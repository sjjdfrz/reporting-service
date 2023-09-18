package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.RoadLocationsType;
import com.neshan.reportservice.util.ReportConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("road_locations")
public class RoadLocationsReport extends Report{

    private RoadLocationsType type;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.ROAD_LOCATIONS_EXPIRES_AT));
    }
}
