package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.targetgroup;

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

/**
 *
 * @author chentianyu1
 * @version $Id: DeleteTargetGroupNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class UpdateTGInstanceAbnormalTest extends ApiTestBase {
    //    @Test(dataProvider = "YamlDriverDataProvider", description = "DeleteLoadBalancer NormalTest")
    @Test(dataProvider = "YamlDriverDataProvider", description = "UpdateTargetGroup Instance AbnormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String createBody, final String updateBody, final String resMsg,
                        final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils     httpClient     = new HttpClientUtils();
            Map<String, String> headers        = new HashMap<String, String>();
            JSONObject          createBodyJson = JSONObject.parseObject(createBody);
            JSONObject          updateBodyJson = JSONObject.parseObject(updateBody);
            JSONObject          resJson        = new JSONObject();
            JSONObject          resMsgJson     = JSONObject.parseObject(resMsg);
            String              tgId           = "";
            LoadBalancer        lb             = null;

            @Override
            public void beforeTest() {
                headers.put("X-Product-Id", tenantId);
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                resetClassicGroups(loadBalanceCaseId);
                createBodyJson.put("InstanceId", lb.getInstanceId());
                updateBodyJson.put("InstanceId", lb.getInstanceId());
                Response res = CommonApi.createTg(headers, createBodyJson, httpClient);
                assertEquals(res.getCode(), 200, "Create tg failed!");
                tgId = JSONObject.parseObject(res.getHtml()).getString("TargetGroupId");
            }

            @Override
            public void executeTest() {
                updateBodyJson.put("TargetGroupId", tgId);
                Response res = CommonApi.updateTgInstance(headers, updateBodyJson, httpClient);
                assertEquals(res.getCode(), 400, caseId);
                resJson = JSONObject.parseObject(res.getHtml());
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
