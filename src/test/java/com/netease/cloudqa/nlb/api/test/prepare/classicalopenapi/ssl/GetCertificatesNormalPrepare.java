package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.ssl;

import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

public class GetCertificatesNormalPrepare extends BasePrepare {

    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getCertificatesNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getCertificatesNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get certs list", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
