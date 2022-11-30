package com.nems.socialmedia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nems.socialmedia.constants.Constants;
import com.nems.socialmedia.services.UserServices;
import com.nems.socialmedia.utility.MediaUtils;
import com.nems.socialmedia.wrapper.UserWrapper;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	UserServices userService;
	
	@PostMapping(path = "/signup")
	public ResponseEntity<String> signUp(@RequestBody Map<String, String> requestMap){
		try {
			return userService.signUp(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return MediaUtils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<String> login(@RequestBody Map<String, String> requestMap){
		try {
			return userService.login(requestMap);
		}catch(Exception ex) {
			
		}
		return MediaUtils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(path = "/checktoken")
	public ResponseEntity<String> checkToken(){
		try {
			return userService.checkToken();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return MediaUtils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(path = "/changepassword")
	public ResponseEntity<String> changePassword(@RequestBody Map<String, String> requestMap){
		try {
			return userService.changePassword(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return MediaUtils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(path = "/forgotpassword")
	public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> requestMap){
		try {
			return userService.forgotPassword(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return MediaUtils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(path = "/get")
	public ResponseEntity<List<UserWrapper>> getAllUser(){
		try {
			return userService.getAllUser();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<String> update(@RequestBody Map<String, String> requestMap){
		try {
			return userService.update(requestMap);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return MediaUtils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
