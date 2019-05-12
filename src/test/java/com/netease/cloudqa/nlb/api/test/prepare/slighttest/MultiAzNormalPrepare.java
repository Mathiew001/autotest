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

public class MultiAzNormalPrepare extends BasePrepare {

    //mix url test
    @CaseLabel(lbType = { "multiaz" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder multiAzNormalPrepare001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        String targetGroup = "[" +
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
                "    \"Name\":\"tg-test-01\"\n" +
                "}, " +
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
                "    \"Name\":\"tg-test-02\"\n" +
                "}, " +
                "{\n" +
                "    \"Instances\":[\n" +
                "        {\n" +
                "            \"Address\":\"" + rsAddress2 + "\",\n" +
                "            \"Port\":82,\n" +
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
                "    \"Name\":\"tg-test-03\"\n" +
                "}" +
                "]";

        //set request body
        String listener = "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 80,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a /b /c /m /n /q /p\",\n"
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
                + "     }, "
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/\",\n"
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
                + "     }, "
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/abcd /efg /vpc/abcd\",\n"
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
                + "     }" +
                "],\n"
                + "    \"Gzip\": 1,\n"
                + "}";

        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":80,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":81,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a /b /c /m /n /q /p\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":80,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/abcd /efg /vpc/abcd\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"http\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"/index.html\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000,\n" +
                "                        \"Rstatus\":\"2xx,3xx\"\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"rewrite\",\n" +
                "                        \"CookieName\":\"asfsd\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
                "                    \"Status\":\"UP\",\n" +
                "                    \"Instances\":[\n" +
                "                        {\n" +
                "                            \"Id\":\"" + realServer2 + "\",\n" +
                "                            \"Name\":\"" + rsName2 + "\",\n" +
                "                            \"Address\":\"" + rsAddress2 + "\",\n" +
                "                            \"Port\":82,\n" +
                "                            \"Status\":\"UP\",\n" +
                "                            \"Weight\":100,\n" +
                "                            \"Backup\":0\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        String urlCheckList = "[\n" +
                "    {\n" +
                "        \"lisenerName\": \"testnl1\",\n" +
                "        \"listenPort\": 80,\n" +
                "        \"check\": [\n" +
                "          {\n" +
                "              \"serverName\": \"test.com\",\n" +
                "              \"port\": 80,\n" +
                "              \"path\": \"/a /b /c /m /n /q /p\"" +
                "          },\n" +
                "          {\n" +
                "              \"serverName\": \"test.com\",\n" +
                "              \"port\": 81,\n" +
                "              \"path\": \"/\"" +
                "          },\n" +
                "          {\n" +
                "              \"serverName\": \"test.com\",\n" +
                "              \"port\": 82,\n" +
                "              \"path\": \"/abcd /efg /vpc/abcd\"\n" +
                "          }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "urlFlowNormalPrepare001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "url flow normal test of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("targetGroup", String.class.toString(), targetGroup, null));
        DataUnits.add(new DataUnit("listener", String.class.toString(), listener, null));
        DataUnits.add(new DataUnit("urlCheckList", String.class.toString(), urlCheckList, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer099", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
