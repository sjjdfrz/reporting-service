package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpeedBumpType {

    PLASTIC(0), RUBBER(1), ASPHALT(2);

    private final int code;
}
