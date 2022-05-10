package com.alfimenkov.finalproject.exception;

import org.springframework.http.HttpStatus;

public class UserExistException extends RuntimeException{

    private HttpStatus httpStatus;

    public UserExistException(String msg) {
        super(msg);
    }

    public UserExistException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}
