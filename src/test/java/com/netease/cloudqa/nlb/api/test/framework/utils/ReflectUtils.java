/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;

import com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer.CreateLoadBalancerNormalTest;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer.CreateLoadBalancerNormalPrepare;

/**
 * 
 * @author hzzhangyan
 * @version $Id: ReflectUtils.java, v 0.1 2017-5-26 上午10:30:47 hzzhangyan Exp $
 */
public class ReflectUtils {

    /**
     * 将一个类的属性和值转换成map,兼容类存在Null
     * 
     * @param clazz
     * @return
     */
    public static Map<String, Object> convtClass2Map(Class<?> clazz) {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (int j = 0; j < fields.length; j++) {
            String orgName = fields[j].getName();
            String name = orgName.substring(0, 1).toUpperCase() + orgName.substring(1);
            Method m;
            String value = null;
            try {
                m = clazz.getClass().getMethod("get" + name);
                value = (String) m.invoke(clazz);
            } catch (Exception e) {
            }
            if (value != null) {
                map.put(orgName, null);
            }
        }
        return map;
    }

    /**
     * 
     * 
     * @param caseId
     * @param prepareClazz
     * @param runClazz
     */
    public static void invokerRunCase(String caseId, BasePrepare prepare, ApiTestBase apiTestBase)
                                                                                                  throws Exception {

        //
        Method prepareMethod = null;
        prepareMethod = prepare.getClass().getMethod("createLoadBalancer001");

        if (null == ConfigLoader.configration) {
            ConfigLoader.loadConfig("local");
        }
        //
        DataHolder prepareData = null;
        prepareData = (DataHolder) prepareMethod.invoke(prepare);

        //
        Method runMethod = null;
        Method[] methods = apiTestBase.getClass().getMethods();
        for (Method method : methods) {
            if (StringUtils.equals(method.getName(), "apiTest")
                && null != method.getAnnotation(Test.class)) {
                runMethod = method;
            }
        }

        //
        runMethod.invoke(apiTestBase, prepareData.getDriverData().getDriverParam());
    }

    public static void main(String[] args) {
        try {
            ReflectUtils.invokerRunCase("createLoadBalancer001()",
                new CreateLoadBalancerNormalPrepare(), new CreateLoadBalancerNormalTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
