package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.listener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.NlbModel;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.PrepareMethodInvokerUtils;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class DeleteLbListenerNormalTest extends ApiTestBase {

//    @Test(dataProvider="YamlDriverDataProvider", description="DeleteLbListener NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String executeBody, final String loadBalanceCaseId, final Boolean isVpc) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray executeBodyArray  = JSONObject.parseArray(executeBody);
//            JSONArray resMsgJson = JSONObject.parseArray(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
            }

            @Override
            public void executeTest() {
                NlbModel nlbModel = (NlbModel) ApiRuntimeContext.CaseContext.getPrameter("NLB_MODEL");
//                Response res = CommonApi.deleteLn(headers, httpClient, instanceId, nlbModel.getListener().getListenerId());
//                assertEquals(res.getCode(), 200, "Delete lb listener failed!");
            }

            @Override
            public void afterTest() {
            }
        });
    }
}
