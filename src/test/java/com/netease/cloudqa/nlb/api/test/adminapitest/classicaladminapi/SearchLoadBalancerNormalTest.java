package com.netease.cloudqa.nlb.api.test.adminapitest.classicaladminapi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SearchLoadBalancerNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "SearchLoadBalancer NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String key, final String value, final String isAccurate) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray resJsonArray = new JSONArray();

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
            }

            @Override
            public void executeTest() {
                Response res = CommonApi.searchLb(headers, httpClient, value);
                Assert.assertEquals(res.getCode(), 200, "search load balancer failed!");
                resJsonArray = JSONObject.parseArray(res.getHtml());
                if (isAccurate.equals("true")) {
                    for (int i = 0; i < resJsonArray.size(); i++) {
                        Assert.assertEquals(resJsonArray.getJSONObject(i).getString(key), value,"search load balancer result wrong!");
                    }
                }
                else {
                    for (int i = 0; i < resJsonArray.size(); i++) {
                        Assert.assertTrue(resJsonArray.getJSONObject(i).getString(key).startsWith(value), "search load balancer result wrong!");
                    }
                }

            }

            @Override
            public void afterTest() {

            }
        });
    }
}
