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
 * @version $Id: CheckLoadBalancerParamsIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CheckLoadBalancerParamsIngNormalPrepare extends BasePrepare {

    //mix check
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String executeBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix check
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String executeBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix check
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String executeBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"month\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //vpc_mix check
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup1 = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroup2 = ConfigLoader.configration.getExtConfig("security_group2");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String executeBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
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
                "    ],\n" +
                "    \"SecurityGroups\": [\n" +
                "        \"" + securityGroup1 + "\",\n" +
                "        \"" + securityGroup2 + "\"\n" +
                "    ]\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix check
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup1 = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroup2 = ConfigLoader.configration.getExtConfig("security_group2");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String executeBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    },\n" +
                "    \"VpcId\": \"" + vpcId + "\",\n" +
                "    \"TopAzInfos\": [\n" +
                "        {\n" +
                "            \"TopAz\": \"" + topAz + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"SecurityGroups\": [\n" +
                "        \"" + securityGroup1 + "\",\n" +
                "        \"" + securityGroup2 + "\"\n" +
                "    ]\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix check
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup1 = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroup2 = ConfigLoader.configration.getExtConfig("security_group2");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String executeBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"month\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\",\n" +
                "      \"Period\": 1\n" +
                "    },\n" +
                "    \"VpcId\": \"" + vpcId + "\",\n" +
                "    \"TopAzInfos\": [\n" +
                "        {\n" +
                "            \"TopAz\": \"" + topAz + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"SecurityGroups\": [\n" +
                "        \"" + securityGroup1 + "\",\n" +
                "        \"" + securityGroup2 + "\"\n" +
                "    ]\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //idc_vpc_mix check
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup1 = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroup2 = ConfigLoader.configration.getExtConfig("security_group2");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String executeBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
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
                "    ],\n" +
                "    \"SecurityGroups\": [\n" +
                "        \"" + securityGroup1 + "\",\n" +
                "        \"" + securityGroup2 + "\"\n" +
                "    ]\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check idc_vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //idc_vpc_mix check
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup1 = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroup2 = ConfigLoader.configration.getExtConfig("security_group2");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String executeBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    },\n" +
                "    \"VpcId\": \"" + vpcId + "\",\n" +
                "    \"TopAzInfos\": [\n" +
                "        {\n" +
                "            \"TopAz\": \"" + topAz + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"SecurityGroups\": [\n" +
                "        \"" + securityGroup1 + "\",\n" +
                "        \"" + securityGroup2 + "\"\n" +
                "    ]\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check idc_vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //idc_vpc_mix check
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup1 = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroup2 = ConfigLoader.configration.getExtConfig("security_group2");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String executeBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"month\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\",\n" +
                "      \"Period\": 1\n" +
                "    },\n" +
                "    \"VpcId\": \"" + vpcId + "\",\n" +
                "    \"TopAzInfos\": [\n" +
                "        {\n" +
                "            \"TopAz\": \"" + topAz + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"SecurityGroups\": [\n" +
                "        \"" + securityGroup1 + "\",\n" +
                "        \"" + securityGroup2 + "\"\n" +
                "    ]\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check idc_vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
