package com.cognixia.jump;

import com.cognixia.jump.menu.LandingMenu;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.display.Display;

public class DollarsBankDriver {
	
	private static Patron CURRENT_USER = null;
	
	public static Patron getCurrentUser() {
		return CURRENT_USER;
	}
	public static void setCurrentUser(Patron user) {
		CURRENT_USER = user;
	}
	public static void logout() {
		setCurrentUser(null);
		Display.printDivider();
		System.out.println(Colors.GREEN.colorize("Sign out complete.") + " Goodbye.");
		Display.printHRule();
		new LandingMenu().run();
	}
    
	public static void main(String[] args) {

		Display.printLogo();
		new LandingMenu().run();
		
	}
	
}
