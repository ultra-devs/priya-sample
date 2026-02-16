package com.priya.sample.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {
	
	
	@GetMapping("/customers/hello") //PutMapping DeleMapping
	public String sayHello()
	{
		return "Hello World";
		
	}

}
