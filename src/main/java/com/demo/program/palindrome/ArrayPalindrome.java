package com.demo.program.palindrome;

public class ArrayPalindrome {
	
	public static void main(String s[]) {
		
		int[] input1 = { 6, 7, 8, 7, 6 };
		int[] input2 = { 6, 7, 8, 9, 10 };
		int[] input3 = { 88, 34, 145, 145, 34, 88 };
		int[] input4 = { 88, 34, 145, 34, 88 };

		System.out.println("The array 1 is palindrome : " + isArrayPalindrome(input1));
		System.out.println("The array 2 is palindrome : " + isArrayPalindrome(input2));
		System.out.println("The array 3 is palindrome : " + isArrayPalindrome(input3));
		System.out.println("The array 4 is palindrome : " + isArrayPalindrome(input4));

	}

	public static boolean isArrayPalindrome(int[] input) {

		int start = 0;
		int end = input.length - 1;
		while (start <= end) {
			if (start == end)
				return true;

			if (input[start] != input[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
