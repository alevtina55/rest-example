package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NotUniqueNameException extends RuntimeException {
    public NotUniqueNameException(String message) {
        super(message);
    }
}
