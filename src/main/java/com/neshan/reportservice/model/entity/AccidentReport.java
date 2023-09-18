package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.AccidentType;
import com.neshan.reportservice.util.ReportConstants;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("accident")
public class AccidentReport extends Report{

    private AccidentType type;
    private boolean approved = false;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.ACCIDENT_EXPIRES_AT));
    }
}
