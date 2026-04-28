package com.map;

public class Employee {
	
	private int id;
	private String name;
	private float salary;
	public Employee(int id, String name, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ "]";
	}
	
	public int hashCode()
	{
		return id;	
	}
	
    public boolean equals(Object obj)
    {
    	Employee emp = (Employee)obj;
    	if(this.name.equals(emp.name))
    	{
    		if(this.salary == emp.salary)
    		{
    			return true;
    		}
    	}
        return false;
    }
}
