package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.loadbalancer;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chentianyu1
 * @version $Id: GetLoadBalancerNormalPrepare.java, v 0.1 Apr 25, 2018 10:17:48 AM chentianyu1 Exp $
 */
public class GetLoadBalancerIngNormalPrepare extends BasePrepare {

    //get mix detail
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
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
                        "    \"Gzip\": 1,\n" +
                        "    \"ForwardPort\": 1,\n" +
                        "    \"TraceVip\": 1\n" +
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
        String resMsg = "{\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
                "    \"Description\":\"test cty\",\n" +
                "    \"Type\":\"mix\",\n" +
                "    \"Namespace\":\"" + namespace + "\",\n" +
                "    \"SecurityGroups\":null,\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAz + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Limit\":{\n" +
                "        \"ListenerLimit\":10,\n" +
                "        \"TGroupLimit\":20,\n" +
                "        \"TGroupInstanceLimit\":50,\n" +
                "        \"PathLimit\":30,\n" +
                "        \"DomainLimit\":5\n" +
                "    },\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":8888,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Timeout\":0,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
//                "                    \"ClusterPort\":80,\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Protocol\":\"tcp\"\n" +
                "                    },\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000,\n" +
                "                        \"CookieName\":\"\"\n" +
                "                    },\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"ServiceName\":\"" + service1 + "\",\n" +
                "                    \"ServicePort\":80,\n" +
                "                },\n" +
                "                {\n" +
//                "                    \"ClusterPort\":80,\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Rise\":5,\n" +
                "                        \"Fall\":5,\n" +
                "                        \"Period\":5000,\n" +
                "                        \"Timeout\":5000,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"Expire\":30000,\n" +
                "                        \"CookieName\":\"asfsd\"\n" +
                "                    },\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"ServiceName\":\"" + service2 + "\",\n" +
                "                    \"ServicePort\":80,\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":8887,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Timeout\":0,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
//                "                    \"ClusterPort\":80,\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Protocol\":\"tcp\"\n" +
                "                    },\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000,\n" +
                "                        \"CookieName\":\"\"\n" +
                "                    },\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"ServiceName\":\"" + service1 + "\",\n" +
                "                    \"ServicePort\":80,\n" +
                "                },\n" +
                "                {\n" +
//                "                    \"ClusterPort\":80,\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Rise\":5,\n" +
                "                        \"Fall\":5,\n" +
                "                        \"Period\":5000,\n" +
                "                        \"Timeout\":5000,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"Expire\":30000,\n" +
                "                        \"CookieName\":\"asfsd\"\n" +
                "                    },\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"ServiceName\":\"" + service2 + "\",\n" +
                "                    \"ServicePort\":80,\n" +
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
                "    }\n" +
                "}\n";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get mix ing detail", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //get vpc_mix detail
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder getLoadBalancerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        String service1 = ConfigLoader.configration.getExtConfig("service_name1_vpc");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2_vpc");
        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String sg1 = ConfigLoader.configration.getExtConfig("security_group1");
        String sg2 = ConfigLoader.configration.getExtConfig("security_group_default_ingress");
        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
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
                        "    \"Gzip\": 1,\n" +
                        "    \"ForwardPort\": 1,\n" +
                        "    \"TraceVip\": 1\n" +
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
        String resMsg = "{\n" +
                "    \"Status\":\"WORKING\",\n" +
                "    \"SubStatus\":\"WORKING\",\n" +
                "    \"Description\":\"test cty\",\n" +
                "    \"Type\":\"vpc_mix\",\n" +
                "    \"Namespace\":\"" + namespace + "\",\n" +
                "    \"VpcId\":\"" + vpcId + "\",\n" +
                "    \"SecurityGroups\":[\n" +
                "        \"" + sg1 + "\",\n" +
                "        \"" + sg2 + "\"\n" +
                "    ],\n" +
                "    \"TopAzInfos\":[\n" +
                "        {\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"SubNetId\":\"" + subNetId + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Limit\":{\n" +
                "        \"ListenerLimit\":10,\n" +
                "        \"TGroupLimit\":20,\n" +
                "        \"TGroupInstanceLimit\":50,\n" +
                "        \"PathLimit\":30,\n" +
                "        \"DomainLimit\":5\n" +
                "    },\n" +
                "    \"Network\":\"public\",\n" +
                "    \"Listeners\":[\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":8888,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Timeout\":0,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
//                "                    \"ClusterPort\":80,\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Protocol\":\"tcp\"\n" +
                "                    },\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000,\n" +
                "                        \"CookieName\":\"\"\n" +
                "                    },\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"ServiceName\":\"" + service1 + "\",\n" +
                "                    \"ServicePort\":80,\n" +
                "                },\n" +
                "                {\n" +
//                "                    \"ClusterPort\":80,\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Rise\":5,\n" +
                "                        \"Fall\":5,\n" +
                "                        \"Period\":5000,\n" +
                "                        \"Timeout\":5000,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"Expire\":30000,\n" +
                "                        \"CookieName\":\"asfsd\"\n" +
                "                    },\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"ServiceName\":\"" + service2 + "\",\n" +
                "                    \"ServicePort\":80,\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":8887,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
//                "            \"Timeout\":0,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
//                "                    \"ClusterPort\":80,\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Protocol\":\"tcp\"\n" +
                "                    },\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000,\n" +
                "                        \"CookieName\":\"\"\n" +
                "                    },\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"ServiceName\":\"" + service1 + "\",\n" +
                "                    \"ServicePort\":80,\n" +
                "                },\n" +
                "                {\n" +
//                "                    \"ClusterPort\":80,\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Rise\":5,\n" +
                "                        \"Fall\":5,\n" +
                "                        \"Period\":5000,\n" +
                "                        \"Timeout\":5000,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"Expire\":30000,\n" +
                "                        \"CookieName\":\"asfsd\"\n" +
                "                    },\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"ServiceName\":\"" + service2 + "\",\n" +
                "                    \"ServicePort\":80,\n" +
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
                "    }\n" +
                "}\n" +
                "\n";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "getLoadBalancerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "get vpc_mix ing detail", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
