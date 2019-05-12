/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;

/**
 * 
 * API运行的上下文,主要保存:
 * 1. 执行类从yaml或csv文件dump出的数据,存入DataHolderMap
 * 2. 执行类在运行数据库比对过程中的比对信息
 * 
 * 注：
 * 1. 为避免执行下一个测试类带入前一个类上下文信息,在类运行完成后调用clear方法清理上下文
 * 
 * @note 后续如需做测试平台,管控每个方法运行时信息，可扩展RuntimeContext成interface,保存至testNg的ThreadLocal
 * @author hzzhangyan
 * @version $Id: ApiRuntimeContext.java, v 0.1 2017-6-22 下午4:01:40 hzzhangyan Exp $
 */
public class ApiRuntimeContext {

    public static Map<String /*caseId*/, DataHolder /*DataHolder*/>   dataHolderMap  = null;

    public static Map<String /*caseId*/, List<String>/*DBCheckInfo*/> dbCheckInfoMap = null;

    public static DataHolder fetchHolder(String caseId) {
        if (CollectionUtils.isEmpty(dataHolderMap)) {
            return null;
        }
        return dataHolderMap.get(caseId);
    }

    public static void clear() {
        dataHolderMap = null;
        dbCheckInfoMap = null;
        CaseContext.clear();
    }

    public static void renderDbCheckInfo(String caseId, List<String> checkInfo) {
        if (null == dbCheckInfoMap) {
            dbCheckInfoMap = new HashMap<String, List<String>>();
        }
        dbCheckInfoMap.put(caseId, checkInfo);
    }

    public static void checkCaseHolder(String caseId) {
        if (CollectionUtils.isEmpty(dataHolderMap)) {
            throw new RuntimeException("caseId:[" + caseId + " ] has dataHolderMap ");
        }

        DataHolder holder = dataHolderMap.get(caseId);
        if (null == holder) {
            throw new RuntimeException("caseId:[" + caseId + "] dataHolder not exits");
        }
    }

    // 用例运行上下文
    public static class CaseContext {

        private static List<DataUnit> parameters;

        public static void addPrameter(DataUnit unit) {
            if (parameters == null) {
                parameters = new ArrayList<DataUnit>();
            }
            parameters.add(unit);
        }

        public static Object getPrameters() {
            return parameters;
        }

        public static Object getPrameter(String name) {
            if (CollectionUtils.isEmpty(parameters)) {
                return null;
            }

            for (DataUnit param : parameters) {
                if (StringUtils.equals(name, param.getName())) {
                    return param.getValue();
                }
            }
            return null;
        }

        public static void put(String key, Object value) {
            if (parameters == null) {
                parameters = new ArrayList<DataUnit>();
            }
            parameters.add(new DataUnit(key, value));
        }

        public static void clear() {
            parameters = null;
        }

    }

}
