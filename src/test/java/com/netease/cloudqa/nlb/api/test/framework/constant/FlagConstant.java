/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.constant;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: FlagConstant.java, v 0.1 2017-6-23 下午12:13:13 hzzhangyan Exp $
 */
public class FlagConstant {

    // 数据库select的key
    public static final String C               = "C";

    // 需要比对
    public static final String Y               = "Y";

    // 忽略比对
    public static final String N               = "N";

    // 正则比对
    public static final String R               = "R";

    // 时间比对
    public static final String D               = "D";

    // 数据库PK
    public static final String P               = "P";

    // 自定义函数
    public static final String F               = "F";

    // 分割包含
    public static final String SPLIT_CONTAIN   = "SPLIT_CONTAIN";

    // 整形比对
    public static final String INT             = "INT";

    //  布尔值比对
    public static final String BOOLEAN         = "BOOLEAN";

    // 整形比对
    public static final String BIGINT          = "BIGINT";

    // 长整型比对
    public static final String LONG            = "LONG";

    // 当前时间
    public static final String NOW             = "now()";

    // unix时间戳
    public static final String UNIX_TIMESTAP   = "UNIX_TIMESTAMP()";

    // 上下文透传参数比对
    public static final String PARAM           = "PARAM";

    // C_AND_PARAM
    public static final String C_AND_PARAM     = "C_AND_PARAM";

    // expect包含actual
    public static final String EXP_CONTAIN_ACT = "EXP_CONTAIN_ACT";

    // actual包含expect
    public static final String ACT_CONTAIN_EXP = "ACT_CONTAIN_EXP";

    // 目前只支持这些
    public static boolean checkFlag(String flag) {
        if (StringUtils.isEmpty(flag)) {
            return false;
        }
        return Y.equals(flag) || N.equals(flag) || R.equals(flag) || flag.startsWith(D)
               || C.equals(flag) || F.equals(flag) || P.equals(flag) || INT.equals(flag)
               || LONG.equals(flag) || BIGINT.equals(flag) || PARAM.equals(flag)
               || EXP_CONTAIN_ACT.equals(flag) || ACT_CONTAIN_EXP.equals(flag) || BOOLEAN.equals(flag)
               || C_AND_PARAM.equals(flag) || SPLIT_CONTAIN.equals(flag) || flag.startsWith(UNIX_TIMESTAP);
    }
}
