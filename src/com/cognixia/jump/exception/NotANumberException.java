package com.cognixia.jump.exception;

public class NotANumberException extends UserInputException {

	private static final long serialVersionUID = 1L;

	public NotANumberException(String message) {
		super(message);
	}
	public NotANumberException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
