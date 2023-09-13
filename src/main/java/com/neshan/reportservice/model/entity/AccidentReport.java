package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.AccidentType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("accident")
public class AccidentReport extends Report{

    @Id
    @SequenceGenerator(
            name = "accident_report_sequence",
            sequenceName = "accident_report_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accident_report_sequence"
    )
    private long id;

    private AccidentType type;
}
