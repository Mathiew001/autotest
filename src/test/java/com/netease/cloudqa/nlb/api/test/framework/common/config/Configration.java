/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.config;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 还是用接口方便些,要不就会get.get.get.get
 * @author hzzhangyan
 * @version $Id: Configration.java, v 0.1 2017-5-26 下午2:50:32 hzzhangyan Exp $
 */
public interface Configration {

    /**
     * 
     * @return
     */
    TestConfig getTestConfig();

    /**
     * 
     * @param convtProps2Class
     */
    void setTestConfig(TestConfig config);

    /**
     * 
     * @return
     */
    List<DBConfig> getDbConfigs();

    /**
     * 
     * @return
     */
    String getEvn();

    /**
     * 
     * @return
     */
    String getHttpUrl();

    /**
     *
     * @return
     */
    String getHttpUrlIngress();

    /**
     *
     * @return
     */
    String getHttpAdmin();
    /**
     *
     * @return
     */
    String getHttpAdminIngress();

    /**
     *
     * @return
     */
    String getCheckDb();

    /**
     *
     * @return
     */
    String getImportDb();

    /**
     * 
     * @return
     */
    String getAppKey();

    /**
     * 
     * @return
     */
    String getAppSecret();

    /**
     * 
     * @param dbConfigMap
     */
    void setDbConfigs(List<DBConfig> dbConfigs);

    /**
     * 
     * @return
     */
    String getHttpLine();

    /**
     * 
     * @return
     */
    String getExtConfig(String key);

    /**
     * 
     * @return
     */
    Set<Map.Entry<Object, Object>> getExtConfig();

    /**
     * 
     * @param entrySet
     * @return 
     */
    void setExtConfig(Set<Map.Entry<Object, Object>> entrySet);

    /**
     * 
     * 
     * @return
     */
    public Set<Map.Entry<Object, Object>> getLabelConfig();

    /**
     * 
     * 
     * @param labelConfig
     */
    public void setLabelConfig(Set<Map.Entry<Object, Object>> labelConfig);
}
