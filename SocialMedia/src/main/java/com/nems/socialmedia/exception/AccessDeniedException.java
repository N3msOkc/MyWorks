package com.nems.socialmedia.exception;

public class AccessDeniedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2813628364967582162L;

	public AccessDeniedException(String message){
		super(message);
	}

}
