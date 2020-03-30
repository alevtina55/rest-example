package com.example;

import com.example.exceptions.NameValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class NameServiceTest {
    @Autowired
    private NameService nameService;

    @Test
    public void shouldReturnName() {
        Name expected = new Name("name");
        Name actual = nameService.validateName(new Name("name"));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowNameValidationException() {
        assertThrows(NameValidationException.class, () -> nameService.validateName(new Name("")));
    }
}