/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author hzzhangyan
 * @version $Id: Instance.java, v 0.1 2018-5-28 下午5:15:50 hzzhangyan Exp $
 */
public class Instance {

    private String  id;

    private String  name;

    private String  address;

    private Integer port;

    private String  status;

    private String  topAz;

    private Integer weight;

    private Integer backup;

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
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
     * Getter method for property <tt>address</tt>.
     * 
     * @return property value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for property <tt>address</tt>.
     * 
     * @param address value to be assigned to property address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter method for property <tt>port</tt>.
     * 
     * @return property value of port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Setter method for property <tt>port</tt>.
     * 
     * @param port value to be assigned to property port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>topAz</tt>.
     * 
     * @return property value of topAz
     */
    public String getTopAz() {
        return topAz;
    }

    /**
     * Setter method for property <tt>topAz</tt>.
     * 
     * @param topAz value to be assigned to property topAz
     */
    public void setTopAz(String topAz) {
        this.topAz = topAz;
    }

    /**
     * Getter method for property <tt>weight</tt>.
     * 
     * @return property value of weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * Setter method for property <tt>weight</tt>.
     * 
     * @param weight value to be assigned to property weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * Getter method for property <tt>backup</tt>.
     * 
     * @return property value of backup
     */
    public Integer getBackup() {
        return backup;
    }

    /**
     * Setter method for property <tt>backup</tt>.
     * 
     * @param backup value to be assigned to property backup
     */
    public void setBackup(Integer backup) {
        this.backup = backup;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static void main(String[] args) {
        Integer a = 8080;

    }

}
