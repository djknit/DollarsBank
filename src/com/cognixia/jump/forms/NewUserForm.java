package com.cognixia.jump.forms;

import com.cognixia.jump.input.InputScanner;
import com.cognixia.jump.utility.Validation;

public class NewUserForm extends Form {
	
	private static String name;
	private static String address;
	private static String username;
	
	
	private static FormInput[] inputs = {
		new FormInput(
				"Enter your name",
				() -> {
					name = InputScanner.getStringInput();
				},
				() -> {
					Validation.validateName(name);
				}),
		new FormInput(
				"Enter your address",
				() -> {
					address = InputScanner.getStringInput();
				},
				() -> {
					
				}),
		new FormInput(
				"Enter a username",
				"3 characters minimum",
				() -> {
					username = InputScanner.getStringInput();
				},
				() -> {
					Validation.validateUsername(username);
				}),
	};

	public NewUserForm() {
		super("Create New User", inputs);
	}

	
}
