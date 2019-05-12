package com.netease.cloudqa.nlb.api.test.utils;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.netease.cloud.services.nos.Headers;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.utils.FileUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import org.omg.CORBA.UNKNOWN;

/**
 *
 * @author chentianyu1
 * @version $Id: JsonUtils.java, v 0.1 Apr 25, 2018 4:40:38 PM chentianyu1n Exp $
 */
public class JsonUtils extends ApiTestBase {
    public static void jsonToStandard(JSONObject jsonObject) {
        if (jsonObject.get("TopAzInfos") != null) {
            JSONArray topAzInfos = (JSONArray) jsonObject.get("TopAzInfos");
            JSONObject topAzInfo = (JSONObject) topAzInfos.get(0);
            jsonObject.put("TopAz", topAzInfo.get("TopAz"));
            jsonObject.put("SubNetId", topAzInfo.get("SubNetId"));
        }
        if (jsonObject.get("Standard") != null) {
            jsonObject.put("ChargeMode", jsonObject.getJSONObject("Standard").get("ChargeMode"));
            jsonObject.put("ChargeType", jsonObject.getJSONObject("Standard").get("ChargeType"));
            jsonObject.put("BandwidthLimit",
                jsonObject.getJSONObject("Standard").get("BandwidthLimit"));
            jsonObject.put("AutoRenewPeriod",
                jsonObject.getJSONObject("Standard").get("AutoRenewPeriod"));
        }
    }

    public static void checkJsonKey(JSONObject jsonObject, String[] checkResParams) {
        for (String item : checkResParams) {
            assertTrue(jsonObject.containsKey(item));
        }
    }

    public static JSONObject makeLbBody(String name, String description, String network,
                                        String type, String chargeMode, String chargeType,
                                        Integer bandwidthLimit) {
        JSONObject body = new JSONObject();
        body.put("Name", name);
        body.put("Description", description);
        body.put("Network", network);
        body.put("Type", type);
        body.put("Standard", makeLbStandard(chargeMode, chargeType, bandwidthLimit));
        return body;
    }

    public static JSONObject makeLbBody(String name, String description, String network,
                                        String type, String chargeMode, String chargeType,
                                        Integer bandwidthLimit, Integer period,
                                        Integer autoRenewPeriod) {
        JSONObject body = new JSONObject();
        body.put("Name", name);
        body.put("Description", description);
        body.put("Network", network);
        body.put("Type", type);
        body.put("Standard",
            makeLbStandard(chargeMode, chargeType, bandwidthLimit, autoRenewPeriod, period));
        return body;
    }

    public static JSONObject makeLbBody(String name, String description, String network,
                                        String type, String chargeMode, String chargeType,
                                        Integer bandwidthLimit, String vpcId, String topAz,
                                        String subnetId, ArrayList<String> securityGroup) {
        JSONObject body = new JSONObject();
        body.put("Name", name);
        body.put("Description", description);
        body.put("Network", network);
        body.put("Type", type);
        body.put("Standard", makeLbStandard(chargeMode, chargeType, bandwidthLimit));
        body.put("VpcId", vpcId);
        body.put("TopAzInfos", makeLbTopAzInfos(topAz, subnetId));
        body.put("SecurityGroups", makeLbSecurityGroups(securityGroup));
        return body;
    }

    public static JSONObject makeLbBody(String name, String description, String network,
                                        String type, String chargeMode, String chargeType,
                                        Integer bandwidthLimit, Integer period,
                                        Integer autoRenewPeriod, String vpcId, String topAz,
                                        String subnetId, ArrayList<String> securityGroup) {
        JSONObject body = new JSONObject();
        body.put("Name", name);
        body.put("Description", description);
        body.put("Network", network);
        body.put("Type", type);
        body.put("Standard",
            makeLbStandard(chargeMode, chargeType, bandwidthLimit, autoRenewPeriod, period));
        body.put("VpcId", vpcId);
        body.put("TopAzInfos", makeLbTopAzInfos(topAz, subnetId));
        body.put("SecurityGroups", makeLbSecurityGroups(securityGroup));
        return body;
    }

    private static JSONObject makeLbStandard(String chargeMode, String chargeType,
                                             Integer bandwidthLimit, Integer autoRenewPeriod,
                                             Integer period) {
        JSONObject standard = new JSONObject();
        standard.put("ChargeMode", chargeMode);
        standard.put("ChargeType", chargeType);
        standard.put("BandwidthLimit", bandwidthLimit);
        standard.put("AutoRenewPeriod", autoRenewPeriod);
        standard.put("Period", period);
        return standard;
    }

