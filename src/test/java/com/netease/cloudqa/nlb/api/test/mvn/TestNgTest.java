/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.mvn;

import java.util.Arrays;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 
 * @author hzzhangyan
 * @version $Id: TestNgTest.java, v 0.1 2018-5-18 下午7:30:03 hzzhangyan Exp $
 */
@Test
public class TestNgTest {

    @Parameters("test.env")
    public void test(String abc) {
        System.out.println("++" + abc);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList("[aa,bb]"));
    }

}
