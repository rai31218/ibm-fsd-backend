package com.Empasgnmnt;
import java.io.FileInputStream;
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

	public int id;
	public String name;
	public int age;
	public int salary;
	public String dept;
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
	
	
	
	
	
	//Comparator EMPLOYEE_SORT_BY_NAME = new Comparator() {
	
	/*public int compareTo(Object emp) {
		if(emp instanceof Employee)
		{
			return this.name.compareTo(((Employee) emp).name);
		}
		return 0;
   } //
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return ((Employee) o1).getName().compareTo(((Employee) o2).getName());
	}
}; */
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public synchronized void importing()
	{
		Object eme= null;
		try {
		FileInputStream fileIn = new FileInputStream("C:\\test\\employee.txt");
        ObjectInputStream oin = new ObjectInputStream(fileIn);
        eme = oin.readObject();
        oin.close();
        fileIn.close();
		}catch (IOException a) {
	         a.printStackTrace();
	         return;
	      } catch (ClassNotFoundException b) {
	         System.out.println("Employee class not found");
	         b.printStackTrace();
	         return;
	      }
		for(Employee empl:((SortedMap<Integer, Employee>) eme).values())
		{
        System.out.format(" %d  \t  %s  \t  %d  \t  %d  \t  %s \n",((Employee) empl).getId(),((Employee) empl).getName(),
    			((Employee) empl).getAge(),((Employee) empl).getSalary(),((Employee) empl).getDept());
		}
	}


	

	
}
