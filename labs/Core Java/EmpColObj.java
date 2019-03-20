package com.java.training;
import java.util.*;
//import com.java.training.Employee;
public class EmpColObj {

	public static void main(String[] args) {
		
		Employee<String> emps= new Employee<String>(0, "Rudra","Kochi", 46, "Management", "Thirty Thousand");
		emps.showEmp();
		emps.setSalary("Fifty Thousand");
		ArrayList<Employee<String>> employees= new ArrayList<>(); //same <> value will be passed to the constructor
		employees.add((new Employee(10, "Rudra", "Kolkata", 23, "FSD", "Thirty")));
		employees.add(new Employee(11, "Rai", "Bangalore", 23, "FSD", 30000));
		employees.add(new Employee(12,"Pihu", "Kolkata", 23, "L&K", 30000));
		employees.toArray();
		for (Employee<String> emp: employees)
		{
			//System.out.println(emp.getId()+" "+ emp.hashCode());
			emp.showEmp();
			
		}
		
		
		
		System.out.println("After Removing");
		
		employees.remove(2);
		
		for (Object emp: employees)
		{
			System.out.println(emp);
		}
		
		System.out.println("Sorting with treeset");
		//SortedSet countriesTreeSet = new TreeSet();
		SortedSet employeeTree= new TreeSet();
		employeeTree.add((new Employee(10, "Rudra", "Kolkata", 23, "FSD", 30000)));
		employeeTree.add(new Employee(11, "Rai", "Bangalore", 23, "FSD", 30000));
		employeeTree.add(new Employee(12,"Pihu", "Kolkata", 23, "L&K", 30000));
		//employeeTree.add("jghg");
		//System.out.println(employeeTree);
		for (Object empT: employeeTree)
		{
			//if(empT.id==10)
			System.out.println(empT);
			
		}
		
		//Collections.binarySearch(employeeTree, 2);

	}

}
