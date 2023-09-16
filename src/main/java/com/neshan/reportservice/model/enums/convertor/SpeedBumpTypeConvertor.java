package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.SpeedBumpType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SpeedBumpTypeConvertor implements AttributeConverter<SpeedBumpType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SpeedBumpType speedBumpType) {
        if (speedBumpType == null) {
            return null;
        }
        return speedBumpType.getCode();
    }

    @Override
    public SpeedBumpType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(SpeedBumpType.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
