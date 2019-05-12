package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;
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

/**
 *
 * @author chentianyu1
 * @version $Id: UpdateLoadBalancerSpecIngNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class UpdateLoadBalancerSpecIngNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="UpdateLoadBalancerSpec NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String body, final String resMsg, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject updateBodyJson = JSONObject.parseObject(body);
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                lb = getIngLoadBalanceByCaseId(loadBalanceCaseId);
//                if (hasOrderId.equals("True")) {
//                    headers.put("X-Account-Type", "primary");
//                    headers.put("X-ORIGIN-GW", "G0");
//                    headers.put("X-Bill-TenantId", tenantId);
//                    JSONObject orderBodyJson = JSONObject.parseObject(orderBody);
//                    orderBodyJson.put("InstanceId", resJson.getString("InstanceId"));
//                    orderId = CommonApi.createUpOrderAndPay(headers, orderBodyJson, httpClient);
//                    updateBodyJson.getJSONObject("Standard").put("OrderId", orderId);
//                }
            }

            @Override
            public void executeTest() {
                updateBodyJson.put("InstanceId", lb.getInstanceId());
                Response res = CommonApi.updateLbSpecIng(headers, updateBodyJson, httpClient);
                assertEquals(res.getCode(), 204, "update ingress spec failed!");
                res = CommonApi.getLbDetailIng(headers, httpClient, lb.getInstanceId());
                resJson = JSONObject.parseObject(res.getHtml());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
            }
        });
    }
}
