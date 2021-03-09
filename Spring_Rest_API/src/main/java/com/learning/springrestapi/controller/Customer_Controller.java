package com.learning.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springrestapi.model.Customer_Model;
import com.learning.springrestapi.service.ICustomer_DAO;
import java.util.Optional;

@RestController
@RequestMapping("cust-api")
@CrossOrigin(origins = "*")
public class Customer_Controller {

	@Autowired
	ICustomer_DAO dao;
	@GetMapping("/")
	public ResponseEntity<List<Customer_Model>> index(){
		List<Customer_Model> customerList=(List<Customer_Model>) dao.findAll();
		if(customerList.size()>0) {
			return new ResponseEntity<List<Customer_Model>>(customerList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Customer_Model>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/add-cust")
	public ResponseEntity<HttpStatus> addCust(@RequestBody Customer_Model model){
		
		Customer_Model customer=model;
		dao.save(customer);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@GetMapping("/get-by-id{id}")
	public ResponseEntity<Optional<Customer_Model>> getCustomerById(@PathVariable("id") int id){
	    Optional<Customer_Model> customer=dao.findById(id);
		if(customer.isPresent()) {
			return new ResponseEntity<Optional<Customer_Model>>(customer,HttpStatus.OK);
		}
		return new ResponseEntity<Optional<Customer_Model>>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("edit-by-id")
	public ResponseEntity<Customer_Model> updatedbyid(@RequestBody Customer_Model model){
		Optional<Customer_Model> custmodel=dao.findById(model.getCustomerID());
		if(custmodel.isPresent()) {
			Customer_Model newcust=custmodel.get();
			newcust.setCustomer_Name(model.getCustomer_Name());
			newcust.setCustomer_Email(model.getCustomer_Email());
			newcust.setCostomer_Contant(model.getCostomer_Contant());
			dao.save(newcust);
			
			return new ResponseEntity<Customer_Model>(HttpStatus.ACCEPTED);
		}
		return  new ResponseEntity<Customer_Model>(HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("delete-by-id{id}")
	public ResponseEntity<HttpStatus> deletebyid(@PathVariable int id){
		dao.deleteById(id);
	
		return new ResponseEntity<HttpStatus>(HttpStatus.GONE);
	}
}
