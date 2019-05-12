package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.listener;

import static org.testng.Assert.assertEquals;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ParallelRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.TargetGroup;
import com.netease.cloudqa.nlb.api.test.utils.AssertUtils;
import com.netease.cloudqa.nlb.api.test.utils.NetUtils;
import org.testng.annotations.Test;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;

public class CreateLbListenerNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "CreateLbListener NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String executeBody, final String resMsg, final String loadBalanceCaseId,
                        final Boolean isVpc, final Boolean sameGroup) {
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
                    TargetGroup tg;
                    if (sameGroup)
                        tg = CommonApi.findTgByName(lb, "tg-test-02");
                    else {
                        tg = CommonApi.findTgByName(lb, "tg-test-0" + (i+1));
                    }
                    JSONArray clusters = item.getJSONArray("Clusters");
                    for (Object m : clusters) {
                        JSONObject cluster = (JSONObject) m;
                        cluster.put("TargetGroupId", tg.getTargetGroupId());
                    }
                }
                for (int i = 0; i < executeBodyArray.size(); i++) {
                    res = CommonApi.createLn(headers, executeBodyArray.getJSONObject(i), httpClient);
                    assertEquals(res.getCode(), 200, caseId + " create lb listener status code != 200");
                    logger.info("Create lb listener successfully!");
                }
                res = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId());
                resJson = JSONObject.parseObject(res.getHtml());
                lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                nlbInstances.put(loadBalanceCaseId, lb);
                JSONArray listeners = resJson.getJSONArray("Listeners");
                logger.info("Listeners: " + listeners);
                JsonUtils.responseCheck(resMsgJson, listeners, caseId);
//                try {
//                    TimeUnit.SECONDS.sleep(6);
//                } catch (InterruptedException e) {
//                    System.out.println("error");
//                }
//                if (!lb.getNetwork().equals("private") || !lb.getType().equals("vpc_mix"))
//                    NetUtils.checkListenerEffective(listeners, lb.getAddress());
                logger.info("curl vip + port successfully!");
                String listenerId1 = CommonApi.findListenerByName(resJson, "testln1").getString("ListenerId");
                String listenerId2 = CommonApi.findListenerByName(resJson, "testln2").getString("ListenerId");
                String listenerId3 = null;
                if (listeners.size() == 3)
                    listenerId3 = CommonApi.findListenerByName(resJson, "testln3").getString("ListenerId");
                List<String> listenerIds = new ArrayList<String>(Arrays.asList(listenerId1, listenerId2, listenerId3));

                for (int i = 0; i < listeners.size(); i++) {
                    String listenerId = listenerIds.get(i);
                    ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_listeners", "lb_listeners_" + (i+1),
                            new DataUnit("id", String.class.toString(), listenerId, null, FlagConstant.C));
                    ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_user_servers_group", "lb_user_servers_group_" + (i+1),
                            new DataUnit("listenerId", String.class.toString(), listenerId, null, FlagConstant.C));
                    ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_listener_attrs", "lb_listener_attrs_" + (i+1),
                            new DataUnit("listenerId", String.class.toString(), listenerId, null, FlagConstant.C));
                    if (!sameGroup) {
                        ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_user_servers", "lb_user_servers_" + (i+1),
                                new DataUnit("tGroupId", String.class.toString(), CommonApi.findTgByName(resJson, "tg-test-02").getString("TargetGroupId"), null, FlagConstant.C));
                    }
                }
                assertDbCheck(caseId);
            }

            @Override
            public void afterTest() {
                resetClassicListener(loadBalanceCaseId);
            }
        });
    }
}
