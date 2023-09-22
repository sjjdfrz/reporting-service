package com.neshan.reportservice.model.dto.report;

import com.neshan.reportservice.model.enums.AccidentType;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AccidentReportDto extends ReportDto {

    @NotNull(message = "You must specify accident type!")
    AccidentType type;
}
