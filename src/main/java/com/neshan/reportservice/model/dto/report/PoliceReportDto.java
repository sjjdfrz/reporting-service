package com.neshan.reportservice.model.dto.report;

import com.neshan.reportservice.model.enums.PoliceType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PoliceReportDto extends ReportDto {

        @NotNull(message = "You must specify accident type!")
        PoliceType type;
}
