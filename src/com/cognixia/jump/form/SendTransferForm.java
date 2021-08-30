package com.cognixia.jump.form;

import com.cognixia.jump.controller.TransactionController;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.DollarAmount;
import com.cognixia.jump.utility.Colors;

public class SendTransferForm extends Form {
	
	private static Account originAccount;
	private static int 
	private static Account targetAccount;
	private static DollarAmount amount;
//	private static final FormInput[] inputs = {
//		new FormInput(
//				"",
//			)
//	};

	private TransactionController transController;

	public SendTransferForm(Account account) {
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
								
					},
					() -> {
						
					})
		};
		return inputs;
	}

	@Override
	void submit() {
		
	}

}
