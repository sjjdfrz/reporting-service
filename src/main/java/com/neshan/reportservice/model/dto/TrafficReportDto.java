package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.TrafficType;
import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Point;

public record TrafficReportDto(

        @NotNull(message = "You must specify location of report!")
        Point point,

        @NotNull(message = "You must specify traffic type!")
        TrafficType trafficType
) {
}
