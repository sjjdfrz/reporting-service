package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MapBugsType {

    CIRCULATION_DIRECTION(5),
    DEAD_END(6),
    NO_ENTRY(7),
    EARTHY(8),
    NO_CAR(9),
    OTHER(10);

    private final int code;
}
