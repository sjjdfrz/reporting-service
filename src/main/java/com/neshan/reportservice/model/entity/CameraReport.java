package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.CameraType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("camera")
public class CameraReport extends Report{

    @Id
    @SequenceGenerator(
            name = "camera_report_sequence",
            sequenceName = "camera_report_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "camera_report_sequence"
    )
    private long id;

    private CameraType type;
}
