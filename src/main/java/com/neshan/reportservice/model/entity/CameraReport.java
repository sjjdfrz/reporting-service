package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.CameraType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("camera")
public class CameraReport extends Report{

    private CameraType type;
}
