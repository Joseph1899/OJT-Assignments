package com.FirstAssignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FirstAssignment.service.GreetingService;

@RestController
@RequestMapping("/api")
public class GreetingRest {

	@Autowired
	GreetingService service;
	
	
	
	@Value("${multiplier.number}")
	float mult;

	
	
	
	
	//http://localhost:8080/api/add/num1/num2/num3/num4
	@GetMapping("/add/{num1}/{num2}/{num3}/{num4}")
	public String addMePlease(@PathVariable("num1") int num1, @PathVariable("num2") int num2 , @PathVariable("num3") int num3 , @PathVariable("num4") int num4) {
		System.out.println("The sum of the 4 input numbers multiply by x=20.42 is: ");
		return service.viewGreeting("The sum of the 4 inputed numbers multiplied by x=20.42 is: "+((num1+num2+num3+num4)*mult));
		
	}
	
	//To test http://localhost:8080/api/addv2?num1=#&num2=#&num3=#&num4=#
	@GetMapping("/addv2")
	public String addByPassingParam (@RequestParam int num1, @RequestParam int num2, @RequestParam int num3, @RequestParam int num4 ) {
		return service.viewGreeting("The sum of the 4 inputed numbers multiplied by x=20.42 is: "+((num1+num2+num3+num4)*mult));
	}

	
}
