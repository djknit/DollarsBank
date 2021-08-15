package com.cognixia.jump.utility;

import java.util.Arrays;

public class Display {
	
	private static final int H_LINES_WIDTH = 42;
	private static final String H_RULE = createRepeatCharString('_');
	private static final String DIVIDER =
			createRepeatCharString('_') + "\n" + createRepeatCharString('$');
	
	public static void printDivider() {
		System.out.println(DIVIDER);
	}
	
	public static void printHRule() {
		System.out.println(H_RULE);
	}
	
	public static String createRepeatCharString(char character) {
		return createRepeatCharString(character, H_LINES_WIDTH);
	}
	public static String createRepeatCharString(char character, int numChars) {
		// source: https://stackoverflow.com/questions/1900477/can-one-initialise-a-java-string-with-a-single-repeated-character-to-a-specific#answer-1900482
		char[] chars = new char[numChars];
		Arrays.fill(chars, character);
		return new String(chars);
	}
	
}
