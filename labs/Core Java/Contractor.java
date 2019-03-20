package com.java.training;

public class Contractor extends Person{
	private int conid;
	private int wage;
	public int getConid() {
		return conid;
	}
	public void setConid(int conid) {
		this.conid = conid;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
		
	public Contractor()
	{
		super();
	}
	
	public Contractor(String name, String address,int conid, int wage)
	{
		super(name, address);
		this.conid=conid;
		this.wage=wage;
	}

	public void showContractor()
	{
		System.out.println(this.name+address+conid+wage);
	}
}


