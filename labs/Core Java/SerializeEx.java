package com.java.training;

import java.io.*;

public class SerializeEx {
	public static void main(String[] args) {
		EmpSerializeEx e = new EmpSerializeEx();
		e.name = "Reyan Ali";
		e.address = "Phokka Kuan, Ambehta Peer";
		e.SSN = 11122333;
		e.id = 101;

		try {
			FileOutputStream fileOut = new FileOutputStream("C:\\test\\serializeex");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in C:\\\\test\\\\serializeex");
		} catch (IOException i) {
			System.out.println(i);
			i.printStackTrace();
		}
}
}