package com.Hexaview.springsecurityjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Hexaview.springsecurityjpa.models.User;
import com.Hexaview.springsecurityjpa.models.MyUserDetails;
import com.Hexaview.springsecurityjpa.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	 	//return new UserDetailServiceImpl(username);
		Optional<User> user =  userRepository.findByUserName(userName);
		
		user.orElseThrow( ()->new UsernameNotFoundException("NOT FOUND :"+ userName)  );
		
		return user.map(MyUserDetails::new).get();
		// Gotten user instance from database from repository and converted into 
		// UserDetailsServiceImpl instance and returning 
	
	}

}
