package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 *
 * @author chentianyu1
 * @version $Id: RenewOrderIngNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class RenewOrderNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="RenewOrder NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String period, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
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
                Response res = CommonApi.renewOrder(headers, httpClient, lb.getInstanceId(), period);
                JSONObject resJson = JSONObject.parseObject(res.getHtml());
                assertEquals(res.getCode(), 200, caseId + " renew order failed!");
                assertTrue(resJson.containsKey("OrderId"), caseId);
                logger.info("Renew order successfully!");
            }

            @Override
            public void afterTest() {
            }
        });
    }
}
