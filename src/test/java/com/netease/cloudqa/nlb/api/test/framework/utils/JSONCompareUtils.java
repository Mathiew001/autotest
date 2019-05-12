/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.constant.ParamConstant;
import com.netease.cloudqa.nlb.api.test.framework.constant.StrictJsonCompareConsts;

/**
 * 
 * @author hzzhangyan
 * @version $Id: JsonCompareUtils.java, v 0.1 2017-6-23 上午9:40:35 hzzhangyan Exp $
 */
public class JSONCompareUtils {

    protected static Logger     logger           = Logger.getLogger(JSONCompareUtils.class);

    private final static String LAYER_SPLIT      = ".";

    private final static String COMPARISON_ARROW = "<--->";

    private final static String LBRACKET         = "[";

    private final static String RBRACKET         = "]";

    /**
     * 
     * 
     * @param source
     * @param dest
     * @param infos
     * @param diffs
     * @return
     */
    public static Map<String, String> JSONCompare(JSON source, JSON dest, Map<String, String> infos) {
        Map<String, String> diffs = new HashMap<String, String>();
        if (source instanceof JSONObject && dest instanceof JSONObject) {
            diffs.putAll(JSONObjectCompare((JSONObject) source, (JSONObject) dest, infos, null));
            //diffs.putAll(JSONObjectCompare((JSONObject) dest, (JSONObject) source, infos, null));
        } else if (source instanceof JSONArray && dest instanceof JSONArray) {
            diffs.putAll(JSONArrayCompare((JSONArray) source, (JSONArray) dest, infos, null));
            //            diffs.putAll(JSONArrayCompare((JSONArray) dest, (JSONArray) source, infos, null));
        } else {
            diffs.put("root", (source + COMPARISON_ARROW + dest));
        }

        return diffs;
    }

    /**
     * 
     * 
     * @param source
     * @param dest
     * @param infos
     * @param diffs
     * @return
     */
    private static Map<String, String> JSONObjectCompare(JSONObject source, JSONObject dest,
                                                         Map<String, String> infos, String upperKey) {
        Map<String, String> diffs = new HashMap<String, String>();

        // 1.source和dest都为null
        if (null == source && null == dest) {
            return diffs;
        }

        // 2.source和dest一个为null一个不为null
        if (null == source ^ null == dest) {
            diffs.put(upperKey, (source + COMPARISON_ARROW + dest));
            return diffs;
        }

        // 3. 都不为空比对
        for (Entry<String, Object> set : source.entrySet()) {
            String srcKey = set.getKey();
            String curKey = StringUtils.isBlank(upperKey) ? srcKey : upperKey + LAYER_SPLIT
                                                                     + srcKey;
            Object srcObj = set.getValue();
            Object destObj = dest.get(srcKey);

            if (null == srcObj && null == destObj) {
                continue;
            }

            // 2.source和dest一个为null一个不为null
            if (null == srcObj ^ null == destObj) {
                diffs.put(curKey, (srcObj + COMPARISON_ARROW + destObj));
                continue;
            }

            if (srcObj instanceof JSONObject && destObj instanceof JSONObject) {
                diffs.putAll(JSONObjectCompare((JSONObject) srcObj, (JSONObject) destObj, infos,
                    curKey));
            } else if (srcObj instanceof JSONArray && destObj instanceof JSONArray) {
                diffs.putAll(JSONArrayCompare((JSONArray) srcObj, (JSONArray) destObj, infos,
                    curKey));
            } else if (StringUtils
                .equals(srcObj.getClass().getName(), destObj.getClass().getName())) {
                diffs.putAll(basicTypeCompare(srcObj, destObj, infos, curKey));
            } else {
                diffs.put(curKey, (srcObj + COMPARISON_ARROW + destObj));
            }
        }

        return diffs;
    }

    /**
     * 
     * 
     * @param source
     * @param dest
     * @param infos
     * @return
     */
    private static Map<String, String> JSONArrayCompare(JSONArray source, JSONArray dest,
                                                        Map<String, String> infos, String upperKey) {
        Map<String, String> diffs = new HashMap<String, String>();

        // 1.source和dest都为null
        if (null == source && null == dest) {
            return diffs;
        }

        // 2.source和dest一个为null一个不为null
        if (null == source ^ null == dest) {
            diffs.put(upperKey, (source + COMPARISON_ARROW + dest));
            return diffs;
        }

        // 3. 都不为空比对
        if (source.size() != dest.size()) {
            diffs.put(upperKey, "数量不相等：" + source + COMPARISON_ARROW + dest);
            return diffs;
        }

        for (Object srcObj : source) {
            int i = 0;
            boolean hasEqual = false;
            for (Object destObj : dest) {
                int diffCnt = 0;
                if (srcObj instanceof JSONObject && destObj instanceof JSONObject) {
                    diffCnt = JSONObjectCompare((JSONObject) srcObj, (JSONObject) destObj, infos,
                        upperKey).size();
                } else if (srcObj instanceof JSONArray && destObj instanceof JSONArray) {
                    diffCnt = JSONArrayCompare((JSONArray) srcObj, (JSONArray) destObj, infos,
                        upperKey).size();
                } else {
                    diffCnt = basicTypeCompare(srcObj, destObj, infos, upperKey).size();
                }
                if (diffCnt == 0) {
                    hasEqual = true;
                }
            }
            if (!hasEqual) {
                diffs.put(upperKey + LAYER_SPLIT + LBRACKET + String.valueOf(i) + RBRACKET,
                    srcObj.toString() + "找不到等值对象");
            }
            i++;
        }

        return diffs;
    }

