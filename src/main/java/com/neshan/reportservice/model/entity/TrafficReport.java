package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.TrafficType;
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
@DiscriminatorValue("traffic")
@SQLDelete(sql = "UPDATE reports SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class TrafficReport extends Report{

    private TrafficType type;
    private boolean approved = false;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.TRAFFIC_EXPIRES_AT));
    }
}
