package com.java.training;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class LambdaExpressionEx {

	   public static void main(String args[]) {
		   LambdaExpressionEx lamExp = new LambdaExpressionEx();
			
	      //with type declaration
	      BiFunction<Integer, Integer, Integer> addition = (Integer a, Integer b) -> a + b; //BiFunctio is default functional interface
			
	      //with out type declaration
	      //BiFunction<Integer, Integer, Integer> subtraction = (a, b) -> a - b;
			
	      //with return statement along with curly braces
	      MathOperation multiplication = (int a, int b) -> { return a * b; };
			
	      //without return statement and without curly braces
	      MathOperation division = (int a, int b) -> a / b;
			
	      addition =(Integer a, Integer b) -> a + b));
		  System.out.println("100 + 5 = " + lamExp.funcoperates(100, 5, addition));
	      System.out.println("95 - 5 = " + lamExp.funcoperates(95, 5, (a, b) -> a - b));
	      System.out.println("10 x 5 = " + lamExp.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + lamExp.operate(10, 5, division));
	      
	  
	      //without parenthesis and using Consumer functional interface
	      Consumer<String> greetService1 = message ->
	      System.out.println("Hello " + message);
			
	      //with parenthesis and using custom functional interface
	      GreetingService greetService2 = (message) ->                  //this is the implementation of interface
	      System.out.println("Hello " + message);
			
	      greetService1.accept("Mahesh");
	      greetService2.sayMessage("Suresh");  
	      
	      Consumer<String> name= nam->System.out.println("Hi my dear "+nam);
	      Consumer<String> n=na->lamExp.displayname(na);
	      
	      name.accept("Rudra");
	      name.accept("Rai");
	       
	   }
		
	    void displayname(String name)
	      {
	    	  System.out.println(name);
	      }
	   
	   
	   interface MathOperation {
	      int operation(int a, int b);
	   }
		
	   
	   interface GreetingService {              // this is the interface
	      void sayMessage(String message);
	   }
		
	   
	   private int operate(int a, int b, MathOperation mathOperation) {
	      return mathOperation.operation(a, b);
	   }
	   private int funcoperates(Integer a, Integer b, BiFunction<Integer,Integer,Integer> mathOperation) {
		     if(a>b)
		     {
		    	 System.out.println("a is greater");
		     }
		      return mathOperation.apply(a, b); // apply is the default method for BiFunction
		   }

}