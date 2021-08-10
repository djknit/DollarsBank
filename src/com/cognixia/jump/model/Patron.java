package com.cognixia.jump.model;

public class Patron {

	private String username;
	private String password;
	private Long userId;
	private String name;
	private String address;
	private long phoneNumber;
	
	public Patron() {
		this(null, null, -1L, null, null, -1L);
	}
	public Patron(String username, String password, Long userId, String name, String address, long phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	
	
}
