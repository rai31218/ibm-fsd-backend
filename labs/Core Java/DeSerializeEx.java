package com.java.training;

import java.io.*;
public class DeSerializeEx {

   public static void main(String [] args) {
	   EmpSerializeEx e = null;
      try {
         FileInputStream fileIn = new FileInputStream("C:\\\\test\\\\serializeex");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (EmpSerializeEx) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return;
      } catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
      
      System.out.println("Deserialized Employee...");
      System.out.println("Name: " + e.name);
      System.out.println("Address: " + e.address);
      System.out.println("SSN: " + e.SSN);
      System.out.println("Id: " + e.id);
   }
}