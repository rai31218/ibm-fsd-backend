package com.java.training;

public class EmpSerializeEx implements java.io.Serializable{
	private static final long serialVersionUID = -7987392421065096694L;
		public String name;
		public String address;
		public transient int SSN; // it will give 0 in DeserializaEx
		public int id;
		
		public EmpSerializeEx()
		{
			
		}
	
}
