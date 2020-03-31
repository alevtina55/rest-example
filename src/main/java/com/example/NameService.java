package com.example;

import com.example.exceptions.NameValidationException;

import java.util.function.Predicate;

public class NameService {
    private final Predicate<Name> isEmptyPredicate;

    public NameService(Predicate<Name> isEmptyPredicate) {
        this.isEmptyPredicate = isEmptyPredicate;
    }

    public Name validateName(Name name) {
        if (isEmptyPredicate.test(name)) {
            throw new NameValidationException("Name can not be empty");
        }

        return name;
    }
}
