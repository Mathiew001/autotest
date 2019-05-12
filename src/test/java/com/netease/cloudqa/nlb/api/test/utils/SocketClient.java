package com.netease.cloudqa.nlb.api.test.utils;

import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.testng.Assert;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class SocketClient {

    //protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SocketClient.class);

    public void connect(String address, Integer port, String protocol) {
        InputStream is = null;
        OutputStream os = null;
        Socket socket;
        try {
            if (protocol.equals("https"))
                socket = SSLSocketFactory.getDefault().createSocket();
            else
                socket = new Socket();
            socket.connect(new InetSocketAddress(address, port), 3000);
            //构建IO
            is = socket.getInputStream();
            os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("abcd\n");
            bw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String mess = br.readLine();
            System.out.println("server response: " + mess + " from " + address + ":" + port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("connection access check failed: " + address + ":" + port);
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (os != null)
                    os.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new SocketClient().connect("60.191.87.12", 443, "http");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
