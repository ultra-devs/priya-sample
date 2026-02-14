package com.priya.sample.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class CustomerController {
	
	Customer globalCustomer; // replacement 
	
	//crud
	@PostMapping("/customers")
	String createCustomer (@RequestBody Customer customer)
	{
		
		globalCustomer=customer;
		return "OK";
	}
	@GetMapping("/customers/{id}")
	Customer createCustomer (@PathVariable int id)
	{
	
		if(id==globalCustomer.getId())
		return globalCustomer;
		return new Customer();
	}
	//putmapping deltemapping
	
	//@put("/customers/{id}")


}
