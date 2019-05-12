package com.netease.cloudqa.nlb.api.test.utils;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.driver.FrameWorkDriver;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.NlbModel;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CleanMethodInvokerUtils extends FrameWorkDriver {

    private static Map<String, Method> methodMap = new HashMap<String, Method>();
    private static NlbModel nlbModel;
    final private static String NLB_MODEL = "NLB_MODEL";

    static {
        try {
            methodMap.put("CleanMethodInvokerUtils.cleanListener",
                    CleanMethodInvokerUtils.class.getMethod("cleanListener", Map.class,
                            HttpClientUtils.class, String.class));
            methodMap.put("CleanMethodInvokerUtils.cleanIngress",
                    CleanMethodInvokerUtils.class.getMethod("cleanIngress", Map.class,
                            HttpClientUtils.class));
            methodMap.put("CleanMethodInvokerUtils.cleanIngressWithWaiting",
                    CleanMethodInvokerUtils.class.getMethod("cleanIngressWithWaiting", Map.class,
                            HttpClientUtils.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public static void invokeMethod(String methodName, Object... args) {
        try {
            nlbModel = (NlbModel) ApiRuntimeContext.CaseContext.getPrameter(NLB_MODEL);
            methodMap.get(methodName).invoke(new CleanMethodInvokerUtils(), args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void cleanListener(Map<String, String> headers, HttpClientUtils httpClient, String instanceId) {
        if (nlbModel != null) {
            Response res = CommonApi.deleteLn(headers, httpClient, instanceId, nlbModel.getListener().getListenerId());
            assertEquals(res.getCode(), 200, "Clean Lb listener failed!");
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }


    public void cleanIngress(Map<String, String> headers, HttpClientUtils httpClient) {
        if (nlbModel != null) {
            Response res = CommonApi.deleteLbIngAdmin(headers, httpClient, nlbModel.getLoadBalancer().getInstanceId());
            assertEquals(res.getCode(), 200, "Clean ing failed!");
            JSONObject resJson = JSONObject.parseObject(res.getHtml());
            String status = CommonApi.waitLbDeleteIng(headers, httpClient, resJson.getString("InstanceId"));
            assertEquals(status, "DELETED", "Delete ing failed!");
            logger.info("Clean ingress successfully!");
        }
    }

    public void cleanIngressWithWaiting(Map<String, String> headers, HttpClientUtils httpClient) {
        if (nlbModel != null) {
            String status = CommonApi.waitIng(headers, httpClient, nlbModel.getLoadBalancer().getInstanceId());
            assertEquals(status, "WORKING", "Ingress status is not WORKING!");
            Response res = CommonApi.deleteLbIngAdmin(headers, httpClient, nlbModel.getLoadBalancer().getInstanceId());
            assertEquals(res.getCode(), 200, "Clean ing failed!");
            logger.info("Clean data successfully!");
        }
    }
}
