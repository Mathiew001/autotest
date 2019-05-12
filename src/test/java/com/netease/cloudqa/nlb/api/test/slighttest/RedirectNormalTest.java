package com.netease.cloudqa.nlb.api.test.slighttest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.Listener;
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
import static org.testng.Assert.assertTrue;

public class RedirectNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "UrlFlow NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String targetGroup, final String listeners, final String update,
                        final String resMsg, final String vipId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray targetGroupArray  = JSONObject.parseArray(targetGroup);
            JSONArray listenersJsonArray = JSONObject.parseArray(listeners);
            JSONObject updateBody = JSONObject.parseObject(update);
            JSONArray resMsgJson = JSONObject.parseArray(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;
            Response res;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                Response res;
                res = CommonApi.getLbDetail(headers, httpClient, vipId);
                lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                for (Listener listener : lb.getListeners()) {
                    CommonApi.deleteLn(headers, httpClient, vipId, listener.getListenerId());
                }
                for (TargetGroup targetGroup : lb.getTargetGroups()) {
                    CommonApi.deleteTg(headers, httpClient, vipId, targetGroup.getTargetGroupId());
                }
            }

            @Override
            public void executeTest() {
                for (Object obj : targetGroupArray) {
                    JSONObject targetGroup = (JSONObject) obj;
                    targetGroup.put("InstanceId", vipId);
                    res = CommonApi.createTg(headers, targetGroup, httpClient);
                    assertEquals(res.getCode(), 200, "create tg failed!");
                }
                res = CommonApi.getLbDetail(headers, httpClient, vipId);
                lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                for (Object obj : listenersJsonArray) {
                    JSONObject listener = (JSONObject) obj;
                    listener.put("InstanceId", lb.getInstanceId());
                    JSONArray clusters = listener.getJSONArray("Clusters");
                    for (int i = 0; i < clusters.size(); i++) {
                        JSONObject cluster = clusters.getJSONObject(i);
                        TargetGroup tg = CommonApi.findTgByName(lb, "tg-test-0" + (i+1));
                        cluster.put("TargetGroupId", tg.getTargetGroupId());
                    }
                    res = CommonApi.createLn(headers, listener, httpClient);
                    assertEquals(res.getCode(), 200, "create lb listener status code != 200");
                    logger.info("Create lb listener successfully!");
                }
                res = CommonApi.getLbDetail(headers, httpClient, vipId);
                lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                JSONArray listeners = resJson.getJSONArray("Listeners");
                logger.info("Listeners: " + listeners);
                updateBody.put("InstanceId", lb.getInstanceId());
                JSONArray clusters = updateBody.getJSONArray("Clusters");
                for (int i = 0; i < clusters.size(); i++) {
                    JSONObject cluster = clusters.getJSONObject(i);
                    TargetGroup tg = CommonApi.findTgByName(lb, "tg-test-0" + (i+1));
                    cluster.put("TargetGroupId", tg.getTargetGroupId());
                }
                for (int i = 0; i < lb.getListeners().size(); i++) {
                    if (lb.getListeners().get(i).getName().equals("testln1")) {
                        updateBody.put("ListenerId", lb.getListeners().get(i).getListenerId());
                    }
                }
                res = CommonApi.updateLn(headers, updateBody, httpClient);
                assertEquals(res.getCode(), 200, "update lb listener status code != 200");
                res = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId());
                System.out.println(res.getHtml());
//                JsonUtils.responseCheck(resMsgJson, listeners);
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    System.out.println("error");
                }
                String serverIp1 = CommonApi.findTgByName(lb, "tg-test-01").getInstances().get(0).getAddress();
                String serverIp2 = CommonApi.findTgByName(lb, "tg-test-02").getInstances().get(0).getAddress();
                String serverIp3 = CommonApi.findTgByName(lb, "tg-test-03").getInstances().get(0).getAddress();
                NetUtils.checkRedictEffective("test1.com", "/a", "test2.com", "/b", serverIp2, "80");
                NetUtils.checkRedictEffective("test1.com", "/a?a=b\\&c=d", "test2.com", "/b?a=b&c=d", serverIp2, "80");
                NetUtils.checkRedictEffective("test2.com", "/", "test1.com", "/a", serverIp1, "80");
                NetUtils.checkRedictEffective(lb.getAddress(), "/", lb.getAddress(), "/", serverIp3, "81");
//                if (lb.getListeners().get(0).getClusters().get(0).getPolicy().getMode().equals("insert")) {
//                    long sessionStickyTime = NetUtils.checkSessionStickyInsert(lb);
//                    logger.info("expire time: " + sessionStickyTime + "ms(actual) " + lb.getListeners().
//                            get(0).getClusters().get(0).getPolicy().getExpire() + "s(expire)");
//                }
//                else if (lb.getListeners().get(0).getClusters().get(0).getPolicy().getMode().equals("rewrite")) {
//                    assertTrue(NetUtils.checkSessionStickyRewrite(lb));
//                }
//                logger.info("check session sticky successfully!");
            }

            @Override
            public void afterTest() {

            }
        });
    }
}
