package com.java.training;
import java.util.*;
public class Employee <T> extends Person implements Appraisable, Comparable{
	//,Comparable, Comparator{
	//Person per=new Employee();
	public int id;
	public  int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int age;
	private String dept;
	private T salary;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public T getSalary() {
		return salary;
	}

	public void setSalary(T salary) {
		this.salary = salary;
	}

	public Employee()
	{
		
	}
	
	public Employee(int id, String name, String address, int age, String dept, T salary)
	{
		super(name, address);
		this.id=id;
		this.age=age;
		this.dept=dept;
		this.salary=salary;
	}
	
	public void showEmp()
	{
		//System.out.println(name+"\nid:"+id+"\nage:"+age+"\ndept:"+dept+"\nsalary:"+salary);
		String str=String.format("%5s", name);
		System.out.println(str);
	}
	//
	void updateEmp(int id,int age, String dept, T salary)
	{
		this.id=id;
		this.age=age;
		this.dept=dept;
		this.salary=salary;
	}
	
	public void appraise()
	{
		System.out.println("It is implementation of Appraisable interface");
	}

	public void inheritable() {
		System.out.println("It is implementation of Inheritable interface which is extended by Appraisable inteface");
		
	}
	
	public void sayHello()
	{
		System.out.println("Testing Overridden Child");
	}
  
   public int hashCode()
   {
	   return this.getId() %5;
	}

   public boolean equals(Object obj) {
	   if(obj instanceof Employee )
		   
	   {
		   return this.getId()==((Employee) obj).getId();
	   }
	   return false;
	   
   }
   public String toString()
   {
	   
	return String.valueOf(this.id) + " " + String.valueOf(this.name + " " + String.valueOf(this.getAge()));
   }
   
  // @Override
 	public int compareTo(Object emp) {
		if(emp instanceof Employee)
		{
			return this.name.compareTo(((Employee) emp).name);
		}
		return 0;
   } 
 	public void defaultTest()
 	{
 		System.out.println("Overridden default method from Appraisable inteface");
 	}
 	
 /* public int compare(Object str1, Object str2) 
   { 
	   Object first_Str; 
	   Object second_Str; 
       first_Str = str1; 
       second_Str = str2; 
       return ((Employee) second_Str).compareTo(first_Str); 
   } */

}
