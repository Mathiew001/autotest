package com.netease.cloudqa.nlb.api.test.prepare.classicaladminapi;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpdateUserQuotaNormalPrepare extends BasePrepare {

    //修改租户配额
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateUserQuotaNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String type = "{\"type\":" +
                "[\"vpc_mix\", \"mix\", \"tcp\", \"http\"]}";
        String createBody = "{\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"netflow\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"BandwidthLimit\":1,\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "    \n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";;

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateUserQuotaNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update user quota", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("type", String.class.toString(), type, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
