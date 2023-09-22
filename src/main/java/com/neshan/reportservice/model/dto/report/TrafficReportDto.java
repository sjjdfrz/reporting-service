package com.neshan.reportservice.model.dto.report;

import com.neshan.reportservice.model.enums.TrafficType;
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
public class TrafficReportDto extends ReportDto {

        @NotNull(message = "You must specify accident type!")
        TrafficType type;
}
