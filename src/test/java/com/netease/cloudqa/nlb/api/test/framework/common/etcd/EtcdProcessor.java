/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.etcd;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;
import com.netease.cloudqa.nlb.api.test.framework.constant.ParamConstant;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.utils.EtcdUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.PatternUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: EtcdProcessor.java, v 0.1 2017-7-21 下午7:47:47 hzzhangyan Exp $
 */
public class EtcdProcessor {

    protected static Logger logger = Logger.getLogger(EtcdProcessor.class);

    /**
     * 
     * @param etcdPrepareData
     */
    public static void etcdHttpClean(List<DataUnit> etcdPrepareData) {
        if (!CollectionUtils.isEmpty(etcdPrepareData)) {
            for (DataUnit etcd : etcdPrepareData) {
                EtcdUtils.remove(etcd.getName());
            }
        } else {
            logger.warn("[empty etcd import list , etcd clean ignored]");
        }
    }

    /**
     * 
     * @param etcdExpectData
     */
    public static List<String> etcdHttpCheck(List<DataUnit> etcdExpectData) {
        List<String> checkInfos = new ArrayList<String>();
        if (!CollectionUtils.isEmpty(etcdExpectData)) {
            for (DataUnit etcd : etcdExpectData) {
                String checkInfo = simpleCompare(etcd);
                if (!StringUtils.isEmpty(checkInfo)) {
                    checkInfos.add(checkInfo + "\n");
                }
            }
        } else {
            logger.warn("[empty etcd check list , etcd check ignored]");
        }
        return checkInfos;
    }

    /**
     * ectd基本存储成json方式,json强比对上之前,暂时用simple compare
     * @param etcd
     * @return
     */
    private static String simpleCompare(DataUnit etcd) {
        String flag = etcd.getFlag();
        if (!FlagConstant.checkFlag(flag)) {
            return "flag[" + flag + "], etcd fail, flagIllegal :[" + flag + "]";
        }

        try {

            String replaceName = etcd.getName();
            String replaceValue = etcd.getValue().toString();

            if (StringUtils.contains(etcd.getName().toString(), ParamConstant.DOLLAR_MARK)
                || StringUtils.contains(etcd.getValue().toString(), ParamConstant.DOLLAR_MARK)) {

                // name has get
                if (PatternUtils.find(etcd.getName().toString(), ParamConstant.GET_PARAM_REG)) {
                    String key = PatternUtils.extractByReg(etcd.getName().toString(),
                        ParamConstant.GET_PARAM_REG);
                    Object ctxParam = ApiRuntimeContext.CaseContext.getPrameter(key);
                    if (null == ctxParam) {
                        return "flag[" + flag + "], etcd fail, use key :[" + key
                               + "] find null objet in contxt ";
                    }
                    replaceName = StringUtils.replace(etcd.getName().toString(), key,
                        ctxParam.toString());
                    etcd.setName(replaceName);
                } else {
                    replaceName = etcd.getName();
                }

                // value has get
                if (PatternUtils.find(etcd.getValue().toString(), ParamConstant.GET_PARAM_REG)) {
                    String key = PatternUtils.extractByReg(etcd.getValue().toString(),
                        ParamConstant.GET_PARAM_REG);
                    Object ctxParam = ApiRuntimeContext.CaseContext.getPrameter(key);
                    if (null == ctxParam) {
                        return "flag[" + flag + "], etcd fail, use key :[" + key
                               + "] find null objet in contxt ";
                    }
                    replaceValue = StringUtils.replace(etcd.getValue().toString(), key,
                        ctxParam.toString());
                    etcd.setValue(replaceValue);
                } else {
                    replaceValue = etcd.getValue().toString();
                }
            }

            String actVal = EtcdUtils.getValue(replaceName);

            if (StringUtils.equals(flag, FlagConstant.Y)) {
                String expectVal = etcd.getValue().toString();
                if (StringUtils.equals(expectVal, actVal)) {
                    return null;
                } else {
                    return "flag[" + flag + "], expect[" + expectVal + "] while actual [" + actVal
                           + "]";
                }
            }

            if (StringUtils.equals(flag, FlagConstant.ACT_CONTAIN_EXP)) {
                String expectVal = etcd.getValue().toString();
                if (StringUtils.contains(actVal, expectVal)) {
                    return null;
                } else {
                    return "flag[" + flag + "], expect[" + expectVal + "] while actual [" + actVal
                           + "]";
                }
            }

            if (StringUtils.equals(flag, FlagConstant.EXP_CONTAIN_ACT)) {
                String expectVal = etcd.getValue().toString();
                if (StringUtils.contains(expectVal, actVal)) {
                    return null;
                } else {
                    return "flag[" + flag + "], expect[" + expectVal + "] while actual [" + actVal
                           + "]";
                }
            }

            return "flag[" + flag + "], etcd do no check , etcd :[" + etcd + "]";

        } catch (Exception e) {
            e.printStackTrace();
            return "flag[" + flag + "], etcd check happen Exception: etcd :[" + etcd + "]";
        }

    }

    /**
     * 
     * @param etcdPrepareData
     */
    public static void etcdHttpImport(List<DataUnit> etcdPrepareData) {
        if (!CollectionUtils.isEmpty(etcdPrepareData)) {
            for (DataUnit etcd : etcdPrepareData) {
                EtcdUtils.put(etcd.getName(), etcd.getValue().toString());
            }
        } else {
            logger.warn("[empty import check list , etcd check ignored]");
        }
    }

}
