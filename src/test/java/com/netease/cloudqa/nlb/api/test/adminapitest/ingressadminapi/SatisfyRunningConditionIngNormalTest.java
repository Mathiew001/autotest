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
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SatisfyRunningConditionIngNormalTest extends ApiTestBase {
    @Test(dataProvider = "YamlDriverDataProvider", description = "SatisfyRunningCondition NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String prepareBody, final String resMsg, final String loadBalanceCaseId,
                        final Boolean isVpc, final String namespace) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray prepareBodyArray = JSONObject.parseArray(prepareBody);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                headers.put("Namespace", namespace);
                lb = getIngLoadBalanceByCaseId(loadBalanceCaseId);
                resetIngressListener(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res;
                for (int i = 0; i < prepareBodyArray.size(); i++) {
                    JSONObject item = (JSONObject) prepareBodyArray.get(i);
                    item.put("InstanceId", lb.getInstanceId());
                }
                for (int i = 0; i < prepareBodyArray.size(); i++) {
                    res = CommonApi.createLnIng(headers, prepareBodyArray.getJSONObject(i), httpClient);
                    assertEquals(res.getCode(), 204, "create ing listener status code != 204");
                    logger.info("Create ing listener successfully!");
                }
                resJson = JsonUtils.refreshIng(headers, httpClient, lb, loadBalanceCaseId);
                JSONArray listeners = resJson.getJSONArray("Listeners");
                logger.info("Listeners: " + listeners);
//                JsonUtils.responseCheck(resMsgJson, listeners);
//                try {
//                    TimeUnit.SECONDS.sleep(6);
//                } catch (InterruptedException e) {
//                    System.out.println("error");
//                }
//                NetUtils.checkListenerEffective(listeners, lb.getAddress());
//                logger.info("curl vip + port successfully!");
                res = CommonApi.notSatisfyRunningConditionIng(headers, httpClient, tenantId, resJson.getString("InstanceId"));
                assertEquals(res.getCode(), 200, "stop failed! code != 200");
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    System.out.println("error");
                }
                resJson = JsonUtils.refreshIng(headers, httpClient, lb, loadBalanceCaseId);
                lb = getIngLoadBalanceByCaseId(loadBalanceCaseId);
                assertEquals(lb.getStatus(), "STOPPED", "status != STOPPED");
                assertEquals(lb.getSubStatus(), "ARREARAGE_STOPPED", "substatus != ARREARAGE_STOPPED");
                Boolean isDeleted = CommonApi.waitCloudServerDeleting(headers, httpClient, resJson.getString("Id"));
                assertTrue(isDeleted, "cloud server is deleted failed! ");
                res = CommonApi.satisfyRunningConditionIng(headers, httpClient, tenantId, resJson.getString("InstanceId"));
                assertEquals(res.getCode(), 200, "restore failed! code != 200");
                resJson = JsonUtils.refreshIng(headers, httpClient, lb, loadBalanceCaseId);
                lb = getIngLoadBalanceByCaseId(loadBalanceCaseId);
                assertEquals(lb.getStatus(), "WORKING", "status != WORKING");
                assertEquals(lb.getSubStatus(), "WORKING", "substatus != WORKING");
                String status = CommonApi.waitCloudServerActive(headers, httpClient, resJson.getString("Id"));
                assertEquals(status, "ACTIVE", "CloudServer is not active after restore!");

            }

            @Override
            public void afterTest() {
                resetIngressListener(loadBalanceCaseId);
            }
        });
    }
}
