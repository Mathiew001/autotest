/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.individual;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.common.config.ConfigLoader;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;

/**
 * 数据面测试大量后端构造脚本
 * @author hzzhangyan
 * @version $Id: MuchBackendPrepare.java, v 0.1 2018-8-20 下午3:36:11 hzzhangyan Exp $
 */
public class MuchBackendPrepare extends ApiTestBase {

    /**
     * 构造20个监听,每个监听128个后端,共计2560个后端
     */
    @Test
    public void create_20_128_backend_lb() {
        String lbId = "9573d800-0c00-48d2-af68-3aab74bbdc23";

        creatLs(lbId);
    }

    /**
     * 构造20个监听,每个监听128个后端,共计2560个后端
     */
    @Test
    public void test_all_backend() {
        String[] lbs = { "fa9484cd-5db1-46b9-af55-bb1cd84174c3",
                "aed07731-4b9c-4a86-a5d9-b6d130aeae44", "4ebee89f-538c-49b7-bb26-6b68e1d8f047",
                "15e8c5aa-e2c1-494c-90b5-15d07e496b42", "3f3876fa-192d-4405-91c3-2130d48ddb38",
                "028c99d6-d46c-4897-b6b7-25d378d255fa", "fd25342c-f2f4-475e-9077-2855719210e8",
                "85779037-851e-4ea7-8cd8-0a4c57a27dc0", "ae119446-4651-4787-8258-a68361b6707e",
                "74ed6584-678b-447c-a45c-b5a05f682faa", "81312ae2-e96e-4810-8a6f-1c468e78ab31",
                "41ca7ba2-2144-4f78-bb8d-94f51d722eb0", "68a03c8c-b994-4b80-a5e5-7162648a84d0",
                "22a15830-28eb-41cb-8b16-f9e7015904c1", "2df410b5-1da9-4322-993e-dccf487560d8",
                "ad9ffa94-8f78-443a-b4cd-0d18648a4215", "f64a531b-39e7-4776-a697-e8a9d8682ddb",
                "9e968e33-7fb2-4086-9a7d-2d9b5a935af2", "b06c3471-3c6b-42c1-8351-29f350afb082",
                "da7eea8e-2dc8-42bb-bb77-6cc4d9f44c44", "dba5494b-1f52-4433-b65e-5eccd2c3fc8b",
                "a07f2411-dac1-4048-b5d5-393f2c843885", "032313dd-8cb6-472a-95de-5e9b67b443b8",
                "600b03a1-6e20-48e6-a034-49680db176d2", "330cbe33-ede3-48b2-b8e6-2f3f859a5595",
                "5c4748a6-c30a-45bd-b069-77bcf2d191e6", "d91f5c4e-6451-49b4-a69d-1bb5fd893142",
                "52370130-3895-40cd-bac5-03c8d297f908", "8ccf5589-2bb7-447b-b937-1127da3445a5",
                "4284ebf8-7ad9-43f8-8514-939fa435a205", "7d04687f-34e9-4c22-82a9-8040dab4bbd2",
                "ed5ca0db-6679-44b5-b388-397a25f29312", "75dff296-894f-4e81-a144-bd4321a9543b",
                "ee16993b-8134-419f-97b7-705536f67279", "840cb861-5e78-4693-857d-8c63d85caec9",
                "7f0e3a62-373b-4ea2-aa78-a59cb4e148ff", "9413710f-1010-4e76-a342-20effa355685",
                "d3fff831-984e-4a46-be75-ab08becda064", "c48fd7e3-8d62-4843-8bd8-be3f3a8ac841",
                "016b525e-3556-497a-a9f0-c1bd0bd9db3a", "1ea32fa1-0952-4e4e-835b-42647dc13212",
                "e3a04b58-bd8c-4762-9361-97df64f63de2", "7948726e-005b-4028-8612-4d014b203795",
                "2aa86c47-a01a-4d70-bfbb-f624e0a5989d", "cc00b05f-82ed-45a0-b5fb-ded537b86bdb",
                "c09e8b71-cdcc-4713-b4a3-b2e8436a987f", "da673a0f-76bb-4b6b-b3e9-a1240f8ac36d",
                "bdf99294-8444-4a99-8329-02637d477b6e", "4dbbc2ea-9d95-4144-a192-dcdcddfdaa3d",
                "485da31e-e55b-4afd-b559-328b73d9fd41" };

        for (String lb : lbs) {
            creatLs(lb);
        }
    }

    /**
     * 构造20个监听,每个监听128个后端,共计2560个后端
     */
    @Test
    public void create_backend_in_lbs() {
        String[] lbIds = null;
        for (String lb : lbIds) {
            creatLs(lb);
        }
    }

