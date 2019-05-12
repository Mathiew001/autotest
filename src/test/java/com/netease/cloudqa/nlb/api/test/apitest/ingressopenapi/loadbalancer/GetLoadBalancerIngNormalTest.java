package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.loadbalancer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
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
public class GetLoadBalancerIngNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="GetLoadBalancer NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String executeBody, final String resMsg, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray executeBodyArray = JSONArray.parseArray(executeBody);
            JSONObject resMsgJson = (JSONObject) JSONObject.parse(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                lb = getIngLoadBalanceByCaseId(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res;
                for (int i = 0; i < executeBodyArray.size(); i++) {
                    JSONObject item = executeBodyArray.getJSONObject(i);
                    item.put("InstanceId", lb.getInstanceId());
                    res = CommonApi.createLnIng(headers, item, httpClient);
                    assertEquals(res.getCode(), 204, "create ing listener status code != 204");
                    logger.info("Create ing listener successfully!");
                }
                res = CommonApi.getLbDetailIng(headers, httpClient, lb.getInstanceId());
                resJson = JSONObject.parseObject(res.getHtml());
                lb = JsonUtils.fromObjectIgnoreCase(res.getHtml());
                ingInstances.put(loadBalanceCaseId, lb);
                resMsgJson.put("TenantId", tenantId);
                resMsgJson.put("InstanceId", lb.getInstanceId());
                resMsgJson.put("Name", lb.getName());
                resMsgJson.put("Address", lb.getAddress());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
                resetIngressListener(loadBalanceCaseId);
            }
        });
    }
}
