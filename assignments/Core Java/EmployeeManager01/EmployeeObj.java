package com.Empasgnmnt;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.java.training.EmpSerializeEx;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;


class MyException extends Exception
{	}
class UpdateException extends Exception{}

public class EmployeeObj extends Valid  {
	FileInputStream in;
		public static void main(String[] args) {
		int i=1,j=1;
		LocalDate date1 = LocalDate.now();
		Instant d= Instant.now();
		EmployeeObj obj= new EmployeeObj();
		Employee emp=new Employee();
		
		//LocalDate dob=emp.getDob();
		 //Period period = Period.between(dob,date1);
		 //System.out.println("The age is: "+period.getYears()+" " +dob + " "+date1+" "+" "+d+"\n");
	  SortedMap<Integer, Employee> emps = new TreeMap<Integer, Employee>();
	 emps.put(i++, new Employee(j++, "Rudra", 46,45000, "AT"));
	 emps.put(i++, new Employee(j++, "Raima", 30,45000, "IT"));
	 emps.put(i++, new Employee(j++, "Ananda", 26,50000, "IT"));
	 emps.put(i++, new Employee(j++, "Piyali", 32,54000, "EE"));
	 
	 
	 
	 
	 double totsal;
	  totsal=emps.values().stream().map(e->e.getSalary()).reduce(0,(a,b)-> a+b);
	  //System.out.println("Total salary : "+totsal);
	 
	 long count;
	 count=emps.values().stream().filter(e->e.getAge()>30).count();
	// System.out.println("Number of employees with age > 30 : "+count);
	 
	 List counts=new ArrayList();
	 counts=emps.values().stream().filter(e->e.getAge()>30).map(e->e.getId()).collect(Collectors.toList());
	 //System.out.println("Employee id with age>30 : "+counts);	 
	 for(Object de: counts)
	 {
		 //System.out.println("Id wth age>30 : "+de);
	 }
	 
	 Map countmap=new TreeMap();
	//countmap=emps.values().stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting())); // gives only the count
	 countmap=emps.values().stream().collect(Collectors.groupingBy(Employee::getDept));
	 //countmap=emps.values().stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingInt(Employee::getSalary)));
	 //System.out.println(countmap);	 //group by will create a maps
	 // this will automatically call the toString().. so only the id and name is showing
	 
	 counts= emps.values().stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()))
			 .entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
	 //System.out.println("Emps greater  than 1: "+counts);
	 
    countmap=emps.values().stream().sorted(Comparator.comparing(Employee::getDept))
   		 .collect(Collectors.groupingBy(Employee::getDept,TreeMap::new,Collectors.counting()));
	 //System.out.println("Sorting based on Department: "+countmap);
	 
	 counts=emps.values().stream().filter(e->e.getName().startsWith("P")).collect(Collectors.toList());
	 //System.out.println("The names starting with 'P': "+counts); 
	  
	 
	 TreeSet deptemp = new TreeSet(emps.values());
	 for(Object de: deptemp)
	 {
		// System.out.println(de);
	 }
	     try {
	    	 boolean n=true;		   
	    	 while(n)
	    	 {	 
	    		 
	    	System.out.println("Please select your choice::: add, fetch, fetchById, update, delete, statistics, exit");
	    	@SuppressWarnings("resource")
			Scanner c = new Scanner(System.in);
	    	 @SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
	    	 String choice=c.next();
	    	
	    	Collection em;
			//Scanner in = new Scanner(System.in);
	    	switch(choice)
	    	{
	    	case "add":
	    	
	    		System.out.println("--------Enter Your Details-------- ");
				System.out.print("Enter name: ");
				String name = in.next();
				System.out.print("Enter department: ");
				String dept=in.next();
				System.out.print("Enter age: ");
				int age = in.nextInt();
				System.out.print("Enter salary: ");
				int sal= in.nextInt();
				emp.setAge(age);
			//	System.out.println("Get age: "+emp.getAge());
//				System.out.println("Enter DOB");
//				 dob=in.nextInt();
//				System.out.println(dob);				
				/*boolean val=obj.validate(new ValidateEmployee()
				   {
			        public boolean check(int age,int salary, Employee emps)
			        {
			        	return (emps.getAge()>20 && emps.salary>15000);
			        }
				   }, emp.age, emp.salary, emp);*/
				//System.out.println(val);
				boolean val1=obj.validate((e)->e.getAge()>22, emp);
     // the check method parameters are
	//coming from the validate method parameter only
     System.out.println(val1);
				//obj.validate((e)->{if(age<22) {System.out.println("Oops");}}, age, emp.salary, emp);			
	
		        if(val1){
		        	emps.put(i++, new Employee(j++, name, age, sal, dept));
		        	System.out.println("Data entered successfully");
		        } 
		        
		        try {
		        	
					FileOutputStream fileOut = new FileOutputStream("C:\\test\\employee.txt");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject((Object)emps);
					out.close();
					fileOut.close();
		        	
				}catch (IOException k) {
					System.out.println(k);
					k.printStackTrace();
				}
		        System.out.printf("Serialized data is saved in C:\\test\\employee.txt");
		        break;
		                
	    	case "fetch" :
	    		Callable<Boolean> call= new Callable<Boolean>() {
	    			@Override
					public Boolean call() throws Exception {
						// TODO Auto-generated method stub
						emp.importing();
						return true;
					}
	    		};
	    		
	    		ExecutorService ex = Executors.newFixedThreadPool(1);
	    		Future<Boolean> f = ex.submit(call);
	    		
	    		break;
	    		
	    	case "delete":
	    		System.out.print("Enter id to delete: ");
	    		Scanner inn = new Scanner(System.in);
				int delid=inn.nextInt();
				int t1=0;
	    		for(Object e: emps.values())
	    		{
	    			if(((Employee) e).getId()==delid)
			        {
	    				t1++;
	    				
			        }	
	    		}
	    		if(t1==1)	    			
	    		{
	    		delEmp(emps,delid);
	    		}
	    		else
	    		{
	    			throw new UpdateException();
	    		}
	    		
	    		System.out.println("Employee details deleted successfully");
	    		break;
	    		
	    	case "update":
	    		//SortedMap<Integer, Employee> e= emps;
	    		//Object ee=(Object)e;
	    		System.out.println("Please give the employee id to be updated");
	    		int id=in.nextInt();
	    		int t=0;
	    		for(Object e: emps.values())
	    		{
	    			if(((Employee) e).getId()==id)
			        {
	    				t++;
	    				
			        }	
	    		}
	    		if(t==1)	    			
	    		{
	    		System.out.print("Enter name: ");
				String uname = in.next();
				System.out.print("Enter age: ");
				int uage = in.nextInt();
				System.out.print("Enter salary: ");
				int usal= in.nextInt();
				System.out.println("Enter department: ");
				String udept=in.next();
				//System.out.format("Name \t Age \t Designation \n");
				//System.out.format("%s \t  %d  \t", name, age);
				//in.close();
		        if(uage<=22)
		        {
				throw new MyException();
		        }	 
		        else
		        {
		        	upEmp(emps ,id, uname,uage,usal,udept);
		        	System.out.println("Data updated successfully");
		        }  
		        
	    		}
	    		
	    		else
	    		{
	    			throw new UpdateException();
	    		}
		        break;
		        
	    	case "fetchById":
	    		System.out.print("Enter id to fetch: ");
	    		//Scanner inn = new Scanner(System.in);
				int fetchid=in.nextInt();
				int t2=0;
	    		for(Object e: emps.values())
	    		{
	    			if(((Employee) e).getId()==fetchid)
			        {
	    				t2++;
	    				
			        }	
	    		}
	    		if(t2==1)	    			
	    		{
	    			fetchEmpById(emps,fetchid);
	    		}
	    		else
	    		{
	    			throw new UpdateException();
	    		}
	    		//fetchEmpById(emps,fetchid);
	    		//System.out.println("Employee details:::");
	    		break;
		    
	    	case "statistics":
	    		stats(emps);
	    		break;
		        
	    	case "exit":
	    		System.out.println("Thank You");
	    		break;
	    	
	        default:
	        	System.out.println("Wrong choice");
	    		
		        			    		
	    	}// end of switch case
	    	//in.close();
		    //System.out.println("Thank you");
		      
	    	 }// end of while loop	    	 
	      
	}catch(MyException e)	{
	    	 System.out.println("Wrong Data given");
	    	 }
	     
	 catch (UpdateException up)
     {
		 System.out.println("No matching id");
	     }
}
	
	
	 static void displayAll(Collection<Employee> col)
		{
		 System.out.format("\n Id  \t  Name  \t  Age  \t  Salary  \t  Department \n");
			for(Object emp: col) {
				
			  System.out.format(" %d  \t  %s  \t  %d  \t  %d  \t  %s \n",((Employee) emp).getId(),((Employee) emp).getName(),
			((Employee) emp).getAge(),((Employee) emp).getSalary(),((Employee) emp).getDept());
			}
			System.out.println();
	}
	 
	static void delEmp(SortedMap<Integer, Employee> col, int id)
	{
		col.remove(id);
		System.out.println("deleted");
		System.out.format("\n Id  \t  Name  \t  Age  \t  Salary  \t  Department \n");
		for(Object emp: col.values()) {
			
		  System.out.format(" %d  \t  %s  \t  %d  \t  %d  \t  %s \n",((Employee) emp).getId(),((Employee) emp).getName(),
				  ((Employee) emp).getAge(),((Employee) emp).getSalary(),((Employee) emp).getDept());
		}
		System.out.println();
	}
	
	static void fetchEmpById(SortedMap<Integer, Employee> col, int id)
	{
		
		System.out.format("\n Id  \t  Name \t   Age  \t  Salary \n");
		for(Object emp: col.values()) {
			
			if(((Employee) emp).getId()==id)
			{
		  System.out.format("%d  \t  %s  \t   %d  \t   %d  \t\n",((Employee) emp).getId(),((Employee) emp).getName(),((Employee) emp).getAge(),((Employee) emp).getSalary());
			}
		}
		System.out.println();
	}
		
	static void upEmp(SortedMap<Integer, Employee> emp,int id, String name, int age, int salary, String dept)
	{
		for(Object col:emp.values())
		{
			if(id==((Employee) col).getId())
			{
				((Employee) col).updateEmp(name, age, salary,dept);
			}
		}
	} //upEmp ends
	
	static void displayMapEntries(Set<Entry<Integer, Employee>> set) {
		Iterator<Entry<Integer, Employee>> itr = set.iterator();
		System.out.println();
		while (itr.hasNext()) {
			Map.Entry entry = (Map.Entry)itr.next();
			System.out.println(entry.getKey() + " " + entry.getValue() + " ");

		}

		System.out.println();
  }
	
	static void stats(SortedMap<Integer, Employee> emp)
	{
		int age=0;
		int count=0;
		System.out.println("The employees with age greater than 30 are:\n ");
		for(Object col:emp.values())
		{
			
			if(((Employee) col).getAge()>30)
			{
				
				System.out.println(col);
			}
		}
		
		System.out.println("The employee id with age greater than 30 are:\n ");
		//Collection<Employee> employees = emp.values();
		for(Employee col:emp.values())
		{
			
			if(col.getAge()>30)
			{
				System.out.println(((Employee) col).getId()+"\n");
			}
		}	
		
		System.out.println("The employees in IT Department:\n ");	
		for(Employee col:emp.values())
		{	
			
			if(col.getDept()=="IT")
			{
				
				System.out.println(col+"\n");
			}
		}
		
		
		System.out.println("The average age of employees in IT Department:\n ");		
		for(Object col:emp.values())
		{
			if(((Employee) col).getDept()=="IT")
			{
				count++;
				age=(age+((Employee) col).getAge());		
			}
			
		}	
		System.out.println(count);
		age=age/count;
		System.out.println(age+"\n");
			
		for(Object col:emp.values())
		{
			boolean matches = Pattern.matches("R.*", ((Employee) col).getName());
			if(matches==true)
			{
				System.out.println(((Employee) col).getName());
			}		
		}
		
/*static void displaydeptEntries(Set<Entry<Integer, Employee>> set) {
		Iterator itr = set.iterator();
		System.out.println();
		while (itr.hasNext()) {
			Map.Entry entry = (Map.Entry)itr.next();
			System.out.println("The average age of employees in IT Department:\n ");		
			System.out.println(entry.getKey() + " " + entry.getValue() + " ");
			if(entry.getKey()=="IT")
			{
			  System.out.println(entry.getValue()+ "\n");
			}
		}

		System.out.println();
  }*/		
	}

}

