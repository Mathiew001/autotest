package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import org.apache.ibatis.annotations.Case;

import java.util.ArrayList;
import java.util.List;

public class GetLoadBalancerAbnormalPrepare extends BasePrepare {

    //instanceId 非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \" Load balancer does not exist.!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb detail, instanceId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), "abcd", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tenentId 非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Tenant initialization failed\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb detail, tenentId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), "abcd", null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tenentId 非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder getLoadBalancerAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Tenant initialization failed\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb detail, tenentId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), "86abf149903840199ffdffc86e408d74", null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), "693c6138-5fe5-4c10-9ce7-99d4b9b18985", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
