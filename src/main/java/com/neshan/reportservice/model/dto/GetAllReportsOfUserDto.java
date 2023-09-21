package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.ReportType;

import java.time.LocalDateTime;

public interface GetAllReportsOfUserDto{

    long getId();
    String getTitle();
    String getLocation();
    ReportType getType();
    String getDate();
}
