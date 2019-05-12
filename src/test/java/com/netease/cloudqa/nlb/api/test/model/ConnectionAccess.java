package com.netease.cloudqa.nlb.api.test.model;

public class ConnectionAccess {

    private String instanceId;

    private String address;

    private Integer port;

    private String protocol;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String toString()
    {
        return "instanceId: " + this.instanceId + "\n" + "address: " + this.address + "\n" + "ports: " + this.port;
    }
}
