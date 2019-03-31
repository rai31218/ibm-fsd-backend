package com.examples.spring.web.mvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Registration {
	

@Size(min=1,message="username required")  
	private String userName;

@Size(min=1,message="password required")  
	private String password;

@Size(min=1,message="name required")  
	private String name;
	
	public Registration()
	{
		
	}
	
	public Registration(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	

}
