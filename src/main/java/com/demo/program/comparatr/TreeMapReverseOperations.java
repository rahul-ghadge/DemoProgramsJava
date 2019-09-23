package com.demo.program.comparatr;


import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapReverseOperations {

	public static void main(String[] args) {

		Comparator<EmployeeModel> compareByMultiple = Comparator
				.comparing(EmployeeModel::getDepartment, Comparator.reverseOrder())
				.thenComparing(EmployeeModel::getName, Comparator.naturalOrder())
				.thenComparing(EmployeeModel::getSalary, Comparator.reverseOrder());
				//.reversed(); // reverse order


		TreeMap<EmployeeModel, String> employeeMapJava7 = new TreeMap<>(
				new Comparator<EmployeeModel>() {
					@Override
					public int compare(EmployeeModel e1, EmployeeModel e2) {
						// sort using name in desending order
						return e2.getName().compareTo(e1.getName());
						// sort using id in desending order
						// return e2.getId()-e1.getId();
					}
				});

		employeeMapJava7.put(new EmployeeModel(0, "Rohit", "Software", 10), "Rohit");
		employeeMapJava7.put(new EmployeeModel(10, "rahul", "Software", 5), "rahul");
		employeeMapJava7.put(new EmployeeModel(7, "Vaibhav", "Software", 10), "Vaibhav");
		employeeMapJava7.put(new EmployeeModel(1, "Ganesh", "Management", 5), "Ganesh");
		employeeMapJava7.put(new EmployeeModel(5, "Binay", "Architect", 20), "Binay");
		employeeMapJava7.put(new EmployeeModel(2, "bindu", "Marketing", 7), "binay");

		
		
		TreeMap<EmployeeModel, String> employeeMapJava8 = new TreeMap<>(compareByMultiple);
		employeeMapJava8.putAll(employeeMapJava7);
		
		// Printing the TreeMap (The keys will be sorted based on the supplied comparator)
		System.out.println(employeeMapJava7);
		System.out.println("-----------------------------");
		System.out.println(employeeMapJava8);
				

	}

}
