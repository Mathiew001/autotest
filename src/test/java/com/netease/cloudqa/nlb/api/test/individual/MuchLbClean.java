/**
 * http://www.163.com
 * Copyright (c) 1997-2018 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.individual;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.netease.cloudqa.nlb.api.test.base.ApiTestBase;
import com.netease.cloudqa.nlb.api.test.framework.model.Response;
import com.netease.cloudqa.nlb.api.test.utils.CommonApi;

/**
 * 
 * @author hzzhangyan
 * @version $Id: MuchLbClean.java, v 0.1 2018-9-3 下午4:15:55 hzzhangyan Exp $
 */
public class MuchLbClean extends ApiTestBase {

    @Test
    public void batchClean() throws InterruptedException {
        String[] lbs = { "9a230c7c-8a41-4072-8502-368c431cceeb",
                "9f43bdd5-10b3-4a89-ae1b-a855d4ef8f07", "9699d79f-5473-4e6b-a415-eb06da323bdb",
                "96338161-ddfc-4830-8529-a807819e5a80", "acdf8536-a5d7-4311-bec4-9e1a98ce7488",
                "82dcd9bb-d838-4406-8d0f-1afaf4c4c3cb", "c9514afd-fdda-40cf-ae2c-521642059c77",
                "da7d1d1d-8c9e-43b6-b358-ff6a0fcae9a8", "6b1b4340-f659-40e4-893c-129e921cb581",
                "b3f6bced-6a47-428a-acab-bdec22e03a89", "d22c6184-6b42-4931-b23d-fc54bd905f0c",
                "c1c9cb0c-cbb1-41d0-8ef2-bd6513c22b50", "c6cfb3f9-4800-4a3e-8cb5-0aa793ffef5b",
                "66a912de-6fa6-441b-99bd-b0b16baf3e16", "aef0b77f-2682-4866-8c53-b3c907c1b8be",
                "4cf5d11c-1137-47ff-ab0a-7370bb31d21a", "8abde55d-d134-4e9d-9c6d-13a8f4334f83",
                "d56dd413-4d73-4724-aed0-b9e20c6ac98f", "8482a988-aa64-4649-88dc-3a23b0a0caa0",
                "681549f8-105a-48e9-a073-ee54c6aa2f6c", "448a8c31-312a-475c-baa2-98f8a4840ef2",
                "97fe8dda-4af1-45be-aeec-905db82e4d7f", "0df39001-c38f-4a0b-a373-f89c948898a9",
                "efed66ed-2234-4d34-8cf5-177b4d4057ad", "20bc7489-ffc3-475e-8a69-7224bea9184b",
                "ef19da6b-b539-41f1-b1ce-ffa8d967dfce", "24ecd34f-8b67-4fb1-8fba-43067550f980",
                "85bf1805-55c9-4f66-aaa9-df17070c9a58", "4fcae494-2fc3-4a0f-81bd-5e4beff6d0a6",
                "46d9b998-d779-4671-bea5-a2345147f0bb", "5ac99649-d282-44a7-9d16-c3c0940c04d4",
                "927e89af-f72a-48bc-bbab-18f92da578a9", "5b87501e-6f31-40c9-831c-c425e87fd44d",
                "40dcdd95-7acd-4f24-8533-8d6cdd26941d", "e3529630-8710-4d66-9d92-c3ad111c75ab",
                "5c728fae-4fa4-4682-a267-f8db743d15c2", "9c5feced-cb45-47f7-8301-816a78ac4408",
                "5d929389-eba1-4677-88cb-fe7c8fc8d277", "9e1e26db-0ca0-4ed6-b70b-00426dab949a",
                "fa9484cd-5db1-46b9-af55-bb1cd84174c3", };
        Map<String, String> headers = new HashMap<String, String>();
        for (String lb : lbs) {
            Response res = CommonApi.deleteLbAdmin(headers, httpClient, lb);
            System.out.println(res.getHtml());
            Thread.currentThread().sleep(1000);
        }
    }

    @Test
    public void batchCleanIng() {
        String[] lbs = { "test123-web02ci@hjgj", "rererererererererererererererere-web02ci@rtytry",
                "default-web02ci@ffff", "default-web02ci@zzzz", "test123-web02ci@luoxl1",
                "default-web02ci@zzz", "zcx-zhangcahoxu@testhuifu", "zcx-zhangcahoxu@n",
                "k8s19test-shadowzhou@iii", "default-louxj424@nlb-containor",
                "default-hzzhangyan01@test111", "default-hzzhangyan01@test1", "aaaa-nlbyq01@dfasd",
                "nametest-webdevelopci@asfd", "aa-webdevelopci@fbtest",
                "aa-webdevelopci@testtuidig", "aa-webdevelopci@asd", "aa-webdevelopci@yayaya",
                "aa-webdevelopci@asdff", "ingresstest-webdevelopci@testb",
                "ingresstest-webdevelopci@testnlb1", "ingresstest-webdevelopci@testnlb",
                "ingresstest-webdevelopci@testnlb2",
                "test1111111111111111111111111111-uedtest@efr",
                "test1111111111111111111111111111-uedtest@tedt", "default-ddosci2@wkg",
                "ds-hightea001@ingress-liuliang", "ds-hightea001@bnbyingress53",
                "ds-hightea001@bnby-ingressd", "default-hightea001@ingressbnbyold1", };
        Map<String, String> headers = new HashMap<String, String>();
        for (String lb : lbs) {
            Response res = CommonApi.deleteLbIngAdmin(headers, httpClient, lb);
            System.out.println(res.getHtml());
        }
    }
}
