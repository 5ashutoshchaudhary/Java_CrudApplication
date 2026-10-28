package com.example.data_transfer_object.DTO;

import java.time.LocalDateTime;

public class ExceptionDTO {

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    private LocalDateTime dateTime;
    private int statusCode;
    private String message;
    private String error;
    private String path;

    public ExceptionDTO() {
    }

    public ExceptionDTO(int statusCode, String message, String error, String path) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
        this.path = path;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
