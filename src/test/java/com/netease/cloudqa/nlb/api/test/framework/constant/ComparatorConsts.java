/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.constant;

/**
 * 
 * @author hzzhangyan
 * @version $Id: ComparatorConsts.java, v 0.1 2017-9-7 下午3:30:12 hzzhangyan Exp $
 */
public class ComparatorConsts {

    /**
     * 简单比对:测试框架第一版的比对方式,如未指明比对方式为CompareTypeConstant中的其他比对方式,默认走简单比对方式,支持部分比对类型上下文透传
     */
    public static final String SIMPLE_COMPARE      = "SIMPLE_COMPARE";

    /**
     * 严格的数据库比对：
     * 1.关系型数据库中的数据比对方式,支持数据库所有类型的比对
     * 2.支持时间、整形、长整型的误差比对
     * 3.支持所有比对类型上下文透传
     */
    public static final String STRICT_DB_COMPARE   = "STRICT_DB_COMPARE";

    /**
     * 严格的Json比对：
     * 1.JSON格式的数据比对方式,支持所有Json子类型的比对
     * 2.同时支持时间、整形、长整型的误差比对
     * 3.支持所有比对类型上下文透传
     * {@link com.netease.cloudqa.dns.api.test.framework.constant.StrictJsonCompareConst}
     */
    public static final String STRICT_JSON_COMPARE = "STRICT_JSON_COMPARE";

}
