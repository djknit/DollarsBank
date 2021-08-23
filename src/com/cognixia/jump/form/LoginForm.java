package com.cognixia.jump.form;

import com.cognixia.jump.controller.PatronController;

public class LoginForm extends Form {
	
	private static FormInput[] inputs = {};
	
	private PatronController patronController;

	public LoginForm() {
		super("LOGIN", inputs);
		patronController = new PatronController();
	}

	@Override
	void submit() {
		// TODO Auto-generated method stub
		
	}

}
