package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.listener;

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

/**
 *
 * @author chentianyu1
 * @version $Id: CreateLbListenerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CreateLbListenerIngNormalPrepare extends BasePrepare {

    //创建mix http监听
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set config
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String executeBody =
                "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 8887,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 5000,\n" +
                "              \"Timeout\": 5000,\n" +
                "              \"Rise\": 5,\n" +
                "              \"Fall\": 5,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx,4xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"TraceVip\": 0,\n" +
                "    \"ForwardPort\": 0\n" +
                "}, \n" +
                "{\n" +
                "    \"Name\": \"testln2\",\n" +
                "    \"ListenPort\": 8888,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 5000,\n" +
                "              \"Timeout\": 5000,\n" +
                "              \"Rise\": 5,\n" +
                "              \"Fall\": 5,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"ForwardPort\": 1\n" +
                "}]\n";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":0,\n" +
//                "        \"Gzip\":0,\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service1 + "\",\n" +
                "                \"ServerName\":\"test.com\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":5000,\n" +
                "                    \"Rstatus\":\"2xx,3xx,4xx\",\n" +
                "                    \"Period\":5000,\n" +
                "                    \"Fall\":5,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":5\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service2 + "\",\n" +
                "                \"ServerName\":\"test.com\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":8887,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":0,\n" +
                "        \"Gzip\":1,\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service1 + "\",\n" +
                "                \"ServerName\":\"test.com\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":5000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":5000,\n" +
                "                    \"Fall\":5,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":5\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service2 + "\",\n" +
                "                \"ServerName\":\"test.com\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":8888,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing http listener of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建mix tcp监听
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set config
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String executeBody =
                "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 21,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}," +
                "{\n" +
                "    \"Name\": \"testln2\",\n" +
                "    \"ListenPort\": 22,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "[{\n" +
                "            \"Name\": \"testln2\",\n" +
                "            \"ListenPort\": 22,\n" +
                "            \"Protocol\": \"tcp\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"leastconn\",\n" +
                "            \"Timeout\": 1000000,\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
//                "                    \"ClusterPort\": 80,\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Protocol\": \"tcp\"\n" +
                "                    },\n" +
                "                    \"ServiceName\": \"" + service2 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                }\n" +
                "            ]\n" +
                "        }, " +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 21,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing tcp listener of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建mix https监听
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String executeBody =
                "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\", \n" +
                "    \"Gzip\": 0\n" +
                "}," +
                "{\n" +
                "    \"Name\": \"testln2\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
//                "        \"Status\":\"ON\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Timeout\":0,\n" +
//                "        \"Gzip\":0,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service1 + "\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service2 + "\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
//                "        \"Status\":\"ON\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Timeout\":0,\n" +
                "        \"Gzip\":1,\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service1 + "\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service2 + "\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing https listener of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建mix tls监听
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set name
        String name = "qa-temp-" + String.valueOf(new Date().getTime());
        //set request body
        String executeBody =
                "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 21,\n" +
                "    \"Protocol\": \"tls\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"testln2\",\n" +
                "    \"ListenPort\": 22,\n" +
                "    \"Protocol\": \"tls\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = " [" +
                "{\n" +
                "            \"Name\": \"testln2\",\n" +
                "            \"ListenPort\": 22,\n" +
                "            \"Protocol\": \"tls\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"roundrobin\",\n" +
                "            \"Timeout\": 1000000,\n" +
                "            \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"ServiceName\": \"" + service2 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                    \"CertId\": \"" + certId + "\",\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Url\": \"/index.html\",\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "}," +
                "{\n" +
                "            \"Name\": \"testln1\",\n" +
                "            \"ListenPort\": 21,\n" +
                "            \"Protocol\": \"tls\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"roundrobin\",\n" +
                "            \"Timeout\": 1000000,\n" +
                "            \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"ServiceName\": \"" + service1 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                    \"CertId\": \"" + certId + "\",\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Url\": \"/index.html\",\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        } " +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing tls listener of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建vpc_mix http监听
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1_vpc");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2_vpc");
        //set request body
        String executeBody =
                "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 8887,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 5000,\n" +
                "              \"Timeout\": 5000,\n" +
                "              \"Rise\": 5,\n" +
                "              \"Fall\": 5,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx,4xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"ForwardPort\": 0,\n" +
                "    \"TraceVip\": 0\n" +
                "}, \n" +
                "{\n" +
                "    \"Name\": \"testln2\",\n" +
                "    \"ListenPort\": 8888,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 5000,\n" +
                "              \"Timeout\": 5000,\n" +
                "              \"Rise\": 5,\n" +
                "              \"Fall\": 5,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"TraceVip\": 1\n" +
                "}]\n";
        //set response message
        String resMsg = "[{\n" +
                "            \"Name\": \"testln2\",\n" +
                "            \"ListenPort\": 8888,\n" +
                "            \"Protocol\": \"http\",\n" +
                "            \"TraceVip\": 1,\n" +
                "            \"ForwardPort\": 1,\n" +
                "            \"Balance\": \"leastconn\",\n" +
                "            \"Gzip\": 1,\n" +
//                "            \"Timeout\": 0,\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Protocol\": \"tcp\"\n" +
                "                    },\n" +
                "                    \"Path\": \"/a\",\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"insert\",\n" +
                "                        \"Expire\": 30000,\n" +
                "                        \"CookieName\": \"\"\n" +
                "                    },\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"ServiceName\": \"" + service1 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 5,\n" +
                "                        \"Fall\": 5,\n" +
                "                        \"Period\": 5000,\n" +
                "                        \"Timeout\": 5000,\n" +
                "                        \"Url\": \"/index.html\",\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Path\": \"/b\",\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"rewrite\",\n" +
                "                        \"Expire\": 30000,\n" +
                "                        \"CookieName\": \"asfsd\"\n" +
                "                    },\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"ServiceName\": \"" + service2 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                }\n" +
                "            ]\n" +
                "        }, " +
                "{\n" +
                "            \"Name\": \"testln1\",\n" +
                "            \"ListenPort\": 8887,\n" +
                "            \"Protocol\": \"http\",\n" +
                "            \"Status\": \"ON\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"leastconn\",\n" +
//                "            \"Gzip\": 0,\n" +
//                "            \"Timeout\": 0,\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Protocol\": \"tcp\"\n" +
                "                    },\n" +
                "                    \"Path\": \"/a\",\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"insert\",\n" +
                "                        \"Expire\": 30000,\n" +
                "                        \"CookieName\": \"\"\n" +
                "                    },\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"ServiceName\": \"" + service1 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 5,\n" +
                "                        \"Fall\": 5,\n" +
                "                        \"Period\": 5000,\n" +
                "                        \"Timeout\": 5000,\n" +
                "                        \"Url\": \"/index.html\",\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rstatus\": \"2xx,3xx,4xx\"\n" +
                "                    },\n" +
                "                    \"Path\": \"/b\",\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"rewrite\",\n" +
                "                        \"Expire\": 30000,\n" +
                "                        \"CookieName\": \"asfsd\"\n" +
                "                    },\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"ServiceName\": \"" + service2 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                }\n" +
                "            ]\n" +
                "        }]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing http listener of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建vpc_mix tcp监听
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set config
        String service1 = ConfigLoader.configration.getExtConfig("service_name1_vpc");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2_vpc");
        //set request body
        String executeBody =
                "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 21,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"testln2\",\n" +
                "    \"ListenPort\": 22,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "[{\n" +
                "            \"Name\": \"testln2\",\n" +
                "            \"ListenPort\": 22,\n" +
                "            \"Protocol\": \"tcp\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"leastconn\",\n" +
                "            \"Timeout\": 1000000,\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Protocol\": \"tcp\"\n" +
                "                    },\n" +
                "                    \"ServiceName\": \"" + service2 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
//                "                    \"Status\": \"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }, " +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 21,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing tcp listener of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建vpc_mix https监听
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1_vpc");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2_vpc");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");

        //set request body
        String executeBody =
                "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"testln2\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
//                "        \"Status\":\"ON\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Timeout\":0,\n" +
//                "        \"Gzip\":0,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service1 + "\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service2 + "\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
//                "        \"Status\":\"ON\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Timeout\":0,\n" +
                "        \"Gzip\":1,\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service1 + "\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"" + service2 + "\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing https listener of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建vpc_mix tls监听
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1_vpc");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String executeBody =
                "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 21,\n" +
                "    \"Protocol\": \"tls\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"testln2\",\n" +
                "    \"ListenPort\": 22,\n" +
                "    \"Protocol\": \"tls\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = " [{\n" +
                "            \"Name\": \"testln2\",\n" +
                "            \"ListenPort\": 22,\n" +
                "            \"Protocol\": \"tls\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"roundrobin\",\n" +
                "            \"Timeout\": 1000000,\n" +
                "            \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"ServiceName\": \"" + service1 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                    \"CertId\": \"" + certId + "\",\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Url\": \"/index.html\",\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }, " +
                "{\n" +
                "            \"Name\": \"testln1\",\n" +
                "            \"ListenPort\": 21,\n" +
                "            \"Protocol\": \"tls\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"roundrobin\",\n" +
//                "            \"Status\": \"ON\",\n" +
                "            \"Timeout\": 1000000,\n" +
                "            \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"ServiceName\": \"" + service1 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                    \"CertId\": \"" + certId + "\",\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Url\": \"/index.html\",\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "}]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing tls listener of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建idc_vpc_mix http监听
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1_vpc");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2_vpc");
        //set request body
        String executeBody =
                "[{\n" +
                        "    \"Name\": \"testln1\",\n" +
                        "    \"ListenPort\": 8887,\n" +
                        "    \"Protocol\": \"http\",\n" +
                        "    \"Balance\": \"leastconn\",\n" +
                        "    \"Clusters\": [\n" +
                        "        {\n" +
                        "            \"ServerName\": \"test.com\",\n" +
                        "            \"Path\": \"/a\",\n" +
                        "            \"ServiceName\": \"" + service1 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"Policy\": {\n" +
                        "                \"Mode\": \"insert\",\n" +
                        "                \"Expire\": 30000\n" +
                        "            },\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 6000,\n" +
                        "              \"Timeout\": 6000,\n" +
                        "              \"Rise\": 6,\n" +
                        "              \"Fall\": 6,\n" +
                        "              \"Protocol\": \"tcp\"\n" +
                        "            }\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"ServerName\": \"test.com\",\n" +
                        "            \"Path\": \"/b\",\n" +
                        "            \"ServiceName\": \"" + service2 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"Policy\": {\n" +
                        "                \"Mode\": \"rewrite\",\n" +
                        "                \"CookieName\": \"asfsd\"\n" +
                        "            },\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 5000,\n" +
                        "              \"Timeout\": 5000,\n" +
                        "              \"Rise\": 5,\n" +
                        "              \"Fall\": 5,\n" +
                        "              \"Protocol\": \"http\",\n" +
                        "              \"Url\": \"/index.html\",\n" +
                        "              \"Rstatus\": \"2xx,3xx\"\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"Gzip\": 1\n" +
                        "}, \n" +
                        "{\n" +
                        "    \"Name\": \"testln2\",\n" +
                        "    \"ListenPort\": 8888,\n" +
                        "    \"Protocol\": \"http\",\n" +
                        "    \"Balance\": \"leastconn\",\n" +
                        "    \"Clusters\": [\n" +
                        "        {\n" +
                        "            \"ServerName\": \"test.com\",\n" +
                        "            \"Path\": \"/a\",\n" +
                        "            \"ServiceName\": \"" + service1 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"Policy\": {\n" +
                        "                \"Mode\": \"insert\",\n" +
                        "                \"Expire\": 30000\n" +
                        "            },\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 6000,\n" +
                        "              \"Timeout\": 6000,\n" +
                        "              \"Rise\": 6,\n" +
                        "              \"Fall\": 6,\n" +
                        "              \"Protocol\": \"tcp\"\n" +
                        "            }\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"ServerName\": \"test.com\",\n" +
                        "            \"Path\": \"/b\",\n" +
                        "            \"ServiceName\": \"" + service2 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"Policy\": {\n" +
                        "                \"Mode\": \"rewrite\",\n" +
                        "                \"CookieName\": \"asfsd\"\n" +
                        "            },\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 5000,\n" +
                        "              \"Timeout\": 5000,\n" +
                        "              \"Rise\": 5,\n" +
                        "              \"Fall\": 5,\n" +
                        "              \"Protocol\": \"http\",\n" +
                        "              \"Url\": \"/index.html\",\n" +
                        "              \"Rstatus\": \"2xx,3xx\"\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"Gzip\": 1\n" +
                        "}]\n";
        //set response message
        String resMsg = "[{\n" +
                "            \"Name\": \"testln2\",\n" +
                "            \"ListenPort\": 8888,\n" +
                "            \"Protocol\": \"http\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"leastconn\",\n" +
                "            \"Gzip\": 1,\n" +
//                "            \"Timeout\": 0,\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Protocol\": \"tcp\"\n" +
                "                    },\n" +
                "                    \"Path\": \"/a\",\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"insert\",\n" +
                "                        \"Expire\": 30000,\n" +
                "                        \"CookieName\": \"\"\n" +
                "                    },\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"ServiceName\": \"" + service1 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
//                "                    \"Status\": \"UP\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 5,\n" +
                "                        \"Fall\": 5,\n" +
                "                        \"Period\": 5000,\n" +
                "                        \"Timeout\": 5000,\n" +
                "                        \"Url\": \"/index.html\",\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Path\": \"/b\",\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"rewrite\",\n" +
                "                        \"Expire\": 30000,\n" +
                "                        \"CookieName\": \"asfsd\"\n" +
                "                    },\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"ServiceName\": \"" + service2 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
//                "                    \"Status\": \"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }, " +
                "{\n" +
                "            \"Name\": \"testln1\",\n" +
                "            \"ListenPort\": 8887,\n" +
                "            \"Protocol\": \"http\",\n" +
//                "            \"Status\": \"ON\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"leastconn\",\n" +
                "            \"Gzip\": 1,\n" +
//                "            \"Timeout\": 0,\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Protocol\": \"tcp\"\n" +
                "                    },\n" +
                "                    \"Path\": \"/a\",\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"insert\",\n" +
                "                        \"Expire\": 30000,\n" +
                "                        \"CookieName\": \"\"\n" +
                "                    },\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"ServiceName\": \"" + service1 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
//                "                    \"Status\": \"UP\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 5,\n" +
                "                        \"Fall\": 5,\n" +
                "                        \"Period\": 5000,\n" +
                "                        \"Timeout\": 5000,\n" +
                "                        \"Url\": \"/index.html\",\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Path\": \"/b\",\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"rewrite\",\n" +
                "                        \"Expire\": 30000,\n" +
                "                        \"CookieName\": \"asfsd\"\n" +
                "                    },\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"ServiceName\": \"" + service2 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
//                "                    \"Status\": \"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing http listener of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal016", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建idc_vpc_mix tcp监听
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set config
        String service1 = ConfigLoader.configration.getExtConfig("service_name1_vpc");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2_vpc");
        //set request body
        String executeBody =
                "[{\n" +
                        "    \"Name\": \"testln1\",\n" +
                        "    \"ListenPort\": 21,\n" +
                        "    \"Protocol\": \"tcp\",\n" +
                        "    \"Balance\": \"leastconn\",\n" +
                        "    \"Timeout\": 1000000,\n" +
                        "    \"Clusters\": [\n" +
                        "        {\n" +
                        "            \"ServiceName\": \"" + service1 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"Policy\": {\n" +
                        "                \"Mode\": \"insert\",\n" +
                        "                \"Expire\": 30000\n" +
                        "            },\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 6000,\n" +
                        "              \"Timeout\": 6000,\n" +
                        "              \"Rise\": 6,\n" +
                        "              \"Fall\": 6,\n" +
                        "              \"Protocol\": \"tcp\"\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}, " +
                        "{\n" +
                        "    \"Name\": \"testln2\",\n" +
                        "    \"ListenPort\": 22,\n" +
                        "    \"Protocol\": \"tcp\",\n" +
                        "    \"Balance\": \"leastconn\",\n" +
                        "    \"Timeout\": 1000000,\n" +
                        "    \"Clusters\": [\n" +
                        "        {\n" +
                        "            \"ServiceName\": \"" + service2 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"Policy\": {\n" +
                        "                \"Mode\": \"insert\",\n" +
                        "                \"Expire\": 30000\n" +
                        "            },\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 6000,\n" +
                        "              \"Timeout\": 6000,\n" +
                        "              \"Rise\": 6,\n" +
                        "              \"Fall\": 6,\n" +
                        "              \"Protocol\": \"tcp\"\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}]";
        //set response message
        String resMsg = "[{\n" +
                "            \"Name\": \"testln2\",\n" +
                "            \"ListenPort\": 22,\n" +
                "            \"Protocol\": \"tcp\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"leastconn\",\n" +
                "            \"Timeout\": 1000000,\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Protocol\": \"tcp\"\n" +
                "                    },\n" +
                "                    \"ServiceName\": \"" + service2 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
//                "                    \"Status\": \"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }, " +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 21,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Timeout\": 1000000,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing tcp listener of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal016", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建idc_vpc_mix https监听
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1_vpc");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2_vpc");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String executeBody =
                "[{\n" +
                        "    \"Name\": \"testln1\",\n" +
                        "    \"ListenPort\": 1025,\n" +
                        "    \"Protocol\": \"https\",\n" +
                        "    \"Balance\": \"roundrobin\",\n" +
                        "    \"Clusters\": [\n" +
                        "        {\n" +
                        "            \"ServerName\": \"*\",\n" +
                        "            \"Path\": \"/a\",\n" +
                        "            \"ServiceName\": \"" + service1 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"CertId\": \"" + certId + "\",\n" +
                        "            \"Policy\": {\n" +
                        "                \"Mode\": \"rewrite\",\n" +
                        "                \"CookieName\": \"asfsd\",\n" +
                        "                \"Expire\": 30000\n" +
                        "            },\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 6000,\n" +
                        "              \"Timeout\": 6000,\n" +
                        "              \"Rise\": 6,\n" +
                        "              \"Fall\": 6,\n" +
                        "              \"Protocol\": \"http\",\n" +
                        "              \"Url\": \"/index.html\",\n" +
                        "              \"Rstatus\": \"2xx,3xx\" \n" +
                        "            }\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"ServerName\": \"*\",\n" +
                        "            \"Path\": \"/b\",\n" +
                        "            \"ServiceName\": \"" + service2 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"CertId\": \"" + certId + "\",\n" +
                        "            \"Policy\": {\n" +
                        "                \"Mode\": \"insert\",\n" +
                        "                \"Expire\": 30000\n" +
                        "            },\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 6000,\n" +
                        "              \"Timeout\": 6000,\n" +
                        "              \"Rise\": 6,\n" +
                        "              \"Fall\": 6,\n" +
                        "              \"Protocol\": \"tcp\"\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"Gzip\": 1,\n" +
                        "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                        "}, " +
                        "{\n" +
                        "    \"Name\": \"testln2\",\n" +
                        "    \"ListenPort\": 1026,\n" +
                        "    \"Protocol\": \"https\",\n" +
                        "    \"Balance\": \"roundrobin\",\n" +
                        "    \"Clusters\": [\n" +
                        "        {\n" +
                        "            \"ServerName\": \"*\",\n" +
                        "            \"Path\": \"/a\",\n" +
                        "            \"ServiceName\": \"" + service1 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"CertId\": \"" + certId + "\",\n" +
                        "            \"Policy\": {\n" +
                        "                \"Mode\": \"rewrite\",\n" +
                        "                \"CookieName\": \"asfsd\",\n" +
                        "                \"Expire\": 30000\n" +
                        "            },\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 6000,\n" +
                        "              \"Timeout\": 6000,\n" +
                        "              \"Rise\": 6,\n" +
                        "              \"Fall\": 6,\n" +
                        "              \"Protocol\": \"http\",\n" +
                        "              \"Url\": \"/index.html\",\n" +
                        "              \"Rstatus\": \"2xx,3xx\" \n" +
                        "            }\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"ServerName\": \"*\",\n" +
                        "            \"Path\": \"/b\",\n" +
                        "            \"ServiceName\": \"" + service2 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"CertId\": \"" + certId + "\",\n" +
                        "            \"Policy\": {\n" +
                        "                \"Mode\": \"insert\",\n" +
                        "                \"Expire\": 30000\n" +
                        "            },\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 6000,\n" +
                        "              \"Timeout\": 6000,\n" +
                        "              \"Rise\": 6,\n" +
                        "              \"Fall\": 6,\n" +
                        "              \"Protocol\": \"tcp\"\n" +
                        "            }\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"Gzip\": 1,\n" +
                        "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                        "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
//                "        \"Status\":\"ON\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Timeout\":900000,\n" +
                "        \"Gzip\":1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"service1\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"service2\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Updatetime\":1528186117000,\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
//                "        \"Status\":\"ON\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
//                "        \"Timeout\":900000,\n" +
                "        \"Gzip\":1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"service1\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\"\n" +
                "                },\n" +
                "                \"ServicePort\":80,\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServiceName\":\"service2\",\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"*\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing https listener of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal016", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建vpc_mix tls监听
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1_vpc");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String executeBody =
                "[{\n" +
                        "    \"Name\": \"testln1\",\n" +
                        "    \"ListenPort\": 21,\n" +
                        "    \"Protocol\": \"tls\",\n" +
                        "    \"Balance\": \"roundrobin\",\n" +
                        "    \"Clusters\": [\n" +
                        "        {\n" +
                        "            \"ServerName\": \"*\",\n" +
                        "            \"Path\": \"/a\",\n" +
                        "            \"ServiceName\": \"" + service1 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"CertId\": \"" + certId + "\",\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 6000,\n" +
                        "              \"Timeout\": 6000,\n" +
                        "              \"Rise\": 6,\n" +
                        "              \"Fall\": 6,\n" +
                        "              \"Protocol\": \"http\",\n" +
                        "              \"Url\": \"/index.html\",\n" +
                        "              \"Rstatus\": \"2xx,3xx\" \n" +
                        "            }\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"Timeout\": 1000000,\n" +
                        "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                        "}, " +
                        "{\n" +
                        "    \"Name\": \"testln2\",\n" +
                        "    \"ListenPort\": 22,\n" +
                        "    \"Protocol\": \"tls\",\n" +
                        "    \"Balance\": \"roundrobin\",\n" +
                        "    \"Clusters\": [\n" +
                        "        {\n" +
                        "            \"ServiceName\": \"" + service1 + "\",\n" +
                        "            \"ServicePort\": 80,\n" +
                        "            \"CertId\": \"" + certId + "\",\n" +
                        "            \"Monitor\": {\n" +
                        "              \"Period\": 6000,\n" +
                        "              \"Timeout\": 6000,\n" +
                        "              \"Rise\": 6,\n" +
                        "              \"Fall\": 6,\n" +
                        "              \"Protocol\": \"http\",\n" +
                        "              \"Url\": \"/index.html\",\n" +
                        "              \"Rstatus\": \"2xx,3xx\" \n" +
                        "            }\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"Timeout\": 1000000,\n" +
                        "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                        "}]";
        //set response message
        String resMsg = " [{\n" +
                "            \"Name\": \"testln2\",\n" +
                "            \"ListenPort\": 22,\n" +
                "            \"Protocol\": \"tls\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"roundrobin\",\n" +
                "            \"Timeout\": 1000000,\n" +
                "            \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"ServiceName\": \"" + service1 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                    \"CertId\": \"" + certId + "\",\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Url\": \"/index.html\",\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }, " +
                "{\n" +
                "            \"Name\": \"testln1\",\n" +
                "            \"ListenPort\": 21,\n" +
                "            \"Protocol\": \"tls\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"roundrobin\",\n" +
//                "            \"Status\": \"ON\",\n" +
                "            \"Timeout\": 1000000,\n" +
                "            \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "                    \"ServiceName\": \"" + service1 + "\",\n" +
                "                    \"ServicePort\": 80,\n" +
                "                    \"CertId\": \"" + certId + "\",\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rise\": 6,\n" +
                "                        \"Fall\": 6,\n" +
                "                        \"Url\": \"/index.html\",\n" +
                "                        \"Timeout\": 6000,\n" +
                "                        \"Period\": 6000,\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "}]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create ing tls listener of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal016", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
