/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ParallelRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import com.netease.cloudqa.nlb.api.test.utils.NetWorkConnectUtils;

/**
 * 
 * @author chentianyu1
 * @version $Id: CreateLoadBalancerNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class CreateLoadBalancerNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "CreateLoadBalancer NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String body, final String hasOrderId, final String orderBody,
                        final String resMsg, final boolean isDeleted) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils     httpClient = new HttpClientUtils();
            Map<String, String> headers    = new HashMap<String, String>();
            JSONObject          bodyJson   = JSONObject.parseObject(body);
            JSONObject          resMsgJson = JSONObject.parseObject(resMsg);
            JSONObject          resJson    = new JSONObject();
            String              orderId    = "";
            String              ipAddress  = "";
            String              type       = bodyJson.getString("type");

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                if (hasOrderId.equals("True")) {
                    headers.put("X-Account-Type", "primary");
                    headers.put("X-ORIGIN-GW", "G0");
                    headers.put("X-Bill-TenantId", tenantId);
                    JSONObject orderBodyJson = JSONObject.parseObject(orderBody);
                    orderId = CommonApi.createOrderAndPay(headers, orderBodyJson, httpClient);
                    bodyJson.getJSONObject("Standard").put("OrderId", orderId);
                }
            }

            @Override
            public void executeTest() {
                Response res = CommonApi.createLb(headers, bodyJson, httpClient);
                if (res.getCode() != 200) {
                    assertEquals(res.getCode(), 200, caseId + " create lb status code != 200" + res.getHtml());
                } else {
                    resJson = JSONObject.parseObject(res.getHtml());
                    resMsgJson = JSONObject.parseObject(resMsg);
                    String status = CommonApi.waitLb(headers, httpClient, resJson.getString("InstanceId"));
                    assertEquals(status, "WORKING", caseId + " create lb failed!" + resJson);
                    ipAddress = JsonUtils.fetchAddr(res.getHtml());
                    if (StringUtils.equals(type, "vpc_mix") || StringUtils.equals(type, "l4_vpc")) {
                        while (!NetWorkConnectUtils.isHostReachable(ipAddress, 3000)) {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                System.out.println("error");
                            }
                        }
                    }
                    logger.info("Create loadbalancer successfully!");
                    // 放到上下文
                    if (!isDeleted) {
                        addClassicLoadBalance(headers, caseId, resJson.getString("InstanceId"));
                    }
//                    if (!resMsgJson.getString("Type").equals("vpc_l4"))
                    JsonUtils.responseCheck(resMsgJson, resJson, caseId);
                }
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_vip_config",
                        new DataUnit("vipId", String.class.toString(), resJson.getString("InstanceId"), null, FlagConstant.C));
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_cloud_server",
                        new DataUnit("vipId", String.class.toString(), resJson.getString("InstanceId"), null, FlagConstant.C));
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_address",
                        new DataUnit("address", String.class.toString(), resJson.getString("Address"), null, FlagConstant.C));
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_dns_rrset",
                        new DataUnit("vipId", String.class.toString(), resJson.getString("InstanceId"), null, FlagConstant.C));
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_dns_rrset",
                        new DataUnit("fqdn", String.class.toString(), resJson.getString("Fqdn"), null, FlagConstant.Y));
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_top_az",
                        new DataUnit("vipId", String.class.toString(), resJson.getString("InstanceId"), null, FlagConstant.C));
                assertDbCheck(caseId);
            }

            @Override
            public void afterTest() {
                if (isDeleted) {
                    Response res = CommonApi.deleteLb(headers, httpClient, resJson.getString("InstanceId"));
                    assertEquals(res.getCode(), 200, caseId + " Delete lb failed!");
                    CommonApi.waitLbDelete(headers, httpClient, resJson.getString("InstanceId"));
                }
                // 类型为vpc_mix或者l4_vpc类型的ip资源需要回收
                if (StringUtils.equals(type, "vpc_mix") || StringUtils.equals(type, "l4_vpc")) {
                    Assert.assertEquals(false, NetWorkConnectUtils.isHostReachable(ipAddress, 3000));
                }
                logger.info("Delete loadbalancer successfully!");
            }
        });
    }
}
