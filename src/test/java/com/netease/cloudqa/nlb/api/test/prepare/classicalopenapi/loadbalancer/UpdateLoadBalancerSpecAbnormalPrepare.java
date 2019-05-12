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
 * @version $Id: UpdateLoadBalancerSpecIngAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateLoadBalancerSpecAbnormalPrepare extends BasePrepare {

    //流量转包月
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\", \"Period\":1}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"checkOrderDetail error\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "netflow turn to package month", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeMode非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"abcd\", \"ChargeType\":\"month\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid chargeMode!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal chargeMode", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeType非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"netflow\", \"ChargeType\":\"abcd\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid chargeType! chargeType should be year|month|hour!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal chargeType", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthlimit非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1001, \"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid bandwidthLimit! bandwidthLimit should be between not null and between 0 and 1000!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal bandwidthlimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthlimit非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":-1, \"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid bandwidthLimit! bandwidthLimit should be between not null and between 0 and 1000!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal bandwidthlimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //autoRenewPeriod非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":-1}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter AutoRenewPeriod cannot accept value -1\\\"}\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //autoRenewPeriod非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":10}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter AutoRenewPeriod cannot accept value 10\\\"}\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //流量转包月,vpc_mix
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\", \"Period\":1}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"checkOrderDetail error\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "netflow turn to package month of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeMode非法,vpc_mix
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"abcd\", \"ChargeType\":\"hour\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid chargeMode!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal chargeMode of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeType非法,vpc_mix
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"netflow\", \"ChargeType\":\"abcd\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid chargeType! chargeType should be year|month|hour!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal chargeType of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthlimit非法,vpc_mix
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1001, \"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid bandwidthLimit! bandwidthLimit should be between not null and between 0 and 1000!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal bandwidthlimit of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthlimit非法,vpc_mix
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":-1, \"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid bandwidthLimit! bandwidthLimit should be between not null and between 0 and 1000!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal bandwidthlimit of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //autoRenewPeriod非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal014() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":-1}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter AutoRenewPeriod cannot accept value -1\\\"}\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //autoRenewPeriod非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":10}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter AutoRenewPeriod cannot accept value 10\\\"}\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //流量转包月, vpc_l4
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal016() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\", \"Period\":1}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"checkOrderDetail error\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "netflow turn to package month of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeMode非法,vpc_l4
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal0017() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"abcd\", \"ChargeType\":\"hour\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid chargeMode!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal chargeMode of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeType非法,vpc_l4
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal018() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"netflow\", \"ChargeType\":\"abcd\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid chargeType! chargeType should be year|month|hour!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal chargeType of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthlimit非法,vpc_l4
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal019() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1001, \"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid bandwidthLimit! bandwidthLimit should be between not null and between 0 and 1000!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal bandwidthlimit of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthlimit非法,vpc_l4
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal020() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":-1, \"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\"}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid bandwidthLimit! bandwidthLimit should be between not null and between 0 and 1000!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal bandwidthlimit of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
