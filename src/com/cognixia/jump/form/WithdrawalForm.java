package com.cognixia.jump.form;

import com.cognixia.jump.controller.TransactionController;
import com.cognixia.jump.menu.AccountMenu;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.DollarAmount;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.InputScanner;
import com.cognixia.jump.utility.Validation;

public class WithdrawalForm extends Form {

	private static Account account;
	private static DollarAmount amount;
	private static final FormInput[] inputs = {
		new FormInput(
				"Enter the amount in USD to withdraw.",
				() -> {
					amount = InputScanner.getDollarAmountInput();
				},
				() -> {
					Validation.validateWithdrawalAmount(account, amount);
				})
	};

	private TransactionController transController;
	
	public WithdrawalForm(Account account) {
		super(
				"WITHDRAWAL FORM\n " + Colors.YELLOW.colorize("Withdrawing from " + account.toString()),
				inputs,
				true);
		WithdrawalForm.account = account;
		transController = new TransactionController();
	}

	@Override
	void submit() {
		transController.withdraw(account, amount);
		System.out.println(Colors.GREEN.colorize(
				"\nSuccess! " + amount + " was withdrawn from " + account + "."));
		new AccountMenu(account).run();
	}

}
