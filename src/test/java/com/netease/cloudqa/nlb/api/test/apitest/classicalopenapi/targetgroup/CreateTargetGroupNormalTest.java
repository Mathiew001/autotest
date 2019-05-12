package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.targetgroup;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ParallelRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.utils.JsonUtils;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;

/**
 *
 * @author chentianyu1
 * @version $Id: CreateTargetGroupNormalTest.java, v 0.1 Apr 27, 2018 1:13:33 PM chentianyu1 Exp $
 */
public class CreateTargetGroupNormalTest extends ApiTestBase {

    @Test(dataProvider = "YamlDriverDataProvider", description = "CreateTargetGroup NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId,
                        final String body, final String resMsg, final String loadBalanceCaseId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils     httpClient = new HttpClientUtils();
            Map<String, String> headers    = new HashMap<String, String>();
            JSONObject          bodyJson   = (JSONObject) JSONObject.parse(body);
            JSONObject          resMsgJson = (JSONObject) JSONObject.parse(resMsg);
            JSONObject          resJson    = new JSONObject();
            LoadBalancer        lb         = null;

            @Override
            public void beforeTest() {
                headers.put("X-Product-Id", tenantId);
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                lb = getClassicLoadBalanceByCaseId(loadBalanceCaseId);
                bodyJson.put("InstanceId", lb.getInstanceId());
                resetClassicGroups(loadBalanceCaseId);
            }

            @Override
            public void executeTest() {
                Response res = CommonApi.createTg(headers, bodyJson, httpClient);
                assertEquals(res.getCode(), 200, caseId + " create tg status code != 200");
                logger.info("create target group successfully!");
                resJson = JSONObject.parseObject(res.getHtml());
                resMsgJson = JSONObject.parseObject(resMsg);
                resMsgJson.put("InstanceId", lb.getInstanceId());
                JsonUtils.responseCheck(resMsgJson, resJson, caseId);
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_tgroup",
                        new DataUnit("vipId", String.class.toString(), resJson.getString("InstanceId"), null, FlagConstant.C));
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_tgroup",
                        new DataUnit("id", String.class.toString(), resJson.getString("TargetGroupId"), null, FlagConstant.C));
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_tgroup_monitor",
                        new DataUnit("vipId", String.class.toString(), resJson.getString("InstanceId"), null, FlagConstant.C));
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_tgroup_monitor",
                        new DataUnit("tGroupId", String.class.toString(), resJson.getString("TargetGroupId"), null, FlagConstant.C));
                res = CommonApi.getLbDetail(headers, httpClient, resJson.getString("InstanceId"));
                assertEquals(res.getCode(), 200, caseId + " get lb != 200");
                resJson = JSONObject.parseObject(res.getHtml());
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_tgroup_server",
                        new DataUnit("tGroupId", String.class.toString(), CommonApi.findTgByName(resJson, "tg-test").getString("TargetGroupId"), null, FlagConstant.C));
                ParallelRuntimeContext.getDataHolderMap().get(caseId).addDbExpectData("lb_tgroup_server", "tgroup_server_2",
                        new DataUnit("tGroupId", String.class.toString(), CommonApi.findTgByName(resJson, "tg-test").getString("TargetGroupId"), null, FlagConstant.C));
                assertDbCheck(caseId);
            }

            @Override
            public void afterTest() {
                JsonUtils.refreshLb(headers, httpClient, lb, loadBalanceCaseId);
                resetClassicGroups(loadBalanceCaseId);
            }
        });
    }
}