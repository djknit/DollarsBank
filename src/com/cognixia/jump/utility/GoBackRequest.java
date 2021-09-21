package com.cognixia.jump.utility;

import com.cognixia.jump.menu.Menu;

public class GoBackRequest extends Throwable {

	private static final long serialVersionUID = 1L;
	
	public GoBackRequest() {
		super();
	}
	
	public static void execute(Menu previousMenu) {
		previousMenu.run();
	}

}
