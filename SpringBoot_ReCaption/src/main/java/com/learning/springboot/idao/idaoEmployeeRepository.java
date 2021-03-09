package com.learning.springboot.idao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.springboot.model.EmployeeEntity;

@Repository
public interface idaoEmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

	
	
}
