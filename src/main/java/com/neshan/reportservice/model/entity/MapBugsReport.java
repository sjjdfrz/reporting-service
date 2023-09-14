package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.MapBugsType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("map_bugs")
public class MapBugsReport extends Report{

    @Id
    @SequenceGenerator(
            name = "map_bugs_report_sequence",
            sequenceName = "map_bugs_report_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "map_bugs_report_sequence"
    )
    private long id;

    private MapBugsType type;
}
