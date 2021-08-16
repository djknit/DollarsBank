package com.cognixia.jump.exception;

public class DuplicateUsernameException extends UserInputException {

	private static final long serialVersionUID = 1L;

	public DuplicateUsernameException(String message) {
		super(message);
	}
	public DuplicateUsernameException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
