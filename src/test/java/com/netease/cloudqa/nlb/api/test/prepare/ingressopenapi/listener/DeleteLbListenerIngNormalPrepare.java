package com.netease.cloudqa.nlb.api.test.prepare.ingressopenapi.listener;

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
 * @version $Id: DeleteLbListenerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class DeleteLbListenerIngNormalPrepare extends BasePrepare {

    //删除监听
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_ingress");
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
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
                "    ],\n" +
                "    \"Gzip\": 1\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete ing http listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListenerIng", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_ingress");
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
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
                "    ]\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete ing tcp listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListenerIng", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_ingress");
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        String service2 = ConfigLoader.configration.getExtConfig("service_name2");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"CertId\": \"0cc5dd00-2b72-11e8-84a3-353db519f4c6\",\n" +
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
                "            \"Path\": \"/b\",\n" +
                "            \"ServiceName\": \"" + service2 + "\",\n" +
                "            \"CertId\": \"0cc5dd00-2b72-11e8-84a3-353db519f4c6\",\n" +
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
                "    \"CipherSuiteId\": \"49a47986-519f-4449-ac86-5c05a94623c8\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete ing https listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListenerIng", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_ingress");
        String service1 = ConfigLoader.configration.getExtConfig("service_name1");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln\",\n" +
                "    \"ListenPort\": 20,\n" +
                "    \"Protocol\": \"tls\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServiceName\": \"" + service1 + "\",\n" +
                "            \"ServicePort\": 80,\n" +
                "            \"CertId\": \"0cc5dd00-2b72-11e8-84a3-353db519f4c6\",\n" +
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
                "    \"CipherSuiteId\": \"49a47986-519f-4449-ac86-5c05a94623c8\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete ing tls listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListenerIng", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
