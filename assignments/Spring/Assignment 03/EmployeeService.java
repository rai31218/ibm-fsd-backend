package com.employee.management;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EmployeeService extends Valid  {
	

	public static void main(String agrs[]) throws SQLException, IOException
	{		
      ApplicationContext context =new ClassPathXmlApplicationContext("empbean-config.xml"); //creating container
   		
		EmployeeServe empserve=(EmployeeServe)context.getBean("employeeserve");
		   EmployeeService serve=new EmployeeService();
		   LocalDate date1 = LocalDate.now();
	    	 boolean n=true;		   
	    	 while(n)
	    	 {	  		 
	    	System.out.println("Please select your choice::: add, fetch, fetchById, update, delete, statistics, exit");
			Scanner c = new Scanner(System.in);
			Scanner in = new Scanner(System.in);
	    	 String choice=c.next();
	    	switch(choice)
	    	{
	    	case "add":
	    	
	    		empserve.add();
	    		break;
	    		
	    	case "fetch":
	    		empserve.fetch();
	    		break;
	    	  	
	    	 case "delete":
	    		 empserve.delete();
	    		 break;
	    		 
	    	 case "update":
	    		 empserve.update();
	    		 break;
	    		 
	    	 case "fetchById":
	    		 empserve.fetchById();
	    		 break;
	    		 
	    	 case "statistics":
	    		 empserve.stats();
	    		 break;
	    		 
	    	 case "exit":
		    		System.out.println("Thank You");
		    		break;
		    		
		    default:
		    	System.out.println("Wrong Choice.. Try again");
		    	break;

	    	   }
	    	 }
	    		
		
	    		
	}

}
