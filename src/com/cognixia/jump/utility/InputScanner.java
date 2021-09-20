package com.cognixia.jump.utility;

import java.util.Scanner;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.exception.NotANumberException;
import com.cognixia.jump.menu.LandingMenu;
import com.cognixia.jump.menu.MainMenu;
import com.cognixia.jump.menu.Menu;
import com.cognixia.jump.model.DollarAmount;
import com.cognixia.jump.model.Patron;

public class InputScanner {
	
	private static final Scanner SCANNER;
	
	static {
		SCANNER = new Scanner(System.in);
		SCANNER.useDelimiter(System.lineSeparator()); // source: https://www.reddit.com/r/javahelp/wiki/scanner
	}
	
	private static Menu getDefaultPreviousMenu() {
		Patron currentUser = DollarsBankDriver.getCurrentUser();
		return currentUser == null ?
				new LandingMenu() :
				new MainMenu(currentUser);
	}
	
	private static void checkForGoBackRequest(String input) throws GoBackRequest {
		if (input.trim().equals("-b") || input.trim().equals("<")) {
			throw new GoBackRequest();
		}
	}
	
	private static void handleNumericInputTypeMismatch(
			String badTypeMessage, Menu previousMenu, Throwable e)
					throws NotANumberException, GoBackRequest {
		Colors.resetConsoleColor();
		String input = SCANNER.next().trim();
		checkForGoBackRequest(input);
		throw new NotANumberException(badTypeMessage, e);
	}
	
	private static void startInputColor() {
		Colors.CYAN.startConsoleColor();
	}
	
	public static int getIntInput()
			throws NotANumberException, GoBackRequest {
		return getIntInput(getDefaultPreviousMenu());
	}
	public static int getIntInput(Menu previousMenu)
			throws NotANumberException, GoBackRequest {
		return getIntInput(previousMenu, true);
	}
	public static int getIntInput(Menu previousMenu, boolean shouldAdvanceInputOnFail)
			throws NotANumberException, GoBackRequest {
		startInputColor();
		try {
			int intInput = SCANNER.nextInt();
			return intInput;
		} catch(Exception e) {
			handleNumericInputTypeMismatch(
					"Input must be a whole number.", previousMenu, e);
			throw e; // should be unreachable b/c previous line throws, but compiler doesn't like it if this line isn't here though.
		}
	}
	
	public static long getLongInput() throws GoBackRequest, NotANumberException {
		return getLongInput(getDefaultPreviousMenu());
	}
	public static long getLongInput(Menu previousMenu) throws GoBackRequest, NotANumberException {
		return getLongInput(previousMenu, true);
	}
	public static long getLongInput(Menu previousMenu, boolean shouldAdvanceInputOnFail)
			throws GoBackRequest, NotANumberException {
		startInputColor();
		try {
			long longInput = SCANNER.nextLong();
			return longInput;
		} catch(Exception e) {
			handleNumericInputTypeMismatch(
					"Input must be a whole number.", previousMenu, e);
			throw e;
		}
	}
	
	public static DollarAmount getDollarAmountInput() throws GoBackRequest, NotANumberException {
		return getDollarAmountInput(getDefaultPreviousMenu());
	}
	public static DollarAmount getDollarAmountInput(Menu previousMenu)
			throws GoBackRequest, NotANumberException {
		startInputColor();
		try {
			double rawDollarAmountInput = SCANNER.nextDouble();
			long amountInCents = (long) Math.floor((rawDollarAmountInput * 100d) + 0.5d);
			return new DollarAmount(amountInCents);
		} catch(Exception e) {
			handleNumericInputTypeMismatch(
					"Input must be a number.", previousMenu, e);
			throw e;
		}
	}
	
	public static String getNonStyledStringInput() throws GoBackRequest {
		return getNonStyledStringInput(getDefaultPreviousMenu());
	}
	private static String getNonStyledStringInput(Menu previousMenu) throws GoBackRequest {
		String input = SCANNER.next();
		checkForGoBackRequest(input);
		Colors.resetConsoleColor();
		return input;
	}
	
	public static String getStringInput() throws GoBackRequest {
		return getStringInput(getDefaultPreviousMenu());
	}
	public static String getStringInput(Menu previousMenu) throws GoBackRequest {
		startInputColor();
		return getNonStyledStringInput(previousMenu);
	}

	public static String getHiddenStringInput() throws GoBackRequest {
		return getHiddenStringInput(getDefaultPreviousMenu());
	}
	public static String getHiddenStringInput(Menu previousMenu) throws GoBackRequest {
		Colors.BLUE_BLOCKS.startConsoleColor();
		return getNonStyledStringInput(previousMenu);
	}
	
	public static void getEnterToContinueInput() {
		System.out.println(Colors.YELLOW.colorize(
				"\nPress \"Enter\" to continue..."));
		Colors.CYAN.startConsoleColor();
		SCANNER.next();
		Colors.resetConsoleColor();
	}
	
	public static void close() {
		SCANNER.close();
	}
	
}
