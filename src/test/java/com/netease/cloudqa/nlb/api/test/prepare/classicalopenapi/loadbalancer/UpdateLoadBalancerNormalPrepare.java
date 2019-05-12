package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author chentianyu1
 * @version $Id: UpdateLoadBalancerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateLoadBalancerNormalPrepare extends BasePrepare {

    //mix实例更新描述
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String updateBody = "{\n" +
                "\t\"InstanceId\": \"instanceId\",\n" +
                "\t\"Description\": \"test cty\"\n" +
                "}";
        String resMsg = "{\n" +
                "\t\"Description\": \"test cty\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("udpateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix实例更新描述
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String updateBody = "{\n" +
                "\t\"InstanceId\": \"instanceId\",\n" +
                "\t\"Description\": \"test cty\"\n" +
                "}";
        String resMsg = "{\n" +
                "\t\"Description\": \"test cty\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("udpateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //idc_vpc_mix更新描述
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String updateBody = "{\n" +
                "\t\"InstanceId\": \"instanceId\",\n" +
                "\t\"Description\": \"test cty\"\n" +
                "}";
        String resMsg = "{\n" +
                "\t\"Description\": \"test cty\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of idc_vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("udpateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //dns实例更新
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String updateBody = "{\n" +
                "\t\"InstanceId\": \"instanceId\",\n" +
                "\t\"Description\": \"test cty\"\n" +
                "}";
        String resMsg = "{\n" +
                "\t\"Description\": \"test cty\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of dns lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("udpateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_l4实例更新
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String updateBody = "{\n" +
                "\t\"InstanceId\": \"instanceId\",\n" +
                "\t\"Description\": \"test cty\"\n" +
                "}";
        String resMsg = "{\n" +
                "\t\"Description\": \"test cty\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_l4 lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("udpateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
