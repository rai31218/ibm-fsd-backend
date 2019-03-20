package com.java.training;

import java.io.*;
import java.io.FileOutputStream;

public class FileInputSteam {

	/*public static void main(String[] args) {
		FileInputStream in;
		FileOutputStream out;
		try
		{
			in=new FileInputStream("C:\\INSTALL.LOG");
			out=new FileOutputStream("C:\\test\\INSTALL");
			int r;
			while((r=in.read())!=-1)
			{
				
				System.out.print((char)r);
				out.write(r);
			}		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}*/
	public static void main(String args[]) throws IOException {
	      FileReader in = null;
	      FileWriter out = null;

	      try {
	         in = new FileReader("C:\\INSTALL.LOG");
	         out = new FileWriter("C:\\test\\output.txt");
	         
	         int c;
	         String s="Hello World";
	         
	            out.write(s);
	         
	         
	         System.out.println("File copied successfully.");
	         
	      
	      
	}

}
