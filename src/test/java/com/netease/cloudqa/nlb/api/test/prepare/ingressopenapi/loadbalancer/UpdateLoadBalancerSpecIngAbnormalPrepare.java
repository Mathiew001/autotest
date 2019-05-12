package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.loadbalancer;

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
public class UpdateLoadBalancerSpecIngAbnormalPrepare extends BasePrepare {

    //流量转包月
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder updateLoadBalancerSpecAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"Period\": 1,\n" +
                "          \"ChargeMode\": \"bandwidth\",\n" +
                "          \"ChargeType\": \"month\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"checkOrderDetail error\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "netflow turn to package month", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeMode非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"Period\": 1,\n" +
                "          \"ChargeMode\": \"abcd\",\n" +
                "          \"ChargeType\": \"month\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid chargeMode.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal chargeMode", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal002", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeType非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"ChargeMode\": \"netflow\",\n" +
                "          \"ChargeType\": \"abcd\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid chargeType: abcd\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal chargeType", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal002", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthlimit非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": -1,\n" +
                "          \"ChargeMode\": \"netflow\",\n" +
                "          \"ChargeType\": \"hour\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid bandwidthLimit. -1, maxBandwidth:1000\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal bandwidthlimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal002", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthlimit非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecAbnormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 1001,\n" +
                "          \"ChargeMode\": \"netflow\",\n" +
                "          \"ChargeType\": \"hour\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid bandwidthLimit. 1001, maxBandwidth:1000\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal bandwidthlimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal002", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //period非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecAbnormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\", \"Period\":10}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter Period cannot accept value 10.\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal002", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //流量转包月
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder updateLoadBalancerSpecAbnormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"Period\": 1,\n" +
                "          \"ChargeMode\": \"bandwidth\",\n" +
                "          \"ChargeType\": \"month\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"checkOrderDetail error\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "netflow turn to package month", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeMode非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecAbnormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"Period\": 1,\n" +
                "          \"ChargeMode\": \"abcd\",\n" +
                "          \"ChargeType\": \"month\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid chargeMode.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal chargeMode", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeType非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecAbnormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"ChargeMode\": \"netflow\",\n" +
                "          \"ChargeType\": \"abcd\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid chargeType: abcd\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal chargeType", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthlimit非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecAbnormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": -1,\n" +
                "          \"ChargeMode\": \"netflow\",\n" +
                "          \"ChargeType\": \"hour\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid bandwidthLimit. -1, maxBandwidth:1000\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal bandwidthlimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthlimit非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecAbnormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 1001,\n" +
                "          \"ChargeMode\": \"netflow\",\n" +
                "          \"ChargeType\": \"hour\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid bandwidthLimit. 1001, maxBandwidth:1000\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal bandwidthlimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //period非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecAbnormal013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\", \"Period\":10}}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter Period cannot accept value 10.\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecAbnormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb, illegal period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal005", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
