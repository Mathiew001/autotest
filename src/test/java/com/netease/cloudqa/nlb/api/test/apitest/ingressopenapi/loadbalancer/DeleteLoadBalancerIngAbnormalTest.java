package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
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

import static org.testng.Assert.assertEquals;

/**
 *
 * @author chentianyu1
 * @version $Id: DeleteLoadBalancerIngAbnormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class DeleteLoadBalancerIngAbnormalTest extends ApiTestBase {
    @Test(dataProvider="YamlDriverDataProvider", description="DeleteLoadBalancer AbnormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String body, final String resMsg, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject deleteBodyJson = JSONObject.parseObject(body);
            JSONObject resJson = new JSONObject();
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                if (loadBalanceCaseId != null)
                    lb = getIngLoadBalanceByCaseId(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                if (lb != null)
                    deleteBodyJson.put("InstanceId", lb.getInstanceId());
                else
                    deleteBodyJson.put("InstanceId", deleteBodyJson.getString("InstanceId"));
                Response res = CommonApi.deleteLbIng(headers, httpClient, deleteBodyJson.getString("InstanceId"));
                resJson = JSONObject.parseObject(res.getHtml());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {

            }
        });
    }
}