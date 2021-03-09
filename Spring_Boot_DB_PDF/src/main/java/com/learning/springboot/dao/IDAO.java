package com.learning.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.springboot.model.User_Model;

public interface IDAO extends JpaRepository<User_Model,Integer> {

	
}
