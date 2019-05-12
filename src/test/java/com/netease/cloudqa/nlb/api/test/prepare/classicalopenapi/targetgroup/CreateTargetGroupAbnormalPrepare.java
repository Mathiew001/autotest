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
 * @version $Id: CreateTargetGroupAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class CreateTargetGroupAbnormalPrepare extends BasePrepare {

    //创建目标组，无instances参数
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        //set request body
        String body = "{\"Name\":\"tg-test\", \"InstanceId\":\"" + instanceId + "\"}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"miss tGroup parameter!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no instances param", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字长度>64
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String realServer3 = ConfigLoader.configration.getExtConfig("real_server3");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsName3 = ConfigLoader.configration.getExtConfig("rs_name3");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String rsAddress3 = ConfigLoader.configration.getExtConfig("rs_address3");
        //set request body
        String body = "{\"Name\":\"abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz1234567812345\", "
                      + "\"InstanceId\":\""
                      + instanceId
                      + "\", \"Instances\":[{\"Id\":\""
                      + realServer1
                      + "\", \"Name\":\""
                      + rsName1
                      + "\", \"Port\":8080, "
                      + "\"Address\": \""
                      + rsAddress1
                      + "\"}, {\"Id\":\""
                      + realServer2
                      + "\", \"Name\":\""
                      + rsName2
                      + "\", \"Port\":8081, \"Address\":\""
                      + rsAddress2
                      + "\"}, {\"Id\":\""
                      + realServer3
                      + "\", \"Name\":\""
                      + rsName3
                      + "\", \"Port\":8082, \"Address\":\""
                      + rsAddress3
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid target group name!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, name > 64", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        return holder;
    }

    //创建目标组，目标组名字不以字母开头
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String realServer3 = ConfigLoader.configration.getExtConfig("real_server3");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsName3 = ConfigLoader.configration.getExtConfig("rs_name3");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String rsAddress3 = ConfigLoader.configration.getExtConfig("rs_address3");
        //set request body
        String body = "{\"Name\":\"123abc\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer2 + "\", \"Name\":\"" + rsName2
                      + "\", \"Port\":8081, \"Address\":\"" + rsAddress2 + "\"}, {\"Id\":\""
                      + realServer3 + "\", \"Name\":\"" + rsName3
                      + "\", \"Port\":8082, \"Address\":\"" + rsAddress3
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid target group name!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, name not start with alphabet", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        holder.setDriverData(DataUnits);
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        return holder;
    }

    //创建目标组，目标组名字重复
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createTargetGroupAbnormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String realServer3 = ConfigLoader.configration.getExtConfig("real_server3");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsName3 = ConfigLoader.configration.getExtConfig("rs_name3");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String rsAddress3 = ConfigLoader.configration.getExtConfig("rs_address3");
        //set request body
        String body = "{\"Name\":\"tgnotdelete\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer2 + "\", \"Name\":\"" + rsName2
                      + "\", \"Port\":8081, \"Address\":\"" + rsAddress2 + "\"}, {\"Id\":\""
                      + realServer3 + "\", \"Name\":\"" + rsName3
                      + "\", \"Port\":8082, \"Address\":\"" + rsAddress3
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":409, \"Message\":\"目标组名字冲突!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组后端server+port重复
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"instance conflict!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, duplicated server+port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无id
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Name\":\"" + rsName1 + "\", \"Port\":8080, "
                      + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server id", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无name
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Port\":8080, "
                      + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无port
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无address
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，weight不合法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":101, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，weight不合法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":100, \"Port\":65536}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":100, \"Port\":-1}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组, 使用相同端口，但端口不同
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal014() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2");
        String realServer3 = ConfigLoader.configration.getExtConfig("real_server3");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2");
        String rsName3 = ConfigLoader.configration.getExtConfig("rs_name3");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2");
        String rsAddress3 = ConfigLoader.configration.getExtConfig("rs_address3");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"InstanceId\":\""
                      + instanceId
                      + "\", \"Instances\":[{\"Id\":\""
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
                      + rsAddress2 + "\"}, {\"Id\":\"" + realServer3 + "\", \"Name\":\"" + rsName3
                      + "\", \"Port\":8080, \"TopAz\":\"cn-east-1a\", "
                      + "\"Weight\":100, \"Address\":\"" + rsAddress3 + "\"}], \"UseSamePort\":1}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid samePort，instance port is not the same!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 3 rs same port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，usesameport不合法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal015() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":2}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid useSamePort!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal015", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal usesameport", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，无instances参数
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal016() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        //set request body
        String body = "{\"Name\":\"tg-test\", \"InstanceId\":\"" + instanceId + "\"}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"miss tGroup parameter!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal016", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no instances param", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->protocol illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal046() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal046", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rise illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal047() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal047", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->Rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rise illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal048() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal048", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->Rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->fall illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal049() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal049", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->fall illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal050() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal050", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->period illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal051() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal051", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->period illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal052() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal052", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->timeout illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal053() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal053", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->timeout illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal054() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal054", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rstatus illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal055() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal055", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rstatus illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal056() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal056", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->url illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal057() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"abcd\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal057", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->url illegal
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal058() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aa\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal058", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字长度>32
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal017() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\", \"InstanceId\":\""
                      + instanceId + "\", \"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                      + rsAddress1 + "\"}, {\"Id\":\"" + realServer2 + "\", \"Name\":\"" + rsName2
                      + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid target group name!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal017", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, name > 32", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字不以字母开头
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal018() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"123abc\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer2 + "\", \"Name\":\"" + rsName2
                      + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid target group name!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal018", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, name not start with alphabet", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字重复
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createTargetGroupAbnormal019() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"tgnotdelete\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer2 + "\", \"Name\":\"" + rsName2
                      + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":409, \"Message\":\"目标组名字冲突!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal019", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组后端server+port重复
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal020() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"instance conflict!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal020", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, duplicated server+port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无id
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal021() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Name\":\"" + rsName1 + "\", \"Port\":8080, "
                      + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal021", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, no server id", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无name
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal022() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Port\":8080, "
                      + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal022", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, no server name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无port
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal023() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal023", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, no server port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无address
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal024() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal024", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，weight不合法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal025() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":101, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal025", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，weight不合法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal026() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal026", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal027() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":0, \"Port\":65536}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal027", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal028() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":0, \"Port\":-1}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal028", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组, 使用相同端口，但端口不同
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal029() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"InstanceId\":\""
                      + instanceId
                      + "\", \"Instances\":[{\"Id\":\""
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal029",
            null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg with 3 rs same port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，usesameport不合法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal030() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":2}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid useSamePort!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal030", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, illegal usesameport", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->protocol illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal059() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal059", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rise illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal060() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal060", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->Rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rise illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal061() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal061", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->Rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->fall illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal062() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal062", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->fall illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal063() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal063", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->period illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal064() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal064", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->period illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal065() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal065", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->timeout illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal066() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal066", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->timeout illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal067() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal067", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rstatus illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal068() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal068", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rstatus illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal069() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal069", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->url illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal070() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"abcd\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal070", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->url illegal
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal071() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aa\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal071", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，无instances参数
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal031() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        //set request body
        String body = "{\"Name\":\"tg-test\", \"InstanceId\":\"" + instanceId + "\"}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"miss tGroup parameter!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal031", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, no instances param", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字长度>32
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal032() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\", \"InstanceId\":\""
                      + instanceId + "\", \"Instances\":[{\"Id\":\"" + realServer1
                      + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                      + rsAddress1 + "\"}, {\"Id\":\"" + realServer2 + "\", \"Name\":\"" + rsName2
                      + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid target group name!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal032", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, name > 32",
            null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字不以字母开头
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal033() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"123abc\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer2 + "\", \"Name\":\"" + rsName2
                      + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid target group name!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal033", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, name not start with alphabet", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字重复
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createTargetGroupAbnormal034() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"tgnotdelete\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer2 + "\", \"Name\":\"" + rsName2
                      + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":409, \"Message\":\"目标组名字冲突!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal034", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组后端server+port重复
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal035() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1 + "\"}, {\"Id\":\""
                      + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080, \"Address\":\"" + rsAddress1
                      + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"instance conflict!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal035", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, duplicated server+port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无id
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal036() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Name\":\"" + rsName1 + "\", \"Port\":8080, "
                      + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal036", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, no server id", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无name
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal037() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Port\":8080, "
                      + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal037", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, no server name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无port
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal038() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal038", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, no server port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无address
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal039() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\", \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal039", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, no server address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，weight不合法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal040() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":101, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal040", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，weight不合法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal041() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal041", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal042() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":0, \"Port\":65536}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal042", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal043() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":0, \"Port\":-1}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal043", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组, 使用相同端口，但端口不同
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal044() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"InstanceId\":\""
                      + instanceId
                      + "\", \"Instances\":[{\"Id\":\""
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal044",
            null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg with 3 rs same port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，usesameport不合法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal045() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                      + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                      + "\"," + "\"Address\": \"" + rsAddress1
                      + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":2}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid useSamePort!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(),
            "createTargetGroupAbnormal045", null));
        DataUnits.add(new DataUnit("description", String.class.toString(),
            "create tg, illegal usesameport", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration
            .getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
            "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->protocol illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal072() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal072", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rise illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal073() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal073", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->Rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rise illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal074() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal074", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->Rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->fall illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal075() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal075", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->fall illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal076() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal076", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->period illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal077() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal077", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->period illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal078() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal078", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->timeout illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal079() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal079", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->timeout illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal080() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal080", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rstatus illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal081() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal081", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rstatus illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal082() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal082", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->url illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal083() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"abcd\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal083", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->url illegal
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal084() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aa\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal084", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字长度>32
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal085() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\", \"InstanceId\":\""
                + instanceId + "\", \"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                + rsAddress1 + "\"}, {\"Id\":\"" + realServer2 + "\", \"Name\":\"" + rsName2
                + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid target group name!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal085", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, name > 32", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字不以字母开头
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal086() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"123abc\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                + realServer2 + "\", \"Name\":\"" + rsName2
                + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid target group name!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal086", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, name not start with alphabet", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字重复
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createTargetGroupAbnormal087() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"tgnotdelete\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                + realServer2 + "\", \"Name\":\"" + rsName2
                + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":409, \"Message\":\"目标组名字冲突!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal087", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组后端server+port重复
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal088() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, \"Address\":\"" + rsAddress1 + "\"}, {\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, \"Address\":\"" + rsAddress1
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"instance conflict!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal088", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, duplicated server+port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无id
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal089() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Name\":\"" + rsName1 + "\", \"Port\":8080, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal089", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server id", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无name
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal090() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Port\":8080, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal090", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无port
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal091() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal091", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无address
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal092() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal092", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，weight不合法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal093() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":101, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal093", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，weight不合法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal094() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal094", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal095() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":0, \"Port\":65536}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal095", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal096() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":0, \"Port\":-1}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal096", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组, 使用相同端口，但端口不同
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal111() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"InstanceId\":\""
                + instanceId
                + "\", \"Instances\":[{\"Id\":\""
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal111", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 3 rs same port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，usesameport不合法
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal097() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":2}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid useSamePort!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal097", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal usesameport", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->protocol illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal098() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal098", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rise illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal099() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal099", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->Rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rise illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal100() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal100", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->Rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->fall illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal101() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal101", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->fall illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal102() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal102", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->period illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal103() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal103", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->period illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal104() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal104", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->timeout illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal105() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal105", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->timeout illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal106() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal106", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rstatus illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal107() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal107", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rstatus illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal108() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal108", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->url illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal109() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"abcd\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal109", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->url illegal
    @CaseLabel(lbType = { "vpc_l4" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal110() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aa\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal110", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字长度>32
    @CaseLabel(lbType = { "id_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal112() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\", \"InstanceId\":\""
                + instanceId + "\", \"Instances\":[{\"Id\":\"" + realServer1
                + "\", \"Name\":\"" + rsName1 + "\", \"Port\":8080, " + "\"Address\": \""
                + rsAddress1 + "\"}, {\"Id\":\"" + realServer2 + "\", \"Name\":\"" + rsName2
                + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid target group name!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal112", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, name > 32", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字不以字母开头
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal113() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"123abc\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                + realServer2 + "\", \"Name\":\"" + rsName2
                + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid target group name!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal113", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, name not start with alphabet", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组名字重复
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder createTargetGroupAbnormal114() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"tgnotdelete\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                + realServer2 + "\", \"Name\":\"" + rsName2
                + "\", \"Port\":8081, \"Address\":\"" + rsAddress2
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":409, \"Message\":\"目标组名字冲突!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal114", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, duplicated name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，目标组后端server+port重复
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal115() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, " + "\"Address\": \"" + rsAddress1 + "\"}, {\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, \"Address\":\"" + rsAddress1 + "\"}, {\"Id\":\""
                + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080, \"Address\":\"" + rsAddress1
                + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"instance conflict!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal115", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, duplicated server+port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无id
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal116() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Name\":\"" + rsName1 + "\", \"Port\":8080, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal116", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server id", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无name
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal117() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Port\":8080, "
                + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal117", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server name", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无port
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal118() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1 + "\"}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal118", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，后端主机参数无address
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal119() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\", \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"The instance parameter is incorrect!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal119", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, no server address", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，weight不合法
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal120() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":101, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal120", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，weight不合法
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal121() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"weight range is 1-100!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal121", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal weight", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal122() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":0, \"Port\":65536}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal122", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，port不合法
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal123() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":0, \"Port\":-1}], \"UseSamePort\":0}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid instance port. range:1~65535!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal123", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组, 使用相同端口，但端口不同
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal124() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");

        //set request body
        String body = "{\"Name\":\"tg-test\", \"InstanceId\":\""
                + instanceId
                + "\", \"Instances\":[{\"Id\":\""
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupNormal124", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg with 3 rs same port", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，usesameport不合法
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal125() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":0, \"Port\":8080}], \"UseSamePort\":2}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid useSamePort!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal125", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal usesameport", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->protocol illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal126() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal126", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->protocol", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rise illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal127() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal127", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->Rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rise illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal128() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal128", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->Rise", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->fall illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal129() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal129", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->fall illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal130() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal130", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->fall", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->period illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal131() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_dns");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal131", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->period illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal132() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal132", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->period", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->timeout illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal133() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal133", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->timeout illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal134() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal134", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->timeout", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rstatus illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal135() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
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

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal135", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->rstatus illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal136() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/index.html\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx,abcd\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"invalid status code!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal136", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->rstatus", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->url illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal137() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"abcd\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal137", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //创建目标组，monitor-->url illegal
    @CaseLabel(lbType = { "idc_vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder createTargetGroupAbnormal138() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();

        // get config
        String instanceId = ConfigLoader.configration.getExtConfig("instance_id_vpc");
        String realServer1 = ConfigLoader.configration.getExtConfig("real_server1_vpc");
        String realServer2 = ConfigLoader.configration.getExtConfig("real_server2_vpc");
        String rsName1 = ConfigLoader.configration.getExtConfig("rs_name1_vpc");
        String rsName2 = ConfigLoader.configration.getExtConfig("rs_name2_vpc");
        String rsAddress1 = ConfigLoader.configration.getExtConfig("rs_address1_vpc");
        String rsAddress2 = ConfigLoader.configration.getExtConfig("rs_address2_vpc");
        //set request body
        String body = "{\"Name\":\"abcdtest\", \"InstanceId\":\"" + instanceId
                + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\"" + rsName1
                + "\"," + "\"Address\": \"" + rsAddress1
                + "\", \"Weight\":100, \"Port\":8080}], \"UseSamePort\":0, " +
                "            \"Monitor\":{\n" +
                "                \"Protocol\":\"http\",\n" +
                "                \"Rise\":5,\n" +
                "                \"Fall\":5,\n" +
                "                \"Url\":\"/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aafsd/aa\",\n" +
                "                \"Timeout\":6000,\n" +
                "                \"Period\":6000\n, " +
                "                \"Rstatus\":\"2xx\"\n" +
                "            }\n" +
                "}";
        //set response message
        String resMsg = "{\"Code\":\"BadRequest\", \"Message\":\"url is invalid!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "createTargetGroupAbnormal138", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "create tg, illegal monitor-->url", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
