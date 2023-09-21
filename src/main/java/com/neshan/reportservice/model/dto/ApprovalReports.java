package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.ReportType;

public interface ApprovalReports {
    Long getId();
    String getLocation();
    String getTitle();
    ReportType getType();
}
