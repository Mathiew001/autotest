package com.netease.cloudqa.nlb.api.test.prepare.ingressadminapi;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import org.codehaus.jackson.map.Serializers;

import java.util.ArrayList;
import java.util.List;

public class GetLoadBalancersByVPCIngNormalPrepare extends BasePrepare {

    @PrepareDescription(isPrepareMethod = true)
    public DataHolder GetLoadBalancersByVPCNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "GetLoadBalancersByVPCIngNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "getLoadBalancersByVPC simple test", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("tenantId2", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id2"), null));
        DataUnits.add(new DataUnit("vpcId", String.class.toString(), ConfigLoader.configration.getExtConfig("vpc_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), ConfigLoader.configration.getExtConfig("namespace"), null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
