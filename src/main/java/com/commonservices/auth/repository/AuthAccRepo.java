package com.commonservices.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.commonservices.model.UserModel;

@Repository
public interface AuthAccRepo extends CrudRepository<UserModel, Long>{
	
	@Query("SELECT u FROM user u WHERE u.username = :username")
	public UserModel findByusername(@Param("username") String username);

}
