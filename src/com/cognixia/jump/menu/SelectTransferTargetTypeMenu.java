package com.cognixia.jump.menu;

import com.cognixia.jump.form.SendTransferToDifferentPatronForm;
import com.cognixia.jump.form.SendTransferToSelfForm;
import com.cognixia.jump.model.Account;

public class SelectTransferTargetTypeMenu extends Menu {
	
	SelectTransferTargetTypeMenu(Account originAccount) {
		super(getOptions(originAccount), "Choose transfer type.");
	}
	
	private static MenuOption[] getOptions(Account account) {
		MenuOption[] options = {
			new MenuOption(
					"Select one of my own accounts to receive the transfer.",
					() -> {
						new SendTransferToSelfForm(account).run();
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
