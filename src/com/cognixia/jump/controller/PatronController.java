package com.cognixia.jump.controller;

import com.cognixia.jump.repository.BankDataRepository;

public class PatronController {
	
	BankDataRepository repo;
	
	public PatronController() {
		super();
		this.repo = BankDataRepository.getInstance();
		
	}
	
	public void createPatron() {
		
	}
	
	public void deletePatron() {
		
	}
	
}
