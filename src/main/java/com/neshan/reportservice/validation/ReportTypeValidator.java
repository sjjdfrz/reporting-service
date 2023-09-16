package com.neshan.reportservice.validation;

import com.neshan.reportservice.model.dto.ReportDto;
import com.neshan.reportservice.model.enums.*;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class ReportTypeValidator implements ConstraintValidator<ValidReportType, ReportDto> {

    @Override
    public boolean isValid(ReportDto reportDto, ConstraintValidatorContext constraintValidatorContext) {

        return switch (reportDto.title()) {

            case ACCIDENT -> isEnumNameContained(AccidentType.values(), reportDto);
            case CAMERA -> isEnumNameContained(CameraType.values(), reportDto);
            case MAP_BUGS -> isEnumNameContained(MapBugsType.values(), reportDto);
            case POLICE -> isEnumNameContained(PoliceType.values(), reportDto);
            case ROAD_LOCATIONS -> isEnumNameContained(RoadLocationsType.values(), reportDto);
            case SPEED_BUMP -> isEnumNameContained(SpeedBumpType.values(), reportDto);
            case TRAFFIC -> isEnumNameContained(TrafficType.values(), reportDto);
            case WAY_EVENTS -> isEnumNameContained(WayEventsType.values(), reportDto);
            case WEATHER_CONDITIONS -> isEnumNameContained(WeatherConditionsType.values(), reportDto);
        };
    }

    private boolean isEnumNameContained(Enum<?>[] enumValues, ReportDto reportDto) {
        return Arrays.stream(enumValues)
                .map(Enum::name)
                .anyMatch(enumName -> enumName.equals(reportDto.type().name()));
    }
}
