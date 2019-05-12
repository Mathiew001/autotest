/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.individual;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;

/**
 * 
 * @author hzzhangyan
 * @version $Id: MuchLbPrepare.java, v 0.1 2018-9-3 上午11:27:11 hzzhangyan Exp $
 */
public class MuchLbPrepare extends ApiTestBase {

    private static Set<String> lbNames = new HashSet<String>();

    static {
        lbNames.add("lshl-lb-vpc");
        lbNames.add("qa_important_notdelete");
        lbNames.add("qaTestNotDelete");
        lbNames.add("notDelete");
        lbNames.add("old-nlb-l4");
    }

    /**
     * 构造20个监听,每个监听128个后端,共计2560个后端
     * @throws InterruptedException 
     */
    @Test
    public void create_500_lb() throws InterruptedException {

        String vpcId = "d9541266-de4d-4eb0-9fe3-8af4708b10b0";
        String topAz = "cn-east-1b";
        String subNetId = "d8fde15a-3316-470f-8047-f9e0f47932ca";
        String sg1 = "8a8a1f41-8ec0-494b-804e-63065c8c2313";
        String sg2 = "8b9b776b-3cce-456c-9558-7f91c5ee1cfb";
        String size = "nlb.s1.micro";

        for (int i = 671; i <= 720; i++) {
            String body = "{\n" + "    \"SecurityGroups\":[\n" + "        \"" + sg1 + "\",\n"
                          + "        \"" + sg2 + "\"\n" + "    ],\n" + "    \"Type\":\"vpc_l4\",\n"
                          + "    \"TopAzInfos\":[\n" + "        {\n"
                          + "            \"SubNetId\":\"" + subNetId + "\",\n"
                          + "            \"TopAz\":\"" + topAz + "\"\n" + "        }\n"
                          + "    ],\n" + "    \"Description\":\"abcd\",\n" + "    \"VpcId\":\""
                          + vpcId + "\",\n" + "    \"Network\":\"public\",\n"
                          + "    \"Standard\":{\n" + "        \"ChargeMode\":\"netflow\",\n"
                          + "        \"ChargeType\":\"hour\",\n" + "        \"Size\":\"" + size
                          + "\",\n" + "        \"BandwidthLimit\":1\n" + "    },\n"
                          + "    \"Name\":\"" + "test-vpc-ip-fake-" + i + "\"\n" + "}";
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("X-Product-Id", "34493fd33b874583ac7b24c1f60138fd");
            Response res = CommonApi.createLb(headers, JSONObject.parseObject(body), httpClient);
            System.out.println("------" + res.getHtml());

            Thread.currentThread().sleep(1000);
        }

    }

    /**
     * 查询指定租户Lb
     */
    @Test
    public void get_500_lbs() {
        StringBuffer strBf = new StringBuffer().append("{");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Product-Id", "34493fd33b874583ac7b24c1f60138fd");
        Response res = CommonApi.getLbs(headers, httpClient, "vpc_l4", "100", "0");
        System.out.println(res.getHtml().toString());

        if (200 == res.getCode()) {
            JSONArray arr = JSONArray.parseArray(res.getHtml());
            for (Object js : arr) {
                String name = ((JSONObject) js).getString("Name");
                String instanceId = ((JSONObject) js).getString("Name");
                if (StringUtils.contains(name, "test-vpc-ip-fake"))
                    strBf.append("\"").append(instanceId).append("\",");
            }
        } else {
            throw new RuntimeException("error ...");
        }
        strBf.append("}");
        System.out.println(strBf);
    }

    /**
     * 查询所有lb
     */
    @Test
    public void get_all_lbs() {
        StringBuffer strBf = new StringBuffer().append("{");
        Map<String, String> headers = new HashMap<String, String>();
        Response res = CommonApi.getLbsAdmin(headers, httpClient, "", "200", "540");
        System.out.println("-----" + res.getHtml());
        JSONArray arr = JSONArray.parseArray(((JSONObject) JSONObject.parse(res.getHtml())).get(
            "Lists").toString());
        for (Object js : arr) {
            String netWork = ((JSONObject) js).getString("Network");
            String name = ((JSONObject) js).getString("Name");
            String instanceId = ((JSONObject) js).getString("Id");
            String vpcId = ((JSONObject) js).getString("VpcId");
            String address = ((JSONObject) js).getString("Address");
            String tenantId = ((JSONObject) js).getString("TenantId");
            if (StringUtils.contains(netWork, "public")) {
                //                if (!(lbNames.contains(name) || name.contains("test-vpc-ip"))) {
                if (name.contains("test-vpc-ip-fake")
                    && vpcId.equals("d9541266-de4d-4eb0-9fe3-8af4708b10b0")) {
                    System.out.println("|" + instanceId + "  |  " + name + "  |  " + address
                                       + "  |  ");
                    strBf.append("\"").append(instanceId).append("\",");
                }
            }
        }
        strBf.append("}");
        System.out.println(strBf);
    }

    /**
     * 查询所有lb并过滤ing
     */
    @Test
    public void get_all_lbs_filter_ingress() {
        StringBuffer strBf = new StringBuffer().append("{");
        Map<String, String> headers = new HashMap<String, String>();
        Response res = CommonApi.getLbsAdmin(headers, httpClient, "", "200", "0");
        JSONArray arr = JSONArray.parseArray(((JSONObject) JSONObject.parse(res.getHtml())).get(
            "Lists").toString());
        Set<String> tntIds = new HashSet<String>();
        for (Object js : arr) {
            String tag = ((JSONObject) js).getString("Tag");
            if (StringUtils.equals(tag, "ingress")) {
                tntIds.add(((JSONObject) js).getString("TenantId"));
            }
        }

        for (String tntId : tntIds) {
            headers.put("X-Product-Id", tntId);
            res = CommonApi.getLbsIng(headers, httpClient, "200", "0");
            System.out.println("--------" + res.getHtml());
            if (res.getCode() == 200) {
                JSONArray arr1 = JSONArray.parseArray(res.getHtml());

                for (Object js : arr1) {
                    String instanceId = ((JSONObject) js).getString("InstanceId");
                    strBf.append("\"").append(instanceId).append("\",");
                }
            } else {
                throw new RuntimeException("");
            }
        }
        strBf.append("}");
        System.out.println(strBf);
    }

    @Test
    public void lb_address_ip_prepare() {
        for (int i = 1; i < 250; i++) {
            System.out
                .println("INSERT INTO `pubenv_nlb`.`lb_address` (`id`, `address`, `groupId`, `status`, `createtime`, `updatetime`, `tenantId`, `type`, `sessionId`, `sessionCreatetime`) VALUES ('9997"
                         + i
                         + "', '60.191.91."
                         + i
                         + "', '4', 'FREE', '0', '1536029014650', 'any', 'vpc_public', NULL, NULL);");
        }

    }
}
