package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.WayEventsType;
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
@DiscriminatorValue("way_events")
@SQLDelete(sql = "UPDATE reports SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class WayEventsReport extends Report{

    private WayEventsType type;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.WAY_EVENTS_EXPIRES_AT));
    }
}
