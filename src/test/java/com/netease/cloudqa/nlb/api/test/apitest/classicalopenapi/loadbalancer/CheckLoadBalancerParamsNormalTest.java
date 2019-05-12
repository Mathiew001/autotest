package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckLoadBalancerParamsNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="CheckLoadBalancerParams NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String body, final String resMsg) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject bodyJson = JSONObject.parseObject(body);
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
            JSONObject resJson = new JSONObject();

            @Override
            public void beforeTest() {
                headers.put("X-Product-Id", tenantId);
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
            }

            @Override
            public void executeTest() {
                Response res = CommonApi.checkLbParams(headers, bodyJson, httpClient);
                resJson = JSONObject.parseObject(res.getHtml());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
//                Response res = CommonApi.getLbs(headers, httpClient, "", "100", "0");
//                JSONArray list = JSONObject.parseArray(res.getHtml());
//                for (Object obj : list) {
//                    JSONObject item = (JSONObject) obj;
//                    if (item.getString("Name").startsWith("qa-temp"))
//                        CommonApi.deleteLbAdmin(headers, httpClient, item.getString("InstanceId"));
//                }
            }
        });
    }
}
