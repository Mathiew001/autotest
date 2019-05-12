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

public class OldNlbNormalPrepare extends BasePrepare {

    //老mix实例，加目标组，加监听
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder oldNlbNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_exist_mix");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body

        String createTargetGroupBody = "{\"Name\":\"tg-test\", \"InstanceId\":\"" + instanceId + "\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":81, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0}";

        String createListenerBody = "[{\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"InstanceId\": \"" + instanceId + "\",\n"
                + "    \"ListenPort\": 80,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"*\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
                + "            },\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"InstanceId\": \"" + instanceId + "\",\n"
                + "    \"ListenPort\": 443,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"*\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
                + "            },\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";

        //set response message
        String resMsg = "{\n" +
                "    \"InstanceId\":\"" + instanceId + "\",\n" +
                "    \"Name\":\"qanotdelete\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":null,\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"InstanceNum\":2,\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":80,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test\",\n" +
                "                    \"ServerName\":\"*\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":81,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":80,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":443,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test\",\n" +
                "                    \"CertId\": \"" + certId + "\",\n" +
                "                    \"ServerName\":\"*\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":81,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":80,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":81 ,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":80,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ], \n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/\",\n" +
                "                \"Timeout\":2000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}\n" +
                "\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "oldNlbNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "old lb test of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createTargetGroupBody", String.class.toString(), createTargetGroupBody, null));
        DataUnits.add(new DataUnit("createListenerBody", String.class.toString(), createListenerBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //老vpc_mix实例，加目标组，加监听
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder oldNlbNormalPrepare002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_exist_vpc_mix");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        //set request body

        String createTargetGroupBody = "{\"Name\":\"tg-test\", \"InstanceId\":\"" + instanceId + "\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":81, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0}";

        String createListenerBody = "[{\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"InstanceId\": \"" + instanceId + "\",\n"
                + "    \"ListenPort\": 80,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"*\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
                + "            },\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"InstanceId\": \"" + instanceId + "\",\n"
                + "    \"ListenPort\": 443,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"*\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
                + "            },\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";

        //set response message
        String resMsg = "{\n" +
                "    \"InstanceId\":\"" + instanceId + "\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Name\":\"qanotdelete-vpc\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":null,\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"InstanceNum\":2,\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":80,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test\",\n" +
                "                    \"ServerName\":\"*\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":81,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":80,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":443,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test\",\n" +
                "                    \"CertId\": \"" + certId + "\",\n" +
                "                    \"ServerName\":\"*\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":81,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":80,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":81,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":80,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ], \n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/\",\n" +
                "                \"Timeout\":2000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }\n" +
                "    ]," +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"SubNetId\":\"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1  + "\",\n" +
                "        \"" + sg2 + "\",\n" +
                "        \"" + sg3 + "\"\n" +
                "    ]\n" +
                "}\n" +
                "\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "oldNlbNormalPrepare002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "old lb test of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createTargetGroupBody", String.class.toString(), createTargetGroupBody, null));
        DataUnits.add(new DataUnit("createListenerBody", String.class.toString(), createListenerBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //老vpc_mix实例，加目标组，加监听
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder oldNlbNormalPrepare003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_exist_dns");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        //set request body

        String createTargetGroupBody = "{\"Name\":\"tg-test\", \"InstanceId\":\"" + instanceId + "\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":81, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0}";

        String createListenerBody = "[{\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"InstanceId\": \"" + instanceId + "\",\n"
                + "    \"ListenPort\": 80,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"*\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
                + "            },\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"InstanceId\": \"" + instanceId + "\",\n"
                + "    \"ListenPort\": 443,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"*\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
                + "            },\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";

        //set response message
        String resMsg = "{\n" +
                "    \"InstanceId\":\"" + instanceId + "\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"Name\":\"qanotdelete-dns\",\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":null,\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"InstanceNum\":2,\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":80,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test\",\n" +
                "                    \"ServerName\":\"*\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":81,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":80,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":443,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test\",\n" +
                "                    \"CertId\": \"" + certId + "\",\n" +
                "                    \"ServerName\":\"*\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":81,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":80,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ],\n" +
                "            \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":81,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":80,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ], \n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/\",\n" +
                "                \"Timeout\":2000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }\n" +
                "    ]," +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"SubNetId\":\"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1  + "\",\n" +
                "        \"" + sg2 + "\",\n" +
                "        \"" + sg3 + "\"\n" +
                "    ]\n" +
                "}\n" +
                "\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "oldNlbNormalPrepare003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "old lb test of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("createTargetGroupBody", String.class.toString(), createTargetGroupBody, null));
        DataUnits.add(new DataUnit("createListenerBody", String.class.toString(), createListenerBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


}
