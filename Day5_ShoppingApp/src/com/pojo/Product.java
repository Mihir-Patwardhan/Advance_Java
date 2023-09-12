package com.pojo;

public class Product {
	private int Pid;
	private String pname,description;
	private int price,quantity;
	@Override
	public String toString() {
		return "Product [Pid=" + Pid + ", pname=" + pname + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	public Product(int pid, String pname, String description, int price, int quantity) {
		super();
		this.Pid = pid;
		this.pname = pname;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
}
