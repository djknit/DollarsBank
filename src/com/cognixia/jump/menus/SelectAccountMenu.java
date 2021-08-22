package com.cognixia.jump.menus;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.model.Patron;

public class SelectAccountMenu extends Menu {

	public SelectAccountMenu() {
		super(getOptions(), "");
	}
	
	private static MenuOption[] getOptions() {
		Patron user = DollarsBankDriver.getCurrentUser();
		MenuOption[] options = {
			
		};
		return options;
	}
	
	@Override
	public void run() {
		
	}
	
}
