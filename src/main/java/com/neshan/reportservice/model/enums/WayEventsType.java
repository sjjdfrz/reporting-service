package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WayEventsType {

    BLOCKED_ROAD(20), HOLE(21), CONSTRUCTION(22);

    private final int code;
}
