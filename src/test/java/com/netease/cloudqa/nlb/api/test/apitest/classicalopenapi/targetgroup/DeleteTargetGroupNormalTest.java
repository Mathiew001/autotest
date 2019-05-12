package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.targetgroup;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;

/**
 *
 * @author chentianyu1
 * @version $Id: DeleteTargetGroupNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class DeleteTargetGroupNormalTest extends ApiTestBase {
//    @Test(dataProvider = "YamlDriverDataProvider", description = "DeleteLoadBalancer NormalTest")
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
                Response res = CommonApi.createTg(headers, bodyJson, httpClient);
                resJson = JSONObject.parseObject(res.getHtml());
                assertEquals(res.getCode(), 200, caseId + " create tg status code != 200");
                logger.info("Create target group successfully!");
            }

            @Override
            public void executeTest() {
                Response res = CommonApi.deleteTg(headers, httpClient,
                    resJson.getString("InstanceId"), resJson.getString("TargetGroupId"));
                assertEquals(res.getCode(), 200, caseId + " Delete target group failed!");
                logger.info("Delete target group successfully!");
            }

            @Override
            public void afterTest() {
                resetClassicGroups(loadBalanceCaseId);
            }
        });
    }
}
