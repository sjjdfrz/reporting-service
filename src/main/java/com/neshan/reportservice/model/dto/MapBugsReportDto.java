package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.MapBugsType;
import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Point;

public record MapBugsReportDto(

        @NotNull(message = "You must specify location of report!")
        Point point,

        @NotNull(message = "You must specify mapBugs type")
        MapBugsType mapBugsType
) {
}
