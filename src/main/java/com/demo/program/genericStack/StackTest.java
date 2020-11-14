package com.demo.program.genericStack;

public class StackTest {

	public static void main(String[] args) {
		
		GenericsStackDemo<Employee> emp = new GenericsStackDemo<>();
		GenericsStackDemo<Professors> professor = new GenericsStackDemo<>();
		
		
		try 
		{
			emp.push(new Employee(1, "Bhargavi"));
			emp.push(new Employee(2, "Sakshi"));
			emp.push(new Employee(3, "Palak"));
			
			professor.push(new Professors(101, "Harry"));
			professor.push(new Professors(102, "Jackie"));
			professor.push(new Professors(103, "Davis"));
			
		} 
		catch (Exception e) 
		{
			
			System.out.println("Exception...");
		}
		
		finally {
			System.out.println("Successful");
		}
		
	}
	
	
}
