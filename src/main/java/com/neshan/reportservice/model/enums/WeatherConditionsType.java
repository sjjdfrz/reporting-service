package com.neshan.reportservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeatherConditionsType {

    TIRE_CHAINS(23), FOG(24), SLIPPERY_ROAD(25);

    private final int code;
}
