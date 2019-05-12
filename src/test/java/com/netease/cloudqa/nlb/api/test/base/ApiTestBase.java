/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.base;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.github.tomakehurst.wiremock.common.Json;
import com.netease.cloudqa.nlb.api.test.framework.utils.ThreadLocalUtils;
import com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.loadbalancer.CreateLoadBalancerIngNormalPrepare;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.driver.FrameWorkDriver;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseTemplate;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseTemplateImpl;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.Listener;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.TargetGroup;
import com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer.CreateLoadBalancerNormalPrepare;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;

/**
 * 
 * @author chentianyu1
 * @version $Id: ApiTestBase.java, v 0.1 Mar 21, 2018 3:14:26 PM chentianyu1n Exp $
 */
public class ApiTestBase extends FrameWorkDriver {
    protected HttpClientUtils                                                           httpClient       = new HttpClientUtils();

    protected static Map<String /* nlb instance type */, LoadBalancer /* instance */> nlbInstances     = new HashMap<String, LoadBalancer>();

    protected static Map<String /* nlb instance type */, LoadBalancer /* instance */> ingInstances  = new HashMap<String, LoadBalancer>();

    private TestCaseTemplate testCaseTemplate = new TestCaseTemplateImpl();

    /**
     * Getter method for property <tt>testCaseTemplate</tt>.
     * 
     * @return property value of testCaseTemplate
     */
    public TestCaseTemplate getTestCaseTemplate() {
        return testCaseTemplate;
    }

    /**
     * Setter method for property <tt>testCaseTemplate</tt>.
     * 
     * @param testCaseTemplate value to be assigned to property testCaseTemplate
     */
    public void setTestCaseTemplate(TestCaseTemplate testCaseTemplate) {
        this.testCaseTemplate = testCaseTemplate;
    }

    @Override
    @AfterSuite
    protected void clearSuiteUp() {
//        System.out.print("是否清理lb资源(y or n): ");
//        Scanner scan = new Scanner(System.in);
//        String read = scan.nextLine();
//        if (read.equals("yes") || read.equals("y")) {
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("X-Product-Id", ConfigLoader.configration.getExtConfig("tenant_id"));
            HttpClientUtils httpClient = new HttpClientUtils();
            logger.info("============================begin clean load balance============================");
            logger.info("需要清理的负载均衡工单：" + nlbInstances.toString());
            if (!CollectionUtils.isEmpty(nlbInstances)) {
                for (Map.Entry<String, LoadBalancer> entry : nlbInstances.entrySet()) {
                    LoadBalancer nlbInstance = entry.getValue();
                    String instanceId = nlbInstance.getInstanceId();
                    CommonApi.deleteLbAdmin(headers, httpClient, instanceId);
                    String status = CommonApi.waitLbDelete(headers, httpClient, instanceId);
                    if (StringUtils.equals(status, "DELETED")) {
                        logger.info("[" + entry.getKey() + "," + instanceId + "]清理结束...");
                    }
                }
            }
            if (!CollectionUtils.isEmpty(ingInstances)) {
                for (Map.Entry<String, LoadBalancer> entry : ingInstances.entrySet()) {
                    LoadBalancer ingInstance = entry.getValue();
                    String instanceId = ingInstance.getInstanceId();
                    CommonApi.deleteLbIngAdmin(headers, httpClient, instanceId);
                    String status = CommonApi.waitLbDeleteIng(headers, httpClient, instanceId);
                    if (StringUtils.equals(status, "DELETED")) {
                        logger.info("[" + entry.getKey() + "," + instanceId + "]清理结束...");
                    }
                }
            }
//        }
        ThreadLocalUtils.clear();
        logger.info("============================end clean load balance============================");
    }

    protected void addClassicLoadBalance(Map<String, String> header, String caseId, String instanceId) {
        if (null == nlbInstances.get(caseId)) {
            String lbDetail = CommonApi.getLbDetail(header, httpClient, instanceId).getHtml();
            LoadBalancer lb = JsonUtils.fromObjectIgnoreCase(lbDetail);
            nlbInstances.put(caseId, lb);
        }
    }

    protected void addIngress(Map<String, String> header, String caseId, String instanceId) {
        if (null == ingInstances.get(caseId)) {
            String lbDetail = CommonApi.getLbDetailIng(header, httpClient, instanceId).getHtml();
            LoadBalancer lb = JsonUtils.fromObjectIgnoreCase(lbDetail);
            ingInstances.put(caseId, lb);
        }
    }

