package com.JDBCEmpasgnmnt;

import java.time.LocalDate;
import java.util.SortedMap;
import java.util.function.Predicate;

public class Valid {
	
	public interface DateCheck
	{
		public boolean check(LocalDate dob);
	}
	
	
	
	 boolean validateage(Predicate<Employee> validator, Employee emp)
	 {
		 boolean ret=true;
		if(!validator.test(emp))
		{
			System.out.println("Age must be greater than 22");
			ret=false;
		}
		return ret;
		
	 }
	 
	 boolean validateDate(DateCheck validator, LocalDate DOB)
	 {
		 boolean ret=true;
		if(!validator.check(DOB))
		{
			System.out.println("Date is not in pattern");
			ret=false;
		}
		return ret;
		
	 }

}
