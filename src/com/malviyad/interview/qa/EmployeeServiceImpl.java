package com.malviyad.interview.qa;
import java.util.HashMap;
import java.util.Map;

class Employee5 {
	String name;
	double salary;
	Integer id;
	String designation;
	String InsuranceScheme;

	public Employee5(String name, double salary, Integer id, String designation) {
		this.name=name;
		this.salary=salary;
		this.id=id;
		this.designation=designation;
		//this.InsuranceScheme=InsuranceScheme;
	}

	public String getInsuranceScheme(double salary) {
		/*
		 * write your code here to return the scheme on the basis of salary if nothing
		 * falls in the range return null
		 */
		if (salary > 5000 && salary < 20000) {
			return "c";
		} else if (salary >= 20000 && salary < 40000) {
			return "b";
		} else if (salary >= 40000) {
			return "a";
		} else if (salary < 5000) {
			return "no";
		} else {
			return null;
		}
	}
}

public class EmployeeServiceImpl {
	// Declare a Hashmap here where key is an Integer and the value is Employee
	// object
	static Map<Integer, Employee5> employeeMap = new HashMap<>();

	public static void addEmployee(Employee5 emp) {
		// write your code here to add employee to the hashmap
		employeeMap.put(emp.id, emp);
	}

	public static boolean deleteEmployee(int id) {
		// write your code here for returning true if the employee deleted wrt the id
		// passed else false
		if (employeeMap.containsKey(id)) {
			employeeMap.remove(id);
			return true;
		}
		return false;
	}

	public static String showEmpDetails(String InsuranceScheme) {
		/*
		 * Write your code here to return a string i.e the employee details according to
		 * the insurance scheme 
		 * Format: Name: name Id: id Salary: salary Designation: Designation InsuranceScheme: InsuranceScheme
		 *         Name: Dinesh Id: 1 Salary: 5500.0 Designation: SSE InsuranceScheme: c

		 *  If multiple results they should
		 * be in a different line
		 */
		String resultString = null;
		for (int key : employeeMap.keySet()) {
			Employee5 emp = employeeMap.get(key);
			if (emp.getInsuranceScheme(emp.salary).equalsIgnoreCase(InsuranceScheme)) {
				resultString = "Name: " + emp.name + " Id: " + emp.id + " Salary: " + emp.salary + " Designation: "
						+ emp.designation + " InsuranceScheme: " + emp.getInsuranceScheme(emp.salary) + "\n";
			}
		}
		return resultString;
	}
	public static void main(String[] args) {
		Employee5 emp = new Employee5("Dinesh", 5500, 1, "SSE");
		Employee5 emp1 = new Employee5("Malviya", 40000, 1, "SSE");
//		Employee5 emp2 = new Employee5("priya", 5500, 1, "SSE", "c");
//		Employee5 emp3 = new Employee5("Baba", 5500, 1, "SSE", "c");
		System.out.println("Hello");
		addEmployee(emp);
		System.out.println(showEmpDetails("c"));
		System.out.println(showEmpDetails("a"));
		System.out.println(deleteEmployee(4));
		
	}
}
