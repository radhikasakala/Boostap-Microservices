package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/helo")
public class HelloController {

	@GetMapping(path="")
	public String sayHello() {
		return "hello";
	}
	
	
}
