package com.netease.cloudqa.nlb.api.test.prepare.slighttest;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

public class BackendWeightNormalPrepare extends BasePrepare {

    //创建一个http监听，一个目标组两个后端，weight=50,100
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder backendWeightNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "     }],\n"
                + "    \"Gzip\": 1\n"
                + "}]";

        String updateTgBody = "{\"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", "
                + "\"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":50, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":1" +
                "}";

        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "backendWeightNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "backend weight test of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("updateTgBody", String.class.toString(), updateTgBody, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建一个http监听，一个目标组两个后端，weight=99,33
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder backendWeightNormalPrepare002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "     }],\n"
                + "    \"Gzip\": 1\n"
                + "}]";

        String updateTgBody = "{\"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", "
                + "\"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":99, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":33, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":1" +
                "}";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "backendWeightNormalPrepare002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "backend weight test of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("updateTgBody", String.class.toString(), updateTgBody, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建一个tcp监听，一个目标组两个后端，weight=100,50
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder backendWeightNormalPrepare003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 20,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "     }]\n"
                + "}]";
        String updateTgBody = "{\"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", "
                + "\"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":50, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":100, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":1" +
                "}";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":20,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"Balance\":\"roundrobin\",\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":2,\n" +
                "                        \"Fall\":2,\n" +
                "                        \"Url\":\"/\",\n" +
                "                        \"Timeout\":5000,\n" +
                "                        \"Period\":5000\n" +
                "                    },\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "backendWeightNormalPrepare003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "backend weight test of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("updateTgBody", String.class.toString(), updateTgBody, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建一个tcp监听，一个目标组两个后端，weight=99,33
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder backendWeightNormalPrepare004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 20,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "     }]\n"
                + "}]";
        String updateTgBody = "{\"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", "
                + "\"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":33, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":99, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":1" +
                "}";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":20,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"Balance\":\"leastconn\",\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":2,\n" +
                "                        \"Fall\":2,\n" +
                "                        \"Url\":\"/\",\n" +
                "                        \"Timeout\":5000,\n" +
                "                        \"Period\":5000\n" +
                "                    },\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "backendWeightNormalPrepare004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "backend weight test of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("updateTgBody", String.class.toString(), updateTgBody, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
