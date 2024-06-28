package com.nagarro.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHomePage() throws Exception {
        mockMvc.perform(post("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void testAddOperation() throws Exception {
        mockMvc.perform(post("/calculate")
                .param("num1", "32.0")
                .param("num2", "3.0")
                .param("operation", "add"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", 35.0));
    }

    @Test
    void testSubtractOperation() throws Exception {
        mockMvc.perform(post("/calculate")
                .param("num1", "32.0")
                .param("num2", "3.0")
                .param("operation", "subtract"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", 29.0));
    }

    @Test
    void testMultiplyOperation() throws Exception {
        mockMvc.perform(post("/calculate")
                .param("num1", "32.0")
                .param("num2", "3.0")
                .param("operation", "multiply"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", 96.0));
    }

    @Test
    void testDivideOperation() throws Exception {
        mockMvc.perform(post("/calculate")
                .param("num1", "30.0")
                .param("num2", "2.0")
                .param("operation", "divide"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", 15.0));
    }

    @Test
    void testDivideByZero() throws Exception {
        mockMvc.perform(post("/calculate")
                .param("num1", "30.0")
                .param("num2", "0.0")
                .param("operation", "divide"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(model().attribute("message", "Cannot divide by zero!"));
    }
    
    @Test
    void testInvalidOperation() throws Exception {
        mockMvc.perform(post("/calculate")
                .param("num1", "32.0")
                .param("num2", "3.0")
                .param("operation", "invalid"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(model().attribute("message", "Invalid operation!"));
    }
    
    @Test
    void testLargeNumbers() throws Exception {
        mockMvc.perform(post("/calculate")
                .param("num1", "9999999.0")
                .param("num2", "9999999.0")
                .param("operation", "multiply"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", 99999980000001.0));
    }
    
    @Test
    void testNegativeNumbers() throws Exception {
        mockMvc.perform(post("/calculate")
                .param("num1", "-10.0")
                .param("num2", "-5.0")
                .param("operation", "add"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", -15.0));
    }
    
}