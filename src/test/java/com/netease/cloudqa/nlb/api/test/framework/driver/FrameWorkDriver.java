/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.driver;

import static meta.CommonData.genHeaderMap;

import java.io.IOException;
import java.lang.reflect.Method;

import java.util.*;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ParallelRuntimeContext;
import meta.CommonData;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.database.DBProcessor;
import com.netease.cloudqa.nlb.api.test.framework.common.etcd.EtcdProcessor;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiProcessor;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.model.Request;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.prepare.BasePrepare;
import com.netease.cloudqa.nlb.api.test.framework.utils.G0AuthUtils;
import org.testng.annotations.Optional;

/**
 * class级别driver
 * @author hzzhangyan
 * @version $Id: FrameWorkDriver.java, v 0.1 2017-5-26 下午2:05:05 hzzhangyan Exp $
 */
public class FrameWorkDriver {

    protected static Logger logger = Logger.getLogger(FrameWorkDriver.class);
    protected static String G0_V2  = "g0_v2";
    protected static String NORMAL = "normal";

    //protected  static LogUtils logUtils = (LogUtils) LogUtils.getLogger(FrameWorkDriver.class);

    @Parameters({"env", "case-label"})
    @BeforeTest
    protected void setUp(@Optional("local") String env, @Optional("none") String caseLabel) {
        ConfigLoader.initConfigs(env);
        if (!"none".equals(caseLabel) && ParallelRuntimeContext.getCaseLabel() == null)
            ParallelRuntimeContext.setCaseLabel(caseLabel);
    }

    @AfterClass
    protected void clearUp() {

    }

    @AfterSuite
    protected void clearSuiteUp() {

    }

    @DataProvider(name = "YamlDriverDataProvider")
    public Iterator<?> getDataProvider(Method method) throws IOException {
        String yamlFileName = this.getClass().getSimpleName().replaceAll("Test", "Prepare");
        String filePath = BasePrepare.YAML_FILE_PATH + yamlFileName + "/" + yamlFileName + ".yaml";
        if (null != method.getAnnotation(Test.class)) {
            return new YamlDataProvider(filePath, method);
        } else {
            logger.error("data provider not support method without @TEST annotation");
            return null;
        }
    }

    /**
     * 执行断言的数据库比对
     * @param caseId
     */
    protected void assertDbCheck(String caseId) {
        List<String> checkInfo = this.dbCheck(caseId);
        Assert.assertEquals(checkInfo.size(), 0, checkInfo.toString());
    }

    /**
     * 不断言的数据库比对
     * @param caseId
     */
    protected List<String> dbCheck(String caseId) {
        if (ConfigLoader.configration.getCheckDb().equals("false"))
            return new ArrayList<String>();
        ParallelRuntimeContext.checkCaseHolder(caseId);
        List<String> checkInfo = DBProcessor.compareTable(ParallelRuntimeContext.getDataHolderMap().get(
            caseId).getDbExpectData());
        logger.info("dbcheck info : [" + checkInfo + "]");
        ParallelRuntimeContext.renderDbCheckInfo(caseId, checkInfo);
        return checkInfo;
    }

    /**
     * 数据库导入数据
     * 
     * @param caseId
     */
    protected void dbImport(String caseId) {
        if (ConfigLoader.configration.getImportDb().equals("false"))
            return;
        ParallelRuntimeContext.checkCaseHolder(caseId);
        DBProcessor.dbImport(ParallelRuntimeContext.getDataHolderMap().get(caseId).getDbPrepareData());
    }

    /**
     * 数据库清理数据
     * 
     * @param caseId
     */
    protected void dbClean(String caseId) {
        ParallelRuntimeContext.checkCaseHolder(caseId);
        DBProcessor.dbClean(ParallelRuntimeContext.getDataHolderMap().get(caseId).getDbExpectData());
        DBProcessor.dbClean(ParallelRuntimeContext.getDataHolderMap().get(caseId).getDbPrepareData());
    }

    /**
     * 开发接口的清理
     * 
     * @param caseId
     */
    protected void ectdHttpClean(String caseId) {
        EtcdProcessor.etcdHttpClean(ApiRuntimeContext.dataHolderMap.get(caseId)
            .getEtcdPrepareData());
        EtcdProcessor
            .etcdHttpClean(ApiRuntimeContext.dataHolderMap.get(caseId).getEtcdExpectData());
    }

    /**
     * 开发接口的比对方式
     * 
     * @param caseId
     */
    protected List<String> ectdHttpCheck(String caseId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("", e);
        }
        return EtcdProcessor.etcdHttpCheck(ApiRuntimeContext.dataHolderMap.get(caseId)
            .getEtcdExpectData());
    }

    /**
     * 开发接口的比对
     * @param caseId
     */
    protected void assertEtcdHttpCheck(String caseId) {
        List<String> checkInfo = this.ectdHttpCheck(caseId);
        Assert.assertEquals(checkInfo.size(), 0, checkInfo.toString());
    }

    /**
     * 开发接口的import
     * @param caseId
     */
    protected void etcdHttpImport(String caseId) {
        EtcdProcessor.etcdHttpImport(ApiRuntimeContext.dataHolderMap.get(caseId)
            .getEtcdPrepareData());
    }

    protected void setApiActValue(String caseId, Object value) {
        ApiProcessor.setApiActValue(caseId, value);
    }

    protected void restApiCheck(String caseId) {
        Map<String, String> checkInfo = ApiProcessor.checkApiResponse(caseId);
        Assert.assertEquals(checkInfo.size(), 0, checkInfo.toString());
    }

    /**
     *
     * ci环境
     * 账号:qa_dns_01
     * 密码:qadns01
     * @return
     */
    protected static Map<String, String> initG0User1Param() {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("WebOpenAPIHost", ConfigLoader.configration.getExtConfig("g0_address"));
            map.put("app_key", ConfigLoader.configration.getExtConfig("tenant_vpc_key"));
            map.put("app_secret", ConfigLoader.configration.getExtConfig("tenant_vpc_secret"));
            map.put("tenant_Id", ConfigLoader.configration.getExtConfig("tenant_id"));
            map.put("region", ConfigLoader.configration.getExtConfig("region"));
            CommonData.init((HashMap<String, String>) map);
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

    protected static Response sendG0Request(Request request) {
        return G0AuthUtils.V2(request.getMethod(), request.getUrl(),
            null == request.getJson() ? null : request.getJson().toString(), genHeaderMap());
    }

}
