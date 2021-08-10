package com.cognixia.jump.model;

import java.sql.Date;

public class Account {

	private Long accountId;
	private Long userId;
	private Date dateOpened;
	private String nickname;
	private long balanceInCents;
	
	public Account(Long accountId, Long userId, Date dateOpened, String nickname, long balanceInCents) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.dateOpened = dateOpened;
		this.nickname = nickname;
		this.balanceInCents = balanceInCents;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public long getBalanceInCents() {
		return balanceInCents;
	}

	public void setBalanceInCents(long balanceInCents) {
		this.balanceInCents = balanceInCents;
	}
	
	
	
}
