package com.cognixia.jump.exception;

public class OverdraftException extends UserInputException {

	private static final long serialVersionUID = 1L;

	public OverdraftException(String message) {
		super(message);
	}
	public OverdraftException(String message, Throwable cause) {
		super(message, cause);
	}

}
