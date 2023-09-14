package com.neshan.reportservice.model.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("speed_bump")
public class SpeedBumpReport extends Report{

    @Id
    @SequenceGenerator(
            name = "speed_bump_report_sequence",
            sequenceName = "speed_bump_report_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "speed_bump_report_sequence"
    )
    private long id;
}
