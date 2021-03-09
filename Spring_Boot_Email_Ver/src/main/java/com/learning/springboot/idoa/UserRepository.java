package com.learning.springboot.idoa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.springboot.model.UserEntity;

@Repository("userRepository ")
public interface UserRepository extends CrudRepository<UserEntity,String> {

	UserEntity findByEmailIdIgnoreCase(String emailId);
}
