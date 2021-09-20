package com.cognixia.jump.form;

import com.cognixia.jump.utility.GoBackRequest;

@FunctionalInterface
public interface InputGetter {
	
	public void execute() throws Exception, GoBackRequest;

}
