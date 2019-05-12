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
 * @version $Id: UpdateTargetGroupAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateTargetGroupAbnormalPrepare extends BasePrepare {

    //更新目标组, instanceId不存在
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal001() {
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
        String body = "{\"InstanceId\":\"" + "abcd" + "\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", "
                      + "\"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\": \" Load balancer does not exist.!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg with illegal instanceId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, targetGroupId不存在
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal002() {
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
        String body = "{\"TargetGroupId\":\""
                      + 123
                      + "\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", "
                      + "\"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\": \"Target group does not exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg with illegal targetGroupId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, instances不存在
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        //set request body
        String body = "{\"Instances\":[{}]}";
        //set response message
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg with empty instances", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, server+port冲突
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                      + rsAddress1 + "\"}, {\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"instance conflict!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, duplicated server+port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, server id为空
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server id", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, name为空
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, port为空
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, no server port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无address
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，weight不合法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":101, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，weight不合法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":-1, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":100, \"Port\":65536}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，port不合法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":100, \"Port\":-1}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 使用相同端口，但端口不同
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal013() {
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
        String body = "{\"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8082, \"TopAz\":\"cn-east-1a\", \"Weight\":100, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid samePort，instance port is not the same!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg with 3 rs same port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，usesameport不合法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal014() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                      + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":2}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid useSamePort!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal014", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal usesameport", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->protocol非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal043() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"abcd\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"unsupported protocol!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal043", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rise非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal044() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":1,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal044", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rise非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal045() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":11,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal045", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->fall非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal046() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":1,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal046", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->fall非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal047() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":11,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal047", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->period非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal048() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":300001\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid period!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal048", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->period非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal049() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":4999\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid period!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal049", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->timeout非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal050() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":1999,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid timeout!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal050", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->timeout非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal051() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":60001,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid timeout!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal051", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rstatus非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal052() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal052", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rstatus非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal053() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx, abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal053", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->url非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal054() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"abcd\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal054", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor为空
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal080() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"Health check parameter format is incorrect.!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal080", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->url非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal055() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aa\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal055", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), false, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, instanceId不存在
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal015() {
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
        String body = "{\"InstanceId\":\""
                      + "abcd"
                      + "\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", "
                      + "\"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\": \" Load balancer does not exist.!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg with illegal instanceId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, targetGroupId不存在
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal016() {
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
        String body = "{\"TargetGroupId\":\""
                      + 123
                      + "\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", "
                      + "\"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\": \"Target group does not exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg with illegal targetGroupId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, instances不存在
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal017() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "{\"Instances\":[{}]}";
        //set response message
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg with empty instances", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, server+port冲突
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal018() {
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
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                      + rsAddress1 + "\"}, {\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"instance conflict!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, duplicated server+port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, server id为空
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal019() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server id", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, name为空
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal020() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, port为空
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal021() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal021", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无address
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal022() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal022", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，weight不合法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal023() {
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
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":101, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal023", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，weight不合法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal024() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":-1, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal024", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal025() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":100, \"Port\":65536}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal025", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，port不合法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal026() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":100, \"Port\":-1}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal026", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 使用相同端口，但端口不同
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal027() {
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
        String body = "{\"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8082, \"TopAz\":\"cn-east-1a\", \"Weight\":100, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid samePort，instance port is not the same!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal027",
            null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg with 3 rs same port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，usesameport不合法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal028() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                      + rsAddress1 + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":2}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid useSamePort!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal028", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal usesameport", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rise非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal056() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":1,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal056", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rise非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal057() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":11,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal057", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->fall非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal058() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":1,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal058", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->fall非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal059() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":11,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal059", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->period非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal060() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":300001\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid period!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal060", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->period非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal061() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":4999\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid period!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal061", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->timeout非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal062() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":1999,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid timeout!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal062", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->timeout非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal063() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":60001,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid timeout!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal063", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rstatus非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal064() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal064", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rstatus非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal065() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx, abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal065", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->url非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal066() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"abcd\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal066", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->url非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal067() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aa\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal067", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor为空
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal081() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"Health check parameter format is incorrect.!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal081", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


    //更新目标组, instanceId不存在
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal029() {
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
        String body = "{\"InstanceId\":\""
                      + "abcd"
                      + "\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", "
                      + "\"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\": \" Load balancer does not exist.!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal029", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg with illegal instanceId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, targetGroupId不存在
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal030() {
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
        String body = "{\"TargetGroupId\":\""
                      + 123
                      + "\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", "
                      + "\"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":80, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\": \"Target group does not exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal030", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg with illegal targetGroupId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, instances不存在
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal031() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "{\"Instances\":[{}]}";
        //set response message
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal031", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg with empty instances", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, server+port冲突
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal032() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                      + rsAddress1 + "\"}, {\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"instance conflict!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal032", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, duplicated server+port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, server id为空
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal033() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal033", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server id", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, name为空
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal034() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal034", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, port为空
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal035() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal035", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无address
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal036() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal036", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, no server address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，weight不合法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal037() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":101, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal037", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，weight不合法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal038() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":-1, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal038", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal039() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":100, \"Port\":65536}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal039", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，port不合法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal040() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":100, \"Port\":-1}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal040", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 使用相同端口，但端口不同
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal041() {
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
        String body = "{\"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8082, \"TopAz\":\"cn-east-1a\", \"Weight\":100, \"Address\":\""
                      + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid samePort，instance port is not the same!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal041",
            null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg with 3 rs same port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，usesameport不合法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal042() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                      + rsAddress1 + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":2}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid useSamePort!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "updateTargetGroupAbnormal042", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "update tg, illegal usesameport", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(),
                true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rise非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal068() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":1,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal068", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rise非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal069() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":11,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal069", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->fall非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal070() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":1,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal070", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->fall非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal071() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":11,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal071", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->period非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal072() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":300001\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid period!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal072", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->period非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal073() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":4999\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid period!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal073", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->timeout非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal074() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":1999,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid timeout!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal074", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->timeout非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal075() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":60001,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid timeout!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal075", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rstatus非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal076() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal076", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rstatus非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal077() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx, abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal077", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->url非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal078() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"abcd\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal078", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->url非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal079() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aa\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal079", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor为空
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal082() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"Health check parameter format is incorrect.!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal082", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, targetGroupId不存在
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal083() {
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
        String body = "{\"TargetGroupId\":\""
                + 123
                + "\", \"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", "
                + "\"Port\":8080, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":80, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\": \"Target group does not exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal083", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg with illegal targetGroupId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, instances不存在
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal084() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set request body
        String body = "{\"Instances\":[{}]}";
        //set response message
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\": \"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal084", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg with empty instances", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, server+port冲突
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal085() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                + rsAddress1 + "\"}, {\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, \"Address\":\"" + rsAddress1 + "\"}, {\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, \"Address\":\"" + rsAddress1
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"instance conflict!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal085", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, duplicated server+port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, server id为空
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal086() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Name\":\"" + rsName1
                + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal086", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, no server id", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, name为空
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal087() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal087", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, no server name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, port为空
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal088() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal088", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, no server port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无address
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal089() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal089", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, no server address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，weight不合法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal090() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":101, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal090", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，weight不合法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal091() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":-1, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal091", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal092() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":65536}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal092", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，port不合法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal093() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":-1}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal093", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组, 使用相同端口，但端口不同
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal094() {
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
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1
                + "\", \"Name\":\""
                + rsName1
                + "\", \"Port\":8081, \"TopAz\":\"cn-east-1a\", \"Weight\":100, "
                + "\"Address\": \""
                + rsAddress1
                + "\"}, {\"Id\":\""
                + realServer2
                + "\", \"Name\":\""
                + rsName2
                + "\", \"Port\":8082, \"TopAz\":\"cn-east-1a\", \"Weight\":100, \"Address\":\""
                + rsAddress2 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid samePort，instance port is not the same!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupNormal094", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg with 3 rs same port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，usesameport不合法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal095() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":2}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid useSamePort!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal095", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal usesameport", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rise非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal096() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":1,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal096", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rise非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal097() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":11,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal097", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->fall非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal098() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":1,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal098", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->fall非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal099() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":11,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid rise or fall!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal099", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->period非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal100() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":300001\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid period!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal100", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->period非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal101() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":4999\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid period!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal101", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->timeout非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal102() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":1999,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid timeout!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal102", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->timeout非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal103() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":60001,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid timeout!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal103", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rstatus非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal104() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal104", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->rstatus非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal105() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx, abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal105", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->url非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal106() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"abcd\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal106", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor-->url非法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal107() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aa\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,3xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal107", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //更新目标组，monitor为空
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateTargetGroupAbnormal108() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Instances\":[{\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1 + "\"," + "\"Address\": \""
                + rsAddress1 + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":1," +
                "            \"Monitor\":{\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"Health check parameter format is incorrect.!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateTargetGroupAbnormal108", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update tg, illegal monitor empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        DataUnits.add(new DataUnit("isVpc", Boolean.class.toString(), true, null));
        holder.setDriverData(DataUnits);
        return holder;
    }


}
