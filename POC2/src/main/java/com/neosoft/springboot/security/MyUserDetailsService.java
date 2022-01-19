package com.neosoft.springboot.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.myexception.ResourceNotFoundException;

@Service
public class MyUserDetailsService implements  UserDetailsService{
	
	@Autowired
	UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userrepo.findByUserName(userName);
		user.orElseThrow(()->new ResourceNotFoundException("User", "User name", userName));
		return user.map(MyUserDetails::new).get();
	}


}
