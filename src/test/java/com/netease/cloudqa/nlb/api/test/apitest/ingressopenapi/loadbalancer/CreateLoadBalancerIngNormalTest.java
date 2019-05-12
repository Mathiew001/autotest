/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;
import com.netease.cloudqa.nlb.api.test.model.NlbModel;
import com.netease.cloudqa.nlb.api.test.utils.CleanMethodInvokerUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import com.netease.cloudqa.nlb.api.test.utils.PrepareMethodInvokerUtils;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * 
 * @author chentianyu1
 * @version $Id: CreateLoadBalancerIngNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class CreateLoadBalancerIngNormalTest extends ApiTestBase {
    
    @Test(dataProvider="YamlDriverDataProvider", description="CreateLoadBalancer NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String namespace, final String body, final String hasOrderId,
                        final String orderBody, final String resMsg, final boolean isDeleted) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {
            
            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject createBodyJson = (JSONObject) JSONObject.parse(body);
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
            JSONObject resJson = new JSONObject();
            String orderId = "";

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                headers.put("Namespace", namespace);
                if (hasOrderId.equals("True")) {
                    headers.put("X-Account-Type", "primary");
                    headers.put("X-ORIGIN-GW", "G0");
                    headers.put("X-Bill-TenantId", tenantId);
                    JSONObject orderBodyJson = JSONObject.parseObject(orderBody);
                    orderId = CommonApi.createOrderAndPay(headers, orderBodyJson, httpClient);
                    createBodyJson.getJSONObject("Standard").put("OrderId", orderId);
                }

            }

            @Override
            public void executeTest() {
                Response res = CommonApi.createLbIng(headers, createBodyJson, httpClient);
                assertEquals(res.getCode(), 200, "create ing status code != 200");
                resJson = JSONObject.parseObject(res.getHtml());
                String status = CommonApi.waitIng(headers, httpClient, resJson.getString("InstanceId"));
                assertEquals(status, "WORKING", "create ingress failed!");
                logger.info("Create ingress successfully!");
                if (!isDeleted) {
                    addIngress(headers, caseId, resJson.getString("InstanceId"));
                }
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
                headers.remove("Namespace");
                if (isDeleted) {
                    Response res = CommonApi.deleteLbIng(headers, httpClient, resJson.getString("InstanceId"));
                    assertEquals(res.getCode(), 200, "Delete lb failed!");
                    CommonApi.waitLbDeleteIng(headers, httpClient, resJson.getString("InstanceId"));
                    logger.info("Delete ingress successfully!");
                }
            }
        });
    }
}
