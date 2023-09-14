package com.neshan.reportservice.model.dto;

import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Point;

public record SpeedBumpReportDto(

        @NotNull(message = "You must specify location of report!")
        Point point
) {
}
