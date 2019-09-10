package com.demo.program.methodcalls;

public class IntegerTest {

	public void printInt(int i) {
		System.out.println("int : " + i);
	}

	public void printInt(Integer i) {
		System.out.println("Integer : " + i);
	}

	public static void main(String args[]) {

		IntegerTest it = new IntegerTest();
		it.printInt(5);
		it.printInt(new Integer(10));

	}

}
