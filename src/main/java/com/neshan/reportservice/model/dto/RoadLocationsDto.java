package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.RoadLocationsType;
import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Point;

public record RoadLocationsDto(

        @NotNull(message = "You must specify location of report!")
        Point point,

        @NotNull(message = "You must specify roadLocations type!")
        RoadLocationsType roadLocationsType
) {
}
