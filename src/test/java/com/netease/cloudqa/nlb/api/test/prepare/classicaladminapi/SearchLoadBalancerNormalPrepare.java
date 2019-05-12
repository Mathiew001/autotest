package com.netease.cloudqa.nlb.api.test.prepare.classicaladminapi;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

public class SearchLoadBalancerNormalPrepare extends BasePrepare {

    //搜索lb, key=name
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder searchLoadBalancerNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "searchLoadBalancerNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "search lb by name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("key", String.class.toString(), "Name", null));
        DataUnits.add(new DataUnit("value", String.class.toString(), "qanotdelete-vpc", null));
        DataUnits.add(new DataUnit("isAccurate", String.class.toString(), "true", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //搜索lb, key=address
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder searchLoadBalancerNormalPrepare002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "searchLoadBalancerNormalPrepare002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "search lb by address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("key", String.class.toString(), "Address", null));
        DataUnits.add(new DataUnit("value", String.class.toString(), "115.238.125.94", null));
        DataUnits.add(new DataUnit("isAccurate", String.class.toString(), "true", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //搜索lb, key=id
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder searchLoadBalancerNormalPrepare003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "searchLoadBalancerNormalPrepare003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "search lb by vipId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("key", String.class.toString(), "Id", null));
        DataUnits.add(new DataUnit("value", String.class.toString(), "dcf575a9-dbd1-4918-8de6-33942b0ad82f", null));
        DataUnits.add(new DataUnit("isAccurate", String.class.toString(), "true", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //搜索lb, key=tenantId
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder searchLoadBalancerNormalPrepare004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "searchLoadBalancerNormalPrepare004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "search lb by tenantId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("key", String.class.toString(), "TenantId", null));
        DataUnits.add(new DataUnit("value", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("isAccurate", String.class.toString(), "true", null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //搜索lb, key=10.
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder searchLoadBalancerNormalPrepare005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "searchLoadBalancerNormalPrepare005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "search lb by ip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("key", String.class.toString(), "Address", null));
        DataUnits.add(new DataUnit("value", String.class.toString(), "10.", null));
        DataUnits.add(new DataUnit("isAccurate", String.class.toString(), "false", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //搜索lb, key=tenantId
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder searchLoadBalancerNormalPrepare006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "searchLoadBalancerNormalPrepare006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "search lb by tenantId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("key", String.class.toString(), "TenantId", null));
        DataUnits.add(new DataUnit("value", String.class.toString(), "34493fd33b8", null));
        DataUnits.add(new DataUnit("isAccurate", String.class.toString(), "false", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