    protected LoadBalancer getIngLoadBalanceByCaseId(String caseId) {
        if (null != ingInstances.get(caseId)) {
            return ingInstances.get(caseId);
        }
        DataHolder prepareData = null;
        String status = null;
        JSONObject resJson = null;
        try {
            CreateLoadBalancerIngNormalPrepare prepare = new CreateLoadBalancerIngNormalPrepare();
            Method prepareMethod = null;
            prepareMethod = new CreateLoadBalancerIngNormalPrepare().getClass().getMethod(caseId);
            if (null == ConfigLoader.configration) {
                ConfigLoader.loadConfig("local");
            }
            prepareData = (DataHolder) prepareMethod.invoke(prepare);
        } catch (Exception e) {
            Assert.assertEquals(true, false);
            e.printStackTrace();
        }
        Object[] obj = prepareData.getDriverData().getDriverParam();
        //        String caseId; //0
        String tenantId = (String) obj[2]; //2
        String namespace = (String) obj[3]; //3
        String body = (String) obj[4];
        JSONObject bodyJson = (JSONObject) JSONObject.parse(body);

        HttpClientUtils httpClient = new HttpClientUtils();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Namespace", namespace);
        headers.put("X-Product-Id", tenantId);
        Response res = CommonApi.createLbIng(headers, bodyJson, httpClient);
        if (res.getCode() != 200) {
            assertEquals(res.getCode(), 200, "create ing status code != 200" + res.getHtml());
        }
        resJson = JSONObject.parseObject(res.getHtml());
        String lbDetail = CommonApi.waitEndingAndGetIngInfo(headers, httpClient, resJson.getString("InstanceId"));
        status = JSONObject.parseObject(lbDetail).getString("Status");
        assertEquals(status, "WORKING", "create lb failed!" + resJson);
        LoadBalancer lb = JsonUtils.fromObjectIgnoreCase(lbDetail);
        ingInstances.put(caseId, lb);
        return lb;
    }

    protected LoadBalancer getClassicLoadBalanceByCaseId(String caseId) {
        if (null != nlbInstances.get(caseId)) {
            String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("X-Product-Id", tenantId);
            JsonUtils.refreshLb(headers, httpClient, nlbInstances.get(caseId), caseId);
            return nlbInstances.get(caseId);
        }

        DataHolder prepareData = null;
        String status = null;
        JSONObject resJson = null;
        try {
            CreateLoadBalancerNormalPrepare prepare = new CreateLoadBalancerNormalPrepare();
            Method prepareMethod = null;
            prepareMethod = new CreateLoadBalancerNormalPrepare().getClass().getMethod(caseId);

            if (null == ConfigLoader.configration) {
                ConfigLoader.loadConfig("local");
            }
            prepareData = (DataHolder) prepareMethod.invoke(prepare);
        } catch (Exception e) {
            Assert.assertEquals(true, false);
            e.printStackTrace();
        }
        Object[] obj = prepareData.getDriverData().getDriverParam();
        //        String caseId; //0
        String tenantId = (String) obj[2]; //2
        String body = (String) obj[3]; //3
        String hasOrderId = (String) obj[4]; //4
        String orderBody = (String) obj[5]; //5
        JSONObject bodyJson = (JSONObject) JSONObject.parse(body);

        HttpClientUtils httpClient = new HttpClientUtils();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Product-Id", tenantId);
        if (hasOrderId.equals("True")) {
            headers.put("X-Account-Type", "primary");
            headers.put("X-ORIGIN-GW", "G0");
            headers.put("X-Bill-TenantId", tenantId);
            JSONObject orderBodyJson = JSONObject.parseObject(orderBody);
            String orderId = CommonApi.createOrderAndPay(headers, orderBodyJson, httpClient);
            bodyJson.getJSONObject("Standard").put("OrderId", orderId);
        }
        Response res = CommonApi.createLb(headers, bodyJson, httpClient);
        if (res.getCode() != 200) {
            assertEquals(res.getCode(), 200, "create lb status code != 200" + res.getHtml());
        }
        resJson = JSONObject.parseObject(res.getHtml());
        String lbDetail = CommonApi.waitEndingAndGetLbInfo(headers, httpClient,
            resJson.getString("InstanceId"));
        status = JSONObject.parseObject(lbDetail).getString("Status");
        assertEquals(status, "WORKING", "create lb failed!" + resJson);
        LoadBalancer lb = JsonUtils.fromObjectIgnoreCase(lbDetail);
        nlbInstances.put(caseId, lb);
        return lb;
    }

