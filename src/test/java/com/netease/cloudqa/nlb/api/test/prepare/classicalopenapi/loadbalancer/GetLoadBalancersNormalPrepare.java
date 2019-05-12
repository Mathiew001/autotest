/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
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
public class GetLoadBalancersNormalPrepare extends BasePrepare {

    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Type\":\"mix\", \"Limit\":\"1\", \"Offset\":\"\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersNormal001",
            null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "get lb list, mix limit=1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("type", String.class.toString(), "mix", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Type\":\"vpc_mix\", \"Limit\":\"1\", \"Offset\":\"\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersNormal002",
            null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "get lb list, vpc_mix limit=1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("type", String.class.toString(), "vpc_mix", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Type\":\"http\", \"Limit\":\"1\", \"Offset\":\"\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersNormal003",
            null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "get lb list, vpc_mix limit=1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("type", String.class.toString(), "http", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Type\":\"tcp\", \"Limit\":\"1\", \"Offset\":\"\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersNormal004",
            null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "get lb list, vpc_mix limit=1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("type", String.class.toString(), "tcp", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    @CaseLabel()
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancersNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String resMsg = "{\"Type\":\"vpc_mix\", \"Limit\":\"2\", \"Offset\":\"1\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancersNormal005",
            null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "get lb list, mix limit=2 offset=1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("type", String.class.toString(), "vpc_mix", null));
        DataUnits.add(new DataUnit("limit", String.class.toString(), "2", null));
        DataUnits.add(new DataUnit("offset", String.class.toString(), "1", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
