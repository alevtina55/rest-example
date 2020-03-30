package com.example.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldSaveSuccessfully() throws Exception {
        mockMvc.perform(post("/hello/names").content("{\"name\": \"test\"}")
                                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("test"));
    }

    @Test
    void shouldReturnBadRequestStatus() throws Exception {
        mockMvc.perform(post("/hello/names").content("{\"name\": \"\"}")
                                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}