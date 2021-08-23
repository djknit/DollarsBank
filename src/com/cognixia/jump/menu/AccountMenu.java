package com.cognixia.jump.menu;

import com.cognixia.jump.model.Account;
import com.cognixia.jump.utility.Colors;

public class AccountMenu extends Menu {
	
	private Account account;

	AccountMenu(Account account) {
		super(
				getOptions(account),
				account.toString().toUpperCase(),
				Colors.WHITE.colorize("Balance:") + Colors.GREEN.colorize(" " + account.getBalance()));
	}
	
	private static MenuOption[] getOptions(Account account) {
		boolean hasBalance = account.getBalance().getAmountInCents() > 0;
		int nextIndex = 0;
		MenuOption[] options = new MenuOption[4];
//		options[nextIndex++] = new MenuOption(
//				, null);
		return options;
	}
	
}
