package com.cognixia.jump.menus;

import com.cognixia.jump.utility.Colors;
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
		Colors.CYAN.startConsoleColor();
		for (int i = 0; i < options.length; i++) {
			System.out.println("  " + i + ".) " + options[i].getDescription());
		}
		Colors.resetConsoleColor();
		System.out.println("\n" + Colors.YELLOW.colorize(prompt));
	}
	
}
