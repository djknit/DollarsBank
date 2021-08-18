package com.cognixia.jump.menus;

class LandingMenu extends Menu {
	
	MenuOption[] options = {
		new MenuOption("Login", null),
		new MenuOption("Register New User", null)
	};
			
	LandingMenu(MenuOption[] options, String name) {
		super(options, "What would you like to do?", true);
	}

//	static MenuOption[] options = {
//		new MenuOption("Employees", () -> {
////			Menus.employees();
//		}),
//		new MenuOption("Departments", () -> {
////			Menus.departments();
//		})
//	};
//	
}
