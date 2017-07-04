package com.commonservices.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.commonservices.model.UserModel;

@Transactional
public interface UsersRepository extends CrudRepository<UserModel, Long>{
	
	@Query("SELECT u FROM UserModel u WHERE u.username = ?")
	UserModel findUserByUserName(String username);
	
	

}
