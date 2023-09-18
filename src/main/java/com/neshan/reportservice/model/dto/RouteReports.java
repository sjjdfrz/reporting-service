package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.ReportType;

// FOR SENDING TO CLIENTS BY ROUTING
public interface RouteReports {
    String getLocation();
    String getTitle();
    ReportType getType();
}
