package com.demo.program.methodcalls;

public class ExtendClass {

	public static void main(String argsp[]) {

		A a = new A();
		a.print();

		a = new B();
		a.print();

		a = new C();
		a.print();

		System.out.println("----------------------");

		C c = new C();
		c.print();

		B b = (C) c;
		b.print();

	}
}

class A {

	public static void staticPrint() {
		System.out.println("Static A");
	}

	public void print() {
		System.out.println("A print");
	}

}

class B extends A {

	public static void staticPrint() {
		System.out.println("Static B");
	}

	public void print() {
		System.out.println("B print");
	}

}

class C extends B {

	public static void staticPrint() {
		System.out.println("Static C");
	}

	public void print() {
		System.out.println("C print");
	}

}