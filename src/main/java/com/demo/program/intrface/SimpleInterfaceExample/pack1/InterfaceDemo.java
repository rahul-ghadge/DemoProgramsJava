package com.demo.program.intrface.SimpleInterfaceExample.pack1;

public class InterfaceDemo implements I1, I2 {

	public void show() {
		System.out.println("Show ");
	}

	public void display() {
		System.out.println("Display");
	}

	void print() {
		System.out.println("Print");
	}

	public static void main(String[] args) {
		I1 obj1 = new InterfaceDemo();
		obj1.show();

		I2 obj2 = new InterfaceDemo();
		obj2.show();
		obj2.display();
		((InterfaceDemo) obj2).print();

		I1 obj4 = new Sub();
		obj4.show();

		I2 obj5 = new Sub();
		obj5.show();
		obj5.display();

		I3 obj3 = new Sub();
		obj3.show();
		obj3.display();
		obj3.myMethod();
		;

	}
}

class Sub implements I3 {
	public void myMethod() {
		System.out.println("Mymethod subclass");
	}

	public void show() {
		System.out.println("show subclass");
	}

	public void display() {
		System.out.println("display in subclass");
	}
}