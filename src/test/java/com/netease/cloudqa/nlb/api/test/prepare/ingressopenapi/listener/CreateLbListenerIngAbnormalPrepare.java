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
 * @version $Id: CreateLbListenerAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CreateLbListenerIngAbnormalPrepare extends BasePrepare {

    //protocol非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 8887,\n" +
                "    \"Protocol\": \"abcd\",\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener protocol.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 8887,\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 81,\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener port.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, http listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 79,\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener port.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, http listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 80,\n" +
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
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\"Code\":\"Conflict\",\"Message\":\"Duplicate listener.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //listenerPort 重复
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createLbListenerAbnormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 80,\n" +
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
                "    \"ListenPort\": 80,\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\"Code\":\"Conflict\",\"Message\":\"Duplicate listener.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
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
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"CertId not found.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, no certId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
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
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"CertId\": \"abcd\",\n" +
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
                "    ],\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"No such cert.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
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
                "            \"Path\": \"/a\",\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\"Code\":\"Conflict\",\"Message\":\"Duplicate cluster.\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated path", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"\",\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Invalid listener.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal021", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal022", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal023", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal024", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
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
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener port.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal025", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 65536,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
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
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener port.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal026", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
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
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz1234567812345\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid parameter type or length of name > 64.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal027", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, name > 64", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //expire 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal028() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": -1\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal028", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, expire illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //expire 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal029() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 86401\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal029", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, expire illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //CookieName 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal030() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"$abcd#123\"\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid cookieName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal030", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, CookieName illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //CookieName 非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal031() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid policy.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal031", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, CookieName illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor url 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal032() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal032", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor url 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal033() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "              \"Url\": \"/abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy123\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal033", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rstatus 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal034() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal034", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rstatus 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal035() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal035", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //serverName 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal036() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1234567891234\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "              \"Rstatus\": \"2xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "    \"Message\": \"Invalid serverName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal036", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal servername", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //path 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal037() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"Path\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1231\",\n" +
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
                "              \"Rstatus\": \"2xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid path.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal037", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal path", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //Gzip 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal038() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal038", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal Gzip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //TraceVip 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal039() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "    \"TraceVip\": -1\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal039", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal TraceVip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //TraceVip 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal040() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "    \"TraceVip\": 2\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal040", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal TraceVip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ForwardPort 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal041() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"ForwardPort\": -1\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal041", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal ForwardPort", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ForwardPort 参数非法
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal042() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"ForwardPort\": 2\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal042", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal ForwardPort", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal043() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 8887,\n" +
                "    \"Protocol\": \"abcd\",\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener protocol.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal043", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //protocol为空
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal044() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 8887,\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal044", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, protocol empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //http port 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal045() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 81,\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener port.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal045", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, http listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //http port 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal046() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 79,\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener port.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal046", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, http listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 重复
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal047() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 80,\n" +
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
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\"Code\":\"Conflict\",\"Message\":\"Duplicate listener.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal047", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //listenerPort 重复
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal048() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 80,\n" +
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
                "    \"ListenPort\": 80,\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\"Code\":\"Conflict\",\"Message\":\"Duplicate listener.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal048", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //无certId
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal049() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
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
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"CertId not found.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal049", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, no certId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //certId非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal050() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
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
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"CertId\": \"abcd\",\n" +
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
                "    ],\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"No such cert.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal050", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //path 重复
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal051() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
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
                "            \"Path\": \"/a\",\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\"Code\":\"Conflict\",\"Message\":\"Duplicate cluster.\"}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal051", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated path", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name为空
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal052() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"\",\n" +
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
                "}]\n";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\",\"Message\":\"Invalid listener.\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal052", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, empty name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //monitor参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal053() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal053", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor protocol 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal054() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal054", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal055() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal055", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal056() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal056", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor timeout 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal057() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal057", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor Period 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal058() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal058", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rise 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal059() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal059", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rise 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal060() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal060", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal061() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal061", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor fall 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal062() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal062", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal063() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
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
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener port.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal063", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //tcp port 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal064() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 65536,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
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
                "    ],\n" +
                "    \"Timeout\": 1000000\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid listener port.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal064", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, tcp listenerPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //name 长度大于64
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal065() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz1234567812345\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid parameter type or length of name > 64.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal065", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, name > 64", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //expire 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal066() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": -1\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal066", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, expire illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //expire 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal067() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 86401\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal067", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, expire illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //CookieName 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal068() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"$abcd#123\"\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid cookieName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal068", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, CookieName illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //CookieName 非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal069() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "    \"Message\": \"Invalid policy.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal069", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, CookieName illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor url 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal070() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal070", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor url 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal071() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "              \"Url\": \"/abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy123\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal071", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rstatus 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal072() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal072", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //monitor rstatus 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal073() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal073", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal monitor rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //serverName 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal074() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1234567891234\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "              \"Rstatus\": \"2xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "    \"Message\": \"Invalid serverName.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal074", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal servername", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //path 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal075() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"Path\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1231\",\n" +
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
                "              \"Rstatus\": \"2xx\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid path.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal075", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal path", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //Gzip 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal076() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal076", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal Gzip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //TraceVip 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal077() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"TraceVip\": -1\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal077", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal TraceVip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //TraceVip 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal078() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"TraceVip\": 2\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal078", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal TraceVip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ForwardPort 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal079() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"ForwardPort\": -1\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal079", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal ForwardPort", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //ForwardPort 参数非法
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerAbnormal080() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 80,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
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
                "    \"ForwardPort\": 2\n" +
                "}]";
        //set response message
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid monitor.\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerAbnormal080", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, illegal ForwardPort", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancerNormal004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}

