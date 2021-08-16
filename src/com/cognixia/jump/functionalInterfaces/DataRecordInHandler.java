package com.cognixia.jump.functionalInterfaces;

import com.cognixia.jump.model.RecordWithId;

@FunctionalInterface
public interface DataRecordInHandler {
	
	public void handleInput(RecordWithId input);
	
}
