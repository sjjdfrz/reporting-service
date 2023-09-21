package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CameraType {

    RED_LIGHT(3), SPEED_CONTROL(4);

    private final int code;
}
