package com.pyx.viewc;

import java.util.Date;

public class HeartBeat {

    private Long id;
    private String hostName;
    private String ip;
    private Date recvTime;

    public HeartBeat() {
    }

    public HeartBeat(String hostName, String ip) {
        this.hostName = hostName;
        this.ip = ip;
        this.recvTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getRecvTime() {
        return recvTime;
    }

    public void setRecvTime(Date recvTime) {
        this.recvTime = recvTime;
    }

    @Override
    public String toString() {
        return "HeartBeat{" +
                "id=" + id +
                ", hostName='" + hostName + '\'' +
                ", ip='" + ip + '\'' +
                ", recvTime=" + recvTime +
                '}';
    }
}
