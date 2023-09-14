package com.neshan.reportservice.model.entity;


import com.neshan.reportservice.model.enums.TrafficType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("traffic")
public class TrafficReport extends Report{

    private TrafficType type;
}
