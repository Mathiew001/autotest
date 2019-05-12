package com.netease.cloudqa.nlb.api.test.utils;

import java.util.UUID;

public class DbUtils {

    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().toLowerCase();
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(getUUID32());
    }
}
