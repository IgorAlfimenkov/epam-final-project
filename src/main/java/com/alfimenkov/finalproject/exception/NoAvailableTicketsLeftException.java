package com.alfimenkov.finalproject.exception;

import org.springframework.http.HttpStatus;

public class NoAvailableTicketsLeftException extends RuntimeException{

    private HttpStatus httpStatus;

    public NoAvailableTicketsLeftException(String msg) {
        super(msg);
    }

    public NoAvailableTicketsLeftException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}
