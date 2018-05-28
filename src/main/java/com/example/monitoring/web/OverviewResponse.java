package com.example.monitoring.web;

import java.util.Date;
import java.util.Map;

public class OverviewResponse {
    Map<Date, String> overview;

    public Map<Date, String> getOverview() {
        return overview;
    }

    public void setOverview(Map<Date, String> overview) {
        this.overview = overview;
    }
}
