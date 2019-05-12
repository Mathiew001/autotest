package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author chentianyu1
 * @version $Id: RenewOrderIngAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class RenewOrderAbnormalPrepare extends BasePrepare {

    //按量计费续费
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder renewOrderAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set resMsg
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"{\\\"Code\\\":\\\"InstanceChargeStateError\\\",\\\"Message\\\":\\\"The instance charge state is illegal\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "renewOrderAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "netflow mix renew order", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("period", String.class.toString(), "2", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //按量计费续费
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder renewOrderAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set resMsg
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"{\\\"Code\\\":\\\"InstanceChargeStateError\\\",\\\"Message\\\":\\\"The instance charge state is illegal\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "renewOrderAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "bandwidth mix renew order", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("period", String.class.toString(), "2", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer002", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //按量计费续费
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder renewOrderAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set resMsg
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"{\\\"Code\\\":\\\"InstanceChargeStateError\\\",\\\"Message\\\":\\\"The instance charge state is illegal\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "renewOrderAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "netflow vpc_mix renew order", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("period", String.class.toString(), "2", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //按量计费续费
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder renewOrderAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set resMsg
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"{\\\"Code\\\":\\\"InstanceChargeStateError\\\",\\\"Message\\\":\\\"The instance charge state is illegal\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "renewOrderAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "bandwidth vpc_mix renew order", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("period", String.class.toString(), "2", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer005", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //period非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder renewOrderAbnormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set resMsg
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter Period cannot accept value 10.\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "renewOrderAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "renew order, period illegals", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("period", String.class.toString(), "10", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //period非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder renewOrderAbnormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set resMsg
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter Period cannot accept value -1.\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "renewOrderAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "renew order, period illegals", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("period", String.class.toString(), "-1", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //period非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder renewOrderAbnormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set resMsg
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter Period cannot accept value 0.\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "renewOrderAbnormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "renew order, period illegals", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("period", String.class.toString(), "0", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //period非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder renewOrderAbnormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set resMsg
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter Period cannot accept value 10.\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "renewOrderAbnormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "renew order, period illegals", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("period", String.class.toString(), "10", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //period非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder renewOrderAbnormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set resMsg
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter Period cannot accept value -1.\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "renewOrderAbnormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "renew order, period illegals", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("period", String.class.toString(), "-1", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //period非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder renewOrderAbnormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set resMsg
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter Period cannot accept value 0.\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "renewOrderAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "renew order, period illegals", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("period", String.class.toString(), "0", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
