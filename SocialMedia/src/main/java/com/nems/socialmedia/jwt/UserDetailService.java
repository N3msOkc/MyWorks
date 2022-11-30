package com.nems.socialmedia.jwt;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nems.socialmedia.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	private com.nems.socialmedia.models.User userDetail;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		userDetail = userRepository.findByEmail(username);
		if(!Objects.isNull(userDetail))
			return new User(userDetail.getEmail(), userDetail.getPassword(),new ArrayList<>());
		
		else 
			throw new UsernameNotFoundException("User not found");
		
	}
	
	public com.nems.socialmedia.models.User getUserDetail(){
		return userDetail;
	}
}
