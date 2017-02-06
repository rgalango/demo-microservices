package com.paradigma.demo.mdm.mock.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.paradigma.customer.customer_web_service.Customer;

@Component
public class CustomerRepository {

	private static final List<Customer> customers = new ArrayList<Customer>();

	@PostConstruct
	public void initData() {
		Customer c = new Customer();
		c.setAddress("Paseo de la Castellana 1, Madrid");
		c.setCustomerId("1");
		c.setFirstName("David");
		c.setMiddleName("López");
		c.setLastName("Mun");
		customers.add(c);
		c = new Customer();
		c.setAddress("Avenida Diagonal 2, Barcelona");
		c.setCustomerId("2");
		c.setFirstName("Alfredo");
		c.setMiddleName("Gil");
		c.setLastName("last");
		customers.add(c);
		c = new Customer();
		c.setAddress("Otra direccion");
		c.setCustomerId("3");
		c.setFirstName("First Name");
		c.setMiddleName("Middle Name");
		c.setLastName("Last Name");
		customers.add(c);
	}

	public Customer findCustomer(String customerId) {
		Assert.notNull(customerId);

		Customer result = null;

		for (Customer c : customers) {
			if (customerId.equals(c.getCustomerId())) {
				result = c;
			}
		}

		return result;
	}
	
	public List<Customer> getCustomers(Integer size,Integer page) {
		
		if(page * size > customers.size()){
			return new ArrayList<>();
		}
		if(page * size + size > customers.size()){
			return customers.subList(page * size , customers.size());
		}

		return customers.subList(page * size , page * size + size);
	}
}
