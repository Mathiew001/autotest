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

import java.util.*;

public class GetLoadBalancerCountsNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "GetLoadBalancerCounts NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String type) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject typeJson = JSONObject.parseObject(type);
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
                JSONArray typeList = typeJson.getJSONArray("type");
                int count = 0;
                for (int i = 0; i < typeList.size(); i++) {
                    String t = typeList.getString(i);
                    res = CommonApi.getLbCounts(headers, httpClient, t);
                    Assert.assertEquals(res.getCode(), 200, "Get " + t + " lb counts failed!");
                    logger.info("Get " + t + " lb counts successfully!");
                    int eachCount = JSONObject.parseObject(res.getHtml()).getInteger("Count");
                    count += eachCount;
                }
                res = CommonApi.getLbsAdmin(headers, httpClient, "", "200", "");
                Assert.assertEquals(res.getCode(), 200, "Get lbs failed!");
                JSONArray lbList = JSONObject.parseObject(res.getHtml()).getJSONArray("Lists");
                int total = JSONObject.parseObject(res.getHtml()).getInteger("Count");
                int offset = 0;
                for (int i = 0; i < Math.ceil((double) total/200); i++) {
                    offset = offset + 200;
                    res = CommonApi.getLbsAdmin(headers, httpClient, "", "200", Integer.toString(offset));
                    Assert.assertEquals(res.getCode(), 200, "Get lbs failed!");
                    lbList.addAll(JSONObject.parseObject(res.getHtml()).getJSONArray("Lists"));
                }
                logger.info("Get lbs successfully!");
                List<JSONObject> list = new ArrayList<JSONObject>();
                for (int i = 0; i < lbList.size(); i++) {
                    if (lbList.getJSONObject(i).getString("Type").equals("vpc_l4"))
                        list.add(lbList.getJSONObject(i));
                }
                Assert.assertEquals(lbList.size()-list.size(), count, "Get lbs size != sum of get lb counts");
            }

            @Override
            public void afterTest() {

            }
        });
    }
}
