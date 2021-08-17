package com.cognixia.jump.input;

import java.util.Scanner;

import com.cognixia.jump.model.DollarAmount;

public class InputScanner {
	
	private static final Scanner SCANNER;
	
	static {
		SCANNER = new Scanner(System.in);
		SCANNER.useDelimiter(System.lineSeparator()); // source: https://www.reddit.com/r/javahelp/wiki/scanner
	}
	
	public static String getLinePreface() {
		return " >> ";
	}
	
	public static int getIntInput() throws Exception {
		return getIntInput(true);
	}
	
	public static int getIntInput(boolean shouldAdvanceInputOnFail) throws Exception {
		try {
			int intInput = SCANNER.nextInt();
			return intInput;
//		} catch(InputMismatchException e) {
//			if (shouldAdvanceInputOnFail) SCANNER.next();
//			throw new InvalidIntException(e);
		} catch(Exception e) {
			if (shouldAdvanceInputOnFail) SCANNER.next();
			throw e;
		}
	}
	
	public static long getLongInput(boolean shouldAdvanceInputOnFail) throws Exception {
		try {
			long longInput = SCANNER.nextLong();
			return longInput;
		} catch(Exception e) {
			if (shouldAdvanceInputOnFail) SCANNER.next();
			throw e;
		}
	}
	
	public static DollarAmount getDollarAmountInput() throws Exception {
		try {
			double rawDollarAmountInput = SCANNER.nextDouble();
			long amountInCents = (long) Math.floor((rawDollarAmountInput * 100d) + 0.5d);
			return new DollarAmount(amountInCents);
		} catch(Exception e) {
			SCANNER.next();
			throw e;
		}
	}
	
	public static String getInput() {
		return SCANNER.next();
	}
	
	public static void close() {
		SCANNER.close();
	}
	
}
