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
import com.priya.sample.demo.exception.CustomerNotFoundException;

@RestController
public class CustomerController {


	
	CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	// crud
	@PostMapping("/customers")
	ResponseEntity<CustomerEntity> createCustomer(@RequestBody Customer customer) {
		
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setLocation(customer.getLocation());
		customerEntity.setName(customer.getName());
		customerEntity.setId(UUID.randomUUID().toString());
		customerRepository.save(customerEntity);
		return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
		// return response;

		// return "OK";
	}

	@GetMapping("/customers/{id}")
	ResponseEntity<CustomerEntity> createCustomer(@PathVariable String id) {

		Optional<CustomerEntity> response = customerRepository.findById(id);
		if (response.isPresent())
			return new ResponseEntity<>(response.get(), HttpStatus.OK);
		throw new CustomerNotFoundException("No Customer Found for "+id);
		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
