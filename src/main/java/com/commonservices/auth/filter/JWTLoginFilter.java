package com.commonservices.auth.filter;

import com.commonservices.auth.model.AuthCredentialModel;
import com.commonservices.auth.services.TokenAuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	  public JWTLoginFilter(String url, AuthenticationManager authManager) {
	    super(new AntPathRequestMatcher(url));
	    setAuthenticationManager(authManager);
	  }

	  @Override
	  public Authentication attemptAuthentication(
	      HttpServletRequest req, HttpServletResponse res)
	      throws AuthenticationException, IOException, ServletException {
	    AuthCredentialModel creds = new ObjectMapper()
	        .readValue(req.getInputStream(), AuthCredentialModel.class);
	    return getAuthenticationManager().authenticate(
	        new UsernamePasswordAuthenticationToken(
	            creds.getUsername(),
	            creds.getPassword(),
	            Collections.emptyList()
	        )
	    );
	  }

	  @Override
	  protected void successfulAuthentication(
	      HttpServletRequest req,
	      HttpServletResponse res, FilterChain chain,
	      Authentication auth) throws IOException, ServletException {
	    TokenAuthenticationService
	        .addAuthentication(res, auth.getName());
	  }

}
