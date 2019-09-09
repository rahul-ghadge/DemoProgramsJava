
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorOnMultipleFields_Java8 {
	
	public static void main(String[] args) {
		List<Employee> employees = getEmployeeList();

		// JAVA 8: Compare by Department, then First Name and then Last Name
		Comparator<Employee> compareByName = Comparator
				.comparing(Employee::getDepartment)
				.thenComparing(Employee::getFirstName)
				.thenComparing(Employee::getLastName);

		// Apply comparator on Collections.sort() method
		Collections.sort(employees, compareByName);

		// Print Employee data
		printEmployeeList(employees);
	}
	
	
	// Create and return static Employee
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

	// Print Employee data
	private static void printEmployeeList(List<Employee> employees) {
		employees.forEach(System.out::print);
	}
}



// Employee class
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
				+ "]\n";
	}
}
