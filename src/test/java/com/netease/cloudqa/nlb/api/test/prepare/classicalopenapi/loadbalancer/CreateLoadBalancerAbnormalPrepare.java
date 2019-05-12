package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;

/**
 *
 * @author chentianyu1
 * @version $Id: CreateLoadBalancerIngAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CreateLoadBalancerAbnormalPrepare extends BasePrepare {

    //name参数为空
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "";
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth",
            "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"name\", \"Message\":\"invalid vip name format!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数非法, 长度>24
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxya";
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"name\", \"Message\":\"invalid vip name format!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数非法, 非字母开头
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLoadBalancerAbnormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "1234abcd";
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"name\", \"Message\":\"invalid vip name format!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数非法, 非字母或数字结尾
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "abcd%&*";
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"name\", \"Message\":\"invalid vip name format!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数非法, 含特殊符号
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "abcd$#@abcd";
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"name\", \"Message\":\"invalid vip name format!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数重复
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLoadBalancerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qanotdelete";
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"name :qanotdelete already exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //type参数非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "abcd", "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"type\", \"Message\":\"invalid loadbalancer type!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal type", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //network参数非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "abcd", "mix", "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"network\", \"Message\":\"invalid network type!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal network", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeType参数非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth", "abcd", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"chargeType\", \"Message\":\"invalid chargeType! chargeType should be hour|month|year!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal chargeType", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeMode参数非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "abcd", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"chargeMode\", \"Message\":\"invalid chargeMode! chargeMode should be bandwidth or netflow!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal chargeMode", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthLimit参数非法, bandwidthLimit<0
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "netflow", "hour", -1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"bandwidthLimit\", \"Message\":\"invalid bandwidthLimit! bandwidthLimit should be between not null and between 0 and 1000!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal bandwidthLimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthLimit参数非法, bandwidthLimit>1000
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLoadBalancerAbnormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "netflow", "hour", 1001);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"bandwidthLimit\", \"Message\":\"invalid bandwidthLimit! bandwidthLimit should be between not null and between 0 and 1000!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal bandwidthLimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，vpcId参数为空
    @CaseLabel()
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
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
                      + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
                      + securityGroups.get(0) + "\", " + "\"" + securityGroups.get(1) + "\"]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid vpcId.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with empty VpcId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，vpcId参数非字符串
    @CaseLabel()
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
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"VpcId\":123, \"TopAzInfos\":[{\"TopAz\":\""
                      + topAz + "\", " + "\"SubNetId\":\"" + subNetId
                      + "\"}], \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                      + securityGroups.get(1) + "\"]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid vpcId.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal VpcId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，topAzInfos参数为空
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal015() {
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
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                      + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                      + securityGroups.get(1) + "\"]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with empty TopAzInfos", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，topAzInfos参数长度为0
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal016() {
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
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                      + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                      + securityGroups.get(1) + "\"], \"TopAzInfos\":[]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal TopAzInfos", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，topAzInfos非数组
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLoadBalancerAbnormal017() {
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
        //set request body
        String body = "{\"Name\":\"" + name + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", " +
                "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", " +
                "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " +
                "\"" + securityGroups.get(1) + "\"], \"TopAzInfos\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal TopAzInfos", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，topAz参数为空
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal018() {
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
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                      + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                      + securityGroups.get(1) + "\"], \"TopAzInfos\":[{}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with empty TopAz", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，topAz参数为非字符串
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal019() {
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
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                      + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                      + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\": 123}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal TopAz", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，subnetId为空
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal020() {
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
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                      + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                      + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                      + "\"}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal SubNetId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，subnetId参数为非字符串
    @CaseLabel()
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
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                      + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                      + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                      + "\", \"SubNetId\":123}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid topAzInfos.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal021", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal SubNetId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，securitygroups参数非数组
    @CaseLabel()
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
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                      + "\", \"SecurityGroups\":123, " + "\"TopAzInfos\":[{\"TopAz\":\"" + topAz
                      + "\", \"SubNetId\":\"" + subNetId + "\"}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid securityGroups.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal022", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal SecurityGroups", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix类型，securitygroup参数非字符串
    @CaseLabel()
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
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", \"SecurityGroups\":["
                      + 123 + ", " + "" + 231 + "], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                      + "\", \"SubNetId\":\"" + subNetId + "\"}]}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\": \"Invalid securityGroups.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal023", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal SecurityGroups", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建包月实例无period
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal024() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" + "        \"Name\": \"abcdefg11343\",\n"
                      + "        \"Description\" : \"test description\",\n"
                      + "        \"Type\": \"mix\",\n" + "        \"Network\": \"public\",\n"
                      + "        \"Standard\": {\n" + "          \"ChargeType\": \"month\",\n"
                      + "          \"BandwidthLimit\": 1,\n"
                      + "          \"ChargeMode\": \"bandwidth\"\n" + "        }\n" + "}";
        //set response message
        String resMsg = "{\n"
                        + "    \"Code\": \"BadRequest\",\n"
                        + "    \"Message\": \"{\\\"Code\\\":\\\"MissingParameter\\\",\\\"Message\\\":\\\"The required input parameter period for processing this request is not supplied.\\\"}\"\n"
                        + "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal type", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //autorenewPeriod 非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal025() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" + "        \"Name\": \"abcdefg11343\",\n"
                + "        \"Description\" : \"test description\",\n"
                + "        \"Type\": \"mix\",\n" + "        \"Network\": \"public\",\n"
                + "        \"Standard\": {\n" + "          \"ChargeType\": \"month\",\n"
                + "          \"BandwidthLimit\": 1, \"AutoRenewPeriod\":11, \"Period\":1, \n"
                + "          \"ChargeMode\": \"bandwidth\"\n" + "        }\n" + "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter autoRenewPeriod cannot accept value 11.\\\"}\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal025", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //autorenewPeriod 非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal026() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" + "        \"Name\": \"abcdefg11343\",\n"
                + "        \"Description\" : \"test description\",\n"
                + "        \"Type\": \"mix\",\n" + "        \"Network\": \"public\",\n"
                + "        \"Standard\": {\n" + "          \"ChargeType\": \"month\",\n"
                + "          \"BandwidthLimit\": 1, \"AutoRenewPeriod\":10, \"Period\":1, \n"
                + "          \"ChargeMode\": \"bandwidth\"\n" + "        }\n" + "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"{\\\"Code\\\":\\\"InvalidParameterValue\\\",\\\"Message\\\":\\\"The parameter autoRenewPeriod cannot accept value 10.\\\"}\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal026", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //autorenewPeriod 非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal027() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" + "        \"Name\": \"abcdefg11343\",\n"
                + "        \"Description\" : \"test description\",\n"
                + "        \"Type\": \"mix\",\n" + "        \"Network\": \"public\",\n"
                + "        \"Standard\": {\n" + "          \"ChargeType\": \"month\",\n"
                + "          \"BandwidthLimit\": 1, \"AutoRenewPeriod\":-1, \"Period\":1, \n"
                + "          \"ChargeMode\": \"bandwidth\"\n" + "        }\n" + "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Location\": \"autoRenewPeriod\",\n" +
                "    \"Message\": \"invalid autoRenewPeriod! autoRenewPeriod should be greater than 0 !\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal026", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //network+type参数非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal028() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "private", "http", "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid combination, type: http, network: private, tag: ordinary\"" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal028", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal network+type", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //description > 400
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal029() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name,
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1",
                "public", "mix", "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"description length too long!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal029", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal description", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //month+netflow
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal030() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "netflow", "month", 1);
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Prepayment only allows bandwidth limited mode\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal030", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal chargeMode+chargeType", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //subnet not found
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal031() {
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
        //set request body
        String body = "{\"Name\":\""
                + name
                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                + "\", \"SubNetId\":\"abcd\"}]}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"subnet not found\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal031", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal SubNetId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //version wrong
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal032() {
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
        //set request body
        String body = "{\"Name\":\""
                + name
                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                + "\", \"SubNetId\":\"" + subNetId + "\"}], \"Attrs\":{\"Version\":\"2018-12-07\"}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid attrs.version\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal032", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal version", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //version wrong
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal033() {
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
        //set request body
        String body = "{\"Name\":\""
                + name
                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                + "\", \"SubNetId\":\"" + subNetId + "\"}], \"Attrs\":{\"Version\":\"2018-12-05\"}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid attrs.version\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal033", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal version", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //version wrong
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal034() {
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
        //set request body
        String body = "{\"Name\":\""
                + name
                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                + "\", \"SubNetId\":\"" + subNetId + "\"}], \"Attrs\":{\"Version\":\"abcd\"}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid attrs.version\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal034", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal version", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //Stoptimeout wrong
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal035() {
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
        //set request body
        String body = "{\"Name\":\""
                + name
                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                + "\", \"SubNetId\":\"" + subNetId + "\"}], \"Attrs\":{\"Version\":\"2018-12-06\", \"StopTimeout\":-1}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid attrs.stopTimeout\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal035", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal stoptimeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //UseSSLAcc wrong
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal036() {
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
        //set request body
        String body = "{\"Name\":\""
                + name
                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                + "\", \"SubNetId\":\"" + subNetId + "\"}], \"Attrs\":{\"Version\":\"2018-12-06\", \"StopTimeout\":1000, \"UseSSLAcc\":2}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid attrs.useSSLAcc\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal036", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb with illegal UseSSLAcc", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //set stopping time when useSSLAcc=0 no version
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLoadBalancerAbnormal037() {
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
        //set request body
        String body = "{\"Name\":\""
                + name
                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                + "\", \"SubNetId\":\"" + subNetId + "\"}], \"Attrs\":{\"StopTimeout\":1000, \"UseSSLAcc\":0}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid attrs.stopTimeout, not supported in current version\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal037", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "set stopping time when useSSLAcc=0 and no version", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //set stopping time when no useSSLAcc and no version
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLoadBalancerAbnormal038() {
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
        //set request body
        String body = "{\"Name\":\""
                + name
                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                + "\", \"SubNetId\":\"" + subNetId + "\"}], \"Attrs\":{\"StopTimeout\":1000}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid attrs.stopTimeout, not supported in current version\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal038", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "set stopping time when no useSSLAcc and no version", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //set ussSSLACcc=0 when version=2018-12-06
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancerAbnormal039() {
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
        //set request body
        String body = "{\"Name\":\""
                + name
                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId
                + "\", \"SecurityGroups\":[\"" + securityGroups.get(0) + "\", " + "\""
                + securityGroups.get(1) + "\"], \"TopAzInfos\":[{\"TopAz\":\"" + topAz
                + "\", \"SubNetId\":\"" + subNetId + "\"}], \"Attrs\":{\"UseSSLAcc\":0, \"Version\":\"2018-12-06\"}}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid attrs.useSSLAcc, should be 1 or -1\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancerAbnormal039", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "set ussSSLACcc=0 when version=2018-12-06", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
