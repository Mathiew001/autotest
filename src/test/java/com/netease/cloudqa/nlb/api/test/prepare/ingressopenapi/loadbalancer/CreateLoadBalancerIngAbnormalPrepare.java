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
 * @version $Id: CreateLoadBalancerIngAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CreateLoadBalancerIngAbnormalPrepare extends BasePrepare {

    //name参数为空
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "";
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";

        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid lbName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数非法, 长度>24
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxya";
        String namespace = ConfigLoader.configration.getExtConfig("namespace");

        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";

        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid lbName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数非法, 非字母开头
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "1234abcd";
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid lbName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数非法, 非字母或数字结尾
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "abcd%&*";
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid lbName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数非法, 含特殊符号
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "abcd$#@abcd";
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid lbName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数重复
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLoadBalancerAbnormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "\t\"Name\": \"qatest-ing-notdelete\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": 409,\n" +
                "    \"Message\": \"Duplicate loadbalancer name.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //type参数非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"abcd\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Invalid type: abcd\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal type", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //network参数非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"abcd\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Invalid network: abcd\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal network", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeType参数非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"abcd\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Invalid chargeType: abcd\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal chargeType", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeMode参数非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"abcd\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"Invalid chargeMode.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal chargeMode", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthLimit参数非法, bandwidthLimit<0
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": -1,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"Invalid bandwidthLimit. -1, maxBandwidth:1000\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal bandwidthLimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthLimit参数非法, bandwidthLimit>1000
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"test description\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1001,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"Invalid bandwidthLimit. 1001, maxBandwidth:1000\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal bandwidthLimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，vpcId参数为空
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", " +
                "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " +
                "\"" + securityGroups.get(1) + "\"]}";
        //set response message
        String resMsg = "{\"Code\":\"NotFound\", \"Message\": \"no found service security group\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with empty VpcId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，vpcId参数非字符串
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal014() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":123, \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", " +
                "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " +
                "\"" + securityGroups.get(1) + "\"]}";
        //set response message
        String resMsg = "{\"Code\":\"NotFound\", \"Message\": \"no found service security group\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal VpcId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，topAzInfos参数为空
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " +
                "\"" + securityGroups.get(1) + "\"]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with empty TopAzInfos", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，topAzInfos参数长度为0
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal016() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " +
                "\"" + securityGroups.get(1) + "\"], \"TopAzInfos\":[]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal TopAzInfos", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，topAzInfos非数组
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal017() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " +
                "\"" + securityGroups.get(1) + "\"], \"TopAzInfos\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal TopAzInfos", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，topAz参数为空
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal018() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " +
                "\"" + securityGroups.get(1) + "\"], \"TopAzInfos\":[{}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with empty TopAz", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，topAz参数为非字符串
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal019() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " +
                "\"" + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\": 123}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal TopAz", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，subnetId为空
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal020() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " +
                "\"" + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\"}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal SubNetId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，subnetId参数为非字符串
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal021() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " +
                "\"" + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", \"SubNetId\":123}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal021", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal SubNetId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，securitygroups参数非数组
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal022() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":123, " +
                "\"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", \"SubNetId\":\"" + subNetId + "\"}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid securityGroups.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal022", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal SecurityGroups", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，securitygroup参数非字符串
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal023() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":[" + 123 + ", " +
                "" + 231 + "], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", \"SubNetId\":\"" + subNetId + "\"}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid securityGroups.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal023", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal SecurityGroup", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建包月实例无period
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal024() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "        \"Name\": \"" + name + "\",\n" +
                "        \"Description\" : \"test description\",\n" +
                "        \"Type\": \"mix\",\n" +
                "        \"Network\": \"public\",\n" +
                "        \"Standard\": {\n" +
                "          \"ChargeType\": \"month\",\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"ChargeMode\": \"bandwidth\"\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"{\\\"Code\\\":\\\"MissingParameter\\\",\\\"Message\\\":\\\"The required input parameter period for processing this request is not supplied.\\\"}\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal024", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建包月实例, period非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal025() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "        \"Name\": \"" + name + "\",\n" +
                "        \"Description\" : \"test description\",\n" +
                "        \"Type\": \"mix\",\n" +
                "        \"Network\": \"public\",\n" +
                "        \"Standard\": {\n" +
                "          \"ChargeType\": \"month\",\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"ChargeMode\": \"bandwidth\",\n" +
                "          \"Period\": 0,\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter period cannot accept value 0.\\\"}\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal025", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建包月实例, period非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal026() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "        \"Name\": \"" + name + "\",\n" +
                "        \"Description\" : \"test description\",\n" +
                "        \"Type\": \"mix\",\n" +
                "        \"Network\": \"public\",\n" +
                "        \"Standard\": {\n" +
                "          \"ChargeType\": \"month\",\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"ChargeMode\": \"bandwidth\",\n" +
                "          \"Period\": 10,\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter period cannot accept value 10.\\\"}\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal026", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建包月实例, period非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal027() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "        \"Name\": \"" + name + "\",\n" +
                "        \"Description\" : \"test description\",\n" +
                "        \"Type\": \"mix\",\n" +
                "        \"Network\": \"public\",\n" +
                "        \"Standard\": {\n" +
                "          \"ChargeType\": \"month\",\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"ChargeMode\": \"bandwidth\",\n" +
                "          \"Period\": 13,\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter period cannot accept value 13.\\\"}\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal027", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //description > 100
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal028() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Description\" : \"abcdefghijklmnopqrstuvwxyabcdefghijklmno" +
                "pqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwx" +
                "yabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmn" +
                "opqrstuvwxyabcdefghijklmnopqrstuvwxya\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"netflow\"\n" +
                "    }\n" +
                "}";

        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid description.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal028", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with too long description", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建包月实例, autoRenewPeriod非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal029() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "        \"Name\": \"" + name + "\",\n" +
                "        \"Description\" : \"test description\",\n" +
                "        \"Type\": \"mix\",\n" +
                "        \"Network\": \"public\",\n" +
                "        \"Standard\": {\n" +
                "          \"ChargeType\": \"month\",\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"ChargeMode\": \"bandwidth\",\n" +
                "          \"Period\": 1,\n" +
                "          \"AutoRenewPeriod\": 10,\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter autoRenewPeriod cannot accept value 10.\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal029", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建包月实例, autoRenewPeriod非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal030() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "        \"Name\": \"" + name + "\",\n" +
                "        \"Description\" : \"test description\",\n" +
                "        \"Type\": \"mix\",\n" +
                "        \"Network\": \"public\",\n" +
                "        \"Standard\": {\n" +
                "          \"ChargeType\": \"month\",\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"ChargeMode\": \"bandwidth\",\n" +
                "          \"Period\": 1,\n" +
                "          \"AutoRenewPeriod\": 11,\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter autoRenewPeriod cannot accept value 11.\\\"}\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal030", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建包月实例, autoRenewPeriod非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal031() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String createBody = "{\n" +
                "        \"Name\": \"" + name + "\",\n" +
                "        \"Description\" : \"test description\",\n" +
                "        \"Type\": \"mix\",\n" +
                "        \"Network\": \"public\",\n" +
                "        \"Standard\": {\n" +
                "          \"ChargeType\": \"month\",\n" +
                "          \"BandwidthLimit\": 1,\n" +
                "          \"ChargeMode\": \"bandwidth\",\n" +
                "          \"Period\": 1,\n" +
                "          \"AutoRenewPeriod\": -1,\n" +
                "        }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"invalid autoRenewPeriod! autoRenewPeriod should be greater than 0 !\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal031", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing with illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
