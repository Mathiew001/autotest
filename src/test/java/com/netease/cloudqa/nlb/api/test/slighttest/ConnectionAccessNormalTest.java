package com.netease.cloudqa.nlb.api.test.slighttest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.ConnectionAccess;
import com.netease.cloudqa.nlb.api.test.utils.CheckListenerAccess;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.LinuxCmd;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ConnectionAccessNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "ConnectionAccess NormalTest")
    public void apiTest(final String caseId, final String description) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            ArrayList<ConnectionAccess> targets = new ArrayList<ConnectionAccess>();
            JSONArray nlbList = new JSONArray();

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                Response res;
                res = CommonApi.getLbsAdmin(headers, httpClient, "public_vpcmix_ordinary", "200", "0");
                int total = JSONObject.parseObject(res.getHtml()).getInteger("Count");
                for (int i = 0; i < total; i+=200) {
                    res = CommonApi.getLbsAdmin(headers, httpClient, "public_vpcmix_ordinary", "200", Integer.toString(i));
                    nlbList.addAll(JSONObject.parseObject(res.getHtml()).getJSONArray("Lists"));
                }

                for (int i = 0; i < nlbList.size(); i++) {
                    JSONObject item = nlbList.getJSONObject(i);
                    if (!item.getString("Status").equals("WORKING"))
                        continue;
                    String instanceId = nlbList.getJSONObject(i).getString("Id");
                    res = CommonApi.getLbDetailAdmin(headers, httpClient, instanceId);
                    JSONArray listeners = JSONObject.parseObject(res.getHtml()).getJSONArray("Listeners");
                    if (listeners.isEmpty())
                        continue;
                    for (int j = 0; j < listeners.size(); j++) {
                        ConnectionAccess target = new ConnectionAccess();
                        target.setInstanceId(instanceId);
                        target.setAddress(nlbList.getJSONObject(i).getString("Address"));
                        target.setPort(listeners.getJSONObject(j).getInteger("ListenPort"));
                        target.setProtocol(listeners.getJSONObject(j).getString("Protocol"));
                        targets.add(target);
                    }
                }
            }

            @Override
            public void executeTest() {
                for (ConnectionAccess target : targets) {
                    CheckListenerAccess checkListenerAccess = new CheckListenerAccess();
                    checkListenerAccess.setTarget(target);
                    Thread thread = new Thread(checkListenerAccess);
                    thread.start();
                }
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("error");
                }
            }

            @Override
            public void afterTest() {

            }
        });
    }
}
