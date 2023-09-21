package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.PoliceType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class PoliceTypeConvertor implements AttributeConverter<PoliceType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PoliceType policeType) {
        if (policeType == null) {
            return null;
        }
        return policeType.getCode();
    }

    @Override
    public PoliceType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(PoliceType.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
