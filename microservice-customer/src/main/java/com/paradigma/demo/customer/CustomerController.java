package com.paradigma.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	private CustomerRepository repository;

	@Autowired
	public CustomerController(CustomerRepository repository) {
		super();
		this.repository = repository;
	}
	
	@RequestMapping(value = "/customer/{customerId}")
	public CustomerDto findCustomerId(@PathVariable("customerId") String customerId){
		return repository.findOne(customerId);
	}
	
	
}
