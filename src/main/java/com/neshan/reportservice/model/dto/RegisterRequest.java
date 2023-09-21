package com.neshan.reportservice.model.dto;


import com.neshan.reportservice.validation.PasswordMatching;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
@PasswordMatching(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "Password and Confirm Password must be matched!"
)
public record RegisterRequest(

        @NotBlank(message = "Invalid firstName: Empty firstname!")
        String firstName,

        @NotBlank(message = "Invalid lastName: Empty lastname!")
        String lastName,

        @NotBlank(message = "Invalid Email: Empty email!")
        @Email
        String email,

        @Pattern(
                regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"
                , message = """
                The password must contain at least:
                 one uppercase letter, one lowercase letter,
                 one digit, one special character(#?!@$%^&*-).
                 Also a minimum length of password is 8 characters.
                """)
        String password,

        @NotBlank(message = "Invalid ConfirmPassword: Empty confirmPassword!")
        String confirmPassword
) {
}
