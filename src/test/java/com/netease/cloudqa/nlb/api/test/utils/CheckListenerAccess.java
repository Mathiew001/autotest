package com.netease.cloudqa.nlb.api.test.utils;

import com.netease.cloudqa.nlb.api.test.model.ConnectionAccess;
import org.testng.Assert;

public class CheckListenerAccess implements Runnable {

    private ConnectionAccess target;

    public void setTarget(ConnectionAccess target) {
        this.target = target;
    }

    @Override
    public void run() {
        String address =  this.target.getAddress();
        Integer port = this.target.getPort();
        String protocol = this.target.getProtocol();
//        String cmd = "echo | telnet " + address + " " + port + " 2>/dev/null | grep \"\\^]\"|wc -l";
//        String res = LinuxCmd.exec(cmd);
        if (!protocol.equals("https")) {
            System.out.println("request to " + address + ":" + port);
            new SocketClient().connect(address, port, protocol);
        }
//        try {
//            Thread.sleep(5000);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        Assert.assertTrue(res.trim().equals("1"));
//        System.out.println(Thread.currentThread().getName());

    }
}
