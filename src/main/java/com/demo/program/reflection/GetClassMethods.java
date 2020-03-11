package com.demo.program.reflection;

import java.lang.reflect.Method;

public class GetClassMethods {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		try {
			
		Class<PrivateClass> cls = (Class<PrivateClass>) Class
				.forName("com.demo.program.reflection.PrivateClass");
		
		
		/*
		 * Get public fields of class
		 */
		
		System.out.println("---------------------------------------------");
		System.out.println("   ------------ Public Methods ------------   ");
		System.out.println("---------------------------------------------");
		System.out.println("Method Name | Return type | Parameter Count \n");
		
		Method[] methods = cls.getMethods();

		for (Method method : methods) {
			System.out.println(method.getName() + " | " + method.getReturnType().getName()
					+ " | " + method.getParameterCount());
		}
		
		
		System.out.println("\n\n---------------------------------------------");
		System.out.println("   ------- Public/Private Methods --------   ");
		System.out.println("---------------------------------------------");
		System.out.println("Method Name | Return type | Parameter Count \n");
		Method[] methodsAll = cls.getDeclaredMethods();

		for (Method method : methodsAll) {
			System.out.println(method.getName() + " | " + method.getReturnType().getName()
					+ " | " + method.getParameterCount());
		}

		

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}


class PrivateClass {

	public String getName() {
		return "Hello Aryan..!";
	}

	@SuppressWarnings("unused")
	private String getPrivateName() {
		return "Hello secure Aryan..!";
	}
}


//---------------------------------------------------------------
//Output 
//---------------------------------------------------------------
//	---------------------------------------------
//	------------ Public Methods ------------   
//	---------------------------------------------
//	Method Name | Return type | Parameter Count 
//	
//	getName | java.lang.String | 0
//	wait | void | 0
//	wait | void | 2
//	wait | void | 1
//	equals | boolean | 1
//	toString | java.lang.String | 0
//	hashCode | int | 0
//	getClass | java.lang.Class | 0
//	notify | void | 0
//	notifyAll | void | 0
//	
//	
//	---------------------------------------------
//	------- Public/Private Methods --------   
//	---------------------------------------------
//	Method Name | Return type | Parameter Count 
//	
//	getName | java.lang.String | 0
//	getPrivateName | java.lang.String | 0
