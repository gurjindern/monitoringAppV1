package com.example.monitoring.web;

import com.example.monitoring.service.MonitoringService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE, path = {"monitor"})

public class MonitoringController {

    @Autowired
    private MonitoringService service;

    @PostMapping(consumes=APPLICATION_JSON_VALUE,path= "start")
    private ResponseEntity<MonitorResponse> start(@RequestBody MonitorRequest request) {
        service.start(request);

        MonitorResponse response = new MonitorResponse();

        response.setStatus("started");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("stop")
    private ResponseEntity<MonitorResponse> stopMonitor() {
        service.stop();
        MonitorResponse response = new MonitorResponse();

        response.setStatus("stopped");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("overview")
    private ResponseEntity<OverviewResponse> getMonitoringOverview() {
        OverviewResponse response = service.overview();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}