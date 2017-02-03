package com.paradigma.demo.mdm.mock.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.paradigma.customer.customer_web_service.GetCustomerByIdRequest;
import com.paradigma.customer.customer_web_service.GetCustomerResponse;
import com.paradigma.demo.mdm.mock.repositories.CustomerRepository;

@Endpoint
public class CustomerEndpoint {

	private static final String NAMESPACE_URI = "http://paradigma.com/customer/customer-web-service";

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerEndpoint(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerByIdRequest")
	@ResponsePayload
	public GetCustomerResponse getCountry(@RequestPayload GetCustomerByIdRequest request) {
		GetCustomerResponse response = new GetCustomerResponse();
		response.setCustomer((customerRepository.findCustomer(request.getCustomerId())));

		return response;
	}
}
