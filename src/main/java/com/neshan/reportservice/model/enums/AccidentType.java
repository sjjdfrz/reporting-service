package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccidentType {

    LIGHT(0), HEAVY(1), OPPOSITE_LINE(2);

    private final int code;
}
