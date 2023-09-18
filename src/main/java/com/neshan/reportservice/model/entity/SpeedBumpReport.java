package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.SpeedBumpType;
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
@DiscriminatorValue("speed_bump")
public class SpeedBumpReport extends Report{

    private SpeedBumpType type;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.SPEED_BUMP_EXPIRES_AT));
    }
}
