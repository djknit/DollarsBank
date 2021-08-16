package com.cognixia.jump.utility;

import com.cognixia.jump.exception.UserInputException;
import com.cognixia.jump.exception.IllegalInputLengthException;
import com.cognixia.jump.exception.MissingInputException;
import com.cognixia.jump.exception.OutOfRangeNumberException;

public class Validation {
	
	private static final int ADDRESS_MIN_CHARS = 3;
	private static final int PASSWORD_MIN_CHARS = 6;

	public static boolean validateDollarAmount(double amount)
			throws OutOfRangeNumberException {
		if (amount < 0) {
			throw new OutOfRangeNumberException(
					"Negative dollar amounts are not allowed.");
		}
		return true;
	}
	
	public static boolean validateName(String name) throws MissingInputException {
		if (name == null || name.length() == 0) {
			throw new MissingInputException(
					"Your name cannot be blank.");
		}
		return true;
	}
	
	private static boolean validateSimpleText(String text, String fieldName, int minLength)
			throws MissingInputException, IllegalInputLengthException {
		if (text == null || text.length() == 0) {
			throw new MissingInputException(
					"Your " + fieldName + " cannot be blank.");
		}
		if (text.length() < minLength) {
			throw new IllegalInputLengthException("Your " + fieldName +
					" must be at least " + minLength + " characters long.");
		}
		return true;
	}
	
	public static boolean validateAddress(String address)
			throws MissingInputException, IllegalInputLengthException {
		return validateSimpleText(address, "address", ADDRESS_MIN_CHARS);
//		if (address == null || address.length() == 0) {
//			throw new MissingInputException(
//					"Your address cannot be blank.");
//		}
//		if (address.length() < ADDRESS_MIN_CHARS) {
//			throw new IllegalInputLengthException("Your address must be at least " +
//					ADDRESS_MIN_CHARS + " characters long.");
//		}
//		return true;
	}
	
	public static boolean validatePassword(String address)
			throws MissingInputException, IllegalInputLengthException {
		if (address == null || address.length() == 0) {
			throw new MissingInputException(
					"Your address cannot be blank.");
		}
		if (address.length() < ADDRESS_MIN_CHARS) {
			throw new IllegalInputLengthException("Your address must be at least " +
					ADDRESS_MIN_CHARS + " characters long.");
		}
		return true;
	}
	
}
