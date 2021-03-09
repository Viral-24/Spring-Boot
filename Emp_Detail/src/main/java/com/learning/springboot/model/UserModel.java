package com.learning.springboot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Entity
@Table(name = "ManagementDB5")
@Component
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String contact;
	private String post;
	private String userphoto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getUserphoto() {
		return userphoto;
	}
	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", contact=" + contact + ", post=" + post + ", userphoto=" + userphoto + "]";
	}
	public UserModel(Long id, String name, String contact, String post, String userphoto) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.post = post;
		this.userphoto = userphoto;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
