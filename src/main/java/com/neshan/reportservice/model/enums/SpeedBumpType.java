package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpeedBumpType {

    PLASTIC(26), RUBBER(27), ASPHALT(28);

    private final int code;
}
