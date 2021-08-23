package com.cognixia.jump;

import com.cognixia.jump.menu.LandingMenu;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.display.Display;

public class DollarsBankDriver {
	
	private static Patron CURRENT_USER = null;
	
	public static Patron getCurrentUser() {
		System.out.println("GET CURRENT USER " + CURRENT_USER);
		return CURRENT_USER;
	}
	public static void setCurrentUser(Patron user) {
		System.out.println("SET CURRENT USER " + user);
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
