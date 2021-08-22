package com.cognixia.jump.menus;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.model.Patron;

public class MainMenu extends Menu {
	
	private Patron user;

	public MainMenu() {
		super(getOptions(), "Main Menu");
		user = DollarsBankDriver.getCurrentUser();
	}
	
	private static MenuOption[] getOptions() {
		Patron user = DollarsBankDriver.getCurrentUser();
		MenuOption[] options = {
			new MenuOption("Accounts", null),
			new MenuOption("Open New Account", null),
			new MenuOption("Recent Transactions", null),
			new MenuOption("Customer Info", null),
			new MenuOption("Sign Out", null)
		};
		return options;
	}
}
