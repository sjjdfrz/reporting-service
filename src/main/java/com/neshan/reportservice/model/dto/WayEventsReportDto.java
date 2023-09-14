package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.WayEventsType;
import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Point;

public record WayEventsReportDto(

        @NotNull(message = "You must specify location of report!")
        Point point,

        @NotNull(message = "You must specify wayEvents type!")
        WayEventsType wayEventsType
) {
}
