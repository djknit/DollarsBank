package com.cognixia.jump.utility;

import java.util.Arrays;

public class Display {
	
	private static final int H_LINES_WIDTH = 42;
	private static final String H_RULE = createRepeatCharString('_');
	private static final String DIVIDER =
			createRepeatCharString('_') + "\n" + createRepeatCharString('@');
	public static void printLogo() {
		new AppLogo().print();
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
	
	static class AppLogo {
		private final String[] LOGO_BODY_LINES = {
			"$$ $ $    $  $  $   $      $     $  $      $        $      $    $     $ $     $$",
			"$$  _______________________________________________________ $      $   $ $    $$",
			"$$ |$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$|  ||    ||    ||  $$",
			"$$ ||        _               _           _                || $$$$  $$$$  $$$$ $$",
			"$$ |$   $\\  / \\ $   $    $  $ ) ((\\     $ )  $  $ | $ /   $| $||   $||   $||  $$",
			"$$ ||   $ } $ } $   $   $~\\ $<   $      $<  $~\\ $\\| $<    || $$$$  $$$$  $$$$ $$",
			"$$ |$   $/  \\_/ $~~ $~~ $ \\ $ \\ \\))     $_) $ \\ $ | $ \\   $|  ||$   ||$   ||$ $$",
			"$$ ||   --- --- --- --- --- --- ---     --- --- --- ---   || $$$$  $$$$  $$$$ $$",
			"$$ |$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$|  ||    ||    ||  $$",
			"$$ \\_____/'~~~y~~'\\_____/'~~~y~~'\\_______/'~~~~y~~~~'\\_____/                  $$",
			"$$ / \\_/ \\___/|___/ \\_/ \\___/|___/ \\___/ \\____/|_____/ \\_/ \\$$$$$$$$$$$$$$$$$$$$"
		};
		private final int LOGO_WIDTH = LOGO_BODY_LINES[0].length();
		private final String[] WELCOME_TEXT_LINES = {
				"\\    /               \\ /    |",
				" \\/\\/ E L C O M E S   | O U o"
		};
		private final String LOGO_DOLLAR_SIGN_ROW = createRepeatCharString('$', LOGO_WIDTH);
		private String[] LOGO_LINES =
				new String[LOGO_BODY_LINES.length + WELCOME_TEXT_LINES.length + 6];
															//                 /\
		{											//   ___________  //\\
			int nextIndex = 0;								//	/,=========\\__||
			LOGO_LINES[nextIndex++] = LOGO_DOLLAR_SIGN_ROW; // 1st additional line not in logo or welcome lines arrays
			for (String line : LOGO_BODY_LINES) {
				LOGO_LINES[nextIndex++] = line;
			}
			LOGO_LINES[nextIndex++] = LOGO_DOLLAR_SIGN_ROW; // 2
			for (String line : WELCOME_TEXT_LINES) {
				LOGO_LINES[nextIndex++] = "$$" + getTextCenteredOnLine(line, LOGO_WIDTH - 4) + "$$";
			}
			LOGO_LINES[nextIndex++] = LOGO_DOLLAR_SIGN_ROW; // 3
			LOGO_LINES[nextIndex++] = ""; // 4
			LOGO_LINES[nextIndex++] = LOGO_DOLLAR_SIGN_ROW; // 5
			LOGO_LINES[nextIndex++] = LOGO_DOLLAR_SIGN_ROW; // 6
		}
		
		void print() {
			for (String lineText : LOGO_LINES) {
				System.out.println(lineText);
			}
		}
	}
	
}
