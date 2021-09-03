package com.cognixia.jump.controller;

import java.util.Optional;

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
	
	public Account findById(long id) {
		// source: https://stackoverflow.com/questions/17526608/how-to-find-an-object-in-an-arraylist-by-property#answer-48839294
		return BankDataRepository.getAccounts()
				.stream()
				.filter(account -> (long) account.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
}
