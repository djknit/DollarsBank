package com.cognixia.jump;

import com.cognixia.jump.menus.LandingMenu;
import com.cognixia.jump.utility.Display;
import com.cognixia.jump.utility.FileIO;

public class DollarsBankDriver {
    
	public static void main(String[] args) {

		Display.printLogo();
		new LandingMenu().run();
	}
	
}
