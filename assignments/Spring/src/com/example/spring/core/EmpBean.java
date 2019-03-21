package com.example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpBean {

	public static void main(String[] args) {
     
		ApplicationContext context =new ClassPathXmlApplicationContext("bean-config.xml"); //creating container
		
		Employee emp=(Employee)context.getBean("employee");
		System.out.println("hi");
		emp.showEmp();

	}

}
