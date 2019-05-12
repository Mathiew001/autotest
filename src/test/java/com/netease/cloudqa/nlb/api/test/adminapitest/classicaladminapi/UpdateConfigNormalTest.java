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

public class UpdateConfigNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "UpdateConfig NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray resJson = new JSONArray();

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
                res = CommonApi.updateConfig(headers, httpClient, "autoScaleUpSwitch", "\"OFF\"");
                Assert.assertEquals(res.getCode(), 200, "update sys config failed!");
                res = CommonApi.getSysConfig(headers, httpClient);
                resJson = JSONObject.parseArray(res.getHtml());
                Boolean success = false;
                for (int i = 0; i < resJson.size(); i++) {
                    JSONObject object = resJson.getJSONObject(i);
                    if (object.getString("Attr").equals("autoScaleUpSwitch") && object.getString("Value").equals("OFF")) {
                        success = true;
                        break;
                    }
                }
                Assert.assertTrue(success, "update sys config failed!");
                res = CommonApi.updateConfig(headers, httpClient, "autoScaleUpSwitch", "\"ON\"");
                Assert.assertEquals(res.getCode(), 200, "update sys config failed!");
                res = CommonApi.getSysConfig(headers, httpClient);
                resJson = JSONObject.parseArray(res.getHtml());
                success = false;
                for (int i = 0; i < resJson.size(); i++) {
                    JSONObject object = resJson.getJSONObject(i);
                    if (object.getString("Attr").equals("autoScaleUpSwitch") && object.getString("Value").equals("ON")) {
                        success = true;
                        break;
                    }
                }
                Assert.assertTrue(success, "update sys config failed!");

            }

            @Override
            public void afterTest() {

            }
        });
    }
}
