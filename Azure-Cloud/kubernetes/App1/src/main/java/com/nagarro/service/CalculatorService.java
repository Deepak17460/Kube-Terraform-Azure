package com.nagarro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nagarro.model.Response;

public class CalculatorService {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
	
	private CalculatorService() {
		super();
	}

	static Response res = new Response();
	static double result;
	
	public static Response add(double n1, double n2) {
		result = n1+n2;
		res.setResult(result);
		return res;
	}
	
	public static Response subtract(double n1, double n2) {
		result = n1-n2;
		res.setResult(result);
		return res;
	}
	
	public static Response multiply(double n1, double n2) {
		result = n1*n2;
		res.setResult(result);
		return res;
	}
	
	public static Response divide(double n1, double n2) {
		try {
			result = n1/n2;
			res.setResult(result);
		}
		catch(ArithmeticException e) {
			logger.error("Cannot divide by zero!", e);
		}
		return res;
	}
}
