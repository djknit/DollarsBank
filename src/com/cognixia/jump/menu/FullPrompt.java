package com.cognixia.jump.menu;

import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.display.Display;

class FullPrompt {
	
	private MenuOption[] options;
	private String name;
	private String prompt;
	private String subtitle;

	FullPrompt(MenuOption[] options, String menuName, String prompt, boolean leaveCase) {
		this(options, menuName, prompt, leaveCase, null);
	}
	FullPrompt(
			MenuOption[] options, String menuName, String prompt, boolean leaveCase, String subtitle) {
		this.options = options;
		this.name = leaveCase ? menuName : menuName.toUpperCase();
		this.prompt = prompt;
		this.subtitle = subtitle;
	}
	
	public final void print() {
		Display.printDivider();
		System.out.println(name + ":\n");
		if (subtitle != null) {
			System.out.println("\n" + subtitle + "\n");
		}
		Colors.CYAN.startConsoleColor();
		for (int i = 0; i < options.length; i++) {
			System.out.println("  " + i + ".) " + options[i].getDescription());
		}
		Colors.resetConsoleColor();
		System.out.println("\n" + Colors.YELLOW.colorize(prompt));
	}
	
}
