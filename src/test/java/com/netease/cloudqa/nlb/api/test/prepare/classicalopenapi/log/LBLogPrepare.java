package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.log;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LBLogPrepare extends BasePrepare {
    //创建按量netflow vpc_mix实例
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder lbLog001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // -----------------
        // data for lb
        // -----------------

        // get config
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");

        //set instance name
        String name = "qa-temp-" + String.valueOf(new Date().getTime()) + "-" + Thread.currentThread().getStackTrace()[1].getMethodName();
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "lbLog001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "test for lb log vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));

        // -----------------
        // data for target group
        // -----------------

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");

        DataUnits.add(new DataUnit("realServer1", String.class.toString(), realServer1, null));
        DataUnits.add(new DataUnit("rsName1", String.class.toString(), rsName1, null));
        DataUnits.add(new DataUnit("rsAddress1", String.class.toString(), rsAddress1, null));
        DataUnits.add(new DataUnit("realServer2", String.class.toString(), realServer2, null));
        DataUnits.add(new DataUnit("rsName2", String.class.toString(), rsName2, null));
        DataUnits.add(new DataUnit("rsAddress2", String.class.toString(), rsAddress2, null));
        DataUnits.add(new DataUnit("topAz", String.class.toString(), topAz, null));

        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建按量netflow mix实例
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder lbLog002() {
        DataHolder holder = new DataHolderImpl();  //create data holder
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();  //create data units

        // -----------------
        // data for lb
        // -----------------

        //set field needed
        String name = "qa-temp-" + String.valueOf(new Date().getTime()) + "-" + Thread.currentThread().getStackTrace()[1].getMethodName();
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

        //add data unit into data units
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "lbLog002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "test for lb log mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));

        // -----------------
        // data for target group
        // -----------------

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        DataUnits.add(new DataUnit("realServer1", String.class.toString(), realServer1, null));
        DataUnits.add(new DataUnit("rsName1", String.class.toString(), rsName1, null));
        DataUnits.add(new DataUnit("rsAddress1", String.class.toString(), rsAddress1, null));
        DataUnits.add(new DataUnit("realServer2", String.class.toString(), realServer2, null));
        DataUnits.add(new DataUnit("rsName2", String.class.toString(), rsName2, null));
        DataUnits.add(new DataUnit("rsAddress2", String.class.toString(), rsAddress2, null));
        DataUnits.add(new DataUnit("topAz", String.class.toString(), topAz, null));

        holder.setDriverData(DataUnits);
        return holder;
    }
}
