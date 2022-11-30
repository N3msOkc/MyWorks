package com.nems.socialmedia.exception;

import java.util.List;

public class BadRequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4646673407615437784L;
	
	private List<Error> errors;

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public BadRequestException(String message, List<Error> errors) {
		super(message);
		this.errors = errors;
	}

}
