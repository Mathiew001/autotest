package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.targetgroup;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;

public class UpdateTargetGroupAbnormalTest extends ApiTestBase {
    @Test(dataProvider = "YamlDriverDataProvider", description = "UpdateTargetGroup AbnormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String body, final String resMsg, final String loadBalanceCaseId,
                        final Boolean isVpc) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {
            HttpClientUtils     httpClient = new HttpClientUtils();
            Map<String, String> headers    = new HashMap<String, String>();
            JSONObject          bodyJson   = (JSONObject) JSONObject.parse(body);
            JSONObject          resMsgJson = (JSONObject) JSONObject.parse(resMsg);
            JSONObject          resJson    = new JSONObject();
            LoadBalancer        lb         = null;

            @Override
            public void beforeTest() {
                headers.put("X-Product-Id", tenantId);
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                resetClassicGroups(loadBalanceCaseId);
                lb = initListenerGroup(loadBalanceCaseId, isVpc);
            }

            @Override
            public void executeTest() {
                if (!bodyJson.containsKey("InstanceId"))
                    bodyJson.put("InstanceId", lb.getInstanceId());
                if (!bodyJson.containsKey("TargetGroupId"))
                    bodyJson.put("TargetGroupId", lb.getTargetGroups().get(2).getTargetGroupId());
                Response res = CommonApi.updateTg(headers, bodyJson, httpClient);
                resJson = JSONObject.parseObject(res.getHtml());
                resMsgJson = JSONObject.parseObject(resMsg);
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
                JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                resetClassicGroups(loadBalanceCaseId);
            }
        });
    }
}
