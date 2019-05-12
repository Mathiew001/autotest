package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.loadbalancer;

import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chentianyu1
 * @version $Id: GetLoadBalancerIngAbnormalPrepare.java, v 0.1 Apr 25, 2018 10:17:48 AM chentianyu1 Exp $
 */
public class GetLoadBalancerIngAbnormalPrepare extends BasePrepare {

    //tenentId 非法
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder getLoadBalancerAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_ingress");
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Tenant initialization failed\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get ing detail, tenentId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), "abcd", null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //namespace不存在
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Namspace not found.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get ing detail, namespace illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), "abcd@qatest-ingress-notdelete", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 不存在
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"No such loadbalancer.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get ing detail, name illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), namespace+"@chentianyu", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
