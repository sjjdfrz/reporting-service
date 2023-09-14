package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PoliceType {

    POLICE(0), SECRET_POLICE(1), OPPOSITE_LINE(2);

    private final int code;
}
