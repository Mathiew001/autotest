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

public class UpdateLoadBalancerQuotaNormalPrepare extends BasePrepare {

    //更改实例配额
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerQuotaNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerQuotaNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb quota", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("listenerLimit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("tGroupLimit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("tGroupInstanceLimit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("pathLimit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("domainLimit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("maxBandwidth", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer010", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
