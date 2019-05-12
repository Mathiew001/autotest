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

public class CreateTargetGroupInstanceStatusAbnormalPrepare extends BasePrepare {

    //mix创建目标组
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of mix lb when lb is creating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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

    //mix创建目标组
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of mix lb when lb is updating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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

    //mix创建目标组
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of mix lb when lb is deleting", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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

    //mix创建目标组
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of mix lb when lb is failed", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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

    //vpc_mix创建目标组
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of vpc_mix lb when lb is creating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //vpc_mix创建目标组
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of vpc_mix lb when lb is updating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //vpc_mix创建目标组
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of vpc_mix lb when lb is deleting", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //vpc_mix创建目标组
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of vpc_mix lb when lb is failed", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //dns创建目标组
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of dns lb when lb is creating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //dns创建目标组
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of dns lb when lb is updating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //dns创建目标组
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of dns lb when lb is deleting", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //dns创建目标组
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of dns lb when lb is failed", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //vpc_l4创建目标组
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of vpc_l4 lb when lb is creating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //vpc_l4创建目标组
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare014() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of vpc_l4 lb when lb is updating", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //vpc_l4创建目标组
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of vpc_l4 lb when lb is deleting", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }

    //vpc_l4创建目标组
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupInstanceStatusAbnormalPrepare016() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String instanceId = DbUtils.getUUID32();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        String resMsg = "{\"Code\":\"Forbidden\",\"Message\":\"负载均衡不在运行中状态!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupInstanceStatusAbnormalPrepare016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create target group of vpc_l4 lb when lb is failed", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
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
        col1.add(new DataUnit("vpcId", String.class.toString(), "", null, FlagConstant.Y));
        lb_vip.addColumn(col1);
        db_prepare.add(lb_vip);
        holder.setDbPrepareData(db_prepare);
        return holder;
    }
}
