package com.cognixia.jump.utility.display;

import java.util.Arrays;

import com.cognixia.jump.utility.Colors;

public class Display {
	
	private static final int H_LINES_WIDTH = 42;
	private static final String H_RULE = createRepeatCharString('_');
	private static final String MINOR_DIVIDER = createRepeatCharString('-');
	private static final String DIVIDER = Colors.GREEN.colorize(H_RULE + "\n" + MINOR_DIVIDER);
	public static void printLogo() {
		new AppLogo().print();
	}
	
	public static void printDivider() {
		System.out.println(DIVIDER);
	}
	
	public static void printHRule() {
		System.out.println(H_RULE);
	}
	
	public static void printMinorDivider() {
		System.out.println(MINOR_DIVIDER);
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
	
	public static String getTextCenteredOnLine(String lineText, int lineCharLength) {
		if (lineText.length() > lineCharLength - 2) return lineText;
		int extraCharsAvailable = lineCharLength - lineText.length();
		if (extraCharsAvailable % 2 != 0) --extraCharsAvailable;
		String result = createRepeatCharString(' ', extraCharsAvailable / 2) + lineText;
		result += createRepeatCharString(' ', lineCharLength - result.length());
		return result;
	}
	
	public static String getTextRightAligned(String lineText) {
		return getTextRightAligned(lineText, H_LINES_WIDTH);
	}
	public static String getTextRightAligned(String lineText, int lineCharLength) {
		int xtraChars = lineCharLength - lineText.length();
		return xtraChars > 0 ?
				createRepeatCharString(' ', xtraChars) + lineText :
				lineText;
	}
	
	
}
