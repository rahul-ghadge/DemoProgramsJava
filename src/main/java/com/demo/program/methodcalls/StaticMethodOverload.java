package com.demo.program.methodcalls;

public class StaticMethodOverload {

	@SuppressWarnings("static-access")
	public static void main(String args[]) {

		Parent p = new Parent();
		p.name(1); // should call static method from super class (Parent)
		// because type of reference variable
		// p is Parent

		p.print(2);

		p = new Child();
		p.name(3); // as per overriding rules this should call to child's static
		// overridden method. Since static method can not be overridden
		// , it will call parent static method
		// because Type of p is Parent.

		p.print(4);

		Child c = new Child();
		c.name(5); // will call child static method because static method
		// get called by type of Class

		c.print(6);

	}
}

class Parent {

	/*
	 * * original static method in super class which will be hidden in subclass.
	 */

	public static void name(int i) {
		System.out.println(i + " : static method from Parent");
	}

	public void print(int i) {
		System.out.println(i + " : Print method from Parent");
	}

}

class Child extends Parent {
	/*
	 * * Static method with same signature as in super class, Since static method
	 * can not be overridden, this is called method hiding. Now, if you call
	 * Child.name(), this method will be called, also any call to name() in this
	 * particular class will go to this method, because super class method is
	 * hidden.
	 */

	public static void name(int i) {
		System.out.println(i + " : static method from Child");
	}

	public void print(int i) {
		System.out.println(i + " : Print method from Child");
	}
}

//  OUTOUT
//
//  1 : static method from Parent
//  2 : Print method from Parent
//  3 : static method from Parent
//  4 : Print method from Child
//  5 : static method from Child
//  6 : Print method from Child