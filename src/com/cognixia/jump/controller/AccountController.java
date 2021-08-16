package com.cognixia.jump.controller;

import com.cognixia.jump.model.Account;
import com.cognixia.jump.repository.BankDataRepository;

public class AccountController {

	public AccountController() {
		super();
	}
	
	public void createAccount(Account account) {
		BankDataRepository.addAccount(account);
		account.getPatron().addAccount(account);
		BankDataRepository.save();
	}
	
	public void removeAccount(Account account) {
		account.getPatron().removeAccount(account);
		BankDataRepository.removeAccount(account);
	}
	
}
