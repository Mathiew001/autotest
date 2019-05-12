package com.netease.cloudqa.nlb.api.test.framework.common.runtime;

import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.utils.ThreadLocalUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParallelRuntimeContext {

    private static ThreadLocal<Map<String /*caseId*/, DataHolder /*DataHolder*/>> dataHolderMapInfos  = new ThreadLocal<Map<String, DataHolder>>();

    private static ThreadLocal<Map<String /*caseId*/, List<String>/*DBCheckInfo*/>> dbCheckInfoMapInfos = new ThreadLocal<Map<String, List<String>>>();

    private static ThreadLocal<String> caseLabelInfos = new ThreadLocal<String>();

    public static Map<String, DataHolder> getDataHolderMap() {
        Map<String, DataHolder> dataHolderMap = dataHolderMapInfos.get();
        if (null == dataHolderMap || dataHolderMap.isEmpty())
            return null;
        return dataHolderMap;
    }

    public static void setDataHolderMap(Map<String, DataHolder> dataHolderMap) {
        dataHolderMapInfos.set(dataHolderMap);
    }

    public static String getCaseLabel() {
        String csLabel = caseLabelInfos.get();
        if (null == csLabel) {
            return null;
        }
        return csLabel;
    }

    public static void setCaseLabel(String caseLabel) {
        caseLabelInfos.set(caseLabel);
    }

    static {
        ThreadLocalUtils.register(caseLabelInfos);
        ThreadLocalUtils.register(dataHolderMapInfos);
        ThreadLocalUtils.register(dataHolderMapInfos);
    }


    public static DataHolder fetchHolder(String caseId) {
        Map<String, DataHolder> dataHolderMap = dataHolderMapInfos.get();
        if (CollectionUtils.isEmpty(dataHolderMap)) {
            return null;
        }
        return dataHolderMap.get(caseId);
    }

    public static void clear() {
        Map<String, DataHolder> dataHolderMap = dataHolderMapInfos.get();
        Map<String, List<String>> dbCheckInfoMap = dbCheckInfoMapInfos.get();
        dataHolderMap = null;
        dbCheckInfoMap = null;
        ParallelRuntimeContext.CaseContext.clear();
    }

    public static void renderDbCheckInfo(String caseId, List<String> checkInfo) {
        Map<String, List<String>> dbCheckInfoMap = dbCheckInfoMapInfos.get();
        if (null == dbCheckInfoMap) {
            dbCheckInfoMap = new HashMap<String, List<String>>();
        }
        dbCheckInfoMap.put(caseId, checkInfo);
    }

    public static void checkCaseHolder(String caseId) {
        Map<String, DataHolder> dataHolderMap = dataHolderMapInfos.get();
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

        private static ThreadLocal<List<DataUnit>> parametersInfos = new ThreadLocal<List<DataUnit>>();

        public static void addPrameter(DataUnit unit) {
            List<DataUnit> parameters = parametersInfos.get();
            if (parameters == null) {
                parameters = new ArrayList<DataUnit>();
            }
            parameters.add(unit);
        }

        public static Object getPrameters() {
            List<DataUnit> parameters = parametersInfos.get();
            return parameters;
        }

        public static Object getPrameter(String name) {
            List<DataUnit> parameters = parametersInfos.get();
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
            List<DataUnit> parameters = parametersInfos.get();
            if (parameters == null) {
                parameters = new ArrayList<DataUnit>();
            }
            parameters.add(new DataUnit(key, value));
        }

        public static void clear() {
            List<DataUnit> parameters = parametersInfos.get();
            parameters = null;
        }

    }



}
