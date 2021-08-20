package com.cognixia.jump.forms;

import com.cognixia.jump.input.InputScanner;
import com.cognixia.jump.utility.Validation;

public class NewUserForm extends Form {
	
	private static String name;
	private static String address;
	private static String username;
	private static long phoneNumber;
	private static String password;
	
	
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
					Validation.validateAddress(address);
				}),
		new FormInput(
				"Enter your phone number.",
				() -> {
					phoneNumber = InputScanner.getLongInput();
				},
				() -> {
					Validation.validatePhoneNumber(phoneNumber);
				}),
		new FormInput(
				"Create a username",
				"3 characters minimum",
				() -> {
					username = InputScanner.getStringInput();
				},
				() -> {
					Validation.validateUsername(username);
				}),
		new FormInput(
				"Create a password",
				"3 characters minimum",
				() -> {
					password = InputScanner.getStringInput();
				},
				() -> {
					Validation.validatePassword(password);
				})
	};

	public NewUserForm() {
		super("Create New User", inputs);
	}

	
}
