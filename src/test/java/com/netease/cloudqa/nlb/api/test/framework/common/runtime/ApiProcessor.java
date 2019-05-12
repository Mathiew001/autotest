/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.runtime;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.utils.JSONCompareUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: ApiProcessor.java, v 0.1 2017-11-9 上午9:49:29 hzzhangyan Exp $
 */
public class ApiProcessor {

    /**
     * 单表比对
     * @param tableDta
     * @return
     */
    public static void setApiActValue(String caseId, Object value) {
        DataHolder holder = ParallelRuntimeContext.fetchHolder(caseId);
        if (holder == null) {
            throw new RuntimeException("set api actual value err");
        }

        if (value instanceof JSON) {
            holder.setApiActRespData((JSON) value);
        }

        if (value instanceof String) {
            holder.setApiActRespData(JSONObject.parseObject((String) value));
        }
        return;
    }

    /**
     * 
     * @param caseId
     * @return
     */
    public static Map<String, String> checkApiResponse(String caseId) {
        return JSONCompareUtils.JSONCompare(ParallelRuntimeContext.fetchHolder(caseId)
            .getApiActRespData(), ParallelRuntimeContext.fetchHolder(caseId).getApiExpRespData(), null);
    }
}
