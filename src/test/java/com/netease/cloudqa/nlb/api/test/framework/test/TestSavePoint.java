/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.test;

import java.sql.Connection;
import java.sql.Statement;

import com.netease.cloudqa.nlb.api.test.framework.utils.ConnectionUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: TestSavePoint.java, v 0.1 2017-7-21 下午12:26:16 hzzhangyan Exp $
 */
public class TestSavePoint {

    public static void main(String args[]) {

        Connection conn = null;

        try {

            ConnectionUtils.initMysqlCon(
                "jdbc:mysql://10.185.0.120:4311/nlb_test?useUnicode=true&characterEncoding=UTF-8",
                "nlb_test", "nlb_test");
            conn = ConnectionUtils.getConnection();

            //关闭自动提交功能

            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();

            stmt.executeUpdate("update nlb_service set access_key = '04' where service = '01'");

            stmt.executeUpdate("update nlb_service set access_key = '05' where service = '01'");

            //            stmt.executeUpdate("delete from nlb_service where service = '01'");

            conn.commit();

            stmt.close();

        } catch (Exception e) {

            System.out.println("Failure.rollback!!!");

            try {

                conn.rollback();

            } catch (Exception e1) {

                e1.printStackTrace();

            }

            e.printStackTrace();

        } finally {

            try {

                if (conn != null) {

                    conn.close();

                }

            } catch (Exception e1) {

                e1.printStackTrace();

            }

        }

    }

}
