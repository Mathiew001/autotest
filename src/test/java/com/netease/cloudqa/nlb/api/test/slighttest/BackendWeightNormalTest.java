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
import com.netease.cloudqa.nlb.api.test.utils.LinuxCmd;
import com.netease.cloudqa.nlb.api.test.utils.NetUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BackendWeightNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "BackendWeight NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String executeBody, final String resMsg, final String loadBalanceCaseId,
                        final Boolean isVpc, final Boolean sameGroup, final String updateTgBody) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray executeBodyArray  = JSONObject.parseArray(executeBody);
            JSONArray resMsgJson = JSONObject.parseArray(resMsg);
            JSONObject updateTgBodyJson = JSONObject.parseObject(updateTgBody);
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
                    tg = CommonApi.findTgByName(lb, "tg-test-03");
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
                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    System.out.println("error");
                }
                if (!lb.getNetwork().equals("private") || !lb.getType().equals("vpc_mix"))
                    NetUtils.checkListenerEffective(listeners, lb.getAddress());
                logger.info("curl vip + port successfully!");
                updateTgBodyJson.put("InstanceId", lb.getInstanceId());
                updateTgBodyJson.put("TargetGroupId", CommonApi.findTgByName(lb, "tg-test-03").getTargetGroupId());
                res = CommonApi.updateTg(headers, updateTgBodyJson, httpClient);
                assertEquals(res.getCode(), 200, caseId + " update target group failed!");
                logger.info("curl vip + port for 1 minute......");
                String path;
                if (lb.getListeners().get(0).getClusters().get(0).getPath() == null)
                    path = "";
                else
                    path = lb.getListeners().get(0).getClusters().get(0).getPath();
                String cmd = "sh scripts/checkBackendWeight.sh " + lb.getAddress() + " " +
                        lb.getListeners().get(0).getListenPort() + " " + lb.getListeners().get(0).getProtocol() + " " +
                        lb.getListeners().get(0).getClusters().get(0).getServerName() + " " + path;
                System.out.println(cmd);
                String result = LinuxCmd.exec(cmd);
                Double weight1 = updateTgBodyJson.getJSONArray("Instances").getJSONObject(0).getDouble("Weight");
                Double weight2 = updateTgBodyJson.getJSONArray("Instances").getJSONObject(1).getDouble("Weight");
                Double ratio = weight1 > weight2 ? weight1/weight2 : weight2/weight1;
                logger.info("two backend expected weight ratio: " +  ratio);
                logger.info("two backend actual weight ratio: " +  result);
            }

            @Override
            public void afterTest() {
                resetClassicListener(loadBalanceCaseId);
            }
        });
    }
}
