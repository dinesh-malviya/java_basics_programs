package com.malviyad.serialization.deserialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationExample {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("employee.txt");
			ObjectInputStream in = new ObjectInputStream(fin);
			Employee emp = (Employee) in.readObject();
			System.out.println(emp.empId + " " + emp.empName);
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
