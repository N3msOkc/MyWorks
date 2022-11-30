package com.nems.socialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body("Access Denied");
		
	}

}
