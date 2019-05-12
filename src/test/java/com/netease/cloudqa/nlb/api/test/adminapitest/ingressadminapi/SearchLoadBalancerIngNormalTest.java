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

public class SearchLoadBalancerIngNormalTest extends ApiTestBase{
    @Test(dataProvider = "YamlDriverDataProvider", description = "SearchLoadBalancer NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId, final String namespace,
                        final String mix_name, final String vpc_mix_name,
                        final String mix_body, final String vpc_mix_body,
                        final String mix_resMsg, final String vpc_mix_resMsg) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray resJson = new JSONArray();
            String prefix_key = "qa-test-temp";
            String instanceId;
            Response res;
            boolean included;
            Iterator resultItr;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
            }

            @Override
            public void executeTest() {
                //only works if no one else has instances with name prefix "qa-temp"
                res = CommonApi.searchLoadBalancer(headers, httpClient, prefix_key);
//                logger.info("====================searchLoadBalancer response html string====================");
//                logger.info(res.getHtml());
//                logger.info("====================searchLoadBalancer response html string====================";
                resJson = JSONArray.parseArray(res.getHtml());
                logger.info("====================searchLoadBalancer actual LB size====================");
                logger.info("actual size: " + resJson.size() + " expected size: 6");
                logger.info("====================searchLoadBalancer actual LB size====================");
                assertTrue(resJson.size() == 6, "Getting unexpected result size !");


                res = CommonApi.searchLoadBalancer(headers, httpClient, tenantId);
                resJson = JSONArray.parseArray(res.getHtml());
                logger.info("====================searchLoadBalancer actual LB size====================");
                logger.info("actual size: " + resJson.size() + " expected size: 6");
                logger.info("====================searchLoadBalancer actual LB size====================");
                assertTrue(resJson.size() == 6, "Getting unexpected result size when searching for " +
                        "case specific instance");

                JSONObject createResJson;
                HttpClientUtils httpClient = new HttpClientUtils();
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Namespace", namespace);
                headers.put("X-Product-Id", tenantId);
                JSONObject bodyJson;
                String lbDetail, status, address;
                LoadBalancer lb;
                JSONObject resMsgJson;

                // adding one mix instance
                bodyJson = (JSONObject) JSONObject.parse(mix_body);
                res = CommonApi.createLbIng(headers, bodyJson, httpClient);
                if (res.getCode() != 200) {
                    assertEquals(res.getCode(), 200, "create ing status code != 200" + res.getHtml());
                }
                createResJson = JSONObject.parseObject(res.getHtml());
                lbDetail = CommonApi.waitEndingAndGetIngInfo(headers, httpClient, createResJson.getString("InstanceId"));
                status = JSONObject.parseObject(lbDetail).getString("Status");
                assertEquals(status, "WORKING", "create mix lb failed @ SearchLoadBalancerIngNormal001!" + resJson);
                resMsgJson = JSONObject.parseObject(mix_resMsg);
                JsonUtils.responseCheck(resMsgJson, createResJson, caseId);
                lb = JsonUtils.fromObjectIgnoreCase(lbDetail);
                ingInstances.put(caseId, lb);
                address = JSONObject.parseObject(lbDetail).getString("Address");
                logger.info("=================================================================");
                logger.info("===            " + "new Ingress instance" + mix_name + " added");
                logger.info("=================================================================");

                res = CommonApi.searchLoadBalancer(headers, httpClient,mix_name);
                resJson = JSONArray.parseArray(res.getHtml());
                logger.info("====================searchLoadBalancer actual LB size====================");
                logger.info("actual size: " + resJson.size() + " expected size: 1");
                logger.info("====================searchLoadBalancer actual LB size====================");
                assertTrue(resJson.size() == 1, "Getting unexpected result size when searching for " +
                        "case specific instance");
                //only works if no one else has instances with name prefix "qa-temp"
                res = CommonApi.searchLoadBalancer(headers, httpClient,prefix_key);
                resJson = JSONArray.parseArray(res.getHtml());
                logger.info("====================searchLoadBalancer actual LB size====================");
                logger.info("actual size: " + resJson.size() + " expected size: 7");
                logger.info("====================searchLoadBalancer actual LB size====================");
                assertTrue(resJson.size() == 7, "Getting unexpected result size when searching for " +
                        "case specific instance");

                res = CommonApi.searchLoadBalancer(headers, httpClient, tenantId);
                resJson = JSONArray.parseArray(res.getHtml());
                logger.info("====================searchLoadBalancer actual LB size====================");
                logger.info("actual size: " + resJson.size() + " expected size: 7");
                logger.info("====================searchLoadBalancer actual LB size====================");
                assertTrue(resJson.size() == 7, "Getting unexpected result size when searching for " +
                        "case specific instance");


                res = CommonApi.searchLoadBalancer(headers, httpClient, address);
                resJson = JSONArray.parseArray(res.getHtml());
                logger.info("====================searchLoadBalancer by address response html string====================");
                logger.info(res.getHtml());
                logger.info("====================searchLoadBalancer by address response html string====================");

                resultItr = resJson.iterator();

                included = false;
                // to avoid ip collision between different tenant checking if result has any duplicated instance info or not while marking checked instance.
                while(resultItr.hasNext()){
                    JSONObject instance = (JSONObject) resultItr.next();
                    instanceId = instance.getString("InstanceId");
                    logger.info("=================================================================");
                    logger.info("===  got instance: " + instanceId);
                    logger.info("=================================================================");
                    if(instanceId.equals(lb.getInstanceId())){
                        included = true;
                        break;
                    }
                }

                assertTrue(included, "Target instance is not included in the response result");

                // adding one vpc-mix instance
                bodyJson = (JSONObject) JSONObject.parse(vpc_mix_body);
                res = CommonApi.createLbIng(headers, bodyJson, httpClient);
                if (res.getCode() != 200) {
                    assertEquals(res.getCode(), 200, "create ing status code != 200" + res.getHtml());
                }
                createResJson = JSONObject.parseObject(res.getHtml());
                lbDetail = CommonApi.waitEndingAndGetIngInfo(headers, httpClient, createResJson.getString("InstanceId"));
                status = JSONObject.parseObject(lbDetail).getString("Status");
                assertEquals(status, "WORKING", "create vpc mix lb failed @ SearchLoadBalancerIngNormal001!" + resJson);
                resMsgJson = JSONObject.parseObject(vpc_mix_resMsg);
                JsonUtils.responseCheck(resMsgJson, createResJson, caseId);
                lb = JsonUtils.fromObjectIgnoreCase(lbDetail);
                address = JSONObject.parseObject(lbDetail).getString("Address");
                logger.info("=================================================================");
                logger.info("===            " + "new Ingress instance" + vpc_mix_name + " added");
                logger.info("=================================================================");

                res = CommonApi.searchLoadBalancer(headers, httpClient,vpc_mix_name);
                resJson = JSONArray.parseArray(res.getHtml());
                logger.info("====================searchLoadBalancer actual LB size====================");
                logger.info("actual size: " + resJson.size() + " expected size: 1");
                logger.info("====================searchLoadBalancer actual LB size====================");
                assertTrue(resJson.size() == 1, "Getting unexpected result size when searching for " +
                        "case specific instance");

                //only works if no one else has instances with name prefix "qa-temp"
                res = CommonApi.searchLoadBalancer(headers, httpClient,prefix_key);
                resJson = JSONArray.parseArray(res.getHtml());
                logger.info("====================searchLoadBalancer actual LB size====================");
                logger.info("actual size: " + resJson.size() + " expected size: 8");
                logger.info("====================searchLoadBalancer actual LB size====================");
                assertTrue(resJson.size() == 8, "Getting unexpected result size when searching for " +
                        "case specific instance");


                res = CommonApi.searchLoadBalancer(headers, httpClient, tenantId);
                resJson = JSONArray.parseArray(res.getHtml());
                logger.info("====================searchLoadBalancer actual LB size====================");
                logger.info("actual size: " + resJson.size() + " expected size: 8");
                logger.info("====================searchLoadBalancer actual LB size====================");
                assertTrue(resJson.size() == 8, "Getting unexpected result size when searching for " +
                        "case specific instance");


                res = CommonApi.searchLoadBalancer(headers, httpClient, address);
                resJson = JSONArray.parseArray(res.getHtml());
//                logger.info("====================searchLoadBalancer actual LB size====================");
//                logger.info("actual size: " + resJson.size() + " expected size: 1");
//                logger.info("====================searchLoadBalancer actual LB size====================");
                if(resJson.size() != 1){
                    resultItr = resJson.iterator();
                    included = false;
                    // checking if result has any duplicated instance info or not while marking checked instance.
                    while(resultItr.hasNext()){
                        JSONObject instance = (JSONObject) resultItr.next();
                        instanceId =  namespace + "@" + instance.getString("Name");
                        logger.info("=================================================================");
                        logger.info("===  got instance: " + instanceId);
                        logger.info("=================================================================");
                        if(instanceId.equals(lb.getInstanceId())){
                            included = true;
                            break;
                        }
                    }
                    assertTrue(included, "Target instance is not included in the response result");
                }

                res = CommonApi.searchLoadBalancer(headers, httpClient,"searchlbingnormal");
                resJson = JSONArray.parseArray(res.getHtml());
                logger.info("====================searchLoadBalancer actual LB size====================");
                logger.info("actual size: " + resJson.size() + " expected size: 0");
                logger.info("====================searchLoadBalancer actual LB size====================");
                assertTrue(resJson.size() == 0, "Getting unexpected result size when searching for " +
                        "case specific instance");


                String instanceId = lb.getInstanceId();
                CommonApi.deleteLbIngAdmin(headers, httpClient, instanceId);
                status = CommonApi.waitLbDeleteIng(headers, httpClient, instanceId);
                if (StringUtils.equals(status, "DELETED")) {
                    logger.info("[" + caseId + "," + instanceId + "]清理结束...");
                }

            }

            @Override
            public void afterTest() {
            }
        });

    }
}
