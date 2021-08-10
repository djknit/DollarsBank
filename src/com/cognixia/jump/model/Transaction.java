package com.cognixia.jump.model;

import java.sql.Timestamp;

public class Transaction {
	
	public enum TransactionType {
		DEPOSIT, WITHDRAWAL, SEND_TRANSFER, RECEIVE_TRANSFER
	}

	private Long transactionId;
	private Long accountId;
	private long amountInCents;
	private Timestamp timestamp;
	private Long reveivingAccountId;
	private Long sendingAccountId;
	private TransactionType type;
	
	public Transaction() {
		this(-1L, -1L, -1l, null, -1L, -1L, null);
	}
	public Transaction(Long transactionId, Long accountId, long amountInCents, Timestamp timestamp,
			Long reveivingAccountId, Long sendingAccountId, TransactionType type) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.amountInCents = amountInCents;
		this.timestamp = timestamp;
		this.reveivingAccountId = reveivingAccountId;
		this.sendingAccountId = sendingAccountId;
		this.type = type;
	}
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public long getAmountInCents() {
		return amountInCents;
	}
	public void setAmountInCents(long amountInCents) {
		this.amountInCents = amountInCents;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public Long getReveivingAccountId() {
		return reveivingAccountId;
	}
	public void setReveivingAccountId(Long reveivingAccountId) {
		this.reveivingAccountId = reveivingAccountId;
	}
	public Long getSendingAccountId() {
		return sendingAccountId;
	}
	public void setSendingAccountId(Long sendingAccountId) {
		this.sendingAccountId = sendingAccountId;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	
}
