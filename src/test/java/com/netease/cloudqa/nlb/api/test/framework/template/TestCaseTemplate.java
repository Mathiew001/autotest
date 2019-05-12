/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.template;

/**
 * 单个测试用例执行模板
 * @author hzzhangyan
 * @version $Id: TestCaseTemplate.java, v 0.1 2017-5-10 下午4:56:28 hzzhangyan Exp $
 */
public interface TestCaseTemplate {

    void process(String caseId, TestCaseCallBack callBack);

}
