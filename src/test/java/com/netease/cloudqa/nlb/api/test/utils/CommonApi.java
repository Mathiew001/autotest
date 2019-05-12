/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.netease.cloudqa.nlb.api.test.model.LbLog;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import com.netease.cloudqa.nlb.api.test.model.TargetGroup;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import org.testng.Assert;

import javax.security.auth.login.Configuration;

/**
 *
 * @author chentianyu1
 * @version $Id: CommonApi.java, v 0.1 Apr 27, 2018 5:58:27 PM chentianyu1 Exp $
 */
public class CommonApi {

    protected static Logger logger = Logger.getLogger(CommonApi.class);

    private static final String K8SVERSION = "1.3";

    //openApi url
    private static String urlGetLb = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=GetLoadBalancer&Version=2017-12-05";

    private static String urlGetLbs = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=GetLoadBalancers&Version=2017-12-05";

    private static String urlDelLb = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=DeleteLoadBalancer&Version=2017-12-05";

    private static String urlCreateLb = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=CreateLoadBalancer&Version=2017-12-05";

    private static String urlUpdateLb = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=UpdateLoadBalancer&Version=2017-12-05";

    private static String urlUpdateLbSpec  = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=UpdateLoadBalancerSpec&Version=2017-12-05";

    private static String urlCheckLb  = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=CheckLoadBalancerParams&Version=2017-12-05";

    private static String urlRenewOrder = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=RenewOrder&Version=2017-12-05";

    private static String urlCreateTg = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=CreateTargetGroup&Version=2017-12-05";

    private static String urlDelTg = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=DeleteTargetGroup&Version=2017-12-05";

    private static String urlUpdateTg = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=UpdateTargetGroup&Version=2017-12-05";

    private static String urlUpdateTgInstance = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=UpdateTGInstance&Version=2017-12-05";

    private static String urlRegisterTGInstance = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=RegisterTGInstance&Version=2017-12-05";

    private static String urlDeregisterTGInstance = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=DeregisterTGInstance&Version=2017-12-05";

    private static String urlCreateLn = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=CreateLBListener&Version=2017-12-05";

    private static String urlDelLn = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=DeleteLBListener&Version=2017-12-05";

    private static String urlUpdateLn = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=UpdateLBListener&Version=2017-12-05";

    private static String urlGetUserQuota = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=GetUserQuota&Version=2017-12-05";

    private static String urlGetResourcePools = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=DescribeResourcePools&Version=2017-12-05";

    //openApi ingress url
    private static String urlGetLbIng = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=GetLoadBalancer&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    private static String urlGetLbsIng = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=GetLoadBalancers&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    private static String urlCreateLbIng = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=CreateLoadBalancer&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    private static String urlDelLbIng = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=DeleteLoadBalancer&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    private static String urlCheckLbIng = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=CheckLoadBalancerParams&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    private static String urlUpdateLbIng = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=UpdateLoadBalancer&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    private static String urlUpdateLbSpecIng = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=UpdateLoadBalancerSpec&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    private static String urlRenewOrderIng = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=RenewOrder&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    private static String urlCreateLnIng = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=CreateLBListener&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    private static String urlDelLnIng  = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=DeleteLBListener&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    private static String urlUpdateLnIng = ConfigLoader.configration.getHttpUrlIngress() + "/ing?Action=UpdateLBListener&Version=2017-12-05&K8sVersion=" + K8SVERSION;

    //adminApi url
    private static String urlDelAdmin = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=DeleteLoadBalancer&Version=2017-12-05";

    private static String urlDelAdminIng = ConfigLoader.configration.getHttpAdminIngress() + "/internaling?Action=DeleteLoadBalancer&Version=2017-12-05";

    private static String urlUpdateArrearageStatus = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=UpdateArrearageStatus&Version=2017-12-05";

    private static String urlNotSatisfyRunningCondition = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=NotSatisfyRunningCondition&Version=2017-12-05";

    private static String urlSatisfyRunningCondition = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=SatisfyRunningCondition&Version=2017-12-05";

    private static String urlDataReservedTimeOut = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=DataReservedTimeOut&Version=2017-12-05";

    private static String urlUpdateArrearageStatusIng = ConfigLoader.configration.getHttpAdminIngress() + "/internaling?Action=UpdateArrearageStatus&Version=2017-12-05";

    private static String urlNotSatisfyRunningConditionIng = ConfigLoader.configration.getHttpAdminIngress() + "/internaling?Action=NotSatisfyRunningCondition&Version=2017-12-05";

    private static String urlSatisfyRunningConditionIng = ConfigLoader.configration.getHttpAdminIngress() + "/internaling?Action=SatisfyRunningCondition&Version=2017-12-05";

    private static String urlDataReservedTimeOutIng = ConfigLoader.configration.getHttpAdminIngress() + "/internaling?Action=DataReservedTimeOut&Version=2017-12-05";

    private static String urlSearchLoadBAlancerIng = ConfigLoader.configration.getHttpAdminIngress() + "/internaling?Action=SearchLoadBalancer&Version=2017-12-05";

    private static String urlGetLbAdmin = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=GetLoadBalancer&Version=2017-12-05";

