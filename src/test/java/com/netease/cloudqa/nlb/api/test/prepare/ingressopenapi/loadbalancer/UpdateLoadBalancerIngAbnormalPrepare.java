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
 * @version $Id: UpdateLoadBalancerIngAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateLoadBalancerIngAbnormalPrepare extends BasePrepare {

    //namespace不存在
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Namspace not found.\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix ing, namespace illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), "abcd", null));
        DataUnits.add(new DataUnit("name", String.class.toString(), "abcd", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name不存在
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body

        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"No found resource.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix ing, name illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("name", String.class.toString(), "abcdabcd", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //namespace不存在
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Namspace not found.\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix ing, namespace illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), "abcd", null));
        DataUnits.add(new DataUnit("name", String.class.toString(), "abcd", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name不存在
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body

        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"No found resource.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix ing, name illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        DataUnits.add(new DataUnit("name", String.class.toString(), "abcdabcd", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
