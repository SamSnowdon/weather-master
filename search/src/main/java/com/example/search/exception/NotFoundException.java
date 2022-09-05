package com.example.search.exception;

public class NotFoundException extends Exception {

    public NotFoundException(){
        super("Entity not found");
    }

}
