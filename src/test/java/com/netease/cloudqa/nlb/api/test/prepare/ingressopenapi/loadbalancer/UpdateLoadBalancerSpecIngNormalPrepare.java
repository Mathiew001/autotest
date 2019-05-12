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
 * @version $Id: UpdateLoadBalancerSpecIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateLoadBalancerSpecIngNormalPrepare extends BasePrepare {

    //netflow mix实例更改带宽
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 2,\n" +
                "          \"ChargeMode\": \"netflow\",\n" +
                "          \"Size\": \"" + size + "\",\n" +
                "          \"ChargeType\": \"hour\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\","
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec netflow mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidth mix实例更改带宽
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 2,\n" +
                "          \"ChargeMode\": \"bandwidth\",\n" +
                "          \"Size\": \"" + size + "\",\n" +
                "          \"ChargeType\": \"hour\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec bandwidth mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal002", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //netflow vpc_mix实例更改带宽
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 2,\n" +
                "          \"ChargeMode\": \"netflow\",\n" +
                "          \"Size\": \"" + size + "\",\n" +
                "          \"ChargeType\": \"hour\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\","
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec netflow vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidth vpc_mix实例更改带宽
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\n" +
                "        \"Standard\": {\n" +
                "          \"BandwidthLimit\": 2,\n" +
                "          \"ChargeMode\": \"bandwidth\",\n" +
                "          \"Size\": \"" + size + "\",\n" +
                "          \"ChargeType\": \"hour\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\","
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec bandwidth vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal005", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix转包年包月
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"bandwidth\", " +
                "\"ChargeType\":\"month\", \"Period\":1, \"Size\":\"" + size + "\"}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\","
                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "change to package month mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal002", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix转包年包月
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\"Standard\":{\"BandwidthLimit\":1, \"ChargeMode\":\"bandwidth\", " +
                "\"ChargeType\":\"month\", \"Period\":1, \"Size\":\"" + size + "\"}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\","
                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "change to package month vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal005", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix包年包月升配
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\"Standard\":{\"BandwidthLimit\":2, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\", \"Size\":\"" + size + "\"}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\","
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec package month mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix包年包月升配
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\"Standard\":{\"BandwidthLimit\":2, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\", \"Size\":\"" + size + "\"}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\","
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec package month vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix包年包月autoRenew
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":1}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\","
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":1, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "autorenew package month mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix包年包月autoRenew
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":1}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\","
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":1, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "autorenew package month vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix包年包月autoRenew=0
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":0}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\","
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "autorenew package month mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix包年包月autoRenew=0
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":0}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\","
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "autorenew package month vpc_mix ing", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

//    //带订单netflow mix实例更改带宽
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal009() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\"CreateBody\": {\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test description\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"netflow\"\n" +
//                "    }\n" +
//                "}, " +
//                "\"OrderBody\": {" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"FLOW\",\n" +
//                "            \"bandwidth\": 5\n" +
//                "    },\n" +
//                "    \"PayType\":\"PostPaid\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}}";
//        String updateBody = "{\n" +
//                "        \"Standard\": {\n" +
//                "          \"BandwidthLimit\": 5,\n" +
//                "          \"ChargeMode\": \"netflow\",\n" +
//                "          \"ChargeType\": \"hour\"\n" +
//                "        }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\", "
//                + "\"BandwidthLimit\":5, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal009", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec netflow mix ing with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngressAndUpdateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), "CleanMethodInvokerUtils.cleanIngress", null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //有订单bandwidth mix实例更改带宽
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal010() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\"CreateBody\": {\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test description\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }\n" +
//                "}, " +
//                "\"OrderBody\": {" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 5\n" +
//                "    },\n" +
//                "    \"PayType\":\"PostPaid\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}}";
//        String updateBody = "{\n" +
//                "        \"Standard\": {\n" +
//                "          \"BandwidthLimit\": 5,\n" +
//                "          \"ChargeMode\": \"bandwidth\",\n" +
//                "          \"ChargeType\": \"hour\"\n" +
//                "        }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", "
//                + "\"BandwidthLimit\":5, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal010", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec bandwidth mix ing with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngressAndUpdateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), "CleanMethodInvokerUtils.cleanIngress", null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //有订单netflow vpc_mix实例更改带宽
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal011() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\"CreateBody\": {\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test description\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"netflow\"\n" +
//                "    }, \n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}, " +
//                "\"OrderBody\": {" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"FLOW\",\n" +
//                "            \"bandwidth\": 5\n" +
//                "    },\n" +
//                "    \"PayType\":\"PostPaid\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}}";
//        String updateBody = "{\n" +
//                "        \"Standard\": {\n" +
//                "          \"BandwidthLimit\": 5,\n" +
//                "          \"ChargeMode\": \"netflow\",\n" +
//                "          \"ChargeType\": \"hour\"\n" +
//                "        }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\", "
//                + "\"BandwidthLimit\":5, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal011", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec netflow vpc_mix ing with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngressAndUpdateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), "CleanMethodInvokerUtils.cleanIngress", null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //有订单bandwidth vpc_mix实例更改带宽
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal012() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\"CreateBody\": {\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test description\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }, \n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}, " +
//                "\"OrderBody\": {" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 5\n" +
//                "    },\n" +
//                "    \"PayType\":\"PostPaid\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}}";
//        String updateBody = "{\n" +
//                "        \"Standard\": {\n" +
//                "          \"BandwidthLimit\": 5,\n" +
//                "          \"ChargeMode\": \"bandwidth\",\n" +
//                "          \"ChargeType\": \"hour\"\n" +
//                "        }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", "
//                + "\"BandwidthLimit\":5, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal012", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec bandwidth vpc_mix ing with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngressAndUpdateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), "CleanMethodInvokerUtils.cleanIngress", null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //有订单mix转包年包月
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal013() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\"CreateBody\": {\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test description\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }\n" +
//                "}, " +
//                "\"OrderBody\": {" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 1\n" +
//                "    },\n" +
//                "    \"PayType\":\"PrePay\",\n" +
//                "    \"Period\": 1,\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}}";
//        String updateBody = "{\n" +
//                "        \"Standard\": {\n" +
//                "          \"BandwidthLimit\": 1,\n" +
//                "          \"ChargeMode\": \"bandwidth\",\n" +
//                "          \"Period\": 1,\n" +
//                "          \"ChargeType\": \"month\"\n" +
//                "        }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", "
//                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal013", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "change to package month mix ing with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngressAndUpdateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), "CleanMethodInvokerUtils.cleanIngress", null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //有订单vpc_mix转包年包月
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal014() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\"CreateBody\": {\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test description\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"hour\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }, \n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}, " +
//                "\"OrderBody\": {" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 1\n" +
//                "    },\n" +
//                "    \"Period\": 1,\n" +
//                "    \"PayType\":\"PrePay\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}}";
//        String updateBody = "{\n" +
//                "        \"Standard\": {\n" +
//                "          \"BandwidthLimit\": 1,\n" +
//                "          \"ChargeMode\": \"bandwidth\",\n" +
//                "          \"Period\": 1,\n" +
//                "          \"ChargeType\": \"month\"\n" +
//                "        }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", "
//                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal014", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "change to package month of vpc_mix ing with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngressAndUpdateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), "CleanMethodInvokerUtils.cleanIngress", null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //带订单mix包年包月升配
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal015() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\"CreateBody\": {\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test description\",\n" +
//                "    \"Type\": \"mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"month\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"Period\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }\n" +
//                "}, " +
//                "\"OrderBody\": {" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 2\n" +
//                "    },\n" +
//                "    \"PayType\":\"PrePay\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}}";
//        String updateBody = "{\n" +
//                "        \"Standard\": {\n" +
//                "          \"BandwidthLimit\": 2,\n" +
//                "          \"ChargeMode\": \"bandwidth\",\n" +
//                "          \"ChargeType\": \"month\"\n" +
//                "        }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", "
//                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal015", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "update package month of mix ing with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngressAndUpdateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), "CleanMethodInvokerUtils.cleanIngress", null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //带订单vpc_mix包年包月升配
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal016() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        String prepareBody = "{\"CreateBody\": {\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Description\" : \"test description\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"public\",\n" +
//                "    \"Standard\": {\n" +
//                "      \"ChargeType\": \"month\",\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"Period\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\"\n" +
//                "    }, \n" +
//                "    \"VpcId\": \"" + vpcId + "\",\n" +
//                "    \"TopAzInfos\": [\n" +
//                "        {\n" +
//                "            \"TopAz\": \"" + topAz + "\",\n" +
//                "            \"SubNetId\": \"" + subNetId + "\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}, " +
//                "\"OrderBody\": {" +
//                "    \"Service\":\"ING\",\n" +
//                "    \"RegionId\":\"" + region + "\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 2\n" +
//                "    },\n" +
//                "    \"PayType\":\"PrePay\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}}";
//        String updateBody = "{\n" +
//                "        \"Standard\": {\n" +
//                "          \"BandwidthLimit\": 2,\n" +
//                "          \"ChargeMode\": \"bandwidth\",\n" +
//                "          \"ChargeType\": \"month\"\n" +
//                "        }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", "
//                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal016", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "update package month of vpc_mix ing with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngressAndUpdateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), "CleanMethodInvokerUtils.cleanIngress", null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //netflow idc_vpc_mix实例更改带宽
//    @CaseLabel(lbType = { "idc_vpc_mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder updateLoadBalancerSpecNormal017() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String namespace = ConfigLoader.configration.getExtConfig("namespace");
//
//        //set request body
//        String prepareBody = "{\n" +
//                "    \"Name\": \"" + name + "\",\n" +
//                "    \"Namespace\": \"" + namespace + "\",\n" +
//                "    \"Description\" : \"test description\",\n" +
//                "    \"Type\": \"vpc_mix\",\n" +
//                "    \"Network\": \"idc\",\n" +
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
//        String updateBody = "{\n" +
//                "        \"Standard\": {\n" +
//                "          \"BandwidthLimit\": 2,\n" +
//                "          \"ChargeMode\": \"netflow\",\n" +
//                "          \"ChargeType\": \"hour\"\n" +
//                "        }\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\","
//                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal017", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "updatespec netflow idc_vpc_mix ing", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
//        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareIngressAndUpdateOrder", null));
//        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), "CleanMethodInvokerUtils.cleanIngress", null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
}
