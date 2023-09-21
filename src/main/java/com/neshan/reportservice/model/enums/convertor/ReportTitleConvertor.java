package com.neshan.reportservice.model.enums.convertor;

import com.neshan.reportservice.model.enums.ReportTitle;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ReportTitleConvertor implements AttributeConverter<ReportTitle, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ReportTitle reportTitle) {
        if (reportTitle == null) {
            return null;
        }
        return reportTitle.getCode();
    }

    @Override
    public ReportTitle convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(ReportTitle.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
