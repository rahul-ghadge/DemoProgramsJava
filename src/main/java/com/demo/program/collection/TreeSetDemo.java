package com.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		
		TreeSet<Integer> t = new TreeSet<Integer>();
		
		t.add(new Integer(10));
		t.add(20);
		t.add(30);
		t.add(100);
		t.add(100);
		t.add(100);
		
		Iterator<Integer> it = t.iterator();
		while(it.hasNext())
		{
			Object o = it.next();
			System.out.println(o);
		}
		
TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("Hi");
		ts.add("Hello");
		ts.add("Welcome");
		ts.add("Good Morning");
		
		System.out.println(ts);
		
		TreeSet<Product> p =  new TreeSet<Product>();
        p.add(new Product(11, "Shoes", 1000));
        p.add(new Product(13, "Watches",3460));
        p.add(new Product(12, "Bags", 4000));
     
        
        Iterator<Product> it1 = p.iterator(); 
        while(it1.hasNext())
        {
        	Product p1 = it1.next();
        	System.out.println(p1);
        }
        System.out.println("----------------------------------------------------");
        TreeSet<Product> p1 =  new TreeSet<Product>(new ProductCompare());
        p1.add(new Product(11, "Shoes", 1000));
        p1.add(new Product(13, "Watches",3460));
        p1.add(new Product(12, "Bags", 4000));
     
        
        Iterator<Product> it2 = p1.iterator(); 
        while(it2.hasNext())
        {
        	Product p2 = it2.next();
        	System.out.println(p2);
        }
	}
}
