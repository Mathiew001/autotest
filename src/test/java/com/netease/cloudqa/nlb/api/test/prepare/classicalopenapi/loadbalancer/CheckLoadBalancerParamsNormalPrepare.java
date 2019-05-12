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
 * @version $Id: CheckLoadBalancerParamsIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CheckLoadBalancerParamsNormalPrepare extends BasePrepare {

    //mix check
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix",
                "bandwidth", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix check
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix",
                "netflow", "hour", 1);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix check
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix",
                "bandwidth", "month", 1);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //dns check
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal004() {
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
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "private", "vpc_mix", "bandwidth",
                "hour", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix check
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal005() {
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
                "hour", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix check
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal006() {
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
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "netflow",
                "hour", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix check
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal007() {
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
                "month", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //idc_vpc_mix check
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal008() {
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
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "idc", "vpc_mix", "bandwidth",
                "hour", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //idc_vpc_mix check
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal009() {
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
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "idc", "vpc_mix", "bandwidth",
                "hour", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //idc_vpc_mix check
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal010() {
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
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "idc", "vpc_mix", "netflow",
                "hour", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //idc_vpc_mix check
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder checkLoadBalancerParamsNormal011() {
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
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "idc", "vpc_mix", "bandwidth",
                "month", 1, vpcId, topAz, subNetId, securityGroups);
        //set response message
        String resMsg = "{\"Code\":200, \"Message\":\"success\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "checkLoadBalancerParamsNormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "check lb of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
