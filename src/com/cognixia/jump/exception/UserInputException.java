package com.cognixia.jump.exception;

public abstract class UserInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserInputException(String message) {
		super(processMsgArg(message));
	}
	public UserInputException(String message, Throwable cause) {
		super(processMsgArg(message), cause);
	}
	
	private static String processMsgArg(String message) {
		String realMsg = (message != null && message.length() > 0) ?
				message : "Sorry, that input is invalid.";
		return finishMessage(realMsg);
	}

	private static String finishMessage(String message) {
		return message + " Please try again.";
	}
	
}
