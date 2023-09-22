package com.neshan.reportservice.model.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LoginRequest(

        @NotBlank(message = "Invalid Email: Empty email!")
        @Email
        String email,

        @NotBlank(message = "Invalid Password: Empty password!")
        String password
) {
}
