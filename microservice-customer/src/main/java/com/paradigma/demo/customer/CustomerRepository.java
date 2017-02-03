package com.paradigma.demo.customer;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface CustomerRepository extends Repository<CustomerDto, String> {
	
	CustomerDto findOne(String id);
	boolean exists(String id);
	
}
