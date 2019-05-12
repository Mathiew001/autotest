package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.model.LbLog;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LbLogTest extends ApiTestBase {
    @Test(dataProvider = "YamlDriverDataProvider", description = "nlb log test")
    public void apiTest(final String caseId, final String description, final String tenantId, final String body,
                        final String realServer1, final String rsName1, final String rsAddress1,
                        final String realServer2, final String rsName2, final String rsAddress2,
                        final String topAz) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {
            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>() {{
                put("X-Product-Id", tenantId);
            }};
            String vipId;

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
            }

            private void assertTimestamp(long expected, long actual, String msg) {
                assertTrue(expected > actual - 1000 || expected < actual + 1000, msg);
            }

            private void logTimestamp(String descr, long ts) {
                logger.info(descr + ": " + ts + " - " + new Date(ts));
            }

            private void assertListPrefix(List<LbLog> logs, LbLog... prefix) {
                for (int i = 0; i < prefix.length; ++i) {
                    assertEquals(prefix[i], logs.get(i));
                }
            }

            @Override
            public void executeTest() {
                // create loadbalancer
                JSONObject bodyJson = JSONObject.parseObject(body);

                final long createLbTimestamp = System.currentTimeMillis();
                logTimestamp("Create loadbalancer at", createLbTimestamp);

                Response resp;
                JSONObject resJson;
                {
                    resp = CommonApi.createLb(headers, bodyJson, httpClient);
                    assertEquals(resp.getCode(), 200, "create lb status code != 200 " + resp.getHtml());
                    resJson = JSONObject.parseObject(resp.getHtml());
                }

                final String vipId = resJson.getString("InstanceId");
                this.vipId = vipId;

                final LbLog logCreate;
                {
                    final List<LbLog> logsWhenCreating = CommonApi.getLbLogs(vipId, tenantId, httpClient);
                    assertEquals(1, logsWhenCreating.size(), "刚创建时候日志应该只有一个");
                    logCreate = logsWhenCreating.get(0);
                    assertEquals(bodyJson.get("Name"), logCreate.getData().getName());
                    assertEquals("vip_create", logCreate.getOperation());
                    logger.info("Resp vip_create timestamp: " + logCreate.getTimestamp() + " - " + new Date(logCreate.getTimestamp()));
                    assertTimestamp(createLbTimestamp, logCreate.getTimestamp(), "vip_create timestamp is wrong");
                }

                final String status = CommonApi.waitLb(headers, httpClient, vipId);
                assertEquals(status, "WORKING", "create lb failed!" + resJson);

                {
                    List<LbLog> logsWhenCreated = CommonApi.getLbLogs(vipId, tenantId, httpClient);
                    assertEquals(1, logsWhenCreated.size(), "创建完成时日志应该只有一个");
                    assertEquals(logCreate, logsWhenCreated.get(0), "创建完成时的日志应该和刚创建时的日志一样");
                }

                // create target group
                final long createTGRP1Timestamp = System.currentTimeMillis();
                logTimestamp("Create target group 1", createTGRP1Timestamp);

                {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject
                        .fluentPut("Name", "tgrp1")
                        .fluentPut("InstanceId", vipId)
                        .fluentPut("Instances", new JSONArray()
                            .fluentAdd(new JSONObject()
                                .fluentPut("Id", realServer1)
                                .fluentPut("Name", rsName1)
                                .fluentPut("Address", rsAddress1)
                                .fluentPut("Port", 80)
                                .fluentPut("TopAz", topAz))
                            .fluentAdd(new JSONObject()
                                .fluentPut("Id", realServer2)
                                .fluentPut("Name", rsName2)
                                .fluentPut("Address", rsAddress2)
                                .fluentPut("Port", 80)
                                .fluentPut("TopAz", topAz))
                        );
                    resp = CommonApi.createTg(headers, jsonObject, httpClient);
                    assertEquals(200, resp.getCode(), "create target group failed");
                    resJson = JSONObject.parseObject(resp.getHtml());
                }

                final String tgrp1Id = resJson.getString("TargetGroupId");

                final LbLog logTGrp1;
                {
                    final List<LbLog> logsAfterTGrp = CommonApi.getLbLogs(vipId, tenantId, httpClient);
                    assertEquals(2, logsAfterTGrp.size(), "列表应该是：[创建vip，创建tgrp1]");
                    assertListPrefix(logsAfterTGrp, logCreate);
                    logTGrp1 = logsAfterTGrp.get(1);
                    assertEquals("tgrp_create", logTGrp1.getOperation());
                    assertTimestamp(createTGRP1Timestamp, logTGrp1.getTimestamp(), "tgrp1 create time is wrong");
                    assertEquals("tgrp1", logTGrp1.getData().getName());
                }

                // create another target group
                final long createTGRP2Timestamp = System.currentTimeMillis();
                logTimestamp("Create target group 2", createTGRP2Timestamp);

                {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject
                        .fluentPut("Name", "tgrp2")
                        .fluentPut("InstanceId", vipId)
                        .fluentPut("Instances", new JSONArray()
                            .fluentAdd(new JSONObject()
                                .fluentPut("Id", realServer1)
                                .fluentPut("Name", rsName1)
                                .fluentPut("Address", rsAddress1)
                                .fluentPut("Port", 80)
                                .fluentPut("TopAz", topAz))
                        );
                    resp = CommonApi.createTg(headers, jsonObject, httpClient);
                    assertEquals(200, resp.getCode(), "create target group failed");
                    resJson = JSONObject.parseObject(resp.getHtml());
                }

                final String tgrp2Id = resJson.getString("TargetGroupId");

                final LbLog logTGrp2;
                {
                    final List<LbLog> logsAfterTGrp = CommonApi.getLbLogs(vipId, tenantId, httpClient);
                    assertEquals(3, logsAfterTGrp.size(), "列表应该是：[创建vip,创建tgrp1,创建tgrp2]");
                    assertListPrefix(logsAfterTGrp, logCreate, logTGrp1);
                    logTGrp2 = logsAfterTGrp.get(2);
                    assertEquals("tgrp_create", logTGrp2.getOperation());
                    assertTimestamp(createTGRP1Timestamp, logTGrp2.getTimestamp(), "tgrp2 create time is wrong");
                    assertEquals("tgrp2", logTGrp2.getData().getName());
                }

                // create listener with tgrp1
                final long createLsnTimestamp = System.currentTimeMillis();
                logTimestamp("Create listener at", createLsnTimestamp);
                final String lsnId;
                {
                    resp = CommonApi.createLn(headers, new JSONObject()
                            .fluentPut("InstanceId", vipId)
                            .fluentPut("Name", "lsn")
                            .fluentPut("ListenPort", 80)
                            .fluentPut("Protocol", "tcp")
                            .fluentPut("Clusters", new JSONArray()
                                .fluentAdd(new JSONObject()
                                    .fluentPut("TargetGroupId", tgrp1Id)
                                ))
                        , httpClient);
                    assertEquals(200, resp.getCode());
                    resJson = JSONObject.parseObject(resp.getHtml());
                    lsnId = resJson.getString("ListenerId");
                }

                final LbLog logLsn;
                {
                    List<LbLog> logsAfterLsnCreate = CommonApi.getLbLogs(vipId, tenantId, httpClient);
                    assertEquals(4, logsAfterLsnCreate.size(), "列表应该是：[创建vip,创建tgrp1,创建tgrp2,创建lsn]");
                    assertListPrefix(logsAfterLsnCreate, logCreate, logTGrp1, logTGrp2);
                    logLsn = logsAfterLsnCreate.get(3);
                    assertEquals("lsn_create", logLsn.getOperation());
                    assertTimestamp(createLsnTimestamp, logLsn.getTimestamp(), "lsn create time is wrong");
                    assertEquals("lsn", logLsn.getData().getName());
                }

                // update tgrp1 remove rs2
                final long updateTGrp1Timestamp = System.currentTimeMillis();
                logTimestamp("Update tgrp1", updateTGrp1Timestamp);
                {
                    resp = CommonApi.deregisterTGInstance(headers, new JSONObject()
                            .fluentPut("InstanceId", vipId)
                            .fluentPut("Instances", new JSONArray()
                                .fluentAdd(new JSONObject()
                                    .fluentPut("Address", rsAddress2)
                                    .fluentPut("Port", 80)
                                )
                            )
                            .fluentPut("TargetGroupId", tgrp1Id)
                        , httpClient);
                    assertEquals(200, resp.getCode(), "remove instance from tgrp1 failed");
                }

                final LbLog logTGrp1Update;
                {
                    List<LbLog> logsAfterUpdateTgrp1 = CommonApi.getLbLogs(vipId, tenantId, httpClient);
                    assertEquals(5, logsAfterUpdateTgrp1.size(), "列表应该是：[创建vip,创建tgrp1,创建tgrp2,创建lsn,更新tgrp1]");
                    assertListPrefix(logsAfterUpdateTgrp1, logCreate, logTGrp1, logTGrp2, logLsn);
                    logTGrp1Update = logsAfterUpdateTgrp1.get(4);
                    assertEquals("tgrp_update", logTGrp1Update.getOperation());
                    assertTimestamp(updateTGrp1Timestamp, logTGrp1Update.getTimestamp(), "update tgrp1 time is wrong");
                    assertEquals("tgrp1", logTGrp1Update.getData().getName());
                }

                // update listener with tgrp2
                final long updateLsnTimestamp = System.currentTimeMillis();
                logTimestamp("Update lsn", updateLsnTimestamp);
                {
                    resp = CommonApi.updateLn(headers, new JSONObject()
                            .fluentPut("InstanceId", vipId)
                            .fluentPut("ListenerId", lsnId)
                            .fluentPut("Clusters", new JSONArray()
                                .fluentAdd(new JSONObject()
                                    .fluentPut("TargetGroupId", tgrp2Id)
                                )
                            )
                        , httpClient);
                    assertEquals(200, resp.getCode(), "update lsn failed");
                }

                final LbLog logLsnUpdate;
                {
                    List<LbLog> logsAfterUpdateLsn = CommonApi.getLbLogs(vipId, tenantId, httpClient);
                    assertEquals(6, logsAfterUpdateLsn.size(), "列表应该是：[创建vip,创建tgrp1,创建tgrp2,创建lsn,更新tgrp1,更新lsn]");
                    assertListPrefix(logsAfterUpdateLsn, logCreate, logTGrp1, logTGrp2, logLsn, logTGrp1Update);
                    logLsnUpdate = logsAfterUpdateLsn.get(5);
                    assertEquals("lsn_update", logLsnUpdate.getOperation());
                    assertTimestamp(updateLsnTimestamp, logLsnUpdate.getTimestamp(), "update lsn time is wrong");
                    assertEquals("lsn", logLsnUpdate.getData().getName());
                }

                // remove tgrp1
                final long removeTGrp1Timestamp = System.currentTimeMillis();
                logTimestamp("Remove tgrp1", removeTGrp1Timestamp);
                {
                    resp = CommonApi.deleteTg(headers, httpClient, vipId, tgrp1Id);
                    assertEquals(200, resp.getCode(), "remove tgrp1 failed");
                }

                final LbLog logTGrp1Remove;
                {
                    List<LbLog> logsAfterTGrp1Remove = CommonApi.getLbLogs(vipId, tenantId, httpClient);
                    assertEquals(7, logsAfterTGrp1Remove.size(), "列表应该是：[创建vip,创建tgrp1,创建tgrp2,创建lsn,更新tgrp1,更新lsn,删除tgrp1]");
                    assertListPrefix(logsAfterTGrp1Remove, logCreate, logTGrp1, logTGrp2, logLsn, logTGrp1Update, logLsnUpdate);
                    logTGrp1Remove = logsAfterTGrp1Remove.get(6);
                    assertEquals("tgrp_delete", logTGrp1Remove.getOperation());
                    assertTimestamp(removeTGrp1Timestamp, logTGrp1Remove.getTimestamp(), "remove tgrp1 time is wrong");
                    assertEquals("tgrp1", logTGrp1Remove.getData().getName());
                }

                // remove listener
                final long removeLsnTimestamp = System.currentTimeMillis();
                logTimestamp("Remove lsn", removeLsnTimestamp);
                {
                    resp = CommonApi.deleteLn(headers, httpClient, vipId, lsnId);
                    assertEquals(200, resp.getCode(), "remove lsn failed");
                }

                final LbLog logLsnRemove;
                {
                    List<LbLog> logsAfterLsnRemove = CommonApi.getLbLogs(vipId, tenantId, httpClient);
                    assertEquals(8, logsAfterLsnRemove.size(), "列表应该是：[创建vip,创建tgrp1,创建tgrp2,创建lsn,更新tgrp1,更新lsn,删除tgrp1,删除lsn]");
                    assertListPrefix(logsAfterLsnRemove, logCreate, logTGrp1, logTGrp2, logLsn, logTGrp1Update, logLsnUpdate, logTGrp1Remove);
                    logLsnRemove = logsAfterLsnRemove.get(7);
                    assertEquals("lsn_delete", logLsnRemove.getOperation());
                    assertTimestamp(removeLsnTimestamp, logLsnRemove.getTimestamp(), "remove lsn time is wrong");
                    assertEquals("lsn", logLsnRemove.getData().getName());
                }

                // update lb bandwidth
                final long updateLbTimestamp = System.currentTimeMillis();
                logTimestamp("Update lb", updateLbTimestamp);
                {
                    resp = CommonApi.updateLbSpec(headers, new JSONObject()
                            .fluentPut("InstanceId", vipId)
                            .fluentPut("Standard", new JSONObject()
                                .fluentPut("BandwidthLimit", 11))
                        , httpClient);
                    assertEquals(200, resp.getCode(), "update lb failed");
                }

                final LbLog logLbUpdate;
                {
                    List<LbLog> logsAfterLbUpdate = CommonApi.getLbLogs(vipId, tenantId, httpClient);
                    assertEquals(9, logsAfterLbUpdate.size(), "列表应该是：[创建vip,创建tgrp1,创建tgrp2,创建lsn,更新tgrp1,更新lsn,删除tgrp1,删除lsn,更新lb]");
                    assertListPrefix(logsAfterLbUpdate, logCreate, logTGrp1, logTGrp2, logLsn, logTGrp1Update, logLsnUpdate, logTGrp1Remove);
                    logLbUpdate = logsAfterLbUpdate.get(8);
                    assertEquals("vip_update", logLbUpdate.getOperation());
                    assertTimestamp(updateLbTimestamp, logLbUpdate.getTimestamp(), "update lb time is wrong");
                    assertEquals(bodyJson.getString("Name"), logLbUpdate.getData().getName());
                }

                // delete the lb
                final long deleteLbTimestamp = System.currentTimeMillis();
                logTimestamp("DeleteLb at", deleteLbTimestamp);
                {
                    resp = CommonApi.deleteLb(headers, httpClient, vipId);
                    assertEquals(200, resp.getCode(), "delete lb failed " + resp.getHtml());
                    this.vipId = null;
                }

//                因为删了lb之后就不能调这个lb的接口了，所以这个日志省略
//                final LbLog logLbRemove;
//                {
//                    List<LbLog> logsAfterLbRemove = CommonApi.getLbLogs(vipId, tenantId, httpClient);
//                    assertEquals(10, logsAfterLbRemove.size(), "列表应该是：[创建vip,创建tgrp1,创建tgrp2,创建lsn,更新tgrp1,更新lsn,删除tgrp1,删除lsn,更新lb,删除lb]");
//                    assertListPrefix(logsAfterLbRemove, logCreate, logTGrp1, logTGrp2, logLsn, logTGrp1Update, logLsnUpdate, logTGrp1Remove, logLbUpdate);
//                    logLbRemove = logsAfterLbRemove.get(8);
//                    assertEquals("vip_delete", logLbRemove.getOperation());
//                    assertTimestamp(deleteLbTimestamp, logLbRemove.getTimestamp(), "remove lb time is wrong");
//                    assertEquals(bodyJson.getString("Name"), logLbRemove.getData().getName());
//                }
            }

            @Override
            public void afterTest() {
                if (this.vipId != null) {
                    logger.error("the vip " + vipId + " is not deleted");
                }
            }
        });
    }
}
