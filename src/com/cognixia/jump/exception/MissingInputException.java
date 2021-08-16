package com.cognixia.jump.exception;

public class MissingInputException extends UserInputException {

	private static final long serialVersionUID = 1L;

	public MissingInputException(String message) {
		super(message);
	}
	public MissingInputException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
