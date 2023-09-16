package com.neshan.reportservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNoSuchElementFoundException(NoSuchElementFoundException exc) {

        ErrorResponse err = buildErrorResponse(exc);
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllUncaughtException(Exception exc) {

        ErrorResponse err = buildErrorResponse(exc);
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException exc) {

        if (exc.getBindingResult().getFieldErrors().isEmpty()) {
            ErrorResponse err = buildErrorResponse(Objects.requireNonNull(exc.getGlobalError()).getDefaultMessage());
            return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
        }

        ErrorResponse err = ErrorResponse
                .builder()
                .timestamp(System.currentTimeMillis())
                .build();

        for (FieldError fieldError : exc.getBindingResult().getFieldErrors()) {
            err.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public ErrorResponse buildErrorResponse(Exception exc) {

        return ErrorResponse
                .builder()
                .message(exc.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    public ErrorResponse buildErrorResponse(String message) {

        return ErrorResponse
                .builder()
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
    }
}
