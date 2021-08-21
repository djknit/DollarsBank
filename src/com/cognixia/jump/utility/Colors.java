package com.cognixia.jump.utility;

public enum Colors {

	RESET("\u001b[0m"),
	BLACK("\u001b[30m"),
	RED("\u001b[31m"),
	GREEN("\u001b[32m"),
	YELLOW("\u001b[33m"),
	BLUE("\u001b[34m"),
	MAGENTA("\u001b[35m"),
	CYAN("\u001b[36m"),
	WHITE("\u001b[37m");

	private final String ansiCode;
	
	public static void printTest() {
		System.out.println("PRINT TEST");
		for (Colors color : Colors.values()) {
			if (color == RESET) continue;
			System.out.println(color.toString());
			System.out.println(color.colorize(color.toString()));
		}
	}
	
	Colors(String ansiCode) {
		this.ansiCode = ansiCode;
	}
	
	public String colorize(String noncoloredText) {
		return ansiCode + noncoloredText + RESET.ansiCode;
	}
	
	public void startConsoleColor() {
		System.out.print(ansiCode);
	}
	
	public static void resetConsoleColor() {
		System.out.print(RESET.ansiCode);
	}
	
	public String getAnsiCode() {
		return ansiCode;
	}
	
}

/* NOTE TO SELF: An idea for password concealing found @:
 * 		http://www.cse.chalmers.se/edu/year/2018/course/TDA602/Eraserlab/pwdmasking.html
 *  */
