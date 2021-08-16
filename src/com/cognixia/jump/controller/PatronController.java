package com.cognixia.jump.controller;

import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.repository.BankDataRepository;

public class PatronController {
	
	public PatronController() {
		super();
	}
	
	public void createPatron(Patron newPatron) {
		BankDataRepository.addPatron(newPatron);
	}
	
	public void deletePatron(Patron patron) {
		BankDataRepository.removePatron(patron);
		for (Account account : patron.getAccounts()) {
			BankDataRepository.removeAccount(account);
		}
	}
	
}
