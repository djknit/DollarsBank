package com.cognixia.jump.utility;

import java.util.Arrays;

public class Display {
	
	private static final int H_LINES_WIDTH = 42;
	private static final String H_RULE = createRepeatCharString('_');
	private static final String MINOR_DIVIDER = createRepeatCharString('-');
	private static final String DIVIDER = H_RULE + "\n" + MINOR_DIVIDER;
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
	
	static class AppLogo {
		private final String L_EDGE_$$ = Colors.GREEN.colorize("$") + Colors.MAGENTA.colorize("$");
		private final String R_EDGE_$$ = Colors.MAGENTA.colorize("$") + Colors.GREEN.colorize("$");
		private final int EDGE_WIDTH = 4; // total for BOTH edges
		private final String[] LOGO_BODY_LINES = {
			Colors.MAGENTA.colorize(" $ $    $  $  $   $      $     $  $      $        $      $    $     $ $     "),
			"  _______________________________________________________ $      $   $ $    ",
			" |$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$| " + LogoBodyText.BIG_$_LINES[0] + " ",
			" ||   " + LogoBodyText.MAIN_LINES[0] + "   || " + LogoBodyText.BIG_$_LINES[1] + " ",
			" |$   " + LogoBodyText.MAIN_LINES[1] + "   $| " + LogoBodyText.BIG_$_LINES[2] + " ",
			" ||   " + LogoBodyText.MAIN_LINES[2] + "   || " + LogoBodyText.BIG_$_LINES[3] + " ",
			" |$   " + LogoBodyText.MAIN_LINES[3] + "   $| " + LogoBodyText.BIG_$_LINES[4] + " ",
			" ||   --- --- --- --- --- --- ---     --- --- --- ---   || " + LogoBodyText.BIG_$_LINES[5] + " ",
			" |$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$~$| " + LogoBodyText.BIG_$_LINES[6] + " ",
			" \\_____/'~~~y~~'\\_____/'~~~y~~'\\_______/'~~~~y~~~~'\\_____/                  ",
			Colors.MAGENTA.colorize(" / \\_/ \\___/|___/ \\_/ \\___/|___/ \\___/ \\____/|_____/ \\_/ \\" + "$$$$$$$$$$$$$$$$$$")
		};
		private final int LOGO_WIDTH = LOGO_BODY_LINES[1].length() + EDGE_WIDTH;
		private final String[] WELCOME_TEXT_LINES = {
				"\\    /               \\ /    |",
				" \\/\\/ E L C O M E S   | O U o"
		};
		private final String LOGO_DOLLAR_SIGN_ROW = createRepeatCharString('$', LOGO_WIDTH);
		private final String GREEN_$_ROW = Colors.GREEN.colorize(LOGO_DOLLAR_SIGN_ROW);
		private final String MAGENTA_$_ROW = Colors.MAGENTA.colorize(LOGO_DOLLAR_SIGN_ROW);
		private String[] LOGO_LINES =
				new String[LOGO_BODY_LINES.length + WELCOME_TEXT_LINES.length + 6];
															//                 /\
		{													//   ___________  //\\
			int nextIndex = 0;								//	/,=========\\__||
			LOGO_LINES[nextIndex++] = GREEN_$_ROW; // 1st additional line not in logo or welcome lines arrays
			for (String line : LOGO_BODY_LINES) {
				LOGO_LINES[nextIndex++] = L_EDGE_$$ + Colors.GREEN.getAnsiCode() + line + R_EDGE_$$;
			}
			LOGO_LINES[nextIndex++] = GREEN_$_ROW; // 2
			for (String line : WELCOME_TEXT_LINES) {
				LOGO_LINES[nextIndex++] =
						L_EDGE_$$ + Colors.YELLOW.colorize(getTextCenteredOnLine(line, LOGO_WIDTH - 4)) + R_EDGE_$$;
			}
			LOGO_LINES[nextIndex++] = GREEN_$_ROW; // 3
			LOGO_LINES[nextIndex++] = ""; // 4
			LOGO_LINES[nextIndex++] = MAGENTA_$_ROW; // 5
			LOGO_LINES[nextIndex++] = MAGENTA_$_ROW; // 6
		}
		
		void print() {
			for (String lineText : LOGO_LINES) {
				System.out.println(lineText);
			}
		}
		
		static class LogoBodyText {
			private static String[] MAIN_LINES = {
				"     _               _           _             ",
				"$\\  / \\ $   $    $  $ ) ((\\     $ )  $  $ | $ /",
				"$ } $ } $   $   $~\\ $<   $      $<  $~\\ $\\| $< ",
				"$/  \\_/ $~~ $~~ $ \\ $ \\ \\))     $_) $ \\ $ | $ \\"
			};
			private static String[] BIG_$_LINES = {
				" ||    ||    || ",
				"$$$$  $$$$  $$$$",
				"$||   $||   $|| ",
				"$$$$  $$$$  $$$$",
				" ||$   ||$   ||$",
				"$$$$  $$$$  $$$$",
				" ||    ||    || "
			};
			static {
				colorize(MAIN_LINES);
				colorize(BIG_$_LINES);
			}
			private static void colorize(String[] noncoloredText) {
				for (int i = 0; i < noncoloredText.length; i++) {
					noncoloredText[i] =
							Colors.YELLOW.getAnsiCode() + noncoloredText[i] + Colors.GREEN.getAnsiCode();
				}
			}
//			static String[] getTextLines() {
//				return LOGO_TEXT_LINES;
//			}
//			static String[] getBig$Lines() {
//				return BIG_$_LINES;
//			}
		}
		
	}
	
}
