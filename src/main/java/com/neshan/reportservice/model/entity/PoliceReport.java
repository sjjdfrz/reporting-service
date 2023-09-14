package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.PoliceType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("police")
public class PoliceReport extends Report{

    private PoliceType type;
}
