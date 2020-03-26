package com.example.controllers;

import com.example.Name;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("hello")
public class HelloController {
    private List<Name> names = new ArrayList<>();

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
        if (name.getName().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        names.add(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(name);
    }
}


