package com.examples.spring.web.rest;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeService {
	EmployeeListService emplist= new EmployeeListService();
	@RequestMapping(value = { "/employees" }, method = RequestMethod.POST)
	public @ResponseBody String postemployees(@RequestBody Employee employee) {
		
		emplist.add(employee);
		return  "EMPLOYEE ADDED SUCCESSFULLY";
		
	}
	
	@RequestMapping(value = { "/employees" }, method = RequestMethod.GET)
	public @ResponseBody ArrayList getemployees() {
		return  (ArrayList) emplist.list();
	}
	
	
	@RequestMapping(value = { "/employees/{id}" }, method = RequestMethod.GET)
	public @ResponseBody Employee getanemployee(@PathVariable(value="id") int id) {
		
	return  emplist.get(id);
	}
	
}
