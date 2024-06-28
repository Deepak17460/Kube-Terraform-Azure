package com.nagarro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.nagarro.model.Response;

class ServiceTest {

	@Test
    void testAdd() {
        Response response = CalculatorService.add(10, 5);
        assertEquals(15, response.getResult(), 0.01);
    }

    @Test
    void testSubtract() {
        Response response = CalculatorService.subtract(10, 5);
        assertEquals(5, response.getResult(), 0.01);
    }

    @Test
    void testMultiply() {
        Response response = CalculatorService.multiply(10, 5);
        assertEquals(50, response.getResult(), 0.01);
    }

    @Test
    void testDivide() {
        Response response = CalculatorService.divide(10, 5);
        assertEquals(2, response.getResult(), 0.01);
    }

}
