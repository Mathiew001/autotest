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

public class KsslNormalPrepare extends BasePrepare {

    //重复创建3次mix https监听
    @CaseLabel(lbType = { "ha1.8mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder ksslNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String certId2 = ConfigLoader.configration.getExtConfig("cert_id2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String createLnBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\"\n"
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
                + "     }],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"insert\",\n"
                + "                \"Expire\": 30000\n"
                + "            },\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"insert\",\n"
                + "                \"Expire\": 30000\n"
                + "            },\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";

        String updateLnBody = "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId2 + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\"\n"
                + "            }\n"
                + "     }],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}";

        String updateLbBody = "{\n" +
                "    \"InstanceId\": \"instanceId\",\n" +
                "    \"Attrs\": {\n" +
                "        \"StopTimeout\": 12345,\n" +
                "        \"UseSSLAcc\": -1,\n" +
                "    }\n" +
                "}";

        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                \"Instances\":[\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "ksslNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb https listener of mix with kssl", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createLnBody", String.class.toString(), createLnBody, null));
        DataUnits.add(new DataUnit("updateLnBody", String.class.toString(), updateLnBody, null));
        DataUnits.add(new DataUnit("updateLbBody", String.class.toString(), updateLbBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer100", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("certId", String.class.toString(), certId, null));
        DataUnits.add(new DataUnit("certId2", String.class.toString(), certId2, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次vpc_mix https监听
    @CaseLabel(lbType = { "ha1.8vpc" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder ksslNormalPrepare002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String certId2 = ConfigLoader.configration.getExtConfig("cert_id2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String createLnBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\"\n"
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
                + "     }],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"insert\",\n"
                + "                \"Expire\": 30000\n"
                + "            },\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"insert\",\n"
                + "                \"Expire\": 30000\n"
                + "            },\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";

        String updateLnBody = "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId2 + "\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\"\n"
                + "            }\n"
                + "     }],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}";

        String updateLbBody = "{\n" +
                "    \"InstanceId\": \"instanceId\",\n" +
                "    \"Attrs\": {\n" +
                "        \"StopTimeout\": 12345,\n" +
                "        \"UseSSLAcc\": -1,\n" +
                "    }\n" +
                "}";

        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                \"Instances\":[\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "ksslNormalPrepare002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb https listener of vpc_mix with kssl", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createLnBody", String.class.toString(), createLnBody, null));
        DataUnits.add(new DataUnit("updateLnBody", String.class.toString(), updateLnBody, null));
        DataUnits.add(new DataUnit("updateLbBody", String.class.toString(), updateLbBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("certId", String.class.toString(), certId, null));
        DataUnits.add(new DataUnit("certId2", String.class.toString(), certId2, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

//    //重复创建3次mix tls监听
//    @CaseLabel(lbType = { "mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder ksslNormalPrepare003() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        String certId = ConfigLoader.configration.getExtConfig("cert_id");
//        String certId2 = ConfigLoader.configration.getExtConfig("cert_id2");
//        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
//        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
//        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
//        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
//        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
//        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
//        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
//        //set request body
//        String executeBody = "[{\n"
//                + "    \"InstanceId\": \"\",\n"
//                + "    \"Name\": \"testln1\",\n"
//                + "    \"ListenPort\": 20,\n"
//                + "    \"Protocol\": \"tls\",\n"
//                + "    \"Balance\": \"roundrobin\",\n"
//                + "    \"Clusters\": [\n"
//                + "        {\n"
//                + "            \"TargetGroupId\": \"\",\n"
//                + "            \"CertId\": \"" + certId + "\",\n"
//                + "            \"Monitor\": {\n"
//                + "              \"Period\": 6000,\n"
//                + "              \"Timeout\": 6000,\n"
//                + "              \"Rise\": 6,\n"
//                + "              \"Fall\": 6,\n"
//                + "              \"Protocol\": \"http\",\n"
//                + "              \"Url\": \"/index.html\",\n"
//                + "              \"Rstatus\": \"2xx,3xx\" \n"
//                + "            }\n"
//                + "        }\n"
//                + "    ],\n"
//                + "    \"Timeout\": 1000000,\n"
//                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
//                + "},"
//                + "{\n"
//                + "    \"InstanceId\": \"\",\n"
//                + "    \"Name\": \"testln2\",\n"
//                + "    \"ListenPort\": 21,\n"
//                + "    \"Protocol\": \"tls\",\n"
//                + "    \"Balance\": \"roundrobin\",\n"
//                + "    \"Clusters\": [\n"
//                + "        {\n"
//                + "            \"TargetGroupId\": \"\",\n"
//                + "            \"CertId\": \"" + certId + "\",\n"
//                + "            \"Monitor\": {\n"
//                + "              \"Period\": 6000,\n"
//                + "              \"Timeout\": 6000,\n"
//                + "              \"Rise\": 6,\n"
//                + "              \"Fall\": 6,\n"
//                + "              \"Protocol\": \"http\",\n"
//                + "              \"Url\": \"/index.html\",\n"
//                + "              \"Rstatus\": \"2xx,3xx\" \n"
//                + "            }\n"
//                + "        }\n"
//                + "    ],\n"
//                + "    \"Timeout\": 1000000,\n"
//                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
//                + "},"
//                + "{\n"
//                + "    \"InstanceId\": \"\",\n"
//                + "    \"Name\": \"testln3\",\n"
//                + "    \"ListenPort\": 22,\n"
//                + "    \"Protocol\": \"tls\",\n"
//                + "    \"Balance\": \"leastconn\",\n"
//                + "    \"Clusters\": [\n"
//                + "        {\n"
//                + "            \"TargetGroupId\": \"\",\n"
//                + "            \"CertId\": \"" + certId + "\",\n"
//
//                + "            \"Monitor\": {\n"
//                + "              \"Period\": 6000,\n"
//                + "              \"Timeout\": 6000,\n"
//                + "              \"Rise\": 6,\n"
//                + "              \"Fall\": 6,\n"
//                + "              \"Protocol\": \"http\",\n"
//                + "              \"Url\": \"/index.html\",\n"
//                + "              \"Rstatus\": \"2xx,3xx\" \n"
//                + "            }\n"
//                + "        }\n"
//                + "    ],\n"
//                + "    \"Timeout\": 1000000,\n"
//                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
//                + "}]";
//
//        String updateBody = "{\n"
//                + "    \"InstanceId\": \"instanceId\",\n"
//                + "    \"Balance\": \"roundrobin\",\n"
//                + "    \"Clusters\": [\n"
//                + "     {\n"
//                + "            \"TargetGroupId\": \"targetGroupId\",\n"
//                + "            \"CertId\": \"" + certId2 + "\"\n"
//                + "     }],\n"
//                + "    \"Gzip\": 1,\n"
//                + "    \"TraceVip\": 1,\n"
//                + "    \"ForwardPort\": 1,\n"
//                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
//                + "}";
//
//        //set response message
//        String resMsg = "[\n" +
//                "    {\n" +
////                "        \"Status\":\"ON\",\n" +
//                "        \"Timeout\":1000000,\n" +
//                "        \"TraceVip\":0,\n" +
//                "        \"ListenPort\":20,\n" +
//                "        \"Name\":\"testln1\",\n" +
//                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Gzip\":0,\n" +
//                "        \"Clusters\":[\n" +
//                "            {\n" +
////                "                \"Status\":\"UP\",\n" +
//                "                \"Instances\":[\n" +
//                "                    {\n" +
////                "                        \"Status\":\"UP\",\n" +
//                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
//                "                        \"Port\":80,\n" +
//                "                        \"Backup\":0,\n" +
//                "                        \"Id\":\"" + realServer1 + "\",\n" +
//                "                        \"Weight\":100,\n" +
//                "                        \"Name\":\"" + rsName1 + "\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"Monitor\":{\n" +
//                "                    \"Timeout\":6000,\n" +
//                "                    \"Rstatus\":\"2xx,3xx\",\n" +
//                "                    \"Period\":6000,\n" +
//                "                    \"Fall\":6,\n" +
//                "                    \"Protocol\":\"http\",\n" +
//                "                    \"Url\":\"/index.html\",\n" +
//                "                    \"Rise\":6\n" +
//                "                },\n" +
//                "                \"CertId\":\"" + certId + "\",\n" +
//                "                \"Name\":\"tg-test-01\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"Protocol\":\"tls\",\n" +
//                "        \"Balance\":\"roundrobin\"\n" +
//                "    },\n" +
//                "    {\n" +
////                "        \"Status\":\"ON\",\n" +
//                "        \"Timeout\":1000000,\n" +
//                "        \"TraceVip\":0,\n" +
//                "        \"ListenPort\":21,\n" +
//                "        \"Name\":\"testln2\",\n" +
//                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Gzip\":0,\n" +
//                "        \"Clusters\":[\n" +
//                "            {\n" +
////                "                \"Status\":\"UP\",\n" +
//                "                \"Instances\":[\n" +
//                "                    {\n" +
////                "                        \"Status\":\"UP\",\n" +
//                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
//                "                        \"Port\":80,\n" +
//                "                        \"Backup\":0,\n" +
//                "                        \"Id\":\"" + realServer2 + "\",\n" +
//                "                        \"Weight\":100,\n" +
//                "                        \"Name\":\"" + rsName2 + "\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"Monitor\":{\n" +
//                "                    \"Timeout\":6000,\n" +
//                "                    \"Rstatus\":\"2xx,3xx\",\n" +
//                "                    \"Period\":6000,\n" +
//                "                    \"Fall\":6,\n" +
//                "                    \"Protocol\":\"http\",\n" +
//                "                    \"Url\":\"/index.html\",\n" +
//                "                    \"Rise\":6\n" +
//                "                },\n" +
//                "                \"CertId\":\"" + certId + "\",\n" +
//                "                \"Name\":\"tg-test-02\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"Protocol\":\"tls\",\n" +
//                "        \"Balance\":\"roundrobin\"\n" +
//                "    },\n" +
//                "    {\n" +
////                "        \"Status\":\"ON\",\n" +
//                "        \"Timeout\":1000000,\n" +
//                "        \"TraceVip\":0,\n" +
//                "        \"ListenPort\":22,\n" +
//                "        \"Name\":\"testln3\",\n" +
//                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Gzip\":0,\n" +
//                "        \"Clusters\":[\n" +
//                "            {\n" +
////                "                \"Status\":\"UP\",\n" +
//                "                \"Instances\":[\n" +
//                "                    {\n" +
////                "                        \"Status\":\"UP\",\n" +
//                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
//                "                        \"Port\":80,\n" +
//                "                        \"Backup\":0,\n" +
//                "                        \"Id\":\"" + realServer1 + "\",\n" +
//                "                        \"Weight\":100,\n" +
//                "                        \"Name\":\"" + rsName1 + "\"\n" +
//                "                    },\n" +
//                "                    {\n" +
////                "                        \"Status\":\"UP\",\n" +
//                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
//                "                        \"Port\":80,\n" +
//                "                        \"Backup\":0,\n" +
//                "                        \"Id\":\"" + realServer2 + "\",\n" +
//                "                        \"Weight\":100,\n" +
//                "                        \"Name\":\"" + rsName2 + "\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"Monitor\":{\n" +
//                "                    \"Timeout\":6000,\n" +
//                "                    \"Rstatus\":\"2xx,3xx\",\n" +
//                "                    \"Period\":6000,\n" +
//                "                    \"Fall\":6,\n" +
//                "                    \"Protocol\":\"http\",\n" +
//                "                    \"Url\":\"/index.html\",\n" +
//                "                    \"Rise\":6\n" +
//                "                },\n" +
//                "                \"CertId\":\"" + certId + "\",\n" +
//                "                \"Name\":\"tg-test-03\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"Protocol\":\"tls\",\n" +
//                "        \"Balance\":\"leastconn\"\n" +
//                "    }\n" +
//                "]";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "ksslNormalPrepare003", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tls listener of mix with kssl", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
//        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer100", null));
//        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
//        DataUnits.add(new DataUnit("certId", String.class.toString(), certId, null));
//        DataUnits.add(new DataUnit("certId2", String.class.toString(), certId2, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //重复创建3次vpc_mix tls监听
//    @CaseLabel(lbType = { "vpc_mix" })
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder ksslNormalPrepare004() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        String certId = ConfigLoader.configration.getExtConfig("cert_id");
//        String certId2 = ConfigLoader.configration.getExtConfig("cert_id2");
//        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
//        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
//        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
//        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
//        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
//        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
//        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
//        //set request body
//        String executeBody = "[{\n"
//                + "    \"InstanceId\": \"\",\n"
//                + "    \"Name\": \"testln1\",\n"
//                + "    \"ListenPort\": 20,\n"
//                + "    \"Protocol\": \"tls\",\n"
//                + "    \"Balance\": \"roundrobin\",\n"
//                + "    \"Clusters\": [\n"
//                + "        {\n"
//                + "            \"TargetGroupId\": \"\",\n"
//                + "            \"CertId\": \"" + certId + "\",\n"
//                + "            \"Monitor\": {\n"
//                + "              \"Period\": 6000,\n"
//                + "              \"Timeout\": 6000,\n"
//                + "              \"Rise\": 6,\n"
//                + "              \"Fall\": 6,\n"
//                + "              \"Protocol\": \"http\",\n"
//                + "              \"Url\": \"/index.html\",\n"
//                + "              \"Rstatus\": \"2xx,3xx\" \n"
//                + "            }\n"
//                + "        }\n"
//                + "    ],\n"
//                + "    \"Timeout\": 1000000,\n"
//                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
//                + "},"
//                + "{\n"
//                + "    \"InstanceId\": \"\",\n"
//                + "    \"Name\": \"testln2\",\n"
//                + "    \"ListenPort\": 21,\n"
//                + "    \"Protocol\": \"tls\",\n"
//                + "    \"Balance\": \"roundrobin\",\n"
//                + "    \"Clusters\": [\n"
//                + "        {\n"
//                + "            \"TargetGroupId\": \"\",\n"
//                + "            \"CertId\": \"" + certId + "\",\n"
//                + "            \"Monitor\": {\n"
//                + "              \"Period\": 6000,\n"
//                + "              \"Timeout\": 6000,\n"
//                + "              \"Rise\": 6,\n"
//                + "              \"Fall\": 6,\n"
//                + "              \"Protocol\": \"http\",\n"
//                + "              \"Url\": \"/index.html\",\n"
//                + "              \"Rstatus\": \"2xx,3xx\" \n"
//                + "            }\n"
//                + "        }\n"
//                + "    ],\n"
//                + "    \"Timeout\": 1000000,\n"
//                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
//                + "},"
//                + "{\n"
//                + "    \"InstanceId\": \"\",\n"
//                + "    \"Name\": \"testln3\",\n"
//                + "    \"ListenPort\": 22,\n"
//                + "    \"Protocol\": \"tls\",\n"
//                + "    \"Balance\": \"leastconn\",\n"
//                + "    \"Clusters\": [\n"
//                + "        {\n"
//                + "            \"TargetGroupId\": \"\",\n"
//                + "            \"CertId\": \"" + certId + "\",\n"
//
//                + "            \"Monitor\": {\n"
//                + "              \"Period\": 6000,\n"
//                + "              \"Timeout\": 6000,\n"
//                + "              \"Rise\": 6,\n"
//                + "              \"Fall\": 6,\n"
//                + "              \"Protocol\": \"http\",\n"
//                + "              \"Url\": \"/index.html\",\n"
//                + "              \"Rstatus\": \"2xx,3xx\" \n"
//                + "            }\n"
//                + "        }\n"
//                + "    ],\n"
//                + "    \"Timeout\": 1000000,\n"
//                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
//                + "}]";
//
//        String updateBody = "{\n"
//                + "    \"InstanceId\": \"instanceId\",\n"
//                + "    \"Balance\": \"roundrobin\",\n"
//                + "    \"Clusters\": [\n"
//                + "     {\n"
//                + "            \"TargetGroupId\": \"targetGroupId\",\n"
//                + "            \"CertId\": \"" + certId2 + "\"\n"
//                + "     }],\n"
//                + "    \"Gzip\": 1,\n"
//                + "    \"TraceVip\": 1,\n"
//                + "    \"ForwardPort\": 1,\n"
//                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
//                + "}";
//
//        //set response message
//        String resMsg = "[\n" +
//                "    {\n" +
////                "        \"Status\":\"ON\",\n" +
//                "        \"Timeout\":1000000,\n" +
//                "        \"TraceVip\":0,\n" +
//                "        \"ListenPort\":20,\n" +
//                "        \"Name\":\"testln1\",\n" +
//                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Gzip\":0,\n" +
//                "        \"Clusters\":[\n" +
//                "            {\n" +
////                "                \"Status\":\"UP\",\n" +
//                "                \"Instances\":[\n" +
//                "                    {\n" +
////                "                        \"Status\":\"UP\",\n" +
//                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
//                "                        \"Port\":80,\n" +
//                "                        \"Backup\":0,\n" +
//                "                        \"Id\":\"" + realServer1 + "\",\n" +
//                "                        \"Weight\":100,\n" +
//                "                        \"Name\":\"" + rsName1 + "\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"Monitor\":{\n" +
//                "                    \"Timeout\":6000,\n" +
//                "                    \"Rstatus\":\"2xx,3xx\",\n" +
//                "                    \"Period\":6000,\n" +
//                "                    \"Fall\":6,\n" +
//                "                    \"Protocol\":\"http\",\n" +
//                "                    \"Url\":\"/index.html\",\n" +
//                "                    \"Rise\":6\n" +
//                "                },\n" +
//                "                \"CertId\":\"" + certId + "\",\n" +
//                "                \"Name\":\"tg-test-01\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"Protocol\":\"tls\",\n" +
//                "        \"Balance\":\"roundrobin\"\n" +
//                "    },\n" +
//                "    {\n" +
////                "        \"Status\":\"ON\",\n" +
//                "        \"Timeout\":1000000,\n" +
//                "        \"TraceVip\":0,\n" +
//                "        \"ListenPort\":21,\n" +
//                "        \"Name\":\"testln2\",\n" +
//                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Gzip\":0,\n" +
//                "        \"Clusters\":[\n" +
//                "            {\n" +
////                "                \"Status\":\"UP\",\n" +
//                "                \"Instances\":[\n" +
//                "                    {\n" +
////                "                        \"Status\":\"UP\",\n" +
//                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
//                "                        \"Port\":80,\n" +
//                "                        \"Backup\":0,\n" +
//                "                        \"Id\":\"" + realServer2 + "\",\n" +
//                "                        \"Weight\":100,\n" +
//                "                        \"Name\":\"" + rsName2 + "\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"Monitor\":{\n" +
//                "                    \"Timeout\":6000,\n" +
//                "                    \"Rstatus\":\"2xx,3xx\",\n" +
//                "                    \"Period\":6000,\n" +
//                "                    \"Fall\":6,\n" +
//                "                    \"Protocol\":\"http\",\n" +
//                "                    \"Url\":\"/index.html\",\n" +
//                "                    \"Rise\":6\n" +
//                "                },\n" +
//                "                \"CertId\":\"" + certId + "\",\n" +
//                "                \"Name\":\"tg-test-02\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"Protocol\":\"tls\",\n" +
//                "        \"Balance\":\"roundrobin\"\n" +
//                "    },\n" +
//                "    {\n" +
////                "        \"Status\":\"ON\",\n" +
//                "        \"Timeout\":1000000,\n" +
//                "        \"TraceVip\":0,\n" +
//                "        \"ListenPort\":22,\n" +
//                "        \"Name\":\"testln3\",\n" +
//                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Gzip\":0,\n" +
//                "        \"Clusters\":[\n" +
//                "            {\n" +
////                "                \"Status\":\"UP\",\n" +
//                "                \"Instances\":[\n" +
//                "                    {\n" +
////                "                        \"Status\":\"UP\",\n" +
//                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
//                "                        \"Port\":80,\n" +
//                "                        \"Backup\":0,\n" +
//                "                        \"Id\":\"" + realServer1 + "\",\n" +
//                "                        \"Weight\":100,\n" +
//                "                        \"Name\":\"" + rsName1 + "\"\n" +
//                "                    },\n" +
//                "                    {\n" +
////                "                        \"Status\":\"UP\",\n" +
//                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
//                "                        \"Port\":80,\n" +
//                "                        \"Backup\":0,\n" +
//                "                        \"Id\":\"" + realServer2 + "\",\n" +
//                "                        \"Weight\":100,\n" +
//                "                        \"Name\":\"" + rsName2 + "\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"Monitor\":{\n" +
//                "                    \"Timeout\":6000,\n" +
//                "                    \"Rstatus\":\"2xx,3xx\",\n" +
//                "                    \"Period\":6000,\n" +
//                "                    \"Fall\":6,\n" +
//                "                    \"Protocol\":\"http\",\n" +
//                "                    \"Url\":\"/index.html\",\n" +
//                "                    \"Rise\":6\n" +
//                "                },\n" +
//                "                \"CertId\":\"" + certId + "\",\n" +
//                "                \"Name\":\"tg-test-03\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"Protocol\":\"tls\",\n" +
//                "        \"Balance\":\"leastconn\"\n" +
//                "    }\n" +
//                "]";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "ksslNormalPrepare004", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tls listener of vpc_mix with kssl", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
//        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
//        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
//        DataUnits.add(new DataUnit("certId", String.class.toString(), certId, null));
//        DataUnits.add(new DataUnit("certId2", String.class.toString(), certId2, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
}
