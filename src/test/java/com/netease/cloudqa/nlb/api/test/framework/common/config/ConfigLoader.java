/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.beust.jcommander.internal.Maps;
import com.netease.cloudqa.nlb.api.test.framework.common.config.impl.ConfigrationImpl;
import com.netease.cloudqa.nlb.api.test.framework.common.database.JdbcAccessor;
import com.netease.cloudqa.nlb.api.test.framework.utils.FileUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.PropertiesUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: ConfigLoader.java, v 0.1 2017-5-25 下午5:24:49 hzzhangyan Exp $
 */
public class ConfigLoader {

    protected static Logger    logger          = Logger.getLogger(ConfigLoader.class);

    public static final String CONFIG_BASE_DIR = "conf";

    public static final String DB_CONF         = "db.conf";

    public static final String EXT_CONF        = "ext.conf";

    public static final String LABLE_CONF      = "case_label.conf";

    public static final String TEST_CONF       = "test-config.properties";

    static Map<String, String> dirMap;

    public static Configration configration;

    private static boolean     loadSuccess     = false;

    private static boolean     initSuccess     = false;

    private static void initDirMap() {
        if (dirMap == null) {
            dirMap = Maps.newHashMap();
            dirMap.put("ci", "ci");
            dirMap.put("jenkins", "jenkins");
            dirMap.put("online_dg_pri", "online_dg_pri");
            dirMap.put("online_dg_pub", "online_dg_pub");
            dirMap.put("online_jd_pri", "online_jd_pri");
            dirMap.put("online_jd_pub", "online_jd_pub");
            dirMap.put("online_lt_pri", "online_lt_pri");
            dirMap.put("online_lt_pub", "online_lt_pub");
            dirMap.put("online_yq_pub", "online_yq_pub");
            dirMap.put("pre_dg_pri", "pre_dg_pri");
            dirMap.put("pre_dg_pub", "pre_dg_pub");
            dirMap.put("pre_jd_pri", "pre_jd_pri");
            dirMap.put("pre_jd_pub", "pre_jd_pub");
            dirMap.put("pre_lt_pri", "pre_lt_pri");
            dirMap.put("pre_lt_pub", "pre_lt_pub");
            dirMap.put("pre_yq_pri", "pre_yq_pri");
            dirMap.put("pre_yq_pub", "pre_yq_pub");
            dirMap.put("private", "private");
            dirMap.put("tmp", "tmp");
            dirMap.put("k8s1.9", "k8s1.9");
            dirMap.put("multiaz", "multiaz");
        }
    }

    /**
     * locad Configration
     * @param env 
     */
    public static void loadConfig(String env) {
        initDirMap();
        if (null == configration) {
            configration = new ConfigrationImpl();
        }

        // 1. load test config
        // 1.1 drive by test-config.prop
        if (null == configration.getTestConfig() && StringUtils.equals(env, "local")) {
            System.out.println(env);
            Properties testConfProps = PropertiesUtils.loadProperties(FileUtils
                .CreateFilePath(CONFIG_BASE_DIR) + TEST_CONF);
            configration.setTestConfig((TestConfig) PropertiesUtils.convtProps2Class(testConfProps,
                TestConfig.class));
        }

        // 1.2 drive by [mvn test -Dtest.env=${test.env}
        if (null == configration.getTestConfig() && !StringUtils.isNotBlank(env)) {
            TestConfig config = new TestConfig();
            config.setTestEnv(env);
            configration.setTestConfig(config);
        }

        // load db config
        if (null == configration.getDbConfigs()) {
            Properties dbProps = PropertiesUtils.loadProperties(FileUtils.CreateFilePath(
                CONFIG_BASE_DIR, dirMap.get(configration.getTestConfig().getTestEnv())) + DB_CONF);
            configration.setDbConfigs(convtProps2DBconfig(dbProps));
        }

        // load ext config
        if (null == configration.getExtConfig()) {
            Properties extProps = PropertiesUtils.loadProperties(FileUtils.CreateFilePath(
                CONFIG_BASE_DIR, dirMap.get(configration.getTestConfig().getTestEnv())) + EXT_CONF);
            if (null == extProps) {
                throw new RuntimeException(EXT_CONF + "文件不存在");
            }
            configration.setExtConfig(extProps.entrySet());
        }

        // load label config
        if (null == configration.getLabelConfig()) {
            Properties labelProps = PropertiesUtils.loadProperties(FileUtils.CreateFilePath(
                CONFIG_BASE_DIR, dirMap.get(configration.getTestConfig().getTestEnv()))
                                                                   + LABLE_CONF);
            if (null == labelProps) {
                throw new RuntimeException(LABLE_CONF + "文件不存在");
            }
            configration.setLabelConfig(labelProps.entrySet());
        }

        loadSuccess = true;
        logger.info(configration.toString());
    }

    /**
     * @param env 
     * 
     */
    private static void intAccessor(String env) {
        // db Accessor
        JdbcAccessor.initialize(configration.getDbConfigs());
        // cache Accessor

    }

    /**
     * 加载配置和初始化连接都加同步锁
     * @param env 
     */
    public static synchronized void initConfigs(String env) {
        if (loadSuccess == false) {
            loadConfig(env);
        }
        if (loadSuccess == true && initSuccess == false) {
            intAccessor(env);
        }
    }

    /**
     * 
     * 
     * @param properties
     * @return
     */
    public static List<DBConfig> convtProps2DBconfig(Properties properties) {
        List<DBConfig> dbConfig = new ArrayList<DBConfig>();
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();

        for (Map.Entry<Object, Object> entry : entrySet) {
            // get datasource name
            if (StringUtils.contains((String) entry.getKey(), "ds_name")) {
                String dsName = (String) entry.getValue();
                String url = properties.getProperty(dsName + "_url");
                String userName = properties.getProperty(dsName + "_username");
                String passWord = properties.getProperty(dsName + "_password");
                String tables = properties.getProperty(dsName + "_tables");
                String driverClass;

                Assert.assertNotNull(url, "url not find for datasource:[" + dsName + "]");
                Assert.assertNotNull(userName, "userName not find for datasource:[" + dsName + "]");
                Assert.assertNotNull(passWord, "passWord not find for datasource:[" + dsName + "]");
                Assert.assertNotNull(tables, "tables not find for datasource:[" + dsName + "]");

                Set<String> tabSet = new HashSet<String>(Arrays.asList(tables.split(",")));
                if (StringUtils.containsIgnoreCase(url, "jdbc:oracle")) {
                    driverClass = "oracle.jdbc.OracleDriver";
                } else {
                    driverClass = "com.mysql.jdbc.Driver";
                }

                dbConfig.add(new DBConfig(dsName, driverClass, url, userName, passWord, tabSet));
            }
        }

        return dbConfig;
    }

    public static void main(String[] args) {
        ConfigLoader.loadConfig("test");
    }

}
