package com.cognixia.jump.menu;

import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.InputScanner;

abstract class Menu {
	
	private static final String DEFAULT_PROMPT =
			"Enter the corresponding number to select an option:";

	private MenuOption[] options;
	private FullPrompt fullPrompt = null;
	
	Menu(MenuOption[] options, String name) {
		this(options, name, false);
	}
	Menu(MenuOption[] options, String name, boolean leaveNameCase) {
		this(options, name, leaveNameCase, null);
	}
	Menu(MenuOption[] options, String name, String subtitle) {
		this(options, name, false, subtitle);
	}
	
	Menu(MenuOption[] options, String name, boolean leaveNameCase, String subtitle) {
		this.options = new MenuOption[options.length + 1];
		this.options[0] = new MenuOption("Exit Program", () -> {});
		for (int i = 0; i < options.length; i++) {
			this.options[i + 1] = options[i];
		}
		this.fullPrompt = new FullPrompt(
				this.options, name, DEFAULT_PROMPT, leaveNameCase, subtitle);
	}
	
	public void run() {
		fullPrompt.print();
		int selectionNumber = getInput(options.length);
		options[selectionNumber].select();
	}
	
	public static void run(Menu menu) {
		menu.run();
	}
	
	private static int getInput(int numOptions) {
		int selectedNumber = -1;
		int numTries = 0;
		while (selectedNumber < 0 || selectedNumber >= numOptions) {
			if (numTries++ > 0) {
				System.out.println(Colors.RED.colorize(
						"Unable to process input. Please enter a number between 0 and "
						+ (numOptions - 1) + ":"));
				
			}
			System.out.print(" > ");
			try {
				Colors.CYAN.startConsoleColor();
				selectedNumber = InputScanner.getIntInput();
			} catch(Exception e) {
				Colors.resetConsoleColor();
				continue;
			}
		}
		return selectedNumber;
	}
	
}