    private static String urlSearchLb = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=SearchLoadBalancer&Version=2017-12-05";

    private static String urlSearchIp = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=SearchIp&Version=2017-12-05";

    private static String urlGetLbsAdmin = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=GetLoadBalancers&Version=2017-12-05";

    private static String urlGetLbCounts = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=GetLoadBalancerCounts&Version=2017-12-05";

    private static String urlAddServer = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=AddServer&Version=2017-12-05";

    private static String urlDelServer = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=DeleteServer&Version=2017-12-05";

    private static String urlUpdateUserQuota = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=UpdateUserQuota&Version=2017-12-05";

    private static String urlUpdateLbQuota = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=UpdateLoadBalancerQuota&Version=2017-12-05";

    private static String urlDeregisterTGInstanceByTenant = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=DeregisterTGInstanceByTenant&Version=2017-12-05";

    private static String urlGetLbsByVPCIng = ConfigLoader.configration.getHttpAdminIngress() + "/internaling?Action=GetLoadBalancersByVPC&Version=2017-12-05";

    private static String urlUpdateUserQuotaIng = ConfigLoader.configration.getHttpAdminIngress() + "/internaling?Action=UpdateUserQuota&Version=2017-12-05";

    private static String urlUpdateLbAttrs = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=UpdateLoadBalancerAttrs&Version=2017-12-05";

    private static String urlGetSysInfo = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=GetSysInfo&Version=2017-12-05";

    private static String urlUpdateConfig = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=UpdateConfig&Version=2017-12-05";

    private static String urlAddConfig = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=AddConfig&Version=2017-12-05";

    private static String urlGetSysConfig = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=GetSysConfig&Version=2017-12-05";

    private static String urlGetIps = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=GetIps&Version=2017-12-05";

    private static String urlAddIps = ConfigLoader.configration.getHttpAdmin() + "/internalnlb?Action=AddIps&Version=2017-12-05";

    //jifeiApi url
    private static String urlCreateOrder = ConfigLoader.configration.getExtConfig("url_jifei") + "/order?Action=CreatePurchaseOrder&Version=2017-12-28";

    private static String urlCreateUpdateOrder = ConfigLoader.configration.getExtConfig("url_jifei") + "/order?Action=CreateModifyStandardOrder&Version=2017-12-28";

    private static String urlPayOrder = ConfigLoader.configration.getExtConfig("url_jifei") + "/order?Action=PayOrder&Version=2017-12-28";
                                                   
    //other api
    private static String urlCreateCert = ConfigLoader.configration.getHttpUrl() + "/api/v1.0/certificate";

    private static String urlGetCertificates = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=GetCertificates&Version=2017-12-05";

    private static String urlDelCertificate = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=DeleteCertificate&Version=2017-12-05";

    private static String urlDelLb1 = ConfigLoader.configration.getHttpUrl() + "/api/v1.0/loadbalancers/";

    private static String urlDelLb2 = ConfigLoader.configration.getHttpUrl() + "/api/v2.0/loadbalancers/";

    private static String urlDelLbAdmin1 = ConfigLoader.configration.getHttpUrl() + "/admin/v1.0/loadbalancers/";

    private static String urlDelCertSsl = ConfigLoader.configration.getExtConfig("url_ssl") + "/ssl?Action=DeleteCert&Version=2017-11-16";

    private static String urlFetchCertificate = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=FetchCertificate&Version=2017-12-05";

    private static String urlUploadCert = ConfigLoader.configration.getExtConfig("url_ssl") + "/ssl?Action=UploadCert&Version=2017-11-16";

    private static String urlGetKeys = ConfigLoader.configration.getExtConfig("url_kssl") + "/api/v1.0/keys";

    private static String urlCreateKeys= ConfigLoader.configration.getExtConfig("url_kssl") + "/api/v1.0/keys";

    private static String urlDelKeys= ConfigLoader.configration.getExtConfig("url_kssl") + "/api/v1.0/keys";

    private static String urlGetKey= ConfigLoader.configration.getExtConfig("url_kssl") + "/admin/v1.0/keys";

    private static String urlGetKeyStore= ConfigLoader.configration.getExtConfig("url_kssl") + "/admin/v1.0/keystores";

    private static String urlGetVipLogs = ConfigLoader.configration.getHttpUrl() + "/nlb?Action=GetVipLogs&Version=2017-12-05";

    //openApi invoked
    public static Response getLoadBalancersByVPC(Map<String, String> headers, HttpClientUtils httpClient, String vpcId){
        return SendReqUtils.sendReq(urlGetLbsByVPCIng + "&VpcId=" + vpcId,
                headers, httpClient, SendReqUtils.GET, "SearchLoadBalancersByVPCID");
    }

    public static Response searchLoadBalancer(Map<String, String> headers, HttpClientUtils httpClient, String key){
        return SendReqUtils.sendReq(urlSearchLoadBAlancerIng + "&Key=" + key,
                headers, httpClient, SendReqUtils.GET, "SearchLoadBalancer");
    }

