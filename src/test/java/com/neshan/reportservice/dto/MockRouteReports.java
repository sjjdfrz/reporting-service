package com.neshan.reportservice.dto;

import com.neshan.reportservice.model.dto.RouteReports;
import com.neshan.reportservice.model.enums.ReportType;

public record MockRouteReports(
        String location,
        String title,
        ReportType type) implements RouteReports {

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public ReportType getType() {
        return type;
    }
}
