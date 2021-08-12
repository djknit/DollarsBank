package com.cognixia.jump.functionalInterfaces;

import com.cognixia.jump.model.HasRecordId;

@FunctionalInterface
public interface DataRecordInHandler {
	
	public void handleInput(HasRecordId input);
	
}
