package com.cognixia.jump.form;

import com.cognixia.jump.model.Account;
import com.cognixia.jump.utility.Colors;

public class WithdrawalForm extends Form {

	public WithdrawalForm(Account account) {
		super(
				"WITHDRAWAL FORM\n " + Colors.YELLOW.colorize("Withdrawing from " + account.toString()),
				getInputs(account),
				true);
	}
	
	private static FormInput[] getInputs(Account account) {
		FormInput[] inputs = {};
		return inputs;
	}

	@Override
	void submit() {
		// TODO Auto-generated method stub
		
	}

}
