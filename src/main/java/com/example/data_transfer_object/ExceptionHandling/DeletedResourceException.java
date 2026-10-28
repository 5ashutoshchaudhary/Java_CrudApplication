package com.example.data_transfer_object.ExceptionHandling;

public class DeletedResourceException extends RuntimeException{
    public DeletedResourceException(String msg){
        super(msg);
    }
}
