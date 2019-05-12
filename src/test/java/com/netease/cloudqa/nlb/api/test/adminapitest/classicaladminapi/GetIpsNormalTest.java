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

public class GetIpsNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "GetIps NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String status, final String groupId, final String limit, final String offest) {
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
                res = CommonApi.getIps(headers, httpClient, status, groupId, limit, offest);
                Assert.assertEquals(res.getCode(), 200, "get ips failed!");
                resJson = JSONObject.parseObject(res.getHtml());
                JSONArray items = resJson.getJSONArray("Items");
                Boolean success = true;
                for (int i = 0; i < items.size(); i++) {
                    JSONObject item = items.getJSONObject(i);
                    if (!item.getString("Status").equals(status) || !item.getString("GroupId").equals(groupId)) {
                        success = false;
                        break;
                    }
                }
                Assert.assertTrue(success, "get ips status or groupId wrong!");
                if (!limit.equals(""))
                    Assert.assertEquals(items.size(), Integer.parseInt(limit), "ip list size != limit");
                logger.info("get ips successfully!");
            }

            @Override
            public void afterTest() {

            }
        });
    }
}
