package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MapBugsType {

    CIRCULATION_DIRECTION(0),
    DEAD_END(1),
    NO_ENTRY(2),
    EARTHY(3),
    NO_CAR(4),
    OTHER(5);

    private final int code;
}
