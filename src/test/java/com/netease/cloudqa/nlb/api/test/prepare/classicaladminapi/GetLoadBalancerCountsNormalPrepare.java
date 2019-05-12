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

public class GetLoadBalancerCountsNormalPrepare extends BasePrepare {

    //获取lb数量
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerCountsNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String type = "{\"type\":" +
                "[\"public_http_ordinary\", \"public_mix_ordinary\", \"public_vpcmix_ordinary\", \"public_tcp_ordinary\"," +
                "\"private_tcp_ordinary\", \"idc_mix_ordinary\", \"private_vpcmix_ordinary\", \"idc_tcp_ordinary\", \"public_http_ingress\", " +
                "\"public_mix_ingress\", \"public_vpcmix_ingress\"]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerCountsNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb count", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("type", String.class.toString(), type, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
