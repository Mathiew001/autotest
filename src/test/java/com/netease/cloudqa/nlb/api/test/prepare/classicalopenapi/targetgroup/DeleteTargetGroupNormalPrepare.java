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
 * @version $Id: DeleteTargetGroupNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class DeleteTargetGroupNormalPrepare extends BasePrepare {

    //删除目标组，带3个后端主机，端口相同, mix
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                        + rsName1 + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                        + "\"}, {\"Id\":\"" + realServer2 + "\", \"Name\":\"" + rsName2
                        + "\", \"Port\":8080, \"Address\":\"" + rsAddress2 + "\"}], \"UseSamePort\":1}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group with 3 instances of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，带2个后端主机，端口相同, vpc_mix
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");

        //set request body
        String body = "{\"Name\":\"tg-test\",\"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                        + rsName1 + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                        + "\"}, {\"Id\":\"" + realServer2 + "\", \"Name\":\"" + rsName2
                        + "\", \"Port\":8080, \"Address\":\"" + rsAddress2
                        + "\"}], \"UseSamePort\":1}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group with 2 instances of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，带2个后端主机，端口相同, vpc_mix
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");

        //set request body
        String body = "{\"Name\":\"tg-test\",\"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\"Name\":\"tg-test\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                        + rsName1 + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                        + "\"}, {\"Id\":\"" + realServer2 + "\", \"Name\":\"" + rsName2
                        + "\", \"Port\":8080, \"Address\":\"" + rsAddress2
                        + "\"}], \"UseSamePort\":1}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group with 2 instances of dns+vip", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
