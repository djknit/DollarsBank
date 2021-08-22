package com.cognixia.jump;

import com.cognixia.jump.menus.LandingMenu;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.Display;

public class DollarsBankDriver {
	
	private static Patron CURRENT_USER = null;
	
	public static Patron getCurrentUser() {
		return CURRENT_USER;
	}
	public static void setCurrentUser(Patron user) {
		CURRENT_USER = user;
	}
    
	public static void main(String[] args) {

		Display.printLogo();
		new LandingMenu().run();
		
	}
	
}
