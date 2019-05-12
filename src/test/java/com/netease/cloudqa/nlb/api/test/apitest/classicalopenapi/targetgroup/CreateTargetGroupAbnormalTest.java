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

/**
 *
 * @author chentianyu1
 * @version $Id: CreateTargetGroupAbnormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class CreateTargetGroupAbnormalTest extends ApiTestBase {
    @Test(dataProvider = "YamlDriverDataProvider", description = "CreateTargetGroup AbnormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String body, final String resMsg, final String loadBalanceCaseId) {
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
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                bodyJson.put("InstanceId", lb.getInstanceId());
                resetClassicGroups(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res = CommonApi.createTg(headers, bodyJson, httpClient);
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