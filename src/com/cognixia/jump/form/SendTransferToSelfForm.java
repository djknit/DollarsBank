package com.cognixia.jump.form;

import com.cognixia.jump.controller.TransactionController;
import com.cognixia.jump.exception.OutOfRangeNumberException;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.DollarAmount;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.InputScanner;
import com.cognixia.jump.utility.Validation;

public class SendTransferToSelfForm extends Form {
	
	private static Account originAccount;
	private static int transferType;
	
	private static DollarAmount amount;
//	
	private static final FormInput[] inputs = {
		new FormInput(
				"Enter the Account Id of the account to send the transfer to.",
				() -> {
//					targetAccount = InputScanner.getLongInput();
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
					"Who owns the account you wish to send a transfer to?",
					"Enter the number of your choice.",
					() -> {
						System.out.println(Colors.CYAN.colorize(
								"  1.) Myself. (Send to another account I own.)" +
								"  2.) Someone else. (Send to an account belonging to somebody else.)"));
						transferType = InputScanner.getIntInput();
					},
					() -> {
						if (transferType < 1 || transferType > 2) {
							throw new OutOfRangeNumberException(
									"Invalid choice. Please enter \"1\" or \"2\".");
						}
					})
			
		};
		return inputs;
	}
	
	

	@Override
	void submit() {
		
	}

}
