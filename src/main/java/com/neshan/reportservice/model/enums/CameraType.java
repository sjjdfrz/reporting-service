package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CameraType {

    RED_LIGHT(0), SPEED_CONTROL(1);

    private final int code;
}
