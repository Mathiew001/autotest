package com.netease.cloudqa.nlb.api.test.model;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class TargetGroup {

    private String         targetGroupId;

    private String         name;

    private Integer        useSamePort;

    private Integer        createtime;

    private Integer        updatetime;

    private List<Instance> instances;

    /**
     * Getter method for property <tt>targetGroupId</tt>.
     * 
     * @return property value of targetGroupId
     */
    public String getTargetGroupId() {
        return targetGroupId;
    }

    /**
     * Setter method for property <tt>targetGroupId</tt>.
     * 
     * @param targetGroupId value to be assigned to property targetGroupId
     */
    public void setTargetGroupId(String targetGroupId) {
        this.targetGroupId = targetGroupId;
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
     * Getter method for property <tt>useSamePort</tt>.
     * 
     * @return property value of useSamePort
     */
    public Integer getUseSamePort() {
        return useSamePort;
    }

    /**
     * Setter method for property <tt>useSamePort</tt>.
     * 
     * @param useSamePort value to be assigned to property useSamePort
     */
    public void setUseSamePort(Integer useSamePort) {
        this.useSamePort = useSamePort;
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
     * Getter method for property <tt>instances</tt>.
     * 
     * @return property value of instances
     */
    public List<Instance> getInstances() {
        return instances;
    }

    /**
     * Setter method for property <tt>instances</tt>.
     * 
     * @param instances value to be assigned to property instances
     */
    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
