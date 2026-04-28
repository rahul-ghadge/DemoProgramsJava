package com.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		
		HashSet h = new HashSet();
		
		h.add(new Integer(100));
		h.add(10.9);
		h.add(60.5f);
	  	h.add("Hello World!");
		h.add(60.5f);
		h.add(new Employee(10,"Sakshi",100000));
		h.add(new Employee(12,"Palak",100000));
		h.add(new Employee(10,"Ritesh",100000));
		h.add(new Employee(12,"Prachi",100000));
		h.add(10);
	    Iterator i = h.iterator();
			
		while(i.hasNext())
		{
			Object o = i.next();
			System.out.println(o);
		}
	}
}
