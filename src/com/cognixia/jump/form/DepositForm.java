package com.cognixia.jump.form;

import com.cognixia.jump.model.Account;
import com.cognixia.jump.utility.Colors;

public class DepositForm extends Form {

	public DepositForm(Account account) {
		super(
				"DEPOSIT FORM\n " + Colors.YELLOW.colorize("Depositing into " + account.toString()),
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
