package com.cognixia.jump.menu;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.form.OpenAccountForm;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.InputScanner;
import com.cognixia.jump.utility.display.PatronDisplay;
import com.cognixia.jump.utility.display.TransactionDisplay;

public class MainMenu extends Menu {
	
//	private Patron user;

	public MainMenu(Patron user) {
		super(getOptions(user), "Main Menu");
	}
	
	private static MenuOption[] getOptions(Patron user) {
		MenuOption[] options = {
			new MenuOption(
					"Accounts",
					() -> new SelectAccountMenu(user).run()),
			new MenuOption(
					"Open New Account",
					() -> new OpenAccountForm().run()),
			new MenuOption(
					"Recent Transactions", () -> {
						TransactionDisplay.printRecentTransactions(
								user.getTransactions(), "All Accounts");
						InputScanner.getEnterToContinueInput();
						new MainMenu(user).run();
					}),
			new MenuOption(
					"Customer Info", () -> {
						PatronDisplay.printPatronInfo();
						InputScanner.getEnterToContinueInput();
						new MainMenu(user).run();
					}),
			new MenuOption(
					"Sign Out", DollarsBankDriver::logout)
		};
		return options;
	}
}
