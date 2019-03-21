package com.example.spring.core;

public class Greetings {
	   private String message="Hello world";
	   public Greetings()
	   {
		   
	   }
	   
	   public Greetings(Integer num, String msg)
	   {
		   System.out.println(num+ " "+ msg);
	   }
	   public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
	}
	}