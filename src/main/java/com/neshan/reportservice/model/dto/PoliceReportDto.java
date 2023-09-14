package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.PoliceType;
import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Point;

public record PoliceReportDto(

        @NotNull(message = "You must specify location of report!")
        Point point,

        @NotNull(message = "You must specify police type!")
        PoliceType policeType
) {
}
