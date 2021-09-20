package com.cognixia.jump.form;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.controller.PatronController;
import com.cognixia.jump.menu.LandingMenu;
import com.cognixia.jump.menu.MainMenu;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.InputScanner;
import com.cognixia.jump.utility.Validation;

public class LoginForm extends Form {
	
	private static String username;
	private static String password;
	private static FormInput[] inputs = {
		new FormInput(
				"Enter your username.",
				() -> username = InputScanner.getStringInput(),
				() -> Validation.validateRequiredOnly(username, "username")),
		new FormInput(
				"Enter your password.",
				() -> password = InputScanner.getHiddenStringInput(),
				() -> Validation.validateRequiredOnly(password, "password"))
	};
	
	private PatronController patronController;

	public LoginForm() {
		super("LOGIN", inputs);
		patronController = new PatronController();
	}

	@Override
	void submit() {
		Patron user = patronController.getPatronByUsername(username);
		if (user == null) {
			handleFail("Incorrect username.");
			return;
		}
		if (!user.getPassword().equals(password)) {
			handleFail("Incorrect password.");
			return;
		}
		DollarsBankDriver.setCurrentUser(user);
		System.out.println(Colors.GREEN.colorize(
				"\nSuccess! You are logged in."));
		new MainMenu(user).run();
	}
	
	private void handleFail(String message) {
		System.out.println(Colors.RED.colorize(
				"\n" + message + " Login failed."));
		new LandingMenu().run();
	}

}
