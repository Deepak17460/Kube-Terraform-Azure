package com.nagarro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.service.CalculatorService;
import com.nagarro.model.Response;

@Controller
public class CalculatorController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public ModelAndView calculate(@RequestParam("num1") double num1,
						            @RequestParam("num2") double num2,
						            @RequestParam("operation") String operation) {
		double result=0;
		Response res;
		
		switch (operation) {
        case "add":
        	res= CalculatorService.add(num1, num2);
            result = res.getResult();
            break;
        case "subtract":
        	res= CalculatorService.subtract(num1, num2);
            result = res.getResult();
            break;
        case "multiply":
        	res= CalculatorService.multiply(num1, num2);
            result = res.getResult();
            break;
        case "divide":
            if (num2 != 0) {
            	res=CalculatorService.divide(num1, num2);
            	result = res.getResult();
            } else {
                return new ModelAndView("error", "message", "Cannot divide by zero!");
            }
            break;
        default :
        	return new ModelAndView("error", "message", "Invalid operation!");
        	
    }

    ModelAndView modelAndView = new ModelAndView("result");
    modelAndView.addObject("num1", num1);
    modelAndView.addObject("num2", num2);
    modelAndView.addObject("result", result);

    return modelAndView;

	}
}
