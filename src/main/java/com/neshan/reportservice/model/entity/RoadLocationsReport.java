package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.RoadLocationsType;
import com.neshan.reportservice.util.ReportConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("road_locations")
@SQLDelete(sql = "UPDATE reports SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class RoadLocationsReport extends Report{

    private RoadLocationsType type;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.ROAD_LOCATIONS_EXPIRES_AT));
    }
}
