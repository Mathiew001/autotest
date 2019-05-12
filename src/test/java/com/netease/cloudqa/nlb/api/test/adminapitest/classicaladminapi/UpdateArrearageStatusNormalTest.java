package com.netease.cloudqa.nlb.api.test.adminapitest.classicaladminapi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.TargetGroup;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UpdateArrearageStatusNormalTest extends ApiTestBase {
    @Test(dataProvider = "YamlDriverDataProvider", description = "UpdateArrearageStatus NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String prepareBody, final String resMsg, final String loadBalanceCaseId,
                        final Boolean isVpc) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray prepareBodyArray  = JSONObject.parseArray(prepareBody);
            JSONArray resMsgJson = JSONObject.parseArray(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                initListenerGroup(loadBalanceCaseId, isVpc);
                lb = resetClassicListener(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res;
                for (int i =  0; i < prepareBodyArray.size(); i++) {
                    JSONObject item = (JSONObject) prepareBodyArray.get(i);
                    item.put("InstanceId", lb.getInstanceId());
                    TargetGroup tg;
                    tg = lb.getTargetGroups().get(i);
                    JSONObject cluster = (JSONObject)item.getJSONArray("Clusters").get(0);
                    cluster.put("TargetGroupId", tg.getTargetGroupId());
                }
                for (int i = 0; i < prepareBodyArray.size(); i++) {
                    res = CommonApi.createLn(headers, prepareBodyArray.getJSONObject(i), httpClient);
                    assertEquals(res.getCode(), 200, "create lb listener status code != 200");
                    logger.info("Create lb listener successfully!");
                }
                resJson = JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
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
                res = CommonApi.updateArrearageStatus(headers, httpClient, resJson.getString("InstanceId"), "stop");
                assertEquals(res.getCode(), 200, "stop failed! code != 200");
                resJson = JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                assertEquals(lb.getStatus(), "STOPPED", "status != STOPPED");
                assertEquals(lb.getSubStatus(), "ARREARAGE_STOPPED", "substatus != ARREARAGE_STOPPED");
                Boolean isDeleted = CommonApi.waitCloudServerDeleting(headers, httpClient, lb.getInstanceId());
                assertTrue(isDeleted, "cloud server is deleted failed!");
                res = CommonApi.updateArrearageStatus(headers, httpClient, resJson.getString("InstanceId"), "restore");
                assertEquals(res.getCode(), 200, "restore failed! code != 200");
                resJson = JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                assertEquals(lb.getStatus(), "WORKING", "status != WORKING");
                assertEquals(lb.getSubStatus(), "WORKING", "substatus != WORKING");
                String status = CommonApi.waitCloudServerActive(headers, httpClient, lb.getInstanceId());
                assertEquals(status, "ACTIVE", "CloudServer is not online after restore!");

            }

            @Override
            public void afterTest() {
                resetClassicListener(loadBalanceCaseId);
            }
        });
    }
}
