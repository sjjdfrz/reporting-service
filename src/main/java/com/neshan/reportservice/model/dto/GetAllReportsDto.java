package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.ReportType;

public interface GetAllReportsDto {

    long getId();
    String getTitle();
    ReportType getType();
}
