package com.commonservices.auth.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.commonservices.auth.model.AuthCredentialModel;
import com.commonservices.model.UserModel;

@Component
public class CustomAuthenticationProviderService implements AuthenticationProvider{
	
	private static Logger logger = LoggerFactory.getLogger(CustomAuthenticationProviderService.class);
	

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String userName = auth.getName();
		String password = auth.getCredentials().toString();
		
		logger.info("UserName : "+ userName +"\nPassword : "+ password);
		
		CheckUserService checkUser = new CheckUserService();
		
		UserModel userCredential =  new UserModel();
		
		userCredential = checkUser.userCredentialCheck(userName);
		
		logger.info("UserName : "+ userCredential.getUsername() +"\nPassword : "+ userCredential.getPassword());
		
		
		if(userName.equals("admin") && password.equals("password")){
			
			return new UsernamePasswordAuthenticationToken(
		              userName, password, new ArrayList<>());
			
		}else{
		return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(
		          UsernamePasswordAuthenticationToken.class);
	}

}
