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

public class GetIpsNormalPrepare extends BasePrepare {

    //获取ip
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getIpsNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getIpsNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get ips free", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("status", String.class.toString(), "FREE", null));
        DataUnits.add(new DataUnit("groupId", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //获取ip
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getIpsNormalPrepare002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getIpsNormalPrepare002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get ips used", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("status", String.class.toString(), "USED", null));
        DataUnits.add(new DataUnit("groupId", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //获取ip
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getIpsNormalPrepare003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getIpsNormalPrepare003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get ips with limit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("status", String.class.toString(), "USED", null));
        DataUnits.add(new DataUnit("groupId", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //获取ip
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getIpsNormalPrepare004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getIpsNormalPrepare003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get ips with limit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("status", String.class.toString(), "USED", null));
        DataUnits.add(new DataUnit("groupId", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "20", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "1", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
