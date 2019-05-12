package com.netease.cloudqa.nlb.api.test.prepare.classicaladminapi;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

public class DeregisterTGInstanceByTenantNormalPrepare extends BasePrepare {

    //批量注销, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deregisterTGInstanceByTenant001() {
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
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Id\":\"" + realServer1 + "\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Id\":\"" + realServer2 + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deregisterTGInstanceByTenant001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "deregister of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //批量注销, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deregisterTGInstanceByTenant002() {
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
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Id\":\"" + realServer1 + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deregisterTGInstanceByTenant002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "deregister of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //批量注销, dns
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deregisterTGInstanceByTenant003() {
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
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Id\":\"" + realServer1 + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deregisterTGInstanceByTenant003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "deregister of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //批量注销, vpc_l4
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deregisterTGInstanceByTenant004() {
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
        String updateBody = "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Id\":\"" + realServer1 + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Instances\":[\n" +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deregisterTGInstanceByTenant004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "deregister of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
