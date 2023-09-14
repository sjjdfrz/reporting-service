package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoadLocationsType {

    RED_CRESCENT(0),
    GAS_STATION(1),
    BENZINE_STATION(2),
    HIGHWAY_PATROL(3),
    WELFARE_SERVICES(4),
    PARKING(5);

    private final int code;
}
