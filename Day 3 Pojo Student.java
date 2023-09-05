package com.pojo;

public class Student {

	
	private int rollno;
	private String name;
	
	private Address addr;

	public Student() {
		super();
		System.out.println("---default Student---");
	}

	public Student(int rollno, String name, Address addr) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.addr = addr;
		System.out.println("---Para Student---");
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", addr=" + addr + "]";
	}
	
	
	
	
}
