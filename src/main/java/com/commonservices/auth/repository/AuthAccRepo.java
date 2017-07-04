package com.commonservices.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.commonservices.model.UserModel;

@Transactional
public interface AuthAccRepo extends CrudRepository<UserModel, Long>{
	
	@Query("SELECT u FROM UserModel u WHERE u.username = :username")
	UserModel findUserByUserName(@Param(value = "username") String username);

}