    public static Response updateUserQuotaIng(Map<String, String> headers, HttpClientUtils httpClient, String TenantId, int limit){
        return SendReqUtils.sendReq(urlUpdateUserQuotaIng + "&TenantId=" + TenantId + "&Limit=" + Integer.toString(limit),
                headers, httpClient, SendReqUtils.GET, "updateUserQuota");
    }

//    public static Response getUserQuota(Map<String, String> headers, HttpClientUtils httpClient, String TenantId){
//        return SendReqUtils.sendReq(urlGetUserQuota + "&TenantId=" + TenantId, headers, httpClient,
//                SendReqUtils.GET, "getUserQuota");
//    }

    public static Response getLbDetail(Map<String, String> headers, HttpClientUtils httpClient,
                                       String instanceId) {
        return SendReqUtils.sendReq(urlGetLb + "&InstanceId=" + instanceId, headers, httpClient,
            SendReqUtils.GET, "getLbDetail");
    }

    public static Response getLbDetailAdmin(Map<String, String> headers, HttpClientUtils httpClient,
                                            String instanceId) {
        return SendReqUtils.sendReq(urlGetLbAdmin + "&InstanceId=" + instanceId, headers, httpClient,
                SendReqUtils.GET, "getLbDetailAdmin");
    }

    public static Response getLbDetailIng(Map<String, String> headers, HttpClientUtils httpClient,
                                          String instanceId) {
        if (headers.containsKey("Namespace"))
            headers.remove("Namespace");
        return SendReqUtils.sendReq(urlGetLbIng + "&InstanceId=" + instanceId, headers, httpClient,
            SendReqUtils.GET, "getLbDetailIng");
    }

    public static Response getLbs(Map<String, String> headers, HttpClientUtils httpClient,
                                  String type, String limit, String offset) {
        return SendReqUtils.sendReq(urlGetLbs + "&Type=" + type + "&Limit=" + limit + "&Offset="
                                    + offset, headers, httpClient, SendReqUtils.GET, "getLbs");
    }

    public static Response getLbsIng(Map<String, String> headers, HttpClientUtils httpClient, String limit, String offset) {
        return SendReqUtils.sendReq(urlGetLbsIng  + "&Limit=" + limit + "&Offset="
                + offset, headers, httpClient, SendReqUtils.GET, "getLbsIng");
    }

    public static Response getResourcePools(Map<String, String> headers, HttpClientUtils httpClient,
                                  String tentantId) {
        return SendReqUtils.sendReq(urlGetResourcePools + "&TenantId=" + tentantId, headers,
                httpClient, SendReqUtils.GET, "getResourcePools");
    }

    public static Response deleteLb(Map<String, String> headers, HttpClientUtils httpClient,
                                    String instanceId) {
        return SendReqUtils.sendReq(urlDelLb + "&InstanceId=" + instanceId, headers, httpClient,
            SendReqUtils.GET, "deleteLb");
    }

    public static Response deleteLb1(Map<String, String> headers, HttpClientUtils httpClient,
                                    String instanceId) {
        return SendReqUtils.sendReq(urlDelLb1 + instanceId + "?freeIp=true", headers, httpClient,
                SendReqUtils.DEL, "deleteLb v1.0");
    }

    public static Response deleteLb2(Map<String, String> headers, HttpClientUtils httpClient,
                                     String instanceId) {
        return SendReqUtils.sendReq(urlDelLb2 + instanceId + "?freeIp=true", headers, httpClient,
                SendReqUtils.DEL, "deleteLb v2.0");
    }

    public static Response deleteLbAdmin1(Map<String, String> headers, HttpClientUtils httpClient,
                                     String instanceId) {
        return SendReqUtils.sendReq(urlDelLbAdmin1 + instanceId, headers, httpClient,
                SendReqUtils.DEL, "deleteLb v1.0 admin");
    }

    public static Response deleteLbIng(Map<String, String> headers, HttpClientUtils httpClient,
                                       String instanceId) {
        return SendReqUtils.sendReq(urlDelLbIng + "&InstanceId=" + instanceId, headers, httpClient,
            SendReqUtils.GET, "deleteLbIng");
    }

    public static Response deleteLbAdmin(Map<String, String> headers, HttpClientUtils httpClient,
                                         String instanceId) {
        return SendReqUtils.sendReq(urlDelAdmin + "&InstanceId=" + instanceId, headers, httpClient,
            SendReqUtils.GET, "deleteLbAdmin");
    }

    public static Response deleteLbIngAdmin(Map<String, String> headers, HttpClientUtils httpClient, String instanceId) {
        return SendReqUtils.sendReq(urlDelAdminIng + "&InstanceId=" + instanceId, headers, httpClient,
                SendReqUtils.GET, "deleteLbIngAdmin");
    }

    public static Response updateArrearageStatus(Map<String, String> headers, HttpClientUtils httpClient,
                                                 String instanceId, String type) {
        Response res = SendReqUtils.sendReq(urlUpdateArrearageStatus + "&InstanceId=" + instanceId + "&Type=" + type, headers, httpClient,
                SendReqUtils.GET, "updateArrearageStatus");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return res;
    }

    public static Response notSatisfyRunningCondition(Map<String, String> headers, HttpClientUtils httpClient,
                                                 String tenantId, String instanceId) {
        Response res = SendReqUtils.sendReq(urlNotSatisfyRunningCondition + "&TenantId=" + tenantId + "&InstanceId=" + instanceId, headers, httpClient,
                SendReqUtils.GET, "notSatisfyRunningCondition");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return res;
    }

