package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.loadbalancer;

import com.alibaba.fastjson.JSONArray;
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
import com.netease.cloudqa.nlb.api.test.utils.PrepareMethodInvokerUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckLoadBalancerParamsIngNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="CheckLoadBalancerParams NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String prepareBody, final String executeBody, final String prepareMethod,
                        final String cleanMethod) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject checkBodyJson = JSONObject.parseObject(executeBody);
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
                Response res = CommonApi.checkLbParamsIng(headers, checkBodyJson, httpClient);
                resJson = JSONObject.parseObject(res.getHtml());
                assertEquals(res.getCode(), 200, "Check ingress params failed!");
                logger.info("Check ingress params successfully!");
            }

            @Override
            public void afterTest() {
//                if (cleanMethod != null)
//                    CleanMethodInvokerUtils.invokeMethod(cleanMethod, headers, httpClient);
//                Response res = CommonApi.getLbsIng(headers, httpClient, "100", "0");
//                JSONArray list = JSONObject.parseArray(res.getHtml());
//                for (Object obj : list) {
//                    JSONObject item = (JSONObject) obj;
//                    if (item.getString("Name").contains("qa-test"))
//                        CommonApi.deleteLbIngAdmin(headers, httpClient, item.getString("InstanceId"));
//                }
            }
        });
    }
}
