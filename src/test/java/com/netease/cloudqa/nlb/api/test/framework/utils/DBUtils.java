/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;

import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.config.DBConfig;
import com.netease.cloudqa.nlb.api.test.framework.common.database.JdbcAccessor;

/**
 * 
 * @author hzzhangyan
 * @version $Id: DBUtils.java, v 0.1 2017-7-13 下午2:36:39 hzzhangyan Exp $
 */
public class DBUtils {

    public static List<Map<String, Object>> query(String tableName, String sql) {
        return getJdbcTemplate(tableName).queryForList(sql);
    }

    /**
     * 
     * @param tableName
     * @return
     */
    public static JdbcTemplate getJdbcTemplate(String tableName) {
        List<DBConfig> dbConfigs = ConfigLoader.configration.getDbConfigs();
        if (CollectionUtils.isEmpty(dbConfigs)) {
            throw new RuntimeException("dbConfigs is null");
        }

        String dsName = null;
        for (DBConfig dbconf : dbConfigs) {
            if (dbconf.containTable(tableName)) {
                dsName = dbconf.getDsName();
                break;
            }
        }

        JdbcTemplate jdbcTemp = JdbcAccessor.dbAccessors.get(dsName);
        if (null == jdbcTemp) {
            throw new RuntimeException("tableName : [" + tableName
                                       + "] jdbcTemplate not found , check db.check has config");
        }
        return jdbcTemp;
    }

}
