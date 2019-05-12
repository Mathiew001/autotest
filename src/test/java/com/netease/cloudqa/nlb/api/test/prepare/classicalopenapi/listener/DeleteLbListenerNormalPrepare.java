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
 * @version $Id: DeleteLbListenerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class DeleteLbListenerNormalPrepare extends BasePrepare {

    //删除监听
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String targetGroupId2 = ConfigLoader.configration.getExtConfig("target_group_id2");
        //set request body
        String body = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"TargetGroupId\": \"" + targetGroupId2 + "\",\n" +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb listener, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @PrepareDescription(isPrepareMethod = true)
    @CaseLabel(lbType = {"mix"})
    public DataHolder deleteLbListenerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String targetGroupId2 = ConfigLoader.configration.getExtConfig("target_group_id2");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"TargetGroupId\": \"" + targetGroupId2 + "\",\n" +
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
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete lb tcp listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListener", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String targetGroupId1 = ConfigLoader.configration.getExtConfig("target_group_id");
        String targetGroupId2 = ConfigLoader.configration.getExtConfig("target_group_id2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"TargetGroupId\": \"" + targetGroupId1 + "\",\n" +
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
                "            \"TargetGroupId\": \"" + targetGroupId2 + "\",\n" +
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
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete lb https listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListener", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String targetGroupId1 = ConfigLoader.configration.getExtConfig("target_group_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 20,\n" +
                "    \"Protocol\": \"tls\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"TargetGroupId\": \"" + targetGroupId1 + "\",\n" +
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
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete lb tls listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListener", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String targetGroupId2 = ConfigLoader.configration.getExtConfig("target_group_id_vpc2");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"TargetGroupId\": \"" + targetGroupId2 + "\",\n" +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete lb http listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListener", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String targetGroupId2 = ConfigLoader.configration.getExtConfig("target_group_id_vpc2");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"TargetGroupId\": \"" + targetGroupId2 + "\",\n" +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete lb tcp listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListener", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String targetGroupId1 = ConfigLoader.configration.getExtConfig("target_group_id_vpc1");
        String targetGroupId2 = ConfigLoader.configration.getExtConfig("target_group_id_vpc2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"TargetGroupId\": \"" + targetGroupId1 + "\",\n" +
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
                "            \"TargetGroupId\": \"" + targetGroupId2 + "\",\n" +
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
                "    \"Gzip\": 0,\n" +
                "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete lb https listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListener", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String targetGroupId1 = ConfigLoader.configration.getExtConfig("target_group_id_vpc1");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 20,\n" +
                "    \"Protocol\": \"tls\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"TargetGroupId\": \"" + targetGroupId1 + "\",\n" +
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
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete lb tls listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListener", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除监听
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteLbListenerNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String targetGroupId2 = ConfigLoader.configration.getExtConfig("target_group_id_dns2");
        //set request body
        String prepareBody = "{\n" +
                "    \"InstanceId\": \"" + instanceId + "\",\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1025,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"TargetGroupId\": \"" + targetGroupId2 + "\",\n" +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteLbListenerNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete lb tcp listener of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("instanceId", String.class.toString(), instanceId, null));
        DataUnits.add(new DataUnit("prepareBody", String.class.toString(), prepareBody, null));
        DataUnits.add(new DataUnit("prepareMethod", String.class.toString(), "PrepareMethodInvokerUtils.prepareListener", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
