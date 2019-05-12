/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.loadbalancer;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * 
 * @author chentianyu1
 * @version $Id: GetLoadBalancersIngNormalTest.java, v 0.1 Apr 25, 2018 10:17:48 AM chentianyu1 Exp $
 */
public class GetLoadBalancersIngNormalTest extends ApiTestBase {
    @Test(dataProvider="YamlDriverDataProvider", description="GetLoadBalancersIng NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String limit, final String offset) {
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
                Response res = CommonApi.getLbsIng(headers, httpClient, limit, offset);
                resJson = JSONArray.parseArray(res.getHtml());
                assertTrue(resJson.size() != 0, "ingress list is empty!");
                if (!"".equals(limit))
                    assertEquals(resJson.size(), Integer.parseInt(limit), "lb list length != limit in params");
            }
            
            @Override
            public void afterTest() {
            }
        });
    }
}
