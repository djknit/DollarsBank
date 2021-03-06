package com.cognixia.jump.menu;

import com.cognixia.jump.utility.Executor;

class MenuOption {
	
	private String description;
	private Executor executor;
	
	MenuOption(String description, Executor executor) {
		this.description = description;
		this.executor = executor;
	}
	
	String getDescription() {
		return description;
	}
	
	void select() {
		try {
			executor.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
