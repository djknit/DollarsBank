package com.cognixia.jump.form;

import com.cognixia.jump.exception.UserInputException;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.Executor;
import com.cognixia.jump.utility.GoBackRequest;

public class FormInput {

	private String prompt;
	private String helpText;
	private InputGetter getInput;
	private Executor validateInput;
	
	FormInput(String prompt, String helpText, InputGetter getInput, Executor validateInput) {
		this.prompt = prompt;
		this.helpText = helpText;
		this.getInput = getInput;
		this.validateInput = validateInput;
	}
	FormInput(String prompt, InputGetter getInput, Executor validateInput) {
		this(prompt, null, getInput, validateInput);
	}
	FormInput(String prompt, InputGetter getInput) {
		this(prompt, getInput, null);
	}
	
	public void run() throws GoBackRequest {
		run(true);
	}
	
	public void run(boolean shouldPrintPrompt) throws GoBackRequest {
		if (shouldPrintPrompt) printPrompt();
		try {
			System.out.print(" > ");
			getInput.execute();
			if (validateInput != null) validateInput.execute();
		} catch (UserInputException e) {
			System.out.println(Colors.RED.colorize(e.getMessage()));
			run(false);
		} catch (Exception e) {
			System.out.println(Colors.RED.colorize(
					"An unexpected problem has occured.\n" +
					"\nPlease restart the program and try again.\n"));
		}
	}
	
	private void printPrompt() {
		String fullPrompt = Colors.WHITE.colorize(prompt);
		if (helpText != null) fullPrompt +=
				Colors.YELLOW.colorize(" (" + helpText + ")");
		fullPrompt +=
				Colors.YELLOW.colorize(" (Or enter ") +
				Colors.CYAN.colorize("<") +
				Colors.YELLOW.colorize(" or ") +
				Colors.CYAN.colorize("-b") +
				Colors.YELLOW.colorize(" to go back.)");
		System.out.println("\n" + fullPrompt);
		
	}
	
}
