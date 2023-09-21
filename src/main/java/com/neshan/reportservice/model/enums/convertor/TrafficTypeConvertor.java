package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.TrafficType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class TrafficTypeConvertor implements AttributeConverter<TrafficType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TrafficType trafficType) {
        if (trafficType == null) {
            return null;
        }
        return trafficType.getCode();
    }

    @Override
    public TrafficType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(TrafficType.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
