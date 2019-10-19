package com.demo.program.reccursive;

public class FactorialReccursive {

    public static void main(String[] args) {
        System.out.println(fact(4));
        System.out.println(factOptimized(5));
        System.out.println(factorial(4));
    }


    public static int fact(int n) {
        if (n == 0)
            return 1;
        else
            return (n * fact(n - 1)); // tail recursion
    }
    
    public static int factOptimized(int n) {
		return n == 1 ? n  : n * fact(n - 1); // tail recurrsion
	}
	
	public static int factorial(int n, int a) {
		return n == 0 ? a : factorial(n - 1, n * a);
	}
}
