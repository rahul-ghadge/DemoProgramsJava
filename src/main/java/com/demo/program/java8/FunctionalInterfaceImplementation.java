package com.demo.program.java8;

import java.util.stream.Stream;

public class FunctionalInterfaceImplementation {

	public static void main(String[] args) {

		StringLength stringLength = (str) -> str.length();

		System.out.println("String length of \"Test string\" is :: "
				+ stringLength.getLength("Test string"));

		System.out.println("Addition :: " + stringLength.sum(50, 50));

		Stream.of(StringLength.stringToArray("want to split string by space"))
				.forEach(strValue -> System.out.print(strValue + " "));
	}
}

interface StringLength {
	int getLength(String string);

	default int sum(int a, int b) {
		return a + b;
	}

	static String[] stringToArray(String str) {
		return str.split(" ");
	}
}
