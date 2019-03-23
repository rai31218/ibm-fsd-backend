package com.employee.management;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.*;
// avg sal in each dept

public class Employee implements Comparable,Comparator,java.io.Serializable {
	private static final long serialVersionUID = -7987392421065096694L;
	@Override
	public int compare(Object str1, Object str2) {
		// TODO Auto-generated method stub
		return ((Employee) str1).getName().compareTo(((Employee) str2).getName());	}

	public static int id;
	public static String name;
	public static int age;
	public static int salary;
	public static String dept;
	public LocalDate dob;
	
	
	public Employee()
	{
		
	}
	
	public Employee(int id, String name, int age, int salary, String dept)
	{
		this.id=id;
		this.name=name;
		this.age=age;
		this.salary=salary;
		this.dept=dept;
		//this.dob=dob;
	}
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void showEmp()
	{
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
		System.out.println(salary);
	}
	
	public void updateEmp(String name, int age, int salary, String dept)
	{
		//this.id=id;
		this.name=name;
		this.age=age;
		this.salary=salary;
		this.dept=dept;
	}
	
	public String toString()
	   {
		   
		return String.valueOf(this.id) + " " + String.valueOf(this.name);
	   }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	public int compareTo(Object emp) {
		if(emp instanceof Employee)
		{
			return this.name.compareTo(((Employee) emp).name);
		}
		return 0;
   } 
	

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	public synchronized void exporting() throws IOException
	{
		String rec=this.getName()+" "+getDept()+" "+getAge()+" "+getSalary()+"\n";
		FileWriter fileOut=null;
		try {
			
			System.out.println(rec);
			//in=new Scanner(new PrintWriter(new FileOutputStream("D:\\JDBC\\JDBCTraining")));
		     fileOut = new FileWriter("D:\\JDBC\\JDBCTraining\\EmployeeInput.txt", true);
			fileOut.write(rec);
			System.out.println("File copied successfully");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		finally
		{
			fileOut.flush();
			fileOut.close();
		}
	}
	
	
	
	
	public synchronized void importing() throws IOException
	{
		FileReader fileIn=null;
		try {
			 fileIn = new FileReader("D:\\JDBC\\JDBCTraining\\EmployeeInput.txt");
				int rec;
				String record=null;
			 while((rec=fileIn.read())!=-1)
					 {
				       char re=(char)rec;
				       //System.out.print(re);
				        record=String.valueOf(re);
				        StringTokenizer token = new StringTokenizer(record,"//");
						while (token.hasMoreTokens()) {
							System.out.print(token.nextToken());
					 }
		
		            }	
		}catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		finally
		{
			fileIn.close();
		}
       // System.out.format(" %d  \t  %s  \t  %d  \t  %d  \t  %s \n",((Employee) empl).getId(),((Employee) empl).getName(),
    		//	((Employee) empl).getAge(),((Employee) empl).getSalary(),((Employee) empl).getDept());
		
	}	
}
