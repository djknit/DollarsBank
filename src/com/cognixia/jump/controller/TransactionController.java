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
		account.addTransaction(newDeposit);
		account.getPatron().addTransaction(newDeposit);
		BankDataRepository.addTransaction(newDeposit);
	}
	
	public void withdraw(Account account, DollarAmount amount) {
		Transaction withdrawal = Transaction.createWithdrawal(account, amount);
		try {
			account.getBalance().subtract(amount);
		} catch (Exception e) { // invalid balance. input validation should have guaranteed this not to occur.
			e.printStackTrace();
			return;
		}
		account.addTransaction(withdrawal);
		account.getPatron().addTransaction(withdrawal);
		BankDataRepository.addTransaction(withdrawal);
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
		originAccount.addTransaction(sendingTransfer);
		targetAccount.addTransaction(receivingTransfer);
	}
	
}
