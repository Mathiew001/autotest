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

public class SatisfyRunningConditionNormalPrepare extends BasePrepare {
    //netflow mix欠费停服恢复
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateArrearageStatus001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String prepareBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
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
                + "    \"Gzip\": 0,\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
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
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
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
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateArrearageStatus001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb status of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //netflow vpc_mix实例欠费停服恢复
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateArrearageStatus002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String prepareBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
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
                + "    \"Gzip\": 0,\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
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
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
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
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateArrearageStatus002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb status of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //netflow dns实例欠费停服恢复
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateArrearageStatus003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String prepareBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
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
                + "    \"Gzip\": 0,\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
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
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
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
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateArrearageStatus003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb status of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
