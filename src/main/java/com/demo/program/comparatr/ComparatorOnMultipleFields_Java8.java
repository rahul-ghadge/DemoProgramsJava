package com.demo.program.comparatr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorOnMultipleFields_Java8 {

	public static void main(String[] args) {
		List<Employee> employees = getEmployeeList();
		
		 System.out.println("*** Before sorting Employees ***\n");
		 printEmployeeList(employees);

		// JAVA 8: Compare by Department, then First Name and then Last Name
		Comparator<Employee> compareByName = Comparator
				.comparing(Employee::getDepartment)
				.thenComparing(Employee::getFirstName)
				.thenComparing(Employee::getLastName);
		

		// Apply comparator on Collections.sort() method
		Collections.sort(employees, compareByName);

		// Print Employee data
		System.out.println("\n*** After sorting Employees ***\n");
		printEmployeeList(employees);
	}

	// Create and return static Employee
	private static List<Employee> getEmployeeList() {
		List<Employee> list = new ArrayList<>();

		list.add(new Employee(0, "Rohit", "Bhakare", "Software", 10.0f));
		list.add(new Employee(10, "rahul", "ghadage", "Software", 5.0f));
		list.add(new Employee(7, "Vaibhav", "Shrivastava", "Software", 10.0f));
		list.add(new Employee(1, "Ganesh", "Badar", "Management", 5.0f));
		list.add(new Employee(5, "Binay", "Gurung", "Architect", 20.0f));
		list.add(new Employee(2, "bindu", "gurung",  "Marketing", 7.0f));

		return list;
	}

	// Print Employee data
	private static void printEmployeeList(List<Employee> employees) {
		employees.forEach(System.out::print);
	}
}