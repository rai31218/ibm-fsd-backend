package com.example.spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
	
	String city;
	String country;
	int pin;
	
	public Address()
	{
		
	}	
	public String getCity() {
		return city;
	}
	@Value(value="Kolkata")
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	@Value(value="India")
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPin() {
		return pin;
	}
	@Value(value="700078")
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}


