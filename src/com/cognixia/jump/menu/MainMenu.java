package com.cognixia.jump.menu;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.form.OpenAccountForm;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.display.PatronDisplay;
import com.cognixia.jump.utility.display.TransactionDisplay;

public class MainMenu extends Menu {
	
	private Patron user;

	public MainMenu() {
		super(getOptions(), "Main Menu");
		user = DollarsBankDriver.getCurrentUser();
	}
	
	private static MenuOption[] getOptions() {
		Patron user = DollarsBankDriver.getCurrentUser();
		MenuOption[] options = {
			new MenuOption(
					"Accounts",
					new SelectAccountMenu()::run),
			new MenuOption(
					"Open New Account",
					new OpenAccountForm()::run),
			new MenuOption(
					"Recent Transactions", () -> {
						TransactionDisplay.printRecentTransactions(
								user.getTransactions(), "All Accounts");
						new MainMenu().run();
					}),
			new MenuOption(
					"Customer Info", () -> {
						PatronDisplay.printPatronInfo();
						new MainMenu().run();
					}),
			new MenuOption(
					"Sign Out",
					DollarsBankDriver::logout)
		};
		return options;
	}
}