    /**
     * 
     * 
     * @param caseId
     * @return
     */
    protected LoadBalancer resetClassicListener(String caseId) {
        LoadBalancer lb = nlbInstances.get(caseId);
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Product-Id", tenantId);
        if (null == lb) {
            throw new RuntimeException("lb需要先实例化");
        }
        List<Listener> listeners = lb.getListeners();
        if (!CollectionUtils.isEmpty(listeners)) {
            for (Listener listener : listeners) {
                Response res = CommonApi.deleteLn(headers, httpClient, lb.getInstanceId(),
                    listener.getListenerId());
                assertEquals(res.getCode(), 200, "Clean Lb listener failed!");
            }

        }
        String lbDetail = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId()).getHtml();
        lb = JsonUtils.fromObjectIgnoreCase(lbDetail);
        nlbInstances.put(caseId, lb);
        return lb;
    }

    protected LoadBalancer resetIngressListener(String caseId) {
        LoadBalancer lb = ingInstances.get(caseId);
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Product-Id", tenantId);
        if (null == lb) {
            throw new RuntimeException("lb需要先实例化");
        }
        List<Listener> listeners = lb.getListeners();
        if (!CollectionUtils.isEmpty(listeners)) {
            for (Listener listener : listeners) {
                Response res = CommonApi.deleteLnIng(headers, httpClient, lb.getInstanceId(),
                        listener.getName());
                assertEquals(res.getCode(), 204, "Clean Lb listener failed!");
            }
        }
        String lbDetail = CommonApi.getLbDetailIng(headers, httpClient, lb.getInstanceId()).getHtml();
        lb = JsonUtils.fromObjectIgnoreCase(lbDetail);
        ingInstances.put(caseId, lb);
        return lb;
    }

    /**
     * 
     * 
     * @param caseId
     * @return
     */
    protected LoadBalancer resetClassicGroups(String caseId) {
        LoadBalancer lb = nlbInstances.get(caseId);
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Product-Id", tenantId);
        if (null == lb) {
            getClassicLoadBalanceByCaseId(caseId);
        }
        List<TargetGroup> tgs = lb.getTargetGroups();
        while (!CollectionUtils.isEmpty(tgs)) {
            for (TargetGroup tg : tgs) {
                Response res = CommonApi.deleteTg(headers, httpClient, lb.getInstanceId(),
                    tg.getTargetGroupId());
                if (res.getCode() != 200)
                    logger.error("Clean Lb targetGroups failed! res.Code = " + res.getCode());
            }
            String lbDetail = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId()).getHtml();
            lb = JsonUtils.fromObjectIgnoreCase(lbDetail);
            lb.setLisTestModel(false);
            nlbInstances.put(caseId, lb);
            tgs = lb.getTargetGroups();
        }
        return lb;
    }

    /**
     * 
     * 
     * @param caseId
     * @return
     */
    protected LoadBalancer initListenerGroup(String caseId, Boolean isVpc) {
        LoadBalancer lb = nlbInstances.get(caseId);
        if (null == lb) {
            lb = getClassicLoadBalanceByCaseId(caseId);
        }
        if (lb.isLisTestModel()) {
            return lb;
        }
        resetClassicGroups(caseId);
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Product-Id", tenantId);
        String realServer1 = !isVpc ?
                ConfigLoader.configration.getExtConfig("real_server1") : ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = !isVpc ?
                ConfigLoader.configration.getExtConfig("real_server2") : ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = !isVpc ?
                ConfigLoader.configration.getExtConfig("rs_name1") : ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = !isVpc ?
                ConfigLoader.configration.getExtConfig("rs_name2") : ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = !isVpc ?
                ConfigLoader.configration.getExtConfig("rs_address1") : ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = !isVpc ?
                ConfigLoader.configration.getExtConfig("rs_address2") : ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = !isVpc ?
                ConfigLoader.configration.getExtConfig("topaz_mix") : ConfigLoader.configration.getExtConfig("topaz");

        String body1 = "{\"Name\":\"tg-test-01\", " + "\"InstanceId\":\"" + lb.getInstanceId()
                       + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                       + rsName1 + "\", \"Port\":80, " + "\"Address\": \"" + rsAddress1
                       + "\", \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        String body2 = "{\"Name\":\"tg-test-02\", " + "\"InstanceId\":\"" + lb.getInstanceId()
                       + "\", \"Instances\":[{\"Id\":\"" + realServer2 + "\", \"Name\":\""
                       + rsName2 + "\", \"Port\":80, \"Address\":\"" + rsAddress2
                       + "\", \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        String body3 = "{\"Name\":\"tg-test-03\", \"InstanceId\":\""
                       + lb.getInstanceId()
                       + "\", \"Instances\":[{\"Id\":\""
                       + realServer1
                       + "\", \"Name\":\""
                       + rsName1
                       + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                       + "\"Address\": \""
                       + rsAddress1
                       + "\"}, {\"Id\":\""
                       + realServer2
                       + "\", \"Name\":\""
                       + rsName2
                       + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":100, \"Address\":\""
                       + rsAddress2 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "}";
        Response res1 = CommonApi.createTg(headers, JSONObject.parseObject(body1), httpClient);
        assertEquals(res1.getCode(), 200, caseId + " Create tg failed!");
        Response res2 = CommonApi.createTg(headers, JSONObject.parseObject(body2), httpClient);
        assertEquals(res2.getCode(), 200, caseId + " Create tg failed!");
        Response res3 = CommonApi.createTg(headers, JSONObject.parseObject(body3), httpClient);
        assertEquals(res3.getCode(), 200, caseId + " Create tg failed!");
        String lbDetail = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId()).getHtml();
        lb = JsonUtils.fromObjectIgnoreCase(lbDetail);
        lb.setLisTestModel(true);
        nlbInstances.put(caseId, lb);
        return lb;
    }
}