    /**
     * json基本数据类型比对
     * 
     * @param source
     * @param dest
     * @param infos
     * @param diffs
     * @return
     */
    private static Map<String, String> basicTypeCompare(Object source, Object dest,
                                                        Map<String, String> infos, String upperKey) {
        Map<String, String> diffs = new HashMap<String, String>();

        String condition = null == infos ? null : infos.get(upperKey);

        // 1. N
        if (StringUtils.equals(condition, StrictJsonCompareConsts.N)) {
            return diffs;
        }

        // 2. PARAM_WITH_COMPARE
        if (StringUtils.equals(condition, StrictJsonCompareConsts.PARAM_WITH_COMPARE)) {
            ApiRuntimeContext.CaseContext.put(ParamConstant.SOURCE_PARAM_ + upperKey, source);
            ApiRuntimeContext.CaseContext.put(ParamConstant.DEST_PARAM_ + upperKey, dest);
        }

        // 3. PARAM_WITH_NO_COMPARE
        if (StringUtils.equals(condition, StrictJsonCompareConsts.PARAM_WITH_NO_COMPARE)) {
            ApiRuntimeContext.CaseContext.put(ParamConstant.SOURCE_PARAM_ + upperKey, source);
            ApiRuntimeContext.CaseContext.put(ParamConstant.DEST_PARAM_ + upperKey, dest);
            return diffs;
        }

        if (source == null ^ dest == null) {
            diffs.put(upperKey, (source + COMPARISON_ARROW + dest));
            return diffs;
        }

        // 4. Integer
        if (source instanceof Integer && dest instanceof Integer) {
            int srcInt = ((Integer) source).intValue();
            int destInt = ((Integer) dest).intValue();

            if (StringUtils.contains(condition, StrictJsonCompareConsts.DEVIATION_INT))
            // 整形比对-误差比对
            {
                Integer expectDev = Integer.valueOf(StringUtils.replace(condition,
                    StrictJsonCompareConsts.DEVIATION_INT, ""));
                if (Math.abs(srcInt - destInt) >= expectDev.intValue()) {
                    diffs.put(upperKey, "误差大于预期:" + source + COMPARISON_ARROW + dest);
                } else {
                    return diffs;
                }
            } else
            // 整形比对-正常比对 
            {
                if (srcInt != destInt) {
                    diffs.put(upperKey, "值不等:" + source + COMPARISON_ARROW + dest);
                } else {
                    return diffs;
                }
            }
        }

        // String
        if (source instanceof String && dest instanceof String) {
            if (!StringUtils.equals((String) source, (String) dest)) {
                diffs.put(upperKey, "值不等:" + source + COMPARISON_ARROW + dest);
            } else {
                return diffs;
            }
        }
        // DATE
        return diffs;
    }

    public static void main(String[] args) {
        JSONObject src = JSONObject
            .parseObject("{\"code\":200,\"query\":{\"device_id\":\"test1.163.com-11DFFB97-2F49-4442-B416-69BE3BFEDD\",\"domain\":\"test1.163.com\",\"platform\":\"iOS\",\"sub_platform\":\"android\",\"product_version\":\"1.1.1\",\"third_party_id\":\"f6d9c6f25bd7b7ac63c7c79557dcbf64b91c0480758836db5e00bdc31f6cfecd\",\"alias\":null,\"user\":\"abc1\",\"topic_mask\":null}}");

        JSONObject dest = JSONObject
            .parseObject("{\"code\":201,\"query\":{\"device_id\":\"test1.163.com-11DFFB97-2F49-4442-B416-69BE3BFEDD\",\"domain\":\"test1.163.com\",\"platform\":\"iOS\",\"sub_platform\":\"android\",\"product_version\":\"1.1.1\",\"third_party_id\":\"f6d9c6f25bd7b7ac63c7c79557dcbf64b91c0480758836db5e00bdc31f6cfecd\",\"alias\":null,\"user\":\"abc1\"}}");

        System.out.println(JSONObjectCompare(src, dest, null, null));

    }
}
