package com.learning.springboot.idao;

import org.springframework.data.repository.CrudRepository;

import com.learning.springboot.model.UserModel;

public interface IDAO extends CrudRepository<UserModel, Long> {

}
