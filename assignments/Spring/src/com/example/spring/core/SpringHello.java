package com.example.spring.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.example.spring.core.Greetings;

public class SpringHello {

	public static void main(String args[])
	{
		// Step 1: Creating IOC container
		ApplicationContext context =new ClassPathXmlApplicationContext("bean-config.xml"); //creating container
		
		System.out.println(context.containsBean("greetings1"));
		//Step 2: Access greeting bean
		Greetings greetings=(Greetings)context.getBean("greeting");
		
		//Step3: Print the message
		System.out.println(greetings.getMessage());
		
		
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("bean-config.xml"));
		// Retrieving the bean from container
         Greetings beanfactobj = (Greetings) container.getBean("beanfactgreetings");
         System.out.println(beanfactobj.getMessage());
         
         
         BeanFactory containerfile = new XmlBeanFactory(new FileSystemResource("src/bean-config.xml"));
         Greetings filebeanfact=(Greetings) containerfile.getBean("beanfactgreetings");
         filebeanfact.setMessage("FileSystem beanfact");
         System.out.println(filebeanfact.getMessage());

         //context.close();
      
	}
}
