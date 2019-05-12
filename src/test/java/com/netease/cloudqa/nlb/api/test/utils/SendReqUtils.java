/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.utils;

import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.driver.FrameWorkDriver;
import com.netease.cloudqa.nlb.api.test.framework.model.Request;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import meta.CommonData;
import org.apache.commons.lang.StringUtils;

import javax.net.ssl.*;

import static meta.CommonData.genHeaderMap;

/**
 * 
 * @author chentianyu1
 * @version $Id: SendReqUtils.java, v 0.1 Mar 22, 2018 9:34:36 AM chentianyu1n Exp $
 */
public class SendReqUtils extends FrameWorkDriver {

    public final static String POST = "POST";
    public final static String GET = "GET";
    public final static String DEL = "DELETE";
    public final static String PUT = "PUT";
    protected static String httpLine = ConfigLoader.configration.getHttpLine();
    
    public static Response sendReq(String url, Map<String, String> headers, HttpClientUtils httpClient,
                                   String httpMethod, String methodName) {
        Request req = new Request(url, httpMethod);
        req.setHeaders(headers);
        Response res = new Response();
        if (StringUtils.equals(httpLine, NORMAL)) {
            logger.info(methodName + " Request Url: " + url);
            res = httpClient.sendRequest(req);
        }
        if (StringUtils.equals(httpLine, G0_V2)) {
            initG0User1Param();
            String url1;
            if (url.contains("internalnlb")) {
                url1 = url.split("/internalnlb")[1];
                req.setUrl(CommonData.WebOpenAPIHost + "/internalnlb" + url1);
                logger.info(methodName + " Request Url: " + CommonData.WebOpenAPIHost + "/internalnlb" + url1);
            }
            else if (url.contains("order")){
                url1 = url.split("/order")[1];
                req.setUrl(CommonData.WebOpenAPIHost + "/order" + url1);
                logger.info(methodName + " Request Url: " + CommonData.WebOpenAPIHost + "/order" + url1);
            }
            else if (url.contains("/ing")){
                url1 = url.split("/ing")[1];
                req.setUrl(CommonData.WebOpenAPIHost + "/ing" + url1);
                logger.info(methodName + " Request Url: " + CommonData.WebOpenAPIHost + "/ining" + url1);
            }
            else if (url.contains("/internaling")){
                url1 = url.split("/internaling")[1];
                req.setUrl(CommonData.WebOpenAPIHost + "/internaling" + url1);
                logger.info(methodName + " Request Url: " + CommonData.WebOpenAPIHost + "/internaling" + url1);
            }
            else {
                url1 = url.split("/nlb")[1];
                req.setUrl(CommonData.WebOpenAPIHost + "/nlb" + url1);
                logger.info(methodName + " Request Url: " + CommonData.WebOpenAPIHost + "/nlb" + url1);
            }
            res = sendG0Request(req);
        }
        logger.info(methodName + " Response Body: " + res.getHtml());
        return res;
    }

    
    public static Response sendJsonReq(String url, Map<String, String> headers, JSONObject bodyJson, HttpClientUtils httpClient,
                                       String httpMethod, String methodName) {
        logger.info(methodName + " Request Body: " + bodyJson);
        Request req = new Request(url, httpMethod);
        req.setHeaders(headers);
        req.setJson(bodyJson);
        Response res = new Response();
        if (StringUtils.equals(httpLine, NORMAL)) {
            res = httpClient.sendJsonRequest(req);
        }
        String url1;
        if (StringUtils.equals(httpLine, G0_V2)) {
            initG0User1Param();
            if (url.contains("order")) {
                url1 = url.split("/order")[1];
                req.setUrl(CommonData.WebOpenAPIHost + "/order" + url1);
            }
            else if (url.contains("ing")) {
                url1 = url.split("/ing")[1];
                req.setUrl(CommonData.WebOpenAPIHost + "/ing" + url1);
            }
            else {
                url1 = url.split("/nlb")[1];
                req.setUrl(CommonData.WebOpenAPIHost + "/nlb" + url1);
            }

            res = sendG0Request(req);
        }
        logger.info(methodName + " Response Body: " + res.getHtml());
        return res;
    }
//
//    public static Response sendHttpsReq(String url, Map<String, String> headers, HttpClientUtils httpClient,
//                                        String httpMethod, String methodName) {
//        Response res = new Response();
//        try {
//            trustAllHttpsCertificates();
//            HostnameVerifier hv = new HostnameVerifier() {
//                public boolean verify(String urlHostName, SSLSession session) {
//                    logger.info("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
//                    return true;
//                }
//            };
//            HttpsURLConnection.setDefaultHostnameVerifier(hv);
//            Request req = new Request(url, httpMethod);
//            req.setHeaders(headers);
//            logger.info(methodName + " Request Url: " + url);
//            res = httpClient.sendRequest(req);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return res;
//    }

//    private static void trustAllHttpsCertificates() throws Exception {
//        TrustManager[] trustAllCerts = new TrustManager[1];
//        TrustManager tm = new miTM();
//        trustAllCerts[0] = tm;
//        SSLContext sc = SSLContext.getInstance("SSL");
//        sc.init(null, trustAllCerts, null);
//        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//    }
//
//    static class miTM implements TrustManager, X509TrustManager {
//        public X509Certificate[] getAcceptedIssuers() {
//            return null;
//        }
//
//        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
//            return true;
//        }
//
//        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
//            return true;
//        }
//
//        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
//                throws java.security.cert.CertificateException {
//            return;
//        }
//
//        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
//                throws java.security.cert.CertificateException {
//            return;
//        }
//    }
}
