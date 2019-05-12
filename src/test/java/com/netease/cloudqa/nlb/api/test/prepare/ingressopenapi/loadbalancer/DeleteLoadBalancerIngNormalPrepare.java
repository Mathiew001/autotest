package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
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
 * @version $Id: DeleteLoadBalancerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class DeleteLoadBalancerIngNormalPrepare extends BasePrepare {

    //删除按量netflow mix类型负载均衡
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\",\n" +
                "    }\n" +
                "}";
        String executeBody = "{}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Delete ing of netflow mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngress", null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除按量bandwidth mix类型负载均衡
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\",\n" +
                "    }\n" +
                "}";
        String executeBody = "{}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Delete ing of bandwidth mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngress", null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除按量public vpc_mix类型负载均衡
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerNormal003() {
        DataHolder holder = new DataHolderImpl();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\",\n" +
                "      \"Period\": 1\n" +
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
        String executeBody = "{}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Delete ing of netflow vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngress", null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除按量public vpc_mix类型负载均衡
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerNormal004() {
        DataHolder holder = new DataHolderImpl();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"vpc_mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
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
                "    ]\n" +
                "}";
        //set response message
        String executeBody = "{}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Delete ing of bandwidth vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngress", null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
