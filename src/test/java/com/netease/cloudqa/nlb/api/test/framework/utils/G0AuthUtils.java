package com.netease.cloudqa.nlb.api.test.framework.utils;

import com.AuthUtilV1;
import com.AuthUtilV2;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import utils.meta.HttpClientResponse;

import java.util.HashMap;
import java.util.Map;

public class G0AuthUtils {
    /**
     *
     *
     * @param service
     * @param input
     * @param payload
     * @param method
     * @return
     */
    public static Response V1(String service, HashMap<String, String> input, String payload,
                              String method) {
        Response resp = new Response();
        try {
            HttpClientResponse respG0 = AuthUtilV1.getResponse(service, input, payload, method);
            resp.setCode(respG0.getStatusCode());
            resp.setHtml(respG0.getResponseBody());
        } catch (Exception e) {
            throw new RuntimeException("G0网关V1认证错误");
        }

        return resp;
    }

    /**
     *
     *
     * @param method
     * @param url
     * @param payload
     * @param headerMap
     * @return
     */
    public static Response V2(String method, String url, String payload,
                              Map<String, String> headerMap) {
        Response resp = new Response();
        try {
            HttpClientResponse respG0 = AuthUtilV2.getResponse(method, url, payload, headerMap);
            resp.setCode(respG0.getStatusCode());
            resp.setHtml(respG0.getResponseBody());
        } catch (Exception e) {
            throw new RuntimeException("G0网关V2认证错误", e);
        }

        return resp;
    }
}
