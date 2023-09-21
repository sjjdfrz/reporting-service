package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.PoliceType;
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
@DiscriminatorValue("police")
@SQLDelete(sql = "UPDATE reports SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PoliceReport extends Report{

    private PoliceType type;
    private boolean approved = false;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.POLICE_EXPIRES_AT));
    }
}
