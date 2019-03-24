package com.example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {

	public static void main(String[] args) {
		//For Java Configuration	
      
		 ApplicationContext context1 =new AnnotationConfigApplicationContext(JavaConfig.class); //creating container
			EmpJavaConfig emp1=(EmpJavaConfig)context1.getBean("employeejavaconfig");
			System.out.println("hi Java Configuaration");
			emp1.showEmp();
	}

}



