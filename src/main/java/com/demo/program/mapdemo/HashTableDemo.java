package com.map;

import java.util.Hashtable;
import java.util.Set;

import com.map.Employee;

public class HashTableDemo {

	public static void main(String[] args) {
		
		Hashtable<Integer,Employee> map = new Hashtable<Integer, Employee>();
		
		map.put(1,new Employee(101,"Sakshi",1000));
		map.put(2,new Employee(101, "Sakshi", 1000));
		map.put(new Integer(4), new Employee(101, "Ritesh", 90000));
		map.put(new Integer(6), new Employee(103, "Palak", 60000));
		//map.put(5,null);
		
		Set<Integer> set = map.keySet();
		for(Integer i : set)
		{
			System.out.println("Key: "+i+" Value: "+map.get(i));
		}
		
	}
}
