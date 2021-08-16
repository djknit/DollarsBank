package com.cognixia.jump.exception;

public class OutOfRangeNumberException extends UserInputException {

	private static final long serialVersionUID = 1L;

	public OutOfRangeNumberException(String message) {
		super(message);
	}
	public OutOfRangeNumberException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
