package com.pojo;

public class Employee {
private int empid;
private String name,city;
private double salary;
public Employee() {
	super();
	empid=10;
	name="Ram";
	city="Pune";
	salary=20000;
			
	System.out.println("---default constr emp----");
}
public Employee(int empid, String name, String city, double salary) {
	super();
	this.empid = empid;
	this.name = name;
	this.city = city;
	this.salary = salary;
	System.out.println("---parameter constr emp----");
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", name=" + name + ", city=" + city + ", salary=" + salary + "]";
}


}
