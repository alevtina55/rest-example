package com.example.controllers;

import com.example.Name;
import com.example.NameService;
import com.example.exceptions.NotUniqueNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("hello")
public class HelloController {
    private final NameService nameService;
    private List<Name> names = new ArrayList<>();

    @Autowired
    public HelloController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping
    public String getHello() {
        return "Привет!";
    }

    @GetMapping("/names")
    public List<Name> getNames() {
        return names;
    }

    @PostMapping("/names")
    public ResponseEntity<Name> saveName(@RequestBody Name name) {

        if (isNotUnique(name)) {
            throw new NotUniqueNameException("This name already exists");
        }

        names.add(nameService.validateName(name));

        return ResponseEntity.status(HttpStatus.CREATED).body(name);
    }

    private boolean isNotUnique(Name nameToCheck) {
        return names.stream()
                .map(Name::getName)
                .anyMatch(name -> name.equals(nameToCheck.getName()));
    }
}


