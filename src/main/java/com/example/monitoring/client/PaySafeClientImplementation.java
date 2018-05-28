package com.example.monitoring.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaySafeClientImplementation implements PaySafeClient {

    private static final String PAYSAFE_MONITOR_API = "https://api.test.paysafe.com/%s/monitor";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PaySafeResponse monitorServer(String server) {
        return restTemplate.getForEntity(String.format(PAYSAFE_MONITOR_API, server), PaySafeResponse.class).getBody();
    }
}
