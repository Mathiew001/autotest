package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer;


import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 *
 * @author chentianyu1
 * @version $Id: GetLoadBalancersNormalTest.java, v 0.1 Apr 25, 2018 10:17:48 AM chentianyu1 Exp $
 */
public class GetLoadBalancersAbnormalTest extends ApiTestBase {
    @Test(dataProvider="YamlDriverDataProvider", description="GetLoadBalancers NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String type, final String limit, final String offset, final String resMsg) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject resMsgJson = (JSONObject) JSONObject.parse(resMsg);
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
                Response res = CommonApi.getLbs(headers, httpClient, type, limit, offset);
                resJson = JSONObject.parseObject(res.getHtml());
                resMsgJson = JSONObject.parseObject(resMsg);
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {

            }
        });
    }
}