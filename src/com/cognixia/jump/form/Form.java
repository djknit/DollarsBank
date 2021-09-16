package com.cognixia.jump.form;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.menu.LandingMenu;
import com.cognixia.jump.menu.MainMenu;
import com.cognixia.jump.menu.Menu;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.utility.display.Display;

abstract public class Form {

	private Menu previousMenu;
	private String name;
	private FormInput[] inputs;
 	
	Form(String name, FormInput[] inputs) {
		this(name, inputs, false);
	}
	Form(String name, FormInput[] inputs, boolean leaveCase) {
		this(getDefaultPreviousMenu(), name, inputs, leaveCase);
	}
	Form(Menu previousMenu, String name, FormInput[] inputs) {
		this(previousMenu, name, inputs, false);
	}
	Form(Menu previousMenu, String name, FormInput[] inputs, boolean leaveCase) {
		this.name = leaveCase ? name : name.toUpperCase();
		this.inputs = inputs;
		this.previousMenu = previousMenu;
	}
	
	private static Menu getDefaultPreviousMenu() {
		Patron currentUser = DollarsBankDriver.getCurrentUser();
		return currentUser == null ?
				new LandingMenu() :
				new MainMenu(currentUser);
	}
	
	abstract void submit();
	
	public void run() {
		Display.printDivider();
		System.out.println(name + ":");
		for (FormInput formInput : inputs) {
			formInput.run();
		}
		this.submit();
	}
}
