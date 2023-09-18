package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.MapBugsType;
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
@DiscriminatorValue("map_bugs")
public class MapBugsReport extends Report{

    private MapBugsType type;

    @PrePersist
    public void prePersist() {
        setExpiresAt(getCreatedAt().plusMinutes(ReportConstants.MAP_BUGS_EXPIRES_AT));
    }
}
