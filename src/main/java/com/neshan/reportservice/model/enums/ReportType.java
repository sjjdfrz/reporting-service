package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReportType {

    LIGHT(0),
    HEAVY(1),
    OPPOSITE_LINE(2),
    RED_LIGHT(3),
    SPEED_CONTROL(4),
    CIRCULATION_DIRECTION(5),
    DEAD_END(6),
    NO_ENTRY(7),
    EARTHY(8),
    NO_CAR(9),
    OTHER(10),
    POLICE(11),
    SECRET_POLICE(12),
    RED_CRESCENT(13),
    GAS_STATION(14),
    BENZINE_STATION(15),
    HIGHWAY_PATROL(16),
    WELFARE_SERVICES(17),
    PARKING(18),
    SEMI_HEAVY(19),
    BLOCKED_ROAD(20),
    HOLE(21),
    CONSTRUCTION(22),
    TIRE_CHAINS(23),
    FOG(24),
    SLIPPERY_ROAD(25),
    PLASTIC(26),
    RUBBER(27),
    ASPHALT(28);

    private final int code;
}
