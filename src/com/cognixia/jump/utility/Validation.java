package com.cognixia.jump.utility;

import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.DollarAmount;
import com.cognixia.jump.controller.PatronController;
import com.cognixia.jump.exception.DuplicateUsernameException;
import com.cognixia.jump.exception.IllegalInputLengthException;
import com.cognixia.jump.exception.MissingInputException;
import com.cognixia.jump.exception.OutOfRangeNumberException;
import com.cognixia.jump.exception.OverdraftException;

public class Validation {
	
	private static final int ADDRESS_MIN_CHARS = 3;
	private static final int PASSWORD_MIN_CHARS = 6;
	private static PatronController patronController = new PatronController();

	public static boolean validateDollarAmount(DollarAmount amount)
			throws OutOfRangeNumberException {
		if (amount.getAmountInCents() < 0) {
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
	
	public static boolean validateAddress(String address)
			throws MissingInputException, IllegalInputLengthException {
		return validateSimpleText(address, "address", ADDRESS_MIN_CHARS);
	}
	
	public static boolean validatePassword(String password)
			throws MissingInputException, IllegalInputLengthException {
		return validateSimpleText(password, "password", PASSWORD_MIN_CHARS);
	}
	
	public static boolean validatePhoneNumber(long phone) throws OutOfRangeNumberException {
		if (phone < 0) {
			throw new OutOfRangeNumberException("Negative numbers are not allowed as a phone number.");
		}
		return true;
	}
	
	public static boolean validateUsername(String username)
			throws DuplicateUsernameException, MissingInputException, IllegalInputLengthException {
		if (patronController.getPatronByUsername(username) != null) {
			throw new DuplicateUsernameException(
					"Sorry, the username \"" + username + "\" is already taken.");
		}
		return validateSimpleText(username, "username", 3);
	}
	
	public static boolean validateWithdrawalAmount(Account account, DollarAmount amount)
			throws OutOfRangeNumberException, OverdraftException {
		validateDollarAmount(amount);
		if (account.getBalance().getAmountInCents() < amount.getAmountInCents()) {
			throw new OverdraftException(
					"There is not enough money in your account to complete the transaction." +
					"\nYou are trying to move " + amount +
					" out of your account, but the account currently only has " +
					account.getBalance() + " available.");
		}
		return false;
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
	
}
