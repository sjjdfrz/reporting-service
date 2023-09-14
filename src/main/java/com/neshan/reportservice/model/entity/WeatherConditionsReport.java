package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.WeatherConditionsType;
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
}
