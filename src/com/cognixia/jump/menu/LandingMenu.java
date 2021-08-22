package com.cognixia.jump.menu;

import com.cognixia.jump.form.NewUserForm;

public class LandingMenu extends Menu {
	
	private static MenuOption[] options = {
		new MenuOption(
				"Login",
				new NewUserForm()::run),
		new MenuOption(
				"Register New User",
				new NewUserForm()::run)
	};
			
	public LandingMenu() {
		super(options, "What would you like to do?", true);
	}

}
