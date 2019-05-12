package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer;

import java.util.ArrayList;
import java.util.List;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import org.testng.annotations.Test;

import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

/**
 *
 * @author chentianyu1
 * @version $Id: GetLoadBalancers.java, v 0.1 Apr 25, 2018 10:26:48 AM chentianyu1n Exp $
 */
@Test
public class GetLoadBalancersAbnormalPrepare extends BasePrepare {

    //type参数非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Code\": \"BadRequest\",\"Message\": \"Bad request with type!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, type=abcd", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("type", String.class.toString(), "abcd", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //limit参数非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Code\": \"BadRequest\",\"Message\": \"Bad request with Offset or Limit\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, limit=-1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("type", String.class.toString(), "mix", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "-1", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //offset参数非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Code\": \"BadRequest\",\"Message\": \"Bad request with Offset or Limit\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, offset=-1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("type", String.class.toString(), "mix", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "-1", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tenantId参数非法
    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Tenant initialization failed\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb list, illegal tenantId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), "abcd", null));
        DataUnits.add(new DataUnit("type", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
