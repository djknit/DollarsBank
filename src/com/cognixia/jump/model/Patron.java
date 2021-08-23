package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.repository.BankDataRepository;

public class Patron extends RecordWithId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name;
	private String address;
	private long phoneNumber;
	private List<Account> accounts;
	
	public Patron(String username, String password, String name, String address, long phoneNumber) {
		super(BankDataRepository.getNextPatronId());
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.accounts = new ArrayList<Account>();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	public void removeAccount(Account account) {
		this.accounts.remove(account);
	}
	
	@Override
	public String getDisplayId() {
		return "Patron " + super.getDisplayId();
	}
	
}
