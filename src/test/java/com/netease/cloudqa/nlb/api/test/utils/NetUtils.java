package com.netease.cloudqa.nlb.api.test.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.cloudqa.nlb.api.test.model.Cluster;
import com.netease.cloudqa.nlb.api.test.model.Listener;
import com.netease.cloudqa.nlb.api.test.model.LoadBalancer;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NetUtils {

    protected static Logger logger = Logger.getLogger(CommonApi.class);

//    public static Boolean checkListenerEffective(HttpClientUtils httpClient, JSONArray listeners, String vip) {
//        Boolean isEffective = false;
//        for (int i = 0; i < listeners.size(); i++) {
//            JSONObject listener = listeners.getJSONObject(i);
//            JSONArray clusters = listener.getJSONArray("Clusters");
//            for (int j = 0; j < clusters.size(); j++) {
//                JSONObject cluster = clusters.getJSONObject(j);
//                String protocol = listener.getString("Protocol");
//                if (protocol.equals("https") || protocol.equals("tls")) {
//                    isEffective = true;
//                    break;
//                }
//                isEffective = curlVipPort(httpClient, protocol, vip, listener.getString("ListenPort"),
//                        cluster.getString("ServerName"), cluster.getString("Path"));
//            }
//        }
//        return isEffective;
//    }
//
//    private static Boolean curlVipPort(HttpClientUtils httpClient, String protocol, String vip, String port, String serverName, String path) {
//        Response res;
//        Map<String, String> headers = new HashMap<String, String>();
//        String prefix = "http://";
//        if (protocol.equals("https"))
//            prefix = "https://";
//        if (serverName.equals("*")) {
//            headers.put("host", serverName);
//            res = SendReqUtils.sendReq(prefix + vip + ":" + port + path,
//                    headers, httpClient, SendReqUtils.GET, "curlVipPort");
//        }
//        else if (path != null) {
//            headers.put("host", serverName);
//            res = SendReqUtils.sendReq(prefix + vip + ":" + port + path,
//                    headers, httpClient, SendReqUtils.GET, "curlVipPort");
//        }
//        else {
//            res = SendReqUtils.sendReq(prefix + vip + ":" + port,
//                    headers, httpClient, SendReqUtils.GET, "curlVipPort");
//        }
//        return res.getCode() == 200;
//    }

    public static void checkListenerEffective(JSONArray listeners, String vip) {
        for (int i = 0; i < listeners.size(); i++) {
            JSONObject listener = listeners.getJSONObject(i);
            JSONArray clusters = listener.getJSONArray("Clusters");
            for (int j = 0; j < clusters.size(); j++) {
                JSONObject cluster = clusters.getJSONObject(j);
                String protocol = listener.getString("Protocol");
                String path = cluster.containsKey("Path")?cluster.getString("Path"):"";
                String serverName = cluster.containsKey("ServerName")?cluster.getString("ServerName"):"";
                String port = listener.getString("ListenPort");
                String cmd;
                String common = " -I -s -o /dev/null -w %{http_code}";
                if (protocol.equals("http")) {
                    cmd = "curl " + "http://" + vip + ":" + port + path + " -H 'host: " +
                            serverName + "'" + common;
                }
                else if (protocol.equals("https")) {
                    cmd = "curl " + "https://" + vip + ":" + port + path + " -H 'host: " +
                            serverName + "'" + " -k" + common;
                }
                else if (protocol.equals("tls")){
                    cmd = "curl " + "https://" + vip + ":" + port + " -k" + common;
                }
                else {
                    cmd = "curl " + vip + ":" + port + common;
                }

                logger.info("cmd: " + cmd);
                assertTrue(checkCurlResponse(cmd, 5), "curl vip+port failed!");
            }
        }
    }

    public static void checkUrlFlow(JSONArray urlCheckList, String vip) {
        for (Object obj : urlCheckList) {
            JSONObject item = (JSONObject) obj;
            int port = item.getInteger("listenPort");
            JSONArray checkList = item.getJSONArray("check");
            for (int i = 0; i < checkList.size(); i++) {
                String serverName = checkList.getJSONObject(i).getString("serverName");
                int instancePort = checkList.getJSONObject(i).getInteger("port");
                List<String> urls = Arrays.asList(checkList.getJSONObject(i).getString("path").split(" "));
                for (String url : urls)
                    checkUrlEffective(vip, port, serverName, url, instancePort);
            }
        }
    }

    public static long checkSessionStickyInsert(LoadBalancer lb) {
        String ip = lb.getAddress();
        Integer port = lb.getListeners().get(0).getListenPort();
        String cmd = "curl " + ip + ":" + port + " -I -s -o /dev/null -w %{http_code}";
        String cmd1 = "curl " + ip + ":" + port + " -D scripts/cookie";
        String cmd2 = "curl " + ip + ":" + port + " -b scripts/cookie";
        if (checkCurlResponse(cmd, 5)) {
            JSONObject resJson = JSONObject.parseObject(LinuxCmd.exec(cmd1));
            String backend = resJson.getString("ip");
            long startTime = System.currentTimeMillis();
            while (JSONObject.parseObject(LinuxCmd.exec(cmd2)).getString("ip").equals(backend)) {
            }
            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        }
        return 0;
    }

    public static boolean checkSessionStickyRewrite(LoadBalancer lb) {
        String ip = lb.getAddress();
        Integer port = lb.getListeners().get(0).getListenPort();
        String cmd = "curl " + ip + ":" + port + " -I -s -o /dev/null -w %{http_code}";
        String cmd1 = "curl " + ip + ":" + port + " -D scripts/cookie";
        String cmd2 = "curl " + ip + ":" + port + " -b scripts/cookie";
        String cmd3 = "curl " + ip + ":" + port;
        boolean flag1 = true;
        boolean flag2 = false;
        if (checkCurlResponse(cmd, 5)) {
            JSONObject resJson = JSONObject.parseObject(LinuxCmd.exec(cmd1));
            String backend = resJson.getString("ip");
            for (int i = 0; i < 6; i++) {
                if (!JSONObject.parseObject(LinuxCmd.exec(cmd2)).getString("ip").equals(backend))
                    flag1 = false;
            }
            for (int i = 0; i < 6; i++) {
                if (!JSONObject.parseObject(LinuxCmd.exec(cmd3)).getString("ip").equals(backend))
                    flag2 = true;
            }
            for (int i = 0; i < 6; i++) {
                if (!JSONObject.parseObject(LinuxCmd.exec(cmd2)).getString("ip").equals(backend))
                    flag1 = false;
            }
        }
        return flag1 && flag2;
    }

    private static Boolean checkUrlEffective(String vip, Integer port, String serverName, String path, Integer instancePort) {
//        String common = " -I -s -o /dev/null -w %{http_code}";
        String cmd = "curl " + "http://" + vip + ":" + port + path + " -H 'host: " + serverName + "'";
        String res = LinuxCmd.exec(cmd);
        JSONObject resJson = JSONObject.parseObject(res);
        if (resJson.getString("port").equals(instancePort) && resJson.getString("path").equals(path))
            return true;
        else
            return false;
    }

    private static Boolean checkCurlResponse(String cmd, int time) {
        Boolean flag = false;
        for (int i = 0; i < time; i++) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            if (LinuxCmd.exec(cmd).trim().equals("200")) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void checkRedictEffective(String sourceDomain, String sourcePath, String targetDomain,
                                               String targetPath, String serverIp, String serverPort) {
        String cmd = "curl http://" + sourceDomain + ":80" + sourcePath + " -kL";
        JSONObject res = JSONObject.parseObject(LinuxCmd.exec(cmd).trim());
        assertEquals(res.getString("hostname"), targetDomain,
                res.getString("hostname")+" != targetDomain("+targetDomain+")");
        assertEquals(res.getString("path"), sourcePath.contains("?")?targetPath : targetPath + "?",
                res.getString("path")+" != targetPath("+targetPath+")");
        assertEquals(res.getString("x-forwarded-proto"), "https",
                "proto != https");
        assertEquals(res.getString("ip"), serverIp, "serverIp wrong");
        assertEquals(res.getString("port"), serverPort, "serverPort wrong");
    }
}
