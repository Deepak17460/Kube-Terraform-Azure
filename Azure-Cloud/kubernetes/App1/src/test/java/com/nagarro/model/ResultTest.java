package com.nagarro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import com.nagarro.service.CalculatorService;

class ResultTest {

	@Test
	void test() {
		System.out.println("This test is running");
	}
	
	@Test
    void testAddResult() {

        Response Response = CalculatorService.add(32, 3);
        assertEquals(35, Response.getResult(), 0.01);
    }
	
	@Test
    void testSubtractResult() {

        Response Response = CalculatorService.subtract(32, 3);

        assertEquals(29, Response.getResult(), 0.01);
    }

	@Test
    void testMultiplyResult() {

        Response Response = CalculatorService.multiply(32, 3);
        assertEquals(96, Response.getResult(), 0.01);
    }

	@Test
    void testDivideResult() {
        double num1 = 30;
        double num2 = 2;
        Response Response = CalculatorService.divide(num1, num2);

        assertEquals(15, Response.getResult(), 0.01);
        num2 = 0;
        try {
        	CalculatorService.divide(num1, num2);
            System.out.println("Expected ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            assertEquals("Cannot divide by zero!", e.getMessage());
        }
    }
	
	@Test
	void testAddNegativeNumbers() {
	    Response response = CalculatorService.add(-5, -3);
	    assertEquals(-8, response.getResult(), 0.01);
	}
	
	@Test
	void testMultiplyByZero() {
	    Response response = CalculatorService.multiply(32, 0);
	    assertEquals(0, response.getResult(), 0.01);
	}
	
	@Test
	void testLargeNumbers() {
	    Response response = CalculatorService.multiply(9999999, 9999999);
	    assertEquals(99999980000001.0, response.getResult(), 0.01);
	}
	
	@Test
	void testPrecision() {
	    Response response = CalculatorService.divide(1, 3);
	    assertEquals(0.333, response.getResult(), 0.001);
	}
	
	@Test
	void testDivideByZero() {
	    double num1 = 30;
	    double num2 = 0;
	    try {
	        CalculatorService.divide(num1, num2);
	    } catch (ArithmeticException e) {
	        assertEquals("Cannot divide by zero!", e.getMessage());
	    }
	}
}
