package com.example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpBeanMainAutowire {

	public static void main(String[] args) {
     
		ApplicationContext context =new ClassPathXmlApplicationContext("bean-emp-config.xml"); //creating container
		
		EmployeeBean emp=(EmployeeBean)context.getBean("employee");
		System.out.println("The employee details ::::::");
		emp.showEmp();

	}

}
