package com.netease.cloudqa.nlb.api.test.apitest.classicalopenapi.ssl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.framework.template.TestCaseCallBack;
import com.netease.cloudqa.nlb.api.test.framework.utils.HttpClientUtils;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;
import com.netease.cloudqa.nlb.api.test.utils.LinuxCmd;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetCertificatesNormalTest extends ApiTestBase {

    @Test(dataProvider="YamlDriverDataProvider", description="GetCertificates NormalTest")
    public void apiTest(final String caseId, final String description, final String tenantId) {
        getTestCaseTemplate().process(caseId, new TestCaseCallBack() {

            HttpClientUtils httpClient = new HttpClientUtils();
            Map<String, String> headers = new HashMap<String, String>();
            JSONObject bodyJson = new JSONObject();
            List<String> certIdList = new ArrayList<String>();
            JSONArray resMsg = new JSONArray();

            @Override
            public void beforeTest() {
                logger.info("=================================================================");
                logger.info("===            " + description);
                logger.info("=================================================================");
                headers.put("X-Product-Id", tenantId);
                Response res;
                for(int i = 0; i < 5; i++) {
                    String cmd1 = "sh scripts/produceCert.sh";
                    String cmd3 = "cat scripts/ssl.crt";
                    String cmd2 = "cat scripts/ssl.key";
                    LinuxCmd.exec(cmd1);
                    String crt = LinuxCmd.exec(cmd3);
                    String key = LinuxCmd.exec(cmd2);
                    bodyJson.put("CertName", "qa-test"+i);
                    bodyJson.put("Cert", crt);
                    bodyJson.put("PrivateKey", key);
                    res = CommonApi.uploadCert(headers, bodyJson, httpClient);
                    certIdList.add(JSONObject.parseObject(res.getHtml()).getString("certId"));
                }
            }

            @Override
            public void executeTest() {
                Response res;
                for (int i = 0; i< certIdList.size(); i++) {
                    res = CommonApi.fetchCert(headers, httpClient, certIdList.get(i));

                    assertEquals(res.getCode(), 200, caseId + " fetch cert failed!");
                }
                res = CommonApi.getCerts(headers, httpClient);
                JSONArray certList = JSONObject.parseArray(res.getHtml());
                assertTrue(CommonApi.isCertInList(certList, certIdList), caseId);
                resMsg = JSONObject.parseArray(res.getHtml());
            }

            @Override
            public void afterTest() {
                for (int i = 0; i < certIdList.size(); i++) {
                    Response res = CommonApi.deleteCert(headers, httpClient, certIdList.get(i));
                    assertEquals(200, res.getCode(), caseId + " delete cert failed!");
                    res = CommonApi.deleteCertSsl(headers, httpClient, certIdList.get(i));
                    assertEquals(200, res.getCode(), caseId + " delete cert failed!");
                    logger.info("Delete cert successfully!");
                }
            }
        });
    }
}
