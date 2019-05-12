/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.driver;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;

/**
 * 
 * @author hzzhangyan
 * @version $Id: PrepareDriver.java, v 0.1 2017-7-21 下午8:30:46 hzzhangyan Exp $
 */
public class PrepareDriver {
    protected static Logger logger = Logger.getLogger(PrepareDriver.class);

    @Parameters({ "test.env" })
    @BeforeClass
    protected void setUp(@Optional("local") String env) {
        ConfigLoader.initConfigs(env);
    }
}
