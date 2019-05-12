package com.netease.cloudqa.nlb.api.test.slighttest;

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
import com.netease.cloudqa.nlb.api.test.utils.NetUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class MultiAzNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "MultiAz NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String targetGroup, final String listener, final String urlCheckList,
                        final String resMsg, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray targetGroupArray  = JSONObject.parseArray(targetGroup);
            JSONObject listenerBody = JSONObject.parseObject(listener);
            JSONArray urlCheckListArray = JSONObject.parseArray(urlCheckList);
            JSONArray resMsgJson = JSONObject.parseArray(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                resetClassicGroups(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res;
                for (Object obj : targetGroupArray) {
                    JSONObject targetGroup = (JSONObject) obj;
                    targetGroup.put("InstanceId", lb.getInstanceId());
                    res = CommonApi.createTg(headers, targetGroup, httpClient);
                    assertEquals(res.getCode(), 200, caseId + " create tg failed!");
                }
                resJson = JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                listenerBody.put("InstanceId", lb.getInstanceId());
                JSONArray clusters = listenerBody.getJSONArray("Clusters");
                for (int i = 0; i < clusters.size(); i++) {
                    JSONObject cluster = clusters.getJSONObject(i);
                    TargetGroup tg = CommonApi.findTgByName(lb, "tg-test-0" + (i+1));
                    cluster.put("TargetGroupId", tg.getTargetGroupId());
                }
                res = CommonApi.createLn(headers, listenerBody, httpClient);
                assertEquals(res.getCode(), 200, caseId + " create lb listener status code != 200");
                logger.info("Create lb listener successfully!");
                resJson = JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                JSONArray listeners = resJson.getJSONArray("Listeners");
                logger.info("Listeners: " + listeners);
                JsonUtils.responseCheck(resMsgJson, listeners, caseId);
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    System.out.println("error");
                }
                NetUtils.checkUrlFlow(urlCheckListArray, lb.getAddress());
                logger.info("curl vip:port/path -H 'host: hostname' success!");
            }

            @Override
            public void afterTest() {
                resetClassicListener(loadBalanceCaseId);
            }
        });
    }
}
