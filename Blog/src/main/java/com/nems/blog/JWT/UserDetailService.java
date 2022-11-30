package com.nems.blog.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nems.blog.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	private com.nems.blog.models.User userDetail;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		userDetail = userRepository.findByEmail(username);
		if(!Objects.isNull(userDetail))
			return new User(userDetail.getEmail(), userDetail.getPassword(),new ArrayList<>());
		
		else 
			throw new UsernameNotFoundException("User not found");
		
	}
	
	public com.nems.blog.models.User getUserDetail(){
		return userDetail;
	}
}
