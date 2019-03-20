package com.Empasgnmnt;

import java.util.SortedMap;
import java.util.function.Predicate;

public class Valid {
	 
	 public interface ValidateEmployee
	   {
		   public boolean check(int age, int salary, Employee emp);
	   }
   
   
/*boolean validate(ValidateEmployee validator, int age, int salary, Employee emp)
{
	return validator.check(age,salary, emp);
}*/
	 

	 boolean validate(Predicate<Employee> validator, Employee emp)
	 {
		 boolean ret=true;
		if(!validator.test(emp))
		{
			System.out.println("Oops");
			ret=false;
		}
		return ret;
		//return validator.test(emp);
	 }

}
//obj.validate((e)-> {if(e.age<22) {System.out.println("Oops");}}, age, emp.salary, emp);