package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.targetgroup;

import java.util.ArrayList;
import java.util.List;
import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.model.TableData;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;

/**
 *
 * @author chentianyu1
 * @version $Id: CreateTargetGroupNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CreateTargetGroupNormalPrepare extends BasePrepare {

    //创建目标组，带2个后端主机，端口不同, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");
        String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":8081,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":80,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 2 rs diff port of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_tgroup col and value
        TableData lb_tgroup = new TableData();
        lb_tgroup.setTableName("lb_tgroup");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        col1.add(new DataUnit("name", String.class.toString(), "tg-test", null, FlagConstant.Y));
        lb_tgroup.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_tgroup);  //add lb_vip into db_check list

        //set lb_tgroup_monitor col and value
        TableData lb_tgroup_monitor = new TableData();
        lb_tgroup_monitor.setTableName("lb_tgroup_monitor");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("rise", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("fall", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("period", Integer.class.toString(), 6000, null, FlagConstant.INT));
        col2.add(new DataUnit("timeout", Integer.class.toString(), 6000, null, FlagConstant.INT));
        col2.add(new DataUnit("url", String.class.toString(), "/index.html", null, FlagConstant.Y));
        col2.add(new DataUnit("rstatus", String.class.toString(), "2xx,3xx", null, FlagConstant.Y));
        col2.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col2.add(new DataUnit("port", Integer.class.toString(), 0, null, FlagConstant.INT));
        lb_tgroup_monitor.addColumn(col2);  //add record into lb_vip
        db_check.add(lb_tgroup_monitor);  //add lb_vip into db_check list

        //set lb_tgroup_server col and value
        TableData lb_tgroup_server = new TableData();
        lb_tgroup_server.setTableName("lb_tgroup_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), rsName1, null, FlagConstant.Y));
        col3.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
        col3.add(new DataUnit("port", Integer.class.toString(), 8080, null, FlagConstant.C));
        col3.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
        col3.add(new DataUnit("topaz", String.class.toString(), "pubt1", null, FlagConstant.Y));

        col4.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
        col4.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
        col4.add(new DataUnit("port", Integer.class.toString(), 8081, null, FlagConstant.C));
        col4.add(new DataUnit("weight", Integer.class.toString(), 80, null, FlagConstant.INT));
        col4.add(new DataUnit("topaz", String.class.toString(), "pubt1", null, FlagConstant.Y));
        lb_tgroup_server.addColumn(col3, "tgroup_server_1");  //add record into lb_vip
        lb_tgroup_server.addColumn(col4, "tgroup_server_2");  //add record into lb_vip
        db_check.add(lb_tgroup_server);  //add lb_vip into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建目标组，带2个后端主机，端口相同, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":1" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":80,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/\",\n" +
                "                \"Timeout\":2000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 2 rs same port of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_tgroup col and value
        TableData lb_tgroup = new TableData();
        lb_tgroup.setTableName("lb_tgroup");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("useSamePort", Boolean.class.toString(), true, null, FlagConstant.BOOLEAN));
        col1.add(new DataUnit("name", String.class.toString(), "tg-test", null, FlagConstant.Y));
        lb_tgroup.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_tgroup);  //add lb_vip into db_check list

        //set lb_tgroup_monitor col and value
        TableData lb_tgroup_monitor = new TableData();
        lb_tgroup_monitor.setTableName("lb_tgroup_monitor");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("rise", Integer.class.toString(), 2, null, FlagConstant.INT));
        col2.add(new DataUnit("fall", Integer.class.toString(), 3, null, FlagConstant.INT));
        col2.add(new DataUnit("period", Integer.class.toString(), 5000, null, FlagConstant.INT));
        col2.add(new DataUnit("timeout", Integer.class.toString(), 2000, null, FlagConstant.INT));
        col2.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col2.add(new DataUnit("rstatus", String.class.toString(), null, null, FlagConstant.Y));
        col2.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col2.add(new DataUnit("port", Integer.class.toString(), 0, null, FlagConstant.INT));
        lb_tgroup_monitor.addColumn(col2);  //add record into lb_vip
        db_check.add(lb_tgroup_monitor);  //add lb_vip into db_check list

        //set lb_tgroup_server col and value
        TableData lb_tgroup_server = new TableData();
        lb_tgroup_server.setTableName("lb_tgroup_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), rsName1, null, FlagConstant.Y));
        col3.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
        col3.add(new DataUnit("port", Integer.class.toString(), 8080, null, FlagConstant.C));
        col3.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
        col3.add(new DataUnit("topaz", String.class.toString(), "pubt1", null, FlagConstant.Y));

        col4.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
        col4.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
        col4.add(new DataUnit("port", Integer.class.toString(), 8080, null, FlagConstant.C));
        col4.add(new DataUnit("weight", Integer.class.toString(), 80, null, FlagConstant.INT));
        col4.add(new DataUnit("topaz", String.class.toString(), "pubt1", null, FlagConstant.Y));
        lb_tgroup_server.addColumn(col3, "tgroup_server_1");  //add record into lb_vip
        lb_tgroup_server.addColumn(col4, "tgroup_server_2");  //add record into lb_vip
        db_check.add(lb_tgroup_server);  //add lb_vip into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);

        return holder;
    }

    //创建空目标组
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //get config
        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[]," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create null tg of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_tgroup col and value
        TableData lb_tgroup = new TableData();
        lb_tgroup.setTableName("lb_tgroup");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        col1.add(new DataUnit("name", String.class.toString(), "tg-test", null, FlagConstant.Y));
        lb_tgroup.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_tgroup);  //add lb_vip into db_check list

        //set lb_tgroup_monitor col and value
        TableData lb_tgroup_monitor = new TableData();
        lb_tgroup_monitor.setTableName("lb_tgroup_monitor");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("rise", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("fall", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("period", Integer.class.toString(), 5000, null, FlagConstant.INT));
        col2.add(new DataUnit("timeout", Integer.class.toString(), 5000, null, FlagConstant.INT));
        col2.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col2.add(new DataUnit("rstatus", String.class.toString(), null, null, FlagConstant.Y));
        col2.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col2.add(new DataUnit("port", Integer.class.toString(), 0, null, FlagConstant.INT));
        lb_tgroup_monitor.addColumn(col2);  //add record into lb_vip
        db_check.add(lb_tgroup_monitor);  //add lb_vip into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建目标组，带2个后端主机，端口不同, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":8081,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":80,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 2 rs diff port of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_tgroup col and value
        TableData lb_tgroup = new TableData();
        lb_tgroup.setTableName("lb_tgroup");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        col1.add(new DataUnit("name", String.class.toString(), "tg-test", null, FlagConstant.Y));
        lb_tgroup.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_tgroup);  //add lb_vip into db_check list

        //set lb_tgroup_monitor col and value
        TableData lb_tgroup_monitor = new TableData();
        lb_tgroup_monitor.setTableName("lb_tgroup_monitor");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("rise", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("fall", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("period", Integer.class.toString(), 6000, null, FlagConstant.INT));
        col2.add(new DataUnit("timeout", Integer.class.toString(), 6000, null, FlagConstant.INT));
        col2.add(new DataUnit("url", String.class.toString(), "/index.html", null, FlagConstant.Y));
        col2.add(new DataUnit("rstatus", String.class.toString(), "2xx,3xx", null, FlagConstant.Y));
        col2.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col2.add(new DataUnit("port", Integer.class.toString(), 0, null, FlagConstant.INT));
        lb_tgroup_monitor.addColumn(col2);  //add record into lb_vip
        db_check.add(lb_tgroup_monitor);  //add lb_vip into db_check list

        //set lb_tgroup_server col and value
        TableData lb_tgroup_server = new TableData();
        lb_tgroup_server.setTableName("lb_tgroup_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), rsName1, null, FlagConstant.Y));
        col3.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
        col3.add(new DataUnit("port", Integer.class.toString(), 8080, null, FlagConstant.C));
        col3.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
        col3.add(new DataUnit("topaz", String.class.toString(), "pubt2", null, FlagConstant.Y));

        col4.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
        col4.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
        col4.add(new DataUnit("port", Integer.class.toString(), 8081, null, FlagConstant.C));
        col4.add(new DataUnit("weight", Integer.class.toString(), 80, null, FlagConstant.INT));
        col4.add(new DataUnit("topaz", String.class.toString(), "pubt2", null, FlagConstant.Y));
        lb_tgroup_server.addColumn(col3, "tgroup_server_1");  //add record into lb_vip
        lb_tgroup_server.addColumn(col4, "tgroup_server_2");  //add record into lb_vip
        db_check.add(lb_tgroup_server);  //add lb_vip into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建目标组，带2个后端主机，端口相同, vpc_mix
    @PrepareDescription(isPrepareMethod = true)
    @CaseLabel(lbType = { "vpc_mix" })
    public DataHolder createTargetGroupNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":80,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/\",\n" +
                "                \"Timeout\":2000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 2 rs same port of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_tgroup col and value
        TableData lb_tgroup = new TableData();
        lb_tgroup.setTableName("lb_tgroup");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("useSamePort", Boolean.class.toString(), true, null, FlagConstant.BOOLEAN));
        col1.add(new DataUnit("name", String.class.toString(), "tg-test", null, FlagConstant.Y));
        lb_tgroup.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_tgroup);  //add lb_vip into db_check list

        //set lb_tgroup_monitor col and value
        TableData lb_tgroup_monitor = new TableData();
        lb_tgroup_monitor.setTableName("lb_tgroup_monitor");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("rise", Integer.class.toString(), 2, null, FlagConstant.INT));
        col2.add(new DataUnit("fall", Integer.class.toString(), 3, null, FlagConstant.INT));
        col2.add(new DataUnit("period", Integer.class.toString(), 5000, null, FlagConstant.INT));
        col2.add(new DataUnit("timeout", Integer.class.toString(), 2000, null, FlagConstant.INT));
        col2.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col2.add(new DataUnit("rstatus", String.class.toString(), "2xx,3xx", null, FlagConstant.Y));
        col2.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col2.add(new DataUnit("port", Integer.class.toString(), 0, null, FlagConstant.INT));
        lb_tgroup_monitor.addColumn(col2);  //add record into lb_vip
        db_check.add(lb_tgroup_monitor);  //add lb_vip into db_check list

        //set lb_tgroup_server col and value
        TableData lb_tgroup_server = new TableData();
        lb_tgroup_server.setTableName("lb_tgroup_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), rsName1, null, FlagConstant.Y));
        col3.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
        col3.add(new DataUnit("port", Integer.class.toString(), 8080, null, FlagConstant.C));
        col3.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
        col3.add(new DataUnit("topaz", String.class.toString(), "pubt2", null, FlagConstant.Y));

        col4.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
        col4.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
        col4.add(new DataUnit("port", Integer.class.toString(), 8080, null, FlagConstant.C));
        col4.add(new DataUnit("weight", Integer.class.toString(), 80, null, FlagConstant.INT));
        col4.add(new DataUnit("topaz", String.class.toString(), "pubt2", null, FlagConstant.Y));
        lb_tgroup_server.addColumn(col3, "tgroup_server_1");  //add record into lb_vip
        lb_tgroup_server.addColumn(col4, "tgroup_server_2");  //add record into lb_vip
        db_check.add(lb_tgroup_server);  //add lb_vip into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建空目标组, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //get config
        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[], " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create null tg of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_tgroup col and value
        TableData lb_tgroup = new TableData();
        lb_tgroup.setTableName("lb_tgroup");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        col1.add(new DataUnit("name", String.class.toString(), "tg-test", null, FlagConstant.Y));
        lb_tgroup.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_tgroup);  //add lb_vip into db_check list

        //set lb_tgroup_monitor col and value
        TableData lb_tgroup_monitor = new TableData();
        lb_tgroup_monitor.setTableName("lb_tgroup_monitor");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("rise", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("fall", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("period", Integer.class.toString(), 5000, null, FlagConstant.INT));
        col2.add(new DataUnit("timeout", Integer.class.toString(), 5000, null, FlagConstant.INT));
        col2.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col2.add(new DataUnit("rstatus", String.class.toString(), "2xx,3xx", null, FlagConstant.Y));
        col2.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col2.add(new DataUnit("port", Integer.class.toString(), 0, null, FlagConstant.INT));
        lb_tgroup_monitor.addColumn(col2);  //add record into lb_vip
        db_check.add(lb_tgroup_monitor);  //add lb_vip into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建目标组，带2个后端主机，端口不同, dns+vip
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":8081,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":80,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ], \n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 2 rs diff port of dns+vip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_tgroup col and value
        TableData lb_tgroup = new TableData();
        lb_tgroup.setTableName("lb_tgroup");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        col1.add(new DataUnit("name", String.class.toString(), "tg-test", null, FlagConstant.Y));
        lb_tgroup.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_tgroup);  //add lb_vip into db_check list

        //set lb_tgroup_monitor col and value
        TableData lb_tgroup_monitor = new TableData();
        lb_tgroup_monitor.setTableName("lb_tgroup_monitor");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("rise", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("fall", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("period", Integer.class.toString(), 6000, null, FlagConstant.INT));
        col2.add(new DataUnit("timeout", Integer.class.toString(), 6000, null, FlagConstant.INT));
        col2.add(new DataUnit("url", String.class.toString(), "/index.html", null, FlagConstant.Y));
        col2.add(new DataUnit("rstatus", String.class.toString(), "2xx,3xx", null, FlagConstant.Y));
        col2.add(new DataUnit("protocol", String.class.toString(), "http", null, FlagConstant.Y));
        col2.add(new DataUnit("port", Integer.class.toString(), 0, null, FlagConstant.INT));
        lb_tgroup_monitor.addColumn(col2);  //add record into lb_vip
        db_check.add(lb_tgroup_monitor);  //add lb_vip into db_check list

        //set lb_tgroup_server col and value
        TableData lb_tgroup_server = new TableData();
        lb_tgroup_server.setTableName("lb_tgroup_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), rsName1, null, FlagConstant.Y));
        col3.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
        col3.add(new DataUnit("port", Integer.class.toString(), 8080, null, FlagConstant.C));
        col3.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
        col3.add(new DataUnit("topaz", String.class.toString(), "pubt2", null, FlagConstant.Y));

        col4.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
        col4.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
        col4.add(new DataUnit("port", Integer.class.toString(), 8081, null, FlagConstant.C));
        col4.add(new DataUnit("weight", Integer.class.toString(), 80, null, FlagConstant.INT));
        col4.add(new DataUnit("topaz", String.class.toString(), "pubt2", null, FlagConstant.Y));
        lb_tgroup_server.addColumn(col3, "tgroup_server_1");  //add record into lb_vip
        lb_tgroup_server.addColumn(col4, "tgroup_server_2");  //add record into lb_vip
        db_check.add(lb_tgroup_server);  //add lb_vip into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建目标组，带2个后端主机，端口相同, dns+vip
    @PrepareDescription(isPrepareMethod = true)
    @CaseLabel(lbType = { "dns" })
    public DataHolder createTargetGroupNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":80,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/\",\n" +
                "                \"Timeout\":2000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 2 rs same port of dns+vip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_tgroup col and value
        TableData lb_tgroup = new TableData();
        lb_tgroup.setTableName("lb_tgroup");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("useSamePort", Boolean.class.toString(), true, null, FlagConstant.BOOLEAN));
        col1.add(new DataUnit("name", String.class.toString(), "tg-test", null, FlagConstant.Y));
        lb_tgroup.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_tgroup);  //add lb_vip into db_check list

        //set lb_tgroup_monitor col and value
        TableData lb_tgroup_monitor = new TableData();
        lb_tgroup_monitor.setTableName("lb_tgroup_monitor");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("rise", Integer.class.toString(), 2, null, FlagConstant.INT));
        col2.add(new DataUnit("fall", Integer.class.toString(), 3, null, FlagConstant.INT));
        col2.add(new DataUnit("period", Integer.class.toString(), 5000, null, FlagConstant.INT));
        col2.add(new DataUnit("timeout", Integer.class.toString(), 2000, null, FlagConstant.INT));
        col2.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col2.add(new DataUnit("rstatus", String.class.toString(), "2xx,3xx", null, FlagConstant.Y));
        col2.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col2.add(new DataUnit("port", Integer.class.toString(), 0, null, FlagConstant.INT));
        lb_tgroup_monitor.addColumn(col2);  //add record into lb_vip
        db_check.add(lb_tgroup_monitor);  //add lb_vip into db_check list

        //set lb_tgroup_server col and value
        TableData lb_tgroup_server = new TableData();
        lb_tgroup_server.setTableName("lb_tgroup_server");
        List<DataUnit> col3 = new ArrayList<DataUnit>();
        List<DataUnit> col4 = new ArrayList<DataUnit>();
        col3.add(new DataUnit("name", String.class.toString(), rsName1, null, FlagConstant.Y));
        col3.add(new DataUnit("address", String.class.toString(), rsAddress1, null, FlagConstant.C));
        col3.add(new DataUnit("port", Integer.class.toString(), 8080, null, FlagConstant.C));
        col3.add(new DataUnit("weight", Integer.class.toString(), 100, null, FlagConstant.INT));
        col3.add(new DataUnit("topaz", String.class.toString(), "pubt2", null, FlagConstant.Y));

        col4.add(new DataUnit("name", String.class.toString(), rsName2, null, FlagConstant.Y));
        col4.add(new DataUnit("address", String.class.toString(), rsAddress2, null, FlagConstant.C));
        col4.add(new DataUnit("port", Integer.class.toString(), 8080, null, FlagConstant.C));
        col4.add(new DataUnit("weight", Integer.class.toString(), 80, null, FlagConstant.INT));
        col4.add(new DataUnit("topaz", String.class.toString(), "pubt2", null, FlagConstant.Y));
        lb_tgroup_server.addColumn(col3, "tgroup_server_1");  //add record into lb_vip
        lb_tgroup_server.addColumn(col4, "tgroup_server_2");  //add record into lb_vip
        db_check.add(lb_tgroup_server);  //add lb_vip into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建空目标组, dns+vip
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //get config
        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[], " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create null tg of dns+vip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);

        List<TableData> db_check = new ArrayList<TableData>();  //create expected db data for db check
        //set lb_tgroup col and value
        TableData lb_tgroup = new TableData();
        lb_tgroup.setTableName("lb_tgroup");
        List<DataUnit> col1 = new ArrayList<DataUnit>();
        col1.add(new DataUnit("useSamePort", Boolean.class.toString(), false, null, FlagConstant.BOOLEAN));
        col1.add(new DataUnit("name", String.class.toString(), "tg-test", null, FlagConstant.Y));
        lb_tgroup.addColumn(col1);  //add record into lb_vip
        db_check.add(lb_tgroup);  //add lb_vip into db_check list

        //set lb_tgroup_monitor col and value
        TableData lb_tgroup_monitor = new TableData();
        lb_tgroup_monitor.setTableName("lb_tgroup_monitor");
        List<DataUnit> col2 = new ArrayList<DataUnit>();
        col2.add(new DataUnit("rise", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("fall", Integer.class.toString(), 5, null, FlagConstant.INT));
        col2.add(new DataUnit("period", Integer.class.toString(), 5000, null, FlagConstant.INT));
        col2.add(new DataUnit("timeout", Integer.class.toString(), 5000, null, FlagConstant.INT));
        col2.add(new DataUnit("url", String.class.toString(), "/", null, FlagConstant.Y));
//        col2.add(new DataUnit("rstatus", String.class.toString(), "2xx,3xx", null, FlagConstant.Y));
        col2.add(new DataUnit("protocol", String.class.toString(), "tcp", null, FlagConstant.Y));
        col2.add(new DataUnit("port", Integer.class.toString(), 0, null, FlagConstant.INT));
        lb_tgroup_monitor.addColumn(col2);  //add record into lb_vip
        db_check.add(lb_tgroup_monitor);  //add lb_vip into db_check list

        //add db_check into data holder
        holder.setDbExpectData(db_check);
        return holder;
    }

    //创建目标组，带2个后端主机，端口不同, idc_vpc_mix
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":8081,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":80,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 2 rs diff port of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，带2个后端主机，端口相同, idc_vpc_mix
    @PrepareDescription(isPrepareMethod = true)
    @CaseLabel(lbType = { "idc_vpc_mix" })
    public DataHolder createTargetGroupNormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":80,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/\",\n" +
                "                \"Timeout\":2000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 2 rs same port of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
                "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建空目标组, idc_vpc_mix
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //get config
        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[], " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create null tg of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，带2个后端主机，端口不同, vpc_l4
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":8081,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":80,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 2 rs diff port of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，带2个后端主机，端口相同, vpc_l4
    @PrepareDescription(isPrepareMethod = true)
    @CaseLabel(lbType = { "vpc_l4" })
    public DataHolder createTargetGroupNormal016() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":1,\n" +
                "            \"Instances\":[\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer1 + "\",\n" +
                "                    \"Name\":\"" + rsName1 + "\",\n" +
                "                    \"Address\":\"" + rsAddress1 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":100,\n" +
                "                    \"Backup\":0\n" +
                "                },\n" +
                "                {\n" +
                "                    \"Id\":\"" + realServer2 + "\",\n" +
                "                    \"Name\":\"" + rsName2 + "\",\n" +
                "                    \"Address\":\"" + rsAddress2 + "\",\n" +
                "                    \"Port\":8080,\n" +
                "                    \"Status\":\"UNKNOWN\",\n" +
                "                    \"TopAz\":\"" + topAz + "\",\n" +
                "                    \"Weight\":80,\n" +
                "                    \"Backup\":0\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":2,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/\",\n" +
                "                \"Timeout\":2000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 2 rs same port of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建空目标组, vpc_l4
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupNormal017() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        //get config
        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[], " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\n" +
                "            \"Name\":\"tg-test\",\n" +
                "            \"UseSamePort\":0,\n" +
                "            \"Instances\":[],\n" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n" +
                "            }\n" +
                "        }";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create null tg of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
