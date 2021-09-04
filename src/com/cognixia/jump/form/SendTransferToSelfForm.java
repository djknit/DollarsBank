package com.cognixia.jump.form;

import com.cognixia.jump.controller.TransactionController;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.DollarAmount;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.InputScanner;
import com.cognixia.jump.utility.Validation;

public class SendTransferToSelfForm extends Form {
	
	private static Account originAccount;
	private static long targetAccountId;
	private static Account targetAccount;
	private static DollarAmount amount;

	private TransactionController transController;

	public SendTransferToSelfForm(Account account) {
		super(
				"MONEY TRANSFER FORM\n " + Colors.YELLOW.colorize(
						"Transfering from " + account.toString()),
				getInputs(account),
				true);
		originAccount = account;
		transController = new TransactionController();
	}
	
	private static FormInput[] getInputs(Account account) {
		FormInput[] inputs = {
			new FormInput(
					"What account are you sending the transfer to?",
					"Enter the account number of your choice.",
					() -> {
						String accountsText = "";
						for (Account patronsAccount : account.getPatron().getAccounts()) {
							if (patronsAccount == account) continue;
							accountsText += " " + patronsAccount + "\n";
						}
						System.out.println(Colors.CYAN.colorize(accountsText));
						targetAccountId = InputScanner.getLongInput();
						targetAccount = account.getPatron().findAccountById(targetAccountId);
					},
					() -> {
						Validation.validateAccountIdForPatron(
								targetAccountId, account.getPatron(), account);
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
		return inputs;
	}
	
	

	@Override
	void submit() {
		transController.sendTransfer(originAccount, amount, targetAccount);
	}

}
