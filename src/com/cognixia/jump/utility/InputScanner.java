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
	
	private static void checkForAndDoGoBackRequest(String input, Menu previousMenu) {
		if (input.trim().equals("-b") || input.trim().equals("<")) {
			try {
				previousMenu.run();
			} catch (Exception e) {
				System.out.println(Colors.RED.colorize(
						"ERROR: An unexpected exception has occured.\n"));
			}
		}
	}
	
//	private static void handleNumericInputTypeMismatch(
//			String badTypeMessage, Menu previousMenu) throws NotANumberException {
//		handleNumericInputTypeMismatch(badTypeMessage, previousMenu, null);
//	}
	private static void handleNumericInputTypeMismatch(
			String badTypeMessage, Menu previousMenu, Throwable e) throws NotANumberException {
		Colors.resetConsoleColor();
		String input = SCANNER.next().trim();
		checkForAndDoGoBackRequest(input, previousMenu);
		throw new NotANumberException(badTypeMessage, e);
	}
	
	private static void startInputColor() {
		Colors.CYAN.startConsoleColor();
	}
	
	public static int getIntInput()
			throws NotANumberException, Exception {
		return getIntInput(getDefaultPreviousMenu());
	}
	public static int getIntInput(Menu previousMenu)
			throws NotANumberException, Exception {
		return getIntInput(previousMenu, true);
	}
	public static int getIntInput(Menu previousMenu, boolean shouldAdvanceInputOnFail)
			throws NotANumberException, Exception {
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
	
	public static long getLongInput() throws Exception {
		return getLongInput(getDefaultPreviousMenu());
	}
	public static long getLongInput(Menu previousMenu) throws Exception {
		return getLongInput(previousMenu, true);
	}
	public static long getLongInput(Menu previousMenu, boolean shouldAdvanceInputOnFail) throws Exception {
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
	
	public static DollarAmount getDollarAmountInput() throws Exception {
		return getDollarAmountInput(getDefaultPreviousMenu());
	}
	public static DollarAmount getDollarAmountInput(Menu previousMenu) throws Exception {
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
	
	public static String getNonStyledStringInput() {
		return getNonStyledStringInput(getDefaultPreviousMenu());
	}
	private static String getNonStyledStringInput(Menu previousMenu) {
		String input = SCANNER.next();
		checkForAndDoGoBackRequest(input, previousMenu);
		Colors.resetConsoleColor();
		return input;
	}
	
	public static String getStringInput() {
		return getStringInput(getDefaultPreviousMenu());
	}
	public static String getStringInput(Menu previousMenu) {
		startInputColor();
		return getNonStyledStringInput(previousMenu);
	}

	public static String getHiddenStringInput() {
		return getHiddenStringInput(getDefaultPreviousMenu());
	}
	public static String getHiddenStringInput(Menu previousMenu) {
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
