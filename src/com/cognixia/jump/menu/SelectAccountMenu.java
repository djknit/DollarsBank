package com.cognixia.jump.menu;

import java.util.List;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.forms.OpenAccountForm;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.Colors;

public class SelectAccountMenu extends Menu {

	public SelectAccountMenu() {
		super(getOptions(), getMenuName(), true);
	}
	
	private static MenuOption[] getOptions() {
		List<Account> accounts = DollarsBankDriver.getCurrentUser().getAccounts();
		int numAccounts = accounts.size();
		MenuOption[] options = new MenuOption[1 + (numAccounts > 0 ? numAccounts : 1)];
		options[0] = new MenuOption("Back to Main Menu", new MainMenu()::run);
		if (numAccounts == 0) {
			options[1] = new MenuOption("Open new bank account", new OpenAccountForm()::run);
		}
		for (int i = 0; i < numAccounts; i++) {
			Account account = accounts.get(i);
			options[i + 1] = new MenuOption(null, null);
		}
		return options;
	}
	
	private static String getMenuName() {
		Patron user = DollarsBankDriver.getCurrentUser();
		String name = user.getName().toUpperCase() + "'S ACCOUNTS:";
		if (user.getAccounts().size() == 0) {
			name += Colors.YELLOW.colorize(
					"\nYou don't have any accounts. You must open a bank account to perform any transactions.");
		}
		return name;
	}
	
	@Override
	public void run() {
		
	}
	
}
