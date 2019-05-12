package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.targetgroup;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

public class RegistTGInstanceNormalPrepare extends BasePrepare {

    //更新目标组, 1个-->4个, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder registTGInstanceNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        //set request body
        String createBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":6,\n" +
                "        \"Fall\":6,\n" +
                "        \"Url\":\"/index1.html\",\n" +
                "        \"Timeout\":6000,\n" +
                "        \"Period\":6000\n, " +
                "        \"Rstatus\":\"2xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "registTGInstanceNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->4 of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 0个-->2个, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder registTGInstanceNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        //set request body
        String createBody = "{\n" +
                "    \"Instances\":[\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":6,\n" +
                "        \"Fall\":6,\n" +
                "        \"Url\":\"/index1.html\",\n" +
                "        \"Timeout\":6000,\n" +
                "        \"Period\":6000\n, " +
                "        \"Rstatus\":\"2xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":1,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "registTGInstanceNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->2 of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1个-->4个, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder registTGInstanceNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":6,\n" +
                "        \"Fall\":6,\n" +
                "        \"Url\":\"/index1.html\",\n" +
                "        \"Timeout\":6000,\n" +
                "        \"Period\":6000\n, " +
                "        \"Rstatus\":\"2xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "registTGInstanceNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->4 of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 0个-->2个, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder registTGInstanceNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\n" +
                "    \"Instances\":[\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":6,\n" +
                "        \"Fall\":6,\n" +
                "        \"Url\":\"/index1.html\",\n" +
                "        \"Timeout\":6000,\n" +
                "        \"Period\":6000\n, " +
                "        \"Rstatus\":\"2xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":1,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "registTGInstanceNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->2 of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1个-->4个, dns
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder registTGInstanceNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":6,\n" +
                "        \"Fall\":6,\n" +
                "        \"Url\":\"/index1.html\",\n" +
                "        \"Timeout\":6000,\n" +
                "        \"Period\":6000\n, " +
                "        \"Rstatus\":\"2xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "registTGInstanceNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->4 of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 0个-->2个, dns
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder registTGInstanceNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\n" +
                "    \"Instances\":[\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":6,\n" +
                "        \"Fall\":6,\n" +
                "        \"Url\":\"/index1.html\",\n" +
                "        \"Timeout\":6000,\n" +
                "        \"Period\":6000\n, " +
                "        \"Rstatus\":\"2xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":1,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "registTGInstanceNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->2 of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1个-->4个, vpc_l4
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder registTGInstanceNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":6,\n" +
                "        \"Fall\":6,\n" +
                "        \"Url\":\"/index1.html\",\n" +
                "        \"Timeout\":6000,\n" +
                "        \"Period\":6000\n, " +
                "        \"Rstatus\":\"2xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "registTGInstanceNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->4 of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 0个-->2个, vpc_l4
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder registTGInstanceNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\n" +
                "    \"Instances\":[\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":6,\n" +
                "        \"Fall\":6,\n" +
                "        \"Url\":\"/index1.html\",\n" +
                "        \"Timeout\":6000,\n" +
                "        \"Period\":6000\n, " +
                "        \"Rstatus\":\"2xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "registTGInstanceNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->2 of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1个-->4个, idc_vpc_mix
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder registTGInstanceNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":6,\n" +
                "        \"Fall\":6,\n" +
                "        \"Url\":\"/index1.html\",\n" +
                "        \"Timeout\":6000,\n" +
                "        \"Period\":6000\n, " +
                "        \"Rstatus\":\"2xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8081,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "registTGInstanceNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->4 of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 0个-->2个, idc_vpc_mix
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder registTGInstanceNormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\n" +
                "    \"Instances\":[\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":6,\n" +
                "        \"Fall\":6,\n" +
                "        \"Url\":\"/index1.html\",\n" +
                "        \"Timeout\":6000,\n" +
                "        \"Period\":6000\n, " +
                "        \"Rstatus\":\"2xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":1,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":8080,\n" +
                "            \"Id\":\"" + realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Rise\":5,\n" +
                "        \"Fall\":5,\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Period\":5000\n, " +
                "        \"Rstatus\":\"2xx,3xx\"\n" +
                "    }, \n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "registTGInstanceNormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->2 of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
