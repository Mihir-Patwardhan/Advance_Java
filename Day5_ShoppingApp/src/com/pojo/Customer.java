package com.pojo;

public class Customer {
//custid | custname | city  | email          | username | password
	
	private int Cid;
	private String cname,city,email,username,password,role;
	@Override
	public String toString() {
		return "Customer [Cid=" + Cid + ", cname=" + cname + ", city=" + city + ", email=" + email + ", username="
				+ username + ", password=" + password + ", role=" + role + "]";
	}

	public Customer(int cid, String cname, String city, String email, String username, String password, String role) {
		super();
		Cid = cid;
		this.cname = cname;
		this.city = city;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Customer(String cname, String city, String email, String username, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.cname = cname;
		this.city = city;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
}
