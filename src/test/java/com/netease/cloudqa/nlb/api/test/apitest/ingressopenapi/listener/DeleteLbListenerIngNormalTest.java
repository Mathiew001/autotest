package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.listener;

import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.NlbModel;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.PrepareMethodInvokerUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class DeleteLbListenerIngNormalTest extends ApiTestBase {

//    @Test(dataProvider="YamlDriverDataProvider", description="DeleteLbListener NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String instanceId, final String prepareBody, final String prepareMethod) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                if (prepareMethod != null)
                    PrepareMethodInvokerUtils.invokeMethod(prepareMethod, headers, httpClient, prepareBody);
            }

            @Override
            public void executeTest() {
                NlbModel nlbModel = (NlbModel) ApiRuntimeContext.CaseContext.getPrameter("NLB_MODEL");
                Response res = CommonApi.deleteLnIng(headers, httpClient, instanceId, nlbModel.getListener().getListenerId());
                assertEquals(res.getCode(), 204, "Delete lb listener failed!");
            }

            @Override
            public void afterTest() {
            }
        });
    }
}
