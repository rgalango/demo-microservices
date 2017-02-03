package com.paradigma.demo.customer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paradigma.customer.customer_web_service.GetCustomerResponse;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private CustomerWsClient client;
		
	@Autowired
	public CustomerRepositoryImpl(CustomerWsClient client) {
		super();
		this.client = client;
	}

	
	@Override
	public CustomerDto findOne(String id) {
		GetCustomerResponse wsresponse = client.getCustomerById(id);
		CustomerDto response = new CustomerDto();
		BeanUtils.copyProperties(wsresponse.getCustomer(), response);
		return response;
	}

	@Override
	public boolean exists(String id) {
		
		return client.getCustomerById(id).getCustomer() != null;
	}

		
}
