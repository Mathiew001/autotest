package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;

public class DeleteLoadBalancerAbnormalPrepare extends BasePrepare {

    //删除创建中的实例
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder deleteLoadBalancerAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "netflow", "hour", 1);
        //set response message
        String resMsg = "{\"Message\":\"elete too fast!Loadbalancer is not ready for delete\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete lb when it's creating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除包年包月mix实例
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set response message
        String resMsg = "{\"Code\": \"Forbidden\", \"Message\":\"chargeType is month not allow delete\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete package month mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除包年包月vpc_mix实例
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set response message
        String resMsg = "{\"Code\": \"Forbidden\", \"Message\":\"chargeType is month not allow delete\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete package month vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
