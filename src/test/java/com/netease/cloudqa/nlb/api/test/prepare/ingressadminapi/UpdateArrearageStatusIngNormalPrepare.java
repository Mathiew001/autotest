package com.netease.cloudqa.nlb.api.test.prepare.ingressadminapi;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

public class UpdateArrearageStatusIngNormalPrepare extends BasePrepare {

    //netflow mix欠费停服恢复
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateArrearageStatus001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //set config
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        String namespace = ConfigLoader.configration.getExtConfig("namespace");

        //set request body
        String prepareBody = "[{\n" +
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
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateArrearageStatus001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update ing status of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //netflow vpc_mix实例欠费停服恢复
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateArrearageStatus002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String service1 = ConfigLoader.configration.getExtConfig("service_name1_vpc");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2_vpc");
        String namespace = ConfigLoader.configration.getExtConfig("namespace");
        //set request body
        String prepareBody = "[{\n" +
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
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateArrearageStatus002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb status of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("namespace", String.class.toString(), namespace, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
