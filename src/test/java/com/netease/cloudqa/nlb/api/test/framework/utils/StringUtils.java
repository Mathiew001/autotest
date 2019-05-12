/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author hzzhangyan
 * @version $Id: StringUtils.java, v 0.1 2018-5-26 下午9:34:12 hzzhangyan Exp $
 */
public class StringUtils {

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static boolean contains(String[] strs, String[] substrs) {
        if (null == substrs) {
            return false;
        }

        if (null == strs) {
            return false;
        }

        List<String> strlst = Arrays.asList(strs);
        List<String> sublst = Arrays.asList(substrs);
        return strlst.containsAll(sublst);
    }

}
