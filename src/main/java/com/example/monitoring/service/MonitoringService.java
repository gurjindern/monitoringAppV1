package com.example.monitoring.service;

import com.example.monitoring.web.MonitorRequest;
import com.example.monitoring.web.OverviewResponse;

public interface MonitoringService {
    void start(MonitorRequest request);

    void stop();

    OverviewResponse overview();
}
