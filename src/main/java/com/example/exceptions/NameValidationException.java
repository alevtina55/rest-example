package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NameValidationException extends RuntimeException {
    public NameValidationException(String message) {
        super(message);
    }
}
