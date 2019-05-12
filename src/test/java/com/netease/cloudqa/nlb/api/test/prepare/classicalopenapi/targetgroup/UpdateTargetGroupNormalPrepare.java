package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.targetgroup;

import java.util.ArrayList;
import java.util.List;
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
 * @version $Id: UpdateTargetGroupNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateTargetGroupNormalPrepare extends BasePrepare {

    //更新目标组, 2个-->1个, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal001() {
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
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
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

        String updateBody = "{\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1 + "\", "
                            + "\"Port\":12345, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                        + "\", \"Name\":\"" + rsName1 + "\", \"Port\":12345, " + "\"Address\": \""
                        + rsAddress1
                        + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal001",null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 3-->1 of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1个-->2个, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal002() {
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
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz +"\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        String updateBody = "{\"Instances\":[{\"Id\":\""
                            + realServer1
                            + "\", \"Name\":\""
                            + rsName1
                            + "\", "
                            + "\"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \""
                            + rsAddress1
                            + "\"}, {\"Id\":\""
                            + realServer2
                            + "\", \"Name\":\""
                            + rsName2
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                            + rsAddress2 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                        + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                        + rsAddress1 + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}, {\"Id\":\""
                        + realServer2 + "\", \"Name\":\"" + rsName2
                        + "\", \"Port\":8080, \"Address\":\"" + rsAddress2
                        + "\", \"Weight\":80, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->3 of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1-->0, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        //set request body
        String createBody = "{\"Name\":\"tg-test\",\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        String updateBody = "{\"Instances\":[], " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->0 of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 无instances mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal023() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        //set request body
        String createBody = "{\"Name\":\"tg-test\",\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        String updateBody = "{" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", " +
                "\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], " +
                "            \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal023", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update only monitor of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 0-->1, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String topAz = ConfigLoader.configration.getExtConfig("topaz_mix");

        //set request body
        String createBody = "{\"Name\":\"tg-test\",\"Instances\":[], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        String updateBody = "{\"Name\":\"tg-test\",\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                        + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                        + rsAddress1
                        + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 0-->1 of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 2个-->1个, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal005() {
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
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
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

        String updateBody = "{\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1 + "\", "
                            + "\"Port\":12345, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                        + "\", \"Name\":\"" + rsName1 + "\", \"Port\":12345, " + "\"Address\": \""
                        + rsAddress1
                        + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 3-->1 of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1个-->2个, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal006() {
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
        String createBody = "{\"Name\":\"tg-test\",\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        String updateBody = "{\"Instances\":[{\"Id\":\""
                            + realServer1
                            + "\", \"Name\":\""
                            + rsName1
                            + "\", "
                            + "\"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \""
                            + rsAddress1
                            + "\"}, {\"Id\":\""
                            + realServer2
                            + "\", \"Name\":\""
                            + rsName2
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                            + rsAddress2 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                        + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                        + rsAddress1 + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}, {\"Id\":\""
                        + realServer2 + "\", \"Name\":\"" + rsName2
                        + "\", \"Port\":8080, \"Address\":\"" + rsAddress2
                        + "\", \"Weight\":80, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->2 of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1-->0, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        String updateBody = "{\"Instances\":[], " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->0 of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 无instances, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal024() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        String updateBody = "{" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", " +
                "\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}]," +
                "            \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal024", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update only monitor of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 0-->1, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        String updateBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                        + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                        + rsAddress1
                        + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 0-->1 of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 2个-->1个, dns
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal009() {
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
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
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

        String updateBody = "{\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1 + "\", "
                            + "\"Port\":12345, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                        + "\", \"Name\":\"" + rsName1 + "\", \"Port\":12345, " + "\"Address\": \""
                        + rsAddress1
                        + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 3-->1 of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1个-->2个, dns
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal010() {
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
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        String updateBody = "{\"Instances\":[{\"Id\":\""
                            + realServer1
                            + "\", \"Name\":\""
                            + rsName1
                            + "\", "
                            + "\"Port\":8080, \"TopAz\":\"" +topAz + "\", \"Weight\":100, "
                            + "\"Address\": \""
                            + rsAddress1
                            + "\"}, {\"Id\":\""
                            + realServer2
                            + "\", \"Name\":\""
                            + rsName2
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                            + rsAddress2 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                        + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                        + rsAddress1 + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}, {\"Id\":\""
                        + realServer2 + "\", \"Name\":\"" + rsName2
                        + "\", \"Port\":8080, \"Address\":\"" + rsAddress2
                        + "\", \"Weight\":80, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->2 of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1-->0, dns
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        String updateBody = "{\"Instances\":[], " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->0 of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 无instances, dns
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal025() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        String updateBody = "{" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", " +
                "\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], " +
                "            \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal025", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update with monitor of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 0-->1, dns
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        String updateBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1
                            + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                            + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                        + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                        + rsAddress1
                        + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 0-->1 of dns", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 2个-->1个, idc_vpc_mix
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal013() {
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
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
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

        String updateBody = "{\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1 + "\", "
                + "\"Port\":12345, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\", \"Port\":12345, " + "\"Address\": \""
                + rsAddress1
                + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 3-->1 of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1个-->2个, idc_vpc_mix
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal014() {
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
        String createBody = "{\"Name\":\"tg-test\",\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        String updateBody = "{\"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", "
                + "\"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}, {\"Id\":\""
                + realServer2 + "\", \"Name\":\"" + rsName2
                + "\", \"Port\":8080, \"Address\":\"" + rsAddress2
                + "\", \"Weight\":80, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->2 of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1-->0, idc_vpc_mix
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        String updateBody = "{\"Instances\":[], " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->0 of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 无instances idc_vpc_mix
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal026() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        String updateBody = "{" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", " +
                "\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], " +
                "            \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal026", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update only monitor of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 0-->1, idc_vpc_mix
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal016() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        String updateBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                + rsAddress1
                + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 0-->1 of idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 2个-->1个, vpc_l4
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal017() {
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
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
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

        String updateBody = "{\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1 + "\", "
                + "\"Port\":12345, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\", \"Port\":12345, " + "\"Address\": \""
                + rsAddress1
                + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 3-->1 of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1个-->2个, vpc_l4
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal018() {
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
        String createBody = "{\"Name\":\"tg-test\",\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        String updateBody = "{\"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", "
                + "\"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}, {\"Id\":\""
                + realServer2 + "\", \"Name\":\"" + rsName2
                + "\", \"Port\":8080, \"Address\":\"" + rsAddress2
                + "\", \"Weight\":80, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->2 of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 1-->0, vpc_l4
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal019() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        String updateBody = "{\"Instances\":[], " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 1-->0 of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 无instances, vpc_l4
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal027() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");

        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        String updateBody = "{" +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", " +
                "\"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], " +
                "            \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal027", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update only monitor of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 0-->1, vpc_l4
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupNormal020() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String topAz = ConfigLoader.configration.getExtConfig("topaz");
        //set request body
        String createBody = "{\"Name\":\"tg-test\", \"Instances\":[], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"tcp\",\n" +
                "                \"Rise\":3,\n" +
                "                \"Fall\":3,\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n " +
                "            }\n" +
                "}";
        String updateBody = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8080, \"TopAz\":\"" + topAz + "\", \"Weight\":100, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                + rsAddress1
                + "\", \"Weight\": 100, \"TopAz\":\"" + topAz + "\"}], \"UseSamePort\":1, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":4,\n" +
                "                \"Fall\":4,\n" +
                "                \"Url\":\"/index1.html\",\n" +
                "                \"Timeout\":5000,\n" +
                "                \"Period\":5000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg 0-->1 of vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody, null));
        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
