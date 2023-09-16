package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.WeatherConditionsType;
import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Point;

public record WeatherConditionsReportDto(

        @NotNull(message = "You must specify location of report!")
        Point point,

        @NotNull(message = "You must specify weatherConditions type!")
        WeatherConditionsType weatherConditionsType
) {
}
