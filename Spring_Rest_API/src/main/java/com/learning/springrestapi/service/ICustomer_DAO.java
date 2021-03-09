package com.learning.springrestapi.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.learning.springrestapi.model.Customer_Model;
@Component
public interface ICustomer_DAO extends CrudRepository<Customer_Model,Integer> {

	
}
