package com.twschool.practice.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class GameControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void should_return_guess_result() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/game")
        .contentType(MediaType.APPLICATION_JSON)
        .param("guess","1 2 3 4"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("1 2 3 4"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("4A0B"));
    }
}
