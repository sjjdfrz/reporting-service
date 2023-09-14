package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.AccidentType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class AccidentTypeConvertor implements AttributeConverter<AccidentType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AccidentType accidentType) {
        if (accidentType == null) {
            return null;
        }
        return accidentType.getCode();
    }

    @Override
    public AccidentType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(AccidentType.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
