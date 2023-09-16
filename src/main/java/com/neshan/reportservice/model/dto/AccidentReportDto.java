package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.AccidentType;
import org.locationtech.jts.geom.Point;

public record AccidentReportDto(

        Point point,
        AccidentType type
) {
}
