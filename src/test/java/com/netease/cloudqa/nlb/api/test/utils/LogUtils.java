package com.netease.cloudqa.nlb.api.test.utils;

import org.apache.log4j.Logger;

public class LogUtils extends Logger {

    public LogUtils(String name) {
        super(name);
    }

    @Override
    public void info(Object message) {
        super.info("[ThreadId] " + message);
    }
}
