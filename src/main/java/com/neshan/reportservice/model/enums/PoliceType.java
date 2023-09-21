package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PoliceType {

    POLICE(11), SECRET_POLICE(12);

    private final int code;
}
