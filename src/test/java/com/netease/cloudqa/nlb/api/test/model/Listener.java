package com.netease.cloudqa.nlb.api.test.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.List;

public class Listener {

    private String  listenerId;

    private String  name;

    private Integer listenPort;

    private String  protocol;

    private Integer traceVip;

    private String  balance;

    private Integer gzip;

    private Integer createtime;

    private Integer updatetime;

    private String  status;

    private List<Cluster> clusters;

    /**
     * @param listenerId
     */
    public Listener(String listenerId) {
        this.listenerId = listenerId;
    }

    public Listener() {};

    /**
     * Getter method for property <tt>listenerId</tt>.
     * 
     * @return property value of listenerId
     */
    public String getListenerId() {
        return listenerId;
    }

    /**
     * Setter method for property <tt>listenerId</tt>.
     * 
     * @param listenerId value to be assigned to property listenerId
     */
    public void setListenerId(String listenerId) {
        this.listenerId = listenerId;
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
     * Getter method for property <tt>listenPort</tt>.
     * 
     * @return property value of listenPort
     */
    public Integer getListenPort() {
        return listenPort;
    }

    /**
     * Setter method for property <tt>listenPort</tt>.
     * 
     * @param listenPort value to be assigned to property listenPort
     */
    public void setListenPort(Integer listenPort) {
        this.listenPort = listenPort;
    }

    /**
     * Getter method for property <tt>protocol</tt>.
     * 
     * @return property value of protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Setter method for property <tt>protocol</tt>.
     * 
     * @param protocol value to be assigned to property protocol
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Getter method for property <tt>traceVip</tt>.
     * 
     * @return property value of traceVip
     */
    public Integer getTraceVip() {
        return traceVip;
    }

    /**
     * Setter method for property <tt>traceVip</tt>.
     * 
     * @param traceVip value to be assigned to property traceVip
     */
    public void setTraceVip(Integer traceVip) {
        this.traceVip = traceVip;
    }

    /**
     * Getter method for property <tt>balance</tt>.
     * 
     * @return property value of balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * Setter method for property <tt>balance</tt>.
     * 
     * @param balance value to be assigned to property balance
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * Getter method for property <tt>gzip</tt>.
     * 
     * @return property value of gzip
     */
    public Integer getGzip() {
        return gzip;
    }

    /**
     * Setter method for property <tt>gzip</tt>.
     * 
     * @param gzip value to be assigned to property gzip
     */
    public void setGzip(Integer gzip) {
        this.gzip = gzip;
    }

    /**
     * Getter method for property <tt>createtime</tt>.
     * 
     * @return property value of createtime
     */
    public Integer getCreatetime() {
        return createtime;
    }

    /**
     * Setter method for property <tt>createtime</tt>.
     * 
     * @param createtime value to be assigned to property createtime
     */
    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    /**
     * Getter method for property <tt>updatetime</tt>.
     * 
     * @return property value of updatetime
     */
    public Integer getUpdatetime() {
        return updatetime;
    }

    /**
     * Setter method for property <tt>updatetime</tt>.
     * 
     * @param updatetime value to be assigned to property updatetime
     */
    public void setUpdatetime(Integer updatetime) {
        this.updatetime = updatetime;
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

    public List<Cluster> getClusters() {
        return clusters;
    }

    public void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
