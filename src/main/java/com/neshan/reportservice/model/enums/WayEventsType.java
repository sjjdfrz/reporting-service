package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WayEventsType {

    BLOCKED_ROAD(0), HOLE(1), CONSTRUCTION(2);

    private final int code;
}
