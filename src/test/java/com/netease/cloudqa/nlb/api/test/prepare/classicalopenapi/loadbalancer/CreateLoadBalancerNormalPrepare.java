/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
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
import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.model.TableData;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;

/**
 * 
 * @author chentianyu1
 * @version $Id: CreateLoadBalancerNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CreateLoadBalancerNormalPrepare extends BasePrepare {

    //创建按量netflow mix实例
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer001() {
        DataHolder holder = new DataHolderImpl();  //create data holder
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();  //create data units
        //set field needed
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"netflow\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"BandwidthLimit\":1,\n" +
                "        \"Size\":\"" + size + "\"\n" +
                "    \n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"" + name
                        + "\", \"Description\":\"abcd\", \"Type\":\"mix\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";

        //add data unit into data units
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public netflow mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        //add driver data into data holder
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "netflow", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "hour", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.micro", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_cloud_server col and value
        TableData lb_cloud_server = new TableData();
        lb_cloud_server.setTableName("lb_cloud_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col3.add(new DataUnit("agentStatus", String.class.toString(), "ONLINE", null, FlagConstant.Y));
        col3.add(new DataUnit("serverStatus", String.class.toString(), "ACTIVE", null, FlagConstant.Y));
        col3.add(new DataUnit("version", String.class.toString(), "1.6", null, FlagConstant.Y));
        lb_cloud_server.addColumn(col3);  //add record into lb_vip_config
        db_check.add(lb_cloud_server);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_address = new TableData();
        lb_address.setTableName("lb_address");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col4.add(new DataUnit("tenantId", String.class.toString(), "any", null, FlagConstant.Y));
        col4.add(new DataUnit("status", String.class.toString(), "USED", null, FlagConstant.Y));
        col4.add(new DataUnit("type", String.class.toString(), "public", null, FlagConstant.Y));
        lb_address.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_address);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建按量bandwidth mix实例
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Network\":\"public\",\n" +
//                "    \"Attrs\":{\n" +
//                "        \"UseSSLAcc\": 1\n" +
//                "    },\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"bandwidth\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"BandwidthLimit\":1,\n" +
                "        \"Size\":\"" + size + "\"\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"abcd\", \"Type\":\"mix\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "bandwidth", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "hour", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.micro", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_cloud_server col and value
        TableData lb_cloud_server = new TableData();
        lb_cloud_server.setTableName("lb_cloud_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col3.add(new DataUnit("agentStatus", String.class.toString(), "ONLINE", null, FlagConstant.Y));
        col3.add(new DataUnit("serverStatus", String.class.toString(), "ACTIVE", null, FlagConstant.Y));
        col3.add(new DataUnit("version", String.class.toString(), "1.6", null, FlagConstant.Y));
        lb_cloud_server.addColumn(col3);  //add record into lb_vip_config
        db_check.add(lb_cloud_server);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_address = new TableData();
        lb_address.setTableName("lb_address");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("tenantId", String.class.toString(), "any", null, FlagConstant.Y));
        col4.add(new DataUnit("status", String.class.toString(), "USED", null, FlagConstant.Y));
        col4.add(new DataUnit("type", String.class.toString(), "public", null, FlagConstant.Y));
        lb_address.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_address);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建ha1.8 mix实例
    @CaseLabel(lbType = { "ha1.8mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer100() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Attrs\":{\n" +
                "        \"Version\": \"2018-12-06\",\n" +
                "        \"StopTimeout\": 20000,\n" +
                "        \"UseSSLAcc\": 1\n" +
                "    },\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"bandwidth\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"BandwidthLimit\":1,\n" +
                "        \"Size\":\"" + size + "\"\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"TenantId\":\"" + tenantId + "\",\n" +
                "    \"Name\":\"" + name + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"CREATING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
                "    \"InstanceStatus\":\"UNKNOWN\",\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"Attrs\":{\n" +
                "        \"DeletionProtectionEnabled\":false,\n" +
                "        \"UseSSLAcc\":1,\n" +
                "        \"Version\":\"2018-12-06\",\n" +
                "        \"StopTimeout\":20000\n" +
                "    },\n" +
                "    \"Listeners\":[\n" +
                "\n" +
                "    ],\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"bandwidth\",\n" +
                "        \"ChargeType\":\"AMOUNT\",\n" +
                "        \"BandwidthLimit\":1,\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"AutoRenewPeriod\":0\n" +
                "    },\n" +
                "    \"Limit\":{\n" +
                "        \"ListenerLimit\":10,\n" +
                "        \"TGroupLimit\":20,\n" +
                "        \"TGroupInstanceLimit\":50,\n" +
                "        \"DomainLimit\":5,\n" +
                "        \"PathLimit\":30,\n" +
                "        \"MaxBandwidth\":1000\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "\n" +
                "    ]\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer100", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth mix lb of ha1.8", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "bandwidth", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "hour", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.micro", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_cloud_server col and value
        TableData lb_cloud_server = new TableData();
        lb_cloud_server.setTableName("lb_cloud_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col3.add(new DataUnit("agentStatus", String.class.toString(), "ONLINE", null, FlagConstant.Y));
        col3.add(new DataUnit("serverStatus", String.class.toString(), "ACTIVE", null, FlagConstant.Y));
        col3.add(new DataUnit("version", String.class.toString(), "1.8", null, FlagConstant.Y));
        lb_cloud_server.addColumn(col3);  //add record into lb_vip_config
        db_check.add(lb_cloud_server);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_address = new TableData();
        lb_address.setTableName("lb_address");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("tenantId", String.class.toString(), "any", null, FlagConstant.Y));
        col4.add(new DataUnit("status", String.class.toString(), "USED", null, FlagConstant.Y));
        col4.add(new DataUnit("type", String.class.toString(), "public", null, FlagConstant.Y));
        lb_address.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_address);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建包年包月mix实例
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String body = "{\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"bandwidth\",\n" +
                "        \"ChargeType\":\"month\",\n" +
                "        \"BandwidthLimit\":1,\n" +
                "        \"Period\":1,\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"AutoRenewPeriod\":1\n" +
                "    \n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"abcd\", \"Type\":\"mix\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":1, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public package month mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "bandwidth", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "month", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.micro", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_cloud_server col and value
        TableData lb_cloud_server = new TableData();
        lb_cloud_server.setTableName("lb_cloud_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col3.add(new DataUnit("agentStatus", String.class.toString(), "ONLINE", null, FlagConstant.Y));
        col3.add(new DataUnit("serverStatus", String.class.toString(), "ACTIVE", null, FlagConstant.Y));
        col3.add(new DataUnit("version", String.class.toString(), "1.6", null, FlagConstant.Y));
        lb_cloud_server.addColumn(col3);  //add record into lb_vip_config
        db_check.add(lb_cloud_server);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_address = new TableData();
        lb_address.setTableName("lb_address");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("tenantId", String.class.toString(), "any", null, FlagConstant.Y));
        col4.add(new DataUnit("status", String.class.toString(), "USED", null, FlagConstant.Y));
        col4.add(new DataUnit("type", String.class.toString(), "public", null, FlagConstant.Y));
        lb_address.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_address);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建按量netflow vpc_mix实例
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetId + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"netflow\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"BandwidthLimit\":1\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
                        + "\"VpcId\":\"" + vpcId
                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
                        + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
                        + sg1 + "\", " + "\"" + sg2 + "\", \""
                        + sg + "\"]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public netflow vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "netflow", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "hour", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.micro", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_cloud_server col and value
        TableData lb_cloud_server = new TableData();
        lb_cloud_server.setTableName("lb_cloud_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col3.add(new DataUnit("agentStatus", String.class.toString(), "ONLINE", null, FlagConstant.Y));
        col3.add(new DataUnit("serverStatus", String.class.toString(), "ACTIVE", null, FlagConstant.Y));
        col3.add(new DataUnit("version", String.class.toString(), "1.6", null, FlagConstant.Y));
        lb_cloud_server.addColumn(col3);  //add record into lb_vip_config
        db_check.add(lb_cloud_server);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_address = new TableData();
        lb_address.setTableName("lb_address");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col4.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col4.add(new DataUnit("status", String.class.toString(), "USED", null, FlagConstant.Y));
        col4.add(new DataUnit("type", String.class.toString(), "vpc_public", null, FlagConstant.Y));
        lb_address.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_address);  //add lb_vip_config into db_check list

        //set lb_top_az col and value
        TableData lb_top_az = new TableData();
        lb_top_az.setTableName("lb_top_az");
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        col5.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col5.add(new DataUnit("subNetId", String.class.toString(), subNetId, null, FlagConstant.Y));
        col5.add(new DataUnit("topAz", String.class.toString(), "^pubt[1-2]$", null, FlagConstant.R));
        lb_top_az.addColumn(col5);  //add record into lb_vip_config
        db_check.add(lb_top_az);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);

        return holder;
    }

    //创建按量bandwidth vpc_mix实例
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"Type\":\"vpc_mix\",\n" +
//                "    \"Attrs\":{\n" +
//                "        \"UseSSLAcc\": 1\n" +
//                "    },\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetId + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"bandwidth\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"BandwidthLimit\":1\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
                        + "\"VpcId\":\"" + vpcId
                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
                        + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
                        + sg1 + "\", " + "\"" + sg2 + "\", \""
                        + sg + "\"]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "bandwidth", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "hour", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.micro", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_cloud_server col and value
        TableData lb_cloud_server = new TableData();
        lb_cloud_server.setTableName("lb_cloud_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col3.add(new DataUnit("agentStatus", String.class.toString(), "ONLINE", null, FlagConstant.Y));
        col3.add(new DataUnit("serverStatus", String.class.toString(), "ACTIVE", null, FlagConstant.Y));
        col3.add(new DataUnit("version", String.class.toString(), "1.6", null, FlagConstant.Y));
        lb_cloud_server.addColumn(col3);  //add record into lb_vip_config
        db_check.add(lb_cloud_server);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_address = new TableData();
        lb_address.setTableName("lb_address");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col4.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col4.add(new DataUnit("status", String.class.toString(), "USED", null, FlagConstant.Y));
        col4.add(new DataUnit("type", String.class.toString(), "vpc_public", null, FlagConstant.Y));
        lb_address.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_address);  //add lb_vip_config into db_check list

        //set lb_top_az col and value
        TableData lb_top_az = new TableData();
        lb_top_az.setTableName("lb_top_az");
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        col5.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col5.add(new DataUnit("subNetId", String.class.toString(), subNetId, null, FlagConstant.Y));
        col5.add(new DataUnit("topAz", String.class.toString(), "^pubt[1-2]$", null, FlagConstant.R));
        lb_top_az.addColumn(col5);  //add record into lb_vip_config
        db_check.add(lb_top_az);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建ha1.8 vpc_mix实例
    @CaseLabel(lbType = { "ha1.8vpc" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer101() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"Attrs\":{\n" +
                "        \"Version\": \"2018-12-06\",\n" +
                "        \"StopTimeout\": 20000,\n" +
                "        \"UseSSLAcc\": 1\n" +
                "    },\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetId + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"bandwidth\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"BandwidthLimit\":1\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"TenantId\":\"" + tenantId + "\",\n" +
                "    \"Name\":\"" + name + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"CREATING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
                "    \"InstanceStatus\":\"UNKNOWN\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"VpcId\":\"" +vpcId + "\",\n" +
                "    \"VpcIps\":[\n" +
                "\n" +
                "    ],\n" +
                "    \"Attrs\":{\n" +
                "        \"DeletionProtectionEnabled\":false,\n" +
                "        \"UseSSLAcc\":1,\n" +
                "        \"Version\":\"2018-12-06\",\n" +
                "        \"StopTimeout\":20000\n" +
                "    },\n" +
                "    \"Listeners\":[\n" +
                "\n" +
                "    ],\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"bandwidth\",\n" +
                "        \"ChargeType\":\"AMOUNT\",\n" +
                "        \"BandwidthLimit\":1,\n" +
                "        \"Size\":\"" + size +"\",\n" +
                "        \"AutoRenewPeriod\":0\n" +
                "    },\n" +
                "    \"Limit\":{\n" +
                "        \"ListenerLimit\":10,\n" +
                "        \"TGroupLimit\":20,\n" +
                "        \"TGroupInstanceLimit\":50,\n" +
                "        \"DomainLimit\":5,\n" +
                "        \"PathLimit\":30,\n" +
                "        \"MaxBandwidth\":1000\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "\n" +
                "    ],\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"SubNetId\":\"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg + "\",\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ]\n" +
                "}\n" +
                "\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth vpc_mix lb of ha1.8", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "bandwidth", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "hour", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.micro", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_cloud_server col and value
        TableData lb_cloud_server = new TableData();
        lb_cloud_server.setTableName("lb_cloud_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col3.add(new DataUnit("agentStatus", String.class.toString(), "ONLINE", null, FlagConstant.Y));
        col3.add(new DataUnit("serverStatus", String.class.toString(), "ACTIVE", null, FlagConstant.Y));
        col3.add(new DataUnit("version", String.class.toString(), "1.8", null, FlagConstant.Y));
        lb_cloud_server.addColumn(col3);  //add record into lb_vip_config
        db_check.add(lb_cloud_server);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_address = new TableData();
        lb_address.setTableName("lb_address");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col4.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col4.add(new DataUnit("status", String.class.toString(), "USED", null, FlagConstant.Y));
        col4.add(new DataUnit("type", String.class.toString(), "vpc_public", null, FlagConstant.Y));
        lb_address.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_address);  //add lb_vip_config into db_check list

        //set lb_top_az col and value
        TableData lb_top_az = new TableData();
        lb_top_az.setTableName("lb_top_az");
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        col5.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col5.add(new DataUnit("subNetId", String.class.toString(), subNetId, null, FlagConstant.Y));
        col5.add(new DataUnit("topAz", String.class.toString(), "^pubt[1-2]$", null, FlagConstant.R));
        lb_top_az.addColumn(col5);  //add record into lb_vip_config
        db_check.add(lb_top_az);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建包年包月vpc_mix实例
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetId + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"bandwidth\",\n" +
                "        \"ChargeType\":\"month\",\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"Period\":1,\n" +
                "        \"BandwidthLimit\":1\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
                        + "\"VpcId\":\"" + vpcId
                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
                        + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
                        + sg1 + "\", " + "\"" + sg2 + "\", \""
                        + sg + "\"]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public package month vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "bandwidth", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "month", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.micro", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_cloud_server col and value
        TableData lb_cloud_server = new TableData();
        lb_cloud_server.setTableName("lb_cloud_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col3.add(new DataUnit("agentStatus", String.class.toString(), "ONLINE", null, FlagConstant.Y));
        col3.add(new DataUnit("serverStatus", String.class.toString(), "ACTIVE", null, FlagConstant.Y));
        col3.add(new DataUnit("version", String.class.toString(), "1.6", null, FlagConstant.Y));
        lb_cloud_server.addColumn(col3);  //add record into lb_vip_config
        db_check.add(lb_cloud_server);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_address = new TableData();
        lb_address.setTableName("lb_address");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col4.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col4.add(new DataUnit("status", String.class.toString(), "USED", null, FlagConstant.Y));
        col4.add(new DataUnit("type", String.class.toString(), "vpc_public", null, FlagConstant.Y));
        lb_address.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_address);  //add lb_vip_config into db_check list

        //set lb_top_az col and value
        TableData lb_top_az = new TableData();
        lb_top_az.setTableName("lb_top_az");
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        col5.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col5.add(new DataUnit("subNetId", String.class.toString(), subNetId, null, FlagConstant.Y));
        col5.add(new DataUnit("topAz", String.class.toString(), "^pubt[1-2]$", null, FlagConstant.R));
        lb_top_az.addColumn(col5);  //add record into lb_vip_config
        db_check.add(lb_top_az);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建按量netflow dns实例
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String securityGroupDefault = ConfigLoader.configration.getExtConfig("security_group_default");
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetId + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Network\":\"private\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"netflow\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"BandwidthLimit\":1\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
                        + "\"Network\":\"private\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
                        + "\"VpcId\":\"" + vpcId
                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
                        + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
                        + sg1 + "\", " + "\"" + sg2 + "\", \""
                        + securityGroupDefault + "\"]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create private netflow dns lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "private", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_mix", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 1, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "netflow", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "hour", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.micro", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_cloud_server col and value
        TableData lb_cloud_server = new TableData();
        lb_cloud_server.setTableName("lb_cloud_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col3.add(new DataUnit("agentStatus", String.class.toString(), "ONLINE", null, FlagConstant.Y));
        col3.add(new DataUnit("serverStatus", String.class.toString(), "ACTIVE", null, FlagConstant.Y));
        col3.add(new DataUnit("version", String.class.toString(), "1.6", null, FlagConstant.Y));
        lb_cloud_server.addColumn(col3);  //add record into lb_vip_config
        db_check.add(lb_cloud_server);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_dns_rrset = new TableData();
        lb_dns_rrset.setTableName("lb_dns_rrset");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col4.add(new DataUnit("ttl", Integer.class.toString(), 5, null, FlagConstant.INT));
        col4.add(new DataUnit("type", String.class.toString(), "A", null, FlagConstant.Y));
        col4.add(new DataUnit("service", String.class.toString(), "nlbadmin", null, FlagConstant.Y));
        lb_dns_rrset.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_dns_rrset);  //add lb_vip_config into db_check list

        //set lb_top_az col and value
        TableData lb_top_az = new TableData();
        lb_top_az.setTableName("lb_top_az");
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        col5.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col5.add(new DataUnit("subNetId", String.class.toString(), subNetId, null, FlagConstant.Y));
        col5.add(new DataUnit("topAz", String.class.toString(), "^pubt[1-2]$", null, FlagConstant.R));
        lb_top_az.addColumn(col5);  //add record into lb_vip_config
        db_check.add(lb_top_az);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建默认standard mix实例
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "", "", 0);
        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"test cty\", \"Type\":\"mix\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                        + "\"BandwidthLimit\":100, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public default standard mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建默认securitygroups vpc_mix实例
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\"Name\":\""
                      + name
                      + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                      + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"hour\", "
                      + "\"BandwidthLimit\":1}, \"VpcId\":\"" + vpcId + "\", "
                      + "\"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", \"SubNetId\":\"" + subNetId
                      + "\"}]}";
        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
                        + "\"VpcId\":\"" + vpcId
                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
                        + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\"" + sg
                        + "\"]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public default securitygroups vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

//    //创建按量netflow mix实例, size=nlb.s1.small
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer011() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s1_small");
//        //set request body
//        String body = "{\n" +
//                "    \"Type\":\"mix\",\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"netflow\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"BandwidthLimit\":101,\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "    \n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":101, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer011", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public netflow mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量netflow mix实例, size=nlb.s2.micro
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancer012() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s2_micro");
//        //set request body
//        String body = "{\n" +
//                "    \"Type\":\"mix\",\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"netflow\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"BandwidthLimit\":1000,\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "    \n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":1000, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer012", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public netflow mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量netflow mix实例, size=nlb.s1.micro, bandwidth=101
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancer013() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//        //set request body
//        String body = "{\n" +
//                "    \"Type\":\"mix\",\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"netflow\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"BandwidthLimit\":101,\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "    \n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":101, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer013", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public netflow mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量netflow mix实例, size=nlb.s2.micro
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancer014() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s2_micro");
//        //set request body
//        String body = "{\n" +
//                "    \"Type\":\"mix\",\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"netflow\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"BandwidthLimit\":1,\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "    \n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\"" + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer014", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public netflow mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth mix实例, size=nlb.s1.small
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer015() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s1_small");
//        //set request body
//        String body = "{\n" +
//                "    \"Type\":\"mix\",\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"bandwidth\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"BandwidthLimit\":20,\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "    \n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":20, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer015", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth mix实例, size=nlb.s1.medium
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer016() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s1_medium");
//        //set request body
//        String body = "{\n" +
//                "    \"Type\":\"mix\",\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"bandwidth\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"BandwidthLimit\":100,\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "    \n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":100, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer016", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth mix实例, size=nlb.s2.micro
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancer017() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s2_micro");
//        //set request body
//        String body = "{\n" +
//                "    \"Type\":\"mix\",\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"bandwidth\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"BandwidthLimit\":500,\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "    \n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"test cty\", \"Type\":\"mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":500, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer017", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth mix实例, size=nlb.s2.micro
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancer018() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s2_small");
//        //set request body
//        String body = "{\n" +
//                "    \"Type\":\"mix\",\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"bandwidth\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"BandwidthLimit\":1000,\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "    \n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"test cty\", \"Type\":\"mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":1000, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer018", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量netflow vpc_mix实例, size=nlb.s1.small
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer019() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
//        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
//        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_small");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        String body = "{\n" +
//                "    \"SecurityGroups\":[\n" +
//                "        \"" + sg1 + "\",\n" +
//                "        \"" + sg2 + "\"\n" +
//                "    ],\n" +
//                "    \"Type\":\"vpc_mix\",\n" +
//                "    \"TopAzInfos\":[\n" +
//                "        {\n" +
//                "            \"SubNetId\":\"" + subNetId + "\",\n" +
//                "            \"TopAz\":\"" + topAz + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"netflow\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "        \"BandwidthLimit\":500\n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":500, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                + "\"VpcId\":\"" + vpcId
//                + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                + sg1 + "\", " + "\"" + sg2 + "\", \""
//                + sg + "\"]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer019", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public netflow vpc_mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量netflow vpc_mix实例, size=nlb.s2.micro
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancer020() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
//        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
//        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
//        String size = ConfigLoader.configration.getExtConfig("size_s2_micro");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        String body = "{\n" +
//                "    \"SecurityGroups\":[\n" +
//                "        \"" + sg1 + "\",\n" +
//                "        \"" + sg2 + "\"\n" +
//                "    ],\n" +
//                "    \"Type\":\"vpc_mix\",\n" +
//                "    \"TopAzInfos\":[\n" +
//                "        {\n" +
//                "            \"SubNetId\":\"" + subNetId + "\",\n" +
//                "            \"TopAz\":\"" + topAz + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"netflow\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "        \"BandwidthLimit\":1000\n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":1000, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                + "\"VpcId\":\"" + vpcId
//                + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                + sg1 + "\", " + "\"" + sg2 + "\", \""
//                + sg + "\"]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer020", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public netflow vpc_mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth vpc_mix实例, size=nlb.s1.small
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer021() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
//        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
//        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_small");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        String body = "{\n" +
//                "    \"SecurityGroups\":[\n" +
//                "        \"" + sg1 + "\",\n" +
//                "        \"" + sg2 + "\"\n" +
//                "    ],\n" +
//                "    \"Type\":\"vpc_mix\",\n" +
//                "    \"TopAzInfos\":[\n" +
//                "        {\n" +
//                "            \"SubNetId\":\"" + subNetId + "\",\n" +
//                "            \"TopAz\":\"" + topAz + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"bandwidth\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "        \"BandwidthLimit\":20\n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":20, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                + "\"VpcId\":\"" + vpcId
//                + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                + sg1 + "\", " + "\"" + sg2 + "\", \""
//                + sg + "\"]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer021", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth vpc_mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth vpc_mix实例, size=nlb.s1.medium
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer022() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
//        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
//        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_medium");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        String body = "{\n" +
//                "    \"SecurityGroups\":[\n" +
//                "        \"" + sg1 + "\",\n" +
//                "        \"" + sg2 + "\"\n" +
//                "    ],\n" +
//                "    \"Type\":\"vpc_mix\",\n" +
//                "    \"TopAzInfos\":[\n" +
//                "        {\n" +
//                "            \"SubNetId\":\"" + subNetId + "\",\n" +
//                "            \"TopAz\":\"" + topAz + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"bandwidth\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "        \"BandwidthLimit\":100\n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":100, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                + "\"VpcId\":\"" + vpcId
//                + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                + sg1 + "\", " + "\"" + sg2 + "\", \""
//                + sg + "\"]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer022", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth vpc_mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth vpc_mix实例, size=nlb.s2.micro
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancer023() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
//        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
//        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
//        String size = ConfigLoader.configration.getExtConfig("size_s2_micro");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        String body = "{\n" +
//                "    \"SecurityGroups\":[\n" +
//                "        \"" + sg1 + "\",\n" +
//                "        \"" + sg2 + "\"\n" +
//                "    ],\n" +
//                "    \"Type\":\"vpc_mix\",\n" +
//                "    \"TopAzInfos\":[\n" +
//                "        {\n" +
//                "            \"SubNetId\":\"" + subNetId + "\",\n" +
//                "            \"TopAz\":\"" + topAz + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"bandwidth\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "        \"BandwidthLimit\":500\n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":500, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                + "\"VpcId\":\"" + vpcId
//                + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                + sg1 + "\", " + "\"" + sg2 + "\", \""
//                + sg + "\"]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer023", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth vpc_mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth vpc_mix实例, size=nlb.s2.small
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = false)
//    public DataHolder createLoadBalancer024() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
//        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
//        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
//        String size = ConfigLoader.configration.getExtConfig("size_s2_small");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        String body = "{\n" +
//                "    \"SecurityGroups\":[\n" +
//                "        \"" + sg1 + "\",\n" +
//                "        \"" + sg2 + "\"\n" +
//                "    ],\n" +
//                "    \"Type\":\"vpc_mix\",\n" +
//                "    \"TopAzInfos\":[\n" +
//                "        {\n" +
//                "            \"SubNetId\":\"" + subNetId + "\",\n" +
//                "            \"TopAz\":\"" + topAz + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"bandwidth\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "        \"BandwidthLimit\":1000\n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":1000, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                + "\"VpcId\":\"" + vpcId
//                + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                + sg1 + "\", " + "\"" + sg2 + "\", \""
//                + sg + "\"]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer024", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth vpc_mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }

//    //创建按量bandwidth vpc_mix实例, 无size
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer025() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
//        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
//        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_medium");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        String body = "{\n" +
//                "    \"SecurityGroups\":[\n" +
//                "        \"" + sg1 + "\",\n" +
//                "        \"" + sg2 + "\"\n" +
//                "    ],\n" +
//                "    \"Type\":\"vpc_mix\",\n" +
//                "    \"TopAzInfos\":[\n" +
//                "        {\n" +
//                "            \"SubNetId\":\"" + subNetId + "\",\n" +
//                "            \"TopAz\":\"" + topAz + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"bandwidth\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"Size\":\"" + size + "\",\n" +
//                "        \"BandwidthLimit\":21\n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":21, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                + "\"VpcId\":\"" + vpcId
//                + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                + sg1 + "\", " + "\"" + sg2 + "\", \""
//                + sg + "\"]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer022", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth vpc_mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建按量bandwidth vpc_mix实例, 无size
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer026() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
//        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
//        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
//        String size = ConfigLoader.configration.getExtConfig("size_s2_micro");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        String body = "{\n" +
//                "    \"SecurityGroups\":[\n" +
//                "        \"" + sg1 + "\",\n" +
//                "        \"" + sg2 + "\"\n" +
//                "    ],\n" +
//                "    \"Type\":\"vpc_mix\",\n" +
//                "    \"TopAzInfos\":[\n" +
//                "        {\n" +
//                "            \"SubNetId\":\"" + subNetId + "\",\n" +
//                "            \"TopAz\":\"" + topAz + "\"\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"Description\":\"abcd\",\n" +
//                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"Network\":\"public\",\n" +
//                "    \"Standard\":{\n" +
//                "        \"ChargeMode\":\"bandwidth\",\n" +
//                "        \"ChargeType\":\"hour\",\n" +
//                "        \"BandwidthLimit\":101\n" +
//                "    },\n" +
//                "    \"Name\":\"" + name + "\"\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                + name
//                + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
//                + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":101, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                + "\"VpcId\":\"" + vpcId
//                + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                + sg1 + "\", " + "\"" + sg2 + "\", \""
//                + sg + "\"]}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer022", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth vpc_mix lb", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }


//    //创建有订单按量netflow mix实例
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer011() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String region = ConfigLoader.configration.getExtConfig("region");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//        //set request body
//        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "netflow",
//            "hour", 1);
//        String orderBody = "{\n" + "    \"Service\":\"NLB\",\n" + "    \"RegionId\":\"" + region
//                           + "\",\n" + "    \"Standard\":{\n"
//                           + "            \"netType\": \"FLOW\",\n"
//                           + "            \"bandwidth\": 1\n" + "    },\n"
//                           + "    \"Unit\":\"Hour\",\n" + "    \"PayType\": \"PostPaid\",\n"
//                           + "    \"Body\": [\"test,test\"],\n"
//                           + "    \"NetworkChargeType\": \"PayByBandwidth\"\n" + "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                        + name
//                        + "\", \"Description\":\"test cty\", \"Type\":\"mix\", "
//                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                        + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits
//            .add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer011", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(),
//            "create public netflow mix lb with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
//            .getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建有订单按量bandwidth mix实例
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer012() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String region = ConfigLoader.configration.getExtConfig("region");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//        //set request body
//        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth",
//            "hour", 1);
//        String orderBody = "{\n" + "    \"Service\":\"NLB\",\n" + "    \"RegionId\":\"" + region
//                           + "\",\n" + "    \"Standard\":{\n"
//                           + "            \"netType\": \"BANDWIDTH\",\n"
//                           + "            \"bandwidth\": 1\n" + "    },\n"
//                           + "    \"Unit\":\"Hour\",\n" + "    \"PayType\": \"PostPaid\",\n"
//                           + "    \"Body\": [\"test,test\"],\n"
//                           + "    \"NetworkChargeType\": \"PayByBandwidth\"\n" + "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                        + name
//                        + "\", \"Description\":\"test cty\", \"Type\":\"mix\", "
//                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                        + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits
//            .add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer012", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(),
//            "create public bandwidth mix lb with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
//            .getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建有订单包年包月mix实例
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer013() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String region = ConfigLoader.configration.getExtConfig("region");
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//        //set request body
//        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "mix", "bandwidth",
//            "month", 1, 1, 0);
//        String orderBody = "{\n" + "    \"Service\":\"NLB\",\n" + "    \"RegionId\":\"" + region
//                           + "\",\n" + "    \"Standard\":{\n"
//                           + "            \"netType\": \"BANDWIDTH\",\n"
//                           + "            \"bandwidth\": 1\n" + "    },\n" + "    \"Period\": 1,\n"
//                           + "    \"Unit\":\"Month\",\n" + "    \"PayType\": \"PrePay\",\n"
//                           + "    \"Body\": [\"test,test\"],\n"
//                           + "    \"NetworkChargeType\": \"PayByBandwidth\"\n" + "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                        + name
//                        + "\", \"Description\":\"test cty\", \"Type\":\"mix\", "
//                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
//                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}, \"Listeners\":[], "
//                        + "\"InstanceStatus\":\"UNKNOWN\", \"TargetGroups\":[]}";
//
//        DataUnits
//            .add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer013", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(),
//            "create public package month mix lb with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
//            .getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建有订单按量netflow vpc_mix实例
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer014() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        ArrayList<String> securityGroups = new ArrayList<String>();
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//        String securityGroupDefault = ConfigLoader.configration
//            .getExtConfig("security_group_default");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "netflow",
//            "hour", 1, vpcId, topAz, subNetId, securityGroups);
//        String orderBody = "{\n" + "    \"Service\":\"NLB\",\n" + "    \"RegionId\":\"" + region
//                           + "\",\n" + "    \"Standard\":{\n"
//                           + "            \"netType\": \"FLOW\",\n"
//                           + "            \"bandwidth\": 1\n" + "    },\n"
//                           + "    \"Unit\":\"Hour\",\n" + "    \"PayType\": \"PostPaid\",\n"
//                           + "    \"Body\": [\"test,test\"],\n"
//                           + "    \"NetworkChargeType\": \"PayByTraffic\"\n" + "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                        + name
//                        + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
//                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                        + "\"VpcId\":\"" + vpcId
//                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                        + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                        + securityGroups.get(0) + "\", " + "\"" + securityGroups.get(1) + "\", \""
//                        + securityGroupDefault + "\"]}";
//
//        DataUnits
//            .add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer014", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(),
//            "create public netflow vpc_mix lb with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
//            .getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建有订单按量bandwidth vpc_mix实例
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer015() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        ArrayList<String> securityGroups = new ArrayList<String>();
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//        String securityGroupDefault = ConfigLoader.configration
//            .getExtConfig("security_group_default");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "bandwidth",
//            "hour", 1, vpcId, topAz, subNetId, securityGroups);
//        String region = ConfigLoader.configration.getExtConfig("region");
//        String orderBody = "{\n" + "    \"Service\":\"NLB\",\n" + "    \"RegionId\":\"" + region
//                           + "\",\n" + "    \"Standard\":{\n"
//                           + "            \"netType\": \"BANDWIDTH\",\n"
//                           + "            \"bandwidth\": 1\n" + "    },\n"
//                           + "    \"Unit\":\"Hour\",\n" + "    \"PayType\": \"PostPaid\",\n"
//                           + "    \"Body\": [\"test,test\"],\n"
//                           + "    \"NetworkChargeType\": \"PayByBandwidth\"\n" + "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                        + name
//                        + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
//                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                        + "\"VpcId\":\"" + vpcId
//                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                        + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                        + securityGroups.get(0) + "\", " + "\"" + securityGroups.get(1) + "\", \""
//                        + securityGroupDefault + "\"]}";
//
//        DataUnits
//            .add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer015", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(),
//            "create public bandwidth vpc_mix lb with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
//            .getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //创建有订单包年包月vpc_mix实例
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder createLoadBalancer016() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        ArrayList<String> securityGroups = new ArrayList<String>();
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//        String securityGroupDefault = ConfigLoader.configration
//            .getExtConfig("security_group_default");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String region = ConfigLoader.configration.getExtConfig("region");
//        //set request body
//        JSONObject body = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "bandwidth",
//            "month", 1, 1, 0, vpcId, topAz, subNetId, securityGroups);
//        String orderBody = "{\n" + "    \"Service\":\"NLB\",\n" + "    \"RegionId\":\"" + region
//                           + "\",\n" + "    \"Standard\":{\n"
//                           + "            \"netType\": \"BANDWIDTH\",\n"
//                           + "            \"bandwidth\": 1\n" + "    },\n" + "    \"Period\": 1,\n"
//                           + "    \"Unit\":\"Month\",\n" + "    \"PayType\": \"PrePay\",\n"
//                           + "    \"Body\": [\"test,test\"],\n"
//                           + "    \"NetworkChargeType\": \"PayByBandwidth\"\n" + "}";
//        //set response message
//        String resMsg = "{\"Name\":\""
//                        + name
//                        + "\", \"Description\":\"test cty\", \"Type\":\"vpc_mix\", "
//                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
//                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
//                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
//                        + "\"VpcId\":\"" + vpcId
//                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
//                        + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
//                        + securityGroups.get(0) + "\", " + "\"" + securityGroups.get(1) + "\", \""
//                        + securityGroupDefault + "\"]}";
//
//        DataUnits
//            .add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer016", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(),
//            "create public package month vpc_mix lb with orderId", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
//            .getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("body", String.class.toString(), body.toJSONString(), null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), true, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }

    //创建按量netflow vpc_l4实例
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer022() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String resourcePool = ConfigLoader.configration.getExtConfig("resource_pool");
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"Type\":\"vpc_l4\",\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetId + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"netflow\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"BandwidthLimit\":1\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\", \n" +
                "    \"ResourcePool\":\"" + resourcePool + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"abcd\", \"Type\":\"vpc_l4\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
                        + "\"VpcId\":\"" + vpcId
                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
                        + "\"SubNetId\":\"" + subNetId + "\"}]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public netflow vpc_l4 lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_l4", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "netflow", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "hour", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.micro", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_address = new TableData();
        lb_address.setTableName("lb_address");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col4.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col4.add(new DataUnit("status", String.class.toString(), "USED", null, FlagConstant.Y));
        col4.add(new DataUnit("type", String.class.toString(), "vpc_public", null, FlagConstant.Y));
        lb_address.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_address);  //add lb_vip_config into db_check list

        //set lb_top_az col and value
        TableData lb_top_az = new TableData();
        lb_top_az.setTableName("lb_top_az");
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        col5.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col5.add(new DataUnit("subNetId", String.class.toString(), subNetId, null, FlagConstant.Y));
        col5.add(new DataUnit("topAz", String.class.toString(), "^pubt[1-2]$", null, FlagConstant.R));
        lb_top_az.addColumn(col5);  //add record into lb_vip_config
        db_check.add(lb_top_az);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);

        return holder;
    }

    //创建按量bandwidth vpc_l4实例
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer018() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        String size = ConfigLoader.configration.getExtConfig("size_s1_small");
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"Type\":\"vpc_l4\",\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetId + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"bandwidth\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"BandwidthLimit\":1\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"abcd\", \"Type\":\"vpc_l4\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
                        + "\"VpcId\":\"" + vpcId
                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
                        + "\"SubNetId\":\"" + subNetId + "\"}]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public bandwidth vpc_l4 lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_vip col and value
        TableData lb_vip = new TableData();
        lb_vip.setTableName("lb_vip");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.C));
        col1.add(new DataUnit("name", String.class.toString(), name, null, FlagConstant.C));
        col1.add(new DataUnit("network", String.class.toString(), "public", null, FlagConstant.Y));
        col1.add(new DataUnit("description", String.class.toString(), "abcd", null, FlagConstant.Y));
        col1.add(new DataUnit("status", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("substatus", String.class.toString(), "WORKING", null, FlagConstant.Y));
        col1.add(new DataUnit("instanceNum", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col1.add(new DataUnit("type", String.class.toString(), "vpc_l4", null, FlagConstant.Y));
        col1.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col1.add(new DataUnit("scale", Integer.class.toString(), 0, null, FlagConstant.INT));
        col1.add(new DataUnit("tag", String.class.toString(), "ordinary", null, FlagConstant.Y));
        col1.add(new DataUnit("k8sEnv", String.class.toString(), "", null, FlagConstant.Y));
        col1.add(new DataUnit("vmType", String.class.toString(), "kvm", null, FlagConstant.Y));
        col1.add(new DataUnit("vpcId", String.class.toString(), vpcId, null, FlagConstant.Y));
        lb_vip.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_vip);  //add lb_vip into db_check list

        //set lb_vip_config col and value
        TableData lb_vip_config = new TableData();
        lb_vip_config.setTableName("lb_vip_config");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col2.add(new DataUnit("listenerLimit", Integer.class.toString(), 10, null, FlagConstant.INT));
        col2.add(new DataUnit("mode", String.class.toString(), "DR", null, FlagConstant.Y));
        col2.add(new DataUnit("bandwidthLimit", Integer.class.toString(), 1, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeMode", String.class.toString(), "bandwidth", null, FlagConstant.Y));
        col2.add(new DataUnit("ipLimitSwitch", String.class.toString(), "OFF", null, FlagConstant.Y));
        col2.add(new DataUnit("tGroupLimit", Integer.class.toString(), 20, null, FlagConstant.INT));
        col2.add(new DataUnit("tGroupInstanceLimit", Integer.class.toString(), 50, null, FlagConstant.INT));
        col2.add(new DataUnit("chargeType", String.class.toString(), "hour", null, FlagConstant.Y));
        col2.add(new DataUnit("size", String.class.toString(), "nlb.s1.small", null, FlagConstant.Y));
        lb_vip_config.addColumn(col2);  //add record into lb_vip_config
        db_check.add(lb_vip_config);  //add lb_vip_config into db_check list

        //set lb_address col and value
        TableData lb_address = new TableData();
        lb_address.setTableName("lb_address");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col4.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col4.add(new DataUnit("status", String.class.toString(), "USED", null, FlagConstant.Y));
        col4.add(new DataUnit("type", String.class.toString(), "vpc_public", null, FlagConstant.Y));
        lb_address.addColumn(col4);  //add record into lb_vip_config
        db_check.add(lb_address);  //add lb_vip_config into db_check list

        //set lb_top_az col and value
        TableData lb_top_az = new TableData();
        lb_top_az.setTableName("lb_top_az");
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        col5.add(new DataUnit("tenantId", String.class.toString(), tenantId, null, FlagConstant.Y));
        col5.add(new DataUnit("subNetId", String.class.toString(), subNetId, null, FlagConstant.Y));
        col5.add(new DataUnit("topAz", String.class.toString(), "^pubt[1-2]$", null, FlagConstant.R));
        lb_top_az.addColumn(col5);  //add record into lb_vip_config
        db_check.add(lb_top_az);  //add lb_vip_config into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建包月 vpc_l4实例
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLoadBalancer019() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"Type\":\"vpc_l4\",\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetId + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"bandwidth\",\n" +
                "        \"ChargeType\":\"month\",\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"Period\":1,\n" +
                "        \"AutoRenewPeriod\":1,\n" +
                "        \"BandwidthLimit\":1\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";

        //set response message
        String resMsg = "{\"Name\":\""
                        + name
                        + "\", \"Description\":\"abcd\", \"Type\":\"vpc_l4\", "
                        + "\"Network\":\"public\", \"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                        + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":1, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
                        + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
                        + "\"VpcId\":\"" + vpcId
                        + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
                        + "\"SubNetId\":\"" + subNetId + "\"}]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public package month vpc_l4 lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建按量netflow idc_vpc_mix实例
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer021() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        ArrayList<String> securityGroups = new ArrayList<String>();
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime()) + "idc";
        //set request body
        String body = "{\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetId + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Network\":\"idc\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"netflow\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"BandwidthLimit\":1\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";

        //set response message
        String resMsg = "{\"Name\":\""
                + name
                + "\", \"Description\":\"abcd\", \"Type\":\"vpc_mix\", "
                + "\"Network\":\"idc\", \"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}, \"Listeners\":[], "
                + "\"InstanceStatus\":\"UNKNOWN\", \"Status\":\"CREATING\", \"SubStatus\":\"WORKING\", "
                + "\"VpcId\":\"" + vpcId
                + "\", \"TargetGroups\":[], \"TopAzInfos\":[{\"TopAz\":\"" + topAz + "\", "
                + "\"SubNetId\":\"" + subNetId + "\"}], \"SecurityGroups\":[\""
                + sg1 + "\", " + "\"" + sg2 + "\", \""
                + sg3 + "\"]}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create public netflow of idc vpc_mix lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建multiaz实例
    @CaseLabel(lbType = { "multiaz" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLoadBalancer099() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAzA = ConfigLoader.configration.getExtConfig("topaz_a");
        String topAzB = ConfigLoader.configration.getExtConfig("topaz_b");
        String subNetIdA = ConfigLoader.configration.getExtConfig("subnet_id_a");
        String subNetIdB = ConfigLoader.configration.getExtConfig("subnet_id_b");
        String sg = ConfigLoader.configration.getExtConfig("security_group_default");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String body = "{\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetIdA + "\",\n" +
                "            \"TopAz\":\"" + topAzA + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"SubNetId\":\"" + subNetIdB + "\",\n" +
                "            \"TopAz\":\"" + topAzB + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"netflow\",\n" +
                "        \"ChargeType\":\"hour\",\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"BandwidthLimit\":1\n" +
                "    },\n" +
                "    \"Name\":\"" + name + "\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Name\":\"" + name + "\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"CREATING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
                "    \"InstanceStatus\":\"UNKNOWN\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"VpcIps\":[\n" +
                "\n" +
                "    ],\n" +
                "    \"Attrs\":{\n" +
                "        \"DeletionProtectionEnabled\":false,\n" +
                "        \"UseSSLAcc\":1,\n" +
                "        \"Version\":\"2018-12-06\",\n" +
                "        \"StopTimeout\":null\n" +
                "    },\n" +
                "    \"Listeners\":[\n" +
                "\n" +
                "    ],\n" +
                "    \"Standard\":{\n" +
                "        \"ChargeMode\":\"netflow\",\n" +
                "        \"ChargeType\":\"AMOUNT\",\n" +
                "        \"BandwidthLimit\":1,\n" +
                "        \"Size\":\"" + size + "\",\n" +
                "        \"AutoRenewPeriod\":0\n" +
                "    },\n" +
                "    \"Limit\":{\n" +
                "        \"ListenerLimit\":10,\n" +
                "        \"TGroupLimit\":20,\n" +
                "        \"TGroupInstanceLimit\":50,\n" +
                "        \"DomainLimit\":5,\n" +
                "        \"PathLimit\":30,\n" +
                "        \"MaxBandwidth\":1000\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "\n" +
                "    ],\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAzA + "\",\n" +
                "            \"SubNetId\":\"" + subNetIdA + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAzB + "\",\n" +
                "            \"SubNetId\":\"" + subNetIdB + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg + "\",\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ]\n" +
                "}\n" +
                "\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLoadBalancer099", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create multiaz lb", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("isDeleted", String.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        return holder;
    }

}
