package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.WayEventsType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("way_events")
public class WayEventsReport extends Report{

    @Id
    @SequenceGenerator(
            name = "way_events_report_sequence",
            sequenceName = "way_events_report_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "way_events_report_sequence"
    )
    private long id;

    private WayEventsType type;
}
