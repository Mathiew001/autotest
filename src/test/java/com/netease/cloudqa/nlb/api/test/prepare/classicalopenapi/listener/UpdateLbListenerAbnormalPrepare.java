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
 * @version $Id: UpdateLbListenerAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateLbListenerAbnormalPrepare extends BasePrepare {

    //更新监听, instanceId illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "[{\n" +
                "    \"ListenerId\": \"" + "abcd" + "\",\n" +
                "    \"InstanceId\": \"" + "abcd" + "\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 50000\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \" Load balancer does not exist.!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, instanceId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, listenerId illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String body = "[{\n" +
                "    \"ListenerId\": \"" + "abcd" + "\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 50000\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"listener is not exist!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, listenerId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, certId illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"Certificate does not exist!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, forwardPort illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal014() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": -1,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"forwardPort is invalid\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, forwardPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, forwardPort illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 2,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"forwardPort is invalid\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, forwardPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, Gzip illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal020() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": -1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"gzip is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, Gzip illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, Gzip illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal021() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 2,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"gzip is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal021", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, Gzip illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, TraceVip illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal022() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": -1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"traceVip is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal022", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, TraceVip illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, TraceVip illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal023() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 2,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"traceVip is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal023", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, TraceVip illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->period illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal024() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Period\": 4999,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal024", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->Period illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->period illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal025() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Period\": 300001,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal025", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->Period illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->timeout illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal026() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Timeout\": 1999,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal026", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->timeout illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal027() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Timeout\": 60001,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal027", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rise illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal028() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rise\": 1,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal028", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rise illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rise illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal029() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rise\": 11,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal029", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rise illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->fall illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal030() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Fall\": 1,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal030", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->fall illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->fall illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal031() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Fall\": 11,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal031", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->fall illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->protocol illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal032() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Protocol\": \"abcd\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported protocol!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal032", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->url illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal033() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Url\": \"index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"url is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal033", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->url illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rstatus illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal034() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rstatus\": \"abcd\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal034", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rstatus illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rstatus illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal035() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal035", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rstatus illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, policy-->mode illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal036() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"abcd\",\n" +
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
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal036", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, policy-->mode illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, policy-->expire illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal037() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal037", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, policy-->expire illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, policy-->expire illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal038() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal038", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, policy-->expire illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, policy-->cookie illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal039() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid cookieName.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal039", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, policy-->cookie illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, path illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal040() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1231\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"URL length must be less than 128 characters!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal040", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, path illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, serverName illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal041() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1234567891234\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"serverNames length not more than 512!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal041", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, serverName illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, cipherSuiteId illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal042() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1234567891234\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + "abcd" + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"Encryption suite does not exist!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal042", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, cipherSuiteId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, timeout illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal043() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Timeout\": 9,\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"timeout is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal043", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, timeout illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal044() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Timeout\": 3601,\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"timeout is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal044", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, balance illegal
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal045() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"abcd\",\n" +
                "    \"Timeout\": 900,\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"balance is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal045", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, balance illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, instanceId illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal046() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "[{\n" +
                "    \"ListenerId\": \"" + "abcd" + "\",\n" +
                "    \"InstanceId\": \"" + "abcd" + "\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 50000\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \" Load balancer does not exist.!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal046", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, instanceId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, listenerId illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal047() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String body = "[{\n" +
                "    \"ListenerId\": \"" + "abcd" + "\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 50000\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"listener is not exist!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal047", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, listenerId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, certId illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal048() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"Certificate does not exist!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal048", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, certId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, forwardPort illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal049() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": -1,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"forwardPort is invalid\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal049", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, forwardPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, forwardPort illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal050() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 2,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"forwardPort is invalid\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal050", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, forwardPort illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, Gzip illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal051() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": -1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"gzip is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal051", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, Gzip illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, Gzip illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal052() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 2,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"gzip is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal052", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, Gzip illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, TraceVip illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal053() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": -1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"traceVip is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal053", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, TraceVip illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, TraceVip illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal054() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 2,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"traceVip is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal054", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, TraceVip illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->period illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal055() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Period\": 4999,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal055", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->Period illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->period illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal056() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Period\": 300001,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal056", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->Period illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->timeout illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal057() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Timeout\": 1999,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal057", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->timeout illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal058() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Timeout\": 60001,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal058", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rise illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal059() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rise\": 1,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal059", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rise illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rise illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal060() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rise\": 11,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal060", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rise illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->fall illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal061() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Fall\": 1,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal061", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->fall illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->fall illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal062() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Fall\": 11,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal062", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->fall illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->protocol illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal063() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Protocol\": \"abcd\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported protocol!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal063", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->url illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal064() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Url\": \"index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"url is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal064", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->url illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rstatus illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal065() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rstatus\": \"abcd\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal065", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rstatus illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rstatus illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal066() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal066", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rstatus illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, policy-->mode illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal067() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"abcd\",\n" +
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
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal067", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, policy-->mode illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, policy-->expire illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal068() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal068", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, policy-->expire illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, policy-->expire illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal069() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid policy expire.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal069", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, policy-->expire illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, policy-->cookie illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal070() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
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
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"Invalid cookieName.\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal070", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, policy-->cookie illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, path illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal071() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1231\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"URL length must be less than 128 characters!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal071", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, path illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, serverName illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal072() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1234567891234\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"serverNames length not more than 512!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal072", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, serverName illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, cipherSuiteId illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal073() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"abcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxy1234567891234\",\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + "abcd" + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"Encryption suite does not exist!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal073", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, cipherSuiteId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, timeout illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal074() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Timeout\": 9,\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"timeout is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal074", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, timeout illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal075() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Timeout\": 3601,\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"timeout is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal075", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, balance illegal
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal076() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"abcd\",\n" +
                "    \"Timeout\": 900,\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"balance is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal076", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, balance illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, instanceId illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal077() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "[{\n" +
                "    \"ListenerId\": \"" + "abcd" + "\",\n" +
                "    \"InstanceId\": \"" + "abcd" + "\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \" Load balancer does not exist.!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal077", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, instanceId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, listenerId illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal078() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String body = "[{\n" +
                "    \"ListenerId\": \"" + "abcd" + "\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"listener is not exist!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal078", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, listenerId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, balance illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal079() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"abcd\",\n" +
                "    \"Timeout\": 900,\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"balance is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal079", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, balance illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->period illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal080() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Period\": 4999,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal080", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->Period illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->period illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal081() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Period\": 300001,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal081", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->Period illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->timeout illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal082() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Timeout\": 1999,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal082", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->timeout illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal083() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Timeout\": 60001,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal083", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rise illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal084() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rise\": 1,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal084", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rise illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rise illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal085() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rise\": 11,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal085", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rise illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->fall illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal086() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Fall\": 1,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal086", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->fall illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->fall illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal087() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Fall\": 11,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal087", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->fall illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->protocol illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal088() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Protocol\": \"abcd\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported protocol!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal088", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->url illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal089() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Url\": \"index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"url is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal089", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->url illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rstatus illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal090() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rstatus\": \"abcd\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal090", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rstatus illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rstatus illegal
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal091() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal091", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rstatus illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, instanceId illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal092() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "[{\n" +
                "    \"ListenerId\": \"" + "abcd" + "\",\n" +
                "    \"InstanceId\": \"" + "abcd" + "\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \" Load balancer does not exist.!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal092", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, instanceId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, listenerId illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal093() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        String body = "[{\n" +
                "    \"ListenerId\": \"" + "abcd" + "\",\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
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
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"NotFound\",\n" +
                "    \"Message\": \"listener is not exist!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal093", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, listenerId illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, balance illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal094() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"abcd\",\n" +
                "    \"Timeout\": 900,\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"balance is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal094", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, balance illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->period illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal095() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 4999,\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal095", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->Period illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->period illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal096() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 300001,\n" +
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
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid period!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal096", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->Period illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->timeout illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal097() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 1999,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal097", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->timeout illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal098() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 60001,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid timeout!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal098", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->timeout illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rise illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal099() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 1,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal099", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rise illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rise illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal100() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 11,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal100", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rise illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->fall illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal101() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 1,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal101", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->fall illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->fall illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal102() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 11,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid rise or fall!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal102", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->fall illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->protocol illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal103() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
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
                "              \"Protocol\": \"abcd\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported protocol!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal03", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->protocol illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->url illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal104() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
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
                "              \"Url\": \"index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"url is invalid!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal104", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->url illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rstatus illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal105() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
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
                "              \"Rstatus\": \"abcd\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal105", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rstatus illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, monitor-->rstatus illegal
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal106() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
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
                "              \"Rstatus\": \"2xx,abcd\" \n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"invalid status code!\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal106", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, monitor-->rstatus illegal", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, ha1.8 alpn illegal
    @CaseLabel(lbType = {"ha1.8vpc"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal107() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"LsnAttrs\": {\n" +
                "       \"Alpn\": 1234\n" +
                "    }," +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"type error for alpn field\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal107", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, alpn illegal of ha1.8", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, ha1.8 alpn illegal
    @CaseLabel(lbType = {"ha1.8vpc"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerAbnormal108() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"LsnAttrs\": {\n" +
                "       \"Alpn\": \"abcd\"\n" +
                "    }," +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"unsupported alpn protocol\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal108", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, alpn illegal of ha1.8", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听, ha1.6 alpn=h2
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder updateLbListenerAbnormal109() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String body = "[" +
                "{\n" +
                "    \"Name\": \"testln1\",\n" +
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
                "        }" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}, " +
                "{\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"LsnAttrs\": {\n" +
                "       \"Alpn\": \"h2\"\n" +
                "    }," +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}]";
        String resMsg = "{\n" +
                "    \"Code\": \"BadRequest\",\n" +
                "    \"Message\": \"alpn is not supported for current instance\"\n" +
                "}";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerAbnormal109", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, alpn=h2 of ha1.6", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

}
