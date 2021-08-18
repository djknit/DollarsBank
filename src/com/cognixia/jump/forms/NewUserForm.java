package com.cognixia.jump.forms;

import com.cognixia.jump.input.InputScanner;
import com.cognixia.jump.utility.Validation;

public class NewUserForm extends Form {
	
	private static String username;
	
	private static FormInput[] inputs = {
		new FormInput(
				"Enter a username.",
				"3 characters minimum",
				() -> {
					username = InputScanner.getStringInput();
				},
				() -> {
					Validation.validateUsername(username);
				})
	};

	public NewUserForm() {
		super("Create New User", inputs);
	}

	
}
