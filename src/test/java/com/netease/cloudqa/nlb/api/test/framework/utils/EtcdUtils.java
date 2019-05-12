/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.model.Request;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;

/**
 * 
 * @author hzzhangyan
 * @version $Id: EtcdUtils.java, v 0.1 2017-7-21 下午5:30:00 hzzhangyan Exp $
 */
public class EtcdUtils {

    protected static Logger              logger        = Logger.getLogger(EtcdUtils.class);

    private static String                FILE_PREFIX   = "/mynlb/local/";

    private static String                PAAS_PREFIX   = "/mynlb/";

    private static String                USER_PREFIX   = "/mynlb/user/";

    private static String                IP_PREFIX     = "/mynlb/config/vpc/";

    private static String                POLICY_PREFIX = "/mynlb/config/policy/private/";

    private final static HttpClientUtils client        = new HttpClientUtils();

    public static String getValue(String key) {
        Request req = new Request(urlGen(), "GET");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Service", "admin");
        req.setHeaders(headers);
        JSONObject jsObj = new JSONObject();
        jsObj.put("key", key);
        logger.info("get response [ key:" + key + "]");
        req.setJson(jsObj);
        Response res = client.sendJsonRequest(req);
        logger.info("get response [ code:" + res.getCode() + ", msg:" + res.getHtml() + "]");
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
        logger.info("put response [ key:" + key + ", value:" + value + "]");
        req.setJson(jsObj);
        Response res = client.sendJsonRequest(req);
        logger.info("put response [ code:" + res.getCode() + ", msg:" + res.getHtml() + "]");
    }

    public static String keyGen(String setName, String recordName, String prefix) {
        //        return FILE_PREFIX + ConfigLoader.configration.getEvn() + "/" + setName + "/" + recordName
        //               + "/" + prefix;
        return FILE_PREFIX + "cn-east1" + "/" + setName + "/" + recordName + "/" + prefix;
    }

    public static String paasPrefixKeyGen(String fqdn, String recordId) {
        return PAAS_PREFIX + fqdn + "/" + recordId;
    }

    public static String userPrefixRRsetKeyGen(String zoneId, String fqdn, String setId) {
        return USER_PREFIX + zoneId + "/" + fqdn + "/" + setId;
    }

    public static String policyPrefixKeyGen(String zoneId, String name, String type) {
        return POLICY_PREFIX + zoneId + "/" + name + "/" + type;
    }

    public static String userPrefixKeyGen(String subPath) {
        return USER_PREFIX + subPath;
    }

    public static String ipPrefix(String ip) {
        return IP_PREFIX + ip;
    }

    private static String urlGen() {
        return ConfigLoader.configration.getHttpUrl() + "/admin/v1/etcd";
    }

}
