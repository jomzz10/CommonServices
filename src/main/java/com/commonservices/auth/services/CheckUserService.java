package com.commonservices.auth.services;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commonservices.auth.repository.AuthAccRepo;
import com.commonservices.model.UserModel;

@Service
public class CheckUserService {

	@Autowired
	private AuthAccRepo accountRepo;
	
	public final Logger logger = LoggerFactory.getLogger(AuthenticationServices.class);
	
	@Transactional
	public UserModel userCredentialCheck(String username){
		logger.info("This is : "+username);
		UserModel authUser = accountRepo.findUserByUserName(username);
		logger.info("user:" + authUser);
		return authUser;
	}
}
