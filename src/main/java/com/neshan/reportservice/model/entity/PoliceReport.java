package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.PoliceType;
import com.neshan.reportservice.util.ReportConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("police")
public class PoliceReport extends Report{

    private PoliceType type;
    private boolean approved = false;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.POLICE_EXPIRES_AT));
    }
}
