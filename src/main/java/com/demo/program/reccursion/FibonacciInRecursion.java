package com.demo.program.reccursion;

public class FibonacciInRecursion {

	public static void main(String[] args) {
		int num = 10;
		System.out.println(num + "'th Fabonacci No : " + fibonacci(num));
	}
	
	/*
	 * Calculate fabonacci at index
	 */
	static int fibonacci(int n) {
		if (n <= 1)
			return n;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
