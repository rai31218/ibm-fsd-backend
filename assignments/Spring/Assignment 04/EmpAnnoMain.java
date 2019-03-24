package com.example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpAnnoMain {

	public static void main(String[] args) {
   //For Annotation with componentscan   
		ApplicationContext context =new AnnotationConfigApplicationContext(AnnoConfig.class); //creating container
		
		Employee emp=(Employee)context.getBean("employee");
		System.out.println("hi Annotation Configuration");
		emp.showEmp();
		

	}

}
