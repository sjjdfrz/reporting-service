package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeatherConditionsType {

    TIRE_CHAINS(0), FOG(1), SLIPPERY_ROAD(2);

    private final int code;
}
