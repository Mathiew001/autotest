/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.individual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * @version $Id: JnutsDataPrepare.java, v 0.1 2018-9-11 下午7:25:25 hzzhangyan Exp $
 */
public class JnutsDataPrepare extends ApiTestBase {

    @Test
    public void getTenantBackends() {
        List<String> lst = new ArrayList<String>();
        Map<String, String> headers = new HashMap<String, String>();
        Response res = CommonApi.getLbsAdmin(headers, httpClient, "", "200", "0");
        System.out.println("-----" + res.getHtml());
        JSONArray arr = JSONArray.parseArray(((JSONObject) JSONObject.parse(res.getHtml())).get(
            "Lists").toString());
        for (Object js : arr) {
            StringBuffer sf = new StringBuffer();
            String netWork = ((JSONObject) js).getString("Network");
            String name = ((JSONObject) js).getString("Name");
            String instanceId = ((JSONObject) js).getString("Id");
            String vpcId = ((JSONObject) js).getString("VpcId");
            String address = ((JSONObject) js).getString("Address");
            sf.append(address);
            if (StringUtils.contains(netWork, "public")) {
                //                if (!(lbNames.contains(name) || name.contains("test-vpc-ip"))) {
                if (name.contains("test-vpc-ip-fake")) {
                    Response res1 = CommonApi.getLbDetailAdmin(headers, httpClient, instanceId);
                    JSONArray arr1 = JSONArray.parseArray(((JSONObject) JSONObject.parse(res1
                        .getHtml())).get("Listeners").toString());
                    for (Object js1 : arr1) {
                        sf.append(",").append(((JSONObject) js1).getString("Sport"));
                    }
                    lst.add(sf.toString());
                }
            }
        }
        for (String str : lst) {
            System.out.println(str);
        }
    }

}