    public static Response satisfyRunningCondition(Map<String, String> headers, HttpClientUtils httpClient,
                                                      String tenantId, String instanceId) {
        Response res = SendReqUtils.sendReq(urlSatisfyRunningCondition + "&TenantId=" + tenantId + "&InstanceId=" + instanceId, headers, httpClient,
                SendReqUtils.GET, "satisfyRunningCondition");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return res;
    }

    public static Response dataReservedTimeOut(Map<String, String> headers, HttpClientUtils httpClient,
                                                   String tenantId, String instanceId) {
        Response res = SendReqUtils.sendReq(urlDataReservedTimeOut + "&TenantId=" + tenantId + "&InstanceId=" + instanceId, headers, httpClient,
                SendReqUtils.GET, "dataReservedTimeOut");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return res;
    }

    public static Response notSatisfyRunningConditionIng(Map<String, String> headers, HttpClientUtils httpClient,
                                                      String tenantId, String instanceId) {
        Response res = SendReqUtils.sendReq(urlNotSatisfyRunningConditionIng + "&TenantId=" + tenantId + "&InstanceId=" + instanceId, headers, httpClient,
                SendReqUtils.GET, "urlNotSatisfyRunningConditionIng");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return res;
    }

    public static Response satisfyRunningConditionIng(Map<String, String> headers, HttpClientUtils httpClient,
                                                   String tenantId, String instanceId) {
        Response res = SendReqUtils.sendReq(urlSatisfyRunningConditionIng + "&TenantId=" + tenantId + "&InstanceId=" + instanceId, headers, httpClient,
                SendReqUtils.GET, "satisfyRunningConditionIng");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return res;
    }

    public static Response dataReservedTimeOutIng(Map<String, String> headers, HttpClientUtils httpClient,
                                               String tenantId, String instanceId) {
        Response res = SendReqUtils.sendReq(urlDataReservedTimeOutIng + "&TenantId=" + tenantId + "&InstanceId=" + instanceId, headers, httpClient,
                SendReqUtils.GET, "dataReservedTimeOutIng");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return res;
    }

    public static Response updateArrearageStatusIng(Map<String, String> headers, HttpClientUtils httpClient,
                                                 String instanceId, String type) {
        Response res = SendReqUtils.sendReq(urlUpdateArrearageStatusIng + "&InstanceId=" + instanceId + "&Type=" + type, headers, httpClient,
                SendReqUtils.GET, "updateArrearageStatusIng");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return res;
    }

    public static Response addServer(Map<String, String> headers, HttpClientUtils httpClient,
                                         String instanceId) {
        return SendReqUtils.sendReq(urlAddServer + "&InstanceId=" + instanceId, headers, httpClient, SendReqUtils.GET, "addServer");
    }

    public static Response delServer(Map<String, String> headers, HttpClientUtils httpClient,
                                     String instanceId, String serverId) {
        return SendReqUtils.sendReq(urlDelServer + "&InstanceId=" + instanceId + "&ServerId=" + serverId, headers, httpClient, SendReqUtils.GET, "delServer");
    }

