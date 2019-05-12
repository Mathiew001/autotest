package com.netease.cloudqa.nlb.api.test.utils;

import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import org.apache.log4j.Logger;

/**
 *
 * @author chentianyu1
 * @version $Id: OtherApi.java, v 0.1 Apr 27, 2018 5:58:27 PM chentianyu1 Exp $
 */
public class OtherApi {

    protected static Logger logger = Logger.getLogger(OtherApi.class);

    private static String createCertUrl = ConfigLoader.configration.getHttpUrl() + "/api/v1.0/certificate";

//    public static Response createCert(String createCertUrl, String name, String pubCert, String priKey, String certChain) {
//        Response res;
//
//    }
}
