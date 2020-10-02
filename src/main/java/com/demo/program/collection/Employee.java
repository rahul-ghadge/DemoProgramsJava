package com.collection;

public class Employee {

	private int id;
	private String name;
	private float salary;
	
	public Employee(int id, String name, float salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getSalary() {
		return salary;
	}
	
	public String toString()
	{
		return ("ID:"+id+" Name:"+name+" Salary:"+salary);
	}
	
	public int hashCode()
	{
		return id;
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Employee)
		{
		  Employee e = (Employee)obj;
		  if(this.id==e.id && this.name==e.name && this.salary==e.salary)
		  {
			return true;
		  }
		}
	return false;
		
	}
	
}
