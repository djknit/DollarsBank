package com.cognixia.jump.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.cognixia.jump.repository.BankDataRepository;

public class Transaction extends RecordWithId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public enum TransactionTypes {
		DEPOSIT, WITHDRAWAL, SEND_TRANSFER, RECEIVE_TRANSFER
	}

	// Once created, transaction should not change. (Can't go back in time and undo action as money has moved, so new transaction would be needed to fix any mistaken transactions.)
	private final Account account;
	private final DollarAmount amount;
	private final Timestamp timestamp;
	private final Account receivingAccount;
	private final Account sendingAccount;
	private final TransactionTypes type;
	
	private Transaction(Account account, DollarAmount amount, Account receivingAccount,
			Account sendingAccount, TransactionTypes type) {
		super(BankDataRepository.getNextTransactionId());
		this.account = account;
		this.amount = amount;
		this.timestamp = createNowTimestamp();
		this.receivingAccount = receivingAccount;
		this.sendingAccount = sendingAccount;
		this.type = type;
	}
	
	// Factories for each transaction type. Similar to overloaded constructor, but seemed to make more sense for this situation.
	public static Transaction createDeposit(Account account, DollarAmount amount) {
		return new Transaction(account, amount, null, null, TransactionTypes.DEPOSIT);
	}
	public static Transaction createWithdrawal(Account account, DollarAmount amount) {
		return new Transaction(account, amount, null, null, TransactionTypes.WITHDRAWAL);
	}
	public static Transaction createSendingTransfer(
			Account account, DollarAmount amount, Account receivingAccount) {
		return new Transaction(account, amount, receivingAccount, null, TransactionTypes.SEND_TRANSFER);
	}
	public static Transaction createReceivingTransfer(
			Account account, DollarAmount amount, Account sendingAccount) {
		return new Transaction(account, amount, null, sendingAccount, TransactionTypes.RECEIVE_TRANSFER);
	}
	
	public Account getAccount() {
		return account;
	}
	public DollarAmount getAmount() {
		return amount;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public Account getReceivingAccount() {
		return receivingAccount;
	}
	public Account getSendingAccount() {
		return sendingAccount;
	}
	public Account getOtherAccount() {
		if (type == TransactionTypes.SEND_TRANSFER) {
			return receivingAccount;
		} if (type == TransactionTypes.RECEIVE_TRANSFER) {
			return sendingAccount;
		}
		return null;
	}
	public TransactionTypes getType() {
		return type;
	}
	
	@Override
	public String getDisplayId() {
		return "Transaction " + super.getDisplayId();
	}
	
}
