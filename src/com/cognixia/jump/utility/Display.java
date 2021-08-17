package com.cognixia.jump.utility;

import java.util.Arrays;

public class Display {
	
	private static final int H_LINES_WIDTH = 42;
	private static final String H_RULE = createRepeatCharString('_');
	private static final String DIVIDER =
			createRepeatCharString('_') + "\n" + createRepeatCharString('@');
	private static final int LOGO_WIDTH = 80;
	private static final String LOGO_DOLLAR_SIGN_ROW = createRepeatCharString('$', LOGO_WIDTH);
	private static final int LOGO_MAIN_PART_WIDTH = 57;
	private static final String WELCOME_ROW_MAIN_PART = 
			"$$" + getTextCenteredOnLine("* * WELCOME TO DOLLARS BANK! * *", LOGO_MAIN_PART_WIDTH) +
			createRepeatCharString(' ', LOGO_WIDTH - LOGO_MAIN_PART_WIDTH - 4) + "$$";
	private static final String[] LOGO_LINES = {
		LOGO_DOLLAR_SIGN_ROW,
		"$$ $ $    $  $  $   $      $     $  $      $        $      $    $     $ $     $$",
		"$$  _______________________________________________________ $      $   $ $    $$",
		"$$ |$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$|  ||    ||    ||  $$",
		"$$ ||                                                     || $$$$  $$$$  $$$$ $$",
		"$$ |$   $\\  /`\\ $   $    $  $`) ((\\     $`)  $  $ | $ /   $| $||   $||   $||  $$",
		"$$ ||   $ ) $ | $   $   $~\\ $<   $      $<  $~\\ $\\| $<    || $$$$  $$$$  $$$$ $$",
		"$$ |$   $/  \\_/ $~~ $~~ $ \\ $ \\ \\))     $_) $ \\ $ | $ \\   $|  ||$   ||$   ||$ $$",
		"$$ ||   --- --- --- --- --- --- ---     --- --- --- ---   || $$$$  $$$$  $$$$ $$",
		"$$ |$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$|  ||    ||    ||  $$",
		"$$ \\_____/~~~~~~~~~~~~~~~~~~~~~~~\\_______/~~~~~~~~~~~\\_____/                  $$",
		"$$ / \\_/ \\_______________________/ \\___/ \\___________/ \\_/ \\$$$$$$$$$$$$$$$$$ $$",
		LOGO_DOLLAR_SIGN_ROW,
		WELCOME_ROW_MAIN_PART,
		LOGO_DOLLAR_SIGN_ROW
	};
	
	public static void printLogo() {
		for (String lineText : LOGO_LINES) {
			System.out.println(lineText);
		}
	}
	
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
	
	public static String getTextCenteredOnLine(String lineText, int lineCharLength) {
		if (lineText.length() > lineCharLength - 2) return lineText;
		int extraCharsAvailable = lineCharLength - lineText.length();
		if (extraCharsAvailable % 2 != 0) --extraCharsAvailable;
		String result = createRepeatCharString(' ', extraCharsAvailable / 2) + lineText;
		result += createRepeatCharString(' ', lineCharLength - result.length());
		return result;
	}
	
}
