package com.priya.sample.demo.rest;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.priya.sample.demo.dao.CustomerEntity;
import com.priya.sample.demo.dao.CustomerRepository;
import com.priya.sample.demo.exception.BadCustomerException;
import com.priya.sample.demo.exception.CustomerNotFoundException;
import com.priya.sample.demo.service.GetCustomerService;

@RestController
public class CustomerController {

	//TODO
	
	// autowiring | constructorBased
	// introduce service - controller->service->repository
	// JPA | repository | entity
	// status code  2xx,4xx,5xx
	// spring annotation
	

	
	//autowire
	@Autowired
	GetCustomerService service;
	
	CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	// crud
	@PostMapping("/customers")
	ResponseEntity<CustomerEntity> createCustomer(@RequestBody Customer customer) {
		

		checkCustomerRequest(customer);
		//
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setLocation(customer.getLocation());
		customerEntity.setName(customer.getName());
		customerEntity.setId(UUID.randomUUID().toString());
		customerRepository.save(customerEntity);
		return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
		// return response;

		// return "OK";
	}
	
	private void checkCustomerRequest( Customer customer) {
		
		if(customer.getLocation()==null || customer.getName()==null)
			throw new BadCustomerException("Missing Location or Name Information");
		
	}

	@GetMapping("/customers/{id}")
	ResponseEntity<CustomerEntity> getCustomer(@PathVariable String id) {
		service.init();

		Optional<CustomerEntity> response = customerRepository.findById(id);
		if (response.isPresent())
			return new ResponseEntity<>(response.get(), HttpStatus.OK);
		throw new CustomerNotFoundException("No Customer Found for "+id);
		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
