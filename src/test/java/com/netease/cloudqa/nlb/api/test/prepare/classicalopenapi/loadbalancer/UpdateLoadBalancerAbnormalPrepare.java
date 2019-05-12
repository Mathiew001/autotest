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

import static com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader.configration;

public class UpdateLoadBalancerAbnormalPrepare extends BasePrepare {

    //ha1.6 update acc to 1
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder updateLoadBalancerAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String updateBody = "{\n" +
                "    \"InstanceId\": \"instanceId\",\n" +
                "    \"Attrs\": {\n" +
                "        \"UseSSLAcc\": 1\n" +
                "    }\n" +
                "}";
        String resMsg = "{\n" +
                "    \"Code\":\"BadRequest\",\n" +
                "    \"Message\":\"this instance do not support sslAcc\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update acc of 1 of vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ha1.6 update acc to -1
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder updateLoadBalancerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String updateBody = "{\n" +
                "    \"InstanceId\": \"instanceId\",\n" +
                "    \"Attrs\": {\n" +
                "        \"UseSSLAcc\": -1\n" +
                "    }\n" +
                "}";
        String resMsg = "{\n" +
                "    \"Code\":\"BadRequest\",\n" +
                "    \"Message\":\"this instance do not support sslAcc\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update acc of -1 of vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ha1.6 update stoptimeout = -1
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String updateBody = "{\n" +
                "    \"InstanceId\": \"instanceId\",\n" +
                "    \"Attrs\": {\n" +
                "        \"StopTimeout\": -1\n" +
                "    }\n" +
                "}";
        String resMsg = "{\n" +
                "    \"Code\":\"BadRequest\",\n" +
                "    \"Message\":\"unsupported stopTimeout\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update stoptimeout of -1 of vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ha1.8 update acc form 1 to 0
    @CaseLabel(lbType = {"ha1.8vpc"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String updateBody = "{\n" +
                "    \"InstanceId\": \"instanceId\",\n" +
                "    \"Attrs\": {\n" +
                "        \"UseSSLAcc\": 0\n" +
                "    }\n" +
                "}";
        String resMsg = "{\n" +
                "    \"Code\":\"BadRequest\",\n" +
                "    \"Message\":\"unsupported useSSLAcc\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update acc of 1 of ha1.8vpc lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ha1.6 update stoptimeout
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder updateLoadBalancerAbnormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String updateBody = "{\n" +
                "    \"InstanceId\": \"instanceId\",\n" +
                "    \"Attrs\": {\n" +
                "        \"StopTimeout\": 1000\n" +
                "    }\n" +
                "}";
        String resMsg = "{\n" +
                "    \"Code\":\"BadRequest\",\n" +
                "    \"Message\":\"this instance do not support stopTimeout\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update stoptimeout of 1 of ha1.6 lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
