package com.example;

import com.example.exceptions.NameValidationException;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    public Name validateName(Name name) {
        if (name.getName().isEmpty()) {
            throw new NameValidationException("Name can not be empty");
        }

        return name;
    }
}
