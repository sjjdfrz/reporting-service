package com.neshan.reportservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = ReportTypeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidReportType {

    String message() default "The type of report is not valid!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
