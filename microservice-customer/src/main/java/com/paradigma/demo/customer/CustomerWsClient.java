package com.paradigma.demo.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.paradigma.customer.customer_web_service.GetCustomerByIdRequest;
import com.paradigma.customer.customer_web_service.GetCustomerResponse;


public class CustomerWsClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CustomerWsClient.class);
	
	
	
	public CustomerWsClient(String mdmCustomerEndPoint) {
		super();
		this.mdmCustomerEndPoint = mdmCustomerEndPoint;
	}

	private String mdmCustomerEndPoint;

	public GetCustomerResponse getCustomerById(String customerId){

		GetCustomerByIdRequest request = new GetCustomerByIdRequest();
		request.setCustomerId(customerId);

		log.info("Requesting for " + customerId);

		
		
		GetCustomerResponse response = (GetCustomerResponse) getWebServiceTemplate()
				.marshalSendAndReceive(mdmCustomerEndPoint,
						request
						);

		return response;
	}
}
