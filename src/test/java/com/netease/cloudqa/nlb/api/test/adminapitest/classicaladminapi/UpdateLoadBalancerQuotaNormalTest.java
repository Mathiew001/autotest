package com.netease.cloudqa.nlb.api.test.adminapitest.classicaladminapi;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UpdateLoadBalancerQuotaNormalTest extends ApiTestBase {
    @Test(dataProvider = "YamlDriverDataProvider", description = "UpdateLoadBalancerQuota NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId, final String listenerLimit,
                        final String tGroupLimit, final String tGroupInstanceLimit, final String pathLimit,
                        final String domainLimit, final String maxBandwidth, final String loadBalanceCaseId) {
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
                Response res;
                res = CommonApi.updateLbQuota(headers, httpClient, lb.getInstanceId(),
                        listenerLimit, tGroupLimit, tGroupInstanceLimit,
                        pathLimit, domainLimit, maxBandwidth);
                Assert.assertEquals(res.getCode(), 200, "update lb quota failed!");
                res = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId());
                JSONObject limit = JSONObject.parseObject(res.getHtml()).getJSONObject("Limit");
                Assert.assertEquals(limit.getString("ListenerLimit"), listenerLimit, "update lb listenerLimit failed!");
                Assert.assertEquals(limit.getString("TGroupLimit"), tGroupLimit, "update lb tGroupLimit failed!");
                Assert.assertEquals(limit.getString("TGroupInstanceLimit"), tGroupInstanceLimit, "update lb tGroupInstanceLimit failed!");
                Assert.assertEquals(limit.getString("PathLimit"), pathLimit, "update lb pathLimit failed!");
                Assert.assertEquals(limit.getString("DomainLimit"), domainLimit, "update lb domainLimit failed!");
                Assert.assertEquals(limit.getString("MaxBandwidth"), maxBandwidth, "update lb maxBandwidth failed!");
            }

            @Override
            public void afterTest() {

            }
        });
    }
}
