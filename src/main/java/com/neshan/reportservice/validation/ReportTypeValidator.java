package com.neshan.reportservice.validation;

import com.neshan.reportservice.model.dto.CreateReportDto;
import com.neshan.reportservice.model.enums.*;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class ReportTypeValidator implements ConstraintValidator<ValidReportType, CreateReportDto> {

    @Override
    public boolean isValid(CreateReportDto createReportDto, ConstraintValidatorContext constraintValidatorContext) {

        return switch (createReportDto.title()) {

            case ACCIDENT -> isEnumNameContained(AccidentType.values(), createReportDto);
            case CAMERA -> isEnumNameContained(CameraType.values(), createReportDto);
            case MAP_BUGS -> isEnumNameContained(MapBugsType.values(), createReportDto);
            case POLICE -> isEnumNameContained(PoliceType.values(), createReportDto);
            case ROAD_LOCATIONS -> isEnumNameContained(RoadLocationsType.values(), createReportDto);
            case SPEED_BUMP -> isEnumNameContained(SpeedBumpType.values(), createReportDto);
            case TRAFFIC -> isEnumNameContained(TrafficType.values(), createReportDto);
            case WAY_EVENTS -> isEnumNameContained(WayEventsType.values(), createReportDto);
            case WEATHER_CONDITIONS -> isEnumNameContained(WeatherConditionsType.values(), createReportDto);
        };
    }

    private boolean isEnumNameContained(Enum<?>[] enumValues, CreateReportDto createReportDto) {
        return Arrays.stream(enumValues)
                .map(Enum::name)
                .anyMatch(enumName -> enumName.equals(createReportDto.type().name()));
    }
}
