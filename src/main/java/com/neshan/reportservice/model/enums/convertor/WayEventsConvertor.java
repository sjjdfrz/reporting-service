package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.WayEventsType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class WayEventsConvertor implements AttributeConverter<WayEventsType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(WayEventsType wayEventsType) {
        if (wayEventsType == null) {
            return null;
        }
        return wayEventsType.getCode();
    }

    @Override
    public WayEventsType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(WayEventsType.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
