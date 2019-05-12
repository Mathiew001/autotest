package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.TargetGroup;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 *
 * @author chentianyu1
 * @version $Id: GetLoadBalancerIngNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class GetLoadBalancerNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="GetLoadBalancer NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String executeBody, final String updateBody, final String resMsg1,
                        final String resMsg2, final String loadBalanceCaseId, final Boolean isVpc) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray executeBodyArray  = JSONObject.parseArray(executeBody);
            JSONObject updateBodyJson  = JSONObject.parseObject(updateBody);
            JSONObject resMsgJson1 = JSONObject.parseObject(resMsg1);
            JSONObject resMsgJson2 = JSONObject.parseObject(resMsg2);
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
                resMsgJson1.put("TenantId", tenantId);
                resMsgJson1.put("InstanceId", lb.getInstanceId());
                resMsgJson1.put("Name", lb.getName());
                resMsgJson1.put("Address", lb.getAddress());
                JsonUtils.responseCheck(resMsgJson1, resJson, caseId);
                updateBodyJson.put("InstanceId", lb.getInstanceId());
                TargetGroup tg = CommonApi.findTgByName(lb, "tg-test-01");
                updateBodyJson.put("TargetGroupId", tg.getTargetGroupId());
                CommonApi.updateTg(headers, updateBodyJson, httpClient);
                res = CommonApi.getLbDetail(headers, httpClient, lb.getInstanceId());
                resJson = JSONObject.parseObject(res.getHtml());
                resMsgJson2.put("TenantId", tenantId);
                resMsgJson2.put("InstanceId", lb.getInstanceId());
                resMsgJson2.put("Name", lb.getName());
                resMsgJson2.put("Address", lb.getAddress());
                JsonUtils.responseCheck(resMsgJson2, resJson, caseId);
            }

            @Override
            public void afterTest() {
                resetClassicListener(loadBalanceCaseId);
                resetClassicGroups(loadBalanceCaseId);
            }
        });
    }
}
