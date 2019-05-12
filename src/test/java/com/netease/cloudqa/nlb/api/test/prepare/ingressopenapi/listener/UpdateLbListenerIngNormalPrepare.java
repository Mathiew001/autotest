package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.listener;

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
 * @version $Id: UpdateLbListenerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateLbListenerIngNormalPrepare extends BasePrepare {

    //更新监听, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String executeBody = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 81,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 40000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 7000,\n" +
                "              \"Timeout\": 7000,\n" +
                "              \"Rise\": 7,\n" +
                "              \"Fall\": 7,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index1.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "            \"ForwardPort\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"Gzip\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[{\n" +
                "            \"Name\": \"testln\",\n" +
                "            \"ListenPort\": 1026,\n" +
                "            \"Protocol\": \"http\",\n" +
                "            \"TraceVip\": 1,\n" +
                "            \"Balance\": \"leastconn\",\n" +
                "            \"Gzip\": 1,\n" +
                "            \"ForwardPort\": 1,\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 81,\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"Path\": \"/b\",\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rise\": 7,\n" +
                "                        \"Fall\": 7,\n" +
                "                        \"Url\": \"/index1.html\",\n" +
                "                        \"Timeout\": 7000,\n" +
                "                        \"Period\": 7000,\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"insert\",\n" +
                "                        \"Expire\": 40000\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update ing listener of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String executeBody = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"TraceVip\": 0,\n" +
                "    \"Gzip\": 0\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 81,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 40000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 7000,\n" +
                "              \"Timeout\": 7000,\n" +
                "              \"Rise\": 7,\n" +
                "              \"Fall\": 7,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index1.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "            \"ForwardPort\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"Gzip\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[{\n" +
                "            \"Name\": \"testln\",\n" +
                "            \"ListenPort\": 1026,\n" +
                "            \"Protocol\": \"http\",\n" +
                "            \"TraceVip\": 1,\n" +
                "            \"Balance\": \"leastconn\",\n" +
                "            \"Gzip\": 1,\n" +
                "            \"ForwardPort\": 1,\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 81,\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"Path\": \"/b\",\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rise\": 7,\n" +
                "                        \"Fall\": 7,\n" +
                "                        \"Url\": \"/index1.html\",\n" +
                "                        \"Timeout\": 7000,\n" +
                "                        \"Period\": 7000,\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"insert\",\n" +
                "                        \"Expire\": 40000\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update ing listener of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, idc_vpc_mix
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String executeBody = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 81,\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 40000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 7000,\n" +
                "              \"Timeout\": 7000,\n" +
                "              \"Rise\": 7,\n" +
                "              \"Fall\": 7,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index1.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[{\n" +
                "            \"Name\": \"testln\",\n" +
                "            \"ListenPort\": 1026,\n" +
                "            \"Protocol\": \"http\",\n" +
                "            \"TraceVip\": 0,\n" +
                "            \"Balance\": \"leastconn\",\n" +
                "            \"Gzip\": 1,\n" +
                "            \"Clusters\": [\n" +
                "                {\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 81,\n" +
                "                    \"ServerName\": \"test.com\",\n" +
                "                    \"Path\": \"/b\",\n" +
                "                    \"Monitor\": {\n" +
                "                        \"Protocol\": \"http\",\n" +
                "                        \"Rise\": 7,\n" +
                "                        \"Fall\": 7,\n" +
                "                        \"Url\": \"/index1.html\",\n" +
                "                        \"Timeout\": 7000,\n" +
                "                        \"Period\": 7000,\n" +
                "                        \"Rstatus\": \"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\": {\n" +
                "                        \"Mode\": \"insert\",\n" +
                "                        \"Expire\": 40000\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update ing listener of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal016", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
