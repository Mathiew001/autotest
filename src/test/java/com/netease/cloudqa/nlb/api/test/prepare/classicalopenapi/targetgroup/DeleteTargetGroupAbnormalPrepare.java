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
 * @version $Id: DeleteTargetGroupAbnormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class DeleteTargetGroupAbnormalPrepare extends BasePrepare {

    //删除目标组，instanceId非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"InstanceId\":\"abcd\", \"targetGroupId\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\":\" Load balancer does not exist.!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, illegal instanceId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，targetGroupId非法
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"targetGroupId\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\":\"Target group does not exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, illegal targetGroupId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，targetGroupId为空
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"targetGroupId\":\"\"}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\":\"Target group does not exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, targetGroupId empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，instanceId为空
    @CaseLabel(lbType = { "mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"InstanceId\":\"\", \"targetGroupId\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\":\"vipId not specified!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, illegal instanceId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，instanceId非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"InstanceId\":\"abcd\", \"targetGroupId\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\":\" Load balancer does not exist.!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, illegal instanceId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，targetGroupId非法
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"targetGroupId\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\":\"Target group does not exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, illegal targetGroupId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
                "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，targetGroupId为空
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"targetGroupId\":\"\"}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\":\"Target group does not exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, targetGroupId empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(),
                "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，instanceId为空
    @CaseLabel(lbType = { "vpc_mix" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"InstanceId\":\"\", \"targetGroupId\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\":\"vipId not specified!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, illegal instanceId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，instanceId非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"InstanceId\":\"abcd\", \"targetGroupId\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\":\" Load balancer does not exist.!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, illegal instanceId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，targetGroupId非法
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"targetGroupId\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\":\"Target group does not exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, illegal targetGroupId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，targetGroupId为空
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"targetGroupId\":\"\"}";
        //set response message
        String resMsg = "{\"Code\": \"NotFound\", \"Message\":\"Target group does not exist!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, targetGroupId empty", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //删除目标组，instanceId为空
    @CaseLabel(lbType = { "dns" })
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder deleteTargetGroupNormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String body = "{\"InstanceId\":\"\", \"targetGroupId\":\"abcd\"}";
        //set response message
        String resMsg = "{\"Code\": \"BadRequest\", \"Message\":\"vipId not specified!\"}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "deleteTargetGroupNormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "delete target group, illegal instanceId", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer007", null));
        holder.setDriverData(DataUnits);
        return holder;
    }
}
