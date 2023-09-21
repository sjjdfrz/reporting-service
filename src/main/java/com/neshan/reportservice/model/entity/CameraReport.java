package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.CameraType;
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
@DiscriminatorValue("camera")
@SQLDelete(sql = "UPDATE reports SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CameraReport extends Report{

    private CameraType type;
    private boolean approved = false;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.CAMERA_EXPIRES_AT));
    }
}
