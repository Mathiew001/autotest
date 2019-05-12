package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 *
 * @author chentianyu1
 * @version $Id: UpdateLoadBalancerIngNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class UpdateLoadBalancerNormalTest extends ApiTestBase {
    @Test(dataProvider="YamlDriverDataProvider", description="UpdateLoadBalancers NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String updateBody, final String resMsg, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject updateBodyJson = JSONObject.parseObject(updateBody);
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);

            }

            @Override
            public void executeTest() {
                updateBodyJson.put("InstanceId", lb.getInstanceId());
                Response res = CommonApi.updateLb(headers, updateBodyJson, httpClient);
                assertEquals(res.getCode(), 200, caseId + " update load balancer failed!");
                JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                assertEquals(resMsgJson.getString("Description"), lb.getDescription(), caseId + " description update wrong!");
                logger.info("Update load balancer successfully!");
            }

            @Override
            public void afterTest() {
            }
        });
    }
}
