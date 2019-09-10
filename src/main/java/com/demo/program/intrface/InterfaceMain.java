package com.demo.program.intrface;

interface A {
	public abstract String print(String name);
}

interface B {
	public abstract String print(String name);

	static void method() {
		System.out.println("Test");
	}
}

class Inf implements InterfaceMain.A {

	@Override
	public void a() {
		System.out.println("Inner class interface is called");

	}
}

public class InterfaceMain {

	public static void main(String[] args) {

		B b = str -> { return str.concat(" is string"); };
		System.out.println(b.print("abc"));
		B.method();

		InterfaceMain.A ia = () -> System.out.println("Inner interface is called");
		ia.a();

	}

	interface A {
		void a();
	}

}
