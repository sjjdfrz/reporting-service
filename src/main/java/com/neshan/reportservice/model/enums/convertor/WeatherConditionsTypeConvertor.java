package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.WeatherConditionsType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class WeatherConditionsTypeConvertor implements AttributeConverter<WeatherConditionsType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(WeatherConditionsType weatherConditionsType) {
        if (weatherConditionsType == null) {
            return null;
        }
        return weatherConditionsType.getCode();
    }

    @Override
    public WeatherConditionsType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(WeatherConditionsType.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
