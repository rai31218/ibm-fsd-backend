package com.JDBCEmpasgnmnt;

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

public class EmployeeService extends Valid  {
	
	public static void main(String agrs[]) throws SQLException, IOException
	{		
		   Employee emp=new Employee();
		   EmployeeDao dao=new EmployeeDao();
		   EmployeeService serve=new EmployeeService();
		   LocalDate date1 = LocalDate.now();
			 //System.out.println("The age is: "+period.getYears()+" " +dob + " "+date1+" "+" "+"\n");
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
	    	
	    		System.out.println("--------Enter Your Details-------- ");
				System.out.print("Enter name: ");
				String name = in.next();
				System.out.print("Enter department: ");
				String dept=in.next();
				System.out.print("Enter date of birth in YYYY-MM-DD: ");
				String dbi=in.next();
				//boolean val1=serve.validateDate((e)->e==LocalDate.parse(DOB), db);
				boolean match=Pattern.matches("(\\d{4})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])", dbi);
				if(match)
				{
				LocalDate db = LocalDate.parse(dbi);
				emp.setDob(db);
				}
				else
				{
					System.out.println("Not Matched Pattern");
					break;
				}
				System.out.print("Enter salary: ");
				int sal= in.nextInt();		
				LocalDate dob=emp.getDob();
				 Period period = Period.between(dob,date1);
				 emp.setAge(period.getYears());
				boolean val=serve.validateage((e)->e.getAge()>22, emp);
				String year=String.valueOf((char)period.getYears());
				String month=String.valueOf((char)period.getMonths());
				String days=String.valueOf((char)period.getDays());
				String DOB=year+"-"+month+"-"+days;
				//(char)period.getMonths()-(char)period.getDays();
				//boolean val1=serve.validateDate((e)->e==LocalDate.parse(DOB), db);
				if(val)
				{
				emp.setAge(period.getYears());
				emp.setDept(dept);
				emp.setName(name);
				emp.setSalary(sal);
				dao.inserted();
				
				Callable<Boolean> call= new Callable<Boolean>() {
	    			@Override
					public Boolean call() throws Exception {
						// TODO Auto-generated method stub
						emp.exporting();
						return true;
					}
	    		};
	    		
	    		ExecutorService ex = Executors.newFixedThreadPool(1);
	    		Future<Boolean> f = ex.submit(call);
	    		ex.shutdown();
				}	
				break;
				
	    	case "fetch":
	    		dao.fetched();
	    		System.out.println("---------------");
	    		Callable<Boolean> call1= new Callable<Boolean>() {
	    			@Override
					public Boolean call() throws Exception {
						System.out.println("From the file");
						emp.importing();
						return true;
					}
	    		};
	    		
	    		ExecutorService ex = Executors.newFixedThreadPool(1);
	    		Future<Boolean> f = ex.submit(call1);
	    		ex.shutdown();
	    		break;
	    		
	    	case "delete": //have to do it from db
	    		System.out.println("Enter the id to be deleted: ");
	    		int id=in.nextInt();
	    		emp.setId(id);
	    		dao.deleted(id);
	    		break;
	    		
	    	case "update": // with any fiels???
	    		System.out.println("Enter the id to be updated: ");
	    		int idt=in.nextInt();
	    		emp.setId(idt);
	    		System.out.println("Enter the salary: ");
	    		int salary=in.nextInt();
	    		emp.setSalary(salary);
	    		dao.updated(idt);
	    		break;
	    		
	    	case "statistics":
	    		dao.stats();
	    		break;
	    		
	    	case "fetchById":
	    		System.out.println("Enter the id to be fetched: ");
	    		int fid=in.nextInt();
	    		emp.setId(fid);
	    		dao.fetchId(fid);
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
