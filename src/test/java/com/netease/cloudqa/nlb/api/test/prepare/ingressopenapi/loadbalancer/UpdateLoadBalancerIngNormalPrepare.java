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
 * @version $Id: UpdateLoadBalancerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateLoadBalancerIngNormalPrepare extends BasePrepare {

    //mix实例更新
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test", null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix实例更新
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test", null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //idc_vpc_mix实例更新
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder updateLoadBalancerNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"idc\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    },\n" +
                "    \"VpcId\": \"" + vpcId + "\",\n" +
                "    \"TopAzInfos\": [\n" +
                "        {\n" +
                "            \"TopAz\": \"" + topAz + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        String executeBody = "{\n" +
                "\t\"Description\": \"test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of idc_vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngress", null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), "CleanMethodInvokerUtils.cleanIngress", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
