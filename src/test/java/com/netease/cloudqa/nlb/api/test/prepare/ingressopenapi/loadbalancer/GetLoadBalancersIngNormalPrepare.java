package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.loadbalancer;

import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

public class GetLoadBalancersIngNormalPrepare extends BasePrepare {

    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersIngNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersIngNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, mix limit=1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersIngNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersIngNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, mix limit=2, offset=0", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "0", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersIngNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersIngNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, mix limit=2, offset=1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "2", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "1", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersIngNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersIngNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, mix limit=\"\"", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
