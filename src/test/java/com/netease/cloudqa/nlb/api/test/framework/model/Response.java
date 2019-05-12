/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.http.client.protocol.HttpClientContext;

/**
 * 
 * @author hzzhangyan
 * @version $Id: Response.java, v 0.1 2017-6-14 下午3:15:46 hzzhangyan Exp $
 */
public class Response {

    private int                 code;

    private String              redirectLocation;

    private HttpClientContext   httpClientContext;

    private String              html;

    private Map<String, String> headers = new HashMap<String, String>();

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * 
     * @param code value to be assigned to property code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>redirectLocation</tt>.
     * 
     * @return property value of redirectLocation
     */
    public String getRedirectLocation() {
        return redirectLocation;
    }

    /**
     * Setter method for property <tt>redirectLocation</tt>.
     * 
     * @param redirectLocation value to be assigned to property redirectLocation
     */
    public void setRedirectLocation(String redirectLocation) {
        this.redirectLocation = redirectLocation;
    }

    /**
     * Getter method for property <tt>httpClientContext</tt>.
     * 
     * @return property value of httpClientContext
     */
    public HttpClientContext getHttpClientContext() {
        return httpClientContext;
    }

    /**
     * Setter method for property <tt>httpClientContext</tt>.
     * 
     * @param httpClientContext value to be assigned to property httpClientContext
     */
    public void setHttpClientContext(HttpClientContext httpClientContext) {
        this.httpClientContext = httpClientContext;
    }

    /**
     * Getter method for property <tt>html</tt>.
     * 
     * @return property value of html
     */
    public String getHtml() {
        return html;
    }

    /**
     * Setter method for property <tt>html</tt>.
     * 
     * @param html value to be assigned to property html
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * Getter method for property <tt>headers</tt>.
     * 
     * @return property value of headers
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Setter method for property <tt>headers</tt>.
     * 
     * @param headers value to be assigned to property headers
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
