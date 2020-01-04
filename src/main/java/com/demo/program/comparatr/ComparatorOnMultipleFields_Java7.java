package com.demo.program.comparatr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorOnMultipleFields_Java7 {
	
	public static void main(String[] args) {
		List<Employee> employees = getEmployeeList();

		// JAVA 7: Compare by Department, then Id and then First Name
        System.out.println("*** Before sorting Employees ***\n");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
 
        Collections.sort(employees, new EmployeeChainedComparator(
                new EmployeeDepartmentComparator(),
                new EmployeeIdComparator(),
                new EmployeeFirstNameComparator())
        );
 
        System.out.println("\n*** After sorting Employees ***\n");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
	}
	
	
	// Create and return static Employees
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
}


class EmployeeDepartmentComparator implements Comparator<Employee> {
	 
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getDepartment().compareTo(emp2.getDepartment());
    }
}

class EmployeeFirstNameComparator implements Comparator<Employee> {
	 
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getFirstName().compareTo(emp2.getFirstName());
    }
}

class EmployeeIdComparator implements Comparator<Employee> {
	 
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getId() - emp2.getId();
    }
}



class EmployeeChainedComparator implements Comparator<Employee> {
	 
    private List<Comparator<Employee>> listComparators;
 
    @SafeVarargs
    public EmployeeChainedComparator(Comparator<Employee>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Employee emp1, Employee emp2) {
        for (Comparator<Employee> comparator : listComparators) {
            int result = comparator.compare(emp1, emp2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
