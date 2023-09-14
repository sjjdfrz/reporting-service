package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.CameraType;
import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Point;

public record CameraReportDto(

        @NotNull(message = "You must specify location of report!")
        Point point,

        @NotNull(message = "You must specify camera type!")
        CameraType cameraType
) {
}
