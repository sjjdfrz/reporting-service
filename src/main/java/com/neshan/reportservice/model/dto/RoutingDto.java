package com.neshan.reportservice.model.dto;

import jakarta.validation.constraints.NotBlank;

public record RoutingDto(

        @NotBlank(message = "You must specify lineString of your route!")
        String lineString
) {
}
