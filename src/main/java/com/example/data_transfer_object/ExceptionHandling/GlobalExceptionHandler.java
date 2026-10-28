package com.example.data_transfer_object.ExceptionHandling;

import com.example.data_transfer_object.DTO.ExceptionDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionDTO> handleDuplicateResourceException(
            DuplicateResourceException e,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;

        ExceptionDTO response = new ExceptionDTO(
                status.value(),
                e.getMessage(),
                status.getReasonPhrase(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(DeletedResourceException.class)
    public ResponseEntity<ExceptionDTO> handleDeletedResourceException(
            DeletedResourceException e,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionDTO response = new ExceptionDTO(
                status.value(),
                e.getMessage(),
                status.getReasonPhrase(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleResourceNotFoundException(
            ResourceNotFoundException e,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionDTO response = new ExceptionDTO(
                status.value(),
                e.getMessage(),
                status.getReasonPhrase(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleException(
            Exception e,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ExceptionDTO response = new ExceptionDTO(
                status.value(),
                "Something went wrong. Please try again later.",
                status.getReasonPhrase(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(response);
    }
}


