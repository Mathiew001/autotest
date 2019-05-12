package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.loadbalancer;

import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

public class GetLoadBalancersIngAbnormalPrepare extends BasePrepare {
    //limit参数非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersIngAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Code\": \"BadRequest\",\"Message\": \"Bad request with Offset or Limit\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersIngAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, limit=-1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "-1", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //offset参数非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersIngAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Code\": \"BadRequest\",\"Message\": \"Bad request with Offset or Limit\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersIngAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, offset=-1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "-1", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tenantId参数非法
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder getLoadBalancersIngAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Tenant initialization failed\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersIngAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, illegal tenantId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), "abcd", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
