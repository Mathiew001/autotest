package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer;

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
 * @version $Id: DeleteLoadBalancerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class DeleteLoadBalancerNormalPrepare extends BasePrepare {

    //删除按量netflow mix类型负载均衡
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix",
                "netflow", "hour", 1);
        //set response message
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete netflow mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除按量bandwidth mix类型负载均衡
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix",
                "bandwidth", "hour", 1);
        //set response message
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete bandwidth mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除按量public vpc_mix类型负载均衡
    @CaseLabel(lbType = {"vpc_mix"})
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
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "netflow",
                "hour", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete vpc_mix public lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除按量public vpc_mix类型负载均衡
    @CaseLabel(lbType = {"vpc_mix"})
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
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "bandwidth",
                "hour", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete vpc_mix public lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除按量private vpc_mix类型负载均衡
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLoadBalancerNormal005() {
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
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "private", "vpc_mix", "netflow",
                "hour", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLoadBalancerNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete vpc_mix private lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
