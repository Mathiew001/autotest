package com.netease.cloudqa.nlb.api.test.slighttest;

import com.alibaba.fastjson.JSON;
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
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KsslNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "Kssl NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String createLnBody, final String updateLnBody, final String updateLbBody,
                        final String resMsg, final String loadBalanceCaseId, final Boolean isVpc,
                        final String certId, final String certId2) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray executeBodyArray  = JSONObject.parseArray(createLnBody);
            JSONObject updateBodyJson  = JSONObject.parseObject(updateLnBody);
            JSONObject updateLbBodyJson  = JSONObject.parseObject(updateLbBody);
            JSONArray resMsgJson = JSONObject.parseArray(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;
            List<String> idList = new ArrayList<String>();
            Set<String> keyId = new HashSet<String>();

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
                    TargetGroup tg = CommonApi.findTgByName(lb, "tg-test-0" + (i+1));
                    JSONObject cluster = (JSONObject)item.getJSONArray("Clusters").get(0);
                    cluster.put("TargetGroupId", tg.getTargetGroupId());
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
                res = CommonApi.getKeys(headers, httpClient);
                assertEquals(res.getCode(), 200, caseId + " get kssl keys failed!");
                JSONArray keyList = JSONObject.parseObject(res.getHtml()).getJSONArray("result");
                for (int i = 0; i < lb.getListeners().size(); i++) {
                    JSONObject listener = CommonApi.findListenerByName(resJson, "testln" + (i+1));
                    String keyName = lb.getInstanceId() + "." + listener.getString("ListenerId") + "." + certId;
                    Boolean found = false;
                    for (int j = 0; j < keyList.size(); j++) {
                        JSONObject key = keyList.getJSONObject(j);
                        if (key.getString("name").equals(keyName)) {
                            found = true;
                            idList.add(key.getString("id"));
                            break;
                        }
                    }
                    assertTrue(found, caseId + " cannot find key in kssl_key list!");
                }
                logger.info("kssl key name is correct!");
                for (int i = 0; i < idList.size(); i++) {
                    res = CommonApi.getKey(headers, httpClient, idList.get(i));
                    JSONObject result = JSONObject.parseObject(res.getHtml()).getJSONObject("result");
                    keyId.add(result.getString("keyId"));
                }
                assertTrue(keyId.size() == 1, caseId + " check key id only failed!" );
                logger.info("key id is only!");

                JSONObject listener = CommonApi.findListenerByName(resJson, "testln1");
                updateBodyJson.put("InstanceId", lb.getInstanceId());
                updateBodyJson.put("ListenerId", listener.getString("ListenerId"));
                updateBodyJson.getJSONArray("Clusters").getJSONObject(0).put("TargetGroupId", executeBodyArray.getJSONObject(0).getJSONArray("Clusters")
                        .getJSONObject(0).getString("TargetGroupId"));
                res = CommonApi.updateLn(headers, updateBodyJson, httpClient);
                assertEquals(res.getCode(), 200, caseId + " update listener failed!");
                logger.info("change cert for testln1 successfully!");
                res = CommonApi.getKeys(headers, httpClient);
                assertEquals(res.getCode(), 200, "get kssl keys failed!");
                keyList = JSONObject.parseObject(res.getHtml()).getJSONArray("result");
                String keyName = lb.getInstanceId() + "." + listener.getString("ListenerId") + "." + certId2;
                Boolean found = false;
                for (int j = 0; j < keyList.size(); j++) {
                    JSONObject key = keyList.getJSONObject(j);
                    if (key.getString("name").equals(keyName)) {
                        found = true;
                        idList.add(key.getString("id"));
                        break;
                    }
                }
                assertTrue(found, caseId + " cannot find new instanceId.listenerId.certId!");
                for (int i = 0; i < idList.size(); i++) {
                    res = CommonApi.getKey(headers, httpClient, idList.get(i));
                    if (res.getCode() == 404)
                        logger.info("old record is deleted!");
                    else {
                        JSONObject result = JSONObject.parseObject(res.getHtml()).getJSONObject("result");
                        keyId.add(result.getString("keyId"));
                    }
                }
                assertTrue(keyId.size() == 2, caseId + " check key id only failed!" );
                Iterator<String> iterator = keyId.iterator();
                while (iterator.hasNext()) {
                    res = CommonApi.getKeyStore(headers, httpClient, iterator.next());
                    assertEquals(res.getCode(), 200, caseId + " get keystore failed!");
                }
                logger.info("all cert key is insert into kless!");
                updateLbBodyJson.put("InstanceId", lb.getInstanceId());
                res = CommonApi.updateLb(headers, updateLbBodyJson, httpClient);
                assertEquals(res.getCode(), 200, caseId + " update acc from 1 to -1 failed!");
                JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                assertEquals(getClassicLoadBalanceByCaseId(loadBalanceCaseId).getAttrs().getUseSSLAcc(), updateLbBodyJson.getJSONObject("Attrs").getInteger("UseSSLAcc"), caseId + " attrs.useSSLAcc wrong!");
                assertEquals(getClassicLoadBalanceByCaseId(loadBalanceCaseId).getAttrs().getStopTimeout(), updateLbBodyJson.getJSONObject("Attrs").getInteger("StopTimeout"), caseId + " attrs.stopTimeout wrong!");
                res = CommonApi.getKeys(headers, httpClient);
                assertEquals(res.getCode(), 200, "get kssl keys failed!");
                assertEquals(JSONObject.parseObject(res.getHtml()).getJSONArray("result").size(), 0, caseId + " kssl keys are not delete after useSSLAcc = -1");
                updateLbBodyJson.getJSONObject("Attrs").put("UseSSLAcc", 1);
                res = CommonApi.updateLb(headers, updateLbBodyJson, httpClient);
                assertEquals(res.getCode(), 200, caseId + " update acc from -1 to 1 failed!");
                JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                assertEquals(getClassicLoadBalanceByCaseId(loadBalanceCaseId).getAttrs().getUseSSLAcc(), updateLbBodyJson.getJSONObject("Attrs").getInteger("UseSSLAcc"), caseId + " attrs.useSSLAcc wrong!");
                assertEquals(getClassicLoadBalanceByCaseId(loadBalanceCaseId).getAttrs().getStopTimeout(), updateLbBodyJson.getJSONObject("Attrs").getInteger("StopTimeout"), caseId + " attrs.stopTimeout wrong!");
                res = CommonApi.getKeys(headers, httpClient);
                assertEquals(res.getCode(), 200, caseId + " get kssl keys failed!");
                assertTrue(!JSONObject.parseObject(res.getHtml()).getJSONArray("result").isEmpty(), caseId + " kssl keys still empty after useSSLAcc = 1");
            }

            @Override
            public void afterTest() {
                resetClassicListener(loadBalanceCaseId);
                Response res;
                res = CommonApi.getKeys(headers, httpClient);
                assertEquals(res.getCode(), 200, caseId + " get kssl keys failed!");
                resJson = JSONObject.parseObject(res.getHtml());
//                assertTrue(resJson.getJSONArray("result").isEmpty());
                logger.info("waiting for 10 sec for deleting ssl key...");
                try {
                    TimeUnit.SECONDS.sleep(25);
                } catch (InterruptedException e) {
                    System.out.println("error");
                }
                res = CommonApi.getKeyStore(headers, httpClient, keyId.iterator().next());
                assertEquals(res.getCode(), 404, caseId + " still find keyId");
                logger.info("cannot find keyId any more after delete listener!");
            }
        });
    }
}
