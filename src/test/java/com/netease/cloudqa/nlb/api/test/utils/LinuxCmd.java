package com.netease.cloudqa.nlb.api.test.utils;
import org.apache.log4j.Logger;

import java.io.*;

public class LinuxCmd {

    protected static Logger logger = Logger.getLogger(CommonApi.class);

    public static String exec(String cmd) {
        try {
            logger.info("Cmd: " + cmd);
            String[] cmdA = { "/bin/sh", "-c", cmd };
            Process process = Runtime.getRuntime().exec(cmdA);
            LineNumberReader br = new LineNumberReader(new InputStreamReader(
                    process.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            logger.info("Cmd Execute Result: " + sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
