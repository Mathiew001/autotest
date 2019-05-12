package com.netease.cloudqa.nlb.api.test.slighttest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class OldNlbNormalTest extends ApiTestBase {
    @Test(dataProvider = "YamlDriverDataProvider", description = "OldNlb NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String instanceId, final String createTargetGroupBody, final String createListenerBody,
                        final String resMsg) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject createTargetGroupBodyJson  = JSONObject.parseObject(createTargetGroupBody);
            JSONArray createListenerBodyJson = JSONObject.parseArray(createListenerBody);
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = new LoadBalancer();

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
            }

            @Override
            public void executeTest() {
                Response res;
                CommonApi.createTg(headers, createTargetGroupBodyJson, httpClient);
                res = CommonApi.getLbDetail(headers, httpClient, instanceId);
                JSONArray targetGroups = JSONObject.parseObject(res.getHtml()).getJSONArray("TargetGroups");
                String targetGroupId = targetGroups.getJSONObject(0).getString("TargetGroupId");
                for (int i = 0; i < createListenerBodyJson.size(); i++) {
                    JSONObject item = (JSONObject) createListenerBodyJson.get(i);
                    JSONObject cluster = (JSONObject)item.getJSONArray("Clusters").get(0);
                    cluster.put("TargetGroupId", targetGroupId);
                    CommonApi.createLn(headers, createListenerBodyJson.getJSONObject(i), httpClient);
                }
                res = CommonApi.getLbDetail(headers, httpClient, instanceId);
                lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                resJson = JSONObject.parseObject(res.getHtml());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
                for (int i = 0; i < lb.getListeners().size(); i++)
                    CommonApi.deleteLn(headers, httpClient, instanceId, lb.getListeners().get(i).getListenerId());
                for (int i = 0; i < lb.getTargetGroups().size(); i++)
                    CommonApi.deleteTg(headers, httpClient, instanceId, lb.getTargetGroups().get(i).getTargetGroupId());
            }
        });
    }
}
