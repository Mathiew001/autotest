package com.netease.cloudqa.nlb.api.test.adminapitest.classicaladminapi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.TargetGroup;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AddServerNormalTest extends ApiTestBase {
    @Test(dataProvider = "YamlDriverDataProvider", description = "AddServer NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String prepareBody, final String resMsg, final String loadBalanceCaseId,
                        final Boolean isVpc) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray prepareBodyArray  = JSONObject.parseArray(prepareBody);
            JSONArray resMsgJson = JSONObject.parseArray(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                initListenerGroup(loadBalanceCaseId, isVpc);
                lb = resetClassicListener(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res;
                for (int i =  0; i < prepareBodyArray.size(); i++) {
                    JSONObject item = (JSONObject) prepareBodyArray.get(i);
                    item.put("InstanceId", lb.getInstanceId());
                    TargetGroup tg;
                    tg = lb.getTargetGroups().get(i);
                    JSONObject cluster = (JSONObject)item.getJSONArray("Clusters").get(0);
                    cluster.put("TargetGroupId", tg.getTargetGroupId());
                }
                for (int i = 0; i < prepareBodyArray.size(); i++) {
                    res = CommonApi.createLn(headers, prepareBodyArray.getJSONObject(i), httpClient);
                    assertEquals(res.getCode(), 200, "create lb listener status code != 200");
                    logger.info("Create lb listener successfully!");
                }
                resJson = JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                JSONArray listeners = resJson.getJSONArray("Listeners");
                logger.info("Listeners: " + listeners);
//                JsonUtils.responseCheck(resMsgJson, listeners);
//                try {
//                    TimeUnit.SECONDS.sleep(6);
//                } catch (InterruptedException e) {
//                    System.out.println("error");
//                }
//                NetUtils.checkListenerEffective(listeners, lb.getAddress());
//                logger.info("curl vip + port successfully!");
                res = CommonApi.addServer(headers, httpClient, resJson.getString("InstanceId"));
                assertEquals(res.getCode(), 200, "add server failed!");
                resJson = JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                String status = CommonApi.waitCloudServerActive(headers, httpClient, lb.getInstanceId());
                assertEquals(status, "ACTIVE", "CloudServer is not online after add server!");
                logger.info("add server successfully!");
                res = CommonApi.getLbDetailAdmin(headers, httpClient, lb.getInstanceId());
                resJson = JSONObject.parseObject(res.getHtml());
                JSONArray cloudServers = resJson.getJSONArray("CloudServers");
                for (int i = 0; i < cloudServers.size(); i++) {
                    res = CommonApi.delServer(headers, httpClient, lb.getInstanceId(), cloudServers.getJSONObject(i).getString("Id"));
//                try {
//                    TimeUnit.SECONDS.sleep(6);
//                } catch (InterruptedException e) {
//                    System.out.println("error");
//                }
                    assertEquals(res.getCode(), 204, "delete server failed!");
                }
                status = CommonApi.waitCloudServerActive(headers, httpClient, lb.getInstanceId());
                assertEquals(status, "ACTIVE", "CloudServer is not online after auto scale!");
                logger.info("auto scale up successfully!");
            }

            @Override
            public void afterTest() {
                resetClassicListener(loadBalanceCaseId);
            }
        });
    }
}
