package com.netease.cloudqa.nlb.api.test.prepare.classicalopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl.DataHolderImpl;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author chentianyu1
 * @version $Id: UpdateLoadBalancerSpecIngNormalPrepare.java, v 0.1 Apr 27, 2018 1:13:56 PM chentianyu1 Exp $
 */
public class UpdateLoadBalancerSpecNormalPrepare extends BasePrepare {

    //netflow mix实例更改带宽
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal001() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String body = "{\"Standard\":{\"BandwidthLimit\":4}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":4, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal001", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of netflow mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer001", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidth mix实例更改带宽
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal002() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        String body = "{\"Standard\":{\"BandwidthLimit\":2}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal002", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of bandwidth mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer002", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //netflow vpc_mix实例更改带宽
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal003() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String body = "{\"Standard\":{\"BandwidthLimit\":2}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal003", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of netflow vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer004", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidth vpc_mix实例更改带宽
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal004() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        // get config
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        String body = "{\"Standard\":{\"BandwidthLimit\":2}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal004", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of bandwidth vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer005", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix转包年包月
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal005() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String updateBody = "{\"Standard\":{\"BandwidthLimit\":2, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\", \"Period\":1}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal005", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "turn to package month of mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer002", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix转包年包月
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal006() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":2, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\", \"Period\":1}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\":\"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal006", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "turn to package month of vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer005", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix包年包月升配
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal007() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":2, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\"}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal007", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update of package month mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix包年包月升配
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal008() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        String updateBody = "{\"Standard\":{\"BandwidthLimit\":2, \"ChargeMode\":\"bandwidth\", \"ChargeType\":\"month\"}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal008", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update of package month vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix包年包月autoRenew
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal009() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":1}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":1, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal009", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "autoRenew of package month mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix包年包月autoRenew
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder updateLoadBalancerSpecNormal010() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":2}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":2, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal010", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "autorenew of package month vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //mix包年包月autoRenew=0
    @CaseLabel(lbType = {"mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal011() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        //set instance name
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":0}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal011", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "autoRenew of package month mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer003", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //vpc_mix包年包月autoRenew=0
    @CaseLabel(lbType = {"vpc_mix"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder updateLoadBalancerSpecNormal012() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");

        String updateBody = "{\"Standard\":{\"AutoRenewPeriod\":0}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal012", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update of package month vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), updateBody, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer006", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //netflow idc_vpc_mix实例更改带宽
    @CaseLabel(lbType = {"idc_vpc_mix"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal013() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_small");
        String body = "{\"Standard\":{\"BandwidthLimit\":2, \"Size\":\"" + size + "\"}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal013", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of netflow idc_vpc_mix", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer021", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //netflow vpc_l4实例更改带宽
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = true)
    public DataHolder updateLoadBalancerSpecNormal022() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
        String body = "{\"Standard\":{\"BandwidthLimit\":2}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal022", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of netflow vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer022", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

    //bandwidth vpc_l4实例更改带宽
    @CaseLabel(lbType = {"vpc_l4"})
    @PrepareDescription(isPrepareMethod = false)
    public DataHolder updateLoadBalancerSpecNormal023() {
        DataHolder holder = new DataHolderImpl();
        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
        // get config
        String size = ConfigLoader.configration.getExtConfig("size_s1_small");

        String body = "{\"Standard\":{\"BandwidthLimit\":2}}";
        //set response message
        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";

        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal023", null));
        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of bandwidth vpc_l4", null));
        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
        DataUnits.add(new DataUnit("body", String.class.toString(), body, null));
        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "False", null));
        DataUnits.add(new DataUnit("orderBody", String.class.toString(), null, null));
        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
        DataUnits.add(new DataUnit("loadBalanceCaseId", String.class.toString(), "createLoadBalancer018", null));
        holder.setDriverData(DataUnits);
        return holder;
    }

//    //带订单netflow mix实例更改带宽
//    @CaseLabel(lbType = {"vpc_mix"})
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal009() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//
//        //set request body
//        JSONObject createBody = JsonUtils.makeLbBody(name, "test cty", "public", "mix",
//                "netflow", "hour", 1);
//        String updateBody = "{\n" +
//                "    \"Standard\": {\n" +
//                "      \"BandwidthLimit\": 5,\n" +
//                "      \"ChargeMode\": \"netflow\",\n" +
//                "      \"ChargeType\": \"hour\"\n" +
//                "    }\n" +
//                "}";
//        String orderBody = "{\n" +
//                "    \"Service\":\"NLB\",\n" +
//                "    \"RegionId\":\"cn-east-1\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"FLOW\",\n" +
//                "            \"bandwidth\": 5\n" +
//                "    },\n" +
//                "    \"PayType\":\"PostPaid\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":5, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal009", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of netflow mix with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody.toJSONString(), null));
//        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //有订单bandwidth mix实例更改带宽
//    @CaseLabel(lbType = {"mix"})
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal010() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//
//        //set request body
//        JSONObject createBody = JsonUtils.makeLbBody(name, "test cty", "public", "mix",
//                "bandwidth", "hour", 1);
//        String updateBody = "{\n" +
//                "    \"Standard\": {\n" +
//                "      \"BandwidthLimit\": 5,\n" +
//                "      \"ChargeMode\": \"bandwidth\",\n" +
//                "      \"ChargeType\": \"hour\"\n" +
//                "    }\n" +
//                "}";
//        String orderBody = "{\n" +
//                "    \"Service\":\"NLB\",\n" +
//                "    \"RegionId\":\"cn-east-1\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 5\n" +
//                "    },\n" +
//                "    \"PayType\":\"PostPaid\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":5, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal010", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of bandwidth mix with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody.toJSONString(), null));
//        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //有订单netflow vpc_mix实例更改带宽
//    @CaseLabel(lbType = {"vpc_mix"})
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal011() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        ArrayList<String> securityGroups = new ArrayList<String>();
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        JSONObject createBody = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "netflow",
//                "hour", 1, vpcId, topAz, subNetId, securityGroups);
//        String updateBody = "{\n" +
//                "    \"Standard\": {\n" +
//                "      \"BandwidthLimit\": 5,\n" +
//                "      \"ChargeMode\": \"netflow\",\n" +
//                "      \"ChargeType\": \"hour\"\n" +
//                "    }\n" +
//                "}";
//        String orderBody = "{\n" +
//                "    \"Service\":\"NLB\",\n" +
//                "    \"RegionId\":\"cn-east-1\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"FLOW\",\n" +
//                "            \"bandwidth\": 5\n" +
//                "    },\n" +
//                "    \"PayType\":\"PostPaid\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"netflow\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":5, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal011", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of netflow vpc_mix with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody.toJSONString(), null));
//        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //有订单bandwidth vpc_mix实例更改带宽
//    @CaseLabel(lbType = {"vpc_mix"})
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal012() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        // get config
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        ArrayList<String> securityGroups = new ArrayList<String>();
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        JSONObject createBody = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "bandwidth",
//                "hour", 1, vpcId, topAz, subNetId, securityGroups);
//        String updateBody = "{\n" +
//                "    \"Standard\": {\n" +
//                "      \"BandwidthLimit\": 5,\n" +
//                "      \"ChargeMode\": \"bandwidth\",\n" +
//                "      \"ChargeType\": \"hour\"\n" +
//                "    }\n" +
//                "}";
//        String orderBody = "{\n" +
//                "    \"Service\":\"NLB\",\n" +
//                "    \"RegionId\":\"cn-east-1\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 5\n" +
//                "    },\n" +
//                "    \"PayType\":\"PostPaid\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"AMOUNT\", "
//                + "\"BandwidthLimit\":5, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal012", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "update standard of bandwidth vpc_mix with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody.toJSONString(), null));
//        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //有订单mix转包年包月
//    @CaseLabel(lbType = {"mix"})
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal013() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//
//        //set request body
//        JSONObject createBody = JsonUtils.makeLbBody(name, "test cty", "public", "mix",
//                "bandwidth", "hour", 1);
//        String updateBody = "{\n" +
//                "    \"Standard\": {\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\",\n" +
//                "      \"Period\": 1,\n" +
//                "      \"ChargeType\": \"month\"\n" +
//                "    }\n" +
//                "}";
//        String orderBody = "{\n" +
//                "    \"Service\":\"NLB\",\n" +
//                "    \"RegionId\":\"cn-east-1\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 1\n" +
//                "    },\n" +
//                "    \"PayType\":\"PrePay\",\n" +
//                "    \"Period\":1,\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
//                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal013", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "change to package month of mix with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody.toJSONString(), null));
//        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //有订单vpc_mix转包年包月
//    @CaseLabel(lbType = {"vpc_mix"})
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal014() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        ArrayList<String> securityGroups = new ArrayList<String>();
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        JSONObject createBody = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "bandwidth",
//                "hour", 1, vpcId, topAz, subNetId, securityGroups);
//        String updateBody = "{\n" +
//                "    \"Standard\": {\n" +
//                "      \"BandwidthLimit\": 1,\n" +
//                "      \"ChargeMode\": \"bandwidth\",\n" +
//                "      \"Period\": 1,\n" +
//                "      \"ChargeType\": \"month\"\n" +
//                "    }\n" +
//                "}";
//        String orderBody = "{\n" +
//                "    \"Service\":\"NLB\",\n" +
//                "    \"RegionId\":\"cn-east-1\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 1\n" +
//                "    },\n" +
//                "    \"PayType\":\"PrePay\",\n" +
//                "    \"Period\":1,\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
//                + "\"BandwidthLimit\":1, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal014", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "change to package month of vpc_mix with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody.toJSONString(), null));
//        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //带订单mix包年包月升配
//    @CaseLabel(lbType = {"mix"})
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal015() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//
//        //set request body
//        JSONObject createBody = JsonUtils.makeLbBody(name, "test cty", "public", "mix",
//                "bandwidth", "month", 1, 1,0);
//        String updateBody = "{\n" +
//                "    \"Standard\": {\n" +
//                "      \"BandwidthLimit\": 2,\n" +
//                "      \"ChargeMode\": \"bandwidth\",\n" +
//                "      \"ChargeType\": \"month\"\n" +
//                "    }\n" +
//                "}";
//        String orderBody = "{\n" +
//                "    \"Service\":\"NLB\",\n" +
//                "    \"RegionId\":\"cn-east-1\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 2\n" +
//                "    },\n" +
//                "    \"PayType\":\"PostPaid\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
//                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal015", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "update of package month mix with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody.toJSONString(), null));
//        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
//
//    //vpc_mix包年包月升配
//    @CaseLabel(lbType = {"vpc_mix"})
//    @PrepareDescription(isPrepareMethod = true)
//    public DataHolder updateLoadBalancerSpecNormal016() {
//        DataHolder holder = new DataHolderImpl();
//        List<DataUnit> DataUnits = new ArrayList<DataUnit>();
//        String vpcId = ConfigLoader.configration.getExtConfig("vpc_id");
//        String topAz = ConfigLoader.configration.getExtConfig("topaz");
//        String subNetId = ConfigLoader.configration.getExtConfig("subnet_id");
//        ArrayList<String> securityGroups = new ArrayList<String>();
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group1"));
//        securityGroups.add(ConfigLoader.configration.getExtConfig("security_group2"));
//        String size = ConfigLoader.configration.getExtConfig("size_s1_micro");
//
//        //set instance name
//        String name = "qa-temp-" + String.valueOf(new Date().getTime());
//        //set request body
//        JSONObject createBody = JsonUtils.makeLbBody(name, "test cty", "public", "vpc_mix", "bandwidth",
//                "month", 1, 1, 0, vpcId, topAz, subNetId, securityGroups);
//        String updateBody = "{\n" +
//                "    \"Standard\": {\n" +
//                "      \"BandwidthLimit\": 2,\n" +
//                "      \"ChargeMode\": \"bandwidth\",\n" +
//                "      \"ChargeType\": \"month\"\n" +
//                "    }\n" +
//                "}";
//        String orderBody = "{\n" +
//                "    \"Service\":\"NLB\",\n" +
//                "    \"RegionId\":\"cn-east-1\",\n" +
//                "    \"NewStandard\":{\n" +
//                "            \"netType\": \"BANDWIDTH\",\n" +
//                "            \"bandwidth\": 2\n" +
//                "    },\n" +
//                "    \"PayType\":\"PostPaid\",\n" +
//                "    \"Body\": [\"test, test\"]\n" +
//                "}";
//        //set response message
//        String resMsg = "{\"Standard\":{\"ChargeMode\":\"bandwidth\", \"ChargeType\":\"RESERVED\", "
//                + "\"BandwidthLimit\":2, \"AutoRenewPeriod\":0, \"Size\": \"" + size + "\"}}";
//
//        DataUnits.add(new DataUnit("caseId", String.class.toString(), "updateLoadBalancerSpecNormal016", null));
//        DataUnits.add(new DataUnit("description", String.class.toString(), "update of package month vpc_mix with order", null));
//        DataUnits.add(new DataUnit("tenantId", String.class.toString(), ConfigLoader.configration.getExtConfig("tenant_id"), null));
//        DataUnits.add(new DataUnit("createBody", String.class.toString(), createBody.toJSONString(), null));
//        DataUnits.add(new DataUnit("updateBody", String.class.toString(), updateBody, null));
//        DataUnits.add(new DataUnit("hasOrderId", String.class.toString(), "True", null));
//        DataUnits.add(new DataUnit("orderBody", String.class.toString(), orderBody, null));
//        DataUnits.add(new DataUnit("resMsg", String.class.toString(), resMsg, null));
//        holder.setDriverData(DataUnits);
//        return holder;
//    }
}
