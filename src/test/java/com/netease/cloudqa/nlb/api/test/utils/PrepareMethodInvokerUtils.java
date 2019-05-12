/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.utils;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.driver.FrameWorkDriver;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.Listener;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.NlbModel;
import com.netease.cloudqa.nlb.api.test.model.Order;

/**
 *
 * @author hzzhangyan
 * @version $Id: PrepareMethodInvokerUtils.java, v 0.1 2018-5-16 下午1:04:43 hzzhangyan Exp $
 */
public class PrepareMethodInvokerUtils extends FrameWorkDriver {

    private static Map<String, Method> methodMap = new HashMap<String, Method>();
    final private static String        NLB_MODEL = "NLB_MODEL";

    static {
        try {
            methodMap.put("PrepareMethodInvokerUtils.prepareListener",
                PrepareMethodInvokerUtils.class.getMethod("prepareListener", Map.class,
                    HttpClientUtils.class, String.class));
            methodMap.put("PrepareMethodInvokerUtils.prepareListenerIng",
                PrepareMethodInvokerUtils.class.getMethod("prepareListenerIng", Map.class,
                    HttpClientUtils.class, String.class));
            methodMap.put("PrepareMethodInvokerUtils.prepareIngress",
                PrepareMethodInvokerUtils.class.getMethod("prepareIngress", Map.class,
                    HttpClientUtils.class, String.class));
            methodMap.put("PrepareMethodInvokerUtils.prepareIngressAndOrder",
                PrepareMethodInvokerUtils.class.getMethod("prepareIngressAndOrder", Map.class,
                    HttpClientUtils.class, String.class, String.class));
            methodMap.put("PrepareMethodInvokerUtils.prepareIngressAndUpdateOrder",
                PrepareMethodInvokerUtils.class.getMethod("prepareIngressAndUpdateOrder",
                    Map.class, HttpClientUtils.class, String.class, String.class));
            methodMap.put("PrepareMethodInvokerUtils.prepareIngressWithoutWaiting",
                PrepareMethodInvokerUtils.class.getMethod("prepareIngressWithoutWaiting",
                    Map.class, HttpClientUtils.class, String.class));
            methodMap.put("PrepareMethodInvokerUtils.prepareCreateOrder",
                PrepareMethodInvokerUtils.class.getMethod("prepareCreateOrder", Map.class,
                    HttpClientUtils.class, String.class, String.class));
            methodMap.put("PrepareMethodInvokerUtils.prepareIngressAndListener",
                PrepareMethodInvokerUtils.class.getMethod("prepareIngressAndListener", Map.class,
                    HttpClientUtils.class, String.class));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public static void invokeMethod(String methodName, Object... args) {
        try {
            NlbModel nlbModel = (NlbModel) methodMap.get(methodName).invoke(
                new PrepareMethodInvokerUtils(), args);
            DataUnit unit = new DataUnit(NLB_MODEL, nlbModel);
            ApiRuntimeContext.CaseContext.addPrameter(unit);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public NlbModel prepareListener(Map<String, String> headers, HttpClientUtils httpClient,
                                    String prepareBody) {
        JSONObject jsonBody = JSONObject.parseObject(prepareBody);
        Response res = CommonApi.createLn(headers, jsonBody, httpClient);
        assertEquals(res.getCode(), 200, "Prepare Lb listener failed!");
        logger.info("Prepare data successfully!");
        Response res1 = CommonApi
            .getLbDetail(headers, httpClient, jsonBody.getString("InstanceId"));

        NlbModel nlbModel = new NlbModel();
        JSONObject listener = CommonApi.findListenerByName(JSONObject.parseObject(res1.getHtml()),
            "testln1");
        nlbModel.setListener(new Listener(listener.getString("ListenerId")));
        return nlbModel;
    }

    public NlbModel prepareListenerIng(Map<String, String> headers, HttpClientUtils httpClient,
                                       String prepareBody) {
        JSONObject jsonBody = JSONObject.parseObject(prepareBody);
        Response res = CommonApi.createLnIng(headers, jsonBody, httpClient);
        assertEquals(res.getCode(), 204, "Prepare ing listener failed!");
        logger.info("Prepare data successfully!");
        NlbModel nlbModel = new NlbModel();
        nlbModel.setListener(new Listener(jsonBody.getString("Name")));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return nlbModel;
    }

    public NlbModel prepareIngressAndListener(Map<String, String> headers,
                                              HttpClientUtils httpClient, String prepareBody) {
        JSONObject jsonBody = JSONObject.parseObject(prepareBody);
        JSONObject createBody = jsonBody.getJSONObject("CreateBody");
        JSONObject listenerBody = jsonBody.getJSONObject("ListenerBody");
        Response res = CommonApi.createLbIng(headers, createBody, httpClient);
        JSONObject resJson = JSONObject.parseObject(res.getHtml());
        assertEquals(res.getCode(), 200, "Prepare ingress failed!");
        String instanceId = resJson.getString("InstanceId");
        listenerBody.put("InstanceId", instanceId);
        String status = CommonApi.waitIng(headers, httpClient, instanceId);
        assertEquals(status, "WORKING", "create ingress failed!");
        res = CommonApi.createLnIng(headers, listenerBody, httpClient);
        assertEquals(res.getCode(), 204, "Prepare listener failed!");
        NlbModel nlbModel = new NlbModel();
        nlbModel.setLoadBalancer(new LoadBalancer(instanceId));
        return nlbModel;
    }

    public NlbModel prepareIngress(Map<String, String> headers, HttpClientUtils httpClient,
                                   String prepareBody) {
        JSONObject jsonBody = JSONObject.parseObject(prepareBody);
        Response res = CommonApi.createLbIng(headers, jsonBody, httpClient);
        JSONObject resJson = JSONObject.parseObject(res.getHtml());
        assertEquals(res.getCode(), 200, "Prepare ingress failed!");
        String instanceId = resJson.getString("InstanceId");
        String status = CommonApi.waitIng(headers, httpClient, instanceId);
        assertEquals(status, "WORKING", "create ingress failed!");
        NlbModel nlbModel = new NlbModel();
        nlbModel.setLoadBalancer(new LoadBalancer(instanceId));
        return nlbModel;
    }

    public NlbModel prepareIngressWithoutWaiting(Map<String, String> headers,
                                                 HttpClientUtils httpClient, String prepareBody) {
        JSONObject jsonBody = JSONObject.parseObject(prepareBody);
        Response res = CommonApi.createLbIng(headers, jsonBody, httpClient);
        JSONObject resJson = JSONObject.parseObject(res.getHtml());
        assertEquals(res.getCode(), 200, "Prepare ingress failed!");
        String instanceId = resJson.getString("InstanceId");
        NlbModel nlbModel = new NlbModel();
        nlbModel.setLoadBalancer(new LoadBalancer(instanceId));
        return nlbModel;
    }

    public NlbModel prepareCreateOrder(Map<String, String> headers, HttpClientUtils httpClient,
                                       String prepareBody, String tenantId) {
        headers.put("X-Account-Type", "primary");
        headers.put("X-ORIGIN-GW", "G0");
        headers.put("X-Bill-TenantId", tenantId);
        JSONObject orderBodyJson = JSONObject.parseObject(prepareBody);
        String orderId = CommonApi.createOrderAndPay(headers, orderBodyJson, httpClient);
        NlbModel nlbModel = new NlbModel();
        nlbModel.setOrder(new Order(orderId));
        return nlbModel;
    }

    public NlbModel prepareUpdateOrder(Map<String, String> headers, HttpClientUtils httpClient,
                                       String prepareBody, String tenantId) {
        headers.put("X-Account-Type", "primary");
        headers.put("X-ORIGIN-GW", "G0");
        headers.put("X-Bill-TenantId", tenantId);
        JSONObject orderBodyJson = JSONObject.parseObject(prepareBody);
        String orderId = CommonApi.createUpOrderAndPay(headers, orderBodyJson, httpClient);
        NlbModel nlbModel = new NlbModel();
        nlbModel.setOrder(new Order(orderId));
        return nlbModel;
    }

    public NlbModel prepareIngressAndOrder(Map<String, String> headers, HttpClientUtils httpClient,
                                           String prepareBody, String tenantId) {
        JSONObject jsonBody = JSONObject.parseObject(prepareBody);
        JSONObject createBody = jsonBody.getJSONObject("CreateBody");
        NlbModel nlbModel = new NlbModel();
        if (jsonBody.containsKey("OrderBody")) {
            JSONObject orderBody = jsonBody.getJSONObject("OrderBody");
            nlbModel = prepareCreateOrder(headers, httpClient, orderBody.toJSONString(), tenantId);
        }
        Response res = CommonApi.createLbIng(headers, createBody, httpClient);
        JSONObject resJson = JSONObject.parseObject(res.getHtml());
        assertEquals(res.getCode(), 200, "Prepare ingress failed!");
        String instanceId = resJson.getString("InstanceId");
        String status = CommonApi.waitIng(headers, httpClient, instanceId);
        assertEquals(status, "WORKING", "create ingress failed!");
        nlbModel.setLoadBalancer(new LoadBalancer(instanceId));
        return nlbModel;
    }

    public NlbModel prepareIngressAndUpdateOrder(Map<String, String> headers,
                                                 HttpClientUtils httpClient, String prepareBody,
                                                 String tenantId) {
        JSONObject jsonBody = JSONObject.parseObject(prepareBody);
        JSONObject createBody = jsonBody.getJSONObject("CreateBody");
        Response res = CommonApi.createLbIng(headers, createBody, httpClient);
        JSONObject resJson = JSONObject.parseObject(res.getHtml());
        assertEquals(res.getCode(), 200, "Prepare ingress failed!");
        String instanceId = resJson.getString("InstanceId");
        String status = CommonApi.waitIng(headers, httpClient, instanceId);
        assertEquals(status, "WORKING", "create ingress failed!");
        NlbModel nlbModel = new NlbModel();
        if (jsonBody.containsKey("OrderBody")) {
            JSONObject orderBody = jsonBody.getJSONObject("OrderBody");
            orderBody.put("InstanceId", instanceId);
            nlbModel = prepareUpdateOrder(headers, httpClient, orderBody.toJSONString(), tenantId);
        }
        nlbModel.setLoadBalancer(new LoadBalancer(instanceId));
        return nlbModel;
    }

}
