package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReportTitle {
    ACCIDENT(0),
    CAMERA(1),
    MAP_BUGS(2),
    POLICE(3),
    ROAD_LOCATIONS(4),
    SPEED_BUMP(5),
    TRAFFIC(6),
    WAY_EVENTS(7),
    WEATHER_CONDITIONS(8);

    private final int code;
}
