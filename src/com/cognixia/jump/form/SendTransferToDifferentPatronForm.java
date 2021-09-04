package com.cognixia.jump.form;

import com.cognixia.jump.controller.AccountController;
import com.cognixia.jump.controller.TransactionController;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.DollarAmount;
import com.cognixia.jump.utility.InputScanner;
import com.cognixia.jump.utility.Validation;

public class SendTransferToDifferentPatronForm extends Form {
	
	private static Account originAccount;
	private static long targetAccountId;
	private static Account targetAccount;
	private static DollarAmount amount;
	
	private static final FormInput[] inputs = {
		new FormInput(
				"Enter the Account Id of the account to send the transfer to.",
				() -> {
					targetAccountId = InputScanner.getLongInput();
					targetAccount = new AccountController().findById(targetAccountId);
				},
				() -> {
					Validation.validateAccountId(targetAccountId);
				}),
		new FormInput(
				"How much money do you want to transfer?",
				() -> {
					amount = InputScanner.getDollarAmountInput();
				},
				() -> {
					Validation.validateWithdrawalAmount(originAccount, amount);
				})
	};
	
	private TransactionController transController;
	
	public SendTransferToDifferentPatronForm(Account account) {
		super("MONEY TRANSFER FORM", inputs);
		originAccount = account;
		transController = new TransactionController();
	}

	@Override
	void submit() {
		System.out.println("SUBMIT SEND TRANSFER");
		System.out.println("origin " + originAccount);
		System.out.println("target id #: " + targetAccountId);
		System.out.println("target " + targetAccount);
		transController.sendTransfer(originAccount, amount, targetAccount);
	}
	
}
