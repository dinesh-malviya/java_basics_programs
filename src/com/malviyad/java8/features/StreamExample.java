package com.malviyad.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//if we want to represent a group of object as a single entity then go for Collection
//if we want to process object from the collection then we should for streams concepts.
//wherever we have group of values or arrays then we can go for streams concepts
public class StreamExample {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(28);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(17);
		list.add(15);
		list.add(16);
		List<Integer> list2 = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println("list2:"+list2);
		
		int sum = list.stream().filter(n->n>16).mapToInt(i->i).sum();
		System.out.println("sum: "+sum);
		
		
		
		list.stream().flatMap(n->Stream.of(n-1)).forEach(System.out::println);
		
		/****************
		 ** FlatMap
		 ****************/
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13); 
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5); 
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8); 
        List<List<Integer>> listOfListofInts = 
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers); 
        System.out.println("The Structure before flattening is : " + listOfListofInts); 
        List<Integer> listofInts  = listOfListofInts.stream() 
                                    .flatMap(list1 -> list1.stream()) 
                                    .collect(Collectors.toList());
        System.out.println("listofInts: "+listofInts);
        
		ArrayList<Integer> marks = new ArrayList<>();
		marks.add(12);
		marks.add(2);
		marks.add(12);
		marks.add(19);
		marks.add(14);
		marks.add(15);
		marks.add(16);
		//if we want to do some operation on each object and generate new object then go for map.
		List<Integer> updatedMarks = marks.stream().map(i->i+5).collect(Collectors.toList());
		System.out.println(updatedMarks);
		long noOfFailedStud = marks.stream().filter(i->i<13).count();
		System.out.println(noOfFailedStud);
		
		List<Integer> sortedMarks = marks.stream().map(i->i+5).sorted().collect(Collectors.toList());
		System.out.println(sortedMarks);
		Consumer<Integer> c = i->{
			System.out.println("The square root of :"+i + " is :" +i*i);
		};
		sortedMarks.stream().forEach(c);
		System.out.println();
		sortedMarks.stream().forEach(i->{
			System.out.println("The square root of :"+i + " is :" +i*i);
		});
		
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(12);
		list3.add(2);
		list3.add(12);
		list3.add(19);
		list3.add(14);
		list3.add(15);
		list3.add(16);
		Integer i[] = list3.stream().toArray(Integer[]::new);
		Stream.of(i).forEach(System.out::println);
		System.out.println();
		Stream<Integer> s = Stream.of(90,30,20,58,1);
		s.forEach(System.out::println);
		
		EmployeeClass emp1 = new EmployeeClass("Dinesh", 125, 32);
		EmployeeClass emp2 = new EmployeeClass("Mukesh", 85, 31);
		EmployeeClass emp3 = new EmployeeClass("Suresh", 87, 20);
		EmployeeClass emp4 = new EmployeeClass("Ganesh", 200, 22);
		EmployeeClass emp5 = new EmployeeClass("Kumar", 98, 39);
		EmployeeClass emp6 = new EmployeeClass("Vikas", 184, 42);
		List<EmployeeClass> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		empList.add(emp6);
		//empList.sort((e1, e2)->e1.getEmpName().compareTo(e2.getEmpName()));
		System.out.println("empList:"+empList);
		
		Collections.sort(empList, (e1, e2)->e1.getEmpName().compareTo(e2.getEmpName()));
		System.out.println("after sorting empList:"+empList);

		List<String> strList = new ArrayList<>();
		strList.add("gdrfr");
		strList.add("abcree");
		strList.add("bcdesw");
		strList.add("bcdesw");
		strList.add("acbdrt");
		strList.add("uhdtre");
		strList.add("abcndr");
		strList.add("abcwer");
		strList.add("acbdou");
		
		System.out.println("============");
		strList.stream().filter(name ->name.startsWith("abc")).forEach(System.out::println);
		System.out.println("============ strList: "+strList);
		List<String> strList1 = strList.stream().filter(name->name.startsWith("abc")).collect(Collectors.toList());
		System.out.println("strList1:"+strList1);
		
		Predicate<String> stringPredicate = name->name.startsWith("abc");
		boolean test = stringPredicate.test("abcdinesh");
		System.out.println("result :"+test);
		test = stringPredicate.test("acvmanoj");
		System.out.println("again result :"+test);
		
		String foundStr = strList.stream().filter(str->str.equals("bcdesw")).findAny().orElse(null);
		System.out.println("foundStr: "+foundStr);
		StreamExample streamExample= new StreamExample();
		List<String> mappedList = strList.stream().filter(str->str.equals("bcdesw")).map(streamExample::updatedName).collect(Collectors.toList());
		System.out.println("mappedList: "+mappedList);
		
		List<String> mappedList1 = strList.stream().filter(str->str.equals("bcdesw")).map(StreamExample::updatedNameStatic).collect(Collectors.toList());
		System.out.println("mappedList1: "+mappedList1);
	}
	
	private  String updatedName(String name) {
		return name+"update";
	}
	
	private  static String updatedNameStatic(String name) {
		return name+"update";
	}
}

class EmployeeClass{
	private String empName;
	private int empId;
	private int empAge;
	
	public EmployeeClass(String empName, int empId, int empAge) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empAge = empAge;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	
	public String toString() {
		return empName +" " +empId +" " +empAge;
	}
}
