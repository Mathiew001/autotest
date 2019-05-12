package com.netease.cloudqa.nlb.api.test.framework.support;

import com.netease.cloudqa.nlb.api.test.framework.info.ParallelExecuteInfo;
import com.netease.cloudqa.nlb.api.test.framework.utils.ThreadLocalUtils;

public class ParallelExecuteInfoHolder {

    private static ThreadLocal<ParallelExecuteInfo> threadVariable = new ThreadLocal<ParallelExecuteInfo>();

    static {
        ThreadLocalUtils.register(threadVariable);
    }

    public static String getTracer() {
        ParallelExecuteInfo variable = threadVariable.get();
        if (null == variable) {
            return null;
        }
        return variable.getCaseLabel();
    }

    public static void setTracer(String caseLabel) {
        ParallelExecuteInfo variable = threadVariable.get();
        if (null == variable) {
            variable = new ParallelExecuteInfo();
        }
        variable.setCaseLabel(caseLabel);
        threadVariable.set(variable);
    }
}
