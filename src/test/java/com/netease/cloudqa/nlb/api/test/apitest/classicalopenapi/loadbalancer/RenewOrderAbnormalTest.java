package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer;

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
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 *
 * @author chentianyu1
 * @version $Id: RenewOrderIngAbnormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class RenewOrderAbnormalTest extends ApiTestBase {
    @Test(dataProvider="YamlDriverDataProvider", description="RenewOrder AbnormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String period, final String resMsg, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
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
                Response res = CommonApi.renewOrder(headers, httpClient, lb.getInstanceId(), period);
                JSONObject resJson = JSONObject.parseObject(res.getHtml());
                String message = resJson.getString("Message");
                if (message.contains("RequestId")) {
                    String[] tmp = message.split(",");
                    String messageNew = tmp[0] + "," + tmp[2];
                    resJson.put("Message", messageNew);
                }
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
            }
        });
    }
}
