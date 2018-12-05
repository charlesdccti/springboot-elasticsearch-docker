package com.volkspace.springbootelasticsearch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.volkspace.springbootelasticsearch.model.Customer;

@EnableElasticsearchRepositories
public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

	Page<Customer> findAll();
	
	List<Customer> findByFirstName(String firstName);
	
}
