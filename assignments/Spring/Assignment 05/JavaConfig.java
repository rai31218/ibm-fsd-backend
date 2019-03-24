package com.example.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class JavaConfig {
@Bean	
	public EmpJavaConfig employeejavaconfig()
	{
		return new EmpJavaConfig();
	}
@Bean 
	public AddrJavaConfig address()
	{
	  return new AddrJavaConfig("Calcutta", "India", 700078);
	}

}
