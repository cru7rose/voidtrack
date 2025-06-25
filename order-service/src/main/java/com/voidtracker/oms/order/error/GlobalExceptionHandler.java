package com.voidtracker.oms.order.error;

import com.voidtracker.oms.commons.dto.ApiErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.Instant;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDto> handleAllExceptions(Exception ex, WebRequest request) {
        String correlationId = UUID.randomUUID().toString();
        ApiErrorDto error = new ApiErrorDto(
                "INTERNAL_ERROR",
                "An unexpected error occurred.",
                ex.getMessage()
        );
        // TODO: Log error with correlationId and Instant.now(), optionally send to monitoring/APM
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
