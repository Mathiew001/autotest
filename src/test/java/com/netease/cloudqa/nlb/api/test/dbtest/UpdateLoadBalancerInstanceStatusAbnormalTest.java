package com.netease.cloudqa.nlb.api.test.dbtest;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import com.netease.push.util.JSONUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class UpdateLoadBalancerInstanceStatusAbnormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="UpdateLoadBalancerInstanceStatusAbnormal Test")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String instanceId, final String des, final String resMsg) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject updateBodyJson = new JSONObject();
            JSONObject resJson = new JSONObject();
            JSONObject resMsgJson = JSONObject.parseObject(resMsg);

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                dbClean(caseId);
                dbImport(caseId);
            }

            @Override
            public void executeTest() {
                updateBodyJson.put("InstanceId", instanceId);
                updateBodyJson.put("Description", des);
                Response res = CommonApi.updateLb(headers, updateBodyJson, httpClient);
                resJson = JSONObject.parseObject(res.getHtml());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
            }

            @Override
            public void afterTest() {
                dbClean(caseId);
            }
        });
    }
}
