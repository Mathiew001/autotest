/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;

/**
 * 
 * @author hzzhangyan
 * @version $Id: DataUnitUtils.java, v 0.1 2017-9-7 上午11:29:16 hzzhangyan Exp $
 */
public class DataUnitUtils {

    /**
     * 兼容jdk1.8和1.6在map.values().toArray()的缺陷(1.8位顺序获取,1.6为倒序)
     * 
     * @param units
     * @return
     */
    public static Object[] filterObject(List<DataUnit> units) {
        if (CollectionUtils.isEmpty(units)) {
            return null;
        }
        int length = units.size();
        Object[] objects = new Object[length];
        for (int i = 0; i < length; i++) {
            objects[i] = units.get(i).getValue();
        }
        return objects;
    }
}
