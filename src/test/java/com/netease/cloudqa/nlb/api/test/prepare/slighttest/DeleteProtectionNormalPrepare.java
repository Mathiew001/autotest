package com.netease.cloudqa.nlb.api.test.prepare.slighttest;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import java.util.ArrayList;
import java.util.List;

public class DeleteProtectionNormalPrepare extends BasePrepare {

    //实例删除保护
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteProtectionNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String executeBody = "{\n" +
                "    \"Attr\": \"deletionProtectionEnabled\",\n" +
                "    \"Value\":true\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"deletionProtectionEnabled is true not allow delete\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteProtectionNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete protection of instances", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer010", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
