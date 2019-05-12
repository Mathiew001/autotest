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
 * @version $Id: UpdateLbListenerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateLbListenerNormalPrepare extends BasePrepare {

    //更新监听
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
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
                "    \"TraceVip\": 0,\n" +
                "    \"ForwardPort\": 0\n" +
                "}," +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"ForwardPort\": 1,\n" +
                "    \"TraceVip\":1,\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
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
                "              \"Rstatus\": \"2xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Gzip\":1,\n" +
                "        \"ForwardPort\": 1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":40000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Rstatus\":\"2xx\",\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":7,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":7\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":1,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，默认monitor
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
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
                "    \"ForwardPort\":1,\n" +
                "    \"TraceVip\":1,\n" +
                "    \"Gzip\": 1\n" +
                "}," +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 40000\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"ForwardPort\":0,\n" +
                "    \"TraceVip\":0\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":40000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":10,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":10\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, default monitor", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，不使用会话保持
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
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
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"ForwardPort\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":10,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":10\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, no session sticky", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
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
                "    \"TraceVip\": 0,\n" +
                "    \"ForwardPort\": 0\n" +
                "}, " +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
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
                "              \"Rstatus\": \"2xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"ForwardPort\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "       \"Gzip\": 1,\n" +
                "       \"TraceVip\": 1,\n" +
                "       \"ForwardPort\": 1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":40000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Rstatus\":\"2xx\",\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":7,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":7\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，默认monitor
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
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
                "    \"ForwardPort\": 1\n" +
                "}," +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 40000\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0,\n" +
                "    \"TraceVip\": 0,\n" +
                "    \"ForwardPort\": 0\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "       \"Gzip\": 0,\n" +
                "       \"TraceVip\": 0,\n" +
                "       \"ForwardPort\": 0, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":40000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":10,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":10\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, default monitor", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，不使用会话保持
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"http\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
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
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"ForwardPort\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "       \"Gzip\": 1,\n" +
                "       \"TraceVip\": 1,\n" +
                "       \"ForwardPort\": 1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":10,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":10\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, no session sticky", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\",\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 7000,\n" +
                "              \"Timeout\": 7000,\n" +
                "              \"Rise\": 7,\n" +
                "              \"Fall\": 7,\n" +
                "              \"Protocol\": \"tcp\",\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":900000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":7,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":7\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，默认monitor
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
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
                "}," +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":10,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":10\n" +
                "                },\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, default monitor", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，不使用会话保持
    @CaseLabel(lbType = {"dns"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
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
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"ForwardPort\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "       \"Gzip\": 1,\n" +
                "       \"TraceVip\": 1,\n" +
                "       \"ForwardPort\": 1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":10,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":10\n" +
                "                },\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, no session sticky", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}, " +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
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
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Gzip\":1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":40000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":7,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":7\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，默认monitor
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}," +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"insert\",\n" +
                "                \"Expire\": 40000\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Gzip\":1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":40000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":10,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":10\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, default monitor", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，不使用会话保持
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
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
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 0\n" +
                "}, " +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Gzip\":1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":10,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":10\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, no session sticky", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"tcp\",\n" +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"tcp\",\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}, " +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 7000,\n" +
                "              \"Timeout\": 7000,\n" +
                "              \"Rise\": 7,\n" +
                "              \"Fall\": 7,\n" +
                "              \"Protocol\": \"tcp\",\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":900000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":7,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":7\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，默认monitor
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal014() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
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
                "}," +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "        }\n" +
                "    ]\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":10,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":10\n" +
                "                },\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, default monitor", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，不使用会话保持
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
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
                "    \"Balance\": \"leastconn\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"ForwardPort\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "       \"Gzip\": 1,\n" +
                "       \"TraceVip\": 1,\n" +
                "       \"ForwardPort\": 1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":10,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":10\n" +
                "                },\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener, no session sticky", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，alpn=""
    @CaseLabel(lbType = {"ha1.8vpc"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal016() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"LsnAttrs\": {\n" +
                "        \"Alpn\": \"h2,http/1.1\"\n" +
                "     }," +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"CipherSuiteId\": \"" +cipherSuiteId + "\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
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
                "    \"TraceVip\": 0,\n" +
                "    \"ForwardPort\": 0\n" +
                "}, " +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"CipherSuiteId\": \"" +cipherSuiteId + "\",\n" +
                "    \"LsnAttrs\": {\n" +
                "        \"Alpn\": \"\"\n" +
                "     }," +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
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
                "              \"Rstatus\": \"2xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"ForwardPort\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "       \"Gzip\": 1,\n" +
                "       \"TraceVip\": 1,\n" +
                "       \"ForwardPort\": 1, \n" +
                "       \"LsnAttrs\": {\n" +
                "        }," +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":40000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Rstatus\":\"2xx\",\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":7,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":7\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener of ha1.8vpc alpn=null", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新监听，alpn=http/1.1
    @CaseLabel(lbType = {"ha1.8vpc"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLbListenerNormal017() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        //set request body
        String body = "[{\n" +
                "    \"Name\": \"testln1\",\n" +
                "    \"ListenPort\": 1026,\n" +
                "    \"Protocol\": \"https\",\n" +
                "    \"LsnAttrs\": {\n" +
                "        \"Alpn\": \"h2,http/1.1\"\n" +
                "     }," +
                "    \"Balance\": \"roundrobin\",\n" +
                "    \"CipherSuiteId\": \"" +cipherSuiteId + "\",\n" +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"*\",\n" +
                "            \"Path\": \"/a\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
                "            \"Policy\": {\n" +
                "                \"Mode\": \"rewrite\",\n" +
                "                \"CookieName\": \"asfsd\"\n" +
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
                "    \"TraceVip\": 0,\n" +
                "    \"ForwardPort\": 0\n" +
                "}, " +
                "{\n" +
                "    \"Balance\": \"leastconn\",\n" +
                "    \"CipherSuiteId\": \"" +cipherSuiteId + "\",\n" +
                "    \"LsnAttrs\": {\n" +
                "        \"Alpn\": \"http/1.1\"\n" +
                "     }," +
                "    \"Clusters\": [\n" +
                "        {\n" +
                "            \"ServerName\": \"test.com\",\n" +
                "            \"Path\": \"/b\",\n" +
                "            \"CertId\": \"" + certId + "\",\n" +
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
                "              \"Rstatus\": \"2xx\" \n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Gzip\": 1,\n" +
                "    \"TraceVip\": 1,\n" +
                "    \"ForwardPort\": 1\n" +
                "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "       \"Gzip\": 1,\n" +
                "       \"TraceVip\": 1,\n" +
                "       \"ForwardPort\": 1, \n" +
                "       \"LsnAttrs\": {\n" +
                "           \"Alpn\": \"http/1.1\"\n" +
                "        }," +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":40000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress2 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer2 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName2 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":7000,\n" +
                "                    \"Rstatus\":\"2xx\",\n" +
                "                    \"Period\":7000,\n" +
                "                    \"Fall\":7,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index1.html\",\n" +
                "                    \"Rise\":7\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLbListenerNormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update lb listener of ha1.8vpc alpn=http/1.1", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
