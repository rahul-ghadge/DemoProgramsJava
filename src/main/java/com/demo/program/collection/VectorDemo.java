package com.collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
	
	public static void main(String[] args) {
		
		Vector list = new Vector();
		
		list.addElement(new Integer(20));
		list.addElement(20.5f);
		list.addElement(30);
		list.addElement("Hello");
		list.addElement(new String("Hi"));
		list.addElement(new String("Hi"));
		list.add(new Employee(10,"Sakshi",10.5f));
		list.add(new Employee(12,"Palak",13.5f));
		Enumeration e = list.elements();
		while(e.hasMoreElements())
		{
			Object o = e.nextElement();
			System.out.println(o);
		}
		
	}

}
