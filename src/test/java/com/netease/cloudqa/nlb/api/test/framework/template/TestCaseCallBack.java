/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.template;

/**
 * 
 * @author hzzhangyan
 * @version $Id: TestCaseCallBack.java, v 0.1 2017-5-10 下午4:58:34 hzzhangyan Exp $
 */
public interface TestCaseCallBack {

    /**
     * 测试的准备,通常包含：
     * 1. 数据库准备数据
     * 2. 入参构造(通过驱动文件构造入参)、
     * 3. 构造接口mock信息
     * 4. 切换环境信息
     */
    void beforeTest();

    /**
     * 测试执行的过程,通常包含：
     * 1. 执行一次接口调用
     * 2. 对接口调用校验点进行校验(数据库期望数据、消息期望、返回值期望)
     */
    void executeTest();

    /**
     * 测试执行后的结果,通常包含：
     * 1. 清理数据库准备数据
     * 2. 清理数据库期望数据
     * 3. 入参赋值null
     * 4. mock接口赋值null
     * 5. 环境复原
     */
    void afterTest();
}
