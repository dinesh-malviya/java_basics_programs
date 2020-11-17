package com.malviyad.serialization.deserialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {
	public static void main(String[] args) {
		try {
			Employee emp = new Employee("Dinesh", 125);
			FileOutputStream fout = new FileOutputStream("employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(emp);
			out.flush();
			out.close();
			System.out.println("successfully Created");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
