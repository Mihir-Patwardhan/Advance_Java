package com.pojo;

public class Details {

	private int actid;
	private String name;
	private double balance;
	private String username;
	private String password;
	
	public Details(int actid, String name, double balance, String username, String password) {
		super();
		this.actid = actid;
		this.name = name;
		this.balance = balance;
		this.username = username;
		this.password = password;
	}
	
	public int getActid() {
		return actid;
	}
	public void setActid(int actid) {
		this.actid = actid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
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
	@Override
	public String toString() {
		return "Details [actid=" + actid + ", name=" + name + ", balance=" + balance + ", username=" + username
				+ ", password=" + password + "]";
	}

	
}
