package com.cognixia.jump.menu;

public class SelectTransferTargetTypeMenu extends Menu {
	
	private static MenuOption[] options = {
		new MenuOption(
				"Transfer to another account that I own.",
				() -> {
					// selection menu
				}), 
		new MenuOption(
				"Send to somebody else.",
				() -> {
					// id (int/long) input (account#id)
				})
	};

	SelectTransferTargetTypeMenu() {
		super(options, "Choose transfer type.");
	}

}
