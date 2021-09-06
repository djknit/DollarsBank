package com.cognixia.jump.menu;

import java.util.List;

import com.cognixia.jump.form.OpenAccountForm;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.Colors;

public class SelectAccountMenu extends Menu {

	public SelectAccountMenu(Patron user) {
		super(getOptions(user), getMenuName(user), getSubtitle(user));
	}
	
	private static MenuOption[] getOptions(Patron user) {
		List<Account> accounts = user.getAccounts();
		int numAccounts = accounts.size();
		MenuOption[] options =
				new MenuOption[numAccounts > 0 ? (numAccounts + 1) : 2];
		options[0] = new MenuOption(
				"Back to Main Menu",
				() -> new MainMenu(user).run());
		if (numAccounts == 0) {
			options[1] = new MenuOption(
					"Open new bank account", new OpenAccountForm()::run);
		}
		for (int i = 0; i < numAccounts; i++) {
			Account account = accounts.get(i);
			options[i + 1] = new MenuOption(
					account.toString(),
					new AccountMenu(account)::run);
		}
		return options;
	}
	
	private static String getMenuName(Patron user) {
		return user.getName().toUpperCase() + "'S ACCOUNTS";
	}
	
	private static String getSubtitle(Patron user) {
		return
			user.getAccounts().size() == 0 ?
			Colors.YELLOW.colorize(
					"You don't have any accounts. You must open a bank account to perform any transactions.") :
			null;
	}
	
}
