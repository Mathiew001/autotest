/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.prepare;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;
import org.yaml.snakeyaml.Yaml;

import com.netease.cloudqa.nlb.api.test.framework.annotation.CaseLabel;
import com.netease.cloudqa.nlb.api.test.framework.annotation.PrepareDescription;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.driver.PrepareDriver;
import com.netease.cloudqa.nlb.api.test.framework.utils.FileUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: BasePrepare.java, v 0.1 2017-7-4 下午4:32:08 hzzhangyan Exp $
 */
public class BasePrepare extends PrepareDriver {

    protected static Logger                                 logger               = Logger.getLogger(BasePrepare.class);

    protected Map<String /*caseId*/, DataHolder /*args*/>   argsMap;

    public String                                           clazzName;

    // source folder of test file path
    public static String                                    BASE_FILE_PATH       = "src/test/resources/tester";

    // yaml file path
    public static String                                    YAML_FILE_PATH       = "src/test/resources/tester/yaml/";

    // drive file path
    public static String                                    TEST_DRIVE_FILE_PATH = "";

    // yaml file
    public static String                                    TEST_DRIVE_FILE      = "";

    @org.testng.annotations.Test
    public void executePrepare() {
        // dir:"src/test/resources/tester"
        File baseDir = new File(BASE_FILE_PATH);
        if (!baseDir.isDirectory()) {
            baseDir.mkdir();
        }

        // dir:"src/test/resources/tester/yaml/"
        File yamlDir = new File(YAML_FILE_PATH);
        if (!yamlDir.isDirectory()) {
            yamlDir.mkdir();
        }

        // dir:"src/test/resources/tester/yaml/$clazzName/"
        clazzName = this.getClass().getSimpleName();
        TEST_DRIVE_FILE_PATH = YAML_FILE_PATH + clazzName;
        File clzYamlDir = new File(TEST_DRIVE_FILE_PATH);
        if (!clzYamlDir.isDirectory()) {
            clzYamlDir.mkdir();
        }

        // yaml file
        TEST_DRIVE_FILE = TEST_DRIVE_FILE_PATH + "/" + clazzName + ".yaml";
        File yamlFile = new File(TEST_DRIVE_FILE);
        if (!yamlFile.isFile()) {
            try {
                yamlFile.createNewFile();
            } catch (IOException e) {
                logger.error("create file path err......", e);
            }
        }

        // reflect invoke
        Method[] methods = this.getClass().getDeclaredMethods();
        argsMap = new HashMap<String, DataHolder>();

        for (Method method : methods) {
            PrepareDescription preDec = method.getAnnotation(PrepareDescription.class);
            // 不存在PrepareDescription说明注解的
            if (null == preDec) {
                continue;
            }

            CaseLabel labels = method.getAnnotation(CaseLabel.class);
            String caseLabel = null;
            if (null != labels)
                caseLabel = labels.lbType()[0];
            if (preDec.isPrepareMethod() && labelMatching(labels)) {
                try {
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        System.out.println("error");
                    }
                    DataHolder dataHolder = (DataHolder) method.invoke(this);
                    dataHolder.setCaseLabel(caseLabel);
                    argsMap.put(method.getName(), dataHolder);
                } catch (IllegalAccessException e) {
                    logger.error("IllegalAccessException", e);
                } catch (IllegalArgumentException e) {
                    logger.error("IllegalArgumentException", e);
                } catch (InvocationTargetException e) {
                    logger.error("InvocationTargetException", e);
                }
            }
        }

        // save
        try {
            FileUtils.write(TEST_DRIVE_FILE, new Yaml().dump(argsMap), "gbk");
        } catch (IOException e) {
            logger.error("dump yaml file err", e);
        }
        logger.info("======================================================================");
        logger.info("[" + this.getClass().getSimpleName() + "] 加载用例个数:" + argsMap.size());
        logger.info("======================================================================");
    }

    /**
     * 
     * @param labels
     * @return
     */
    private boolean labelMatching(CaseLabel labels) {
        // 1. 方法上没有label标签,不进过滤用例
        if (null == labels) {
            return true;
        }
        Set<Entry<Object, Object>> sets = ConfigLoader.configration.getLabelConfig();
        // 2. config配置项为空,不进行标签过滤
        if (CollectionUtils.isEmpty(sets)) {
            return true;
        }

        int matchCnt = 0;
        // 3. 标签项用例过滤(只对定义标签做处理)
        for (Entry<Object, Object> entry : sets) {
            String confValue = (String) entry.getValue();
            if (StringUtils.isEmpty(confValue)) {
                throw new RuntimeException("[标签格式不合法],label.conf禁止空置配置项[" + (String) entry.getKey()
                                           + "=\"\"]");
            }
            boolean ruleMatching = false;
            boolean hasMethod = false;
            for (Method method : labels.getClass().getMethods()) {
                String invokeMethod = com.netease.cloudqa.nlb.api.test.framework.utils.StringUtils
                    .lineToHump((String) entry.getKey());
                if (StringUtils.equals(method.getName(), invokeMethod)) {
                    Object invokerObj = null;
                    hasMethod = true;
                    try {
                        invokerObj = method.invoke(labels);
                    } catch (Exception e) {
                        throw new RuntimeException("invoker方法异常", e);
                    }

                    // 方法没有声明该标签,不进行过滤
                    if (StringUtils.contains(invokerObj.toString(), "0xffffffffffffffff")) {
                        ruleMatching = true;
                    } else if (invokerObj instanceof String[]) {
                        String[] methodStrs = (String[]) invokerObj;
                        String[] confStrs = StringUtils.split(confValue, ",");
                        ruleMatching = com.netease.cloudqa.nlb.api.test.framework.utils.StringUtils
                            .contains(confStrs, methodStrs);
                    } else if (invokerObj instanceof String) {
                        ruleMatching = StringUtils.equals((String) invokerObj, confValue);
                    } else {
                        throw new RuntimeException("Label枚举返回类型只允许String和String[]不支持");
                    }
                }
            }

            if (!hasMethod) {
                throw new RuntimeException("Label注解方法未定义[" + (String) entry.getKey() + "]");
            }
            // 文件定义
            if (ruleMatching) {
                matchCnt++;
            }
        }

        return sets.size() == matchCnt;
    }
}
