package com.pyx.viewc;

import java.util.Date;

public class WebSite {

    private Long id;
    private String name;
    private String url;
    private int timeMargin;
    private Date lastSeen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTimeMargin() {
        return timeMargin;
    }

    public void setTimeMargin(int timeMargin) {
        this.timeMargin = timeMargin;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    @Override
    public String toString() {
        return "WebSite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", timeMargin=" + timeMargin +
                ", lastSeen=" + lastSeen +
                '}';
    }
}
