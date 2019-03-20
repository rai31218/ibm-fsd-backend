package com.java.training;

public class EmpManager {
	public String name;
	public int salary;
	public int id;
	
	public EmpManager()
	{
		this.name="";
		this.salary=0;
	}
	public EmpManager(int id,String name, int salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
		
	}
	
	public void showEmp()
	{
		System.out.println(id+ " "+name+ " "+ salary);
	}
	
	public void updateEmp(int id, String name, int salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
		//System.out.println(id+ " "+name + " "+salary);
	}

}
