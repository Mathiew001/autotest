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

public class SearchIpNormalPrepare extends BasePrepare {

    //搜索lb, key=address
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder searchIpNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "searchIpNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "search ip by address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("key", String.class.toString(), "Address", null));
        DataUnits.add(new DataUnit("value", String.class.toString(), "115.238.125.94", null));
        DataUnits.add(new DataUnit("isAccurate", String.class.toString(), "true", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //搜索lb, key=10.
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder searchIpNormalPrepare002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "searchIpNormalPrepare002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "search ip by address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("key", String.class.toString(), "Address", null));
        DataUnits.add(new DataUnit("value", String.class.toString(), "10.", null));
        DataUnits.add(new DataUnit("isAccurate", String.class.toString(), "false", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //搜索lb, key=115
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder searchIpNormalPrepare003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "searchIpNormalPrepare003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "search ip by address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("key", String.class.toString(), "Address", null));
        DataUnits.add(new DataUnit("value", String.class.toString(), "115", null));
        DataUnits.add(new DataUnit("isAccurate", String.class.toString(), "false", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //搜索lb, key=10.
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder searchIpNormalPrepare004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "searchIpNormalPrepare004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "search ip by address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("key", String.class.toString(), "Address", null));
        DataUnits.add(new DataUnit("value", String.class.toString(), "10.", null));
        DataUnits.add(new DataUnit("isAccurate", String.class.toString(), "false", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
