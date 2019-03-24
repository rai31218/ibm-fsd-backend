package com.example.spring.core;

import org.springframework.stereotype.Component;


//@Component("addrJavaConfig")
public class AddrJavaConfig {

	
	String city;
	String country;
	int pin;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public AddrJavaConfig(String city, String country, int pin)
	{
		this.city=city;
		this.country=country;
		this.pin=pin;
	}
	
	public void show()
	{
		System.out.println("From Addreess class speaking");
	}

}
