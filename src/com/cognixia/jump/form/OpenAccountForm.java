package com.cognixia.jump.form;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.controller.AccountController;
import com.cognixia.jump.menu.AccountMenu;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.InputScanner;

public class OpenAccountForm extends Form {
	
	private static String nickname;
	private static FormInput[] inputs = {
		new FormInput(
				"Choose a nickname for your new account.",
				() -> nickname = InputScanner.getStringInput())
	};
	
	private AccountController accountController;
	
	public OpenAccountForm() {
		super("Create Bank Account", inputs);
		accountController = new AccountController();
	}

	@Override
	void submit() {
		Patron user = DollarsBankDriver.getCurrentUser();
		Account newAccount = new Account(user, nickname);
		accountController.createAccount(newAccount);
		System.out.println(Colors.GREEN.colorize(
				"\nSuccess! New account created."));
		new AccountMenu(newAccount).run();
	}

}
