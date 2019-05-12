/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hzzhangyan
 * @version $Id: CaseLabel.java, v 0.1 2018-5-26 下午7:55:25 hzzhangyan Exp $
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CaseLabel {

    String[] lbType() default {"vpc_mix"};

    String dbImport() default "0xffffffffffffffff";

    String dbCheck() default "0xffffffffffffffff";
}
