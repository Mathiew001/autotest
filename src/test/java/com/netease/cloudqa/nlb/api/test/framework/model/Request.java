/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.model;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author hzzhangyan
 * @version $Id: Request.java, v 0.1 2017-6-14 下午2:59:20 hzzhangyan Exp $
 */
public class Request {

    protected static Logger     logger            = Logger.getLogger(Request.class);

    public final static String  GET               = "GET";

    public final static String  POST              = "POST";

    public final static String  DELETE            = "DELETE";

    public final static String  PUT               = "PUT";

    private String              url;

    private String              method            = Request.POST;

    private JSON                json;

    private Map<String, String> params            = new HashMap<String, String>();

    private Map<String, String> headers           = new HashMap<String, String>();

    private HttpClientContext   httpClientContext = HttpClientContext.create();

    private SSLContext          sslContext;

    // 默认兼容https
    public Request() {
        if (null == sslContext) {
            enableDefaultSSL();
        }
    }

    /**
     * @param url
     * @param method
     */
    public Request(String url, String method) {
        super();
        this.url = url;
        this.method = method;
        if (null == sslContext) {
            enableDefaultSSL();
        }
    }

    /**
     * 客户端默认ssl签名逻辑,兼容https
     */
    public SSLContext enableDefaultSSL() {
        try {
            setSslContext(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // ignore all
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build());
        } catch (KeyManagementException e) {
            logger.error("KeyManagementException", e);
        } catch (NoSuchAlgorithmException e) {
            logger.error("NoSuchAlgorithmException", e);
        } catch (KeyStoreException e) {
            logger.error("KeyStoreException", e);
        }
        return this.sslContext;
    }

    public boolean isPostMethod() {
        return StringUtils.equals(this.getMethod(), POST);
    }

    public boolean isGetMethod() {
        return StringUtils.equals(this.getMethod(), GET);
    }

    public boolean isDeleteMethod() {
        return StringUtils.equals(this.getMethod(), DELETE);
    }

    public boolean isPutMethod() {
        return StringUtils.equals(this.getMethod(), PUT);
    }

    public SSLContext getSslContext() {
        return sslContext;
    }

    public void setSslContext(SSLContext sslContext) {
        this.sslContext = sslContext;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public HttpClientContext getHttpClientContext() {
        return httpClientContext;
    }

    public void setHttpClientContext(HttpClientContext httpClientContext) {
        this.httpClientContext = httpClientContext;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }

}
