/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;

import com.netease.cloudqa.nlb.api.test.framework.common.config.DBConfig;

/**
 * 
 * @author hzzhangyan
 * @version $Id: JdbcAccessor.java, v 0.1 2017-6-21 下午8:09:31 hzzhangyan Exp $
 */
public class JdbcAccessor {

    public static Map<String, JdbcTemplate> dbAccessors;

    public static int                       QUERY_TIME_OUT = 3000;

    public static void initialize(List<DBConfig> dbconfigs) {
        if (null == dbAccessors) {
            dbAccessors = new HashMap<String, JdbcTemplate>();
        }
        if (!CollectionUtils.isEmpty(dbconfigs)) {
            for (DBConfig dbConfig : dbconfigs) {
                BasicDataSource dataSource = new BasicDataSource();
                dataSource.setUrl(dbConfig.getDbUrl());
                dataSource.setDriverClassName(dbConfig.getDriverClass());
                dataSource.setUsername(dbConfig.getUserName());
                dataSource.setPassword(dbConfig.getPassWord());
                JdbcTemplate template = new JdbcTemplate();
                template.setDataSource(dataSource);
                template.setQueryTimeout(QUERY_TIME_OUT);
                dbAccessors.put(dbConfig.getDsName(), template);
            }
        }
    }
}
