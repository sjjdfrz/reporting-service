package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.WeatherConditionsType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("weather_conditions")
public class WeatherConditionsReport extends Report{

    @Id
    @SequenceGenerator(
            name = "weather_conditions_report_sequence",
            sequenceName = "weather_conditions_report_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "weather_conditions_report_sequence"
    )
    private long id;

    private WeatherConditionsType type;
}
