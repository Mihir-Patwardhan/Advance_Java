package com.pojo;

public class Address {

	private String city,state,countrty;

	public Address() {
		super();
		System.out.println("---default Address---");
	}

	public Address(String city, String state, String countrty) {
		super();
		this.city = city;
		this.state = state;
		this.countrty = countrty;
		System.out.println("---param Address---");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountrty() {
		return countrty;
	}

	public void setCountrty(String countrty) {
		this.countrty = countrty;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", countrty=" + countrty + "]";
	}
	
}
