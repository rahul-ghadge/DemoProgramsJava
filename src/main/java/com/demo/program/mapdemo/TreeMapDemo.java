package com.map;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		TreeMap< Integer, String> map = new TreeMap<Integer, String>();
		
		map.put(2,"Hi");
		map.put(1, "Hello");
		map.put(3, "Welcome");
		
		Set<Integer> keys = map.keySet();
		for(Integer i : keys)
		{
			System.out.println("Key :"+i+" Value: "+map.get(i));
		}
		
	    TreeMap<String,Employee> map1 = new TreeMap<String, Employee>();
	    map1.put("Hi", new Employee(101,"Sakshi",1000));
	    map1.put("Bitch", new Employee(102,"Palak",2000));
	    
	    Set<String> keys2 = map1.keySet();
		for(String s : keys2)
		{
			System.out.println("Key :"+s+" Value: "+map1.get(s));
		}
	    
		
		TreeMap<Student,String> map2 = new TreeMap<Student, String>();
		
		map2.put(new Student(3,"Sakshi",87.3f), "hi");
		map2.put(new Student(2,"Palak",85.3f), "hello");
		map2.put(new Student(4,"Prachi",75.9f), "today");
		
		Set<Student> set = map2.keySet();
		for(Student s : set)
		{
			System.out.println("Key: "+s+" Value: "+map2.get(s));
		}
		System.out.println("---------------------------------------------------");
  
		TreeMap<Student,String> map3 = new TreeMap<Student, String>(new StudentComparator()); 	
		map3.put(new Student(3,"Sakshi",87.3f), "hi");
        map3.put(new Student(2,"Palak",85.3f), "hello");
		map3.put(new Student(4,"Prachi",75.9f), "today");
		
		Set<Student> set1 = map3.keySet();
		for(Student s : set1)
		{
			System.out.println("Key: "+s+" Value: "+map3.get(s));
		}
	}
}
