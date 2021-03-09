package com.learning.springrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rest_API_Demo")
public class Customer_Model {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CustomerID;
	private String Customer_Name;
	@Column(unique = true)
	private String Customer_Email;
	private String Costomer_Contant;
	public Customer_Model(int customerID, String customer_Name, String customer_Email, String costomer_Contant) {
		super();
		CustomerID = customerID;
		Customer_Name = customer_Name;
		Customer_Email = customer_Email;
		Costomer_Contant = costomer_Contant;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getCustomer_Email() {
		return Customer_Email;
	}
	public void setCustomer_Email(String customer_Email) {
		Customer_Email = customer_Email;
	}
	public String getCostomer_Contant() {
		return Costomer_Contant;
	}
	public void setCostomer_Contant(String costomer_Contant) {
		Costomer_Contant = costomer_Contant;
	}
	@Override
	public String toString() {
		return "Customer_Model [CustomerID=" + CustomerID + ", Customer_Name=" + Customer_Name + ", Customer_Email="
				+ Customer_Email + ", Costomer_Contant=" + Costomer_Contant + "]";
	}
	public Customer_Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
