package com.commonservices.auth.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commonservices.auth.model.AuthCredentialModel;
import com.commonservices.auth.repository.AuthAccRepo;
import com.commonservices.model.UserModel;

@Service
public class CheckUserService {

	@Autowired
	private AuthAccRepo accountRepo;
	
	@Autowired
	UserModel userCredential = new UserModel();
	
	@Transactional
	public UserModel userCredentialCheck(String username){
		
		return accountRepo.findByusername(username);
	}
}
