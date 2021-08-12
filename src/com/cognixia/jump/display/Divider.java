package com.cognixia.jump.display;

abstract public class Divider {

	private static String divider = create('-');
	private static String lowDivider = create('_');
	
	public static String get() {
		return divider;
	}
	
	public static String getLow() {
		return lowDivider;
	}
	
	public static void print() {
		System.out.println(divider);
	}
	
	public static void printLow() {
		System.out.println(lowDivider);
	}
	
	private static String create(char divChar) {
		String divStr = "";
		for (int i = 0; i < 42; i++) {
			divStr += divChar;
		}
		return divStr;
	}
	
}
