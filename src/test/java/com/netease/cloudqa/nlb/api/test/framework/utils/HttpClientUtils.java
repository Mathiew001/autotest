/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.model.Request;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;

/**
 * 支持Content-Type：
 * 1. application/x-www-form-urlencoded
 * 2. application/json
 * 
 * @author hzzhangyan
 * @version $Id: HttpClientUtils.java, v 0.1 2017-6-14 上午9:33:39 hzzhangyan Exp $
 */
public class HttpClientUtils {

    protected static Logger logger = Logger.getLogger(HttpClientUtils.class);

    public Response sendRequest(Request req) {

        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(req.getSslContext());
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf)
            .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)).build();

        HttpRequestBase sendRequest = null;
        if (req.isPostMethod()) {

            sendRequest = convt2HttpPost(req.getUrl(), req.getHeaders(), req.getParams());
        }

        if (req.isGetMethod()) {
            sendRequest = convt2HttpGet(req.getUrl(), req.getHeaders(), req.getParams());
        }

        if (req.isDeleteMethod()) {
            sendRequest = convt2HttpDelete(req.getUrl(), req.getHeaders(), req.getParams());
        }

        if (req.isPutMethod()) {
            sendRequest = convt2HttpPut(req.getUrl(), req.getHeaders(), req.getParams());
        }

        HttpResponse response = null;
        Response retResp = null;
        try {
            response = httpclient.execute(sendRequest, req.getHttpClientContext());

            retResp = convt2Response(response);
        } catch (ClientProtocolException e) {
            logger.error("httpclient execute fail ClientProtocolException", e);
        } catch (IOException e) {
            logger.error("httpclient execute fail IOException", e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // http上下文
        retResp.setHttpClientContext(req.getHttpClientContext());
        return retResp;
    }

    /**
     * 
     * @param url
     * @param headers
     * @param params
     * @return
     */
    private HttpRequestBase convt2HttpPut(String url, Map<String, String> reqHeaders,
                                          Map<String, String> reqParams) {
        HttpPut httpPut = new HttpPut(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(120000)
            .setConnectTimeout(120000).setSocketTimeout(120000).build();
        httpPut.setConfig(requestConfig);
        Map<String, String> headers = new HashMap<String, String>();
        if (StringUtils.isBlank(reqHeaders.get("Content-Type"))) {
            headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        }
        headers.put("X-Requested-With", "XMLHttpRequest");
        if (!CollectionUtils.isEmpty(reqHeaders)) {
            headers.putAll(reqHeaders);
        }

        if (!CollectionUtils.isEmpty(headers)) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpPut.addHeader(header.getKey(), header.getValue());
            }
        }

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (!CollectionUtils.isEmpty(reqParams)) {
            for (Map.Entry<String, String> entry : reqParams.entrySet()) {
                String name = entry.getKey();
                try {
                    String value = URLDecoder.decode(StringUtils.trimToEmpty(entry.getValue()),
                        "GBK");
                    params.add(new BasicNameValuePair(name, value));
                } catch (UnsupportedEncodingException e) {
                    logger.error("NameValuePair[" + name + "," + entry.getValue() + "] decode err",
                        e);
                }
            }
        }

        try {
            httpPut.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("httpost entity set fail", e);
        }

        return httpPut;
    }

    /**
     * 
     * @param url
     * @param headers
     * @param params
     * @return
     */
    private HttpRequestBase convt2HttpDelete(String url, Map<String, String> reqHeaders,
                                             Map<String, String> reqParams) {
        HttpDelete httpDelete = new HttpDelete(url);

        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(120000)
            .setConnectTimeout(120000).setSocketTimeout(120000).build();
        httpDelete.setConfig(requestConfig);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=GBK");
        headers.put("X-Requested-With", "XMLHttpRequest");
        if (reqHeaders.size() > 0) {
            headers.putAll(reqHeaders);
        }

        if (!CollectionUtils.isEmpty(reqHeaders)) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpDelete.addHeader(header.getKey(), header.getValue());
            }
        }

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (!CollectionUtils.isEmpty(reqParams)) {
            for (Map.Entry<String, String> entry : reqParams.entrySet()) {
                String name = entry.getKey();
                try {
                    String value = URLDecoder.decode(StringUtils.trimToEmpty(entry.getValue()),
                        "GBK");
                    params.add(new BasicNameValuePair(name, value));
                } catch (UnsupportedEncodingException e) {
                    logger.error("NameValuePair[" + name + "," + entry.getValue() + "] decode err",
                        e);
                }
            }
        }

        if (params.size() > 0) {
            httpDelete.setURI(URI.create(url + "?" + URLEncodedUtils.format(params, "GBK")));
        }

        return httpDelete;
    }

    /**
     * 
     * @param response
     * @return
     */
    private Response convt2Response(HttpResponse response) {
        if (null == response) {
            return null;
        }

        Response ret = new Response();
        ret.setHeaders(convertHeader2Map(response.getAllHeaders()));

        ret.setCode(response.getStatusLine().getStatusCode());

        if (response.getStatusLine().getStatusCode() == 302) {
            String location = getRedirectLocation(response);
            ret.setRedirectLocation(location);
        } else {
            String resultStr = paserResponse(response);
            ret.setHtml(resultStr);
        }

        return ret;
    }

    /**
     * 
     * @param allHeaders
     * @return
     */
    private Map<String, String> convertHeader2Map(Header[] headers) {
        if (headers == null) {
            return null;
        }
        Map<String, String> headerMap = new HashMap<String, String>();
        for (int i = 0; i < headers.length; i++) {
            Header head = headers[i];
            headerMap.put(head.getName(), head.getValue());
        }
        return headerMap;
    }

    private static String paserResponse(HttpResponse response) {
        HttpEntity entity = response.getEntity();
        String body = null;
        try {
            //            StringBuffer sb = new StringBuffer();
            //            byte[] b = new byte[1024];
            //            int len = 0;
            //            while ((len = entity.getContent().read(b)) != -1) {
            //                sb.append(new String(b, 0, len, "UTF-8"));
            //            }
            //            body = sb.toString();
            if (null == entity) {
                return null;
            }
            body = EntityUtils.toString(entity, "UTF-8");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    private static String getRedirectLocation(HttpResponse response) {
        String redirectUrl = null;
        Header locationHeader = response.getFirstHeader("Location");
        if (null == locationHeader) {
            return redirectUrl;
        }
        redirectUrl = locationHeader.getValue();

        if (redirectUrl.contains(":443")) {
            redirectUrl = redirectUrl.replace(":443", "");
        }
        return redirectUrl;
    }

    /**
     * 
     * @param url
     * @param headers
     * @param params
     * @return
     */
    private HttpRequestBase convt2HttpPost(String url, Map<String, String> reqHeaders,
                                           Map<String, String> reqParams) {
        HttpPost httpost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(120000)
            .setConnectTimeout(120000).setSocketTimeout(120000).build();
        httpost.setConfig(requestConfig);
        Map<String, String> headers = new HashMap<String, String>();
        if (StringUtils.isBlank(reqHeaders.get("Content-Type"))) {
            headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        }
        headers.put("X-Requested-With", "XMLHttpRequest");
        if (!CollectionUtils.isEmpty(reqHeaders)) {
            headers.putAll(reqHeaders);
        }

        if (!CollectionUtils.isEmpty(headers)) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpost.addHeader(header.getKey(), header.getValue());
            }
        }

        // 非x-www-form-urlencoded
        if (!StringUtils
            .contains(headers.get("Content-Type"), "application/x-www-form-urlencoded;")) {
            httpost.setEntity(new StringEntity(JSON.toJSONString(reqParams), headers
                .get("Content-Type")));
        }

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (!CollectionUtils.isEmpty(reqParams)) {
            for (Map.Entry<String, String> entry : reqParams.entrySet()) {
                String name = entry.getKey();
                try {
                    String value = URLDecoder.decode(StringUtils.trimToEmpty(entry.getValue()),
                        "GBK");
                    params.add(new BasicNameValuePair(name, value));
                } catch (UnsupportedEncodingException e) {
                    logger.error("NameValuePair[" + name + "," + entry.getValue() + "] decode err",
                        e);
                }
            }
        }

        try {
            httpost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("httpost entity set fail", e);
        }

        return httpost;
    }

    /**
     * 
     * @param string
     * @param headers
     * @param params
     * @return
     */
    private HttpRequestBase convt2HttpGet(String url, Map<String, String> reqHeaders,
                                          Map<String, String> reqParams) {
        HttpGet httpGet = null;
        try {
            URL urlSrc = new URL(url);
            URI uri = new URI(urlSrc.getProtocol(), null, urlSrc.getHost(), urlSrc.getPort(),
                urlSrc.getPath(), urlSrc.getQuery(), null);
            httpGet = new HttpGet(uri);
        } catch (Exception e) {
            logger.error("URL Or URI Exception", e);
        }

        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(120000)
            .setConnectTimeout(120000).setSocketTimeout(120000).build();
        httpGet.setConfig(requestConfig);

        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=GBK");
        headers.put("X-Requested-With", "XMLHttpRequest");
        if (reqHeaders.size() > 0) {
            headers.putAll(reqHeaders);
        }

        if (!CollectionUtils.isEmpty(reqHeaders)) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpGet.addHeader(header.getKey(), header.getValue());
            }
        }

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (!CollectionUtils.isEmpty(reqParams)) {
            for (Map.Entry<String, String> entry : reqParams.entrySet()) {
                String name = entry.getKey();
                try {
                    String value = URLDecoder.decode(StringUtils.trimToEmpty(entry.getValue()),
                        "GBK");
                    params.add(new BasicNameValuePair(name, value));
                } catch (UnsupportedEncodingException e) {
                    logger.error("NameValuePair[" + name + "," + entry.getValue() + "] decode err",
                        e);
                }
            }
        }

        if (params.size() > 0) {
            httpGet.setURI(URI.create(url + "?" + URLEncodedUtils.format(params, "GBK")));
        }

        return httpGet;
    }

    public Response sendJsonRequest(Request req) {
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(req.getSslContext());
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf)
            .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)).build();

        HttpRequestBase sendRequest = null;
        if (req.isPostMethod()) {
            sendRequest = convt2JsonPost(req.getUrl(), req.getHeaders(), req.getJson());
        }

        if (req.isGetMethod()) {
            sendRequest = convt2JsonGet(req.getUrl(), req.getHeaders(), req.getJson());
        }

        if (req.isPutMethod()) {
            sendRequest = convt2JsonPut(req.getUrl(), req.getHeaders(), req.getJson());
        }

        if (req.isDeleteMethod()) {
            sendRequest = convt2JsonDel(req.getUrl(), req.getHeaders(), req.getJson());
        }

        HttpResponse response = null;
        Response retResp = null;
        try {
            response = httpclient.execute(sendRequest, req.getHttpClientContext());
            retResp = convt2Response(response);
        } catch (ClientProtocolException e) {
            logger.error("httpclient execute fail ClientProtocolException", e);
        } catch (IOException e) {
            logger.error("httpclient execute fail IOException", e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // http上下文
        retResp.setHttpClientContext(req.getHttpClientContext());
        return retResp;
    }

    /**
     * 
     * @param url
     * @param headers
     * @param JSON
     * @return
     */
    private HttpRequestBase convt2JsonDel(String url, Map<String, String> reqHeaders, JSON json) {
        HttpDelete httpDelete = new HttpDelete(url);

        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(120000)
            .setConnectTimeout(120000).setSocketTimeout(120000).build();
        httpDelete.setConfig(requestConfig);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json; charset=UTF-8");
        headers.put("X-Requested-With", "XMLHttpRequest");
        if (reqHeaders.size() > 0) {
            headers.putAll(reqHeaders);
        }

        if (!CollectionUtils.isEmpty(reqHeaders)) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpDelete.addHeader(header.getKey(), header.getValue());
            }
        }

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (null != json && json instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) json;
            for (Entry<String, Object> entry : jsonObject.entrySet()) {
                String name = entry.getKey();
                try {
                    String value = URLDecoder.decode(
                        StringUtils.trimToEmpty(entry.getValue().toString()), "GBK");
                    params.add(new BasicNameValuePair(name, value));
                } catch (UnsupportedEncodingException e) {
                    logger.error("NameValuePair[" + name + "," + entry.getValue() + "] decode err",
                        e);
                }
            }
        }

        if (params.size() > 0) {
            httpDelete.setURI(URI.create(url + "?" + URLEncodedUtils.format(params, "GBK")));
        }

        return httpDelete;
    }

    /**
     * 
     * @param url
     * @param headers
     * @param JSON
     * @return
     */
    private HttpRequestBase convt2JsonPut(String url, Map<String, String> reqHeaders, JSON json) {
        HttpPut httpPut = new HttpPut(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(120000)
            .setConnectTimeout(120000).setSocketTimeout(120000).build();
        httpPut.setConfig(requestConfig);
        Map<String, String> headers = new HashMap<String, String>();
        if (StringUtils.isBlank(reqHeaders.get("Content-Type"))) {
            headers.put("Content-Type", "application/json; charset=UTF-8");
        }
        headers.put("X-Requested-With", "XMLHttpRequest");
        if (!CollectionUtils.isEmpty(reqHeaders)) {
            headers.putAll(reqHeaders);
        }

        if (!CollectionUtils.isEmpty(headers)) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpPut.addHeader(header.getKey(), header.getValue());
            }
        }

        httpPut.setEntity(new StringEntity(json.toJSONString(), "UTF-8"));

        return httpPut;
    }

    /**
     * 
     * @param url
     * @param headers
     * @param JSON
     * @return
     */
    private HttpRequestBase convt2JsonGet(String url, Map<String, String> reqHeaders, JSON json) {
        HttpGet httpGet = new HttpGet(url);

        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(120000)
            .setConnectTimeout(120000).setSocketTimeout(120000).build();
        httpGet.setConfig(requestConfig);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json; charset=UTF-8");
        headers.put("X-Requested-With", "XMLHttpRequest");
        if (reqHeaders.size() > 0) {
            headers.putAll(reqHeaders);
        }

        if (!CollectionUtils.isEmpty(reqHeaders)) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpGet.addHeader(header.getKey(), header.getValue());
            }
        }

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (null != json && json instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) json;
            for (Entry<String, Object> entry : jsonObject.entrySet()) {
                String name = entry.getKey();
                try {
                    String value = URLDecoder.decode(
                        StringUtils.trimToEmpty(entry.getValue().toString()), "GBK");
                    params.add(new BasicNameValuePair(name, value));
                } catch (UnsupportedEncodingException e) {
                    logger.error("NameValuePair[" + name + "," + entry.getValue() + "] decode err",
                        e);
                }
            }
        }

        if (params.size() > 0) {
            httpGet.setURI(URI.create(url + "?" + URLEncodedUtils.format(params, "GBK")));
        }

        return httpGet;
    }

    /**
     * 
     * @param url
     * @param headers
     * @param JSON
     * @return
     */
    private HttpRequestBase convt2JsonPost(String url, Map<String, String> reqHeaders, JSON JSON) {
        HttpPost httpost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(120000)
            .setConnectTimeout(120000).setSocketTimeout(120000).build();
        httpost.setConfig(requestConfig);
        Map<String, String> headers = new HashMap<String, String>();
        if (StringUtils.isBlank(reqHeaders.get("Content-Type"))) {
            headers.put("Content-Type", "application/json; charset=UTF-8");
        }
        headers.put("X-Requested-With", "XMLHttpRequest");
        if (!CollectionUtils.isEmpty(reqHeaders)) {
            headers.putAll(reqHeaders);
        }

        if (!CollectionUtils.isEmpty(headers)) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpost.addHeader(header.getKey(), header.getValue());
            }
        }

        httpost.setEntity(new StringEntity(JSON.toJSONString(), "UTF-8"));

        return httpost;
    }

}
