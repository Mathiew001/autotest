package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 *
 * @author chentianyu1
 * @version $Id: DeleteLoadBalancerIngNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class DeleteLoadBalancerNormalTest extends ApiTestBase {
//    @Test(dataProvider="YamlDriverDataProvider", description="DeleteLoadBalancer NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String body, final String resMsg) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject bodyJson = JSONObject.parseObject(body);
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
            JSONObject resJson = new JSONObject();


            @Override
            public void beforeTest() {
                headers.put("X-Product-Id", tenantId);
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                Response res = CommonApi.createLb(headers, bodyJson, httpClient);
                assertEquals(res.getCode(), 200, caseId + " create lb status code != 200");
                resJson = JSONObject.parseObject(res.getHtml());
                resMsgJson = JSONObject.parseObject(resMsg);
                String status = CommonApi.waitLb(headers, httpClient, resJson.getString("InstanceId"));
                assertEquals(status, "WORKING", caseId + " create lb failed!");
                logger.info("Create loadbalancer successfully!");

            }

            @Override
            public void executeTest() {
                Response res = CommonApi.deleteLb(headers, httpClient, resJson.getString("InstanceId"));
                assertEquals(res.getCode(), 200, caseId + " Delete lb status code != 200");
                logger.info("Delete loadbalancer successfully! Try to find it again!");
                String status = CommonApi.waitLbDelete(headers, httpClient, resJson.getString("InstanceId"));
                assertEquals(status, "DELETED", caseId + " Delete loadbalancer failed!");
                logger.info("Cannot find lb anymore!");
            }

            @Override
            public void afterTest() {

            }
        });
    }

}
