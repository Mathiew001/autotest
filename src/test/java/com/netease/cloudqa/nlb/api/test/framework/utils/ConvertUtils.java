/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: ConvertUtils.java, v 0.1 2017-5-23 下午4:30:01 hzzhangyan Exp $
 */
public class ConvertUtils {

    /**
     * 将String类型a,b,c转换成List类型[a,b,c]
     * 
     * @param str
     * @return
     */
    public List<String> convStr2List(String str) {
        List<String> lst = new ArrayList<String>();
        if (StringUtils.isEmpty(str)) {
            return lst;
        }
        String[] strs = str.split(",");
        return Arrays.asList(strs);
    }
}
