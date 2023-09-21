package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TrafficType {

    LIGHT(0), SEMI_HEAVY(19), HEAVY(1);

    private final int code;
}
