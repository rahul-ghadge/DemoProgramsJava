package com.demo.program.comparatr;


import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapReverseOperations {

	public static void main(String[] args) {

		Comparator<Employee> compareByMultiple = Comparator
				.comparing(Employee::getDepartment, Comparator.reverseOrder())
				.thenComparing(Employee::getFirstName, Comparator.naturalOrder())
				.thenComparing(Employee::getSalary, Comparator.reverseOrder());
				//.reversed(); // reverse order


		TreeMap<Employee, String> employeeMapJava7 = new TreeMap<>(
				new Comparator<Employee>() {
					@Override
					public int compare(Employee e1, Employee e2) {
						// sort using name in desending order
						return e2.getFirstName().compareTo(e1.getFirstName());
						// sort using id in desending order
						// return e2.getId()-e1.getId();
					}
				});

		employeeMapJava7.put(new Employee(0, "Rohit", "Bhakare", "Software", 10.0f), "Rohit");
		employeeMapJava7.put(new Employee(10, "rahul", "ghadage", "Software", 5.0f), "rahul");
		employeeMapJava7.put(new Employee(7, "Vaibhav", "Shrivastava", "Software", 10.0f), "Vaibhav");
		employeeMapJava7.put(new Employee(1, "Ganesh", "Badar", "Management", 5.0f), "Ganesh");
		employeeMapJava7.put(new Employee(5, "Binay", "Gurung", "Architect", 20.0f), "Binay");
		employeeMapJava7.put(new Employee(2, "bindu", "gurung",  "Marketing", 7.0f), "binay");

		
		
		TreeMap<Employee, String> employeeMapJava8 = new TreeMap<>(compareByMultiple);
		employeeMapJava8.putAll(employeeMapJava7);
		
		// Printing the TreeMap (The keys will be sorted based on the supplied comparator)
		System.out.println(employeeMapJava7);
		System.out.println("-----------------------------");
		System.out.println(employeeMapJava8);
				

	}

}
