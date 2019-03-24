package com.example.spring.core;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("employeejavaconfig")
public class EmpJavaConfig {
	@Value(value="1")
	int id;
	@Value(value="John")
	String name;
	LocalDate dob;
	@Value(value="Project Manager")
	String designation;
	@Value(value="100000")
	double  salary;
// @Autowired
    AddrJavaConfig address;
 @Value(value="FrontEnd, BackEnd")
	List skill;
 @Value(value="True")
	boolean fulltime;
	
	public boolean isFulltime() {
		return fulltime;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}

	public EmpJavaConfig()
	{
		
	}
	public EmpJavaConfig(int id, String name, AddrJavaConfig address)
	{
		this.id=id;
		this.name=name;
		this.address=address;
		
	}
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public List getSkill() {
		return skill;
	}
	public void setSkill(List skill) {
		this.skill = skill;
	}
	
	
	public void showEmp()
	{
		System.out.println("Id: "+id);
		System.out.println("Name: "+name);
		System.out.println("Designation: "+designation);
		System.out.println("Salary: "+salary);
		System.out.println("Address: "+address.country+" "+address.city+" "+address.pin);
		System.out.print("Skills: ");
		for (Object skills: skill)
		{
			System.out.print(skills+"\t");
		}
		System.out.println("\nFullTime: "+fulltime);
		
	}
    
	
}

