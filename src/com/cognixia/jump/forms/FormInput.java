package com.cognixia.jump.forms;

import com.cognixia.jump.exception.UserInputException;
import com.cognixia.jump.functionalInterfaces.Executor;

public class FormInput {

	private String prompt;
	private String helpText;
	private Executor getInput;
	private Executor validateInput;
	
	FormInput(String prompt, String helpText, Executor getInput, Executor validateInput) {
		this.prompt = prompt;
		this.helpText = helpText;
		this.getInput = getInput;
		this.validateInput = validateInput;
	}
	FormInput(String prompt, Executor getInput, Executor validateInput) {
		this(prompt, null, getInput, validateInput);
	}
	FormInput(String prompt, Executor getInput) {
		this(prompt, getInput, null);
	}
	
	public void run() {
		run(true);
	}
	
	public void run(boolean shouldPrintPrompt) {
		if (shouldPrintPrompt) printPrompt();
		try {
			getInput.execute();
			validateInput.execute();
		} catch (UserInputException e) {
			System.out.println(e.getMessage());
			run(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printPrompt() {
		String fullPrompt = prompt;
		if (helpText != null) fullPrompt += " (" + helpText + ")";
		System.out.println(fullPrompt);
	}
	
}
