package com.example.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@ComponentScan
public class AnnoConfig {
@Bean	
	public Employee employee()
	{
		return new Employee();
	}
@Bean 
	public Address address()
	{
	  return new Address();
	}

}
