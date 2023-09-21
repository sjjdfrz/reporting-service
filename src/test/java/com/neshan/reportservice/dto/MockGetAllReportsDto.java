package com.neshan.reportservice.dto;

import com.neshan.reportservice.model.dto.GetAllReportsDto;
import com.neshan.reportservice.model.enums.ReportType;

public record MockGetAllReportsDto(
        long id,
        String title,
        ReportType type) implements GetAllReportsDto {

    @Override
    public long getId() {
        return id;
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
