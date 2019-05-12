package com.netease.cloudqa.nlb.api.test.prepare.slighttest;

import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

public class SessionStickyNormalPrepare extends BasePrepare {

    //mix session sticky
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder sessionStickyNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        String targetGroup = "[" +
                "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":80,\n" +
                "            \"Id\":\"" +realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2+ "\",\n" +
                "            \"Port\":80,\n" +
                "            \"Id\":\"" +realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Rstatus\":\"2xx,3xx\",\n" +
                "        \"Period\":5000,\n" +
                "        \"Fall\":5,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Rise\":5\n" +
                "    },\n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test-01\"\n" +
                "}" +
                "]";

        //set request body
        String listener = "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 80,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                +              "\"ServerName\": \"*\",\n"
                + "            \"Path\": \"/\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"insert\",\n"
                + "                \"Expire\": \"5\"\n"
                + "            }\n"
                + "     }"
                + "],\n"
                + "    \"Gzip\": 1\n"
                + "}";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":80,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"*\",\n" +
                "                    \"Path\":\"/\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":5,\n" +
                "                        \"Fall\":5,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":5000,\n" +
                "                        \"Period\":5000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\": 5\n" +
                "                    },\n" +
                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "sessionStickyNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "session sticky normal test of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("targetGroup", String.class.toString(), targetGroup, null));
        DataUnits.add(new DataUnit("listener", String.class.toString(), listener, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix session sticky
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder sessionStickyNormalPrepare002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        String targetGroup = "[" +
                "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":80,\n" +
                "            \"Id\":\"" +realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2+ "\",\n" +
                "            \"Port\":80,\n" +
                "            \"Id\":\"" +realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Rstatus\":\"2xx,3xx\",\n" +
                "        \"Period\":5000,\n" +
                "        \"Fall\":5,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Rise\":5\n" +
                "    },\n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test-01\"\n" +
                "}" +
                "]";

        //set request body
        String listener = "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 80,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                +              "\"ServerName\": \"*\",\n"
                + "            \"Path\": \"/\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"testcookie\"\n"
                + "            }\n"
                + "     }"
                + "],\n"
                + "    \"Gzip\": 1\n"
                + "}";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":80,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"*\",\n" +
                "                    \"Path\":\"/\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":5,\n" +
                "                        \"Fall\":5,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":5000,\n" +
                "                        \"Period\":5000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\": \"testcookie\"\n" +
                "                    },\n" +
                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "sessionStickyNormalPrepare002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "session sticky normal test of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("targetGroup", String.class.toString(), targetGroup, null));
        DataUnits.add(new DataUnit("listener", String.class.toString(), listener, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //mix session sticky
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder sessionStickyNormalPrepare003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        String targetGroup = "[" +
                "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":80,\n" +
                "            \"Id\":\"" +realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2+ "\",\n" +
                "            \"Port\":80,\n" +
                "            \"Id\":\"" +realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Rstatus\":\"2xx,3xx\",\n" +
                "        \"Period\":5000,\n" +
                "        \"Fall\":5,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Rise\":5\n" +
                "    },\n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test-01\"\n" +
                "}" +
                "]";

        //set request body
        String listener = "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 80,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                +              "\"ServerName\": \"*\",\n"
                + "            \"Path\": \"/\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"insert\",\n"
                + "                \"Expire\": \"5\"\n"
                + "            }\n"
                + "     }"
                + "],\n"
                + "    \"Gzip\": 1\n"
                + "}";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":80,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"*\",\n" +
                "                    \"Path\":\"/\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":5,\n" +
                "                        \"Fall\":5,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":5000,\n" +
                "                        \"Period\":5000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\": 5\n" +
                "                    },\n" +
                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "sessionStickyNormalPrepare003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "session sticky normal test of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("targetGroup", String.class.toString(), targetGroup, null));
        DataUnits.add(new DataUnit("listener", String.class.toString(), listener, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix session sticky
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder sessionStickyNormalPrepare004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        String targetGroup = "[" +
                "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":80,\n" +
                "            \"Id\":\"" +realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2+ "\",\n" +
                "            \"Port\":80,\n" +
                "            \"Id\":\"" +realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Rstatus\":\"2xx,3xx\",\n" +
                "        \"Period\":5000,\n" +
                "        \"Fall\":5,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Rise\":5\n" +
                "    },\n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test-01\"\n" +
                "}" +
                "]";

        //set request body
        String listener = "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 80,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                +              "\"ServerName\": \"*\",\n"
                + "            \"Path\": \"/\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"testcookie\"\n"
                + "            }\n"
                + "     }"
                + "],\n"
                + "    \"Gzip\": 1\n"
                + "}";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":80,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"*\",\n" +
                "                    \"Path\":\"/\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":5,\n" +
                "                        \"Fall\":5,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":5000,\n" +
                "                        \"Period\":5000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\": \"testcookie\"\n" +
                "                    },\n" +
                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "sessionStickyNormalPrepare004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "session sticky normal test of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("targetGroup", String.class.toString(), targetGroup, null));
        DataUnits.add(new DataUnit("listener", String.class.toString(), listener, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
