package com.netease.cloudqa.nlb.api.test.prepare.slighttest;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

import java.util.ArrayList;
import java.util.List;

public class RedirectNormalPrepare extends BasePrepare {

    //vpc_mix redirect
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder redirectNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String vipId = ConfigLoader.configration.getExtConfig("redirect_id_vpcmix");

        String targetGroup = "[" +
                "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":80,\n" +
                "            \"Id\":\"" +realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Rstatus\":\"2xx,3xx\",\n" +
                "        \"Period\":5000,\n" +
                "        \"Fall\":5,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Rise\":5\n" +
                "    },\n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test-01\"\n" +
                "}, " +
                "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":80,\n" +
                "            \"Id\":\"" +realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Rstatus\":\"2xx,3xx\",\n" +
                "        \"Period\":5000,\n" +
                "        \"Fall\":5,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Rise\":5\n" +
                "    },\n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test-02\"\n" +
                "}," +
                "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress1 + "\",\n" +
                "            \"Port\":81,\n" +
                "            \"Id\":\"" +realServer1 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName1 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Rstatus\":\"2xx,3xx\",\n" +
                "        \"Period\":5000,\n" +
                "        \"Fall\":5,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Rise\":5\n" +
                "    },\n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test-03\"\n" +
                "}," +
                "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":81,\n" +
                "            \"Id\":\"" +realServer2 + "\",\n" +
                "            \"TopAz\":\"" + topAz + "\",\n" +
                "            \"Weight\":100,\n" +
                "            \"Name\":\"" + rsName2 + "\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Monitor\":{\n" +
                "        \"Timeout\":5000,\n" +
                "        \"Rstatus\":\"2xx,3xx\",\n" +
                "        \"Period\":5000,\n" +
                "        \"Fall\":5,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Url\":\"/index.html\",\n" +
                "        \"Rise\":5\n" +
                "    },\n" +
                "    \"UseSamePort\":0,\n" +
                "    \"Name\":\"tg-test-04\"\n" +
                "}" +
                "]";

        //set request body
        String listeners = "[" +
                "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 80,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                +              "\"ServerName\": \"test1.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "     },"
                + "     {\n"
                +              "\"ServerName\": \"test2.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "     },"
                + "     {\n"
                +              "\"ServerName\": \"*\",\n"
                + "            \"Path\": \"/\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "     }"
                + "],\n"
                + "    \"Gzip\": 1\n"
                + "}, " +
                "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 443,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                +              "\"ServerName\": \"test1.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "     },"
                + "     {\n"
                +              "\"ServerName\": \"test2.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "     },"
                + "     {\n"
                +              "\"ServerName\": \"*\",\n"
                + "            \"Path\": \"/\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "     }"
                + "],\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 1\n"
                + "}" +
                "]";

        //set request body
        String update =
                "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"RedirectRules\":[\n"
                + "     {\n"
                +              "\"sourceDomain\": \"test1.com\",\n"
                + "            \"sourcePath\": \"/a\",\n"
                + "            \"targetDomain\": \"test2.com\",\n"
                + "            \"targetPath\": \"/b\",\n"
                + "            \"targetPort\": 443,\n"
                + "            \"protocol\": \"https\"\n"
                + "     },"
                + "     {\n"
                +              "\"sourceDomain\": \"test2.com\",\n"
                + "            \"targetDomain\": \"test1.com\",\n"
                + "            \"targetPath\": \"/a\",\n"
                + "            \"targetPort\": 443,\n"
                + "            \"protocol\": \"https\"\n"
                + "     },"
                        + "     {\n"
                        + "            \"targetPort\": 443,\n"
                        + "            \"protocol\": \"https\"\n"
                        + "     }"
                + "],\n"
                + "    \"Clusters\": [\n"
                + "     {\n"
                +              "\"ServerName\": \"test1.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "     },"
                + "     {\n"
                +              "\"ServerName\": \"test2.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\"\n"
                + "     },"
                        + "     {\n"
                        +              "\"ServerName\": \"*\",\n"
                        + "            \"Path\": \"/\",\n"
                        + "            \"TargetGroupId\": \"targetGroupId\"\n"
                        + "     }"
                + "],\n"
                + "    \"Gzip\": 1\n"
                + "}";

        //set response message
        String resMsg = "";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "redirectNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "redirect of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("targetGroup", String.class.toString(), targetGroup, null));
        DataUnits.add(new DataUnit("listener", String.class.toString(), listeners, null));
        DataUnits.add(new DataUnit("update", String.class.toString(), update, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("vipId", String.class.toString(), vipId, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
