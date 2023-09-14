package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.MapBugsType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class MapBugsTypeConvertor implements AttributeConverter<MapBugsType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MapBugsType mapBugsType) {
        if (mapBugsType == null) {
            return null;
        }
        return mapBugsType.getCode();
    }

    @Override
    public MapBugsType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(MapBugsType.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}