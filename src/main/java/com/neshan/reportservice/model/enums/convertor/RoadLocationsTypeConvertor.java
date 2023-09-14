package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.RoadLocationsType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoadLocationsTypeConvertor implements AttributeConverter<RoadLocationsType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(RoadLocationsType roadLocationsType) {
        if (roadLocationsType == null) {
            return null;
        }
        return roadLocationsType.getCode();
    }

    @Override
    public RoadLocationsType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(RoadLocationsType.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
