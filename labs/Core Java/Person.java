package com.java.training;

public abstract class Person {
	 String name;
	 String address;
	
	
	public Person()
	{
		System.out.println("This is person class default constructor");
	}
	
	public Person(String name, String address)
	{
		this.name=name;
		this.address=address;
	}
	public void sayHello()
	{
		System.out.println("Testing Overridden Parent");
	}
	
}
