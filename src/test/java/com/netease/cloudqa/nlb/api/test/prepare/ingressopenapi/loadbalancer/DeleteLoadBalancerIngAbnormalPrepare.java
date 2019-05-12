package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.loadbalancer;

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

public class DeleteLoadBalancerIngAbnormalPrepare extends BasePrepare {

    //删除包年包月实例
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"chargeType is month not allow delete\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Delete package month ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), "{}", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除包年包月实例
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerAbnormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"chargeType is month not allow delete\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerAbnormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Delete package month ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), "{}", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除实例，name非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String body = "{\"InstanceId\":\"" + namespace + "@" + "abcdf" + "\"}";

        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"No such loadbalancer.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Delete ing, instanceId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除实例，namespace非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"InstanceId\":\"" + "abcd" + "@" + "abcd" + "\"}";

        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Namspace not found.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Delete ing, instanceId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除实例，name非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerAbnormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String body = "{\"InstanceId\":\"" + namespace + "@" + "abcdf" + "\"}";

        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"No such loadbalancer.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Delete ing, instanceId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除实例，namespace非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerAbnormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"InstanceId\":\"" + "abcd" + "@" + "abcd" + "\"}";

        //set response message
        String resMsg = "{\n" +
                "    \"code\": 459,\n" +
                "    \"message\": \"Namspace not found.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Delete ing, instanceId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
