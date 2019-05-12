/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.constant;

/**
 * 
 * @author hzzhangyan
 * @version $Id: StrictJsonCompareConsts.java, v 0.1 2017-9-7 下午3:45:25 hzzhangyan Exp $
 */
public class StrictJsonCompareConsts {

    // 不进行比对
    public static final String N                     = "N";

    /********************************************基本数据类型********************************************/
    // 整形
    public static final String INT                   = "INT";

    // 浮点型
    public static final String FLOAT                 = "FLOAT";

    // 长整型
    public static final String LONG                  = "LONG";

    // 字符型
    public static final String STRING                = "STRING";

    // 空对象
    public static final String NULL                  = "NULL";

    // JSON数组
    public static final String JSON_ARRAY            = "JSON_ARRAY";

    // JSON对象
    public static final String JSON_OBJECT           = "JSON_OBJECT";

    /********************************************误差数据类型********************************************/

    // 整形误差,误差范围在常量后拼接,如10的误差,DEVIATION_INT_10
    public static final String DEVIATION_INT         = "DEVIATION_INT_";

    // 浮点误差,误差范围在常量后拼接,如0.03的误差,DEVIATION_FLOAT_0.03
    public static final String DEVIATION_FLOAT       = "DEVIATION_FLOAT_";

    // 长整型误差,误差范围在常量后拼接,如300L的误差,DEVIATION_FLOAT_300L
    public static final String DEVIATION_LONG        = "DEVIATION_LONG_";

    // 时间误差,误差范围在常量后拼接,如500ms的误差,DEVIATION_DATE_500
    public static final String DEVIATION_DATE        = "DEVIATION_DATE_";

    /********************************************参数放入上下文,********************************************/
    // 放上下文,并进行比对
    public static final String PARAM_WITH_COMPARE    = "PARAM_WITH_COMPARE";

    // 放上下文,但不比对
    public static final String PARAM_WITH_NO_COMPARE = "PARAM_WITH_NO_COMPARE";

}
