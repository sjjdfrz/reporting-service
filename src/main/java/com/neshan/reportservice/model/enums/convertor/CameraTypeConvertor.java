package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.CameraType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class CameraTypeConvertor implements AttributeConverter<CameraType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CameraType cameraType) {
        if (cameraType == null) {
            return null;
        }
        return cameraType.getCode();
    }

    @Override
    public CameraType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(CameraType.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
