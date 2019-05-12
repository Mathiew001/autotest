package com.netease.cloudqa.nlb.api.test.slighttest;

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

public class DeleteProtectionNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "DeleteProtection NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String executeBody, final String resMsg, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject executeBodyJson  = JSONObject.parseObject(executeBody);
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res;
                res = CommonApi.updateLbAttrs(headers, executeBodyJson, httpClient, lb.getInstanceId());
                assertEquals(res.getCode(), 200, caseId + " update Lb Attrs failed!");
                logger.info("update lb protection enabled successfully!");
                res = CommonApi.deleteLb(headers, httpClient, lb.getInstanceId());
                resJson = JSONObject.parseObject(res.getHtml());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
                res = CommonApi.deleteLbAdmin(headers, httpClient, lb.getInstanceId());
                resJson = JSONObject.parseObject(res.getHtml());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
                res = CommonApi.deleteLb1(headers, httpClient, lb.getInstanceId());
                assertEquals(res.getCode(), 403, caseId + " delete protection failed!");
                res = CommonApi.deleteLb2(headers, httpClient, lb.getInstanceId());
                assertEquals(res.getCode(), 403, caseId + " delete protection failed!");
                res = CommonApi.deleteLbAdmin1(headers, httpClient, lb.getInstanceId());
                assertEquals(res.getCode(), 403, caseId + " delete protection failed!");
            }

            @Override
            public void afterTest() {
                executeBodyJson.put("Value", false);
                Response res;
                res = CommonApi.updateLbAttrs(headers, executeBodyJson, httpClient, lb.getInstanceId());
                assertEquals(res.getCode(), 200, caseId + " update Lb Attrs failed!");
                logger.info("update lb protection disabled successfully!");
                res = CommonApi.deleteLb(headers, httpClient, lb.getInstanceId());
                assertEquals(res.getCode(), 200, caseId + " delete lb failed!");
                logger.info("delete lb successfully after disabling delete protection!");
            }
        });
    }
}
