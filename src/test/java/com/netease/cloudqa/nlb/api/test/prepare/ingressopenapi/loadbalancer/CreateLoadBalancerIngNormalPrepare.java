/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
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
 * @version $Id: CreateLoadBalancerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CreateLoadBalancerIngNormalPrepare extends BasePrepare {

    //创建按量netflow mix实例
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        //String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String name = "qa-test-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test cty\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"Size\": \"" + size + "\",\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create netflow mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建按量bandwidth mix实例
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        //String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String name = "qa-test-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test cty\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"Size\": \"" + size + "\",\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //创建包年包月mix实例
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        //String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String name = "qa-test-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test cty\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"month\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"Size\": \"" + size + "\",\n" +
                "      \"ChargeMode\": \"bandwidth\",\n" +
                "      \"AutoRenewPeriod\": 1, \n" +
                "      \"Period\": 1\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":1, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create package month mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //创建按量netflow vpc_mix实例
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
        //set instance name
        //String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String name = "qa-test-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test cty\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"Size\": \"" + size + "\",\n" +
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
                "        \"" + securityGroup + "\"\n" +
                "    ]" +
                "}";

        //set response message
        String resMsg = "{\n" +
                "    \"Status\": \"CREATING\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Description\": \"test cty\",\n" +
                "    \"TopAzInfos\": [\n" +
                "        {\n" +
                "            \"TopAz\": \"" + topAz + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"VpcId\": \"" + vpcId + "\",\n" +
                "    \"SecurityGroups\": [\n" +
                "        \"" + securityGroup + "\",\n" +
                "        \"" + securityGroupDefault + "\"\n" +
                "    ],\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
                "    \"Standard\": {\n" +
                "        \"ChargeMode\": \"netflow\",\n" +
                "        \"ChargeType\": \"AMOUNT\",\n" +
                "        \"BandwidthLimit\": 1,\n" +
                "        \"Size\": \"" + size + "\",\n" +
                "        \"AutoRenewPeriod\": 0\n" +
                "    }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create netflow vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidth vpc_mix实例
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
        //set instance name
        //String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String name = "qa-test-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test cty\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"Size\": \"" + size + "\",\n" +
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
                "        \"" + securityGroup + "\"\n" +
                "    ]" +
                "}";

        //set response message
        String resMsg = "{\n" +
                "    \"Status\": \"CREATING\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Description\": \"test cty\",\n" +
                "    \"TopAzInfos\": [\n" +
                "        {\n" +
                "            \"TopAz\": \"" + topAz + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"VpcId\": \"" + vpcId + "\",\n" +
                "    \"SecurityGroups\": [\n" +
                "        \"" + securityGroup + "\",\n" +
                "        \"" + securityGroupDefault + "\"\n" +
                "    ],\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
                "    \"Standard\": {\n" +
                "        \"ChargeMode\": \"bandwidth\",\n" +
                "        \"ChargeType\": \"AMOUNT\",\n" +
                "        \"BandwidthLimit\": 1,\n" +
                "        \"Size\": \"" + size + "\",\n" +
                "        \"AutoRenewPeriod\": 0\n" +
                "    }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建包年包月vpc_mix实例
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
        //set instance name
        //String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String name = "qa-test-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test cty\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"month\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"Size\": \"" + size + "\",\n" +
                "      \"ChargeMode\": \"bandwidth\",\n" +
                "      \"AutoRenewPeriod\": 2, \n" +
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
                "        \"" + securityGroup + "\"\n" +
                "    ]" +
                "}";

        //set response message
        String resMsg = "{\n" +
                "    \"Status\": \"CREATING\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Description\": \"test cty\",\n" +
                "    \"TopAzInfos\": [\n" +
                "        {\n" +
                "            \"TopAz\": \"" + topAz + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"VpcId\": \"" + vpcId + "\",\n" +
                "    \"SecurityGroups\": [\n" +
                "        \"" + securityGroup + "\",\n" +
                "        \"" + securityGroupDefault + "\"\n" +
                "    ],\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
                "    \"Standard\": {\n" +
                "        \"ChargeMode\": \"bandwidth\",\n" +
                "        \"ChargeType\": \"RESERVED\",\n" +
                "        \"BandwidthLimit\": 1,\n" +
                "        \"Size\": \"" + size + "\",\n" +
                "        \"AutoRenewPeriod\": 2\n" +
                "    }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create package month vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建默认standard mix实例
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLoadBalancerNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        //String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String name = "qa-test-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String prepareBody = "{\"OrderBody\":{}}";
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test cty\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\"\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":100, \"AutoRenewPeriod\":0}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create default standard mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建默认securitygroups vpc_mix实例
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
        //set instance name
        //String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String name = "qa-test-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test cty\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "        \"Size\": \"" + size + "\",\n" +
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

        //set response message
        String resMsg = "{\n" +
                "    \"Status\": \"CREATING\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Description\": \"test cty\",\n" +
                "    \"TopAzInfos\": [\n" +
                "        {\n" +
                "            \"TopAz\": \"" + topAz + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"VpcId\": \"" + vpcId + "\",\n" +
                "    \"SecurityGroups\": [\n" +
                "        \"" + securityGroupDefault + "\"\n" +
                "    ],\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
                "    \"Standard\": {\n" +
                "        \"ChargeMode\": \"netflow\",\n" +
                "        \"ChargeType\": \"AMOUNT\",\n" +
                "        \"BandwidthLimit\": 1,\n" +
                "        \"Size\": \"" + size + "\",\n" +
                "        \"AutoRenewPeriod\": 0\n" +
                "    }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create default securityGroups ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

//    //创建按量netflow mix实例, size=nlb.s1.small
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal009() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_small");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 500,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"netflow\"\n" +
//                "    }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":500, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal009", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create netflow mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量netflow mix实例, size=nlb.s2.micro
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancerNormal010() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s2_micro");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1000,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"netflow\"\n" +
//                "    }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":1000, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal010", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create netflow mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth mix实例, size=nlb.s1.small
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal011() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_small");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 20,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":20, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal011", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth mix实例, size=nlb.s1.medium
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal012() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_medium");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 20,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":20, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal012", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth mix实例, size=nlb.s2.micro
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancerNormal013() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s2_micro");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 20,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":20, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal013", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth mix实例, size=nlb.s2.small
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancerNormal014() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s2_small");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 20,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":20, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal014", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量netflow vpc_mix实例, size=nlb.s1.small
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal015() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
//        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_small");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"netflow\"\n" +
//                "    },\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\"\n" +
//                "    ]" +
//                "}";
//
//        //set response message
//        String resMsg = "{\n" +
//                "    \"Status\": \"CREATING\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Description\": \"test cty\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\",\n" +
//                "        \"" + securityGroupDefault + "\"\n" +
//                "    ],\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Standard\": {\n" +
//                "        \"ChargeMode\": \"netflow\",\n" +
//                "        \"ChargeType\": \"AMOUNT\",\n" +
//                "        \"BandwidthLimit\": 1,\n" +
//                "        \"Size\": \"" + size + "\",\n" +
//                "        \"AutoRenewPeriod\": 0\n" +
//                "    }\n" +
//                "}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal015", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create netflow vpc_mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量netflow vpc_mix实例, size=nlb.s2.micro
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancerNormal016() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
//        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s2_micro");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 10,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"netflow\"\n" +
//                "    },\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\"\n" +
//                "    ]" +
//                "}";
//
//        //set response message
//        String resMsg = "{\n" +
//                "    \"Status\": \"CREATING\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Description\": \"test cty\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\",\n" +
//                "        \"" + securityGroupDefault + "\"\n" +
//                "    ],\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Standard\": {\n" +
//                "        \"ChargeMode\": \"netflow\",\n" +
//                "        \"ChargeType\": \"AMOUNT\",\n" +
//                "        \"BandwidthLimit\": 10,\n" +
//                "        \"Size\": \"" + size + "\",\n" +
//                "        \"AutoRenewPeriod\": 0\n" +
//                "    }\n" +
//                "}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal016", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create netflow vpc_mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //bandwidth vpc_mix实例, size=nlb.s1.small
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal017() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
//        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_small");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    },\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\"\n" +
//                "    ]" +
//                "}";
//
//        //set response message
//        String resMsg = "{\n" +
//                "    \"Status\": \"CREATING\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Description\": \"test cty\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\",\n" +
//                "        \"" + securityGroupDefault + "\"\n" +
//                "    ],\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Standard\": {\n" +
//                "        \"ChargeMode\": \"bandwidth\",\n" +
//                "        \"ChargeType\": \"AMOUNT\",\n" +
//                "        \"BandwidthLimit\": 1,\n" +
//                "        \"Size\": \"" + size + "\",\n" +
//                "        \"AutoRenewPeriod\": 0\n" +
//                "    }\n" +
//                "}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal017", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth vpc_mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //bandwidth vpc_mix实例, size=nlb.s1.medium
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal018() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
//        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_medium");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    },\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\"\n" +
//                "    ]" +
//                "}";
//
//        //set response message
//        String resMsg = "{\n" +
//                "    \"Status\": \"CREATING\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Description\": \"test cty\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\",\n" +
//                "        \"" + securityGroupDefault + "\"\n" +
//                "    ],\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Standard\": {\n" +
//                "        \"ChargeMode\": \"bandwidth\",\n" +
//                "        \"ChargeType\": \"AMOUNT\",\n" +
//                "        \"BandwidthLimit\": 1,\n" +
//                "        \"Size\": \"" + size + "\",\n" +
//                "        \"AutoRenewPeriod\": 0\n" +
//                "    }\n" +
//                "}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal018", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth vpc_mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //bandwidth vpc_mix实例, size=nlb.s2.micro
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancerNormal019() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
//        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s2_micro");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    },\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\"\n" +
//                "    ]" +
//                "}";
//
//        //set response message
//        String resMsg = "{\n" +
//                "    \"Status\": \"CREATING\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Description\": \"test cty\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\",\n" +
//                "        \"" + securityGroupDefault + "\"\n" +
//                "    ],\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Standard\": {\n" +
//                "        \"ChargeMode\": \"bandwidth\",\n" +
//                "        \"ChargeType\": \"AMOUNT\",\n" +
//                "        \"BandwidthLimit\": 1,\n" +
//                "        \"Size\": \"" + size + "\",\n" +
//                "        \"AutoRenewPeriod\": 0\n" +
//                "    }\n" +
//                "}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal019", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth vpc_mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //bandwidth vpc_mix实例, size=nlb.s2.small
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancerNormal020() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
//        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String size = ConfigLoader.configration.getExtConfig("size_s2_small");
//        //set request body
//        String body = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"Size\": \"" + size + "\",\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    },\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\"\n" +
//                "    ]" +
//                "}";
//
//        //set response message
//        String resMsg = "{\n" +
//                "    \"Status\": \"CREATING\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Description\": \"test cty\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\",\n" +
//                "        \"" + securityGroupDefault + "\"\n" +
//                "    ],\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Standard\": {\n" +
//                "        \"ChargeMode\": \"bandwidth\",\n" +
//                "        \"ChargeType\": \"AMOUNT\",\n" +
//                "        \"BandwidthLimit\": 1,\n" +
//                "        \"Size\": \"" + size + "\",\n" +
//                "        \"AutoRenewPeriod\": 0\n" +
//                "    }\n" +
//                "}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal020", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth vpc_mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }


//    //创建有订单按量netflow vpc_mix实例
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal010() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        //set request body
//        String prepareBody = "{\n" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"Standard\":{\n" +
//                "            \"netType\": \"FLOW\",\n" +
//                "            \"bandwidth\": 1\n" +
//                "    },\n" +
//                "    \"Unit\":\"Hour\",\n" +
//                "    \"PayType\": \"PostPaid\",\n" +
//                "    \"Body\": [\"test,test\"],\n" +
//                "    \"NetworkChargeType\": \"PayByTraffic\"\n" +
//                "}";
//        String createBody = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"netflow\"\n" +
//                "    },\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//
//        //set response message
//        String resMsg = "{\n" +
//                "    \"Status\": \"CREATING\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Description\": \"test cty\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroupDefault + "\"\n" +
//                "    ],\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Standard\": {\n" +
//                "        \"ChargeMode\": \"netflow\",\n" +
//                "        \"ChargeType\": \"AMOUNT\",\n" +
//                "        \"BandwidthLimit\": 1,\n" +
//                "        \"AutoRenewPeriod\": 0\n" +
//                "    }\n" +
//                "}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal010", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create netflow vpc_mix ing with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareCreateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建有订单按量bandwidth vpc_mix实例
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal011() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        //set request body
//        String prepareBody = "{\n" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"Standard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 1\n" +
//                "    },\n" +
//                "    \"Unit\":\"Hour\",\n" +
//                "    \"PayType\": \"PostPaid\",\n" +
//                "    \"Body\": [\"test,test\"],\n" +
//                "    \"NetworkChargeType\": \"PayByBandwidth\"\n" +
//                "}";
//        String createBody = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    },\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//
//        //set response message
//        String resMsg = "{\n" +
//                "    \"Status\": \"CREATING\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Description\": \"test cty\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroupDefault + "\"\n" +
//                "    ],\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Standard\": {\n" +
//                "        \"ChargeMode\": \"bandwidth\",\n" +
//                "        \"ChargeType\": \"AMOUNT\",\n" +
//                "        \"BandwidthLimit\": 1,\n" +
//                "        \"AutoRenewPeriod\": 0\n" +
//                "    }\n" +
//                "}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal011", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth vpc_mix ing with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareCreateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建有订单包年包月vpc_mix实例
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal012() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        //set request body
//        String prepareBody = "{\n" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"Standard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 1\n" +
//                "    },\n" +
//                "    \"Unit\":\"Month\",\n" +
//                "    \"PayType\": \"PrePay\",\n" +
//                "    \"Body\": [\"test,test\"],\n" +
//                "    \"NetworkChargeType\": \"PayByBandwidth\",\n" +
//                "    \"Period\": 1\n" +
//                "}";
//        String createBody = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"month\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\",\n" +
//                "      \"Period\": 1\n" +
//                "    },\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//
//        //set response message
//        String resMsg = "{\n" +
//                "    \"Status\": \"CREATING\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Description\": \"test cty\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroupDefault + "\"\n" +
//                "    ],\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Standard\": {\n" +
//                "        \"ChargeMode\": \"bandwidth\",\n" +
//                "        \"ChargeType\": \"RESERVED\",\n" +
//                "        \"BandwidthLimit\": 1,\n" +
//                "        \"AutoRenewPeriod\": 0\n" +
//                "    }\n" +
//                "}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal012", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create package month vpc_mix ing with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareCreateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建有订单按量netflow vpc_mix实例
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal013() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\n" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"Standard\":{\n" +
//                "            \"netType\": \"FLOW\",\n" +
//                "            \"bandwidth\": 1\n" +
//                "    },\n" +
//                "    \"Unit\":\"Hour\",\n" +
//                "    \"PayType\": \"PostPaid\",\n" +
//                "    \"Body\": [\"test,test\"],\n" +
//                "    \"NetworkChargeType\": \"PayByTraffic\"\n" +
//                "}";
//        String createBody = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"netflow\"\n" +
//                "    }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal013", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create netflow mix ing with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareCreateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建有订单按量bandwidth vpc_mix实例
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal014() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\n" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"Standard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 1\n" +
//                "    },\n" +
//                "    \"Unit\":\"Hour\",\n" +
//                "    \"PayType\": \"PostPaid\",\n" +
//                "    \"Body\": [\"test,test\"],\n" +
//                "    \"NetworkChargeType\": \"PayByBandwidth\"\n" +
//                "}";
//        String createBody = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal014", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create bandwidth mix ing with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareCreateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建有订单包年包月 vpc_mix实例
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal015() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\n" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"Standard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 1\n" +
//                "    },\n" +
//                "    \"Unit\":\"Month\",\n" +
//                "    \"PayType\": \"PrePay\",\n" +
//                "    \"Body\": [\"test,test\"],\n" +
//                "    \"NetworkChargeType\": \"PayByBandwidth\",\n" +
//                "    \"Period\":1\n" +
//                "}";
//        String createBody = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"month\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\",\n" +
//                "      \"Period\": 1\n" +
//                "    }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Namespace\": \"" + namespace +"\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
//                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal015", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create package month mix ing with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareCreateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量netflow idc_vpc_mix实例
//    @CaseLabel(lbType = { "idc_vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancerNormal016() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
//        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        //set request body
//        String prepareBody = "{\"OrderBody\":{}}";
//        String createBody = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test cty\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"netflow\"\n" +
//                "    },\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\"\n" +
//                "    ]" +
//                "}";
//
//        //set response message
//        String resMsg = "{\n" +
//                "    \"Status\": \"CREATING\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Description\": \"test cty\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"SecurityGroups\": [\n" +
//                "        \"" + securityGroup + "\",\n" +
//                "        \"" + securityGroupDefault + "\"\n" +
//                "    ],\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"InstanceId\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Id\": \"" + namespace + "@" + name + "\",\n" +
//                "    \"Standard\": {\n" +
//                "        \"ChargeMode\": \"netflow\",\n" +
//                "        \"ChargeType\": \"AMOUNT\",\n" +
//                "        \"BandwidthLimit\": 1,\n" +
//                "        \"AutoRenewPeriod\": 0\n" +
//                "    }\n" +
//                "}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerNormal016", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create netflow idc_vpc_mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }

}
