package com.cognixia.jump.functionalInterfaces;

import com.cognixia.jump.model.DollarAmount;

@FunctionalInterface
public interface DollarAmountInHandler {

	public void handleInput(DollarAmount input);
	
}
