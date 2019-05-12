package com.netease.cloudqa.nlb.api.test.prepare.ingressadminapi;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchLoadBalancerIngNormalPrepare extends BasePrepare{

    //adding one more mix type instance and vpc_mix type instance with special names under mix label
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder searchLoadBalancer001(){
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String securityGroup = ConfigLoader.configration.getExtConfig("security_group1");
        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default_ingress");

        //set instance name
        String mix_instance_name = "qa-test-temp-searchlbingnormal-mix";

        //set mix instance request body
        String mix_body = "{\n" +
                "    \"Name\": \"" + mix_instance_name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test fzn SearchLoadBalancerIngNormal mix\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"Size\": \"" + size + "\",\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";
        //set mix instance response message
        String mix_resMsg = "{\"Name\":\"" + mix_instance_name + "\", " +
                "\"Description\":\"test fzn SearchLoadBalancerIngNormal mix\", \"Namespace\": \"" + namespace +"\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        //set vpc_mix instance name
        String vpc_mix_instance_name = "qa-test-temp-searchlbingnormal-vpc-mix";

        //set vpc_mix request body
        String vpc_mix_body = "{\n" +
                "    \"Name\": \"" + vpc_mix_instance_name + "\",\n" +
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
        String vpc_mix_resMsg = "{\n" +
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
                "    \"InstanceId\": \"" + namespace + "@" + vpc_mix_instance_name + "\",\n" +
                "    \"Id\": \"" + namespace + "@" + vpc_mix_instance_name + "\",\n" +
                "    \"Standard\": {\n" +
                "        \"ChargeMode\": \"bandwidth\",\n" +
                "        \"ChargeType\": \"RESERVED\",\n" +
                "        \"BandwidthLimit\": 1,\n" +
                "        \"Size\": \"" + size + "\",\n" +
                "        \"AutoRenewPeriod\": 2\n" +
                "    }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "SearchLoadBalancerIngNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
                "test  SearchLoadBalancer with adding one more mix type instance and vpc_mix with special names under mix case label", null));

        DataUnits.add(new DataUnit("tenantId", String.class.toString(),
                ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("mix_name", String.class.toString(), mix_instance_name, null));
        DataUnits.add(new DataUnit("vpc_mix_name", String.class.toString(), vpc_mix_instance_name, null));
        DataUnits.add(new DataUnit("mix_body", String.class.toString(), mix_body, null));
        DataUnits.add(new DataUnit("vpc_mix_body", String.class.toString(), vpc_mix_body, null));
        DataUnits.add(new DataUnit("mix_resMsg", String.class.toString(), mix_resMsg, null));
        DataUnits.add(new DataUnit("vpc_mix_resMsg", String.class.toString(), vpc_mix_resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
