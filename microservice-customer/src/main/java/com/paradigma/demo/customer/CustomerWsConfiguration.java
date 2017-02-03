package com.paradigma.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CustomerWsConfiguration {
	
	@Value("${mdm.wsdl.endpointl}")
	private String mdmCustomerEndPoint;
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();	
		marshaller.setContextPath("com.paradigma.customer.customer_web_service");
		return marshaller;
	}

	@Bean
	public CustomerWsClient quoteClient(Jaxb2Marshaller marshaller) {
		CustomerWsClient client = new CustomerWsClient(mdmCustomerEndPoint);
		client.setDefaultUri(mdmCustomerEndPoint);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
