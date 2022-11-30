package com.nems.blog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.nems.blog.JWT.JwtFilter;
import com.nems.blog.JWT.JwtUtil;
import com.nems.blog.JWT.UserDetailService;
import com.nems.blog.constants.BlogConstants;
import com.nems.blog.models.User;
import com.nems.blog.repository.UserRepository;
import com.nems.blog.utility.BlogUtils;
import com.nems.blog.utility.EmailUtils;
import com.nems.blog.wrapper.UserWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServices {
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	EmailUtils emailUtils;

	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		try {
		if(validateSignUp(requestMap)) {
			User user = userRepository.findByEmail(requestMap.get("email"));
			if(java.util.Objects.isNull(user)) {
				
				userRepository.save(getUserFromMap(requestMap));
				return BlogUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
				
			}else {
				return BlogUtils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
			}
		}else {
			return BlogUtils.getResponseEntity(BlogConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return BlogUtils.getResponseEntity(BlogConstants.SOMETHING_WENT_WRONG, HttpStatus.BAD_REQUEST);
	}
	
	private boolean validateSignUp(Map<String, String> requestMap) {
		if(requestMap.containsKey("name") && requestMap.containsKey("email") &&
		requestMap.containsKey("password")) {
			return true;
		}
		return false;
	}
	
	private User getUserFromMap(Map<String, String> requestMap) {
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(encoder.encode(requestMap.get("password")));
		user.setStatus("true");
		return user;
	}


	public ResponseEntity<String> login(Map<String, String> requestMap) {
			try {
			Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password")));
			if(auth.isAuthenticated()) {
				if(userDetailService.getUserDetail().getStatus().equalsIgnoreCase("true")) {
					return new ResponseEntity<String>("{\"token\":\""+ 
				jwtUtil.generateToken(userDetailService.getUserDetail().getEmail()) + "\"}", HttpStatus.OK);
				}else {
					return new ResponseEntity<String>("{\"message\":\""+"Wait for approval"+"\"}", HttpStatus.BAD_REQUEST);
				}
			}
		}catch(Exception ex) {
			
		}
		return new ResponseEntity<String>("{\"message\":\""+"Bad Crendentials"+"\"}", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> checkToken() {
		return BlogUtils.getResponseEntity("true", HttpStatus.OK);
	}

	public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
		try {
			User userObj = userRepository.findByEmail(jwtFilter.getCurrentUser());
			String encryptedPassword = encoder.encode(requestMap.get("newPassword"));
			String rawPassword = requestMap.get("oldPassword");
			String passwordInDatabase = userObj.getPassword();
			if(!userObj.equals(null)) {
					if(encoder.matches(rawPassword, passwordInDatabase)) {
						userObj.setPassword(encryptedPassword);
						userRepository.save(userObj);
						return BlogUtils.getResponseEntity("Password updated Successfully", HttpStatus.OK);
					}else {
						return BlogUtils.getResponseEntity("Incorrect old Password", HttpStatus.BAD_REQUEST);
					}
			}
			return BlogUtils.getResponseEntity(BlogConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return BlogUtils.getResponseEntity(BlogConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<String> forgotPassword(Map<String, String> requestMap) {
		try {
			User user = userRepository.findByEmail(requestMap.get("email"));
			if(!Objects.isNull(user) && !Strings.isNullOrEmpty(user.getEmail()))
				emailUtils.forgotMail(user.getEmail(), "Credentials by Blog System", user.getPassword());
				return BlogUtils.getResponseEntity("Check your mail for Credentials", HttpStatus.OK);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return BlogUtils.getResponseEntity(BlogConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<List<UserWrapper>> getAllUser() {
		try {
			return new ResponseEntity<>(userRepository.getAllUser(), HttpStatus.OK);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<String> update(Map<String, String> requestMap) {
		try {
			Optional <User> optional = userRepository.findById(Integer.parseInt(requestMap.get("id")));
			if(!optional.isEmpty()) {
				userRepository.updateStatus(requestMap.get("status"), Integer.parseInt(requestMap.get("id")));
				sendMailToAll(requestMap.get("status"), optional.get().getEmail(), userRepository.getUserByEmail());
				return BlogUtils.getResponseEntity("User status updated successfully", HttpStatus.OK);
			}else {
				return BlogUtils.getResponseEntity("User id doesn't exist", HttpStatus.BAD_REQUEST);
			}
				
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return BlogUtils.getResponseEntity(BlogConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private void sendMailToAll(String status, String user, List<String> allUser) {
		allUser.remove(jwtFilter.getCurrentUser());
		if(status!=null && status.equalsIgnoreCase("true")) {
			emailUtils.sendSimpleMessage(jwtFilter.getCurrentUser(), "Account approved", "USER:- "+user+" \n is approved:- " + jwtFilter.getCurrentUser(), allUser);
		}else {
			emailUtils.sendSimpleMessage(jwtFilter.getCurrentUser(), "Account Disabled", "USER:- "+user+" \n is disabled:- " + jwtFilter.getCurrentUser(), allUser);
		}
		
	}
	
	

}
