package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.loadbalancer;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.apache.log4j.NDC;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;


/**
 *
 * @author chentianyu1
 * @version $Id: CreateLoadBalancerIngNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1n Exp $
 */
public class CreateLoadBalancerAbnormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="CreateLoadBalancer AbnormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String body, final String resMsg) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject bodyJson = (JSONObject) JSONObject.parse(body);
            JSONObject resMsgJson = (JSONObject) JSONObject.parse(resMsg);
            JSONObject resJson = new JSONObject();

            @Override
            public void beforeTest() {
                headers.put("X-Product-Id", tenantId);
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
            }

            @Override
            public void executeTest() {
                Response res = CommonApi.createLb(headers, bodyJson, httpClient);
                resJson = JSONObject.parseObject(res.getHtml());
                resMsgJson = JSONObject.parseObject(resMsg);
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
