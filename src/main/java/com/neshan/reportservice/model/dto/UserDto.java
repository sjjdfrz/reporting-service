package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.ReportType;

public interface UserDto {

    String getFirstName();

    String getTitle();

    ReportType getType();

    String getLocation();
}
