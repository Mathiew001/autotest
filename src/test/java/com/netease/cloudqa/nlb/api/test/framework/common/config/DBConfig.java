/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.config;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: DBConfig.java, v 0.1 2017-5-25 下午7:04:38 hzzhangyan Exp $
 */
public class DBConfig {

    private String      dsName;

    private String      driverClass;

    private String      url;

    private String      userName;

    private String      passWord;

    private Set<String> tables;

    /**
     * @param dsName
     * @param driverClass
     * @param url
     * @param userName
     * @param passWord
     * @param tables
     */
    public DBConfig(String dsName, String driverClass, String url, String userName,
                    String passWord, Set<String> tables) {
        super();
        this.dsName = dsName;
        this.driverClass = driverClass;
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;
        this.tables = tables;
    }

    public boolean containTable(String table) {
        for (String tb : tables) {
            // 只支持简单匹配
            if (StringUtils.equalsIgnoreCase(tb, table)) {
                return true;
            }
        }
        return false;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDbUrl() {
        return url;
    }

    public void setDbUrl(String dbUrl) {
        this.url = dbUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean hasTable(String tableName) {
        if (CollectionUtils.isEmpty(tables)) {
            return false;
        }
        return getTables().contains(tableName);
    }

    public Set<String> getTables() {
        return tables;
    }

    public void setTables(Set<String> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
