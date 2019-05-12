package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chentianyu1
 * @version $Id: GetLoadBalancerIngNormalTest.java, v 0.1 Apr 25, 2018 10:17:48 AM chentianyu1 Exp $
 */
public class GetLoadBalancerNormalPrepare extends BasePrepare {

    //get vpc_mix detail
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String executeBody = "[{\n"
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
                + "            }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
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
                + "            }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg1 = "{" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"InstanceNum\":4,\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"VpcIps\":[\n" +
//                "        \"192.168.9.199\"\n" +
//                "    ],\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"CertId\":\"" +certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-03\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-02\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }, " +
                "        {\n" +
                "            \"Name\":\"tg-test-01\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
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
                "}\n";

        String updateBody =  "{\"Instances\":[" +
                "{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1 + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", " +
                "\"Weight\":100, " + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        //set response message
        String resMsg2 = "{" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"InstanceNum\":4,\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"VpcIps\":[\n" +
//                "        \"192.168.9.199\"\n" +
//                "    ],\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"CertId\":\"" +certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-03\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-02\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }, " +
                "        {\n" +
                "            \"Name\":\"tg-test-01\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
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
                "}\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb detail", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg1", String.class.toString(), resMsg1, null));
        DataUnits.add(new DataUnit("resMsg2", String.class.toString(), resMsg2, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //get mix detail
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String executeBody = "[{\n"
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
                + "            }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
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
                + "            }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";

        String updateBody =  "{\"Instances\":[" +
                "{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1 + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", " +
                "\"Weight\":100, " + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        //set response message
        String resMsg1 = "{\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"InstanceNum\":4,\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
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
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"CertId\":\"" +certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
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
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-03\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":80,\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":80,\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ], \n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-02\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":80,\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ], \n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-01\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":80,\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ], \n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}\n" +
                "\n";

        String resMsg2 = "{\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"InstanceNum\":4,\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
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
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"CertId\":\"" +certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
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
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-03\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":80,\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":80,\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ], \n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-02\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":80,\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ], \n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-01\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":80,\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ], \n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}\n" +
                "\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb detail", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg1", String.class.toString(), resMsg1, null));
        DataUnits.add(new DataUnit("resMsg2", String.class.toString(), resMsg2, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //get mix detail
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String executeBody = "[{\n"
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
                + "            }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
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
                + "            }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";

        String updateBody =  "{\"Instances\":[" +
                "{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1 + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", " +
                "\"Weight\":100, " + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        //set response message
        String resMsg1 = "{" +
                "    \"Network\":\"idc\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"InstanceNum\":4,\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"VpcIps\":[\n" +
//                "        \"192.168.9.199\"\n" +
//                "    ],\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"CertId\":\"" +certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-03\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-02\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            } \n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-01\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            } \n" +
                "        }\n" +
                "    ],\n" +
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
                "}\n";

        String resMsg2 = "{" +
                "    \"Network\":\"idc\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"InstanceNum\":4,\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"VpcIps\":[\n" +
//                "        \"192.168.9.199\"\n" +
//                "    ],\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"CertId\":\"" +certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-03\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-02\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            } \n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-01\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
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
                "}\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb detail", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg1", String.class.toString(), resMsg1, null));
        DataUnits.add(new DataUnit("resMsg2", String.class.toString(), resMsg2, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //get dns detail
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                + "           \"TargetGroupId\": \"targetGroupId\"\n"
                + "     }], \n"
                + "    \"Timeout\": 100000\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "      }\n"
                + "    ]\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "      }\n"
                + "    ]\n"
                + "}]";

        String updateBody =  "{\"Instances\":[" +
                "{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1 + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", " +
                "\"Weight\":100, " + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        //set response message
        String resMsg1 = "{" +
                "    \"Network\":\"private\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"InstanceNum\":4,\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"VpcIps\":[\n" +
//                "        \"192.168.9.199\"\n" +
//                "    ],\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Timeout\": 100000, \n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"leastconn\",\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-03\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-02\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }, " +
                "        {\n" +
                "            \"Name\":\"tg-test-01\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"SubNetId\":\"" + subNetId + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";

        String resMsg2 = "{" +
                "    \"Network\":\"private\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"InstanceNum\":4,\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"VpcIps\":[\n" +
//                "        \"192.168.9.199\"\n" +
//                "    ],\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Timeout\": 100000, \n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"leastconn\",\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-03\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-02\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }, " +
                "        {\n" +
                "            \"Name\":\"tg-test-01\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"SubNetId\":\"" + subNetId + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb detail", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg1", String.class.toString(), resMsg1, null));
        DataUnits.add(new DataUnit("resMsg2", String.class.toString(), resMsg2, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //get vpc_l4 detail
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group2");
        String sg3 = ConfigLoader.configration.getExtConfig("security_group_default");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                + "           \"TargetGroupId\": \"targetGroupId\"\n"
                + "     }], \n"
                + "    \"Timeout\": 100000\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "      }\n"
                + "    ]\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "      }\n"
                + "    ]\n"
                + "}]";

        String updateBody =  "{\"Instances\":[" +
                "{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1 + "\", \"Port\":80, \"TopAz\":\"" + topAz + "\", " +
                "\"Weight\":100, " + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";

        //set response message
        String resMsg1 = "{" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"vpc_l4\",\n" +
                "    \"InstanceNum\":4,\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"VpcIps\":[\n" +
//                "        \"192.168.9.199\"\n" +
//                "    ],\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Timeout\": 100000, \n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"leastconn\",\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-03\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-02\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }, " +
                "        {\n" +
                "            \"Name\":\"tg-test-01\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"SubNetId\":\"" + subNetId + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";

        String resMsg2 = "{" +
                "    \"Network\":\"public\",\n" +
                "    \"Description\":\"abcd\",\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
//                "    \"InstanceStatus\":\"UP\",\n" +
                "    \"Type\":\"vpc_l4\",\n" +
                "    \"InstanceNum\":4,\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
//                "    \"VpcIps\":[\n" +
//                "        \"192.168.9.199\"\n" +
//                "    ],\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Timeout\": 100000, \n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }, \n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"Protocol\":\"tcp\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"leastconn\",\n" +
//                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            },\n" +
//                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
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
                "        \"PathLimit\":30\n" +
                "    },\n" +
                "    \"TargetGroups\":[\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-03\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }, \n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":2,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"tg-test-02\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":10,\n" +
                "                \"Fall\":10,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":7000,\n" +
                "                \"Period\":7000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }, " +
                "        {\n" +
                "            \"Name\":\"tg-test-01\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" +realServer1 + "\",\n" +
                "                            \"Name\":\"" + rsName1 + "\",\n" +
                "                            \"Address\":\"" + rsAddress1 + "\",\n" +
                "                            \"Port\":80,\n" +
//                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":6,\n" +
                "                \"Fall\":6,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"SubNetId\":\"" + subNetId + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get lb detail", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), tenantId, null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg1", String.class.toString(), resMsg1, null));
        DataUnits.add(new DataUnit("resMsg2", String.class.toString(), resMsg2, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
