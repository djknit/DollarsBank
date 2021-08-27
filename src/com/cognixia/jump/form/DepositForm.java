package com.cognixia.jump.form;

import com.cognixia.jump.controller.TransactionController;
import com.cognixia.jump.menu.AccountMenu;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.DollarAmount;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.InputScanner;
import com.cognixia.jump.utility.Validation;

public class DepositForm extends Form {

	private static Account account;
	private static DollarAmount amount;
	private static final FormInput[] inputs = {
		new FormInput(
				"Enter the amount to deposit in USD.",
				() -> amount = InputScanner.getDollarAmountInput(),
				() -> Validation.validateDollarAmount(amount))
	};
	
	private TransactionController transController;
	
	public DepositForm(Account account) {
		super(
				"DEPOSIT FORM\n " + Colors.YELLOW.colorize("Depositing into " + account.toString()),
				inputs,
				true);
		DepositForm.account = account;
		transController = new TransactionController();
	}

	@Override
	void submit() {
		transController.deposit(account, amount);
		System.out.println(Colors.GREEN.colorize(
				"\nSuccess! " + amount + " was deposited into " + account + "."));
		new AccountMenu(account).run();
	}

}
