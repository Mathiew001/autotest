package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;
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
 * @version $Id: CreateLoadBalancerIngNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1n Exp $
 */
public class CreateLoadBalancerIngAbnormalTest extends ApiTestBase {
    @Test(dataProvider="YamlDriverDataProvider", description="CreateLoadBalancer NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String namespace, final String prepareBody, final String executeBody,
                        final String prepareMethod, final String cleanMethod, final String resMsg) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject createBodyJson = JSONObject.parseObject(executeBody);
            JSONObject resJson = new JSONObject();
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);

            @Override
            public void beforeTest() {
                headers.put("X-Product-Id", tenantId);
                headers.put("Namespace", namespace);
                System.out.println("headers: "+ headers);
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                if (prepareMethod != null)
                    PrepareMethodInvokerUtils.invokeMethod(prepareMethod, headers, httpClient, prepareBody);
            }

            @Override
            public void executeTest() {
                Response res = CommonApi.createLbIng(headers, createBodyJson, httpClient);
                resJson = JSONObject.parseObject(res.getHtml());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
                if (cleanMethod != null)
                    CleanMethodInvokerUtils.invokeMethod(cleanMethod, headers, httpClient);
            }
        });
    }
}
