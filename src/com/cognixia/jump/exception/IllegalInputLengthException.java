package com.cognixia.jump.exception;

public class IllegalInputLengthException extends UserInputException {

	private static final long serialVersionUID = 1L;

	public IllegalInputLengthException(String message) {
		super(message);
	}
	public IllegalInputLengthException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
