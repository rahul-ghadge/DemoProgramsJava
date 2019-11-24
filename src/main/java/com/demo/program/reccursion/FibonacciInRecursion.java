package com.demo.program.reccursion;

public class FibonacciInRecursion {

	public static void main(String[] args) {
		int num = 10;
		
		for (int i = 0; i < num; i++) {
			System.out.println((i + 1) + "'th Fabonacci No : " + fibonacci(i));
		}
	}
	
	/*
	 * Calculate fabonacci at index
	 */
	static int fibonacci(int n) {
		if (n == 0) 
			return 0;		
		else if (n <= 2)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
