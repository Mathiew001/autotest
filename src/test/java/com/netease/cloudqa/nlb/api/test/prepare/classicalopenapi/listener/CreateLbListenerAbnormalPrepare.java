package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.listener;

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
 * @version $Id: CreateLbListenerAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CreateLbListenerAbnormalPrepare extends BasePrepare {

    //targetGroupId非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"TargetGroupId\": \"" + " abcd" + "\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"target group does not exist!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create listener, illegal targetGroupId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"abcd\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"protocol is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol为空
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"miss listener parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //http port 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 81,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port is 80 or > 1024 for http!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, http listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //http port 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 79,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port is 80 or > 1024 for http!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, http listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 重复
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"qanotdelete\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}," +
                "{\n" +
                "    \"Name\": \"qanotdelete\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"Conflict\",\n" +
                "    \"Message\": \"listener port or name is already existed\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //listenerPort 重复
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 12345,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}," +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 12345,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"Conflict\",\n" +
                "    \"Message\": \"listener port or name is already existed\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //无certId
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Missing certificate parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, no certId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //cipherSuitId 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal138() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + "abcd" + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"Encryption suite does not exist!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal138", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //certId非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"abcd\",\n" +
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
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" +cipherSuiteId+ "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"Certificate does not exist!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //path 重复
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"route repeated! route */a has already existed!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated path", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name为空
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"miss listener parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //targetGroup为空
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLbListenerAbnormal014() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"缺少转发规则参数！\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty targetGroup", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Health check parameter format is incorrect.!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor protocol 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal016() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"abcd\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported protocol!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal017() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 300001,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal018() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 60001,\n" +
                "              \"Period\": 6000,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal019() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 1999,\n" +
                "              \"Period\": 6000,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal020() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 4999,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
    //monitor rise 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal021() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 1,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal021", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rise 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal022() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 11,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal022", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal023() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 1,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal023", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal024() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 11,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal024", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor url 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal139() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"url is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal139", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rstatus 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal140() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal140", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rstatus 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal141() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal141", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //policy mode 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal142() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"abcd\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal142", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal policy mode", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //policy expire 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal143() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": -1\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal143", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal policy expire", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //policy expire 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal144() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 86401\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal144", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal policy expire", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //policy cookie 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal145() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1\",\n" +
                "                \"Expire\": 3000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid cookieName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal145", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal policy cookie", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //balance 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal146() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"abcd\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 3000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"balance is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal146", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal balance", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal025() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port range: 2~65535!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal025", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal026() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 65536,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port range: 2~65535!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal026", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 长度大于64
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal027() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz1234567812345\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"listener name is invalid! length less than 64!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal027", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, name > 64", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }



    //targetGroupId非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal028() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"TargetGroupId\": \"" + " abcd" + "\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"target group does not exist!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal028", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, targetgroupId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal029() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"abcd\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"protocol is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal029", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol为空
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal030() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"miss listener parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal030", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //http port 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal031() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 81,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port is 80 or > 1024 for http!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal031", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, http listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //http port 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal032() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 79,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port is 80 or > 1024 for http!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal032", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, http listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 重复
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal033() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"qanotdelete\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}," +
                "{\n" +
                "    \"Name\": \"qanotdelete\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"Conflict\",\n" +
                "    \"Message\": \"listener port or name is already existed\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal033", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //listenerPort 重复
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal034() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 12345,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 12345,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"Conflict\",\n" +
                "    \"Message\": \"listener port or name is already existed\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal034", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //无certId
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal037() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Missing certificate parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal037", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, no certId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //certId非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal038() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"abcd\",\n" +
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
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"Certificate does not exist!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal038", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //path 重复
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal039() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"route repeated! route */a has already existed!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal039", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated path", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name为空
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal040() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"miss listener parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal040", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //targetGroup为空
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLbListenerAbnormal041() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"缺少转发规则参数！\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal041", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty targetGroup", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal042() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Health check parameter format is incorrect.!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal042", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor protocol 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal043() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"abcd\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported protocol!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal043", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal044() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 300001,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal044", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal045() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 60001,\n" +
                "              \"Period\": 6000,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal045", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal046() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 1999,\n" +
                "              \"Period\": 6000,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal046", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal047() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 4999,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal047", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
    //monitor rise 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal048() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 1,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal048", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rise 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal049() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 11,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal049", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal050() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 1,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal050", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal051() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 11,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal051", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor url 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal147() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"url is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal147", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rstatus 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal148() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal148", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rstatus 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal149() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal149", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //policy mode 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal150() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"abcd\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal150", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal policy mode", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //policy expire 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal151() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": -1\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal151", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal policy expire", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //policy expire 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal152() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 86401\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal152", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal policy expire", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //policy cookie 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal153() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy" +
                "abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1\",\n" +
                "                \"Expire\": 3000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid cookieName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal153", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal policy cookie", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //balance 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal154() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"abcd\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 3000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 10,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"balance is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal154", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal balance", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal052() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port range: 2~65535!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal052", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal053() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 65536,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port range: 2~65535!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal053", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 长度大于64
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal054() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz1234567812345\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"listener name is invalid! length less than 64!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal054", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, name > 64", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //targetGroupId非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal055() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"TargetGroupId\": \"" + " abcd" + "\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"target group does not exist!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal055", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, targetgroupId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal056() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"abcd\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"protocol is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal056", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol为空
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal057() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"miss listener parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal057", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //http port 非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal058() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 81,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port is 80 or > 1024 for http!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal058", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, http listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //http port 非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal059() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 79,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port is 80 or > 1024 for http!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal059", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, http listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 重复
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLbListenerAbnormal060() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"qanotdelete\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"Conflict\",\n" +
                "    \"Message\": \"listener port or name is already existed\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal060", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //listenerPort 重复
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLbListenerAbnormal061() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 12345,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"Conflict\",\n" +
                "    \"Message\": \"listener port or name is already existed\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal061", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //无certId
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal062() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Missing certificate parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal062", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, no certId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //certId非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal063() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"abcd\",\n" +
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
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"Certificate does not exist!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal063", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //path 重复
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal064() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"route repeated! route */a has already existed!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal064", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated path", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name为空
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal065() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"miss listener parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal065", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //targetGroup为空
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLbListenerAbnormal066() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"缺少转发规则参数！\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal066", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty targetGroup", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor参数非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal067() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Health check parameter format is incorrect.!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal067", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor protocol 参数非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal068() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"abcd\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported protocol!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal068", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal069() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 300001,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal069", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal070() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 60001,\n" +
                "              \"Period\": 6000,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal070", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal071() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 1999,\n" +
                "              \"Period\": 6000,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal071", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal072() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 4999,\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal072", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
    //monitor rise 参数非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal073() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 1,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal073", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rise 参数非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal074() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 11,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal074", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal075() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 1,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal075", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal076() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
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
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 11,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal076", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal077() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port range: 2~65535!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal077", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal078() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 65536,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port range: 2~65535!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal078", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 长度大于64
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal079() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz1234567812345\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"listener name is invalid! length less than 64!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal079", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, name > 64", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //targetGroupId非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal080() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"TargetGroupId\": \"" + " abcd" + "\",\n" +
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
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"target group does not exist!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal080", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, targetgroupId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal081() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"abcd\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"protocol is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal081", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol为空
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal082() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"miss listener parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal082", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 重复
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal085() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"qanotdelete\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"qanotdelete\",\n" +
                "    \"ListenPort\": 81,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}" +
                "]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"Conflict\",\n" +
                "    \"Message\": \"listener port or name is already existed\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal085", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //listenerPort 重复
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal086() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 12345,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 12345,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}" +
                "]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"Conflict\",\n" +
                "    \"Message\": \"listener port or name is already existed\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal086", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name为空
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal090() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"miss listener parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal090", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //targetGroup为空
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLbListenerAbnormal091() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"缺少转发规则参数！\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal091", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty targetGroup", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor protocol 参数非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal093() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"abcd\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported protocol!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal093", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal094() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 300001,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal094", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal095() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 60001,\n" +
                "              \"Period\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal095", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal096() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 1999,\n" +
                "              \"Period\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal096", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal097() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 4999,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal097", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
    //monitor rise 参数非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal098() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 1,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}" +
                "]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal098", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rise 参数非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal099() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 11,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal099", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal100() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 1,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal100", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal101() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 11,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal101", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal102() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port range: 2~65535!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal102", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal103() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 65536,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port range: 2~65535!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal103", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 长度大于64
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal104() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz1234567812345\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"listener name is invalid! length less than 64!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal104", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, name > 64", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //targetGroupId非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal105() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"TargetGroupId\": \"" + " abcd" + "\",\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "    }]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"target group does not exist!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal105", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, targetgroupId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal106() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"abcd\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"protocol is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal106", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol为空
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal107() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"miss listener parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal107", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 重复
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal110() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"qanotdelete\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"qanotdelete\",\n" +
                "    \"ListenPort\": 81,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}" +
                "]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"Conflict\",\n" +
                "    \"Message\": \"listener port or name is already existed\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal110", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //listenerPort 重复
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal111() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 12345,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 12345,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}" +
                "]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"Conflict\",\n" +
                "    \"Message\": \"listener port or name is already existed\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal111", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name为空
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal115() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"miss listener parameters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal115", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //targetGroup为空
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLbListenerAbnormal116() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"缺少转发规则参数！\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal116", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty targetGroup", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor protocol 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal118() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"abcd\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported protocol!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal118", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal119() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 300001,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal119", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal120() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\",\n" +
                "                \"Expire\": 30000\n" +
                "            },\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 60001,\n" +
                "              \"Period\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal120", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal121() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 1999,\n" +
                "              \"Period\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal121", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal122() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 4999,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal122", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
    //monitor rise 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal123() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 1,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal123", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rise 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal124() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 11,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal124", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal125() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 1,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal125", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal126() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 11,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal126", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor url 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal155() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"url is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal155", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rstatus 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal156() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"abcd\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal156", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rstatus 参数非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal157() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Period\": 5000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"4xx,abcd\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal157", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal127() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port range: 2~65535!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal127", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal128() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 65536,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"port is invalid! port range: 2~65535!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal128", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 长度大于64
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal129() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz1234567812345\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"listener name is invalid! length less than 64!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal129", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, name > 64", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //forwardPort 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal130() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": -1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"forwardPort is invalid\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal130", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal forwardPort", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //forwardPort 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal131() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 2,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"forwardPort is invalid\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal131", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal forwardPort", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //forwardPort 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal132() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": -1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"forwardPort is invalid\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal132", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal forwardPort", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //forwardPort 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal133() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 2,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"forwardPort is invalid\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal133", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal forwardPort", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //serverName too long
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal134() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1234567891234\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"serverNames length not more than 512!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal134", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, serverName too long", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //severName too long
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal135() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1234567891234\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"serverNames length not more than 512!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal135", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, serverName too long", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //path too long
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal136() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1231\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"URL length must be less than 128 characters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal136", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, path too long", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //path too long
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal137() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1231\",\n" +
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
                "    \"Gzip\": 0\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"URL length must be less than 128 characters!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal137", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, path too long", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //Gzip 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal158() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": -1\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"gzip is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal158", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal Gzip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //Gzip 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal159() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 2\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"gzip is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal159", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal Gzip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //TraceVip 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal160() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 1, \n" +
                "    \"TraceVip\": -1\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"traceVip is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal160", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal TraceVip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //TraceVip 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal161() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 1, \n" +
                "    \"TraceVip\": 2\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"traceVip is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal161", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal TraceVip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //Gzip 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal162() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 2\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"gzip is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal162", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal Gzip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //TraceVip 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal163() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 1, \n" +
                "    \"TraceVip\": -1\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"traceVip is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal163", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal TraceVip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //TraceVip 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal164() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": 1, \n" +
                "    \"TraceVip\": 2\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"traceVip is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal164", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal TraceVip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //Gzip 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal165() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    \"Gzip\": -1\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"gzip is invalid!\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal165", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal Gzip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //defaultCert非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal166() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"LsnAttrs\": {" +
                "         \"DefaultCert\": \"123avsdf\"" +
                "     }," +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"default cert not used in any cluster\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal166", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, default certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //defaultCert非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal167() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"LsnAttrs\": {" +
                "         \"DefaultCert\": \"123avsdf\"" +
                "     }," +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"default cert not used in any cluster\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal167", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, default certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //defaultCert非法
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal168() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"LsnAttrs\": {" +
                "         \"DefaultCert\": \"123avsdf\"" +
                "     }," +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"default cert not used in any cluster\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal168", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, default certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //alpn非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal169() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"LsnAttrs\": {" +
                "         \"Alpn\": \"abcd\"" +
                "     }," +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported alpn protocol\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal169", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, alpn illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ha1.6设置alpn=h2
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLbListenerAbnormal170() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"LsnAttrs\": {" +
                "         \"Alpn\": \"h2\"" +
                "     }," +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"alpn is not supported for current instance\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal170", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, alpn=h2 of ha1.6", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //alpn not string
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal171() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"LsnAttrs\": {" +
                "         \"Alpn\": 1234" +
                "     }," +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"type error for alpn field\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal171", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, alpn not string", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ha1.6设置alpn=http/1.1
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLbListenerAbnormal172() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"LsnAttrs\": {" +
                "         \"Alpn\": \"http/1.1\"" +
                "     }," +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"alpn is not supported for current instance\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal172", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, alpn=http/1.1 of ha1.6", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ha1.8, http监听设置alpn=h2
    @CaseLabel(lbType = {"ha1.8vpc"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal173() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"LsnAttrs\": {" +
                "         \"Alpn\": \"h2\"" +
                "     }," +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported listener protocol for alpn\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal173", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb http listener with alpn=h2 of ha1.8", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ha1.8, tls监听设置alpn=h2
    @CaseLabel(lbType = {"ha1.8vpc"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal174() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tls\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "    ],\n" +
                "    \"LsnAttrs\": {" +
                "         \"Alpn\": \"h2\"" +
                "     }," +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported listener protocol for alpn\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal174", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tls listener with alpn=h2 of ha1.8", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}

