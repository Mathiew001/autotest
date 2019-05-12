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
 * @version $Id: CheckLoadBalancerParamsIngAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CheckLoadBalancerParamsAbnormalPrepare extends BasePrepare {

    //name参数为空
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "";
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth",
            "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"name\", \"Message\":\"invalid vip name format!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数非法, 长度>100
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxya";
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth",
            "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"name\", \"Message\":\"invalid vip name format!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name参数重复
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder checkLoadBalancerParamsAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qanotdelete";
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth",
            "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"name :qanotdelete already exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //type参数非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "abcd", "bandwidth",
            "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"type\", \"Message\":\"invalid loadbalancer type!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createLoadBalancerAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal type", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //network参数非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "abcd", "mix", "bandwidth",
            "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"network\", \"Message\":\"invalid network type!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal network", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeType参数非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth",
            "abcd", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"chargeType\", \"Message\":\"invalid chargeType! chargeType should be hour|month|year!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal chargeType", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //chargeMode参数非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "abcd", "hour",
            1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"chargeMode\", \"Message\":\"invalid chargeMode! chargeMode should be bandwidth or netflow!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal chargeMode", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthLimit参数非法, bandwidthLimit<0
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "netflow",
            "hour", -1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"bandwidthLimit\", \"Message\":\"invalid bandwidthLimit! bandwidthLimit should be between not null and between 0 and 1000!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal bandwidthLimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidthLimit参数非法, bandwidthLimit>1000
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder checkLoadBalancerParamsAbnormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "netflow",
            "hour", 1001);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"bandwidthLimit\", \"Message\":\"invalid bandwidthLimit! bandwidthLimit should be between not null and between 0 and 1000!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal bandwidthLimit", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //description > 200
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmno" +
                        "pqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqr" +
                        "stuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1", "public", "mix",
                "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"description\", \"Message\":\"description length too long!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal description", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //period 非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth",
            "hour", 1, 0, 0);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Location\":\"period\", \"Message\":\"invalid period! period should be greater than 1!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //autorenewPeriod 非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsAbnormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth",
            "hour", 1, 1, -1);
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Location\":\"autoRenewPeriod\",\"Message\":\"invalid autoRenewPeriod! autoRenewPeriod should be greater than 0 !\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal autoRenewPeriod", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //subnet 非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
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
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "bandwidth",
            "month", 1, vpcId, topAz, "abcd", securityGroups);
        //set response message
        String resMsg = "{\"Code\":\"NotFound\", \"Message\":\"subnet not found\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "checkLoadBalancerParamsAbnormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "check lb with illegal subnet", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
