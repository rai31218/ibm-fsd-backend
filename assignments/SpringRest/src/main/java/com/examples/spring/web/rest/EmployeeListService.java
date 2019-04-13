package com.examples.spring.web.rest;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class EmployeeListService {
	
private static Map employees = new LinkedHashMap();
	

	public void add(Employee employee)
	{
					
		employees.put(employee.getId(), employee);
	}
	
	
	
	public List<Employee> list()
	{
		return new ArrayList<Employee>(employees.values());
	}	
	
	public Employee get(int id)
	{
		return  (Employee) employees.get(id);
	}
}
