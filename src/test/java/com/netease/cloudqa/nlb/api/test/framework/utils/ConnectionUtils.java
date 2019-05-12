/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author hzzhangyan
 * @version $Id: ConnectionUtils.java, v 0.1 2017-7-21 下午12:28:39 hzzhangyan Exp $
 */
public class ConnectionUtils {

    private static Connection conn = null;

    public static void initMysqlCon(String url, String userName, String pwd) {
        if (null == conn) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // 2.获得数据库的连接
                conn = DriverManager.getConnection(url, userName, pwd);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static Connection getConnection() {
        return conn;
    }
}
