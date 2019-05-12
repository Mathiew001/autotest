package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.loadbalancer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.NlbModel;
import com.netease.cloudqa.nlb.api.test.utils.CleanMethodInvokerUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import com.netease.cloudqa.nlb.api.test.utils.PrepareMethodInvokerUtils;
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
public class UpdateLoadBalancerIngNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="UpdateLoadBalancers NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String des, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject updateBodyJson = new JSONObject();
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
                updateBodyJson.put("InstanceId", lb.getInstanceId());
                updateBodyJson.put("Description", des);
                Response res = CommonApi.updateLbIng(headers, updateBodyJson, httpClient);
                assertEquals(res.getCode(), 204, "update ingress failed!");
                res = CommonApi.getLbDetailIng(headers, httpClient, lb.getInstanceId());
                resJson = JSONObject.parseObject(res.getHtml());
                assertEquals(resJson.getString("Description"), des, "description update wrong!");
                logger.info("Update ingress successfully!");
            }

            @Override
            public void afterTest() {
            }
        });
    }
}
