package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.PoliceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("police")
public class PoliceReport extends Report{

    private PoliceType type;
}
