package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.TrafficType;
import com.neshan.reportservice.util.ReportConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("traffic")
public class TrafficReport extends Report{

    private TrafficType type;
    private boolean approved = false;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.TRAFFIC_EXPIRES_AT));
    }
}
