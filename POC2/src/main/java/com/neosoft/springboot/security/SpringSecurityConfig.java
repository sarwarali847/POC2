package com.neosoft.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	//create 2 user for demo (Authentication)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//{noop} to your password in order for the DelegatingPasswordEncoder
		
		//With hard coded values
		/*auth.inMemoryAuthentication().withUser("user").password("{noop}user123").roles("USER")
		.and().withUser("admin").password("{noop}admin123").roles("USER", "ADMIN");
		*/
		
		//With databse level
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
		
		
	}
	
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN") // /** for all end point 
		.antMatchers(HttpMethod.POST,"/**").hasAnyRole("STUDENT","USER")
		.antMatchers(HttpMethod.PUT,"/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/**").hasAnyRole("ADMIN")
		.and()
		.csrf().disable();
		
	}
	
	
	

}
