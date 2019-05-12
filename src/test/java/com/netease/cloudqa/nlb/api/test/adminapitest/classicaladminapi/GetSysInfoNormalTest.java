package com.netease.cloudqa.nlb.api.test.adminapitest.classicaladminapi;

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

public class GetSysInfoNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "UpdateConfig NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
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
                res = CommonApi.getSysInfo(headers, httpClient);
                resJson = JSONObject.parseObject(res.getHtml());
                Assert.assertTrue(resJson.containsKey("UserCount"), "sysInfo do not contain key[UserCount]");
                Assert.assertTrue(resJson.containsKey("VipCount"), "sysInfo do not contain key[VipCount]");
                Assert.assertTrue(resJson.containsKey("Vip"), "sysInfo do not contain key[Vip]");
                Assert.assertTrue(resJson.containsKey("IpCount"), "sysInfo do not contain key[IpCount]");
                Assert.assertTrue(resJson.containsKey("Ip"), "sysInfo do not contain key[Ip]");
                Assert.assertTrue(resJson.containsKey("Azs"), "sysInfo do not contain key[Azs]");
            }

            @Override
            public void afterTest() {

            }
        });
    }
}
