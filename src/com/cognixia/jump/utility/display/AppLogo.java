package com.cognixia.jump.utility.display;

import com.cognixia.jump.utility.Colors;

class AppLogo {

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
	
	private final int LOGO_WIDTH = LOGO_BODY_LINES[1].length() + EDGE_WIDTH; // must pick a line with no ansi codes to measure
	
	private final String[] WELCOME_TEXT_LINES = {
			"\\    /               \\ /    |",
			" \\/\\/ E L C O M E S   | O U o"
	};
	
	private final String LOGO_DOLLAR_SIGN_ROW = Display.createRepeatCharString('$', LOGO_WIDTH);
	private final String GREEN_$_ROW = Colors.GREEN.colorize(LOGO_DOLLAR_SIGN_ROW);
	private final String MAGENTA_$_ROW = Colors.MAGENTA.colorize(LOGO_DOLLAR_SIGN_ROW);
	
	private String[] LOGO_LINES =
			new String[LOGO_BODY_LINES.length + WELCOME_TEXT_LINES.length + 4];
											//			                   /\
											//							  //\\
	{										//							   ||
		int nextIndex = 0;					//	   ,=======================~'
		LOGO_LINES[nextIndex++] = GREEN_$_ROW; // 1st additional line not in logo or welcome lines arrays
		for (String line : LOGO_BODY_LINES) {
			LOGO_LINES[nextIndex++] = L_EDGE_$$ + Colors.GREEN.getAnsiCode() + line + R_EDGE_$$;
		}
		LOGO_LINES[nextIndex++] = GREEN_$_ROW; // 2nd
		for (String line : WELCOME_TEXT_LINES) {
			LOGO_LINES[nextIndex++] =
					L_EDGE_$$ +
					Colors.YELLOW.colorize(Display.getTextCenteredOnLine(line, LOGO_WIDTH - EDGE_WIDTH)) +
					R_EDGE_$$;
		}
		LOGO_LINES[nextIndex++] = GREEN_$_ROW; // 3rd
		LOGO_LINES[nextIndex++] = MAGENTA_$_ROW; // 4th
	}
	
	void print() {
		for (String lineText : LOGO_LINES) {
			System.out.println(lineText);
		}
	}
	

	private static class LogoBodyText {
		
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
	}
	
}
