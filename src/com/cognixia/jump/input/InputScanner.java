package com.cognixia.jump.input;

import java.util.Scanner;

import com.cognixia.jump.exception.NotANumberException;
import com.cognixia.jump.model.DollarAmount;
import com.cognixia.jump.utility.Colors;

public class InputScanner {
	
	private static final Scanner SCANNER;
	
	static {
		SCANNER = new Scanner(System.in);
		SCANNER.useDelimiter(System.lineSeparator()); // source: https://www.reddit.com/r/javahelp/wiki/scanner
	}
	
	public static int getIntInput() throws Exception {
		return getIntInput(true);
	}
	public static int getIntInput(boolean shouldAdvanceInputOnFail) throws Exception {
		try {
			Colors.CYAN.startConsoleColor();
			int intInput = SCANNER.nextInt();
			return intInput;
		} catch(Exception e) {
			Colors.resetConsoleColor();
			SCANNER.next();
			throw new NotANumberException("Input must be a whole number.", e);
		}
	}
	
	
	public static long getLongInput() throws Exception {
		return getLongInput(true);
	}
	public static long getLongInput(boolean shouldAdvanceInputOnFail) throws Exception {
		try {
			Colors.CYAN.startConsoleColor();
			long longInput = SCANNER.nextLong();
			return longInput;
		} catch(Exception e) {
			Colors.resetConsoleColor();
			SCANNER.next();
			throw new NotANumberException("Input must be a whole number.", e);
		}
	}
	
	public static DollarAmount getDollarAmountInput() throws Exception {
		try {
			Colors.CYAN.startConsoleColor();
			double rawDollarAmountInput = SCANNER.nextDouble();
			long amountInCents = (long) Math.floor((rawDollarAmountInput * 100d) + 0.5d);
			return new DollarAmount(amountInCents);
		} catch(Exception e) {
			Colors.resetConsoleColor();
			SCANNER.next();
			throw new NotANumberException("Input must be an number.", e);
		}
	}
	
	public static String getStringInput() {
		Colors.CYAN.startConsoleColor();
		String input = SCANNER.next();
		Colors.resetConsoleColor();
		return input;
	}
	
	public static String getHiddenStringInput() {
		Colors.BLUE_BLOCKS.startConsoleColor();
		String input = SCANNER.next();
		Colors.resetConsoleColor();
		return input;
	}
	
	public static void close() {
		SCANNER.close();
	}
	
}
