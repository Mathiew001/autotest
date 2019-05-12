/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.mvn;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.ITestNGMethod;
import org.testng.TestRunner;
import org.testng.internal.Configuration;
import org.testng.internal.IInvoker;
import org.testng.internal.Invoker;
import org.testng.internal.TestNGMethod;
import org.testng.internal.annotations.DefaultAnnotationTransformer;
import org.testng.internal.annotations.JDK15AnnotationFinder;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 * 
 * @author hzzhangyan
 * @version $Id: TestNgMethod.java, v 0.1 2018-5-28 下午9:42:11 hzzhangyan Exp $
 */
public class TestNgMethod {

    public static void main(String[] args) {
        //        boolean t = false;
        //        System.out.println(((Object) t).getClass().getTypeName());
        Method javaMethod = null;
        try {
            javaMethod = TestNgTest.class.getMethod("test", String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ITestNGMethod method = new TestNGMethod(javaMethod, new JDK15AnnotationFinder(
            new DefaultAnnotationTransformer()), new XmlTest(), null);
        IInvoker invoker = new Invoker(new Configuration(), new TestRunner(null, null, null, false,
            null), null, null, false, null);
        invoker.invokeTestMethods(method, new ITestNGMethod[] { method }, 0, new XmlSuite(),
            new HashMap<String, String>(), null, null, null);
    }
}
