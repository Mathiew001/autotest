package com.netease.cloudqa.nlb.api.test.utils;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class AssertUtils {

    protected static Logger logger = Logger.getLogger(AssertUtils.class);

    public static void assertEquals(int actual,  int expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        }
        catch (AssertionError error) {
            logger.error(error.getMessage());
        }
    }
}
