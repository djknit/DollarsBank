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
					"Transfer to another account that I own.",
					() -> {
						new SendTransferToSelfForm(account).run();
					}), 
			new MenuOption(
					"Send to somebody else.",
					() -> {
						new SendTransferToDifferentPatronForm(account).run();
					})
		};
		return options;
	}

}
