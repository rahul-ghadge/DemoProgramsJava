package com.demo.program.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Advanced Stream Operations Demo
 * Demonstrates complex stream operations like flatMap, grouping, partitioning, and custom reductions.
 * Suitable for senior developers to understand performance and correctness.
 */
public class AdvancedStreamOperations {

    public static void main(String[] args) {
        // Sample data: List of departments with employees
        List<Department> departments = Arrays.asList(
            new Department("Engineering", Arrays.asList(
                new Employee("Alice", 30, 70000),
                new Employee("Bob", 25, 65000),
                new Employee("Charlie", 35, 80000)
            )),
            new Department("HR", Arrays.asList(
                new Employee("Diana", 28, 60000),
                new Employee("Eve", 32, 75000)
            )),
            new Department("Sales", Arrays.asList(
                new Employee("Frank", 40, 90000),
                new Employee("Grace", 29, 55000),
                new Employee("Henry", 45, 95000)
            ))
        );



        // 1. FlatMap: Get all employees across departments
        List<Employee> allEmployees = departments.stream()
            .flatMap(dept -> dept.getEmployees().stream())
            .collect(Collectors.toList());
        System.out.println("\nAll Employees: " + allEmployees);



        // 2. Grouping: Group employees by department name
        Map<String, List<Employee>> employeesByDept = departments.stream()
            .collect(Collectors.toMap(Department::getName, Department::getEmployees));
        System.out.println("\nEmployees by Department: " + employeesByDept);



        // 3. Partitioning: Partition employees into high and low salary (>70k)
        Map<Boolean, List<Employee>> partitionedBySalary = allEmployees.stream()
            .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 70000));
        System.out.println("\nHigh Salary Employees: " + partitionedBySalary.get(true));
        System.out.println("\nLow Salary Employees: " + partitionedBySalary.get(false));



        // 4. Custom Reduction: Calculate total salary per department
        Map<String, Double> totalSalaryByDept = departments.stream()
            .collect(Collectors.toMap(
                Department::getName,
                dept -> dept.getEmployees().stream().mapToDouble(Employee::getSalary).sum()
            ));
        System.out.println("\nTotal Salary by Department: " + totalSalaryByDept);



        // 5. Complex: Find the department with the highest average salary
        Optional<Department> deptWithHighestAvgSalary = departments.stream()
            .max(Comparator.comparingDouble(dept ->
                dept.getEmployees().stream().mapToDouble(Employee::getSalary).average().orElse(0.0)
            ));
        deptWithHighestAvgSalary.ifPresent(dept ->
            System.out.println("\nDepartment with highest avg salary: " + dept.getName())
        );



        // 6. Parallel Stream: Sum all salaries (demonstrate parallel processing)
        double totalSalary = allEmployees.parallelStream()
            .mapToDouble(Employee::getSalary)
            .sum();
        System.out.println("\nTotal Salary (parallel): " + totalSalary);
    }



    static class Department {
        private String name;
        private List<Employee> employees;

        public Department(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
        }

        public String getName() { return name; }
        public List<Employee> getEmployees() { return employees; }

        @Override
        public String toString() {
            return "Department{name='" + name + "', employees=" + employees + '}';
        }
    }

    static class Employee {
        private String name;
        private int age;
        private double salary;

        public Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + '}';
        }
    }
}

//        ---------------------------------------------------------------
//        Output
//        ---------------------------------------------------------------
//        All Employees: [Employee{name='Alice', age=30, salary=70000.0}, Employee{name='Bob', age=25, salary=65000.0}, Employee{name='Charlie', age=35, salary=80000.0}, Employee{name='Diana', age=28, salary=60000.0}, Employee{name='Eve', age=32, salary=75000.0}, Employee{name='Frank', age=40, salary=90000.0}, Employee{name='Grace', age=29, salary=55000.0}, Employee{name='Henry', age=45, salary=95000.0}]
//
//        Employees by Department: {Engineering=[Employee{name='Alice', age=30, salary=70000.0}, Employee{name='Bob', age=25, salary=65000.0}, Employee{name='Charlie', age=35, salary=80000.0}], Sales=[Employee{name='Frank', age=40, salary=90000.0}, Employee{name='Grace', age=29, salary=55000.0}, Employee{name='Henry', age=45, salary=95000.0}], HR=[Employee{name='Diana', age=28, salary=60000.0}, Employee{name='Eve', age=32, salary=75000.0}]}
//
//        High Salary Employees: [Employee{name='Charlie', age=35, salary=80000.0}, Employee{name='Eve', age=32, salary=75000.0}, Employee{name='Frank', age=40, salary=90000.0}, Employee{name='Henry', age=45, salary=95000.0}]
//
//        Low Salary Employees: [Employee{name='Alice', age=30, salary=70000.0}, Employee{name='Bob', age=25, salary=65000.0}, Employee{name='Diana', age=28, salary=60000.0}, Employee{name='Grace', age=29, salary=55000.0}]
//
//        Total Salary by Department: {Engineering=215000.0, Sales=240000.0, HR=135000.0}
//
//        Department with highest avg salary: Sales
//
//        Total Salary (parallel): 590000.0