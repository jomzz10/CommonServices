package com.commonservices.auth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.commonservices.model.UserModel;
import com.commonservices.repository.UsersRepository;

@Service
public class AuthenticationServices implements UserDetailsService {
	
	@Autowired
    private UsersRepository userRepository;
    
/*	@Autowired
    private RoleRepository roleRepository;*/
	
	
	public final Logger logger = LoggerFactory.getLogger(AuthenticationServices.class);

	public UserModel authenticate(String userName, String password)
	   {
			
		   UserModel user = userRepository.findUserByUserName(userName);

		   logger.info("user:" + user);
	       if (user!=null)
	       { 
	    	   
//	    	   Boolean test = BCrypt.checkpw(password, hashPass);
//	    	   System.out.println(tests);
	    	    if(BCrypt.checkpw(password,  user.getPassword())){
	    		   return user;
	    	   }
	    		   	
	       }
	    return null;
  
	   }

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	   
	  /* public String  getRole(long role_id)
	   {
		  return roleRepository.findRoleNameById(role_id);
	   }
	   
	

		@Override
		public UserDetails loadUserByUsername(String username)
				throws UsernameNotFoundException {
			UserModel userInfo = userRepository.findUserByUserName(username);
			
			GrantedAuthority  authority= new SimpleGrantedAuthority( getRole(userInfo.getRole_id()));
			UserDetails userDetails = (UserDetails)new User(userInfo.getUsername(), 
					userInfo.getPassword(), Arrays.asList(authority));
			logger.info("loadUserByUsername:" + authority + ":" + "ROLE:"+ getRole(userInfo.getRole_id()));
			return userDetails;
		}*/
}