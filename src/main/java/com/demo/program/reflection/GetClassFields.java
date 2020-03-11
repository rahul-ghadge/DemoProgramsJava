package com.demo.program.reflection;

import java.lang.reflect.Field;

public class GetClassFields {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try {
			Class<AnyClass> cls = (Class<AnyClass>) Class
					.forName("com.demo.program.reflection.AnyClass");

			/*
			 * Get public fields of class
			 */
			
			System.out.println("---------------------------------------------");
			System.out.println("   ------------ Public Fields ------------   ");
			System.out.println("---------------------------------------------");
			System.out.println("Field Name \t|\t Datatype");
			
			Field[] fields = cls.getFields();

			for (Field field : fields) {
				System.out.println(field.getName()+ " \t|\t " + field.getType());
			}

			
			
			/*
			 *  Get public and private fields of class
			 */
			
			System.out.println("---------------------------------------------");
			System.out.println("   ------- Public/Private Fields ---------   ");
			System.out.println("---------------------------------------------");
			System.out.println("Field Name \t|\t Datatype");
			
			fields = cls.getDeclaredFields();
			
			for (Field field : fields) {
				System.out.println(field.getName()+ " \t|\t " + field.getType().getSimpleName());
			}
			
			
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class AnyClass {

	public String userName;
	public int userData;
	public boolean isVisible;

	@SuppressWarnings("unused")
	private String privateField;
}


//---------------------------------------------------------------
//Output 
//---------------------------------------------------------------
// ---------------------------------------------
// ------------ Public Fields ------------   
// ---------------------------------------------
// Field Name 	|	 Datatype
// userName 	|	 class java.lang.String
// userData 	|	 int
// isVisible 	|	 boolean
// ---------------------------------------------
// ------- Public/Private Fields ---------   
// ---------------------------------------------
// Field Name 	|	 Datatype
// userName 	|	 String
// userData 	|	 int
// isVisible 	|	 boolean
// privateField 	|	 String
