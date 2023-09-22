package com.neshan.reportservice.model.dto.report;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.neshan.reportservice.model.Point;
import com.neshan.reportservice.model.enums.ReportTitle;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "title",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AccidentReportDto.class, name = "ACCIDENT"),
        @JsonSubTypes.Type(value = CameraReportDto.class, name = "CAMERA"),
        @JsonSubTypes.Type(value = MapBugsReportDto.class, name = "MAP_BUGS"),
        @JsonSubTypes.Type(value = PoliceReportDto.class, name = "POLICE"),
        @JsonSubTypes.Type(value = RoadLocationsReportDto.class, name = "ROAD_LOCATIONS"),
        @JsonSubTypes.Type(value = SpeedBumpReportDto.class, name = "SPEED_BUMP"),
        @JsonSubTypes.Type(value = TrafficReportDto.class, name = "TRAFFIC"),
        @JsonSubTypes.Type(value = WayEventsReportDto.class, name = "WAY_EVENTS"),
        @JsonSubTypes.Type(value = WeatherConditionsReportDto.class, name = "WEATHER_CONDITIONS"),
})
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public abstract class ReportDto {

        @NotNull(message = "You must specify location of report!")
        Point location;

        @NotNull(message = "You must specify title of report!")
        ReportTitle title;
}
