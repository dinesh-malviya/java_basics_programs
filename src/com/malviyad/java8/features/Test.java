package com.malviyad.java8.features;

import java.util.ArrayList;
import java.util.Collections;

class Employee {
	String name;
	int eNum;

	public Employee(String name, int eNum) {
		this.name = name;
		this.eNum = eNum;
	}

	public String toString() {
		return eNum + ":" + name;
	}
}

//By default Static methods of interfaces are not available in the implementation classes.
//Interface static methods should be called only by using interface name only.
interface Interface1 {
	public static void method1(){
		System.out.println("static method1");
	}
	public static void main(String [] args){
		System.out.println("static main");
	}
}
//Without implementing Interface1 also we can call Interface1 static method
public class Test implements Interface1{
	public static void main(String[] args) {
		Employee employee = new Employee("Dinesh", 31);
		System.out.println(employee);
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Mukesh", 32));
		employeeList.add(new Employee("Baba", 33));
		employeeList.add(new Employee("Pajji", 38));
		employeeList.add(new Employee("Chaman", 30));
		System.out.println(employeeList);
		Collections.sort(employeeList, (e1, e2) -> (e1.eNum < e2.eNum) ? -1 : (e1.eNum > e2.eNum) ? 1 : 0);
		System.out.println(employeeList);

		//Lambda versus Anonymous class.
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				//System.out.println("from child thread:" + i);
			}
		});
		thread.start();
		for (int i = 0; i < 10; i++) {
			//System.out.println("from parent thread:" + i);
		}
		//Interface static methods should be called only by using interface name only.
		Interface1.method1();
		Interface1.main(args);
	}
}

//Until 1.7 version --Every method inside a interface was always public and abstract
//1.8 version : default methods (virtual Extension | Defender method ) + static methods are also allowed
//1.9 version : private methods are also allowed
//in all versions: variables are always public static final.
//Without affecting implementation classes if we want to add new method to the interface then go for default method.
//default methods can only be defined in the interface but not in any class.
//Object class methods (eg hashCode()) are not allowed to defined in interface as these methods are always available in all classes.
//If you have only static methods then go for interface (1.8 version onwards).
