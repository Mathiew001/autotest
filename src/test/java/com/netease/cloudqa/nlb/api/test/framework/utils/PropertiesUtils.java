/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 
 * @author hzzhangyan
 * @version $Id: PropertiesUtils.java, v 0.1 2017-5-26 上午9:47:53 hzzhangyan Exp $
 */
public class PropertiesUtils {

    protected static Logger  logger    = Logger.getLogger(PropertiesUtils.class);

    public static final char UNDERLINE = '_';

    /**
     * load Properties by Properties file path
     * 
     * @param confPath
     * @return
     */
    public static Properties loadProperties(String confPath) {
        ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
        URL configUrl = currentClassLoader.getResource(confPath);
        if (null == configUrl) {
            logger.error("can not find config from path:[" + confPath + "]");
            return null;
        }

        Properties properties = new Properties();
        try {
            properties.load(configUrl.openStream());
        } catch (Exception e) {
            logger.error("can not find config [" + confPath + "] details [" + e.getMessage() + "]");
            return null;
        }
        return properties;
    }

    /**
     * 
     * Example:
     * Property[app_name=push,test_env=test,core_port=8080] 转换成  TestConfig对应的类和属性
     */
    public static Object convtProps2Class(Properties properties, Class<?> clazz) {
        if (null == properties) {
            return null;
        }

        // instance class
        Object obj;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            logger.error("InstantiationException", e);
            return null;
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccessException", e);
            return null;
        }
        // fields
        Field[] fields = obj.getClass().getDeclaredFields();
        if (null == fields) {
            return obj;
        }

        // props entry
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();

        // set class attribute
        for (Map.Entry<Object, Object> entry : entrySet) {
            String attrName = underlineToCamel((String) entry.getKey());
            for (Field field : fields) {
                if (StringUtils.equals(field.getName(), attrName)) {
                    field.setAccessible(true);
                    try {
                        field.set(obj, entry.getValue());
                    } catch (IllegalArgumentException e) {
                        logger.error("IllegalArgumentException", e);
                    } catch (IllegalAccessException e) {
                        logger.error("IllegalAccessException", e);
                    }
                    //                    String methodName = attrName.substring(0, 1).toUpperCase()
                    //                                        + attrName.substring(1);
                    //                    Method m;
                    //                    try {
                    //                        m = obj.getClass().getMethod("set" + methodName);
                    //                        m.invoke(obj, entry.getValue());
                    //                    } catch (Exception e) {
                    //                        logger.error("Can Not Find Method ： set" + methodName + "(parameters)", e);
                    //                    }
                }
            }
        }

        return obj;

    }

    /**
     * Example:
     * app_name=appName
     * 
     * @param param
     * @return
     */
    public static String underlineToCamel(String param) {
        if (StringUtils.isEmpty(param)) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(PropertiesUtils.underlineToCamel("core_host"));
    }
}
