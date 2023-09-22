package com.neshan.reportservice.model.dto.user;

import com.neshan.reportservice.model.enums.ReportType;

public interface UserDto {

    String getFirstName();

    String getTitle();

    ReportType getType();

    String getLocation();
}
