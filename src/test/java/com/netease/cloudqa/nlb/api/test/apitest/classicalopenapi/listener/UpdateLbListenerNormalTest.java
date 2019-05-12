package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.listener;

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
import org.apache.log4j.NDC;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class UpdateLbListenerNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="UpdateLbListener NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String executeBody, final String resMsg, final String loadBalanceCaseId,
                        final Boolean isVpc) {
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
                initListenerGroup(loadBalanceCaseId, isVpc);
                lb = resetClassicListener(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res;
                for (int i =  0; i < executeBodyArray.size(); i++) {
                    JSONObject item = (JSONObject) executeBodyArray.get(i);
                    item.put("InstanceId", lb.getInstanceId());
                    TargetGroup tg = CommonApi.findTgByName(lb, "tg-test-02");
                    JSONObject cluster = (JSONObject)item.getJSONArray("Clusters").get(0);
                    cluster.put("TargetGroupId", tg.getTargetGroupId());
                }
                res = CommonApi.createLn(headers, executeBodyArray.getJSONObject(0), httpClient);
                assertEquals(res.getCode(), 200, caseId + " create lb listener status code != 200");
                logger.info("Create lb listener successfully!");
                res = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId());
                lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                nlbInstances.put(loadBalanceCaseId, lb);
                executeBodyArray.getJSONObject(1).put("ListenerId", lb.getListeners().get(0).getListenerId());
                res = CommonApi.updateLn(headers, executeBodyArray.getJSONObject(1), httpClient);
                assertEquals(res.getCode(), 200, "Update lb listener status code != 200");
                logger.info("Update lb listener successfully!");
                res = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId());
                resJson = JSONObject.parseObject(res.getHtml());
                lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                nlbInstances.put(loadBalanceCaseId, lb);
                JSONArray listeners = resJson.getJSONArray("Listeners");
                logger.info("Listeners: " + listeners);
                JsonUtils.responseCheck(resMsgJson, listeners, caseId);
            }

            @Override
            public void afterTest() {
                resetClassicListener(loadBalanceCaseId);
            }
        });
    }
}
