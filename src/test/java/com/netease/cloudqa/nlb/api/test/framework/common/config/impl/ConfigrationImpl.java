/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.config.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.netease.cloudqa.nlb.api.test.framework.common.config.Configration;
import com.netease.cloudqa.nlb.api.test.framework.common.config.DBConfig;
import com.netease.cloudqa.nlb.api.test.framework.common.config.TestConfig;

/**
 * 
 * @author hzzhangyan
 * @version $Id: ConfigrationImpl.java, v 0.1 2017-5-25 下午5:36:02 hzzhangyan Exp $
 */
public class ConfigrationImpl implements Configration {

    private List<DBConfig>                 dbConfigs;

    private TestConfig                     testConfig;

    private Set<Map.Entry<Object, Object>> extConfig;

    private Set<Map.Entry<Object, Object>> labelConfig;

    @Override
    public TestConfig getTestConfig() {
        return testConfig;
    }

    @Override
    public void setTestConfig(TestConfig testConfig) {
        this.testConfig = testConfig;
    }

    /** 
     * @see com.netease.push.server.sdk.framework.common.config.Configration#getEvn()
     */
    @Override
    public String getEvn() {
        if (null == getTestConfig()) {
            return null;
        }
        return getTestConfig().getTestEnv();
    }

    /** 
     * @see com.netease.push.server.sdk.framework.common.config.Configration#getHttpUrl()
     */
    @Override
    public String getCheckDb() {
        if (null == getTestConfig()) {
            return null;
        }
        return getTestConfig().getCheckDb();
    }

    @Override
    public String getImportDb() {
        if (null == getTestConfig()) {
            return null;
        }
        return getTestConfig().getImportDb();
    }

    @Override
    public String getHttpUrl() {
        if (null == getTestConfig()) {
            return null;
        }
        return getTestConfig().getHttpUrl();
    }

    @Override
    public String getHttpUrlIngress() {
        if (null == getTestConfig()) {
            return null;
        }
        return getTestConfig().getHttpUrlIngress();
    }

    @Override
    public String getHttpAdmin() {
        if (null == getTestConfig()) {
            return null;
        }
        return getTestConfig().getHttpAdmin();
    }

    @Override
    public String getHttpAdminIngress() {
        if (null == getTestConfig()) {
            return null;
        }
        return getTestConfig().getHttpAdminIngress();
    }

    /** 
     * @see com.netease.push.server.sdk.framework.common.config.Configration#getAppKey()
     */
    @Override
    public String getAppKey() {
        if (null == getTestConfig()) {
            return null;
        }
        return getTestConfig().getAppKey();
    }

    /** 
     * @see com.netease.push.server.sdk.framework.common.config.Configration#getAppSecret()
     */
    @Override
    public String getAppSecret() {
        if (null == getTestConfig()) {
            return null;
        }
        return getTestConfig().getAppSecret();
    }

    @Override
    public List<DBConfig> getDbConfigs() {
        return dbConfigs;
    }

    @Override
    public void setDbConfigs(List<DBConfig> dbConfigs) {
        this.dbConfigs = dbConfigs;
    }

    @Override
    public String getHttpLine() {
        return testConfig.getHttpLine();
    }

    @Override
    public String getExtConfig(String key) {
        if (StringUtils.isEmpty(key) || null == extConfig) {
            return null;
        }

        for (Map.Entry<Object, Object> set : extConfig) {
            if (StringUtils.equals((String) set.getKey(), key)) {
                return (String) set.getValue();
            }
        }
        return null;
    }

    @Override
    public void setExtConfig(Set<Entry<Object, Object>> entrySet) {
        this.extConfig = entrySet;
    }

    /** 
     * 
     * @see com.netease.cloudqa.nlb.api.test.framework.common.config.Configration#getExtConfig()
     */
    @Override
    public Set<Entry<Object, Object>> getExtConfig() {
        return extConfig;
    }

    public Set<Map.Entry<Object, Object>> getLabelConfig() {
        return labelConfig;
    }

    public void setLabelConfig(Set<Map.Entry<Object, Object>> labelConfig) {
        this.labelConfig = labelConfig;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
