/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.model.Request;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: EtcdUtils.java, v 0.1 2017-7-21 下午5:30:00 hzzhangyan Exp $
 */
public class EtcdUtils {

    protected static Logger              logger      = Logger.getLogger(EtcdUtils.class);

    private static String                FILE_PREFIX = "/mynlb/local/";

    private final static HttpClientUtils client      = new HttpClientUtils();

    public static String getValue(String key) {
        Request req = new Request(urlGen(), "GET");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Service", "admin");
        req.setHeaders(headers);
        JSONObject jsObj = new JSONObject();
        jsObj.put("key", key);
        req.setJson(jsObj);
        Response res = client.sendJsonRequest(req);
        logger.info("getValue response [ code:" + res.getCode() + ", msg:" + res.getHtml() + "]");
        return res.getHtml();
    }

    public static void remove(String key) {
        Request req = new Request(urlGen(), "DELETE");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Service", "admin");
        req.setHeaders(headers);
        JSONObject jsObj = new JSONObject();
        jsObj.put("key", key);
        req.setJson(jsObj);
        Response res = client.sendJsonRequest(req);
        logger.info("remove response [ code:" + res.getCode() + ", msg:" + res.getHtml() + "]");
    }

    public static void put(String key, String value) {
        Request req = new Request(urlGen(), "POST");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Service", "admin");
        req.setHeaders(headers);
        JSONObject jsObj = new JSONObject();
        jsObj.put("key", key);
        jsObj.put("value", value);
        req.setJson(jsObj);
        Response res = client.sendJsonRequest(req);
        logger.info("put response [ code:" + res.getCode() + ", msg:" + res.getHtml() + "]");
    }

    public static String keyGen(String setId, String recordName, String prefix) {
        return FILE_PREFIX + ConfigLoader.configration.getEvn() + "/" + setId + "/" + recordName
               + "/" + prefix;
    }

    private static String urlGen() {
        return "http://api.nlb.test.local:5353" + "/admin/v1/etcd";
    }

    public static void main(String[] args) {
        //        put("/mynlb/local/test/record-api-service-name/record-api-service-name/10055",
        //            "{\"host\":\"223.252.220.220\",\"group\":\"95facad13f3745a0\",\"ttl\":1000}");

        //        remove("/mynlb/local/test/record-api-service-name/record-api-service-name");
        //        System.out
        //            .println(getValue("/mynlb/local/cn-east1/put-record-service-name/put-record-service-name/c6ea431a846d4b21"));

        //        System.out.println(getValue("/mynlb/user/c9i5T0BcILga4AwU/.soa"));

        //        System.out.println(getValue("/mynlb/user/NFV0Bu11ccwcOj8u/.ns"));

        //        System.out.println(getValue("/mynlb/config/vpc/10.182.23.165"));
        System.out
            .println(getValue("/mynlb/config/policy/private/pTYScoQ40EAofTKK/.com.hzzhangyan.vpc.simple.test1/A"));

        //        System.out.println(getValue("/mynlb/config/vpc/10.182.22.167"));

        //        getValue("/mynlb/local/test/record-api-service-name/record-api-service-name/10055");record-api-service-name.record-api-service-name.test.local.

    }
}
