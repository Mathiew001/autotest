package com.netease.cloudqa.nlb.api.test.prepare.dbtest;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.model.TableData;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import com.netease.cloudqa.nlb.api.test.utils.DbUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpdateLoadBalancerInstanceStatusAbnormalPrepare extends BasePrepare {

    //mix实例更新
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix lb when lb is creating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "CREATING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix lb when lb is updating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "UPDATING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix lb when lb is deleting", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "DELETING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix lb when lb is failed", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "FAILED", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of mix lb when lb is stopped", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "STOPPED", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_mix lb when lb is creating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "CREATING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_mix lb when lb is updating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "UPDATING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_mix lb when lb is deleting", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "DELETING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_mix lb when lb is failed", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "FAILED", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_mix lb when lb is stopped", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "STOPPED", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_l4 lb when lb is creating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "CREATING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_l4", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_l4 lb when lb is updating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "UPDATING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_l4", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare014() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_l4 lb when lb is deleting", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "DELETING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_l4", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_l4 lb when lb is failed", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "FAILED", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_l4", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare016() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of vpc_l4 lb when lb is stopped", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "STOPPED", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_l4", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare017() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of dns lb when lb is creating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "private", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "CREATING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare018() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of dns lb when lb is updating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "private", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "UPDATING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare019() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of dns lb when lb is deleting", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "private", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "DELETING", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare020() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of dns lb when lb is failed", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "private", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "FAILED", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //mix实例更新
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerInstanceStatusAbnormalPrepare021() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String instanceId = DbUtils.getUUID32();
        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerInstanceStatusAbnormalPrepare021", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update description of dns lb when lb is stopped", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("des", String.class.toString(), "test cty", null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_prepare = new ArrayList<TableData>();
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("id", String.class.toString(), instanceId, null, FlagConstant.P));
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col1.add(new DataUnit("name", String.class.toString(), "test-cty-db-check", null, FlagConstant.Y));
        col1.add(new DataUnit("network", String.class.toString(), "private", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "STOPPED", null, FlagConstant.Y));
//        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("address", String.class.toString(), "1.1.1.1", null, FlagConstant.Y));
        col1.add(new DataUnit("createtime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("updatetime", Date.class.toString(), FlagConstant.UNIX_TIMESTAP, null, FlagConstant.F));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }
}
