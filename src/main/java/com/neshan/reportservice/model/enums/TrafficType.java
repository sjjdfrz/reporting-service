package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TrafficType {

    LIGHT(0), SEMI_HEAVY(1), HEAVY(2);

    private final int code;
}
