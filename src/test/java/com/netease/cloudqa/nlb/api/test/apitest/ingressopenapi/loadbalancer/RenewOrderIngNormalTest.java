package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.NlbModel;
import com.netease.cloudqa.nlb.api.test.utils.CleanMethodInvokerUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import com.netease.cloudqa.nlb.api.test.utils.PrepareMethodInvokerUtils;
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
public class RenewOrderIngNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="RenewOrder NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String period, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                lb = getIngLoadBalanceByCaseId(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res = CommonApi.renewOrderIng(headers, httpClient, lb.getInstanceId(), period);
                assertEquals(res.getCode(), 200, "Reneworder ingress failed!");
                resJson = JSONObject.parseObject(res.getHtml());
                assertTrue(resJson.containsKey("OrderId"));
                logger.info("Reneworder ingress successfully!");
            }

            @Override
            public void afterTest() {
            }
        });
    }
}
