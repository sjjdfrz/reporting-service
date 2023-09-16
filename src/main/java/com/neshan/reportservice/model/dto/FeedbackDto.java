package com.neshan.reportservice.model.dto;

import com.neshan.reportservice.model.enums.FeedbackAction;
import jakarta.validation.constraints.NotNull;

public record FeedbackDto(

        @NotNull(message = "You didn't specify your feedback!")
        FeedbackAction action
) {
}
