/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author hzzhangyan
 * @version $Id: PatternUtils.java, v 0.1 2017-6-23 下午3:34:01 hzzhangyan Exp $
 */
public class PatternUtils {

    public static boolean matcher(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean find(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static String extractByReg(String str, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(str);
        if (m.find()) {
            return m.group();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(matcher(
            "/mydns/local/test/record-api-service-name/record-api-service-name/$recordPrefix$",
            "\\$\\w+\\$"));
        System.out.println(extractByReg(
            "/mydns/local/test/record-api-service-name/record-api-service-name/$recordPrefix$",
            "\\$\\w+\\$"));
        System.out.println(extractByReg("dsdfsefwdfe$=ip$", "\\$=\\w+\\$"));
    }

}
