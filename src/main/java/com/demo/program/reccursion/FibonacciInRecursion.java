package com.demo.program.reccursion;

import java.util.Scanner;

public class FibonacciInRecursion {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Enter the number for the fibonacci sequence");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			System.out.println((i + 1) + "'the Fibonacci No : " + fibonacci(i));
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
