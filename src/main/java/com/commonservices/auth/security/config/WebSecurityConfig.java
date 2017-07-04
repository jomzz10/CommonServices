package com.commonservices.auth.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.commonservices.auth.filter.JWTAuthenticationFilter;
import com.commonservices.auth.filter.JWTLoginFilter;
import com.commonservices.auth.services.CustomAuthenticationProviderService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private CustomAuthenticationProviderService authProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable().authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers(HttpMethod.POST, "/login").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        // We filter the api/login requests
	        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
	        // And filter other requests to check the presence of JWT in header
	        .addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
	  }
	@Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    // Create a default account
//	    auth.inMemoryAuthentication()
//	        .withUser("admin")
//	        .password("password")
//	        .roles("ADMIN");
		auth.authenticationProvider(authProvider);
	  }
	
}
