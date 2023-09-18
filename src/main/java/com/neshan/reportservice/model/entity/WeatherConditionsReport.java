package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.WeatherConditionsType;
import com.neshan.reportservice.util.ReportConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("weather_conditions")
public class WeatherConditionsReport extends Report{

    private WeatherConditionsType type;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.WEATHER_CONDITIONS_EXPIRES_AT));
    }
}
