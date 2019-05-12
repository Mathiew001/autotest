package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.listener;

import java.util.ArrayList;
import java.util.List;

import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;
import com.netease.cloudqa.nlb.api.test.framework.model.TableData;
import org.testng.annotations.Test;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

/**
 *
 * @author chentianyu1
 * @version $Id: CreateLbListenerIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CreateLbListenerNormalPrepare extends BasePrepare {

    //创建两个mix http监听，绑定同一个目标组
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"*\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
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
                + "        }\n"
                + "    ],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"*\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
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
                + "        }\n"
                + "    ],\n"
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"*\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":1,\n" +
                "        \"LsnAttrs\": {}," +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"*\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"LsnAttrs\": {}," +
                "        \"Name\":\"testln2\"\n" +
                "    }\n" +
                "]\n" +
                "\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb http listener with same tg of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "*", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "*", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners

        col11.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个mix tcp监听，绑定同一个目标组
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "              \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "             \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "              \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"LsnAttrs\": {}," +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"LsnAttrs\": {}," +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb tcp listener with same tg of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners

        col9.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个mix https监听，绑定同一个目标组
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String targetGroupId1 = ConfigLoader.configration.getExtConfig("target_group_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String certId2 = ConfigLoader.configration.getExtConfig("cert_id2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "     },"
                + "     {\n" + "\"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId2 + "\",\n"
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
                + "     }"
                + "],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"LsnAttrs\": {"
                + "         \"DefaultCert\": \"" + certId2 + "\""
                + "     },"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"LsnAttrs\": {" +
                "                 \"DefaultCert\": \"" + certId2 + "\"" +
                "            }," +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
                "                    \"CertId\":\"" + certId2 + "\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb https listener with same tg of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
//        TableData lb_user_servers_group = new TableData();
//        lb_user_servers_group.setTableName("lb_user_servers_group");
//        List<DataUnit> col3 = new ArrayList<DataUnit>();
//        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
//        col3.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
//        col3.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
//        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
//        col3.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
//        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
//        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
//
//        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
//        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
//        col4.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
//        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
//        col4.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
//        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
//        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
//        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
//        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        List<DataUnit> col13 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_1");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col13.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col13.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col13, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个mix tls监听，绑定同一个目标组
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String targetGroupId1 = ConfigLoader.configration.getExtConfig("target_group_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 20,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 21,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":20,\n" +
                "        \"Name\":\"testln1\",\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
                "        \"ListenPort\":21,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb tls listener with same tg of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 20, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "tls", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 20, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 21, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "tls", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 21, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners

        col10.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        col12.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个vpc_mix http监听，绑定同一个目标组
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"leastconn\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"ForwardPort\": 0,\n"
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
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
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
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb http listener with same tg of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners

        col11.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个vpc_mix tcp监听，绑定同一个目标组
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    }\n" +
                "]\n";


        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb https listener with same tg of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners

        col9.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个vpc_mix https监听，绑定同一个目标组
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String certId2 = ConfigLoader.configration.getExtConfig("cert_id2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "     {\n" + "\"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId2 + "\",\n"
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
                + "    \"LsnAttrs\": {"
                + "         \"DefaultCert\": \"" + certId2 + "\""
                + "     },"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }, \n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId2 + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "    \"LsnAttrs\": {" +
                "         \"DefaultCert\": \"" + certId2 + "\"" +
                "     }," +
                "        \"Balance\":\"leastconn\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1026,\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb tcp listener with same tg of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
//        TableData lb_user_servers_group = new TableData();
//        lb_user_servers_group.setTableName("lb_user_servers_group");
//        List<DataUnit> col3 = new ArrayList<DataUnit>();
//        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
//        col3.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
//        col3.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
//        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
//        col3.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
//        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
//        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
//
//        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
//        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
//        col4.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
//        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
//        col4.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
//        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
//        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
//        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
//        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        List<DataUnit> col13 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_1");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col13.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col13.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col13, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个vpc_mix tls监听，绑定同一个目标组
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 20,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 21,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":20,\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":21,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"Gzip\":0,\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb tls listener with same tg of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 20, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "tls", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 20, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 21, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "tls", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 21, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners

        col10.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        col12.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建一个vpc_mix http监听，不同domain+path绑定同一个目标组
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal017() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"leastconn\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"ForwardPort\": 0,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"test.com\",\n"
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
                + "},"
                + "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 0,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
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
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
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
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
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
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb http listener with same tg of different domain+path of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col3.add(new DataUnit("name", String.class.toString(), "testln3", null, FlagConstant.Y));
        col3.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col3.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col3.add(new DataUnit("sport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col3.add(new DataUnit("dport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        lb_listeners.addColumn(col3, "lb_listeners_3");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        List<DataUnit> col6 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col5.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col5.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col5.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col5.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col5.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col5.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col5.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col6.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col6.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col6.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col6.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col6.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col6.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col6.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col5, "lb_user_servers_group_2");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col6, "lb_user_servers_group_3");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners

        col11.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_2");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_3");  //add record into lb_listeners

        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建一个mix http监听，不同domain+path绑定同一个目标组
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal018() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String targetGroupId1 = ConfigLoader.configration.getExtConfig("target_group_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
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
                + "        }\n"
                + "    ],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
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
                + "        }\n"
                + "    ],\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"Policy\": {\n"
                + "                \"Mode\": \"rewrite\",\n"
                + "                \"CookieName\": \"asfsd\",\n"
                + "                \"Expire\": 30000\n"
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
                + "        }\n"
                + "    ],\n"
                + "    \"Gzip\": 0\n"
                + "}" +
                "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":1,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"http\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\"\n" +
                "    }\n" +
                "]\n" +
                "\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb http listener with same tg of different domain+path of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col3.add(new DataUnit("name", String.class.toString(), "testln3", null, FlagConstant.Y));
        col3.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col3.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col3.add(new DataUnit("sport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col3.add(new DataUnit("dport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        lb_listeners.addColumn(col3, "lb_listeners_3");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        List<DataUnit> col6 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col5.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col5.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col5.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col5.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col5.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col5.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col5.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col6.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col6.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col6.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col6.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col6.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col6.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col6.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col5, "lb_user_servers_group_2");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col6, "lb_user_servers_group_3");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners

        col11.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_2");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_3");  //add record into lb_listeners

        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建一个mix https监听，不同domain+path绑定同一个目标组
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal019() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String targetGroupId1 = ConfigLoader.configration.getExtConfig("target_group_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}" +
                "]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb https listener with same tg of different domain+path of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));


        col3.add(new DataUnit("name", String.class.toString(), "testln3", null, FlagConstant.Y));
        col3.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col3.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col3.add(new DataUnit("sport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col3.add(new DataUnit("dport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        lb_listeners.addColumn(col3, "lb_listeners_3");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        List<DataUnit> col6 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col5.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col5.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col5.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col5.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col5.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col5.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col5.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col5.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col6.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col6.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col6.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col6.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col6.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col6.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col6.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col6.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col5, "lb_user_servers_group_2");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col6, "lb_user_servers_group_3");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        List<DataUnit> col13 = new ArrayList<DataUnit>();
        List<DataUnit> col14 = new ArrayList<DataUnit>();
        List<DataUnit> col15 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_1");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col13.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col13.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));

        col14.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col14.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col15.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col15.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col13, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col14, "lb_listener_attrs_3");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col15, "lb_listener_attrs_3");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建一个vpc_mix https监听，不同domain+path绑定同一个目标组
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal020() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "},"
                + "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb https listener with same tg of different domain+path of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));


        col3.add(new DataUnit("name", String.class.toString(), "testln3", null, FlagConstant.Y));
        col3.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col3.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col3.add(new DataUnit("sport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col3.add(new DataUnit("dport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        lb_listeners.addColumn(col3, "lb_listeners_3");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        List<DataUnit> col6 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col5.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col5.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col5.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col5.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col5.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col5.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col5.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col5.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col6.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col6.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col6.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col6.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col6.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col6.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col6.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col6.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col5, "lb_user_servers_group_2");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col6, "lb_user_servers_group_3");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        List<DataUnit> col13 = new ArrayList<DataUnit>();
        List<DataUnit> col14 = new ArrayList<DataUnit>();
        List<DataUnit> col15 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_1");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col13.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col13.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));

        col14.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col14.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col15.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col15.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col13, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col14, "lb_listener_attrs_3");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col15, "lb_listener_attrs_3");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //重复创建两次dns tcp监听, 绑定同一个目标组
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal022() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    }\n" +
                "]\n";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal022", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb tcp listener with same tg of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners

        col9.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个dns http监听，绑定同一个目标组
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal032() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"leastconn\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"ForwardPort\": 0,\n"
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
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
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
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal032", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb http listener with same tg of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners

        col11.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个dns https监听，绑定同一个目标组
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal033() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal033", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb tcp listener with same tg of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        List<DataUnit> col13 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_1");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col13.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col13.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col13, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个dns tls监听，绑定同一个目标组
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal034() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 20,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 21,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":20,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":21,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal034", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb tls listener with same tg of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 20, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "tls", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 20, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 21, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "tls", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 21, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners

        col10.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        col12.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }


    //创建一个dns http监听，不同domain+path绑定同一个目标组
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal035() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"leastconn\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"ForwardPort\": 0,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"test.com\",\n"
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
                + "},"
                + "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 0,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
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
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
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
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
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
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal035", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb http listener with same tg of different domain+path of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col3.add(new DataUnit("name", String.class.toString(), "testln3", null, FlagConstant.Y));
        col3.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col3.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col3.add(new DataUnit("sport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col3.add(new DataUnit("dport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        lb_listeners.addColumn(col3, "lb_listeners_3");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        List<DataUnit> col6 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col5.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col5.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col5.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col5.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col5.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col5.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col5.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col6.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col6.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col6.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col6.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col6.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col6.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col6.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col5, "lb_user_servers_group_2");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col6, "lb_user_servers_group_3");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners

        col11.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_2");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_3");  //add record into lb_listeners

        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建一个dns https监听，不同domain+path绑定同一个目标组
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal036() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "},"
                + "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal036", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb https listener with same tg of different domain+path of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));


        col3.add(new DataUnit("name", String.class.toString(), "testln3", null, FlagConstant.Y));
        col3.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col3.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col3.add(new DataUnit("sport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col3.add(new DataUnit("dport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        lb_listeners.addColumn(col3, "lb_listeners_3");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        List<DataUnit> col6 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col5.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col5.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col5.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col5.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col5.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col5.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col5.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col5.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col6.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col6.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col6.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col6.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col6.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col6.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col6.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col6.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col5, "lb_user_servers_group_2");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col6, "lb_user_servers_group_3");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        List<DataUnit> col13 = new ArrayList<DataUnit>();
        List<DataUnit> col14 = new ArrayList<DataUnit>();
        List<DataUnit> col15 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_1");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col13.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col13.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));

        col14.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col14.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col15.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col15.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col13, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col14, "lb_listener_attrs_3");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col15, "lb_listener_attrs_3");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //重复创建两次vpc_l4 tcp监听, 绑定同一个目标组
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal028() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    }\n" +
                "]\n";
        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal028", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb tcp listener with same tg of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col3.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col3.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners

        col9.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "timeout", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1000000", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //重复创建3次mix http监听
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal016() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1\n"
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
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\": 1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\": 0,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
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
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\": 1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb http listener of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col3.add(new DataUnit("name", String.class.toString(), "testln3", null, FlagConstant.Y));
        col3.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col3.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col3.add(new DataUnit("sport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col3.add(new DataUnit("dport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        lb_listeners.addColumn(col3, "lb_listeners_3");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        List<DataUnit> col6 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("name", String.class.toString(), "tg-test-01", null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col5.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col5.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col5.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col5.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col5.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col5.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col5.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col6.add(new DataUnit("name", String.class.toString(), "tg-test-03", null, FlagConstant.Y));
        col6.add(new DataUnit("path", String.class.toString(), "/c", null, FlagConstant.Y));
        col6.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col6.add(new DataUnit("serverName", String.class.toString(), "cty.com", null, FlagConstant.Y));
        col6.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col6.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col6.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col5, "lb_user_servers_group_2");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col6, "lb_user_servers_group_3");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners

        col11.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_2");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_3");  //add record into lb_listeners

        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //重复创建3次mix https监听
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb https listener of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次mix tcp监听
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\"\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tcp listener of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次mix tls监听
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 20,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 21,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 22,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"

                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":20,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":21,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":22,\n" +
                "        \"Name\":\"testln3\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"leastconn\"\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tls listener of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次vpc_mix tls监听
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 20,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 21,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 22,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":20,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":21,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
//                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":22,\n" +
                "        \"Name\":\"testln3\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tls listener of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次vpc_mix tcp监听
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\"\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tcp listener of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次vpc_mix https监听
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal014() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" +cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/c\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"cty.com\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb https listener of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次vpc_mix http监听
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
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
                + "    \"Gzip\": 1,\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"ForwardPort\": 0,\n"
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
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
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
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb http listener of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次dns tcp监听
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal021() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\"\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal021", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tcp listener of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次dns http监听
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal029() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
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
                + "    \"Gzip\": 1,\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"ForwardPort\": 0,\n"
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
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
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
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal029", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb http listener of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次dns https监听
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal030() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" +cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/c\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"cty.com\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal030", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb https listener of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次dns tls监听
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal031() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 20,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 21,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 22,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":20,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":21,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":22,\n" +
                "        \"Name\":\"testln3\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal031", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tls listener of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次机房网vpc_mix tcp监听
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal023() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\"\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal023", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tcp listener of vpc_mix of idc", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次机房网vpc_mix https监听
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal024() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
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
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal024", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb https listener of vpc_mix of idc", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次机房网vpc_mix http监听
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal025() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"http\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" +
                "\"ServerName\": \"test.com\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1\n"
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
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
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
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"Protocol\":\"http\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal025", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb http listener of vpc_mix of idc", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //重复创建3次机房网vpc_mix tls监听
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal026() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 20,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 21,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}"
                + "{\n"
                + "    \"InstanceId\": \"\",\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 22,\n"
                + "    \"Protocol\": \"tls\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
                + "            \"Monitor\": {\n"
                + "              \"Period\": 6000,\n"
                + "              \"Timeout\": 6000,\n"
                + "              \"Rise\": 6,\n"
                + "              \"Fall\": 6,\n"
                + "              \"Protocol\": \"http\",\n"
                + "              \"Url\": \"/index.html\",\n"
                + "              \"Rstatus\": \"2xx,3xx\" \n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":20,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":21,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":22,\n" +
                "        \"Name\":\"testln3\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Rstatus\":\"2xx,3xx\",\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"http\",\n" +
                "                    \"Url\":\"/index.html\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"tls\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "    }\n" +
                "]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal026", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tls listener of vpc_mix of idc", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //重复创建3次vpc_l4 tcp监听
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal027() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "},"
                + "{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"tcp\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "        {\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"Monitor\": {\n"
                + "                 \"Period\": 6000,\n"
                + "                 \"Timeout\": 6000,\n"
                + "                 \"Rise\": 6,\n"
                + "                 \"Fall\": 6,\n"
                + "                 \"Protocol\": \"tcp\"\n"
                + "            }\n"
                + "        }\n"
                + "    ],\n"
                + "    \"Timeout\": 1000000\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"Monitor\":{\n" +
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"roundrobin\",\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"Timeout\":1000000,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Url\":\"\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"ServerName\":\"\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"TraceVip\":0,\n" +
                "        \"Protocol\":\"tcp\",\n" +
                "        \"Balance\":\"leastconn\",\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\"\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal027", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb tcp listener of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建两个mix http2监听，绑定同一个目标组
    @CaseLabel(lbType = { "ha1.8mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal037() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String targetGroupId1 = ConfigLoader.configration.getExtConfig("target_group_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String certId2 = ConfigLoader.configration.getExtConfig("cert_id2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "     },"
                + "     {\n" + "\"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId2 + "\",\n"
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
                + "     }"
                + "],\n"
                + "    \"Gzip\": 1,\n"
                + "    \"LsnAttrs\": {"
                + "         \"DefaultCert\": \"" + certId2 + "\","
                + "         \"Alpn\": \"h2,http/1.1\""
                + "     },\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, "
                + "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\""
                + "     },"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"LsnAttrs\": {" +
                "                 \"DefaultCert\": \"" + certId2 + "\"," +
                "                 \"Alpn\": \"h2,http/1.1\"" +
                "            }," +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
                "                    \"CertId\":\"" + certId2 + "\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"https\",\n" +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"LsnAttrs\": {" +
                "                  \"Alpn\": \"h2,http/1.1\"" +
                "             }," +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal037", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb http2 listener with same tg of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer100", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
//        TableData lb_user_servers_group = new TableData();
//        lb_user_servers_group.setTableName("lb_user_servers_group");
//        List<DataUnit> col3 = new ArrayList<DataUnit>();
//        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
//        col3.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
//        col3.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
//        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
//        col3.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
//        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
//        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
//
//        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
//        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
//        col4.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
//        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
//        col4.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
//        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
//        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
//        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
//        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        List<DataUnit> col13 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_1");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col13.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col13.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col13, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建两个vpc_mix http2监听，绑定同一个目标组
    @CaseLabel(lbType = { "ha1.8vpc" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal038() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String certId2 = ConfigLoader.configration.getExtConfig("cert_id2");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "     {\n" + "\"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId2 + "\",\n"
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
                + "    \"LsnAttrs\": {"
                + "         \"DefaultCert\": \"" + certId2 + "\","
                + "         \"Alpn\": \"h2,http/1.1\""
                + "     },"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\""
                + "     },"
                + "    \"Gzip\": 0\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }, \n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId2 + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "         \"LsnAttrs\": {" +
                "              \"DefaultCert\": \"" + certId2 + "\"," +
                "               \"Alpn\": \"h2,http/1.1\"" +
                "          }," +
                "        \"Balance\":\"leastconn\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1026,\n" +
                "            \"LsnAttrs\": {" +
                "            }," +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n" +
                "         \"LsnAttrs\": {" +
                "               \"Alpn\": \"h2,http/1.1\"" +
                "         }," +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal038", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb http2 listener with same tg of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
//        TableData lb_user_servers_group = new TableData();
//        lb_user_servers_group.setTableName("lb_user_servers_group");
//        List<DataUnit> col3 = new ArrayList<DataUnit>();
//        List<DataUnit> col4 = new ArrayList<DataUnit>();
//        col3.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
//        col3.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
//        col3.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
//        col3.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
//        col3.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
//        col3.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col3.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
//        col3.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
//
//        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
//        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
//        col4.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
//        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
//        col4.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
//        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
//        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
//        lb_user_servers_group.addColumn(col3, "lb_user_servers_group_1");  //add record into lb_listeners
//        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        List<DataUnit> col13 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_1");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col13.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col13.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col13, "lb_listener_attrs_2");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建一个mix http2监听，不同domain+path绑定同一个目标组
    @CaseLabel(lbType = { "ha1.8mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal039() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String targetGroupId1 = ConfigLoader.configration.getExtConfig("target_group_id");
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}" +
                "]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"leastconn\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }, \n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal039", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb http2 listener with same tg of different domain+path of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer100", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));


        col3.add(new DataUnit("name", String.class.toString(), "testln3", null, FlagConstant.Y));
        col3.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col3.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col3.add(new DataUnit("sport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col3.add(new DataUnit("dport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        lb_listeners.addColumn(col3, "lb_listeners_3");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        List<DataUnit> col6 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col5.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col5.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col5.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col5.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col5.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col5.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col5.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col5.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col6.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col6.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col6.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col6.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col6.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col6.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col6.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col6.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col5, "lb_user_servers_group_2");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col6, "lb_user_servers_group_3");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        List<DataUnit> col13 = new ArrayList<DataUnit>();
        List<DataUnit> col14 = new ArrayList<DataUnit>();
        List<DataUnit> col15 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_1");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col13.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col13.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));

        col14.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col14.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col15.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col15.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col13, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col14, "lb_listener_attrs_3");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col15, "lb_listener_attrs_3");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建一个vpc_mix http2监听，不同domain+path绑定同一个目标组
    @CaseLabel(lbType = { "ha1.8vpc" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal040() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"leastconn\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "},"
                + "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}"
                + "]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
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
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "        \"Balance\":\"leastconn\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal040", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create two lb http2 listener with same tg of different domain+path of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_listeners col and value
        TableData lb_listeners = new TableData();
        lb_listeners.setTableName("lb_listeners");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("name", String.class.toString(), "testln1", null, FlagConstant.Y));
        col1.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col1.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col1.add(new DataUnit("sport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col1.add(new DataUnit("dport", Integer.class.toString(), 1025, null, FlagConstant.INT));
        col1.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col2.add(new DataUnit("name", String.class.toString(), "testln2", null, FlagConstant.Y));
        col2.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col2.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col2.add(new DataUnit("sport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col2.add(new DataUnit("dport", Integer.class.toString(), 1026, null, FlagConstant.INT));
        col2.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));


        col3.add(new DataUnit("name", String.class.toString(), "testln3", null, FlagConstant.Y));
        col3.add(new DataUnit("enable", String.class.toString(), "ON", null, FlagConstant.Y));
        col3.add(new DataUnit("groupId", String.class.toString(), "0", null, FlagConstant.Y));
        col3.add(new DataUnit("sport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("protocol", String.class.toString(), "https", null, FlagConstant.Y));
        col3.add(new DataUnit("dport", Integer.class.toString(), 1027, null, FlagConstant.INT));
        col3.add(new DataUnit("flag", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_listeners.addColumn(col1, "lb_listeners_1");  //add record into lb_listeners
        lb_listeners.addColumn(col2, "lb_listeners_2");  //add record into lb_listeners
        lb_listeners.addColumn(col3, "lb_listeners_3");  //add record into lb_listeners
        db_check.add(lb_listeners);  //add lb_listeners into db_check list


        //set lb_user_servers_group col and value
        TableData lb_user_servers_group = new TableData();
        lb_user_servers_group.setTableName("lb_user_servers_group");
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        List<DataUnit> col5 = new ArrayList<DataUnit>();
        List<DataUnit> col6 = new ArrayList<DataUnit>();
        col4.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col4.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col4.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col4.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col4.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col4.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col4.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col4.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col5.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col5.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col5.add(new DataUnit("path", String.class.toString(), "/b", null, FlagConstant.Y));
        col5.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col5.add(new DataUnit("serverName", String.class.toString(), "test.com", null, FlagConstant.Y));
        col5.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col5.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col5.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));

        col6.add(new DataUnit("name", String.class.toString(), "tg-test-02", null, FlagConstant.Y));
        col6.add(new DataUnit("certId", String.class.toString(), certId, null, FlagConstant.Y));
        col6.add(new DataUnit("path", String.class.toString(), "/a", null, FlagConstant.Y));
        col6.add(new DataUnit("clientTimeout", Integer.class.toString(), 900, null, FlagConstant.INT));
        col6.add(new DataUnit("serverName", String.class.toString(), "nimei.com", null, FlagConstant.Y));
        col6.add(new DataUnit("clusterPort", Integer.class.toString(), 0, null, FlagConstant.INT));
        col6.add(new DataUnit("tag", String.class.toString(), "target", null, FlagConstant.Y));
        col6.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        lb_user_servers_group.addColumn(col4, "lb_user_servers_group_1");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col5, "lb_user_servers_group_2");  //add record into lb_listeners
        lb_user_servers_group.addColumn(col6, "lb_user_servers_group_3");  //add record into lb_listeners
        db_check.add(lb_user_servers_group);  //add lb_listeners into db_check list

//        //set lb_user_servers col and value
//        TableData lb_user_servers = new TableData();
//        lb_user_servers.setTableName("lb_user_servers");
//        List<DataUnit> col5 = new ArrayList<DataUnit>();
//        List<DataUnit> col6 = new ArrayList<DataUnit>();
//        col5.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col5.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col5.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
//        col5.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col5.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col5.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col5.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col5.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col5.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//
//        col6.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
//        col6.add(new DataUnit("status", String.class.toString(), "UP", null, FlagConstant.Y));
//        col6.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
//        col6.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col6.add(new DataUnit("flag", Integer.class.toString(), 0, null, FlagConstant.INT));
//        col6.add(new DataUnit("port", Integer.class.toString(), 80, null, FlagConstant.C));
//        col6.add(new DataUnit("topAz", String.class.toString(), "pubt2", null, FlagConstant.Y));
//        col6.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
//        col6.add(new DataUnit("backup", Integer.class.toString(), 0, null, FlagConstant.INT));
//        lb_user_servers.addColumn(col5, "lb_user_servers_1");  //add record into lb_listeners
//        lb_user_servers.addColumn(col6, "lb_user_servers_2");  //add record into lb_listeners
//        db_check.add(lb_user_servers);  //add lb_listeners into db_check list

        //set lb_listener_attrs col and value
        TableData lb_listener_attrs = new TableData();
        lb_listener_attrs.setTableName("lb_listener_attrs");
        List<DataUnit> col7 = new ArrayList<DataUnit>();
        List<DataUnit> col8 = new ArrayList<DataUnit>();
        List<DataUnit> col9 = new ArrayList<DataUnit>();
        List<DataUnit> col10 = new ArrayList<DataUnit>();
        List<DataUnit> col11 = new ArrayList<DataUnit>();
        List<DataUnit> col12 = new ArrayList<DataUnit>();
        List<DataUnit> col13 = new ArrayList<DataUnit>();
        List<DataUnit> col14 = new ArrayList<DataUnit>();
        List<DataUnit> col15 = new ArrayList<DataUnit>();
        col7.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col7.add(new DataUnit("value", String.class.toString(), "leastconn", null, FlagConstant.Y));
        col8.add(new DataUnit("attr", String.class.toString(), "forwardPort", null, FlagConstant.C));
        col8.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col9.add(new DataUnit("attr", String.class.toString(), "gzip", null, FlagConstant.C));
        col9.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col10.add(new DataUnit("attr", String.class.toString(), "traceVip", null, FlagConstant.C));
        col10.add(new DataUnit("value", String.class.toString(), "1", null, FlagConstant.Y));
        col11.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col11.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col7, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col8, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col9, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col10, "lb_listener_attrs_1");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col11, "lb_listener_attrs_1");  //add record into lb_listeners

        col12.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col12.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col13.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col13.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));

        col14.add(new DataUnit("attr", String.class.toString(), "balance", null, FlagConstant.C));
        col14.add(new DataUnit("value", String.class.toString(), "roundrobin", null, FlagConstant.Y));
        col15.add(new DataUnit("attr", String.class.toString(), "cipherSuiteId", null, FlagConstant.C));
        col15.add(new DataUnit("value", String.class.toString(), cipherSuiteId, null, FlagConstant.Y));
        lb_listener_attrs.addColumn(col12, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col13, "lb_listener_attrs_2");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col14, "lb_listener_attrs_3");  //add record into lb_listeners
        lb_listener_attrs.addColumn(col15, "lb_listener_attrs_3");  //add record into lb_listeners
        db_check.add(lb_listener_attrs);  //add lb_listeners into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //重复创建3次mix http2监听
    @CaseLabel(lbType = { "ha1.8mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal041() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "        {\n" +
                "            \"Name\":\"testln1\",\n" +
                "            \"ListenPort\":1025,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "            \"TraceVip\":1,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":1,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-01\",\n" +
                "                    \"ServerName\":\"test.com\",\n" +
                "                    \"Path\":\"/a\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                    \"CertId\":\"" + certId + "\",\n" +
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
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln2\",\n" +
                "            \"ListenPort\":1026,\n" +
                "            \"ForwardPort\":0,\n" +
                "            \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-02\",\n" +
                "                    \"ServerName\":\"nimei.com\",\n" +
                "                    \"Path\":\"/b\",\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"testln3\",\n" +
                "            \"ListenPort\":1027,\n" +
                "            \"ForwardPort\":1,\n" +
                "            \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "            \"TraceVip\":0,\n" +
                "            \"Balance\":\"roundrobin\",\n" +
                "            \"Gzip\":0,\n" +
                "            \"Status\":\"ON\",\n" +
                "            \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "            \"Clusters\":[\n" +
                "                {\n" +
                "                    \"Name\":\"tg-test-03\",\n" +
                "                    \"ServerName\":\"cty.com\",\n" +
                "                    \"Path\":\"/c\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"CertId\":\"" + certId + "\",\n" +
                "                    \"Monitor\":{\n" +
                "                        \"Protocol\":\"tcp\",\n" +
                "                        \"Rise\":6,\n" +
                "                        \"Fall\":6,\n" +
                "                        \"Url\":\"\",\n" +
                "                        \"Timeout\":6000,\n" +
                "                        \"Period\":6000\n" +
                "                    },\n" +
                "                    \"Policy\":{\n" +
                "                        \"Mode\":\"insert\",\n" +
                "                        \"Expire\":30000\n" +
                "                    },\n" +
//                "                    \"Status\":\"UP\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal041", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb http2 listener of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer100", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //重复创建3次vpc_mix http2监听
    @CaseLabel(lbType = { "ha1.8vpc" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createLbListenerNormal042() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String certId = ConfigLoader.configration.getExtConfig("cert_id");
        String cipherSuiteId = ConfigLoader.configration.getExtConfig("cipher_suite_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String executeBody = "[{\n"
                + "    \"InstanceId\": \"instanceId\",\n"
                + "    \"Name\": \"testln1\",\n"
                + "    \"ListenPort\": 1025,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"TraceVip\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "     {\n" + "\"ServerName\": \"test.com\",\n"
                + "            \"Path\": \"/a\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"Gzip\": 1,\n"
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\"\n"
                + "}, " +
                "{\n"
                + "    \"Name\": \"testln2\",\n"
                + "    \"ListenPort\": 1026,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"nimei.com\",\n"
                + "            \"Path\": \"/b\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}," +
                "{\n"
                + "    \"Name\": \"testln3\",\n"
                + "    \"ListenPort\": 1027,\n"
                + "    \"ForwardPort\": 1,\n"
                + "    \"Protocol\": \"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, "
                + "    \"Balance\": \"roundrobin\",\n"
                + "    \"Clusters\": [\n"
                + "      {\n"
                + "            \"ServerName\": \"cty.com\",\n"
                + "            \"Path\": \"/c\",\n"
                + "            \"TargetGroupId\": \"targetGroupId\",\n"
                + "            \"CertId\": \"" + certId + "\",\n"
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
                + "    \"CipherSuiteId\": \"" + cipherSuiteId + "\",\n"
                + "    \"Gzip\": 0\n"
                + "}]";
        //set response message
        String resMsg = "[\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":1,\n" +
                "        \"ListenPort\":1025,\n" +
                "        \"Name\":\"testln1\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":1, \n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/a\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"rewrite\",\n" +
                "                    \"CookieName\":\"asfsd\"\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" + rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    }\n" +
                "                ],\n" +
                "            \"Monitor\": {\n" +
                "              \"Period\": 6000,\n" +
                "              \"Timeout\": 6000,\n" +
                "              \"Rise\": 6,\n" +
                "              \"Fall\": 6,\n" +
                "              \"Protocol\": \"http\",\n" +
                "              \"Url\": \"/index.html\",\n" +
                "              \"Rstatus\": \"2xx,3xx\" \n" +
                "            },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"test.com\",\n" +
                "                \"Name\":\"tg-test-01\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1026,\n" +
                "        \"Name\":\"testln2\",\n" +
                "        \"CipherSuiteId\":\"" +cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":0,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/b\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"nimei.com\",\n" +
                "                \"Name\":\"tg-test-02\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "        \"Balance\":\"roundrobin\",\n" +
                "    },\n" +
                "    {\n" +
                "        \"Status\":\"ON\",\n" +
                "        \"TraceVip\":0,\n" +
                "        \"ListenPort\":1027,\n" +
                "        \"Name\":\"testln3\",\n" +
                "        \"CipherSuiteId\":\"" + cipherSuiteId + "\",\n" +
                "        \"ForwardPort\":1,\n" +
                "        \"Gzip\":0,\n" +
                "        \"Clusters\":[\n" +
                "            {\n" +
                "                \"Path\":\"/c\",\n" +
                "                \"Policy\":{\n" +
                "                    \"Expire\":30000,\n" +
                "                    \"Mode\":\"insert\",\n" +
                "                },\n" +
//                "                \"Status\":\"UP\",\n" +
                "                \"Instances\":[\n" +
                "                    {\n" +
//                "                        \"Status\":\"UP\",\n" +
                "                        \"Address\":\"" +rsAddress1 + "\",\n" +
                "                        \"Port\":80,\n" +
                "                        \"Backup\":0,\n" +
                "                        \"Id\":\"" + realServer1 + "\",\n" +
                "                        \"Weight\":100,\n" +
                "                        \"Name\":\"" + rsName1 + "\"\n" +
                "                    },\n" +
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
                "                    \"Timeout\":6000,\n" +
                "                    \"Period\":6000,\n" +
                "                    \"Fall\":6,\n" +
                "                    \"Protocol\":\"tcp\",\n" +
                "                    \"Rise\":6\n" +
                "                },\n" +
                "                \"CertId\":\"" + certId + "\",\n" +
                "                \"ServerName\":\"cty.com\",\n" +
                "                \"Name\":\"tg-test-03\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"Protocol\":\"https\",\n"
                + "    \"LsnAttrs\": {"
                + "         \"Alpn\": \"h2,http/1.1\"\n"
                + "     }, " +
                "        \"Balance\":\"roundrobin\",\n" +
                "    }\n" +
                "]\n";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createLbListenerNormal042", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create lb http2 listener of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("executeBody", String.class.toString(), executeBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer101", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        DataUnits.add(new DataUnit("sameGroup", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
