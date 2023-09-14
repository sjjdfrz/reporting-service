package com.neshan.reportservice.model.entity;


import com.neshan.reportservice.model.enums.TrafficType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("traffic")
public class TrafficReport extends Report{

    @Id
    @SequenceGenerator(
            name = "traffic_report_sequence",
            sequenceName = "traffic_report_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "traffic_report_sequence"
    )
    private long id;

    private TrafficType type;
}
