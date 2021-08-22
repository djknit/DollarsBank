package com.cognixia.jump.form;

import com.cognixia.jump.controller.PatronController;
import com.cognixia.jump.menu.MainMenu;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.repository.BankDataRepository;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.InputScanner;
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
				"3 characters minimum",
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
				"6 characters minimum",
				() -> {
					password = InputScanner.getHiddenStringInput();
				},
				() -> {
					Validation.validatePassword(password);
				})
	};
	
	private PatronController patronController;
	
	public NewUserForm() {
		super("Create New User", inputs);
		patronController = new PatronController();
	}

	@Override
	void submit() {
		Patron newUser = new Patron(username, password, name, address, phoneNumber);
		patronController.createPatron(newUser);
		System.out.println(Colors.GREEN.colorize(
				"\nSuccess! New Customer Created."));
		new MainMenu().run();
	}
	
}
