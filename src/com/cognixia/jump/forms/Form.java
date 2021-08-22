package com.cognixia.jump.forms;

import com.cognixia.jump.utility.Display;

abstract public class Form {

	private String name;
	private FormInput[] inputs;
 	
	Form(String name, FormInput[] inputs) {
		this(name, inputs, false);
	}
	Form(String name, FormInput[] inputs, boolean leaveCase) {
		this.name = leaveCase ? name : name.toUpperCase();
		this.inputs = inputs;
	}
	
	abstract void submit();
	
	public void run() {
		Display.printDivider();
		System.out.println(name + ":");
		for (FormInput formInput : inputs) {
			formInput.run();
		}
	}
}
