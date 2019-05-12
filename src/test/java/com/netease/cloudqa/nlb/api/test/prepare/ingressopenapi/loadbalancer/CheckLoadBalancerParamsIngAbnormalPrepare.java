package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.loadbalancer;

import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author chentianyu1
 * @version $Id: CheckLoadBalancerParamsIngAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CheckLoadBalancerParamsIngAbnormalPrepare extends BasePrepare {

    //name参数为空
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "";
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
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid lbName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name > 100
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxya";
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
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid lbName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, name > 100", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //name参数重复
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder checkLoadBalancerParamsAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qanotdelete";
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
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"name :qanotdelete already exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //type参数非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal004() {
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
                "    \"Type\": \"abcd\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Invalid type: abcd\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, type illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //network参数非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal005() {
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
                "    \"Network\": \"abcd\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Invalid network: abcd\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, network illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //chargeType参数非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal006() {
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
                "      \"ChargeType\": \"abcd\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"Invalid chargeType: abcd\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, chargeType illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeMode参数非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal007() {
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
                "      \"ChargeMode\": \"abcd\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid chargeMode.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, chargeType illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthLimit参数非法, bandwidthLimit<0
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal008() {
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
                "      \"BandwidthLimit\": -1,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid bandwidthLimit. -1, maxBandwidth:1000\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, bandwidth illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthLimit参数非法, bandwidthLimit>1000
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal009() {
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
                "      \"BandwidthLimit\": 1001,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid bandwidthLimit. 1001, maxBandwidth:1000\"\n" +
                "}";;

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, bandwidth illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //description > 100
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String executeBody = "{\n" +
                "    \"Name\": \"" + name + "\",\n" +
                "    \"Namespace\": \"" + namespace + "\",\n" +
                "    \"Description\" : \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu" +
                "vwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxya" +
                "bcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxya\",\n" +
                "    \"Type\": \"mix\",\n" +
                "    \"Network\": \"public\",\n" +
                "    \"Standard\": {\n" +
                "      \"ChargeType\": \"hour\",\n" +
                "      \"BandwidthLimit\": 1,\n" +
                "      \"ChargeMode\": \"bandwidth\"\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid description.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, description illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //period 非法
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder checkLoadBalancerParamsAbnormal011() {
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
                "      \"ChargeMode\": \"bandwidth\",\n" +
                "      \"Period\": 10\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid description.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, period illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //autorenewPeriod 非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal012() {
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
                "      \"ChargeMode\": \"bandwidth\",\n" +
                "      \"Period\": 10,\n" +
                "      \"AutoRenewPeriod\": -1,\n" +
                "    }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid autoRenewPeriod! autoRenewPeriod should be greater than 0 !\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, autorenewPeriod illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //topaz 非法
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder checkLoadBalancerParamsAbnormal013() {
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
                "            \"TopAz\": \"" + "abcd" + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"NotFound\", \"Message\":\"subnet not found\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, topaz illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpcId 非法
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal014() {
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
                "    \"VpcId\": \"" + "abcd" + "\",\n" +
                "    \"TopAzInfos\": [\n" +
                "        {\n" +
                "            \"TopAz\": \"" + subNetId + "\",\n" +
                "            \"SubNetId\": \"" + subNetId + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"NotFound\", \"Message\":\"no found service security group\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsAbnormal014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "Check ing params, vpcId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("cleanMethod", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
