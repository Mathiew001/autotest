/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author hzzhangyan
 * @version $Id: DateUtils.java, v 0.1 2017-7-14 下午5:27:43 hzzhangyan Exp $
 */
public class DateUtils {

    /**
     * format:yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     * @param format
     * @return
     */
    public static Date transFromString(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date ret = null;
        try {
            ret = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(transFromString("2017-07-14 17:17:7", "yyyy-MM-dd HH:mm:ss"));
    }
}
