package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.AccidentType;
import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Point;

public record AccidentReportDto(

        @NotNull(message = "You must specify location of report!")
        Point point,

        @NotNull(message = "You must specify accident type!")
        AccidentType accidentType
) {
}
