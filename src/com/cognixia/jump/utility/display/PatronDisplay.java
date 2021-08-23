package com.cognixia.jump.utility.display;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.Colors;

public class PatronDisplay {
	
	// there is no use for instance, so don't confuse developer by allowing instantiation
	private PatronDisplay() {}

	public static void printPatronInfo() {
		printPatronInfo(DollarsBankDriver.getCurrentUser());
	}

	public static void printPatronInfo(Patron patron) {
		Display.printDivider();
		System.out.println("CUSTOMER INFO:\n");
		printAttribute("Username", patron.getUsername());
		printAttribute("Name", patron.getName());
		printAttribute("Address", patron.getAddress());
		printAttribute("Phone #", "" + patron.getPhoneNumber());
	}
	
	private static void printAttribute(String name, String value) {
		System.out.println(
				Colors.WHITE.colorize(name + ": ") +
				Colors.GREEN.colorize(value));
	}
	
}
