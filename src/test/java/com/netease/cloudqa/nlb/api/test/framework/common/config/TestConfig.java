/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.config;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author hzzhangyan
 * @version $Id: TestConfig.java, v 0.1 2017-5-25 下午7:30:46 hzzhangyan Exp $
 */
public class TestConfig {

    private String appName;

    private String testEnv;

    private String testPort;

    private String httpUrl;

    private String checkDb;

    private String importDb;

    private String httpUrlIngress;

    private String httpAdmin;

    private String httpAdminIngress;

    private String appKey;

    private String appSecret;

    private String httpLine;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTestEnv() {
        return testEnv;
    }

    public void setTestEnv(String testEnv) {
        this.testEnv = testEnv;
    }

    public String getTestPort() {
        return testPort;
    }

    public void setTestPort(String testPort) {
        this.testPort = testPort;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public String getHttpUrlIngress() {
        return httpUrlIngress;
    }

    public String getHttpAdmin() {
        return httpAdmin;
    }

    public String getHttpAdminIngress() {
        return httpAdminIngress;
    }

    public void setHttpUrlIngress(String httpUrlIngress) {
        this.httpUrlIngress = httpUrlIngress;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getHttpLine() {
        return httpLine;
    }

    public void setHttpLine(String httpLine) {
        this.httpLine = httpLine;
    }

    public String getCheckDb() {
        return checkDb;
    }

    public void setCheckDb(String checkDb) {
        this.checkDb = checkDb;
    }

    public String getImportDb() {
        return importDb;
    }

    public void setImportDb(String importDb) {
        this.importDb = importDb;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