    private static JSONObject makeLbStandard(String chargeMode, String chargeType,
                                             Integer bandwidthLimit) {
        JSONObject standard = new JSONObject();
        standard.put("ChargeMode", chargeMode);
        standard.put("ChargeType", chargeType);
        standard.put("BandwidthLimit", bandwidthLimit);
        return standard;
    }

    private static JSONArray makeLbTopAzInfos(String topAz, String subnetId) {
        JSONArray topAzInfos = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("TopAz", topAz);
        jsonObject.put("SubNetId", subnetId);
        topAzInfos.add(jsonObject);
        return topAzInfos;
    }

    private static JSONArray makeLbSecurityGroups(ArrayList<String> securityGroup) {
        JSONArray securityGroups = new JSONArray();
        securityGroups.addAll(securityGroup);
        return securityGroups;
    }

    public static JSONObject getJsonData(String path) {
        JSONObject jsonObject = new JSONObject();
        try {
            String content = FileUtils.read(path, "utf-8");
            jsonObject = JSONObject.parseObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void responseCheck(JSONObject des, JSONObject src, String caseId) {
        logger.info("resMsg: " + des);
        Map jsonCheckResult = JSONCompareUtils.JSONCompare(des, src, null);
        if (jsonCheckResult.isEmpty()) {
            logger.info("check json response successfully!");
        } else {
            logger.error(jsonCheckResult);
            assertEquals(jsonCheckResult, null, caseId + " check json response failed!");
        }
    }

    public static void responseCheck(JSONArray des, JSONArray src, String caseId) {
        logger.info("resMsg: " + des);
        Map jsonCheckResult = JSONCompareUtils.JSONCompare(des, src, null);
        if (jsonCheckResult.isEmpty()) {
            logger.info("check json response successfully!");
        } else {
            logger.error(jsonCheckResult);
            assertEquals(jsonCheckResult, null, caseId + " check json response failed!");
        }
    }

    /**
     * 
     * @param html
     * @return
     */
    public static String fetchAddr(String createLbRet) {
        JSONObject js = JSONObject.parseObject(createLbRet);
        return js.getString("Address");
    }

    /**
     * 
     * 
     * @param jsonStr
     * @param clazz
     * @return
     */
    public static LoadBalancer fromObjectIgnoreCase(String jsonStr) {
        boolean tmp = TypeUtils.compatibleWithJavaBean;
        TypeUtils.compatibleWithJavaBean = true;
        JSONObject jsObj = JSONObject.parseObject(jsonStr);
        LoadBalancer ret = JSONObject.toJavaObject(jsObj, LoadBalancer.class);
        TypeUtils.compatibleWithJavaBean = tmp;
        return ret;
    }

    public static JSONObject refreshLb(Map<String, String> headers, HttpClientUtils httpClient,
                                         LoadBalancer lb, String loadBalanceCaseId) {

        Response res = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId());
        JSONObject resJson = JSONObject.parseObject(res.getHtml());
        lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
        nlbInstances.put(loadBalanceCaseId, lb);
        return resJson;
    }

    public static JSONObject refreshIng(Map<String, String> headers, HttpClientUtils httpClient,
                                       LoadBalancer lb, String loadBalanceCaseId) {

        Response res = CommonApi.getLbDetailIng(headers, httpClient, lb.getInstanceId());
        JSONObject resJson = JSONObject.parseObject(res.getHtml());
        lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
        ingInstances.put(loadBalanceCaseId, lb);
        return resJson;
    }

//    public static Boolean ishealthCheckCorrect(Map<String, String> headers, HttpClientUtils httpClient,
//                                               String instanceId, String upAddress, String downAddress) {
//        Response res = CommonApi.getLbDetail(headers, httpClient, instanceId);
//        JSONObject lbDetail = JSONObject.parseObject(res.getHtml());
//        JSONArray instances = lbDetail.getJSONArray("TargetGroups").getJSONObject(0).getJSONArray("Instances");
//        String upStatus = getInstanceStatusByAddress(instances, upAddress);
//        String downStatus = getInstanceStatusByAddress(instances, downAddress);
//        while (!upStatus.equals("up") || !downStatus.equals("down")) {
//            res = CommonApi.getLbDetail(headers, httpClient, instanceId);
//            lbDetail = JSONObject.parseObject(res.getHtml());
//            upStatus = getInstanceStatusByAddress(instances, upAddress);
//            downStatus = getInstanceStatusByAddress(instances, downAddress);
//        }
//
//    }

    public static String getInstanceStatusByAddress(JSONArray instances, String address) {
        String status = "UNKNOWN";
        for (int i = 0; i < instances.size(); i++) {
            JSONObject instance = instances.getJSONObject(i);
            if (instance.getString("Address").equals(address)) {
                status = instance.getString("Status");
                break;
            }
        }
        return status;
    }

}
