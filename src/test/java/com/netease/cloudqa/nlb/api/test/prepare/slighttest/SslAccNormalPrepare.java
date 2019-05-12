package com.netease.cloudqa.nlb.api.test.prepare.slighttest;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.model.TableData;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SslAccNormalPrepare extends BasePrepare {

    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder sslAccNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String createLbBody = "{\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Attrs\":{\n" +
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
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "sslAccNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "ssl acc of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createLbBody", String.class.toString(), createLbBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
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

}
