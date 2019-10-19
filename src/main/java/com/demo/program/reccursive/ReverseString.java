package com.demo.program.reccursive;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println("Reverse String : " + reverseString("Reverse"));
	}
	
	public static String reverseString(String str) {
		return (str.isEmpty()) ? str : reverseString(str.substring(1)) + str.charAt(0);
	}
}
