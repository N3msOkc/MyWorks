package com.nems.socialmedia.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MediaUtils {
private MediaUtils() {
		
	}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
		return new ResponseEntity<String>("{\"message\": \""+responseMessage+"\"}", httpStatus);
	}
}
