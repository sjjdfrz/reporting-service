package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.WayEventsType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("way_events")
public class WayEventsReport extends Report{

    private WayEventsType type;
}
