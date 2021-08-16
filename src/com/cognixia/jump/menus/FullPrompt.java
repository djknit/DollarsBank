package com.cognixia.jump.menus;

import com.cognixia.jump.utility.Display;

class FullPrompt {
	
	private MenuOption[] options;
	private String name;
	private String prompt;

	FullPrompt(MenuOption[] options, String menuName, String prompt, boolean leaveCase) {
		this.options = options;
		this.name = leaveCase ? menuName : menuName.toUpperCase();
		this.prompt = prompt;
	}
	
	public final void print() {
		Display.printDivider();
		System.out.println(name + ":\n");
		for (int i = 0; i < options.length; i++) {
			System.out.println("  " + i + ".) " + options[i].getDescription());
		}
		System.out.println("\n" + prompt);
	}
	
}
