package com.example.monitoring.service;

import com.example.monitoring.client.PaySafeClient;
import com.example.monitoring.client.PaySafeResponse;
import com.example.monitoring.web.MonitorRequest;
import com.example.monitoring.web.OverviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.Logger;
import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public class MonitoringServiceImplementation implements MonitoringService {

    private Logger logger = Logger.getLogger(String.valueOf(MonitoringServiceImplementation.class));

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(0);
    private Map<Date, String> statusTimeMap = new HashMap<>();

    @Autowired
    private PaySafeClient paySafeClient;

    @Override
    public void start(MonitorRequest request) {
        //scheduler.
        if (((ScheduledThreadPoolExecutor) scheduler).getCorePoolSize() == 0) {
            scheduler = Executors.newScheduledThreadPool(1);
            statusTimeMap = new HashMap<>();
            final Runnable monitor = () -> {
                logger.info(String.format("Calling PaySafe every %s seconds", request.getInterval()));
                PaySafeResponse response = paySafeClient.monitorServer(request.getServer());
                statusTimeMap.put(new Date(), response.getStatus());
            };

            final ScheduledFuture<?> scheduleAtFixedRate = scheduler.scheduleAtFixedRate(monitor, 0, request.getInterval(), SECONDS);

            scheduler.schedule(() -> {
                scheduleAtFixedRate.cancel(true);
            }, 60 * 60, SECONDS);
        } else {
            logger.warning("One of the monitoring job is running already!");
        }
    }

    @Override
    public void stop() {
        logger.info("Stopping Scheduler");
        scheduler.shutdown();
        scheduler = Executors.newScheduledThreadPool(0);
        ((ScheduledThreadPoolExecutor)scheduler).setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
    }

    @Override
    public OverviewResponse overview() {
        logger.info("Getting monitoring overview");
        OverviewResponse response = new OverviewResponse();
        response.setOverview(statusTimeMap);

        return response;
    }
}
