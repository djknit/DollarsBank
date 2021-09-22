package com.cognixia.jump.menu;

import com.cognixia.jump.form.SendTransferToDifferentPatronForm;
import com.cognixia.jump.form.SendTransferToSelfForm;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.InputScanner;

public class SelectTransferTargetTypeMenu extends Menu {
	
	SelectTransferTargetTypeMenu(Account originAccount) {
		super(getOptions(originAccount), "Choose transfer type.");
	}
	
	private static MenuOption[] getOptions(Account account) {
		MenuOption[] options = {
			new MenuOption(
					"Select one of my own accounts to receive the transfer.",
					() -> {
						if (account.getPatron().getAccounts().size() < 2) {
							System.out.println(Colors.RED.colorize(
									"You don't have any accounts to transfer to." +
									"\nYou must have at least two accounts in order to send a transfer to yourself."));
							InputScanner.getEnterToContinueInput();
							new AccountMenu(account).run();
						} else {
							new SendTransferToSelfForm(account).run();
						}
					}), 
			new MenuOption(
					"Send to any account by account ID number.",
					() -> {
						new SendTransferToDifferentPatronForm(account).run();
					})
		};
		return options;
	}

}
