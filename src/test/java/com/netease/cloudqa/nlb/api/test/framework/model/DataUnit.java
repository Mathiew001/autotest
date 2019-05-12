/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.model;

import org.apache.commons.lang.StringUtils;

import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;

/**
 * 
 * @author hzzhangyan
 * @version $Id: DataUnit.java, v 0.1 2017-6-22 下午3:49:55 hzzhangyan Exp $
 */
public class DataUnit {
    private String name;

    private String clazz;

    private Object value;

    private String flag = FlagConstant.N;

    private String description;

    public DataUnit() {

    }

    /**
     * @param name
     * @param value
     */
    public DataUnit(String name, Object value) {
        super();
        this.name = name;
        this.value = value;
    }

    /**
     * @param name
     * @param value
     * @param flag
     */
    public DataUnit(String name, Object value, String flag) {
        super();
        this.name = name;
        this.value = value;
        this.flag = flag;
    }

    /**
     * @param name
     * @param clazz
     * @param value
     * @param description
     */
    public DataUnit(String name, String clazz, Object value, String description) {
        super();
        this.name = name;
        this.clazz = clazz;
        this.value = value;
        this.description = description;
    }

    /**
     * @param name
     * @param clazz
     * @param value
     * @param flag
     * @param description
     */
    public DataUnit(String name, String clazz, Object value, String description, String flag) {
        super();
        this.name = name;
        this.clazz = clazz;
        this.value = value;
        this.description = description;
        this.flag = flag;
    }

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>clazz</tt>.
     * 
     * @return property value of clazz
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Setter method for property <tt>clazz</tt>.
     * 
     * @param clazz value to be assigned to property clazz
     */
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    /**
     * Getter method for property <tt>value</tt>.
     * 
     * @return property value of value
     */
    public Object getValue() {
        return value;
    }

    /**
     * Setter method for property <tt>value</tt>.
     * 
     * @param value value to be assigned to property value
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Getter method for property <tt>description</tt>.
     * 
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for property <tt>description</tt>.
     * 
     * @param description value to be assigned to property description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for property <tt>flag</tt>.
     * 
     * @return property value of flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Setter method for property <tt>flag</tt>.
     * 
     * @param flag value to be assigned to property flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 
     */
    public void dbCheck() {
        if (StringUtils.isEmpty(name) || null == value || StringUtils.isEmpty(flag)) {
            throw new RuntimeException("DataUnit dbCompareCheck exception :" + this.toString());
        }
    }

    @Override
    public String toString() {
        return "DataUnit [name = " + name + ", clazz=" + clazz + ", value = " + value
               + ", description=" + description + ", flag = " + flag + "]";
    }

}
