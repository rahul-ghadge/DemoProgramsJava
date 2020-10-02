package com.collection;

import java.util.ArrayList;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add(new Integer(10));
		list.add(new Float(20.6));
		list.add(new String("ABC"));
		list.add("Welcome");
		list.add(30.8);
		list.add(1, "HI");
		list.add(30.8);
		list.add(new Employee(10,"Sakshi",10.5f));
		list.add(new Employee(12,"Palak",13.5f));
		for(int i=0;i<list.size();i++)
		{
			Object obj = list.get(i);
			if(obj instanceof Employee){
				System.out.println("Employee Details:");
				System.out.println("Id: "+((Employee)obj).getId());
				System.out.println("Name: "+((Employee)obj).getName());
				System.out.println("Salary: "+((Employee)obj).getSalary());
			}
			else
			{
			     System.out.println(obj);
			}
		}
		
	}

}
