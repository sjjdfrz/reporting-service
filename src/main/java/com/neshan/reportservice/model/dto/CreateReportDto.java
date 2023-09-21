package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.Point;
import com.neshan.reportservice.model.enums.ReportTitle;
import com.neshan.reportservice.model.enums.ReportType;
import com.neshan.reportservice.validation.ValidReportType;
import jakarta.validation.constraints.NotNull;

// FOR CREATION
@ValidReportType
public record CreateReportDto(

        @NotNull(message = "You must specify location of report!")
        Point location,

        @NotNull(message = "You must specify title of report!")
        ReportTitle title,

        @NotNull(message = "You must specify type of report!")
        ReportType type
) {
}
