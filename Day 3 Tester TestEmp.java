package com.tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.Employee;
import com.pojo.Student;

public class TstEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Employee emp=new Employee();
//		emp=new Employee(11, "aaa", "pune", 90000);
//		System.out.println(emp);

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("MyBean.cfg.xml");

		System.out.println("BeanFactory loaded.....");

		Employee emp1 = (Employee) ctx.getBean("empObj1");

		System.out.println(emp1);

		Employee emp2 = (Employee) ctx.getBean("empObj2");

		System.out.println(emp2);

		Employee emp3 = (Employee) ctx.getBean("empObj3");

		System.out.println(emp3);

		Student std1 = (Student) ctx.getBean("stdObj2");
		System.out.println(std1);
	}

}
