package com.demo.program.comparatr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorOnMultipleFields_Java7 {
	
	public static void main(String[] args) {
		List<Employee7> employees = getEmployeeList();

		// JAVA 7: Compare by Department, then Id and then First Name
        System.out.println("*** Before sorting Employees ***\n");
        for (Employee7 emp : employees) {
            System.out.println(emp);
        }
 
        Collections.sort(employees, new EmployeeChainedComparator(
                new EmployeeDepartmentComparator(),
                new EmployeeIdComparator(),
                new EmployeeFirstNameComparator())
        );
 
        System.out.println("\n*** After sorting Employees ***\n");
        for (Employee7 emp : employees) {
            System.out.println(emp);
        }
	}
	
	
	// Create and return static Employees
	private static List<Employee7> getEmployeeList() {
		List<Employee7> list = new ArrayList<>();
		
		list.add(new Employee7(2, "Rohit", "Bhakare", "IT"));
		list.add(new Employee7(1, "Rahul", "Ghadge", "IT"));
		list.add(new Employee7(4, "Rajesh", "Khuntiya", "Support"));
		list.add(new Employee7(5, "Meeraj", "Khan", "Account"));
		list.add(new Employee7(3, "Jaya", "Singh", "HR"));
		list.add(new Employee7(7, "Rajesh", "Khanna", "Support"));
		list.add(new Employee7(6, "Binay", "Gurun", "Management"));
		
		return list;
	}
}


class EmployeeDepartmentComparator implements Comparator<Employee7> {
	 
    @Override
    public int compare(Employee7 emp1, Employee7 emp2) {
        return emp1.getDepartment().compareTo(emp2.getDepartment());
    }
}

class EmployeeFirstNameComparator implements Comparator<Employee7> {
	 
    @Override
    public int compare(Employee7 emp1, Employee7 emp2) {
        return emp1.getFirstName().compareTo(emp2.getFirstName());
    }
}

class EmployeeIdComparator implements Comparator<Employee7> {
	 
    @Override
    public int compare(Employee7 emp1, Employee7 emp2) {
        return emp1.getId() - emp2.getId();
    }
}



class EmployeeChainedComparator implements Comparator<Employee7> {
	 
    private List<Comparator<Employee7>> listComparators;
 
    @SafeVarargs
    public EmployeeChainedComparator(Comparator<Employee7>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Employee7 emp1, Employee7 emp2) {
        for (Comparator<Employee7> comparator : listComparators) {
            int result = comparator.compare(emp1, emp2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}


//Employee class
class Employee7 {

	private int id;
	private String firstName;
	private String lastName;
	private String department;

	public Employee7(int id, String firstName, String lastName, String department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "[Id=" + id + ", \tfirstName=" + firstName
				+ ", \tlastName=" + lastName + ", \tdepartment=" + department
				+ "]";
	}

}
