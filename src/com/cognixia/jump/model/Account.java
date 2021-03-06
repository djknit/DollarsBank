package com.cognixia.jump.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.DollarsBankDriver;
import com.cognixia.jump.repository.BankDataRepository;

public class Account extends RecordWithId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Patron patron;
	private Date dateOpened;
	private String nickname;
	private DollarAmount balance;
	private List<Transaction> transactions;
	
	public Account(Patron patron, String nickname) {
		this(patron, nickname, 0l);
	}
	public Account(Patron patron, String nickname, long balanceInCents) {
		super(BankDataRepository.getNextAccountId());
		this.patron = patron;
		this.dateOpened = new Date(createNowTimestamp().getTime());
		this.nickname = nickname;
		this.balance = new DollarAmount(balanceInCents);
		this.transactions = new ArrayList<Transaction>();
	}

	public Patron getPatron() {
		return patron;
	}
	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	public Date getDateOpened() {
		return dateOpened;
	}
	// no setter provided because this value is not expected to change

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public DollarAmount getBalance() {
		return balance;
	}
	// no setter provided because DollarAmount instance should be updated via its methods for updating the amount instead of manually creating new DollarAmount instance for new balance

	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	// no setter or remove method should be needed
	
	@Override
	public String getDisplayId() {
		return "Account " + super.getDisplayId();
	}
	
	@Override
	public String toString() {
		return getDisplayId() + (
				patron == DollarsBankDriver.getCurrentUser() ?
				", \"" + nickname + "\"" :
				" -- (" + patron.getDisplayId() + ", \"" + patron.getName() + "\")");
	}
	
}
