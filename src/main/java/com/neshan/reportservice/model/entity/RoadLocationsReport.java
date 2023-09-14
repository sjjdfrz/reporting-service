package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.RoadLocationsType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("road_locations")
public class RoadLocationsReport extends Report{

    @Id
    @SequenceGenerator(
            name = "road_locations_report_sequence",
            sequenceName = "road_locations_report_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "road_locations_report_sequence"
    )
    private long id;

    private RoadLocationsType type;
}
