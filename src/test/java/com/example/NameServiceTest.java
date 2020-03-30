package com.example;

import com.example.exceptions.NameValidationException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class NameServiceTest {
    private Name name = mock(Name.class);

    @InjectMocks
    private NameService nameService = new NameService();

    @Test
    public void shouldReturnName() {
        Name expected = new Name("name");

        Mockito.when(name.getName()).thenReturn("name");
        Name actual = nameService.validateName(name);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowNameValidationException() {
        Mockito.when(name.getName()).thenReturn("");

        assertThrows(NameValidationException.class, () -> nameService.validateName(name));
    }
}