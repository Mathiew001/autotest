/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer;


import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import org.testng.annotations.Test;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;

/**
 * 
 * @author chentianyu1
 * @version $Id: GetLoadBalancersNormalTest.java, v 0.1 Apr 25, 2018 10:17:48 AM chentianyu1 Exp $
 */
public class GetLoadBalancersNormalTest extends ApiTestBase {
    @Test(dataProvider="YamlDriverDataProvider", description="GetLoadBalancers NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String type, final String limit, final String offset, final String resMsg) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject resMsgJson = (JSONObject) JSONObject.parse(resMsg);
            JSONArray resJson = new JSONArray();

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
                resJson = JSONArray.parseArray(res.getHtml());
                if (resJson.size() == 0)
                    logger.warn("lb list in return is empty! " + "Type is " + type);
                else {
                    if (!"".equals(limit) && "".equals(offset))
                        assertEquals(resJson.size(), Integer.parseInt(limit), caseId + " lb list length != limit in params");
                    if (!"".equals(offset))
                        assertEquals(resJson.size(), Integer.parseInt(limit), caseId + " lb list offset failed!");
                    for (int i = 0; i < resJson.size(); i++) {
                        JSONObject item = (JSONObject) resJson.get(i);
                        assertEquals(item.getString("Type"), resMsgJson.getString("Type"), caseId + " type in return != type in params");
                        logger.info("check each type successfully!");
                    }
                }
            }
            
            @Override
            public void afterTest() {
            }
        });
    }
}
