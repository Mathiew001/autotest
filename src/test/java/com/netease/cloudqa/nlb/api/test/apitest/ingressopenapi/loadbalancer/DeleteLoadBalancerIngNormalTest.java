package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.NlbModel;
import com.netease.cloudqa.nlb.api.test.utils.CleanMethodInvokerUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.PrepareMethodInvokerUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 *
 * @author chentianyu1
 * @version $Id: DeleteLoadBalancerIngNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class DeleteLoadBalancerIngNormalTest extends ApiTestBase {
//    @Test(dataProvider="YamlDriverDataProvider", description="DeleteLoadBalancer NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String prepareBody, final String executeBody, final String prepareMethod,
                        final String cleanMethod) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject deleteBodyJson = JSONObject.parseObject(executeBody);
            JSONObject resJson = new JSONObject();

            @Override
            public void beforeTest() {
                headers.put("X-Product-Id", tenantId);
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                if (prepareMethod != null)
                    PrepareMethodInvokerUtils.invokeMethod(prepareMethod, headers, httpClient, prepareBody);
            }

            @Override
            public void executeTest() {
                NlbModel nlbModel = (NlbModel) ApiRuntimeContext.CaseContext.getPrameter("NLB_MODEL");
                deleteBodyJson.put("InstanceId", nlbModel.getLoadBalancer().getInstanceId());
                logger.info("Execute Data Request: " + deleteBodyJson);
                Response res = CommonApi.deleteLbIng(headers, httpClient, deleteBodyJson.getString("InstanceId"));
                assertEquals(res.getCode(), 200, "Reneworder ingress failed!");
                resJson = JSONObject.parseObject(res.getHtml());
                logger.info("Execute Data Response: " + resJson);
                logger.info("Delete ingress successfully!");
            }

            @Override
            public void afterTest() {
                if (cleanMethod != null)
                    CleanMethodInvokerUtils.invokeMethod(cleanMethod, headers, httpClient);
            }
        });
    }

}
