package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.WayEventsType;
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
@DiscriminatorValue("way_events")
public class WayEventsReport extends Report{

    private WayEventsType type;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.WAY_EVENTS_EXPIRES_AT));
    }
}
