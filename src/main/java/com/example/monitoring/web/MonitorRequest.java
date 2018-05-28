package com.example.monitoring.web;

import javax.validation.constraints.NotNull;

public class MonitorRequest {

    @NotNull
    private long interval;

    @NotNull
    private String server;

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
