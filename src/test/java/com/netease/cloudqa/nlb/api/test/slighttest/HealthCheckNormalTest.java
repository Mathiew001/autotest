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

import static org.testng.Assert.assertEquals;

public class HealthCheckNormalTest extends ApiTestBase {
    @Test(dataProvider = "YamlDriverDataProvider", description = "DeleteProtection NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String createTgBody, final String createLnBody, final String updateBody,
                        final String resMsg, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject createTgBodyJson  = JSONObject.parseObject(createTgBody);
            JSONObject createLnBodyJson  = JSONObject.parseObject(createLnBody);
            JSONArray updateBodyJson  = JSONObject.parseArray(updateBody);
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                resetClassicGroups(loadBalanceCaseId);
                resetClassicListener(loadBalanceCaseId);
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res;
                res = CommonApi.createTg(headers, createTgBodyJson, httpClient);
                assertEquals(res.getCode(), 200, "create nlb target group failed!");
                createLnBodyJson.put("TargetGroupId", JSONObject.parseObject(res.getHtml()).getString("TargetGroupId"));
                res = CommonApi.createLn(headers, createLnBodyJson, httpClient);
                assertEquals(res.getCode(), 200, "create nlb listener failed!");
                res = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId());
                lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                nlbInstances.put(caseId, lb);
                

            }

            @Override
            public void afterTest() {

            }
        });
    }
}
