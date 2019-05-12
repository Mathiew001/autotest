/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.constant;

/**
 * 
 * @author hzzhangyan
 * @version $Id: ParamConstant.java, v 0.1 2017-7-22 下午6:47:40 hzzhangyan Exp $
 */
public class ParamConstant {

    // 匹配$param$,从用例上下文get
    public static String GET_PARAM_REG = "\\$\\w+\\$";

    // 匹配$=param$,set到用例上下文
    public static String SET_PARAM_REG = "\\$=\\w+\\$";

    // 匹配$=param$,set到用例上下文
    public static String DOLLAR_MARK   = "$";

    /********************************************上下文参数常量******************************************/
    public static String SOURCE_PARAM_ = "source_";

    public static String DEST_PARAM_   = "dest_";

}
