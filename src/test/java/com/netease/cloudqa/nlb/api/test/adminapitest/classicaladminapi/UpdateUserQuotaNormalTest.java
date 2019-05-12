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


public class UpdateUserQuotaNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "UpdateUserQuota NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String limit, final String type, final String createBody) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject typeJson = JSONObject.parseObject(type);
            JSONObject createJsonBody = JSONObject.parseObject(createBody);
            String limitOriginal;
            JSONObject resJson = new JSONObject();

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
            }

            @Override
            public void executeTest() {
                Response res;
                res = CommonApi.getUserQuota(headers, httpClient, tenantId, "");
                Assert.assertEquals(res.getCode(), 200, "get user quota failed!");
                limitOriginal = JSONObject.parseObject(res.getHtml()).getString("Limit");
                res = CommonApi.updateUserQuota(headers, httpClient, tenantId, limit);
                Assert.assertEquals(res.getCode(), 200, "update user quota failed!");
                JSONArray typeList = typeJson.getJSONArray("type");
                for (int i = 0; i < typeList.size(); i++) {
                    res = CommonApi.getUserQuota(headers, httpClient, tenantId, typeList.getString(i));
                    Assert.assertEquals(res.getCode(), 200, "get user quota failed!");
                    resJson = JSONObject.parseObject(res.getHtml());
                    Assert.assertEquals(resJson.getString("Limit"), limit, "get user quota limit actual != limit expected");
                }
                res = CommonApi.createLb(headers, createJsonBody, httpClient);
                Assert.assertEquals(res.getCode(), 413, "beyond limit but still create successfully!");
                logger.info("get user quota successfully!");
            }

            @Override
            public void afterTest() {
                Response res = CommonApi.updateUserQuota(headers, httpClient, tenantId, limitOriginal);
                Assert.assertEquals(res.getCode(), 200, "update user quota failed!");
                res = CommonApi.getUserQuota(headers, httpClient, tenantId, "");
                Assert.assertEquals(res.getCode(), 200, "get user quota failed!");
                resJson = JSONObject.parseObject(res.getHtml());
                Assert.assertEquals(resJson.getString("Limit"), limitOriginal, "get user quota limit actual != limit expected");
            }
        });
    }
}
