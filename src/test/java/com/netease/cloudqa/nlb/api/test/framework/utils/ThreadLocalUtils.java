/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hzzhangyan
 * @version $Id: ThreadLocalUtils.java, v 0.1 2017-5-26 下午2:33:28 hzzhangyan Exp $
 */
public class ThreadLocalUtils {
    private static List<ThreadLocal<?>> tls = new ArrayList<ThreadLocal<?>>();

    public static void clear() {
        for (ThreadLocal<?> tl : tls) {
            tl.remove();
        }
    }

    /**
     * 注册线程变量。
     * @param tl
     */
    public static void register(ThreadLocal<?> tl) {
        synchronized (tls) {
            tls.add(tl);
        }
    }
}
