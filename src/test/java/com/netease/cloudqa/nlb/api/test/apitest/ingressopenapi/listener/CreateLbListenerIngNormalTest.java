package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.listener;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.NlbModel;
import com.netease.cloudqa.nlb.api.test.model.TargetGroup;
import com.netease.cloudqa.nlb.api.test.utils.CleanMethodInvokerUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import com.netease.cloudqa.nlb.api.test.utils.PrepareMethodInvokerUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CreateLbListenerIngNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="CreateLbListener NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String executeBody, final String resMsg, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray executeBodyArray  = JSONObject.parseArray(executeBody);
            JSONArray resMsgJson = JSONObject.parseArray(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                lb = getIngLoadBalanceByCaseId(loadBalanceCaseId);
                resetIngressListener(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res;
                for (int i =  0; i < executeBodyArray.size(); i++) {
                    JSONObject item = (JSONObject) executeBodyArray.get(i);
                    item.put("InstanceId", lb.getInstanceId());
                }
                for (int i = 0; i < executeBodyArray.size(); i++) {
                    res = CommonApi.createLnIng(headers, executeBodyArray.getJSONObject(i), httpClient);
                    assertEquals(res.getCode(), 204, "create ing listener status code != 204");
                    logger.info("Create ing listener successfully!");
                }
                res = CommonApi.getLbDetailIng(headers, httpClient, lb.getInstanceId());
//                Response res1 = CommonApi.getLbDetailAdmin(headers, httpClient, lb.getId());
//                System.out.println(res1.getHtml());
                resJson = JSONObject.parseObject(res.getHtml());
                lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                ingInstances.put(loadBalanceCaseId, lb);
                JSONArray listeners = resJson.getJSONArray("Listeners");
                logger.info("Listeners: " + listeners);;
                JsonUtils.responseCheck(resMsgJson, listeners, caseId);
            }

            @Override
            public void afterTest() {
                resetIngressListener(loadBalanceCaseId);
            }
        });
    }
}
