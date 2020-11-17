package com.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		
		
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		
		map.put(new Integer(10), "Sakshi");
		map.put(new Integer(20), "Palak");
		map.put(40, "prachi");
		map.put(40,"Ritesh");
		map.put(50, "prachi");
		map.put(null, "Hi");
		map.put(null, "Hello");
		map.put(60, null);
		map.put(70,null);
		
		
		//String s = map.get(10);
		Set<Integer> keys = map.keySet();
		
		for(Integer k : keys)
		{
			System.out.println("Key :"+k+" Value: "+map.get(k));
		}
		
		
		HashMap<Employee, String> empmap = new HashMap<Employee, String>();
		
		Employee emp1=new Employee(101,"sakshi",1290);
		Employee emp2=new Employee(101,"sakshi",1290);
		Employee emp3=new Employee(103,"palak",34324);
		
		empmap.put(emp1, "Hi");
		empmap.put(emp2, "Hello");
		empmap.put(emp3, "Hi");
		
		Set<Employee> empset=empmap.keySet();
		Iterator<Employee> it = empset.iterator();
		while(it.hasNext())
		{
			Employee emp = it.next();
			System.out.println("Key :"+emp+" Value: "+empmap.get(emp));
		}	
		
	}
	
}
