package com.java.training;

public interface Appraisable extends Inheritable {
	public void appraise();
	
	default void defaultTest()
	{
		System.out.println("Hey, inteface can now have method implementation with default method");
	}

}
