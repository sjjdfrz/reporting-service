package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoadLocationsType {

    RED_CRESCENT(13),
    GAS_STATION(14),
    BENZINE_STATION(15),
    HIGHWAY_PATROL(16),
    WELFARE_SERVICES(17),
    PARKING(18);

    private final int code;
}
