package com.neshan.reportservice.model.entity;

import com.neshan.reportservice.model.enums.AccidentType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
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
}
