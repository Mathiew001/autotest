package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.listener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.apache.log4j.NDC;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class UpdateLbListenerAbnormalTest extends ApiTestBase {
    @Test(dataProvider="YamlDriverDataProvider", description="UpdateLbListener AbnormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String executeBody, final String resMsg, final String loadBalanceCaseId,
                        final Boolean isVpc) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray executeBodyArray  = JSONObject.parseArray(executeBody);
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
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
                JSONObject updateJson;
                JSONObject prepareJson;
                Response res;
                if (executeBodyArray.size() == 2) {
                    prepareJson = executeBodyArray.getJSONObject(0);
                    if (!prepareJson.containsKey("InstanceId"))
                        prepareJson.put("InstanceId", lb.getInstanceId());
                    prepareJson.getJSONArray("Clusters").getJSONObject(0).put("TargetGroupId",
                            lb.getTargetGroups().get(0).getTargetGroupId());
                    res = CommonApi.createLn(headers, prepareJson, httpClient);
                    assertEquals(res.getCode(), 200, caseId + " create lb listener status code != 200");
                    logger.info("Create lb listener successfully!");
                    res = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId());
                    lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                    nlbInstances.put(loadBalanceCaseId, lb);
                    updateJson = executeBodyArray.getJSONObject(1);
                    updateJson.put("ListenerId", lb.getListeners().get(0).getListenerId());
                }
                else
                    updateJson = executeBodyArray.getJSONObject(0);
                if (!updateJson.containsKey("InstanceId"))
                    updateJson.put("InstanceId", lb.getInstanceId());
                if (!updateJson.containsKey("ListenerId"))
                    updateJson.put("ListenerId", lb.getListeners().get(0).getListenerId());
                if (!updateJson.getJSONArray("Clusters").getJSONObject(0).containsKey("TargetGroupId"))
                    updateJson.getJSONArray("Clusters").getJSONObject(0).put("TargetGroupId", lb.getTargetGroups().get(1).getTargetGroupId());
                res = CommonApi.updateLn(headers,  updateJson, httpClient);
                resJson = JSONObject.parseObject(res.getHtml());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
                resetClassicListener(loadBalanceCaseId);
            }
        });
    }
}