    public static Response deregisterTGInstanceByTenant(Map<String, String> headers, JSONObject bodyJson, HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlDeregisterTGInstanceByTenant, headers, bodyJson, httpClient,
                SendReqUtils.POST, "deregisterTGInstanceByTenant");
    }

    public static Response updateLbAttrs(Map<String, String> headers, JSONObject bodyJson, HttpClientUtils httpClient,
                                         String instanceId) {
        return SendReqUtils.sendJsonReq(urlUpdateLbAttrs + "&InstanceId=" + instanceId, headers, bodyJson, httpClient,
                SendReqUtils.POST, "updateLbAttrs");
    }

    public static Response updateUserQuota(Map<String, String> headers, HttpClientUtils httpClient,
                                       String tenantId, String limit) {
        return SendReqUtils.sendReq(urlUpdateUserQuota + "&TenantId=" + tenantId + "&Limit=" + limit, headers, httpClient, SendReqUtils.GET, "updateUserQuota");
    }

    public static Response getUserQuota(Map<String, String> headers, HttpClientUtils httpClient,
                                           String tenantId, String type) {
        return SendReqUtils.sendReq(urlGetUserQuota + "&TenantId=" + tenantId + "&Type=" + type, headers, httpClient, SendReqUtils.GET, "getUserQuota");
    }

    public static Response updateLbQuota(Map<String, String> headers, HttpClientUtils httpClient,
                                           String instanceId, String listenerLimit, String tGroupLimit, String tGroupInstanceLimit,
                                         String pathLimit, String domainLimit, String maxBandwidth) {
        return SendReqUtils.sendReq(urlUpdateLbQuota + "&InstanceId=" + instanceId + "&ListenerLimit=" + listenerLimit +
                        "&TGroupLimit=" + tGroupLimit + "&TGroupInstanceLimit=" + tGroupInstanceLimit + "&PathLimit=" + pathLimit +
                        "&DomainLimit=" + domainLimit + "&MaxBandwidth=" + maxBandwidth, headers, httpClient,
                SendReqUtils.GET, "updateLbQuota");
    }

    public static Response getLbsAdmin(Map<String, String> headers, HttpClientUtils httpClient,
                                     String type, String limit, String offset) {
        return SendReqUtils.sendReq(urlGetLbsAdmin + "&Type=" + type + "&Limit=" + limit + "&Offset=" + offset, headers, httpClient, SendReqUtils.GET, "getLbsAdmin");
    }

    public static Response getLbCounts(Map<String, String> headers, HttpClientUtils httpClient, String type) {
        return SendReqUtils.sendReq(urlGetLbCounts + "&Type=" + type, headers, httpClient, SendReqUtils.GET, "getLbCounts");
    }

    public static Response searchLb(Map<String, String> headers, HttpClientUtils httpClient, String key) {
        return SendReqUtils.sendReq(urlSearchLb + "&Key=" + key, headers, httpClient, SendReqUtils.GET, "searchLb");
    }

    public static Response searchIp(Map<String, String> headers, HttpClientUtils httpClient, String ip) {
        return SendReqUtils.sendReq(urlSearchIp + "&Ip=" + ip, headers, httpClient, SendReqUtils.GET, "searchIp");
    }

    public static Response getSysInfo(Map<String, String> headers, HttpClientUtils httpClient) {
        return SendReqUtils.sendReq(urlGetSysInfo, headers, httpClient, SendReqUtils.GET, "getSysInfo");
    }

    public static Response getSysConfig(Map<String, String> headers, HttpClientUtils httpClient) {
        return SendReqUtils.sendReq(urlGetSysConfig, headers, httpClient, SendReqUtils.GET, "getSysConfig");
    }

    public static Response updateConfig(Map<String, String> headers, HttpClientUtils httpClient, String attr, String value) {
        return SendReqUtils.sendReq(urlUpdateConfig + "&Attr=" + attr + "&Value=" + value, headers,
                httpClient, SendReqUtils.GET, "updateConfig");
    }

    public static Response addConfig(Map<String, String> headers, HttpClientUtils httpClient, String attr, String value) {
        return SendReqUtils.sendReq(urlAddConfig + "&Attr=" + attr + "&Value=" + value, headers,
                httpClient, SendReqUtils.GET, "addConfig");
    }

    public static Response addIps(Map<String, String> headers, HttpClientUtils httpClient, String cidr, String groupId, String status, String type) {
        return SendReqUtils.sendReq(urlAddConfig + "&Cidr=" + cidr + "&GroupId=" + groupId + "&Status=" + status + "&Type=" + type,
                headers, httpClient, SendReqUtils.POST, "addIps");
    }

    public static Response getIps(Map<String, String> headers, HttpClientUtils httpClient, String status, String groupId, String limit, String offset) {
        return SendReqUtils.sendReq(urlGetIps + "&GroupId=" + groupId + "&Status=" + status + "&Offset=" + offset + "&Limit=" + limit,
                headers, httpClient, SendReqUtils.GET, "getIps");
    }

    public static Response createLb(Map<String, String> headers, JSONObject bodyJson,
                                    HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlCreateLb, headers, bodyJson, httpClient,
            SendReqUtils.POST, "createLb");
    }

    public static Response createLbIng(Map<String, String> headers, JSONObject bodyJson,
                                       HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlCreateLbIng, headers, bodyJson, httpClient,
            SendReqUtils.POST, "createLbIng");
    }

    public static Response updateLb(Map<String, String> headers, JSONObject bodyJson,
                                    HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlUpdateLb, headers, bodyJson, httpClient,
            SendReqUtils.POST, "updateLb");
    }

    public static Response updateLbIng(Map<String, String> headers, JSONObject bodyJson,
                                       HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlUpdateLbIng, headers, bodyJson, httpClient,
            SendReqUtils.POST, "updateLbIng");
    }

    public static Response renewOrder(Map<String, String> headers, HttpClientUtils httpClient,
                                      String instanceId, String period) {
        return SendReqUtils.sendReq(urlRenewOrder + "&InstanceId=" + instanceId + "&Period="
                                    + period, headers, httpClient, SendReqUtils.GET, "renewOrder");
    }

    public static Response renewOrderIng(Map<String, String> headers, HttpClientUtils httpClient,
                                         String instanceId, String period) {
        return SendReqUtils.sendReq(urlRenewOrderIng + "&InstanceId=" + instanceId + "&Period="
                                    + period, headers, httpClient, SendReqUtils.GET, "renewOrderIng");
    }

    public static Response updateLbSpec(Map<String, String> headers, JSONObject bodyJson,
                                        HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlUpdateLbSpec, headers, bodyJson, httpClient,
            SendReqUtils.POST, "updateLbSpec");
    }

    public static Response updateLbSpecIng(Map<String, String> headers, JSONObject bodyJson,
                                           HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlUpdateLbSpecIng, headers, bodyJson, httpClient,
            SendReqUtils.POST, "updateLbSpecIng");
    }

    public static Response checkLbParams(Map<String, String> headers, JSONObject bodyJson,
                                         HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlCheckLb, headers, bodyJson, httpClient,
            SendReqUtils.POST, "checkLbParams");
    }

    public static Response checkLbParamsIng(Map<String, String> headers, JSONObject bodyJson,
                                            HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlCheckLbIng, headers, bodyJson, httpClient,
            SendReqUtils.POST, "checkLbParamsIng");
    }

    public static Response createTg(Map<String, String> headers, JSONObject bodyJson,
                                    HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlCreateTg, headers, bodyJson, httpClient,
            SendReqUtils.POST, "createTg");
    }

    public static Response updateTg(Map<String, String> headers, JSONObject bodyJson,
                                    HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlUpdateTg, headers, bodyJson, httpClient,
            SendReqUtils.POST, "updateTg");
    }

    public static Response updateTgInstance(Map<String, String> headers, JSONObject bodyJson,
                                    HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlUpdateTgInstance, headers, bodyJson, httpClient,
                SendReqUtils.POST, "updateTgInstance");
    }

    public static Response registerTGInstance(Map<String, String> headers, JSONObject bodyJson,
                                    HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlRegisterTGInstance, headers, bodyJson, httpClient,
                SendReqUtils.POST, "registTGInstance");
    }

    public static Response deregisterTGInstance(Map<String, String> headers, JSONObject bodyJson,
                                            HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlDeregisterTGInstance, headers, bodyJson, httpClient,
                SendReqUtils.POST, "deregistTGInstance");
    }

    public static Response updateTGInstance(Map<String, String> headers, JSONObject updateBodyJson,
                                            HttpClientUtils httpClient) {
        Response res = null;
        if (!updateBodyJson.getJSONObject("Deregister").isEmpty())
            res = SendReqUtils.sendJsonReq(urlDeregisterTGInstance, headers, updateBodyJson.getJSONObject("Deregister"), httpClient,
                    SendReqUtils.POST, "deregistTGInstance");
        if (!updateBodyJson.getJSONObject("Register").isEmpty())
            res=  SendReqUtils.sendJsonReq(urlRegisterTGInstance, headers, updateBodyJson.getJSONObject("Register"), httpClient,
                    SendReqUtils.POST, "registTGInstance");
        return res;
    }

    public static Response deleteTg(Map<String, String> headers, HttpClientUtils httpClient,
                                    String instanceId, String targetGroupId) {
        return SendReqUtils.sendReq(urlDelTg + "&InstanceId=" + instanceId + "&TargetGroupId="
                                    + targetGroupId, headers, httpClient, SendReqUtils.GET, "deleteTg");
    }

    public static Response createLn(Map<String, String> headers, JSONObject bodyJson,
                                    HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlCreateLn, headers, bodyJson, httpClient,
            SendReqUtils.POST, "createLn");
    }

    public static Response createLnIng(Map<String, String> headers, JSONObject bodyJson,
                                       HttpClientUtils httpClient) {
        Response res = SendReqUtils.sendJsonReq(urlCreateLnIng, headers, bodyJson, httpClient,
            SendReqUtils.POST, "createLnIng");
        if (res.getCode() == 204) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
        }
        return res;
    }

    public static Response updateLn(Map<String, String> headers, JSONObject bodyJson,
                                    HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlUpdateLn, headers, bodyJson, httpClient,
            SendReqUtils.POST, "updateLn");
    }

    public static Response updateLnIng(Map<String, String> headers, JSONObject bodyJson,
                                       HttpClientUtils httpClient) {
        Response res = SendReqUtils.sendJsonReq(urlUpdateLnIng, headers, bodyJson, httpClient,
            SendReqUtils.POST, "updateLnIng");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return res;
    }

    public static Response deleteLn(Map<String, String> headers, HttpClientUtils httpClient,
                                    String instanceId, String listenerId) {
        return SendReqUtils.sendReq(urlDelLn + "&InstanceId=" + instanceId + "&ListenerId=" + listenerId, headers,
                httpClient, SendReqUtils.GET, "deleteLn");
    }

    public static Response deleteLnIng(Map<String, String> headers, HttpClientUtils httpClient, String instanceId, String listenerId) {
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.out.println("loader balancer is deleting......");
        }
        return SendReqUtils.sendReq(urlDelLnIng + "&InstanceId=" + instanceId + "&Name=" + listenerId, headers, httpClient, SendReqUtils.GET, "deleteLnIng");
    }

    public static String createOrderAndPay(Map<String, String> headers, JSONObject bodyJson,
                                           HttpClientUtils httpClient) {
        Response res = SendReqUtils.sendJsonReq(urlCreateOrder, headers, bodyJson, httpClient,
            SendReqUtils.POST, "createOrder");
        JSONObject resJson = JSONObject.parseObject(res.getHtml());
        String orderId = resJson.getString("OrderId");
        res = SendReqUtils.sendReq(urlPayOrder + "&OrderId=" + orderId, headers, httpClient,
            SendReqUtils.GET, "payOrder");
        if (res.getCode() == 200)
            return orderId;
        else
            return "";
    }

    public static String createUpOrderAndPay(Map<String, String> headers, JSONObject bodyJson,
                                             HttpClientUtils httpClient) {
        Response res = SendReqUtils.sendJsonReq(urlCreateUpdateOrder, headers, bodyJson,
            httpClient, SendReqUtils.POST, "createUpOrder");
        JSONObject resJson = JSONObject.parseObject(res.getHtml());
        String orderId = resJson.getString("OrderId");
        res = SendReqUtils.sendReq(urlPayOrder + "&OrderId=" + orderId, headers, httpClient,
            SendReqUtils.GET, "createUpOrder");
        if (res.getCode() == 200)
            return orderId;
        else
            return "";
    }
    
    public static Response createCert(Map<String, String> headers, JSONObject bodyJson,
                                      HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlCreateCert, headers, bodyJson, httpClient, SendReqUtils.POST, "createCert");
    }

    public static Response getCerts(Map<String, String> headers, HttpClientUtils httpClient) {
        return SendReqUtils.sendReq(urlGetCertificates, headers, httpClient, SendReqUtils.GET, "getCerts");
    }

    public static Response deleteCert(Map<String, String> headers, HttpClientUtils httpClient,
                                    String certId) {
        return SendReqUtils.sendReq(urlDelCertificate + "&CertId=" + certId, headers, httpClient, SendReqUtils.GET, "deleteCert");
    }

    public static Response deleteCertSsl(Map<String, String> headers, HttpClientUtils httpClient,
                                    String certId) {
        return SendReqUtils.sendReq(urlDelCertSsl + "&CertId=" + certId, headers, httpClient, SendReqUtils.GET, "deleteCertSsl");
    }

    public static Response fetchCert(Map<String, String> headers, HttpClientUtils httpClient,
                                      String certId) {
        return SendReqUtils.sendReq(urlFetchCertificate + "&CertId=" + certId, headers, httpClient, SendReqUtils.GET, "fetchCert");
    }

    public static Response uploadCert(Map<String, String> headers, JSONObject bodyJson,
                                      HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlUploadCert, headers, bodyJson, httpClient, SendReqUtils.POST, "uploadCert");
    }

    public static Response getKeys(Map<String, String> headers, HttpClientUtils httpClient) {
        return SendReqUtils.sendReq(urlGetKeys, headers, httpClient, SendReqUtils.GET, "getKeys");
    }

    public static Response createKeys(Map<String, String> headers, JSONObject bodyJson,
                                      HttpClientUtils httpClient) {
        return SendReqUtils.sendJsonReq(urlCreateKeys, headers, bodyJson, httpClient, SendReqUtils.POST, "createKeys");
    }

    public static Response delKeys(Map<String, String> headers, HttpClientUtils httpClient, String keyId) {
        return SendReqUtils.sendReq(urlDelKeys + "/" + keyId, headers, httpClient, SendReqUtils.DEL, "delKeys");
    }

    public static Response getKey(Map<String, String> headers, HttpClientUtils httpClient, String keyId) {
        return SendReqUtils.sendReq(urlGetKey + "/" + keyId, headers, httpClient, SendReqUtils.GET, "getKey");
    }

    public static Response getKeyStore(Map<String, String> headers, HttpClientUtils httpClient, String keyId) {
        return SendReqUtils.sendReq(urlGetKeyStore + "/" + keyId, headers, httpClient, SendReqUtils.GET, "getKeyStore");
    }

    public static String waitLb(Map<String, String> headers, HttpClientUtils httpClient,
                                String instanceId) {
        String status = "CREATING";
        int count = 1;
        while (status.equals("CREATING")) {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            String lbDetail = CommonApi.getLbDetail(headers, httpClient, instanceId).getHtml();
            status = JSONObject.parseObject(lbDetail).getString("Status");
            logger.info("LoadBalancer is creating...");
//            count++;
//            if (count == 15)
//                break;
        }
        return status;
    }

    public static String waitCloudServerActive(Map<String, String> headers, HttpClientUtils httpClient,
                                String instanceId) {
        String status = "BUILD";
        while (status.equals("BUILD") || status.equals("INIT")) {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            String lbDetail = CommonApi.getLbDetailAdmin(headers, httpClient, instanceId).getHtml();
            JSONArray cloudServers = JSONObject.parseObject(lbDetail).getJSONArray("CloudServers");
            if (!cloudServers.isEmpty()) {
                for (int i = 0; i < cloudServers.size(); i++) {
                    status = cloudServers.getJSONObject(i).getString("ServerStatus");
                    if (!status.equals("ACTIVE"))
                        break;
                }
                logger.info("CloudServer is building...");
            }
            else {
                logger.info("Auto Scale doesn't begin yet...");
            }
        }
        return status;
    }

    public static Boolean waitCloudServerDeleting(Map<String, String> headers, HttpClientUtils httpClient,
                                               String instanceId) {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            String lbDetail = CommonApi.getLbDetailAdmin(headers, httpClient, instanceId).getHtml();
            JSONArray cloudServers = JSONObject.parseObject(lbDetail).getJSONArray("CloudServers");
            if (cloudServers.size() == 0)
                return true;
            logger.info("CloudServer is deleting...");
        }
    }

    public static String waitEndingAndGetLbInfo(Map<String, String> headers, HttpClientUtils httpClient, String instanceId) {
        String lbDetail = null;
        String status = "CREATING";

        while (status.equals("CREATING")) {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            lbDetail = CommonApi.getLbDetail(headers, httpClient, instanceId).getHtml();
            status = JSONObject.parseObject(lbDetail).getString("Status");
            logger.info("LoadBalancer is creating...");
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return lbDetail;
    }

    public static String waitEndingAndGetIngInfo(Map<String, String> headers, HttpClientUtils httpClient, String instanceId) {
        String lbDetail = null;
        String status = "CREATING";
        while (status.equals("CREATING")) {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            lbDetail = CommonApi.getLbDetailIng(headers, httpClient, instanceId).getHtml();
            status = JSONObject.parseObject(lbDetail).getString("Status");
            logger.info("LoadBalancer is creating...");
        }
        return lbDetail;
    }

    public static String waitIng(Map<String, String> headers, HttpClientUtils httpClient,
                                 String instanceId) {
        String status = "CREATING";
        int count = 1;
        while (status.equals("CREATING")) {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            String lbDetail = CommonApi.getLbDetailIng(headers, httpClient, instanceId).getHtml();
            status = JSONObject.parseObject(lbDetail).getString("Status");
            logger.info("LoadBalancer is creating...");
//            count++;
//            if (count == 30)
//                break;
        }
        return status;
    }

    public static String waitLbDelete(Map<String, String> headers, HttpClientUtils httpClient,
                                      String instanceId) {
        String status = "DELETING";
        while (StringUtils.equals(status, "DELETING")) {
            logger.info("LoadBalancer is deleting...");
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                System.out.println("loader balancer is deleting......");
            }
            String lbDetail = CommonApi.getLbDetail(headers, httpClient, instanceId).getHtml();
            if (JSONObject.parseObject(lbDetail).containsKey("Status"))
                status = JSONObject.parseObject(lbDetail).getString("Status");
            else {
                return "DELETED";
            }
        }
        return status;
    }

    public static String waitLbDeleteIng(Map<String, String> headers, HttpClientUtils httpClient,
                                         String instanceId) {
        String status = "DELETING";
        while (status.equals("DELETING")) {
            logger.info("LoadBalancer is deleting...");
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            String lbDetail = CommonApi.getLbDetailIng(headers, httpClient, instanceId).getHtml();
            if (JSONObject.parseObject(lbDetail).containsKey("Status"))
                status = JSONObject.parseObject(lbDetail).getString("Status");
            else
                return "DELETED";
        }
        return status;
    }

    public static JSONObject findListenerByName(JSONObject lbDetail, String name) {
        JSONArray listeners = lbDetail.getJSONArray("Listeners");
        for (int i = 0; i < listeners.size(); i++) {
            if (listeners.getJSONObject(i).getString("Name").equals(name))
                return listeners.getJSONObject(i);
        }
        return null;
    }

    public static JSONObject findTgByName(JSONObject lbDetail, String name) {
        JSONArray targetGroups = lbDetail.getJSONArray("TargetGroups");
        for (int i = 0; i < targetGroups.size(); i++) {
            if (targetGroups.getJSONObject(i).getString("Name").equals(name))
                return targetGroups.getJSONObject(i);
        }
        return null;
    }

    public static TargetGroup findTgByName(LoadBalancer lb, String name) {
        List<TargetGroup> targetGroups = lb.getTargetGroups();
        for (int i = 0; i < targetGroups.size(); i++) {
            if (targetGroups.get(i).getName().equals(name))
                return targetGroups.get(i);
        }
        return null;
    }

    public static Boolean isCertInList(JSONArray certList, List<String> certIdList) {
        for (int i = 0; i < certIdList.size(); i++) {
            String certId = certIdList.get(i);
            Boolean exist = false;
            for (int j = 0; j < certList.size(); j++) {
                JSONObject cert = certList.getJSONObject(j);
                if (cert.getString("Id").equals(certId)) {
                    exist = true;
                    break;
                }
            }
            if (!exist)
                return false;
        }
        return true;
    }

    public static List<LbLog> getLbLogs(String vipId, final String tenantId, HttpClientUtils httpClient) {
        Response resp = SendReqUtils.sendReq(urlGetVipLogs + "&InstanceId=" + vipId,
            new HashMap<String, String>() {{
                put("X-Product-Id", tenantId);
            }}, httpClient, SendReqUtils.GET, "getLbLogs");
        if (resp.getCode() != 200) {
            throw new AssertionError("get lb logs failed! " + resp.getHtml());
        }

        String logListStr = resp.getHtml();
        return JSON.parseArray(logListStr, LbLog.class);
    }

    public static void main(String[] args) {
        HttpClientUtils httpClient = new HttpClientUtils();
        Map<String, String> headers = new HashMap<String, String>();
        Response res = CommonApi.getLbsIng(headers, httpClient, "", "");
        JSONArray lbs = JSONObject.parseArray(res.getHtml());
        JSONObject lb;
        for (int i = 0; i < lbs.size(); i++) {
            lb = lbs.getJSONObject(i);
            String instanceId = lb.getString("InstanceId");
            CommonApi.deleteLbIngAdmin(headers, httpClient, instanceId);
        }
    }
}
