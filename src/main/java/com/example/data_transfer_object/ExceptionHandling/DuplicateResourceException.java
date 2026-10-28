package com.example.data_transfer_object.ExceptionHandling;

public class DuplicateResourceException extends RuntimeException{
    public DuplicateResourceException(String message){
        super(message);
    }
}
