package com.netease.cloudqa.nlb.api.test.apitest.ingressopenapi.listener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.TargetGroup;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateLbListenerIngAbnormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="CreateLbListenerIng AbnormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String executeBody, final String resMsg, final String loadBalanceCaseId,
                        final Boolean isVpc) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {
            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONArray executeBodyArray = JSONObject.parseArray(executeBody);
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);
            JSONObject resJson = new JSONObject();
            LoadBalancer lb = null;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                lb = getIngLoadBalanceByCaseId(loadBalanceCaseId);
                resetIngressListener(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res = null;
                for (int i =  0; i < executeBodyArray.size(); i++) {
                    JSONObject item = (JSONObject) executeBodyArray.get(i);
                    item.put("InstanceId", lb.getInstanceId());
                }
                for (int i = 0; i < executeBodyArray.size(); i++)
                    res = CommonApi.createLnIng(headers, executeBodyArray.getJSONObject(i), httpClient);
                resJson = JSONObject.parseObject(res.getHtml());
                resMsgJson = JSONObject.parseObject(resMsg);
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
                resetIngressListener(loadBalanceCaseId);
            }
        });
    }
}
