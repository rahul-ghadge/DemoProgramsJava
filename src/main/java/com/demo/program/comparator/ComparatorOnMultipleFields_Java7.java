
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorOnMultipleFields_Java7 {
	
	public static void main(String[] args) {
		List<Employee> employees = getEmployeeList();

		// JAVA 7: Compare by Department, then Id and then First Name
        System.out.println("*** Before sorting Employees ***");
        
        for (Employee emp : employees) {
            System.out.println(emp);
        }
 
        Collections.sort(employees, new EmployeeChainedComparator(
                new EmployeeDepartmentComparator(),
                new EmployeeIdComparator(),
                new EmployeeFirstNameComparator())
        );
 
        System.out.println("\n*** After sorting Employees ***");
 
        for (Employee emp : employees) {
            System.out.println(emp);
        }
	}
	
	
	// Create and return static Employees
	private static List<Employee> getEmployeeList() {
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(2, "Rohit", "Bhakare", "IT"));
		list.add(new Employee(1, "Rahul", "Ghadge", "IT"));
		list.add(new Employee(4, "Rajesh", "Khuntiya", "Support"));
		list.add(new Employee(5, "Meeraj", "Khan", "Account"));
		list.add(new Employee(3, "Jaya", "Singh", "HR"));
		list.add(new Employee(7, "Rajesh", "Khanna", "Support"));
		list.add(new Employee(6, "Binay", "Gurun", "Management"));
		
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


//Employee class
class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String department;

	public Employee(int id, String firstName, String lastName, String department) {
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
