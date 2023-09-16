package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.SpeedBumpType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("speed_bump")
public class SpeedBumpReport extends Report{

    private SpeedBumpType type;
}
