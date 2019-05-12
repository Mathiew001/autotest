/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.driver;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.management.RuntimeErrorException;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ParallelRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.support.ParallelExecuteInfoHolder;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;
import org.yaml.snakeyaml.Yaml;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.utils.FileUtils;

/**
 *
 * @author hzzhangyan
 * @version $Id: YamlDataProvider.java, v 0.1 2017-7-5 下午2:02:57 hzzhangyan Exp $
 */
public class YamlDataProvider implements Iterator<Object[]> {

    protected static Logger   logger = Logger.getLogger(YamlDataProvider.class);

    private final Class<?>[]  driveDataTypes;

    private final Converter[] driveDataConverters;

    private String runCaseId;

    @SuppressWarnings("unchecked")
    public YamlDataProvider(String filePath, Method method) throws IOException {
        ParallelRuntimeContext.clear();
        String content = FileUtils.read(filePath, "gbk");
        Yaml yaml = new Yaml();
        Map<String, DataHolder> dataMap = (Map<String, DataHolder>) yaml.load(content);
        if (CollectionUtils.isEmpty(dataMap)) {
            throw new RuntimeErrorException(new Error("dump yaml file occurred err"));
        }
        // set runtime holder
        ParallelRuntimeContext.setDataHolderMap(dataMap);
        driveDataTypes = method.getParameterTypes();
        int len = driveDataTypes.length;
        driveDataConverters = new Converter[len];
        for (int i = 0; i < len; i++) {
            driveDataConverters[i] = ConvertUtils.lookup(driveDataTypes[i]);
        }
    }

    /**
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
        if (CollectionUtils.isEmpty(ParallelRuntimeContext.getDataHolderMap())) {
            return false;
        }

        Set<String> sets = ParallelRuntimeContext.getDataHolderMap().keySet();
        Iterator<String> itRun = sets.iterator();
        Iterator<String> itCur = sets.iterator();
        if (ParallelRuntimeContext.getCaseLabel() == null)
            return singleHasNext(itCur);
        else
            return parallelHasNext(itRun, itCur);

    }

    public boolean singleHasNext(Iterator<String> itCur) {
        if (StringUtils.isEmpty(runCaseId)) {
            return true;
        } else {
            while (itCur.hasNext()) {
                String curCaseId = itCur.next();
                if (StringUtils.equals(runCaseId, curCaseId) && itCur.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean parallelHasNext(Iterator<String> itRun, Iterator<String> itCur) {
        String caseLabel;
        String curCaseId;
        if (StringUtils.isEmpty(runCaseId)) {
            curCaseId = itCur.next();
            caseLabel = ParallelRuntimeContext.getDataHolderMap().get(curCaseId).getCaseLabel();
            while (itCur.hasNext() || caseLabel.equals(ParallelRuntimeContext.getCaseLabel())) {
                caseLabel = ParallelRuntimeContext.getDataHolderMap().get(curCaseId).getCaseLabel();
                if (caseLabel.equals(ParallelRuntimeContext.getCaseLabel()))
                    return true;
                curCaseId = itCur.next();
                runCaseId = itRun.next();
            }
            return false;
        } else {
            while (itCur.hasNext()) {
                curCaseId = itCur.next();
                itRun.next();
                if (StringUtils.equals(runCaseId, curCaseId) && itCur.hasNext()) {
                    break;
                }
            }
            if (itCur.hasNext()) {
                curCaseId = itCur.next();
                caseLabel = ParallelRuntimeContext.getDataHolderMap().get(curCaseId).getCaseLabel();
                while (itCur.hasNext() || caseLabel.equals(ParallelRuntimeContext.getCaseLabel())) {
                    if (caseLabel.equals(ParallelRuntimeContext.getCaseLabel()))
                        return true;
                    curCaseId = itCur.next();
                    runCaseId = itRun.next();
                    caseLabel = ParallelRuntimeContext.getDataHolderMap().get(curCaseId).getCaseLabel();
                }
            }
        }
        return false;
    }

    /**
     * @see java.util.Iterator#next()
     */
    @Override
    public Object[] next() {
        if (CollectionUtils.isEmpty(ParallelRuntimeContext.getDataHolderMap())) {
            throw new RuntimeErrorException(new Error("RuntimeContext dataHolderMap is empty"));
        }


        Set<String> sets = ParallelRuntimeContext.getDataHolderMap().keySet();
        Iterator<String> itRun = sets.iterator();
        Iterator<String> itCur = sets.iterator();
        if (ParallelRuntimeContext.getCaseLabel() == null)
            singleNext(itCur);
        else
            parallelNext(itRun, itCur);

        int len = driveDataTypes.length;
        Object[] data = new Object[len];
        // restful only need simple type
        DataHolder holder = ParallelRuntimeContext.getDataHolderMap().get(runCaseId);

        for (int i = 0; i < len; i++) {
            data[i] = driveDataConverters[i].convert(driveDataTypes[i], holder.getDriverUnits()
                    .get(i).getValue());
        }
        return data;
    }

    public void singleNext(Iterator<String> itCur) {
        if (StringUtils.isEmpty(runCaseId)) {
            runCaseId = itCur.next();
        } else {
            while (itCur.hasNext()) {
                String curCaseId = itCur.next();
                if (StringUtils.equals(runCaseId, curCaseId)) {
                    runCaseId = itCur.next();
                    break;
                }
            }
        }

    }

    public void parallelNext(Iterator<String> itRun, Iterator<String> itCur) {
        String caseLabel;
        String curCaseId;
        if (StringUtils.isEmpty(runCaseId)) {
            curCaseId = itCur.next();
            caseLabel = ParallelRuntimeContext.getDataHolderMap().get(curCaseId).getCaseLabel();
            while (itCur.hasNext() || caseLabel.equals(ParallelRuntimeContext.getCaseLabel())) {
                caseLabel = ParallelRuntimeContext.getDataHolderMap().get(curCaseId).getCaseLabel();
                if (caseLabel.equals(ParallelRuntimeContext.getCaseLabel())) {
                    runCaseId = curCaseId;
                    break;
                }
                curCaseId = itCur.next();
                runCaseId = itRun.next();
            }
        } else {
            while (itCur.hasNext()) {
                curCaseId = itCur.next();
                itRun.next();
                if (StringUtils.equals(runCaseId, curCaseId)) {
                    break;
                }
            }
            if (itCur.hasNext()) {
                curCaseId = itCur.next();
                caseLabel = ParallelRuntimeContext.getDataHolderMap().get(curCaseId).getCaseLabel();
//                String a = FrameWorkDriver.csLabel;
                while (itCur.hasNext() || caseLabel.equals(ParallelRuntimeContext.getCaseLabel())) {
                    caseLabel = ParallelRuntimeContext.getDataHolderMap().get(curCaseId).getCaseLabel();
                    if (caseLabel.equals(ParallelRuntimeContext.getCaseLabel())) {
                        runCaseId = curCaseId;
                        break;
                    }
                    curCaseId = itCur.next();
                    runCaseId = itRun.next();
                }
            }
        }
    }

    /**
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove() {
    }

    /**
//     * @see java.util.Iterator#forEachRemaining(java.util.function.Consumer)
     */

}
