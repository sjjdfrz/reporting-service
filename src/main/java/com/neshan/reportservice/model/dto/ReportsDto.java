package com.neshan.reportservice.model.dto;


import com.neshan.reportservice.model.enums.ReportType;

public interface ReportsDto {
    String getLocation();
    String getTitle();
    ReportType getType();
}
