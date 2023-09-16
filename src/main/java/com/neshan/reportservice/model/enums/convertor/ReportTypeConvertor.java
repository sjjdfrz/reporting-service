package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.ReportType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ReportTypeConvertor implements AttributeConverter<ReportType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ReportType reportType) {
        if (reportType == null) {
            return null;
        }
        return reportType.getCode();
    }

    @Override
    public ReportType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(ReportType.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
