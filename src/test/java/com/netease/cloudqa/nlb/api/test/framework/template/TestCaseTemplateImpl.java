/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.template;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ParallelRuntimeContext;
import org.apache.log4j.Logger;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import org.apache.log4j.NDC;

/**
 * 
 * @author hzzhangyan
 * @version $Id: TestCaseTemplateImpl.java, v 0.1 2017-5-10 下午5:07:12 hzzhangyan Exp $
 */
public class TestCaseTemplateImpl implements TestCaseTemplate {

    private static final Logger logger = Logger.getLogger(TestCaseTemplateImpl.class);

    /** 
     * @see com.netease.push.server.sdk.framework.template.TestCaseTemplate#process(java.lang.String, com.netease.push.server.sdk.framework.template.TestCaseCallBack)
     */
    @Override
    public void process(String caseId, TestCaseCallBack callBack) {
        logger.info(".......caseId:[" + caseId + "] start.......");
        ParallelRuntimeContext.CaseContext.clear();
        NDC.clear();
        NDC.push(caseId);
        try {
            callBack.beforeTest();
            callBack.executeTest();
        } finally {
            callBack.afterTest();
        }
        ParallelRuntimeContext.CaseContext.clear();
        NDC.clear();
        logger.info(".......caseId:[" + caseId + "] end.......");

    }
}
