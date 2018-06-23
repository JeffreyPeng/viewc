package com.pyx.viewc;

import java.util.Date;

public class WebSiteForm extends  WebSite{

    public String getShowUrl() {
        if (getUrl() != null && getUrl().length() > 20) {
            return getUrl().substring(0, 20).concat("...");
        }
        return getUrl();
    }

    public boolean isReadyToSee() {
        if (getLeftTime() == null) {
            return true;
        }
        return false;
    }

    public String getLeftTime() {
        int timeMargin = getTimeMargin();
        Date lastSeen = getLastSeen();
        if (lastSeen == null) {
            return null;
        }
        long margin = timeMargin * 60 * 60 * 1000;
        long timeLeft = lastSeen.getTime() + margin - new Date().getTime();
        timeLeft = timeLeft / 1000;
        if (timeLeft > 0) {
            long hours = timeLeft / (60 * 60);
            long minutes = timeLeft % (60 * 60) / 60;
            long seconds = timeLeft % 60;
            StringBuilder builder = new StringBuilder();
            if (hours > 0) {
                builder.append(hours + "时");
            }
            if (minutes > 0) {
                builder.append(minutes + "分");
            }
            if (seconds > 0) {
                builder.append(seconds + "秒");
            }
            return builder.toString();
        }
        return null;
    }
}
