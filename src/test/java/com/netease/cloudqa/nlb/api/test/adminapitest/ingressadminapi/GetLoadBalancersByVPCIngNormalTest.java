package com.netease.cloudqa.nlb.api.test.adminapitest.ingressadminapi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetLoadBalancersByVPCIngNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "GetLoadBalancersByVPC NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String tenantId2, final String vpcId, final String namespace){
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {
            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            Response res;
            JSONObject resJson = new JSONObject();
            JSONArray result = new JSONArray();
            Map<String, Integer> LBs = new HashMap<String, Integer>();
            String instanceId;
            LoadBalancer ingInstance;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId2);
            }

            @Override
            public void executeTest() {
                // API shoud get empty result array with mismatched vpcId and tenantId
                res = CommonApi.getLoadBalancersByVPC(headers, httpClient, vpcId);
                resJson = JSONObject.parseObject(res.getHtml());
                result = JSONArray.parseArray(resJson.getString("result"));
                assertEquals(result.size(), 0, "The result size should be true with mismatched tenantId and vpcId");
                // testing if getting empty result with mismatched vpcId and tenantId

                headers.put("X-Product-Id", tenantId);
                for(Map.Entry<String, LoadBalancer> entry : ingInstances.entrySet()) {
                    ingInstance = entry.getValue();
                    instanceId = ingInstance.getInstanceId();
                    logger.info("=================================================================");
                    logger.info("===  adding instance: " + instanceId);
                    logger.info("=================================================================");
                    LBs.put(instanceId, 0);
                    if (ingInstance.getType().equals("mix")){
                        LBs.put(instanceId, 1);
                    }
                }

                res = CommonApi.getLoadBalancersByVPC(headers, httpClient, vpcId);
                resJson = JSONObject.parseObject(res.getHtml());
                result = JSONArray.parseArray(resJson.getString("result"));
                logger.info("=================================================================");
                logger.info("===  Api response result part: " + resJson.getString("result"));
                logger.info("=================================================================");
                Iterator resultItr = result.iterator();
                String instanceId;

                // checking if result has any duplicated instance info or not while marking checked instance.
                while(resultItr.hasNext()){
                    JSONObject lb = (JSONObject) resultItr.next();
                    instanceId =  namespace + "@" + lb.getString("instanceName");
                    logger.info("=================================================================");
                    logger.info("===  checking instance: " + instanceId);
                    logger.info("=================================================================");
                    assertTrue(LBs.containsKey(instanceId), "getting unexpected instance");
                    assertTrue(LBs.get(instanceId).equals(0), "getting duplicated instances in result");
                    LBs.put(instanceId, 1);
                }
                // checking if it missed any instance under the VPC with given vpcId
                for(Map.Entry<String, Integer> entry : LBs.entrySet()) {
                    assertTrue(entry.getValue() == 1, "missed instance with instanceId: " + entry.getKey());
                }


            }

            @Override
            public void afterTest() {

            }
        });
    }
}