    public void creatLs(String lbId) {
        String topAz = "cn-east-1b";
        String realServer1 = "b2560606-eb0c-47d9-b60f-0280d961140a";
        String rsName1 = "kaola-perf1";
        String rsAddress1 = "192.168.0.107";

        String realServer2 = "6e6e9d5b-eb1e-47a4-95a6-fce9fb085a97";
        String rsName2 = "kaola-perf2";
        String rsAddress2 = "192.168.0.106";

        //        String realServer1 = "b4b26c9b-7c81-45ed-a84a-b227f26d03f4";
        //        String rsName1 = "testnlb-02";
        //        String rsAddress1 = "192.168.4.21";

        for (int i = 1; i <= 1; i++) {
            String tgBody = "{\"Name\":\"tg-test-" + i + "\", \"InstanceId\":\"" + lbId
                            + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
                            + rsName1 + "\", \"Port\":80, \"TopAz\":\"" + topAz
                            + "\", \"Weight\":100, " + "\"Address\": \"" + rsAddress1
                            + "\"}, {\"Id\":\"" + realServer2 + "\", \"Name\":\"" + rsName2
                            + "\", \"Port\":80, \"TopAz\":\"" + topAz
                            + "\", \"Weight\":100, \"Address\":\"" + rsAddress2
                            + "\"}], \"UseSamePort\":1, " + "            \"Monitor\":{\n"
                            + "                \"Protocol\":\"tcp\",\n"
                            + "                \"Rise\":2,\n" + "                \"Fall\":2,\n"
                            + "                \"Timeout\":5000,\n"
                            + "                \"Period\":5000\n" + "            }\n" + "}";

            //            String tgBody = "{\"Name\":\"tg-test-" + i + "\", \"InstanceId\":\"" + lbId
            //                            + "\", \"Instances\":[{\"Id\":\"" + realServer1 + "\", \"Name\":\""
            //                            + rsName1 + "\", \"Port\":81, \"TopAz\":\"" + topAz
            //                            + "\", \"Weight\":100, " + "\"Address\": \"" + rsAddress1
            //                            + "\"}], \"UseSamePort\":1, " + "            \"Monitor\":{\n"
            //                            + "                \"Protocol\":\"tcp\",\n"
            //                            + "                \"Rise\":2,\n" + "                \"Fall\":2,\n"
            //                            + "                \"Timeout\":5000,\n"
            //                            + "                \"Period\":5000\n" + "            }\n" + "}";

            Map<String, String> headers = new HashMap<String, String>();
            String tenantId = ConfigLoader.configration.getExtConfig("tenant_id");
            headers.put("X-Product-Id", tenantId);
            Response tgRes = CommonApi
                .createTg(headers, JSONObject.parseObject(tgBody), httpClient);
            if (tgRes.getCode() != 200) {
                throw new RuntimeException("error....");
            }
            System.out.println("----------------------" + tgRes);

            JSONObject tagJs = (JSONObject) JSONObject.parse(tgRes.getHtml());
            String tagId = tagJs.getString("TargetGroupId");

            String lsBody = "{\n" + "    \"InstanceId\": \"" + lbId + "\",\n"
                            + "    \"Name\": \"test-ls-" + i + "\",\n" + "    \"ListenPort\": "
                            + (1100 + i) + ",\n" + "    \"ForwardPort\": 1,\n"
                            + "    \"TraceVip\": 1,\n" + "    \"Protocol\": \"tcp\",\n"
                            + "    \"Balance\": \"roundrobin\",\n" + "    \"Clusters\": [\n"
                            + "     {\n" + "            \"TargetGroupId\": \"" + tagId + "\",\n"
                            + "            \"Policy\": {\n"
                            + "                \"Mode\": \"rewrite\",\n"
                            + "                \"CookieName\": \"asfsd\"\n" + "            },\n"
                            + "            \"Monitor\": {\n" + "              \"Period\": 6000,\n"
                            + "              \"Timeout\": 6000,\n" + "              \"Rise\": 6,\n"
                            + "              \"Fall\": 6,\n"
                            + "              \"Protocol\": \"tcp\",\n"
                            + "              \"Url\": \"/index.html\",\n"
                            + "              \"Rstatus\": \"2xx,3xx\" \n" + "            }\n"
                            + "     }],\n" + "    \"Gzip\": 1,\n" + "}";

            Response lsRes = CommonApi
                .createLn(headers, JSONObject.parseObject(lsBody), httpClient);
            if (lsRes.getCode() != 200) {
                throw new RuntimeException("error....");
            }
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                logger.error("", e);
            }
            System.out.println("----------------------" + lsRes);
        }
    }
}
