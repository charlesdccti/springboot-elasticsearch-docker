package com.volkspace.springbootelasticsearch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volkspace.springbootelasticsearch.model.Customer;
import com.volkspace.springbootelasticsearch.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> retrieveCustomer() {
		return customerRepository.findAll().getContent();
	}
	
	public Optional<Customer> retrieveCustomer(String id) {
		return customerRepository.findById(id);
	}
	
	public List<Customer> retrieveCustomersByName(String name) {
		return customerRepository.findByFirstName(name);
	}
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> updateCustomer(String id, Customer customer) {
		Optional<Customer> customerOpt = customerRepository.findById(id);
		if(!customerOpt.isPresent()) {
			return customerOpt;
		}
		customer.setId(id);
		return Optional.of(customerRepository.save(customer));
	}
	
	public boolean deleteCustomer(String id) {
		try {
			customerRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
