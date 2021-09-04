package com.cognixia.jump.controller;

import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.DollarAmount;
import com.cognixia.jump.model.Transaction;
import com.cognixia.jump.repository.BankDataRepository;

public class TransactionController {

	public TransactionController() {
		super();
	}
	
	public void deposit(Account account, DollarAmount amount) {
		Transaction newDeposit = Transaction.createDeposit(account, amount);
		try {
			account.getBalance().add(amount);
		} catch (Exception e) { // invalid balance. shouldn't be possible here.
			e.printStackTrace();
			return;
		}
		addTransaction(newDeposit, account);
	}
	
	public void withdraw(Account account, DollarAmount amount) {
		Transaction withdrawal = Transaction.createWithdrawal(account, amount);
		try {
			account.getBalance().subtract(amount);
		} catch (Exception e) { // invalid balance. input validation should have guaranteed this not to occur.
			e.printStackTrace();
			return;
		}
		addTransaction(withdrawal, account);
	}
	
	public void sendTransfer(Account originAccount, DollarAmount amount, Account targetAccount) {
		Transaction sendingTransfer = Transaction.createSendingTransfer(originAccount, amount, targetAccount);
		Transaction receivingTransfer = Transaction.createReceivingTransfer(targetAccount, amount, originAccount);
		try {
			originAccount.getBalance().subtract(amount);
			targetAccount.getBalance().add(amount);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		addTransaction(sendingTransfer, originAccount);
		addTransaction(receivingTransfer, targetAccount);
	}
	
	private void addTransaction(Transaction transaction, Account account) {
		account.addTransaction(transaction);
		account.getPatron().addTransaction(transaction);
		BankDataRepository.addTransaction(transaction);
	}
	
}
