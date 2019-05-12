package com.netease.cloudqa.nlb.api.test.model;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.util.CollectionUtils;

//缺少属性后面补充:https://g.hz.netease.com/nlb/nlb-server/blob/doc-master/docs/api/classicalOpenapi.md
public class LoadBalancer {

    public LoadBalancer() {
    }

    private String            instanceId;

    private String            id;

    private String            tenantId;

    private String            name;

    private String            network;

    private String            description;

    private String            status;

    private String            subStatus;

    private String            instanceStatus;

    private String            address;

    private String            type;

    private Integer           createtime;

    private Integer           updatetime;

    private String            instanceNum;

    private String            vpcId;

    private List<String>      vpcIps;

    private String            orderId;

    private List<Listener>    listeners;

    private List<TargetGroup> targetGroups;

    public Attrs getAttrs() {
        return attrs;
    }

    public void setAttrs(Attrs attrs) {
        this.attrs = attrs;
    }

    private Attrs attrs;

    //是否是5目标组测试监听
    private boolean           lisTestModel = false;

    /**
     * 
     * @param name
     * @return
     */
    public TargetGroup getGroupByName(String name) {
        if (CollectionUtils.isEmpty(targetGroups)) {
            return null;
        }

        for (TargetGroup grp : targetGroups) {
            if (StringUtils.equals(grp.getName(), name)) {
                return grp;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>lisTestModel</tt>.
     * 
     * @return property value of lisTestModel
     */
    public boolean isLisTestModel() {
        return lisTestModel;
    }

    /**
     * Setter method for property <tt>lisTestModel</tt>.
     * 
     * @param lisTestModel value to be assigned to property lisTestModel
     */
    public void setLisTestModel(boolean lisTestModel) {
        this.lisTestModel = lisTestModel;
    }

    /**
     * Getter method for property <tt>listeners</tt>.
     * 
     * @return property value of listeners
     */
    public List<Listener> getListeners() {
        return listeners;
    }

    /**
     * Setter method for property <tt>listeners</tt>.
     * 
     * @param listeners value to be assigned to property listeners
     */
    public void setListeners(List<Listener> listeners) {
        this.listeners = listeners;
    }

    /**
     * Getter method for property <tt>targetGroups</tt>.
     * 
     * @return property value of targetGroups
     */
    public List<TargetGroup> getTargetGroups() {
        return targetGroups;
    }

    /**
     * Setter method for property <tt>targetGroups</tt>.
     * 
     * @param targetGroups value to be assigned to property targetGroups
     */
    public void setTargetGroups(List<TargetGroup> targetGroups) {
        this.targetGroups = targetGroups;
    }

    public LoadBalancer(String instanceId) {
        this.instanceId = instanceId;
        orderId = null;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter method for property <tt>tenantId</tt>.
     * 
     * @return property value of tenantId
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * Setter method for property <tt>tenantId</tt>.
     * 
     * @param tenantId value to be assigned to property tenantId
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
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
     * Getter method for property <tt>network</tt>.
     * 
     * @return property value of network
     */
    public String getNetwork() {
        return network;
    }

    /**
     * Setter method for property <tt>network</tt>.
     * 
     * @param network value to be assigned to property network
     */
    public void setNetwork(String network) {
        this.network = network;
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
     * Getter method for property <tt>subStatus</tt>.
     * 
     * @return property value of subStatus
     */
    public String getSubStatus() {
        return subStatus;
    }

    /**
     * Setter method for property <tt>subStatus</tt>.
     * 
     * @param subStatus value to be assigned to property subStatus
     */
    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    /**
     * Getter method for property <tt>instanceStatus</tt>.
     * 
     * @return property value of instanceStatus
     */
    public String getInstanceStatus() {
        return instanceStatus;
    }

    /**
     * Setter method for property <tt>instanceStatus</tt>.
     * 
     * @param instanceStatus value to be assigned to property instanceStatus
     */
    public void setInstanceStatus(String instanceStatus) {
        this.instanceStatus = instanceStatus;
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
     * Getter method for property <tt>type</tt>.
     * 
     * @return property value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for property <tt>type</tt>.
     * 
     * @param type value to be assigned to property type
     */
    public void setType(String type) {
        this.type = type;
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
     * Getter method for property <tt>instanceNum</tt>.
     * 
     * @return property value of instanceNum
     */
    public String getInstanceNum() {
        return instanceNum;
    }

    /**
     * Setter method for property <tt>instanceNum</tt>.
     * 
     * @param instanceNum value to be assigned to property instanceNum
     */
    public void setInstanceNum(String instanceNum) {
        this.instanceNum = instanceNum;
    }

    /**
     * Getter method for property <tt>vpcId</tt>.
     * 
     * @return property value of vpcId
     */
    public String getVpcId() {
        return vpcId;
    }

    /**
     * Setter method for property <tt>vpcId</tt>.
     * 
     * @param vpcId value to be assigned to property vpcId
     */
    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    /**
     * Getter method for property <tt>vpcIps</tt>.
     * 
     * @return property value of vpcIps
     */
    public List<String> getVpcIps() {
        return vpcIps;
    }

    /**
     * Setter method for property <tt>vpcIps</tt>.
     * 
     * @param vpcIps value to be assigned to property vpcIps
     */
    public void setVpcIps(List<String> vpcIps) {
        this.vpcIps = vpcIps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
